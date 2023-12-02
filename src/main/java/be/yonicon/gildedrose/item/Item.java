package be.yonicon.gildedrose.item;

public abstract sealed class Item permits CheeseItem, ConcertPassItem, ConjuredItem, LegendaryItem, RegularItem {

    protected static final int MINIMUM_ITEM_QUALITY = 0;
    protected static final int MAXIMUM_ITEM_QUALITY = 50;

    public final String name;
    protected int sellIn;
    protected int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public abstract void processNextDay();

    protected void decreaseSellIn1Day() {
        sellIn = sellIn - 1;
    }

    protected void increaseQuality() {
        if (quality < MAXIMUM_ITEM_QUALITY) {
            quality = quality + 1;
        }
    }

    protected void decreaseQuality(final int amount) {
        if (quality > MINIMUM_ITEM_QUALITY) {
            quality = quality - amount;
        }
    }

    protected boolean hasSellByDatePassed() {
        return sellIn < 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}