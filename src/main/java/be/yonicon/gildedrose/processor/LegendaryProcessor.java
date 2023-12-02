package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public class LegendaryProcessor extends AbstractNextDayProcessor {
    public LegendaryProcessor(final Item item) {
        super(item);
    }

    @Override
    public void processNextDay() {
        // legendary items never change in quality or sell in days value
    }
}
