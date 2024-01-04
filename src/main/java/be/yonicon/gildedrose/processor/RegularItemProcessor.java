package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public final class RegularItemProcessor extends AbstractNextDayProcessor {

    private static final int REGULAR_ITEM_QUALITY_DECREASE = 1;

    public RegularItemProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {
        decreaseSellIn1Day();

        updateQuality();
    }

    private void updateQuality() {
        decreaseQuality(REGULAR_ITEM_QUALITY_DECREASE);

        if (hasSellByDatePassed()) {
            decreaseQuality(REGULAR_ITEM_QUALITY_DECREASE);
        }
    }
}
