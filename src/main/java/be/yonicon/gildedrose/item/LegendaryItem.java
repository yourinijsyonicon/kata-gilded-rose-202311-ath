package be.yonicon.gildedrose.item;

public final class LegendaryItem extends Item {
    public LegendaryItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void processNextDay() {
        // legendary items never change in quality or sell in days value
    }
}
