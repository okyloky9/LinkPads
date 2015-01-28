package me.okyloky9.portals.items;

import me.okyloky9.portals.blocks.Portals;
import me.okyloky9.portals.events.Events;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLinker extends Item{
	
	public ItemLinker(){
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("itemLinker");
		setTextureName(Portals.MODID + ":itemLinker");
		setMaxStackSize(1);
		setMaxDamage(0);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player){
		if(is.getItem() == Portals.itemLinker){
			Events.link(player);
		}
		return is;
	}
	
}
