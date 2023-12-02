package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public class ConcertPassProcessor extends AbstractNextDayProcessor {

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
            if (item.sellIn < 10) {
                increaseQuality();
            }
            if (item.sellIn < 5) {
                increaseQuality();
            }
        }
    }
}
