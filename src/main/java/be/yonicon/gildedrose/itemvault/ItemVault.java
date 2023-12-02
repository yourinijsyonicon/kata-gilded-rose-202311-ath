package be.yonicon.gildedrose.itemvault;

import be.yonicon.gildedrose.Item;

import java.util.Map;

public final class ItemVault {
    private static final Map<String, ItemClass> KNOWN_ITEMS = Map.of(
            "Sulfuras, Hand of Ragnaros", ItemClass.LEGENDARY,
            "Aged Brie", ItemClass.CHEESE,
            "Backstage passes to a TAFKAL80ETC concert", ItemClass.CONCERT_PASS,
            "Conjured Mana Cake", ItemClass.CONJURED);

    private ItemVault() {
    }

    public static ItemClass determineItemClass(final Item item) {
        return KNOWN_ITEMS.getOrDefault(item.name, ItemClass.REGULAR);
    }
}
