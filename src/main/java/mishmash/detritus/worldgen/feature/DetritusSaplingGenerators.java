package mishmash.detritus.worldgen.feature;

import mishmash.detritus.DetritusMod;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class DetritusSaplingGenerators {
    public static final SaplingGenerator OSSIFIED = new SaplingGenerator(
            DetritusMod.MOD_ID + ":ossified",
            Optional.empty(),
            Optional.of(DetritusFeatures.OSSIFIED_TREE_KEY),
            Optional.empty()
    );
}
