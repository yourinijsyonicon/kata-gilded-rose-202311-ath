package be.yonicon.gildedrose.item;

public final class RegularItem extends Item {
    public RegularItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void processNextDay() {
        decreaseSellIn1Day();

        updateQuality();
    }

    private void updateQuality() {
        decreaseQuality(1);

        if (hasSellByDatePassed()) {
            decreaseQuality(1);
        }
    }
}
