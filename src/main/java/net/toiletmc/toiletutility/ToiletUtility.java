package net.toiletmc.toiletutility;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ToiletUtility extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // 从 config.yml 中读取插件配置
        Config cfg = new Config(this);

        // 1. 创建Slimefun分类
        NamespacedKey itemGroupId = new NamespacedKey(this, "toilet_utility");
        ItemGroup itemGroup = new ItemGroup(itemGroupId, getItemGroupIcon());
        // 2. 创建分类中的物品
        SlimefunItemStack slimefunItem = new SlimefunItemStack("COOL_DIAMOND", Material.DIAMOND, "&4炫酷的钻石", "&c+20% 炫酷");
        // 3. 创建物品的配方
        ItemStack[] recipe = {new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD), null, new ItemStack(Material.DIAMOND), null, new ItemStack(Material.EMERALD), null, new ItemStack(Material.EMERALD)};
        // 4. 注册物品
        SlimefunItem item = new SlimefunItem(itemGroup, slimefunItem, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        item.register(this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/ToiletMC/plugin-ToiletUtility/issues";
    }

    @Override
    public @NotNull JavaPlugin getJavaPlugin() {
        return this;
    }


    private ItemStack getItemGroupIcon() {
        ItemStack itemGroupItem = new CustomItemStack(Material.PLAYER_HEAD, "&x&5&b&7&5&e&e厕所实用工具");
        String texture = "ewogICJ0aW1lc3RhbXAiIDogMTY4ODM5NzQzNDQwNiwKICAicHJvZmlsZUlkIiA6ICJhZWI3NjNlZDdlNzU0OGQyYWE5N2FmN2E3NjhlMGFlMyIsCiAgInByb2ZpbGVOYW1lIiA6ICJTa3lfQ2FzdGxlXyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xYjNiZTczMzA5OGRkMTZiNTg5MWYxMjE1MGJiMzQ4OGQ0ZTk1MzA0MzYzZDYyZTc3MzAwMGJiMGEzNTA5ZTlmIgogICAgfSwKICAgICJDQVBFIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yMzQwYzBlMDNkZDI0YTExYjE1YThiMzNjMmE3ZTllMzJhYmIyMDUxYjI0ODFkMGJhN2RlZmQ2MzVjYTdhOTMzIgogICAgfQogIH0KfQ==";

        SkullMeta skullMeta = (SkullMeta) itemGroupItem.getItemMeta();
        skullMeta.setPlayerProfile(Bukkit.createProfile(UUID.randomUUID(), null));
        PlayerProfile playerProfile = skullMeta.getPlayerProfile();
        if (playerProfile != null) {
            playerProfile.getProperties().add(new ProfileProperty("textures", texture));
        }
        skullMeta.setPlayerProfile(playerProfile);
        itemGroupItem.setItemMeta(skullMeta);

        return itemGroupItem;
    }
}
