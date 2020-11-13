package io.github.nagol2003.celestial;

import io.github.nagol2003.AddonConfig;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;

public class AddonDimensions {

    public static DimensionType dimPolulos;
    public static DimensionType dimOgnious;

    public static void init() {

        AddonDimensions.dimPolulos = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idPolulos);
        AddonDimensions.dimOgnious = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idOgnious);

    }
}
