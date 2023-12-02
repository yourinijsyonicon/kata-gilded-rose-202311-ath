package be.yonicon.gildedrose;

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
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

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
            app.updateQuality();
        }
    }

}