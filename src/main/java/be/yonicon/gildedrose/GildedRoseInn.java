package be.yonicon.gildedrose;

import be.yonicon.gildedrose.inventory.Inventory;
import be.yonicon.gildedrose.item.Item;

import java.util.Arrays;

public class GildedRoseInn {
    private final Inventory inventory;

    public GildedRoseInn(Item[] items) {
        inventory = new Inventory(Arrays.asList(items));
    }

    public void openNextDay() {
        inventory.processNextDay();
    }
}