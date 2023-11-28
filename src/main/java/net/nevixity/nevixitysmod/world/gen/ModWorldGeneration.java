package net.nevixity.nevixitysmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGeneration() {
        ModOreGeneration.generateOres();
        ModEntitySpawns.addSpawns();
    }
}
