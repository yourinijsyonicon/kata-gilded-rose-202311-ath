package be.yonicon.gildedrose.item;

public final class ConjuredItem extends Item {
    public ConjuredItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
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
