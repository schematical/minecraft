package OCraft;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mlc
 * Date: 9/20/13
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class CheeseRay extends Item {
    public CheeseRay(int i)
    {
        super(i);
        maxStackSize = 64;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg){
        this.itemIcon = iconReg.registerIcon("OwensMod:cheese_ray");
    }
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        int dY = 0;
        int dX = 0;
        int dZ = 0;
        float fltYaw = par2EntityPlayer.rotationYaw;
        FMLLog.info("Yaw" + fltYaw, fltYaw);
        if(fltYaw >315 || fltYaw <= 45 ){
            dZ = 1;
        }
        if(fltYaw >45 && fltYaw <= 135){
            dX = -1;
        }
        if(fltYaw >135 && fltYaw <= 225){
            dZ = -1;
        }
        if(fltYaw >225 && fltYaw <= 315){
            dX = 1;
        }




         if (par7 == 0)
        {
            --y;
        }

        if (par7 == 1)
        {
            ++y ;
        }

        if (par7 == 2)
        {
            --z;
        }

        if (par7 == 3)
        {
            ++z;
        }

        if (par7 == 4)
        {
            --x;
        }

        if (par7 == 5)
        {
            ++x;
        }

        if (!par2EntityPlayer.canPlayerEdit(x, y, z, par7, par1ItemStack))
        {
            return false;
        }
        else
        {

            /*if (par3World.isAirBlock(x, y, z))
            {*/
                par3World.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);

                for(int i = 0; i < 10; i++){

                    par3World.setBlock(
                            x + (dX * i),
                            y + (dY * i),
                            z + (dZ * i),
                            Block.fire.blockID
                    );
                   /* x = x + dX;
                    y = y + dY;
                    z = z + dZ;
                    par3World.setBlock(x, y, z, Block.fire.blockID);*/
                }
            //}

            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        }
    }
}
