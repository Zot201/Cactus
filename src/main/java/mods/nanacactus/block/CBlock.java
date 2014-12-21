package mods.nanacactus.block;

import java.util.List;

import mods.nanacactus.Models;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.IStringSerializable;

import com.google.common.base.Optional;

@Models({"cactus_block", "ceramic_block", "receramic_block", "cactusium_block"})
public class CBlock extends Block
{
    public static final String[] blockTypes = CBlock.class.getAnnotation(Models.class).value();
    private static Optional<PropertyEnum> variant = Optional.absent();
    private IIcon[] BlockIcons;

    public CBlock()
    {
        super(Material.iron);
    }

    // getIcon
    public IIcon func_149691_a(int side, int meta)
    {
        if (meta <= blockTypes.length && BlockIcons[meta] != null)
        {
            return BlockIcons[meta];
        }

        return null;
    }

    // damageDropped
    public int func_149692_a(int meta)
    {
        return meta;
    }

    @SuppressWarnings("unchecked")
    @Override public void getSubBlocks(Item item, CreativeTabs creativetabs, @SuppressWarnings("rawtypes") List list)
    {
        for (int meta = 0; meta < blockTypes.length; ++meta)
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    // registerBlockIcons
    public void func_149651_a(IIconRegister iconregister)
    {
        this.BlockIcons = new IIcon[blockTypes.length];

        for (int meta = 0; meta < this.BlockIcons.length; ++meta)
        {
            String s = "nanacactus:";

            if (blockTypes[meta] != null)
            {
                s = s + blockTypes[meta];
            }

            BlockIcons[meta] = iconregister.func_94245_a(s);
        }
    }

    @Override public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(variant.get(), Variant.valueOf(meta));
    }

    @Override public int getMetaFromState(IBlockState state)
    {
        return Variant.get(variant.get(), state).ordinal();
    }

    @Override protected BlockState createBlockState()
    {
        if (!variant.isPresent()) variant = Optional.of(PropertyEnum.create("variant", Variant.class));
        return new BlockState(this, variant.get());
    }

    public enum Variant implements IStringSerializable
    {
        cactus, ceramic, receramic, cactusium;

        @Override public String getName()
        {
            return name();
        }

        public static Variant get(PropertyEnum variant, IBlockState state)
        {
            return (Variant) state.getValue(variant);
        }

        public static Variant valueOf(int meta)
        {
            return values()[meta < 0 || meta >= values().length ? 0 : meta];
        }
    }
}
