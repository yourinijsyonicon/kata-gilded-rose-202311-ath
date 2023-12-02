package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public class RegularItemProcessor extends AbstractNextDayProcessor {
    public RegularItemProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
