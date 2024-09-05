package com.skadoosh.minigame.items;

import com.skadoosh.minigame.Minigame;
import com.skadoosh.minigame.items.gravetoken.GTScreenHandler;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnchantingTableBlockEntity;
import net.minecraft.block.entity.StructureBlockBlockEntity.Action;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Nameable;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GraveTokenItem extends Item
{
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        user.openHandledScreen(createScreenHandlerFactory(world, user.getBlockPos(), user.getStackInHand(hand)));
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public GraveTokenItem(Settings settings)
    {
        super(settings);
    }

    protected NamedScreenHandlerFactory createScreenHandlerFactory(World world, BlockPos pos, ItemStack stack)
    {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, player) -> {
            return new GTScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
        }, stack.getName());
    }
}
