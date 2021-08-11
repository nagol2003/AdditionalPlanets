package io.github.nagol2003.client;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import com.google.common.primitives.UnsignedInts;
import com.google.gson.JsonObject;

import net.minecraft.util.JsonUtils;
import net.minecraft.util.math.MathHelper;

public class ColorRGB {
	private static final Map<String, ColorRGB>	NAMED_MAP				= new HashMap<>();
	private static final Pattern				PATTERN_LEADING_JUNK	= Pattern.compile("(#|0x)", Pattern.CASE_INSENSITIVE);
	private static final Pattern				PATTERN_HEX_CODE		= Pattern.compile("(#|0x)?[0-9a-f]{1,8}", Pattern.CASE_INSENSITIVE);

	public static final int VALUE_WHITE = 0xFFFFFF;

	// region CSS Colors
	public static final ColorRGB	ALICEBLUE				= named("AliceBlue", 0xF0F8FF);
	public static final ColorRGB	ANTIQUEWHITE			= named("AntiqueWhite", 0xFAEBD7);
	public static final ColorRGB	AQUA					= named("Aqua", 0x00FFFF);
	public static final ColorRGB	AQUAMARINE				= named("Aquamarine", 0x7FFFD4);
	public static final ColorRGB	AZURE					= named("Azure", 0xF0FFFF);
	public static final ColorRGB	BEIGE					= named("Beige", 0xF5F5DC);
	public static final ColorRGB	BISQUE					= named("Bisque", 0xFFE4C4);
	public static final ColorRGB	BLACK					= named("Black", 0x000000);
	public static final ColorRGB	BLANCHEDALMOND			= named("BlanchedAlmond", 0xFFEBCD);
	public static final ColorRGB	BLUE					= named("Blue", 0x0000FF);
	public static final ColorRGB	BLUEVIOLET				= named("BlueViolet", 0x8A2BE2);
	public static final ColorRGB	BROWN					= named("Brown", 0xA52A2A);
	public static final ColorRGB	BURLYWOOD				= named("BurlyWood", 0xDEB887);
	public static final ColorRGB	CADETBLUE				= named("CadetBlue", 0x5F9EA0);
	public static final ColorRGB	CHARTREUSE				= named("Chartreuse", 0x7FFF00);
	public static final ColorRGB	CHOCOLATE				= named("Chocolate", 0xD2691E);
	public static final ColorRGB	CORAL					= named("Coral", 0xFF7F50);
	public static final ColorRGB	CORNFLOWERBLUE			= named("CornflowerBlue", 0x6495ED);
	public static final ColorRGB	CORNSILK				= named("Cornsilk", 0xFFF8DC);
	public static final ColorRGB	CRIMSON					= named("Crimson", 0xDC143C);
	public static final ColorRGB	CYAN					= named("Cyan", 0x00FFFF);
	public static final ColorRGB	DARKBLUE				= named("DarkBlue", 0x00008B);
	public static final ColorRGB	DARKCYAN				= named("DarkCyan", 0x008B8B);
	public static final ColorRGB	DARKGOLDENROD			= named("DarkGoldenRod", 0xB8860B);
	public static final ColorRGB	DARKGRAY				= named("DarkGray", 0xA9A9A9);
	public static final ColorRGB	DARKGREY				= named("DarkGrey", 0xA9A9A9);
	public static final ColorRGB	DARKGREEN				= named("DarkGreen", 0x006400);
	public static final ColorRGB	DARKKHAKI				= named("DarkKhaki", 0xBDB76B);
	public static final ColorRGB	DARKMAGENTA				= named("DarkMagenta", 0x8B008B);
	public static final ColorRGB	DARKOLIVEGREEN			= named("DarkOliveGreen", 0x556B2F);
	public static final ColorRGB	DARKORANGE				= named("DarkOrange", 0xFF8C00);
	public static final ColorRGB	DARKORCHID				= named("DarkOrchid", 0x9932CC);
	public static final ColorRGB	DARKRED					= named("DarkRed", 0x8B0000);
	public static final ColorRGB	DARKSALMON				= named("DarkSalmon", 0xE9967A);
	public static final ColorRGB	DARKSEAGREEN			= named("DarkSeaGreen", 0x8FBC8F);
	public static final ColorRGB	DARKSLATEBLUE			= named("DarkSlateBlue", 0x483D8B);
	public static final ColorRGB	DARKSLATEGRAY			= named("DarkSlateGray", 0x2F4F4F);
	public static final ColorRGB	DARKSLATEGREY			= named("DarkSlateGrey", 0x2F4F4F);
	public static final ColorRGB	DARKTURQUOISE			= named("DarkTurquoise", 0x00CED1);
	public static final ColorRGB	DARKVIOLET				= named("DarkViolet", 0x9400D3);
	public static final ColorRGB	DEEPPINK				= named("DeepPink", 0xFF1493);
	public static final ColorRGB	DEEPSKYBLUE				= named("DeepSkyBlue", 0x00BFFF);
	public static final ColorRGB	DIMGRAY					= named("DimGray", 0x696969);
	public static final ColorRGB	DIMGREY					= named("DimGrey", 0x696969);
	public static final ColorRGB	DODGERBLUE				= named("DodgerBlue", 0x1E90FF);
	public static final ColorRGB	FIREBRICK				= named("FireBrick", 0xB22222);
	public static final ColorRGB	FLORALWHITE				= named("FloralWhite", 0xFFFAF0);
	public static final ColorRGB	FORESTGREEN				= named("ForestGreen", 0x228B22);
	public static final ColorRGB	FUCHSIA					= named("Fuchsia", 0xFF00FF);
	public static final ColorRGB	GAINSBORO				= named("Gainsboro", 0xDCDCDC);
	public static final ColorRGB	GHOSTWHITE				= named("GhostWhite", 0xF8F8FF);
	public static final ColorRGB	GOLD					= named("Gold", 0xFFD700);
	public static final ColorRGB	GOLDENROD				= named("GoldenRod", 0xDAA520);
	public static final ColorRGB	GRAY					= named("Gray", 0x808080);
	public static final ColorRGB	GREY					= named("Grey", 0x808080);
	public static final ColorRGB	GREEN					= named("Green", 0x008000);
	public static final ColorRGB	GREENYELLOW				= named("GreenYellow", 0xADFF2F);
	public static final ColorRGB	HONEYDEW				= named("HoneyDew", 0xF0FFF0);
	public static final ColorRGB	HOTPINK					= named("HotPink", 0xFF69B4);
	public static final ColorRGB	INDIANRED				= named("IndianRed", 0xCD5C5C);
	public static final ColorRGB	INDIGO					= named("Indigo", 0x4B0082);
	public static final ColorRGB	IVORY					= named("Ivory", 0xFFFFF0);
	public static final ColorRGB	KHAKI					= named("Khaki", 0xF0E68C);
	public static final ColorRGB	LAVENDER				= named("Lavender", 0xE6E6FA);
	public static final ColorRGB	LAVENDERBLUSH			= named("LavenderBlush", 0xFFF0F5);
	public static final ColorRGB	LAWNGREEN				= named("LawnGreen", 0x7CFC00);
	public static final ColorRGB	LEMONCHIFFON			= named("LemonChiffon", 0xFFFACD);
	public static final ColorRGB	LIGHTBLUE				= named("LightBlue", 0xADD8E6);
	public static final ColorRGB	LIGHTCORAL				= named("LightCoral", 0xF08080);
	public static final ColorRGB	LIGHTCYAN				= named("LightCyan", 0xE0FFFF);
	public static final ColorRGB	LIGHTGOLDENRODYELLOW	= named("LightGoldenRodYellow", 0xFAFAD2);
	public static final ColorRGB	LIGHTGRAY				= named("LightGray", 0xD3D3D3);
	public static final ColorRGB	LIGHTGREY				= named("LightGrey", 0xD3D3D3);
	public static final ColorRGB	LIGHTGREEN				= named("LightGreen", 0x90EE90);
	public static final ColorRGB	LIGHTPINK				= named("LightPink", 0xFFB6C1);
	public static final ColorRGB	LIGHTSALMON				= named("LightSalmon", 0xFFA07A);
	public static final ColorRGB	LIGHTSEAGREEN			= named("LightSeaGreen", 0x20B2AA);
	public static final ColorRGB	LIGHTSKYBLUE			= named("LightSkyBlue", 0x87CEFA);
	public static final ColorRGB	LIGHTSLATEGRAY			= named("LightSlateGray", 0x778899);
	public static final ColorRGB	LIGHTSLATEGREY			= named("LightSlateGrey", 0x778899);
	public static final ColorRGB	LIGHTSTEELBLUE			= named("LightSteelBlue", 0xB0C4DE);
	public static final ColorRGB	LIGHTYELLOW				= named("LightYellow", 0xFFFFE0);
	public static final ColorRGB	LIME					= named("Lime", 0x00FF00);
	public static final ColorRGB	LIMEGREEN				= named("LimeGreen", 0x32CD32);
	public static final ColorRGB	LINEN					= named("Linen", 0xFAF0E6);
	public static final ColorRGB	MAGENTA					= named("Magenta", 0xFF00FF);
	public static final ColorRGB	MAROON					= named("Maroon", 0x800000);
	public static final ColorRGB	MEDIUMAQUAMARINE		= named("MediumAquaMarine", 0x66CDAA);
	public static final ColorRGB	MEDIUMBLUE				= named("MediumBlue", 0x0000CD);
	public static final ColorRGB	MEDIUMORCHID			= named("MediumOrchid", 0xBA55D3);
	public static final ColorRGB	MEDIUMPURPLE			= named("MediumPurple", 0x9370DB);
	public static final ColorRGB	MEDIUMSEAGREEN			= named("MediumSeaGreen", 0x3CB371);
	public static final ColorRGB	MEDIUMSLATEBLUE			= named("MediumSlateBlue", 0x7B68EE);
	public static final ColorRGB	MEDIUMSPRINGGREEN		= named("MediumSpringGreen", 0x00FA9A);
	public static final ColorRGB	MEDIUMTURQUOISE			= named("MediumTurquoise", 0x48D1CC);
	public static final ColorRGB	MEDIUMVIOLETRED			= named("MediumVioletRed", 0xC71585);
	public static final ColorRGB	MIDNIGHTBLUE			= named("MidnightBlue", 0x191970);
	public static final ColorRGB	MINTCREAM				= named("MintCream", 0xF5FFFA);
	public static final ColorRGB	MISTYROSE				= named("MistyRose", 0xFFE4E1);
	public static final ColorRGB	MOCCASIN				= named("Moccasin", 0xFFE4B5);
	public static final ColorRGB	NAVAJOWHITE				= named("NavajoWhite", 0xFFDEAD);
	public static final ColorRGB	NAVY					= named("Navy", 0x000080);
	public static final ColorRGB	OLDLACE					= named("OldLace", 0xFDF5E6);
	public static final ColorRGB	OLIVE					= named("Olive", 0x808000);
	public static final ColorRGB	OLIVEDRAB				= named("OliveDrab", 0x6B8E23);
	public static final ColorRGB	ORANGE					= named("Orange", 0xFFA500);
	public static final ColorRGB	ORANGERED				= named("OrangeRed", 0xFF4500);
	public static final ColorRGB	ORCHID					= named("Orchid", 0xDA70D6);
	public static final ColorRGB	PALEGOLDENROD			= named("PaleGoldenRod", 0xEEE8AA);
	public static final ColorRGB	PALEGREEN				= named("PaleGreen", 0x98FB98);
	public static final ColorRGB	PALETURQUOISE			= named("PaleTurquoise", 0xAFEEEE);
	public static final ColorRGB	PALEVIOLETRED			= named("PaleVioletRed", 0xDB7093);
	public static final ColorRGB	PAPAYAWHIP				= named("PapayaWhip", 0xFFEFD5);
	public static final ColorRGB	PEACHPUFF				= named("PeachPuff", 0xFFDAB9);
	public static final ColorRGB	PERU					= named("Peru", 0xCD853F);
	public static final ColorRGB	PINK					= named("Pink", 0xFFC0CB);
	public static final ColorRGB	PLUM					= named("Plum", 0xDDA0DD);
	public static final ColorRGB	POWDERBLUE				= named("PowderBlue", 0xB0E0E6);
	public static final ColorRGB	PURPLE					= named("Purple", 0x800080);
	public static final ColorRGB	REBECCAPURPLE			= named("RebeccaPurple", 0x663399);
	public static final ColorRGB	RED						= named("Red", 0xFF0000);
	public static final ColorRGB	ROSYBROWN				= named("RosyBrown", 0xBC8F8F);
	public static final ColorRGB	ROYALBLUE				= named("RoyalBlue", 0x4169E1);
	public static final ColorRGB	SADDLEBROWN				= named("SaddleBrown", 0x8B4513);
	public static final ColorRGB	SALMON					= named("Salmon", 0xFA8072);
	public static final ColorRGB	SANDYBROWN				= named("SandyBrown", 0xF4A460);
	public static final ColorRGB	SEAGREEN				= named("SeaGreen", 0x2E8B57);
	public static final ColorRGB	SEASHELL				= named("SeaShell", 0xFFF5EE);
	public static final ColorRGB	SIENNA					= named("Sienna", 0xA0522D);
	public static final ColorRGB	SILVER					= named("Silver", 0xC0C0C0);
	public static final ColorRGB	SKYBLUE					= named("SkyBlue", 0x87CEEB);
	public static final ColorRGB	SLATEBLUE				= named("SlateBlue", 0x6A5ACD);
	public static final ColorRGB	SLATEGRAY				= named("SlateGray", 0x708090);
	public static final ColorRGB	SLATEGREY				= named("SlateGrey", 0x708090);
	public static final ColorRGB	SNOW					= named("Snow", 0xFFFAFA);
	public static final ColorRGB	SPRINGGREEN				= named("SpringGreen", 0x00FF7F);
	public static final ColorRGB	STEELBLUE				= named("SteelBlue", 0x4682B4);
	public static final ColorRGB	TAN						= named("Tan", 0xD2B48C);
	public static final ColorRGB	TEAL					= named("Teal", 0x008080);
	public static final ColorRGB	THISTLE					= named("Thistle", 0xD8BFD8);
	public static final ColorRGB	TOMATO					= named("Tomato", 0xFF6347);
	public static final ColorRGB	TURQUOISE				= named("Turquoise", 0x40E0D0);
	public static final ColorRGB	VIOLET					= named("Violet", 0xEE82EE);
	public static final ColorRGB	WHEAT					= named("Wheat", 0xF5DEB3);
	public static final ColorRGB	WHITE					= named("White", 0xFFFFFF);
	public static final ColorRGB	WHITESMOKE				= named("WhiteSmoke", 0xF5F5F5);
	public static final ColorRGB	YELLOW					= named("Yellow", 0xFFFF00);
	public static final ColorRGB	YELLOWGREEN				= named("YellowGreen", 0x9ACD32);
	// endregion

	private Integer hex;

	private final float	red;
	private final float	green;
	private final float	blue;
	private final float	alpha;

	public ColorRGB(int color) {
		this((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF);
		this.hex = color;
	}

	public ColorRGB(int red, int green, int blue) {
		this(red / 255f, green / 255f, blue / 255f, 1f);
	}

	public ColorRGB(int red, int green, int blue, int alpha) {
		this(red / 255f, green / 255f, blue / 255f, alpha / 255f);
	}

	public ColorRGB(float red, float green, float blue) {
		this(red, green, blue, 1f);
	}

	public ColorRGB(float red, float green, float blue, float alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	private static ColorRGB named(String name, int color) {
		ColorRGB c = new ColorRGB(color);
		NAMED_MAP.put(name.toLowerCase(Locale.ROOT), c);
		return c;
	}

	public int getHex() {
		return (hex != null) ? hex : VALUE_WHITE;
	}

	// region Parsing and Formatting

	/**
	 * Validator for color strings. Accepts CSS color names or hex codes with optional leading '#' or '0x'.
	 *
	 * @param str The string to validate
	 * @return True if and only if the string can be parsed
	 */
	public static boolean validate(String str) {
		return NAMED_MAP.containsKey(str.toLowerCase(Locale.ROOT)) || PATTERN_HEX_CODE.matcher(str).matches();
	}

	/**
	 * Format the color as it would appear in a config file.
	 *
	 * @param color The color
	 * @return A string in the form "#XXXXXX" or "#XXXXXXXX", where 'X' is a hex digit.
	 */
	public static String format(int color) {
		return String.format(color > 0xFFFFFF ? "#%08X" : "#%06X", color);
	}

	/**
	 * Attempt to parse the string as a color. May be either a common CSS color name or a hex code with optional leading '#' or '0x'. Consider using {@link #tryParse(String, int)} instead, which handles validation.
	 *
	 * @param str The string to try to parse
	 * @return A Color object based on str
	 * @throws NumberFormatException If the string cannot be parsed
	 * @throws NullPointerException  If the string is null
	 * @implNote Uses {@link UnsignedInts#parseUnsignedInt(String, int)} for parsing
	 */
	public static ColorRGB parse(String str) {
		// Named color?
		str = str.toLowerCase(Locale.ROOT);
		if (NAMED_MAP.containsKey(str)) {
			return NAMED_MAP.get(str);
		}

		// Hex code
		str = PATTERN_LEADING_JUNK.matcher(str).replaceFirst("");
		int color = UnsignedInts.parseUnsignedInt(str, 16);
		return new ColorRGB(color);
	}

	/**
	 * Attempt to parse a color, returning the default if it is not valid.
	 *
	 * @param str          The string to parse
	 * @param defaultValue The fallback value
	 * @return A color parsed from str, or from defaultValue if str is invalid
	 */
	public static ColorRGB tryParse(String str, int defaultValue) {
		if (!validate(str)) {
			return new ColorRGB(defaultValue);
		}
		return parse(str);
	}

	/**
	 * Read a color from JSON. The property must be a string. If the JsonObject does not contain a property with the given name, a Color is created from defaultValue. If the valid from JSON is invalid, an exception will be thrown.
	 *
	 * @param json         The JSON object
	 * @param propertyName The property to read from json
	 * @param defaultValue A default value to use if json does not have the given property
	 * @return A color parsed from the value read from json
	 * @throws NumberFormatException If the value from json cannot be parsed
	 */
	public static ColorRGB from(JsonObject json, String propertyName, int defaultValue) {
		String defaultStr = Integer.toHexString(defaultValue);
		return parse(JsonUtils.getString(json, propertyName, defaultStr));
	}

	// endregion

	public ColorRGB blendWith(ColorRGB other) {
		return blend(this, other);
	}

	public static ColorRGB blend(ColorRGB color1, ColorRGB color2) {
		return blend(color1, color2, 0.5f);
	}

	public static ColorRGB blend(ColorRGB color1, ColorRGB color2, float ratio) {
		int i1 = color1.getColor();
		int i2 = color2.getColor();

		int color = blend(i1, i2, ratio);
		return new ColorRGB(color);
	}

	public static int blend(int color1, int color2) {
		return blend(color1, color2, 0.5f);
	}

	public static int blend(int color1, int color2, float ratio) {
		ratio = MathHelper.clamp(ratio, 0f, 1f);
		float iRatio = 1f - ratio;

		int a1 = (color1 >> 24 & 0xff);
		int r1 = ((color1 & 0xff0000) >> 16);
		int g1 = ((color1 & 0xff00) >> 8);
		int b1 = (color1 & 0xff);

		int a2 = (color2 >> 24 & 0xff);
		int r2 = ((color2 & 0xff0000) >> 16);
		int g2 = ((color2 & 0xff00) >> 8);
		int b2 = (color2 & 0xff);

		int a = (int) ((a1 * iRatio) + (a2 * ratio));
		int r = (int) ((r1 * iRatio) + (r2 * ratio));
		int g = (int) ((g1 * iRatio) + (g2 * ratio));
		int b = (int) ((b1 * iRatio) + (b2 * ratio));

		return a << 24 | r << 16 | g << 8 | b;
	}

	public int getColor() {
		int r = (int) (red * 255f) << 16;
		int g = (int) (green * 255f) << 8;
		int b = (int) (blue * 255f);
		return r + g + b;
	}

	public int getColorWithA() {
		int a = (int) (alpha * 255f) << 24;
		int r = (int) (red * 255f) << 16;
		int g = (int) (green * 255f) << 8;
		int b = (int) (blue * 255f);
		return a + r + g + b;
	}

	public float getRed() {
		return red;
	}

	public float getGreen() {
		return green;
	}

	public float getBlue() {
		return blue;
	}

	public float getAlpha() {
		return alpha;
	}

	public int getRedInt() {
		return (int) (red * 255f);
	}

	public int getGreenInt() {
		return (int) (green * 255f);
	}

	public int getBlueInt() {
		return (int) (blue * 255f);
	}

	public int getAlphaInt() {
		return (int) (alpha * 255f);
	}
}
