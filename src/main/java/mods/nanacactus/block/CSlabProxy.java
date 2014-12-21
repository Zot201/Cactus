package mods.nanacactus.block;

import java.util.concurrent.Semaphore;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public abstract class CSlabProxy extends BlockSlab
{
    private static final Semaphore semaphore = new Semaphore(1);
    private static boolean isDoubleTemp;
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", Variant.class);
    private Boolean isDouble;

    CSlabProxy(boolean isDouble, Material material)
    {
        super(acquirePermit(isDouble, material));
        this.isDouble = isDouble;
        semaphore.release();
    }

    private static Material acquirePermit(boolean isDouble, Material material)
    {
        semaphore.acquireUninterruptibly();
        isDoubleTemp = isDouble;
        return material;
    }

    @Override public boolean isDouble()
    {
        return isDouble != null ? isDouble : isDoubleTemp;
    }

    @Override public IProperty getVariantProperty()
    {
        return VARIANT;
    }

    @Override public Object getVariant(ItemStack stack)
    {
        return Variant.cactus;
    }

    @Override public IBlockState getStateFromMeta(int meta)
    {
        return isDouble() ? getDefaultState() : getDefaultState().withProperty(
                HALF, meta == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
    }

    @Override public int getMetaFromState(IBlockState state)
    {
        return !isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP ? 8 : 0;
    }

    @Override protected BlockState createBlockState()
    {
        return isDouble() ? new BlockState(this, VARIANT) : new BlockState(this, VARIANT, HALF);
    }

    @Override public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing,
            float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return isDouble() ? getStateFromMeta(meta) : super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
    }

    public enum Variant implements IStringSerializable
    {
        cactus;

        @Override public String getName()
        {
            return name();
        }
    }
}
