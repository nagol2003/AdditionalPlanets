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

package io.github.nagol2003.items.interfaces;

import java.util.Locale;
import java.util.function.Function;

import javax.annotation.Nonnull;

import io.github.nagol2003.registry.APRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;


/**
 * Used to map enum values to items for easy grouping. Intended to be implemented on the enum, but
 * any class would work (you would still have to make the enum though). Every value of the enum
 * should represent one and only one unique item. Remember to store the item, preferably in a
 * private field. This does not register the items for you, but the {@code registerItems} method can
 * be used. Enum values can be added or sorted with no ill effects.
 *
 * @param <E> The enum, which would typically implement this interface
 * @param <I> The Item class, provided to reduce the need for casting
 */
@SuppressWarnings("rawtypes")
public interface IEnumItems<E extends Enum<E>, I extends Item> extends IStringSerializable {
    /**
     * Gets the enum that represents the object. Typically, you would just {@code return this}. This
     * exists because the implementing class may not be an enum.
     *
     * @return An enum representing this object, usually the object itself
     */
    @Nonnull
    E getEnum();

    /**
     * Gets the {@code Item} associated with this object.
     *
     * @return The {code Item}
     */
    @Nonnull
    I getItem();

    /**
     * Convenience method to get an {@code ItemStack} of the {@code Item}. Calls {@code getItem}.
     *
     * @return An {@code ItemStack} with a size of 1
     */
    @Nonnull
    default ItemStack getStack() {
        return new ItemStack(getItem());
    }

    /**
     * Convenience method to get an {@code ItemStack} of the {@code Item}. Calls {@code getItem}.
     *
     * @param amount The stack size
     * @return An {@code ItemStack} with a size of {code amount}
     */
    @Nonnull
    default ItemStack getStack(int amount) {
        return new ItemStack(getItem(), amount);
    }

    /**
     * Gets the name for the {@code Item} (excluding mod ID). Should contain only lowercase letters
     * and underscores ([a-z_]+).
     *
     * @return A unique name for the {@code Item}, in snake_case
     */
    @Nonnull
    @Override
    default String getName() {
        String prefix = getNamePrefix();
        return (!prefix.isEmpty() ? prefix + "_" : "") + getEnum().name().toLowerCase(Locale.ROOT);
    }


    /**
     * Gets a prefix for all item names. If non-empty, {@code getName} will prepend the prefix
     * followed by an underscore to every name.
     *
     * @return The name prefix, or an empty string if a prefix should not be used (default empty)
     */
    @Nonnull
    default String getNamePrefix() {
        return "";
    }

    class RegistrationHelper {
        private final APRegistry registry;

        public RegistrationHelper(APRegistry registry) {
            this.registry = registry;
        }

        /**
         * Registers items for the provided {@link IEnumItems} values.
         * @param items The {@link IEnumItems} values
         */
		public void registerItems(IEnumItems... items) {
            for (IEnumItems item : items)
                registry.register(item.getItem(), item.getName());
        }

        /**
         * Registers blocks for any enum type, using the given functions to get the block and name.
         * @param block Function that returns the block for the enum
         * @param name Function that returns the registry name (minus namespace/mod ID) of the block
         * @param enumClass The enum type, E
         * @param <E> Any enum type
         */
        public <E extends Enum<E>> void registerBlocksGenericEnum(Function<E, Block> block, Function<E, String> name, Class<E> enumClass) {
            for (E e : enumClass.getEnumConstants())
                registry.register(block.apply(e), name.apply(e));
        }

        /**
         * Registers items for any enum type, using the given functions to get the item and name.
         * @param item Function that returns the item for the enum
         * @param name Function that returns the registry name (minus namespace/mod ID) of the item
         * @param enumClass The enum type, E
         * @param <E> Any enum type
         */
        public <E extends Enum<E>> void registerItemsGenericEnum(Function<E, Item> item, Function<E, String> name, Class<E> enumClass) {
            for (E e : enumClass.getEnumConstants())
                registry.register(item.apply(e), name.apply(e));
        }
    }

}
