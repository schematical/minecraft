package OCraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.BaseMod;
import java.util.Random;
import net.minecraft.item.*;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod.*;

@Mod(modid="OwensMod", name="OwensMod",version="0,0,0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

/**
 * Created with IntelliJ IDEA.
 * User: mlc
 * Date: 9/20/13
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */

public class OwensMod extends BaseMod {

    @Instance("OwensMod")
    public static OwensMod instance;
    @SidedProxy(clientSide="OCraft.OProxy",serverSide = "OCraft.OServer")
    public static OProxy proxy;
    public static final  net.minecraft.item.Item ChickenGun = new ChickenGun(2108).setUnlocalizedName("ChickenGun").setTextureName("OwensMod:cheese_ray").setCreativeTab(CreativeTabs.tabCombat);
    public static final  net.minecraft.item.Item CheeseRay = new CheeseRay(2107).setUnlocalizedName("CheeseRay").setTextureName("OwensMod:cheese_ray").setCreativeTab(CreativeTabs.tabCombat);

    public static final  net.minecraft.item.Item CheeseItem = new CheeseObject(2085).setUnlocalizedName("Cheese Slice").setCreativeTab(CreativeTabs.tabMaterials);

    public static final Block CheeseBlock = new CheeseBlock(500).setCreativeTab(CreativeTabs.tabBlock).setHardness(5F).setResistance(6F).setStepSound(Block.soundSnowFootstep);//.getIndirectPowerOutput("Cheese");
    public static final Block OTNT = new OTNT(191).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("sponge").setTextureName("sponge");
    @EventHandler
    public void preInit(FMLInitializationEvent event){

    }
    public void load()
    {

    }
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderes();
        GameRegistry.registerBlock(CheeseBlock);
        LanguageRegistry.addName(CheeseBlock, "Cheese");

        ItemStack cheeseStack = new ItemStack(OwensMod.CheeseBlock, 2);
        GameRegistry.addShapelessRecipe(
                new ItemStack( net.minecraft.item.Item.diamond, 64),
                cheeseStack
        );
        MinecraftForge.setBlockHarvestLevel(
                CheeseBlock,
                "shovel",
                1
        );

        ModLoader.registerBlock(OTNT);
        ModLoader.addName(OTNT, "C4");

        MinecraftForge.setBlockHarvestLevel(
                OTNT,
                "shovel",
                1
        );

    }

    @EventHandler
    public void postInit(FMLInitializationEvent event){

    }
    public String getVersion()
    {
        return "1.5/1.5.1";
    }


    public void generateSurface(World world, Random random, int chunkX, int chunkZ)
    {
        Random randomGenerator = random;

        for (int i = 0; i < 10; i++)
        {
            int randPosX = chunkX + randomGenerator.nextInt(20);
            int randPosY = random.nextInt(40);
            int randPosZ = chunkZ + randomGenerator.nextInt(20);
            (new WorldGenMinable(CheeseBlock.blockID, 8)).generate(world, random, randPosX, randPosY, randPosZ);
        }
    }


}
