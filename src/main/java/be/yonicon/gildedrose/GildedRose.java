package be.yonicon.gildedrose;

import be.yonicon.gildedrose.processor.ProcessorFactory;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void startNextDay() {
        for (Item item : items) {
            ProcessorFactory.getProcessor(item).processNextDay();
        }
    }
}