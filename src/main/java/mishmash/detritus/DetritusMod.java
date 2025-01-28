package mishmash.detritus;

import mishmash.detritus.block.DetritusBlocks;
import mishmash.detritus.worldgen.density_function.DetritusDensityFunctions;
import net.fabricmc.api.ModInitializer;

public class DetritusMod implements ModInitializer {

    public static final String MOD_ID = "detritus";

    @Override
    public void onInitialize() {
        DetritusBlocks.initialize();
        DetritusDensityFunctions.initialize();
    }
}
