package mishmash.detritus.worldgen.density_function;

import mishmash.detritus.DetritusMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DetritusDensityFunctions {

    public static void initialize() {
        Registry.register(Registries.DENSITY_FUNCTION_TYPE, Identifier.of(DetritusMod.MOD_ID,"double_ridge"), DoubleRidge.CODEC.codec());
    }
}
