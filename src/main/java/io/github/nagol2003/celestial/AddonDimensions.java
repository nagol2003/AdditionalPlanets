package io.github.nagol2003.celestial;

import io.github.nagol2003.AddonConfig;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;

public class AddonDimensions {

    public static DimensionType dimPolulos;
    public static DimensionType dimOgnious;
    public static DimensionType dimVulcan;
    public static DimensionType dimj1407b;
    public static DimensionType dimkoi4878b;

    public static void init() {

        AddonDimensions.dimPolulos = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idPolulos);
        AddonDimensions.dimOgnious = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idOgnious);
        AddonDimensions.dimVulcan = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idVulcan);
        AddonDimensions.dimj1407b = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idj1407b);
        AddonDimensions.dimkoi4878b = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idkoi4878b);

    }
}
