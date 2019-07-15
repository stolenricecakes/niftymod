package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
//    public static final String MODID = "examplemod";
    public static final String MODID = "niftymod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(this);
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
    
    @SubscribeEvent
    public void fartyArrows(ArrowLooseEvent event) {
        System.out.println("arrow loosed.");	
        //event.getEntityPlayer().playSound(soundCreator.createGassySound(), 100f, 50f);
        World world = event.getWorld();
        world.playSound(event.getEntityPlayer(), event.getEntityPlayer().getPosition(), GassySoundEventCreator.GASSY, SoundCategory.MASTER,  1.0f, 1.0f);
        System.out.println("played the gassy arrow.");	
    }
}
