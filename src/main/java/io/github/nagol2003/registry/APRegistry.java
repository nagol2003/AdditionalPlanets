/**
 * Copyright (C) 2020 Interstellar:  Exoplanets
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.nagol2003.registry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.github.nagol2003.AddonMain;
import io.github.nagol2003.Const;
import io.github.nagol2003.blocks.interfaces.BlockMetaSubtypes;
import io.github.nagol2003.blocks.interfaces.IAddRecipe;
import io.github.nagol2003.blocks.interfaces.IBlockTileEntity;
import io.github.nagol2003.blocks.interfaces.IColorBlock;
import io.github.nagol2003.blocks.interfaces.ICustomModel;
import io.github.nagol2003.init.InitFluids;
import io.github.nagol2003.items.interfaces.IColorItem;
import io.github.nagol2003.items.interfaces.ICustomMesh;
import io.github.nagol2003.items.interfaces.ItemBlockMetaSubtypes;
import io.github.nagol2003.registry.recipe.RecipeBuilder;
import io.github.nagol2003.util.Logging;
import io.github.nagol2003.util.Utils;
import lombok.Setter;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.LootFunctionManager;
import net.minecraft.world.storage.loot.properties.EntityProperty;
import net.minecraft.world.storage.loot.properties.EntityPropertyManager;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class APRegistry {
	private static final Pattern PATTERN_REGISTRY_NAME = Pattern.compile("[^a-z0-9_]+");

	public final List<Block> BLOCKS = NonNullList.create();
	public final List<Item> ITEMS = NonNullList.create();
	public final List<Fluid> FLUIDS = NonNullList.create();
	private final List<IAddRecipe> recipeAdders = NonNullList.create();
	private final List<Block> coloredBlocks = NonNullList.create();
	private final List<Item> coloredItems = NonNullList.create();

	private final Map<Class<? extends IForgeRegistryEntry<?>>, Consumer<APRegistry>> registrationHandlers = new HashMap<>();

	private Object mod;
	private final Logging logger;
	private final String modId;
	private final String resourcePrefix;

	@Nonnull
	private final RecipeBuilder recipes;

    @Setter
	@Nullable
	private CreativeTabs creativeTab = null;

	/**
	 * Constructor which automatically acquires the mod container to populate
	 * required fields.
	 *
	 */
	public APRegistry() {
		ModContainer mod = Objects.requireNonNull(Loader.instance().activeModContainer());
		this.modId = mod.getModId();
		this.resourcePrefix = this.modId + ":";
		this.logger = AddonMain.LOGGER;
		this.recipes = new RecipeBuilder(this.modId);
		MinecraftForge.EVENT_BUS.register(new EventHandler(this));
	}

	public RecipeBuilder getRecipeMaker() {
		return this.recipes;
	}

	/**
	 * Set the mod instance object
	 */
	public void setMod(Object mod) {
		this.mod = mod;
	}

	public APRegistry setTab(CreativeTabs tab) {
		this.creativeTab = tab;
		return this;
	}

	/**
	 * Adds a function that will be called when it is time to register objects for a
	 * certain class. For example, adding a handler for class {@link Item} will call
	 * the function during {@link net.minecraftforge.event.RegistryEvent.Register}
	 * for type {@link Item}.
	 * <p>
	 * This method should be called during <em>pre-init</em> in the proper proxy.
	 * </p>
	 *
	 * @param registerFunction The function to call
	 * @param registryClass    The registry object class
	 * @throws RuntimeException if a handler for the class is already registered
	 */
	public void addRegistrationHandler(Consumer<APRegistry> registerFunction,
			Class<? extends IForgeRegistryEntry<?>> registryClass) throws RuntimeException {
		if (this.registrationHandlers.containsKey(registryClass)) {
			throw new RuntimeException("Registration handler for class " + registryClass + " already registered!");
		}
		this.registrationHandlers.put(registryClass, registerFunction);
	}

	public <T extends Block> T register(T block, String key, String path) {
		return register(block, key, defaultItemBlock(block), path);
	}

	/**
	 * Register a Block. Its name (registry key/name) must be provided. Uses a new
	 * ItemBlock.
	 */
	public <T extends Block> T register(T block, String key) {
		return register(block, key, defaultItemBlock(block));

	}

	@Nonnull
	private <T extends Block> ItemBlock defaultItemBlock(T block) {
		if (block instanceof BlockMetaSubtypes) {
			return new ItemBlockMetaSubtypes((BlockMetaSubtypes) block);
		} else {
			return new ItemBlock(block);
		}
	}

	/**
	 * Register a Block. Its name registry name and ItemBlock must be provided.
	 */
	public <T extends Block> T register(T block, String key, ItemBlock itemBlock) {
		this.BLOCKS.add(block);
		block.setUnlocalizedName(this.modId + "." + key);

		validateRegistryName(key);
		ResourceLocation name = new ResourceLocation(this.modId, key);
		safeSetRegistryName(block, name);
		ForgeRegistries.BLOCKS.register(block);

		safeSetRegistryName(itemBlock, name);
		ForgeRegistries.ITEMS.register(itemBlock);

		// Register TileEntity
		if (block instanceof IBlockTileEntity) {
			Class<? extends TileEntity> clazz = ((IBlockTileEntity) block).getTileEntityClass();
			registerTileEntity(clazz, key);
		}

		if (block instanceof IAddRecipe) {
			this.recipeAdders.add((IAddRecipe) block);
		}

		if (Utils.isClient() && (block instanceof IColorBlock)) {
			this.coloredBlocks.add(block);
		}

		if (this.creativeTab != null) {
			block.setCreativeTab(this.creativeTab);
		}

		return block;
	}

	/**
	 * Register a Block. Its name registry name and ItemBlock must be provided.
	 */
	public <T extends Block> T register(T block, String key, ItemBlock itemBlock, String path) {
		this.BLOCKS.add(block);
		block.setUnlocalizedName(this.modId + "." + key);

		validateRegistryName(key);
		ResourceLocation name = new ResourceLocation(this.modId, key);
		safeSetRegistryName(block, name);
		ForgeRegistries.BLOCKS.register(block);

		safeSetRegistryName(itemBlock, name);
		ForgeRegistries.ITEMS.register(itemBlock);

		// Register TileEntity
		if (block instanceof IBlockTileEntity) {
			Class<? extends TileEntity> clazz = ((IBlockTileEntity) block).getTileEntityClass();
			registerTileEntity(clazz, key);
		}

		if (block instanceof IAddRecipe) {
			this.recipeAdders.add((IAddRecipe) block);
		}

		if (Utils.isClient() && (block instanceof IColorBlock)) {
			this.coloredBlocks.add(block);
		}

		if (this.creativeTab != null) {
			block.setCreativeTab(this.creativeTab);
		}

		return block;
	}

	// Item

	/**
	 * Register an Item. Its name (registry key/name) must be provided.
	 */
	public <T extends Item> T register(T item, String key) {
		this.ITEMS.add(item);
		item.setUnlocalizedName(this.modId + "." + key.toLowerCase());
		validateRegistryName(key);
		ResourceLocation name = new ResourceLocation(this.modId, key);
		safeSetRegistryName(item, name);
		ForgeRegistries.ITEMS.register(item);

		if (item instanceof IAddRecipe) {
			this.recipeAdders.add((IAddRecipe) item);
		}

		if (Utils.isClient() && (item instanceof IColorItem)) {
			this.coloredItems.add(item);
		}

		if (this.creativeTab != null) {
			item.setCreativeTab(this.creativeTab);
		}

		return item;
	}

	// Enchantment

	public void registerEnchantment(Enchantment enchantment, String key) {
		validateRegistryName(key);
		ResourceLocation name = new ResourceLocation(this.modId, key);
		safeSetRegistryName(enchantment, name);
		enchantment.setName(name.getResourceDomain() + "." + name.getResourcePath());
		ForgeRegistries.ENCHANTMENTS.register(enchantment);
	}

	// Entity

	/**
	 * Automatically incrementing ID number for registering entities.
	 */
	private int lastEntityId = -1;

	public void registerEntity(Class<? extends Entity> entityClass, String key) {
		registerEntity(entityClass, key, ++this.lastEntityId, this.mod, 64, 20, true);
	}

	public void registerEntity(Class<? extends Entity> entityClass, String key, int trackingRange, int updateFrequency,
			boolean sendsVelocityUpdates) {
		registerEntity(entityClass, key, ++this.lastEntityId, this.mod, trackingRange, updateFrequency,
				sendsVelocityUpdates);
	}

	public void registerEntity(Class<? extends Entity> entityClass, String key, int id, Object mod, int trackingRange,
			int updateFrequency, boolean sendsVelocityUpdates) {
		ResourceLocation resource = new ResourceLocation(this.modId, key);
		EntityRegistry.registerModEntity(resource, entityClass, key, id, mod, trackingRange, updateFrequency,
				sendsVelocityUpdates);
	}

	public void registerEntity(Class<? extends Entity> entityClass, String key, int trackingRange, int updateFrequency,
			boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary) {
		registerEntity(entityClass, key, ++this.lastEntityId, this.mod, trackingRange, updateFrequency,
				sendsVelocityUpdates, eggPrimary, eggSecondary);
	}

	public void registerEntity(Class<? extends Entity> entityClass, String key, int id, Object mod, int trackingRange,
			int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary) {
		ResourceLocation resource = new ResourceLocation(this.modId, key);
		EntityRegistry.registerModEntity(resource, entityClass, key, id, mod, trackingRange, updateFrequency,
				sendsVelocityUpdates, eggPrimary, eggSecondary);
	}

	@SideOnly(Side.CLIENT)
	public <T extends Entity> void registerEntityRenderer(Class<T> entityClass, IRenderFactory<T> renderFactory) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
	}

	// Potion

	public void registerPotion(Potion potion, String key) {
		if (potion.getName().isEmpty()) {
			potion.setPotionName("effect." + this.modId + "." + key);
		}

		validateRegistryName(key);
		ResourceLocation name = new ResourceLocation(this.modId, key);
		safeSetRegistryName(potion, name);
		ForgeRegistries.POTIONS.register(potion);
	}

	// Sound Events

	public void registerSoundEvent(SoundEvent sound, String key) {
		validateRegistryName(key);
		ResourceLocation name = new ResourceLocation(this.modId, key);
		safeSetRegistryName(sound, name);
		ForgeRegistries.SOUND_EVENTS.register(sound);
	}

	// Loot

	public void registerLootCondition(LootCondition.Serializer<? extends LootCondition> serializer) {
		LootConditionManager.registerCondition(serializer);
	}

	public void registerLootEntityProperty(EntityProperty.Serializer<? extends EntityProperty> serializer) {
		EntityPropertyManager.registerProperty(serializer);
	}

	public void registerLootFunction(LootFunction.Serializer<? extends LootFunction> serializer) {
		LootFunctionManager.registerFunction(serializer);
	}

	public void registerLootTable(String name) {
		LootTableList.register(new ResourceLocation(this.modId, name));
	}

	/**
	 * Set the object's registry name, if it has not already been set. Logs a
	 * warning if it has.
	 */
	private void safeSetRegistryName(IForgeRegistryEntry<?> entry, ResourceLocation name) {
		if (entry.getRegistryName() == null) {
			entry.setRegistryName(name);
		} else {
			this.logger.warn("Registry name for {} has already been set. Was trying to set it to {}.",
					entry.getRegistryName(), name);
		}
	}

	/**
	 * Ensure the given name does not contain upper case letters. This is not a
	 * problem until 1.13, so just log it as a warning.
	 */
	private void validateRegistryName(String name) {
		if (PATTERN_REGISTRY_NAME.matcher(name).matches()) {
			this.logger.warn("Invalid name for object: {}", name);
		}
	}

	// Advancements
	public <T extends ICriterionInstance> ICriterionTrigger<T> registerAdvancementTrigger(
			ICriterionTrigger<T> trigger) {
		CriteriaTriggers.register(trigger);
		return trigger;
	}

	/**
	 * Register a TileEntity. "tile." + resourcePrefix is automatically prepended to
	 * the key.
	 */
	public void registerTileEntity(Class<? extends TileEntity> tileClass, String key) {
		GameRegistry.registerTileEntity(tileClass, new ResourceLocation(this.modId, key));
	}

	/**
	 * Registers a renderer for a TileEntity.
	 */
	@SideOnly(Side.CLIENT)
	public <T extends TileEntity> void registerTileEntitySpecialRenderer(Class<T> tileClass,
			TileEntitySpecialRenderer<T> renderer) {
		ClientRegistry.bindTileEntitySpecialRenderer(tileClass, renderer);
	}

	// Model registration wrappers

	@SideOnly(Side.CLIENT)
	public void setModel(Block block, int meta, String modelPath) {
		setModel(Item.getItemFromBlock(block), meta, modelPath, "inventory");
	}

	@SideOnly(Side.CLIENT)
	public void setModel(Block block, int meta, String modelPath, String variant) {
		setModel(Item.getItemFromBlock(block), meta, modelPath, variant);
	}

	@SideOnly(Side.CLIENT)
	public void setModel(Item item, int meta, String modelPath) {
		setModel(item, meta, modelPath, "inventory");
	}

	@SideOnly(Side.CLIENT)
	public void setModel(Item item, int meta, String modelPath, String variant) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(this.resourcePrefix + modelPath, variant));
	}

	// endregion

	// region Initialization phases

	/*
	 * Initialization phases. Calling in either your common or client proxy is
	 * recommended. "client" methods in your client proxy, the rest in your common
	 * AND client proxy.
	 */

	private boolean preInitDone = false;
	private boolean initDone = false;
	private boolean postInitDone = false;

	/**
	 * Call in the "preInit" phase in your common proxy.
	 */
	public void preInit(FMLPreInitializationEvent event) {
		if (this.preInitDone) {
			this.logger.warn("preInit called more than once!");
			return;
		}

		verifyOrFindModObject();
		this.preInitDone = true;
	}

	private void verifyOrFindModObject() {
		if (this.mod == null) {
			this.logger.warn("Mod {} did not manually set its mod object! This is bad and may cause crashes.",
					this.modId);
			ModContainer container = Loader.instance().getIndexedModList().get(this.modId);
			if (container != null) {
				this.mod = container.getMod();
				this.logger.warn("Automatically acquired mod object for {}", this.modId);
			} else {
				this.logger.warn("Could not find mod object. The mod ID is likely incorrect.");
			}
		}
	}

	/**
	 * Call in the "init" phase in your common proxy.
	 */
	public void init(FMLInitializationEvent event) {
		if (this.initDone) {
			this.logger.warn("init called more than once!");
			return;
		}
		this.initDone = true;
	}

	/**
	 * Call in the "postInit" phase in your common proxy.
	 */
	@SuppressWarnings("unused")
	public void postInit(FMLPostInitializationEvent event) {
		if (this.postInitDone) {
			this.logger.warn("postInit called more than once!");
			return;
		}

		int oldRecipeRegisterCount = this.recipes.getOldRecipeRegisterCount();
		if (oldRecipeRegisterCount > 0) {
			long totalRecipes = ForgeRegistries.RECIPES.getKeys().stream().map(ResourceLocation::getResourceDomain)
					.filter(s -> s.equals(this.modId)).count();
		}
		this.postInitDone = true;
	}

	/**
	 * Call in the "preInit" phase in your client proxy.
	 */
	@SideOnly(Side.CLIENT)
	public void clientPreInit(FMLPreInitializationEvent event) {
	}

	/**
	 * Call in the "init" phase in your client proxy.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void clientInit(FMLInitializationEvent event) {
		for (Block block : this.BLOCKS) {
			if (block instanceof IBlockTileEntity) {
				IBlockTileEntity tileBlock = (IBlockTileEntity) block;
				final TileEntitySpecialRenderer tesr = tileBlock.getTileRenderer();
				if (tesr != null) {
					ClientRegistry.bindTileEntitySpecialRenderer(tileBlock.getTileEntityClass(), tesr);
				}
			}
		}
	}

	/**
	 * Call in the "postInit" phase in your client proxy.
	 *
	 * @param event
	 */
	@SideOnly(Side.CLIENT)
	public void clientPostInit(FMLPostInitializationEvent event) {
	}

	// endregion

	private void addRecipes() {
		this.recipeAdders.forEach(obj -> obj.addRecipes(this.recipes));
	}

	private void addOreDictEntries() {
		this.recipeAdders.forEach(IAddRecipe::addOreDict);
	}

	@SideOnly(Side.CLIENT)
	private void registerModels() {
		for (Block block : this.BLOCKS) {
			if (block instanceof ICustomModel) {
				((ICustomModel) block).registerModels();
			} else {
				ResourceLocation registryName = Objects.requireNonNull(block.getRegistryName());
				ModelResourceLocation model = new ModelResourceLocation(registryName, "inventory");
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
			}
		}
		for (Item item : this.ITEMS) {
			if (item instanceof ICustomMesh) {
				ICustomMesh customMesh = (ICustomMesh) item;
				ModelBakery.registerItemVariants(item, customMesh.getVariants());
				ModelLoader.setCustomMeshDefinition(item, customMesh.getCustomMesh());
			} else if (item instanceof ICustomModel) {
				((ICustomModel) item).registerModels();
			} else {
				ResourceLocation registryName = Objects.requireNonNull(item.getRegistryName());
				ModelResourceLocation model = new ModelResourceLocation(registryName, "inventory");
				ModelLoader.setCustomModelResourceLocation(item, 0, model);
			}
		}

		InitFluids.MOD_FLUID_BLOCKS.forEach(this::registerFluidModel);

	}

	private void registerFluidModel(final IFluidBlock fluidBlock) {
		final Item item = Item.getItemFromBlock((Block) fluidBlock);
		assert item != Items.AIR;

		ModelBakery.registerItemVariants(item);

		final ModelResourceLocation modelResourceLocation =
				new ModelResourceLocation(Const.TEXTURE_PREFIX + "fluid", fluidBlock.getFluid().getName());

		ModelLoader.setCustomMeshDefinition(item, stack -> modelResourceLocation);

		ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(final IBlockState p_178132_1_) {
				return modelResourceLocation;
			}
		});
	}

	public static class EventHandler {
		private final APRegistry ModRegistry;

		public EventHandler(APRegistry ModRegistry) {
			this.ModRegistry = ModRegistry;
		}

		private void runRegistrationHandlerIfPresent(Class<? extends IForgeRegistryEntry<?>> registryClass) {
			if (this.ModRegistry.registrationHandlers.containsKey(registryClass)) {
				this.ModRegistry.registrationHandlers.get(registryClass).accept(this.ModRegistry);
			}
		}

		@SubscribeEvent
		public void registerBlocks(RegistryEvent.Register<Block> event) {
			runRegistrationHandlerIfPresent(Block.class);
		}

		@SubscribeEvent
		public void registerItems(RegistryEvent.Register<Item> event) {
			runRegistrationHandlerIfPresent(Item.class);
			this.ModRegistry.addOreDictEntries();
		}

		@SubscribeEvent
		public void registerPotions(RegistryEvent.Register<Potion> event) {
			runRegistrationHandlerIfPresent(Potion.class);
		}

		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			runRegistrationHandlerIfPresent(Biome.class);
		}

		@SubscribeEvent
		public void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
			runRegistrationHandlerIfPresent(SoundEvent.class);
		}

		@SubscribeEvent
		public void registerPotionTypes(RegistryEvent.Register<PotionType> event) {
			runRegistrationHandlerIfPresent(PotionType.class);
		}

		@SubscribeEvent
		public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
			runRegistrationHandlerIfPresent(Enchantment.class);
		}

		@SubscribeEvent
		public void registerVillagerProfessions(RegistryEvent.Register<VillagerProfession> event) {
			runRegistrationHandlerIfPresent(VillagerProfession.class);
		}

		@SubscribeEvent
		public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
			runRegistrationHandlerIfPresent(EntityEntry.class);
		}

		@SubscribeEvent
		public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
			runRegistrationHandlerIfPresent(IRecipe.class);
			this.ModRegistry.addRecipes();
		}

		@SubscribeEvent
		public void registerModels(ModelRegistryEvent event) {
			this.ModRegistry.registerModels();
		}

		@SideOnly(Side.CLIENT)
		@SubscribeEvent
		public void registerBlockColors(ColorHandlerEvent.Block event) {
			BlockColors blockColors = event.getBlockColors();
			for (Block block : this.ModRegistry.coloredBlocks) {
				blockColors.registerBlockColorHandler(((IColorBlock) block).getColorHandler(), block);
			}
		}

		@SideOnly(Side.CLIENT)
		@SubscribeEvent
		public void registerItemColors(ColorHandlerEvent.Item event) {
			ItemColors itemColors = event.getItemColors();
			for (Block block : this.ModRegistry.coloredBlocks) {
				itemColors.registerItemColorHandler(((IColorBlock) block).getItemColorHandler(),
						Item.getItemFromBlock(block));
			}
			for (Item item : this.ModRegistry.coloredItems) {
				itemColors.registerItemColorHandler(((IColorItem) item).getColorHandler(), item);
			}
		}
	}
}
