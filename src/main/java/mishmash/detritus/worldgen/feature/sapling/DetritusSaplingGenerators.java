package mishmash.detritus.worldgen.feature.sapling;

import mishmash.detritus.DetritusMod;
import mishmash.detritus.worldgen.feature.DetritusFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class DetritusSaplingGenerators {
    public static final SaplingGenerator MNEMORA = new SaplingGenerator(
            DetritusMod.MOD_ID + ":mnemora",
            Optional.empty(),
            Optional.of(DetritusFeatures.MNEMORA_GROWTH_KEY),
            Optional.empty()
    );
}
