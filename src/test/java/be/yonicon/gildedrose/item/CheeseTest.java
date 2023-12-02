package be.yonicon.gildedrose.item;

import be.yonicon.gildedrose.GildedRoseInn;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheeseTest {
    private static final String CHEESE_NAME = "Aged Brie";

    @Test
    void shouldIncreaseQualityByOne() {
        Item item = new CheeseItem(CHEESE_NAME, 11, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CHEESE_NAME);
        assertThat(item.quality).isEqualTo(21);
        assertThat(item.sellIn).isEqualTo(10);
    }

    @Test
    void shouldNeverExceed50InQuality() {
        Item item = new CheeseItem(CHEESE_NAME, -1, 50);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CHEESE_NAME);
        assertThat(item.quality).isEqualTo(50);
        assertThat(item.sellIn).isEqualTo(-2);
    }

    @Test
    void passingSellInDateDoesIncreaseQualityBy2() {
        Item item = new CheeseItem(CHEESE_NAME, -1, 10);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CHEESE_NAME);
        assertThat(item.quality).isEqualTo(12);
        assertThat(item.sellIn).isEqualTo(-2);
    }
}
