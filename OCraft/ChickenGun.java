package OCraft;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: mlc
 * Date: 9/20/13
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChickenGun extends Item {
    int entityId = 93;
    public ChickenGun(int i)
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
        if (par3World.isRemote)
        {
            return true;
        }
        else
        {
            int i1 = par3World.getBlockId(x, y, z);
            x += Facing.offsetsXForSide[par7];
            y += Facing.offsetsYForSide[par7];
            z += Facing.offsetsZForSide[par7];
            double d0 = 0.0D;

            if (par7 == 1 && Block.blocksList[i1] != null && Block.blocksList[i1].getRenderType() == 11)
            {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(par3World, entityId, (double)x + 0.5D, (double)y + d0, (double)z + 0.5D);

            if (entity != null)
            {
                entity.motionY = 1;
                float fltYaw = par2EntityPlayer.rotationYaw;
                FMLLog.info("Yaw" + fltYaw, fltYaw);
                if(fltYaw >315 || fltYaw <= 45 ){
                    entity.motionZ = 1;
                }
                if(fltYaw >45 && fltYaw <= 135){
                    entity.motionX = -1;
                }
                if(fltYaw >135 && fltYaw <= 225){
                    entity.motionZ = -1;
                }
                if(fltYaw >225 && fltYaw <= 315){
                    entity.motionX = 1;
                }

                if (entity instanceof EntityLivingBase && par1ItemStack.hasDisplayName())
                {
                    ((EntityLiving)entity).setCustomNameTag(par1ItemStack.getDisplayName());
                }

                if (!par2EntityPlayer.capabilities.isCreativeMode)
                {
                    --par1ItemStack.stackSize;
                }
            }

            return true;
        }
    }
    public static Entity spawnCreature(World par0World, int par1, double par2, double par4, double par6)
    {
       /* if (!EntityList.entityEggs.containsKey(Integer.valueOf(par1)))
        {
            return null;
        }
        else
        {  */
            Entity entity = null;

            for (int j = 0; j < 1; ++j)
            {
                entity = EntityList.createEntityByID(par1, par0World);

                if (entity != null && entity instanceof EntityLivingBase)
                {
                    EntityLiving entityliving = (EntityLiving)entity;
                    entity.setLocationAndAngles(par2, par4, par6, MathHelper.wrapAngleTo180_float(par0World.rand.nextFloat() * 360.0F), 0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onSpawnWithEgg((EntityLivingData)null);
                    par0World.spawnEntityInWorld(entity);
                    entityliving.playLivingSound();
                }
            }

            return entity;
        //}
    }
}
