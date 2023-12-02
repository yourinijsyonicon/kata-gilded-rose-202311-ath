package be.yonicon.gildedrose.inventory;

import be.yonicon.gildedrose.item.Item;

import java.util.List;

public record Inventory(List<Item> items) {
    public void processNextDay() {
        items.forEach(Item::processNextDay);
    }
}
