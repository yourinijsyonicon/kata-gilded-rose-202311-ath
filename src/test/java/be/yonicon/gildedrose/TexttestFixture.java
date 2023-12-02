package be.yonicon.gildedrose;

import be.yonicon.gildedrose.item.CheeseItem;
import be.yonicon.gildedrose.item.ConcertPassItem;
import be.yonicon.gildedrose.item.ConjuredItem;
import be.yonicon.gildedrose.item.Item;
import be.yonicon.gildedrose.item.LegendaryItem;
import be.yonicon.gildedrose.item.RegularItem;

import java.util.function.Consumer;

public class TexttestFixture {
    public static void main(String[] args) {
        fixture(args, System.out::println);
    }

    public static String capture(final String[] args) {
        StringBuilder sB = new StringBuilder();
        fixture(args, str -> sB.append(str).append(System.lineSeparator()));

        return sB.toString();
    }

    private static void fixture(final String[] args, final Consumer<String> appender) {
        appender.accept("OMGHAI!");

        Item[] items = new Item[] {
                new RegularItem("+5 Dexterity Vest", 10, 20), //
                new CheeseItem("Aged Brie", 2, 0), //
                new RegularItem("Elixir of the Mongoose", 5, 7), //
                new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                new LegendaryItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new ConcertPassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new ConcertPassItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new ConcertPassItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new ConjuredItem("Conjured Mana Cake", 3, 6) };

        GildedRoseInn app = new GildedRoseInn(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            appender.accept("-------- day " + i + " --------");
            appender.accept("name, sellIn, quality");
            for (Item item : items) {
                appender.accept("" + item);
            }
            appender.accept("");
            app.openNextDay();
        }
    }

}