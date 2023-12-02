package be.yonicon.gildedrose.item;

import be.yonicon.gildedrose.GildedRoseInn;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredTest {
    private static final String ITEM_NAME = "Conjured Mana Cake";

    @Test
    void shouldDecreaseQualityBy2IfNotPassedSellIn() {
        Item item = new ConjuredItem(ITEM_NAME, 10, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(ITEM_NAME);
        assertThat(item.quality).isEqualTo(18);
        assertThat(item.sellIn).isEqualTo(9);
    }

    @Test
    void shouldDecreaseQualityBy2IfPassedSellIn() {
        Item item = new ConjuredItem(ITEM_NAME, 0, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(ITEM_NAME);
        assertThat(item.quality).isEqualTo(16);
        assertThat(item.sellIn).isEqualTo(-1);
    }

    @Test
    void shouldNeverHaveNegativeQuality() {
        Item item = new ConjuredItem(ITEM_NAME, 0, 0);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(ITEM_NAME);
        assertThat(item.quality).isEqualTo(0);
        assertThat(item.sellIn).isEqualTo(-1);
    }

    @Test
    void shouldNeverHaveNegativeQualityEvenIfQualityIsOne() {
        Item item = new ConjuredItem(ITEM_NAME, 0, 1);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(ITEM_NAME);
        assertThat(item.quality).isEqualTo(0);
        assertThat(item.sellIn).isEqualTo(-1);
    }
}
