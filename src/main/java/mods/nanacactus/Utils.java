package mods.nanacactus;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.Type;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.reflect.Invokable;

public class Utils {

	public static RuntimeException propagate(Throwable t) {
		return propagateWhatever(checkNotNull(t)); // sneaky throw
	}

	@SuppressWarnings("unchecked")
	private static <T extends Throwable> T propagateWhatever(Throwable t) throws T {
		throw (T) t;
	}



	public static class Dynamic {
		
		public static <T> Chainable<T> from(final T obj) {
			return new Chainable<T>() { public T get() {
				return obj;
			}};
		}
		
		public static <T> Refer<T> refer(Class<?> clz, String field) {
			return new Refer<T>(Klas.ofClass(clz), NullSupplier.INSTANCE, field);
		}
		public static <T> Refer<T> refer(String clz, String field) {
			return new Refer<T>(Klas.ofName(clz), NullSupplier.INSTANCE, field);
		}
		
		public static <U> Invoke<U> invoke(Class<?> clz, String method) {
			return new Invoke<U>(Klas.ofClass(clz), NullSupplier.INSTANCE, method);
		}
		public static <U> Invoke<U> invoke(String clz, String method) {
			return new Invoke<U>(Klas.ofName(clz), NullSupplier.INSTANCE, method);
		}
		
		public static <T> Construct<T> construct(Class<? extends T> clz) {
			return new Construct<T>(Klas.ofClass(clz));
		}
		public static <T> Construct<T> construct(final String clz) {
			return new Construct<T>(Klas.<T>ofName(clz));
		}
		
		
		
		private static class TypedArg<T> {
			final Klas<T> type;
			final T arg;
			
			private TypedArg(Klas<T> type, T arg) {
				this.type = type;
				this.arg = arg;
			}
			
			@SuppressWarnings({"unchecked", "rawtypes"})
			public static TypedArg<?> of(Object obj) {
				return new TypedArg(Klas.ofClass(obj.getClass()), obj);
			}
		}
		
		public static abstract class Chainable<T> implements Supplier<T> {
			private Chainable() { }
			
			public <U> Refer<U> refer(String field) {
				return new Refer<U>(null, this, field);
			}
			public <U> Refer<U> refer(Class<?> clz, String field) {
				return new Refer<U>(Klas.ofClass(clz), this, field);
			}
			public <U> Refer<U> refer(String clz, String field) {
				return new Refer<U>(Klas.ofName(clz), this, field);
			}
			public <U> Invoke<U> invoke(String method) {
				return new Invoke<U>(null, this, method);
			}
			public <U> Invoke<U> invoke(Class<?> clz, String method) {
				return new Invoke<U>(Klas.ofClass(clz), this, method);
			}
			public <U> Invoke<U> invoke(String clz, String method) {
				return new Invoke<U>(Klas.ofName(clz), this, method);
			}
			
			public <U> Chainable<T> assign(final String field, final U value) {
				return new Chainable<T>() { public T get() {
					try {
						T ret = Chainable.this.get();
						ret.getClass().getField(field).set(ret, value);
						return ret;
					} catch (Throwable e) {
						throw propagate(e);
					}
				}};
			}
			public <U> Chainable<T> assign(final Class<?> clz, final String field, final U value) {
				return new Chainable<T>() { public T get() {
					try {
						T ret = Chainable.this.get();
						Field f = clz.getDeclaredField(field);
						f.setAccessible(true);
						f.set(ret, value);
						return ret;
					} catch (Throwable e) {
						throw propagate(e);
					}
				}};
			}
			
			public Chainable<T> call(final Invokable<T, ?> method, final Object... args) {
				return new Chainable<T>() { public T get() {
					try {
						T ret = Chainable.this.get();
						method.invoke(ret, args);
						return ret;
					} catch (Throwable e) {
						throw propagate(e);
					}
				}};
			}
		}

		public static abstract class Arguments<T, U extends Arguments<T, U>> extends Chainable<T> {
			protected final ImmutableList<Supplier<TypedArg<?>>> args;
			
			private Arguments(ImmutableList<Supplier<TypedArg<?>>> args) {
				this.args = args;
			}
			protected abstract U derive(ImmutableList<Supplier<TypedArg<?>>> args);
			
			protected <V> U viaArg(Supplier<TypedArg<?>> arg) {
				return derive(ImmutableList.<Supplier<TypedArg<?>>>builder()
						.addAll(args)
						.add(arg)
						.build());
			}
			
			protected <V> U viaKlas(final Klas<V> type, final Supplier<V> arg) {
				return viaArg(new Supplier<TypedArg<?>>() {public TypedArg<?> get() {
					return new TypedArg<V>(type, arg.get());
				}});
			}
			public <V> U via(Class<V> type, Supplier<V> arg) {
				return viaKlas(Klas.ofClass(type), arg);
			}
			public <V> U via(Class<V> type, V arg) {
				return via(type, Suppliers.ofInstance(arg));
			}
			public <V> U via(String type, Supplier<V> arg) {
				return viaKlas(Klas.<V>ofName(type), arg);
			}
			public <V> U via(String type, V arg) {
				return via(type, Suppliers.ofInstance(arg));
			}
			
			public <V> U via(final Supplier<V> arg) {
				return viaArg(new Supplier<TypedArg<?>>() { public TypedArg<?> get() {
					return TypedArg.of(arg.get());
				}});
			}
			public <V> U via(V arg) {
				return via(Suppliers.ofInstance(arg));
			}
			
			public U viaInt(final Supplier<Integer> arg) {
				return viaArg(new Supplier<TypedArg<?>>() { public TypedArg<?> get() {
					return new TypedArg<Integer>(Klas.INT, arg.get());
				}});
			}
			public U viaInt(int arg) {
				return viaInt(Suppliers.ofInstance(arg));
			}
			
			public U viaFloat(final Supplier<Float> arg) {
				return viaArg(new Supplier<TypedArg<?>>() { public TypedArg<?> get() {
					return new TypedArg<Float>(Klas.FLOAT, arg.get());
				}});
			}
			public U viaFloat(float arg) {
				return viaFloat(Suppliers.ofInstance(arg));
			}
			
			public U viaBoolean(final Supplier<Boolean> arg) {
				return viaArg(new Supplier<TypedArg<?>>() { public TypedArg<?> get() {
					return new TypedArg<Boolean>(Klas.BOOLEAN, arg.get());
				}});
			}
			public U viaBoolean(boolean arg) {
				return viaBoolean(Suppliers.ofInstance(arg));
			}

			@Override public <V> Refer<V> refer(String field) {
				return new Refer<V>(null, this, field);
			}
			@Override public <V> Invoke<V> invoke(String method) {
				return new Invoke<V>(null, this, method);
			}
		}
		
		public static class Refer<T> extends Chainable<T> {
			private final Klas<?> clz;
			private final Supplier<?> obj;
			private final String field;
			
			private Refer(Klas<?> clz, Supplier<?> obj, String field) {
				this.clz = clz;
				this.obj = obj;
				this.field = field;
			}
			
			@SuppressWarnings("unchecked")
			@Override public T get() {
				try {
					if (clz != null) {
						Field f = clz.toClass().getDeclaredField(field);
						f.setAccessible(true);
						return (T) f.get(obj.get());
					}
					
					Object o = obj.get();
					return (T) o.getClass().getField(field).get(o);
					
				} catch (Throwable e) {
					throw propagate(e);
				}
			}
		}
		
		public static class Invoke<T> extends Arguments<T, Invoke<T>> {
			private final Klas<?> clz;
			private final Supplier<?> obj;
			private final String method;
			
			private Invoke(Klas<?> clz, Supplier<?> obj, String method,
					ImmutableList<Supplier<TypedArg<?>>> args) {
				super(args);
				this.clz = clz;
				this.obj = obj;
				this.method = method;
			}
			private Invoke(Klas<?> clz, Supplier<?> obj, String method) {
				this(clz, obj, method, ImmutableList.<Supplier<TypedArg<?>>>of());
			}
			@Override protected Invoke<T> derive(ImmutableList<Supplier<TypedArg<?>>> args) {
				return new Invoke<T>(clz, obj, method, args);
			}
			
			@SuppressWarnings("unchecked")
			@Override public T get() {
				try {
					List<Class<?>> types = Lists.newArrayList();
					List<Object> args = Lists.newArrayList();
					
					for (Supplier<TypedArg<?>> supplier : this.args) {
						TypedArg<?> p = supplier.get();
						types.add(p.type.toClass());
						args.add(p.arg);
					}
					
					if (clz != null) {
						Method m = clz.toClass()
								.getDeclaredMethod(method, Iterables.toArray(types, Class.class));
						m.setAccessible(true);
						return (T) m.invoke(obj.get(), args.toArray());
					}
					
					Object o = obj.get();
					return (T) o.getClass()
							.getMethod(method, Iterables.toArray(types, Class.class))
							.invoke(o, args.toArray());
					
				} catch (Throwable e) {
					throw propagate(e);
				}
			}
		}
		
		public static class Construct<T> extends Arguments<T, Construct<T>> {
			private final Klas<? extends T> clz;
			
			private Construct(Klas<? extends T> clz, ImmutableList<Supplier<TypedArg<?>>> args) {
				super(args);
				this.clz = clz;
			}
			private Construct(Klas<? extends T> clz) {
				this(clz, ImmutableList.<Supplier<TypedArg<?>>>of());
			}
			@Override protected Construct<T> derive(ImmutableList<Supplier<TypedArg<?>>> args) {
				return new Construct<T>(clz, args);
			}
			
			@Override public T get() {
				try {
					List<Class<?>> types = Lists.newArrayList();
					List<Object> args = Lists.newArrayList();
					
					for (Supplier<TypedArg<?>> supplier : this.args) {
						TypedArg<?> p = supplier.get();
						types.add(p.type.toClass());
						args.add(p.arg);
					}
					
					Constructor<? extends T> c = clz.toClass()
							.getDeclaredConstructor(Iterables.toArray(types, Class.class));
					c.setAccessible(true);
					return c.newInstance(args.toArray());
					
				} catch (Throwable e) {
					throw propagate(e);
				}
			}
		}
		
		
		private enum NullSupplier implements Supplier<Object> {
			INSTANCE;
			@Override public Object get() { return null; }
		}
		
	}
	
	
	
	@SuppressWarnings("unused")
	private static abstract class Klas<T> implements Supplier<Class<T>> {
		
		public static final Klas<Byte> BYTE = PrimitiveKlas.of(byte.class, "B");
		public static final Klas<Character> CHAR = PrimitiveKlas.of(char.class, "C");
		public static final Klas<Double> DOUBLE = PrimitiveKlas.of(double.class, "D");
		public static final Klas<Float> FLOAT = PrimitiveKlas.of(float.class, "F");
		public static final Klas<Integer> INT = PrimitiveKlas.of(int.class, "I");
		public static final Klas<Long> LONG = PrimitiveKlas.of(long.class, "J");
		public static final Klas<Short> SHORT = PrimitiveKlas.of(short.class, "S");
		public static final Klas<Void> VOID = PrimitiveKlas.of(void.class, "V");
		public static final Klas<Boolean> BOOLEAN = PrimitiveKlas.of(boolean.class, "Z");
		
		
		private Klas() { }
		
		public abstract Class<T> toClass();
		@Deprecated @Override public Class<T> get() {
			return toClass();
		}
		
		public abstract String toName();
		
		public abstract String toDescriptor();
		
		public Type toType() {
			return Type.getType(toDescriptor());
		}
		
		
		@Override public int hashCode() {
			return toName().hashCode();
		}
		
		@Override public boolean equals(Object obj) {
			if (obj == this)
				return true;
			if (obj instanceof Klas)
				return ((Klas<?>) obj).toName().equals(toName());
			
			return false;
		}
		
		@Override public String toString() {
			return getClass().getSimpleName() + " " + toName();
		}
		
		
		
		
		public static class PrimitiveKlas<T> extends Klas<T> {
			private static final Map<String, Klas<?>>
			FROM_NAME = Maps.newHashMap(), FROM_DESC = Maps.newHashMap();
			
			private final Class<T> clz;
			private final String name, desc;
			private PrimitiveKlas(Class<T> clz, String desc) {
				this.clz = clz;
				this.name = clz.getName();
				this.desc = desc;
				
				FROM_NAME.put(name, this);
				FROM_DESC.put(desc, this);
			}
			private static <T> PrimitiveKlas<T> of(Class<T> clz, String desc) {
				return new PrimitiveKlas<T>(clz, desc);
			}
			
			@Override public Class<T> toClass() {
				return clz;
			}
			@Override public String toName() {
				return name;
			}
			@Override public String toDescriptor() {
				return desc;
			}
		}
		
		public static class ObjectKlas<T> extends Klas<T> {
			private final String name;
			private ObjectKlas(String name) {
				this.name = name;
			}
			private ObjectKlas(Class<T> clz) {
				this(clz.getName());
				this.clz = clz;
			}
			
			private Class<T> clz;
			@SuppressWarnings("unchecked")
			@Override public Class<T> toClass() {
				if (clz != null)
					return clz;
				
				try {
					return clz = (Class<T>) Class.forName(name);
				} catch (Throwable e) {
					throw propagate(e);
				}
			}
			@Override public String toName() {
				return name;
			}
			@Override public String toDescriptor() {
				return "L" + toName().replace('.', '/') + ";";
			}
		}
		
		public static class ArrayKlas<T> extends Klas<T> {
			private final String name;
			private final Klas<?> component;
			private final int nDimensions;
			private ArrayKlas(String name, Klas<?> component, int nDimensions) {
				this.name = name;
				this.component = component;
				this.nDimensions = nDimensions;
			}
			private ArrayKlas(Class<T> clz) {
				this(clz.getName(), null, -1);
				this.clz = clz;
			}
			
			private Class<T> clz;
			@SuppressWarnings("unchecked")
			@Override public Class<T> toClass() {
				if (clz != null)
					return clz;
				
				return clz = (Class<T>) Array
						.newInstance(component.toClass(), new int[nDimensions])
						.getClass();
			}
			@Override public String toName() {
				return name;
			}
			@Override public String toDescriptor() {
				return toName().replace('.', '/');
			}
		}
		
		
		public static <T> Klas<T> ofClass(Class<T> clz) {
			@SuppressWarnings("unchecked")
			Klas<T> primitive = (Klas<T>) PrimitiveKlas.FROM_NAME.get(clz.getName());
			if (primitive != null)
				return primitive;
			
			if (!clz.isArray())
				return new ObjectKlas<T>(clz);
			
			return new ArrayKlas<T>(clz);
		}
		
		private static <T> ArrayKlas<T> getArrayKlas(String desc) {
			int nDims = desc.lastIndexOf('[') + 1;
			if (nDims > 0) {
				for (int i = 0; i < nDims - 1; i++)
					if (desc.charAt(i) != '[')
						throw new IllegalArgumentException(desc);
				
				return new ArrayKlas<T>(
						desc.replace('/', '.'),
						ofDescriptor(desc.substring(nDims)),
						nDims);
			}
			
			return null;
		}
		
		public static <T> Klas<T> ofName(String name) {
			@SuppressWarnings("unchecked")
			Klas<T> primitive = (Klas<T>) PrimitiveKlas.FROM_NAME.get(name);
			if (primitive != null)
				return primitive;
			
			if (name.indexOf('/') >= 0)
				throw new IllegalArgumentException(name);
			
			Klas<T> array = getArrayKlas(name.replace('.', '/'));
			if (array != null)
				return array;
			
			return new ObjectKlas<T>(name);
		}
		
		public static <T> Klas<T> ofDescriptor(String desc) {
			@SuppressWarnings("unchecked")
			Klas<T> primitive = (Klas<T>) PrimitiveKlas.FROM_DESC.get(desc);
			if (primitive != null)
				return primitive;
			
			if (desc.indexOf('.') >= 0)
				throw new IllegalArgumentException(desc);
			
			Klas<T> array = getArrayKlas(desc);
			if (array != null)
				return array;
			
			return new ObjectKlas<T>(desc.substring(1, desc.length() - 1).replace('/', '.'));
		}
		
		public static <T> Klas<T> ofType(Type type) {
			return ofDescriptor(type.getDescriptor());
		}
		
	}

}
