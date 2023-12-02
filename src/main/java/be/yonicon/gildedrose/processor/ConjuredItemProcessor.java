package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public final class ConjuredItemProcessor extends AbstractNextDayProcessor {
    public ConjuredItemProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {
        decreaseSellIn1Day();

        updateQuality();
    }

    private void updateQuality() {
        decreaseQuality(2);

        if (hasSellByDatePassed()) {
            decreaseQuality(2);
        }
    }
}
