package me.okyloky9.portals.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import me.okyloky9.portals.events.teleport.Teleporter;
import cpw.mods.fml.relauncher.SideOnly;
import me.okyloky9.portals.events.Events;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPortal extends Block {
	
	public BlockPortal(String unlocalizedName, Material material) {
		super(material);
		setCreativeTab(CreativeTabs.tabTransport);
		setBlockTextureName(Portals.MODID + ":blockLinkpad");
		setBlockName(unlocalizedName);
		setStepSound(soundTypeMetal);
		setLightLevel(0.4F);
		setHardness(2.0F);
		setResistance(20.0F);
	}
	
	@Override
	public int damageDropped (int metadata){
		return metadata;
	}
	
	@SideOnly(Side.CLIENT)
		private IIcon[][] icons = new IIcon[6][16];
	
	@Override
	public IIcon getIcon(int side, int meta) {
	    return icons[side][meta];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
		for (int i = 0; i < 16; ++i){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for (int i = 2; i < 6; i ++) {
			for (int j=0; j < 16; j ++){
				this.icons[i][j] = reg.registerIcon(this.textureName + "_0");
			}
	    }
		
		for (int j=0; j < 16; j ++){
			this.icons[0][j] = reg.registerIcon(this.textureName + "_0");
		}
		
		for (int j=0; j < 16; j ++){
			this.icons[1][j] = reg.registerIcon(this.textureName + "_top_" + j);
		}
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float PlayerX, float PlayerY, float PlayerZ)
    {
        Item item = player.getHeldItem().getItem();
        int mdata = player.getHeldItem().getItemDamageForDisplay();
        int i = item.getMetadata(item.getDamage(new ItemStack(item)));
        if (item instanceof ItemDye) {
            Events.check(player, new ItemStack(item), x, y, z, mdata);
        }
        return false;
    }
	
	/*@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity e){
		int tx = 260;
		int ty = 65;
		int tz = 0;
		
		if(e instanceof EntityPlayerMP){
			EntityPlayerMP player = (EntityPlayerMP) e;
			if(e.dimension != 0){
				Teleporter.transferPlayerToDimension(player, 0, player.mcServer.getConfigurationManager(), tx, ty, tz);
			}else{
				player.playerNetServerHandler.setPlayerLocation(tx, ty, tz, 90, 90);
			}
		}else{
			e.setPosition(tx, ty, tz);
		}
	}*/

}
