package me.okyloky9.portals.events;
import me.okyloky9.portals.blocks.Portals;
import me.okyloky9.portals.events.teleport.Teleporter;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Events {

	@SubscribeEvent
    public void onBlockPlace(BlockEvent.PlaceEvent event) {
		int portalx = event.x;
		int portaly = event.y;
		int portalz = event.z;
		Minecraft.getMinecraft().thePlayer.sendChatMessage("X:" + portalx +" Y:"+ portaly +" Z:"+ portalz);
    }
	
	public static void link(EntityPlayer player){
		int x = Minecraft.getMinecraft().objectMouseOver.blockX;
		int y = Minecraft.getMinecraft().objectMouseOver.blockY;
		int z = Minecraft.getMinecraft().objectMouseOver.blockZ;
		
		if(player.worldObj.getBlock(x, y, z) == Portals.blockLinkpad){
			Minecraft.getMinecraft().thePlayer.sendChatMessage("Portals linked!");
		}
	}
	
	public static void check(EntityPlayer player, ItemStack is, int x, int y, int z, int meta){
		player.worldObj.setBlockMetadataWithNotify(x, y, z, meta, 2);
	}
	
	/*public void onEntityWalking(World world, int x, int y, int z, Entity e){
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
	
	public void livingTick(LivingEvent.LivingUpdateEvent event){
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer player =  (EntityPlayer) event.entityLiving;
			Block block = player.worldObj.getBlock((int)player.posX, (int)player.posY-1, (int)player.posZ);
		}else{
			
		}
	}
	
}
