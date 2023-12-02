package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public abstract class AbstractNextDayProcessor {
    protected Item item;

    protected AbstractNextDayProcessor(final Item item) {
        this.item = item;
    }

    public abstract void processNextDay();
}
