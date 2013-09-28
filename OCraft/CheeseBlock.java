package OCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import scala.util.Random;
import net.minecraft.client.renderer.texture.IconRegister;

public class CheeseBlock extends Block{


        public CheeseBlock(int par1)
        {
            super(par1, Material.rock);
            /*this.setCreativeTab(CreativeTabs.tabBlock);
            this.setUnlocalizedName("Cheese Block");
            setTextureName("dirt");
*/
        }

          @Override
          @SideOnly(Side.CLIENT)
          public void registerIcons(IconRegister iconReg){
              this.blockIcon = iconReg.registerIcon("OwensMod:cheese_block");
          }
      /*  public int idDropped(int i, Random random, int j)
        {
            return OwensMod.CheeseBlock.blockID;
        }
        public int quantityDropped(Random random)
        {
            return 1;
        }
*/
    }


