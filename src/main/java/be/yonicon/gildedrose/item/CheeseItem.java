package be.yonicon.gildedrose.item;

public final class CheeseItem extends Item {
    public CheeseItem(final String name, final int sellIn, final int quality) {
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
            increaseQuality();
        }
    }
}
