package be.yonicon.gildedrose.processor;

import be.yonicon.gildedrose.Item;

public final class ProcessorFactory {
    private ProcessorFactory() {
    }

    public static AbstractNextDayProcessor getProcessor(final Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> {
                return new LegendaryProcessor(item);
            }
            case "Aged Brie" -> {
                return new CheeseProcessor(item);
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                return new ConcertPassProcessor(item);
            }
            case "Conjured Mana Cake" -> {
                return new ConjuredItemProcessor(item);
            }
            default -> {
                return new RegularItemProcessor(item);
            }
        }
    }
}
