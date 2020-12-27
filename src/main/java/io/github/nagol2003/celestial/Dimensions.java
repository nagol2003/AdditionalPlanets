package io.github.nagol2003.celestial;

import io.github.nagol2003.AddonConfig;
import io.github.nagol2003.celestial.planets.Polulos.station.WorldProviderPolulosOrbit;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;

public class Dimensions {

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
    public static DimensionType dimAmmon;
    public static DimensionType dimXareious;
    public static DimensionType dimErink;
    public static DimensionType dimJunsin;
    public static DimensionType dimChiona;
    public static DimensionType dimKeyian;
    public static DimensionType dimBlastopy;
    public static DimensionType dimThesiusOmega;
    
    public static DimensionType polulosOrbit;
    public static DimensionType polulosOrbit_static;

    public static void init() { 

        Dimensions.dimPolulos = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idPolulos);
        Dimensions.dimOgnious = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idOgnious);
        Dimensions.dimVulcan = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idVulcan);
        Dimensions.dimj1407b = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idj1407b);
        Dimensions.dimkoi4878b = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idkoi4878b);
        Dimensions.dimZakir = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idZakir);
        Dimensions.dimKepler452b = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idKepler452b);
        Dimensions.dimAlphaCentauriB = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idAlphaCentauriB);
        Dimensions.dimDark = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idDark);
        Dimensions.dimUnknown = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idUnknown);
        Dimensions.dimMother = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idMother);
        Dimensions.dimVermon = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idVermon);
        Dimensions.dimDenia = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idDenia);
        Dimensions.dimShayan = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idShayan);
        Dimensions.dimQueran = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idQueran);
        Dimensions.dimBarbanI = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idBarbanI);
        Dimensions.dimBarbanII = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idBarbanII);
        Dimensions.dimBarbanIII = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idBarbanIII);
        Dimensions.dimTerrin = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idTerrin);
        Dimensions.dimAmmon = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idAmmon);
        Dimensions.dimXareious = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idXareious);
        Dimensions.dimErink = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idErink);
        Dimensions.dimJunsin = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idJunsin);
        Dimensions.dimChiona = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idChiona);
        Dimensions.dimKeyian = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idKeyian);
        Dimensions.dimBlastopy = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idBlastopy);
        Dimensions.dimThesiusOmega = WorldUtil.getDimensionTypeById(AddonConfig.addon_dimension.idThesiusOmega);

    }
    
    public static void initSpaceStationDims() {
    	Dimensions.polulosOrbit = DimensionType.register("Polulos Space Station", "_polulos_orbit", AddonConfig.addon_spacestation_settings.polulosOrbitDimID, WorldProviderPolulosOrbit.class, false);
    	Dimensions.polulosOrbit_static = DimensionType.register("Polulos Space Station", "_polulos_orbit", AddonConfig.addon_spacestation_settings.polulosOrbitDimID_static, WorldProviderPolulosOrbit.class, true);
    	
    }
}
