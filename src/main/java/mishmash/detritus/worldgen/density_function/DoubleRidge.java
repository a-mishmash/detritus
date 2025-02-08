package mishmash.detritus.worldgen.density_function;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;

public record DoubleRidge(DensityFunction densityFunction) implements DensityFunction {

    private static final MapCodec<DoubleRidge> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(DensityFunction.FUNCTION_CODEC.fieldOf("input").forGetter(DoubleRidge::densityFunction))
                    .apply(instance, (DoubleRidge::new)));
    public static final CodecHolder<DoubleRidge> CODEC = new CodecHolder<>(MAP_CODEC);

    @Override
    public double sample(NoisePos pos) {
        return 0.1 / (1 + Math.pow(2.7, -0.2 * Math.pow((densityFunction.sample(pos) - 1.4), 81.0))) + 0.1;
    }

    @Override
    public void fill(double[] densities, EachApplier applier) {
        applier.fill(densities, this);
    }

    @Override
    public DensityFunction apply(DensityFunctionVisitor visitor) {
        return new DoubleRidge(this.densityFunction.apply(visitor));
    }

    @Override
    public double minValue() {
        return 0.0;
    }

    @Override
    public double maxValue() {
        return 1.0;
    }

    @Override
    public CodecHolder<? extends DensityFunction> getCodecHolder() {
        return CODEC;
    }
}
