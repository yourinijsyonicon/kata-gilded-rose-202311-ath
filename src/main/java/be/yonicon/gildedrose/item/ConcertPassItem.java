package be.yonicon.gildedrose.item;

public final class ConcertPassItem extends Item {
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
            if (sellIn < 10) {
                increaseQuality();
            }
            if (sellIn < 5) {
                increaseQuality();
            }
        }
    }
}
