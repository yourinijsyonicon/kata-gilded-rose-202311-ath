package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public abstract sealed class AbstractNextDayProcessor
        permits CheeseProcessor, ConcertPassProcessor, ConjuredItemProcessor, LegendaryProcessor, RegularItemProcessor {

    protected static final int MINIMUM_ITEM_QUALITY = 0;
    protected static final int MAXIMUM_ITEM_QUALITY = 50;

    protected final Item item;

    protected AbstractNextDayProcessor(final Item item) {
        this.item = item;
    }

    public abstract void processNextDay();

    protected void decreaseSellIn1Day() {
        item.sellIn = item.sellIn - 1;
    }

    protected void increaseQuality() {
        if (item.quality < MAXIMUM_ITEM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseQuality(final int amount) {
        if (item.quality > MINIMUM_ITEM_QUALITY) {
            item.quality = item.quality - amount;
        }
    }

    protected boolean hasSellByDatePassed() {
        return item.sellIn < 0;
    }
}
