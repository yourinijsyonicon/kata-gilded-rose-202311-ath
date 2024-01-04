package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public final class ConjuredItemProcessor extends AbstractNextDayProcessor {

    private static final int CONJURED_ITEM_QUALITY_DECREASE = 2;

    public ConjuredItemProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {
        decreaseSellIn1Day();

        updateQuality();
    }

    private void updateQuality() {
        decreaseQuality(CONJURED_ITEM_QUALITY_DECREASE);

        if (hasSellByDatePassed()) {
            decreaseQuality(CONJURED_ITEM_QUALITY_DECREASE);
        }
    }
}
