package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public class ConjuredItemProcessor extends AbstractNextDayProcessor {
    public ConjuredItemProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {
        decreaseSellIn1Day();

        decreaseQuality(2);
        if (hasSellByDatePassed()) {
            decreaseQuality(2);
        }
    }
}
