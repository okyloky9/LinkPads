package me.okyloky9.portals.blocks;

import me.okyloky9.portals.events.Events;
import me.okyloky9.portals.items.ItemLinker;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "portals", name = "Portals", version = "0.1")
public class Portals {
	
	public static String MODID = "portals";
	public static Block blockLinkpad;
	public static Item itemLinker = new ItemLinker();
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Block & Item Registry
		GameRegistry.registerBlock(blockLinkpad = new BlockPortal("blockLinkpad", Material.iron), "blockLinkpad");
		GameRegistry.registerItem(itemLinker, "itemLinker");
		//Crafting Registry
		GameRegistry.addShapedRecipe(new ItemStack(itemLinker), new Object[]{"g g",
																			 "dgd",
																			 " g ", 'g', Items.gold_ingot, 'd', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(blockLinkpad,2),new Object[]{"eee",
																			  "eoe",
																			  "eee", 'e', Items.ender_eye, 'o', Blocks.obsidian});
	}
	@EventHandler
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new Events());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
