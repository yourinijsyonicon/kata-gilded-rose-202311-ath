package be.yonicon.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void startNextDay() {
        for (Item item : items) {
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros" -> processLegendary();
                case "Aged Brie" -> processCheese(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> processConcertPass(item);
                default -> processRegularItem(item);
            }
        }
    }

    private static void processLegendary() {
        // legendary items never change in quality or sell in days value
    }

    private static void processRegularItem(final Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static void processConcertPass(final Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11 && item.quality < 50) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private static void processCheese(final Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}