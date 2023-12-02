package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;
import be.yonicon.gildedrose.itemvault.ItemVault;

public final class ProcessorFactory {
    private ProcessorFactory() {
    }

    public static AbstractNextDayProcessor getProcessor(final Item item) {
        return switch (ItemVault.determineItemClass(item)) {
            case LEGENDARY -> new LegendaryProcessor(item);
            case CHEESE -> new CheeseProcessor(item);
            case CONCERT_PASS -> new ConcertPassProcessor(item);
            case CONJURED -> new ConjuredItemProcessor(item);
            case REGULAR -> new RegularItemProcessor(item);
        };
    }
}
