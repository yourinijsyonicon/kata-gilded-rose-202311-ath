package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public class RegularItemProcessor extends AbstractNextDayProcessor {
    public RegularItemProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {
        decreaseSellIn1Day();

        updateQuality();
    }

    private void updateQuality() {
        decreaseQuality(1);

        if (hasSellByDatePassed()) {
            decreaseQuality(1);
        }
    }
}
