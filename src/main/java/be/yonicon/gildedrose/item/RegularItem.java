package be.yonicon.gildedrose.item;

public final class RegularItem extends Item {

    private static final int REGULAR_ITEM_QUALITY_DECREASE = 1;

    public RegularItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
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
