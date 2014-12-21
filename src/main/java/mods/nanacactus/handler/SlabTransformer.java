package mods.nanacactus.handler;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class SlabTransformer implements IClassTransformer
{
    @Override public byte[] transform(String name, String transformedName, byte[] classBytes)
    {
        if (transformedName.equals("mods.nanacactus.block.CSlab"))
            classBytes = transformSuper(classBytes, "net/minecraft/block/BlockSlab");
        else if (transformedName.equals("mods.nanacactus.item.ItemCSlab"))
            classBytes = transformSuper(classBytes, "net/minecraft/item/ItemSlab");

        return classBytes;
    }

    private byte[] transformSuper(byte[] classBytes, String superName)
    {
        ClassNode classNode = new ClassNode();
        new ClassReader(classBytes).accept(classNode, 0);

        String original = classNode.superName;
        classNode.superName = superName;

        for (MethodNode methodNode : classNode.methods)
            for (AbstractInsnNode insnNode : methodNode.instructions.toArray())
                if (insnNode instanceof MethodInsnNode)
                {
                    MethodInsnNode min = (MethodInsnNode) insnNode;
                    if (min.owner.equals(original))
                        min.owner = classNode.superName;
                }

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        classNode.accept(cw);
        return cw.toByteArray();
    }
}
