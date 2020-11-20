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
    public static DimensionType dimZakir;
    public static DimensionType dimKepler452b;
    public static DimensionType dimAlphaCentauriB;
    public static DimensionType dimDark;
    public static DimensionType dimUnknown;
    public static DimensionType dimMother;
    public static DimensionType dimVermon;
    public static DimensionType dimDenia;
    public static DimensionType dimShayan;
    public static DimensionType dimQueran;
    public static DimensionType dimBarbanI;
    public static DimensionType dimBarbanII;
    public static DimensionType dimBarbanIII;
    public static DimensionType dimTerrin;

    public static void init() {

        AddonDimensions.dimPolulos = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idPolulos);
        AddonDimensions.dimOgnious = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idOgnious);
        AddonDimensions.dimVulcan = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idVulcan);
        AddonDimensions.dimj1407b = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idj1407b);
        AddonDimensions.dimkoi4878b = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idkoi4878b);
        AddonDimensions.dimZakir = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idZakir);
        AddonDimensions.dimKepler452b = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idKepler452b);
        AddonDimensions.dimAlphaCentauriB = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idAlphaCentauriB);
        AddonDimensions.dimDark = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idDark);
        AddonDimensions.dimUnknown = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idUnknown);
        AddonDimensions.dimMother = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idMother);
        AddonDimensions.dimVermon = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idVermon);
        AddonDimensions.dimDenia = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idDenia);
        AddonDimensions.dimShayan = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idShayan);
        AddonDimensions.dimQueran = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idQueran);
        AddonDimensions.dimBarbanI = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idBarbanI);
        AddonDimensions.dimBarbanII = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idBarbanII);
        AddonDimensions.dimBarbanIII = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idBarbanIII);
        AddonDimensions.dimTerrin = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idTerrin);

    }
}
