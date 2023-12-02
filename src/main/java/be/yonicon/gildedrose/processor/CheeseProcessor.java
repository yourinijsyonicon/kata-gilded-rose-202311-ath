package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public class CheeseProcessor extends AbstractNextDayProcessor {
    public CheeseProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {

        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
