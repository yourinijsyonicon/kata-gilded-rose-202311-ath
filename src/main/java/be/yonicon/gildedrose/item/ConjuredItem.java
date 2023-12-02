package be.yonicon.gildedrose.item;

public final class ConjuredItem extends Item {

    private static final int CONJURED_ITEM_QUALITY_DECREASE = 2;

    public ConjuredItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
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
