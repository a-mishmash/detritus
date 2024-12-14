package com.github.mishmash.detritus.density_function;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;

public record DoubleRidge(DensityFunction densityFunction) implements DensityFunctionTypes.Unary {

    private static final MapCodec<DoubleRidge> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(DensityFunction.FUNCTION_CODEC.fieldOf("input").forGetter(DoubleRidge::densityFunction))
                    .apply(instance, (DoubleRidge::new)));
    public static final CodecHolder<DoubleRidge> CODEC = DensityFunctionTypes.holderOf(MAP_CODEC);

    @Override
    public DensityFunction input() {
        return this.densityFunction;
    }

    @Override
    public double apply(double density) {
        return 0.1 / (1 + Math.pow(2.7, -0.2 * Math.pow((density - 1.4), 15.0))) + 0.1;
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
