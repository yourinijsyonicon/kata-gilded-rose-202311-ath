package be.yonicon.gildedrose.item;

public final class ConcertPassItem extends Item {

    private static final int FIRST_QUALITY_INCREASE_THRESHOLD = 10;
    private static final int SECOND_QUALITY_INCREASE_THRESHOLD = 5;

    public ConcertPassItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void processNextDay() {
        decreaseSellIn1Day();

        updateQuality();
    }

    private void updateQuality() {
        increaseQuality();
        if (hasSellByDatePassed()) {
            quality = MINIMUM_ITEM_QUALITY;
        } else {
            increaseQualityByPassedThresholds();
        }
    }

    private void increaseQualityByPassedThresholds() {
        if (sellIn < FIRST_QUALITY_INCREASE_THRESHOLD) {
            increaseQuality();
        }
        if (sellIn < SECOND_QUALITY_INCREASE_THRESHOLD) {
            increaseQuality();
        }
    }
}
