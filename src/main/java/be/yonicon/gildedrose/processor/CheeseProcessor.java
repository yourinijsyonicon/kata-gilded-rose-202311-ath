package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public final class CheeseProcessor extends AbstractNextDayProcessor {

    public CheeseProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {
        decreaseSellIn1Day();

        updateQuality();
    }

    private void updateQuality() {
        increaseQuality();

        if (hasSellByDatePassed()) {
            increaseQuality();
        }
    }
}
