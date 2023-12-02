package be.yonicon.gildedrose.item;

import be.yonicon.gildedrose.GildedRose;
import be.yonicon.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheeseTest {
    private final static String CHEESE_NAME = "Aged Brie";

    @Test
    void shouldIncreaseQualityByOne() {
        Item item = new Item(CHEESE_NAME, 11, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.name).isEqualTo(CHEESE_NAME);
        assertThat(item.quality).isEqualTo(21);
        assertThat(item.sellIn).isEqualTo(10);
    }

    @Test
    void shouldNeverExceed50InQuality() {
        Item item = new Item(CHEESE_NAME, -1, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.name).isEqualTo(CHEESE_NAME);
        assertThat(item.quality).isEqualTo(50);
        assertThat(item.sellIn).isEqualTo(-2);
    }

    @Test
    void passingSellInDateDoesIncreaseQualityBy2() {
        Item item = new Item(CHEESE_NAME, -1, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.name).isEqualTo(CHEESE_NAME);
        assertThat(item.quality).isEqualTo(12);
        assertThat(item.sellIn).isEqualTo(-2);
    }
}
