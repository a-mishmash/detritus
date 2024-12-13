package com.github.mishmash.detritus.density_function;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;

public record MultiNoiseRoute(DensityFunction routeFunctionA, DensityFunction routeFunctionB, DensityFunction routerFunction) implements DensityFunction {

    private static final MapCodec<MultiNoiseRoute> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(
                    DensityFunction.FUNCTION_CODEC.fieldOf("route_positive").forGetter(MultiNoiseRoute::routeFunctionA),
                    DensityFunction.FUNCTION_CODEC.fieldOf("route_negative").forGetter(MultiNoiseRoute::routeFunctionB),
                    DensityFunction.FUNCTION_CODEC.fieldOf("router").forGetter(MultiNoiseRoute::routerFunction)
                    ).apply(instance, (MultiNoiseRoute::new)));
    public static final CodecHolder<MultiNoiseRoute> CODEC = DensityFunctionTypes.holderOf(MAP_CODEC);

    @Override
    public double sample(NoisePos pos) {
        if (routerFunction.sample(pos) > 0) {
            return routeFunctionA.sample(pos);
        } else {
            return routeFunctionA.sample(pos);
        }
    }

    @Override
    public void fill(double[] densities, EachApplier applier) {
        applier.fill(densities, this);
    }

    @Override
    public DensityFunction apply(DensityFunctionVisitor visitor) {
        return new MultiNoiseRoute(this.routeFunctionA.apply(visitor), this.routeFunctionB.apply(visitor), this.routerFunction.apply(visitor));
    }

    @Override
    public double minValue() {
        return Math.min(routeFunctionA.minValue(), routeFunctionB.minValue());
    }

    @Override
    public double maxValue() {
        return Math.max(routeFunctionA.maxValue(), routeFunctionB.maxValue());
    }

    @Override
    public CodecHolder<? extends DensityFunction> getCodecHolder() {
        return CODEC;
    }
}
