package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public final class ConcertPassProcessor extends AbstractNextDayProcessor {

    private static final int FIRST_QUALITY_INCREASE_THRESHOLD = 10;
    private static final int SECOND_QUALITY_INCREASE_THRESHOLD = 5;

    public ConcertPassProcessor(final Item item) {
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
            item.quality = MINIMUM_ITEM_QUALITY;
        } else {
            if (item.sellIn < FIRST_QUALITY_INCREASE_THRESHOLD) {
                increaseQuality();
            }
            if (item.sellIn < SECOND_QUALITY_INCREASE_THRESHOLD) {
                increaseQuality();
            }
        }
    }
}
