package be.yonicon.gildedrose.item;

import be.yonicon.gildedrose.GildedRose;
import be.yonicon.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredTest {
    private static final String ITEM_NAME = "Conjured Mana Cake";

    @Test
    void shouldDecreaseQualityBy2IfNotPassedSellIn() {
        Item item = new Item(ITEM_NAME, 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.startNextDay();

        assertThat(item.name).isEqualTo(ITEM_NAME);
        assertThat(item.quality).isEqualTo(18);
        assertThat(item.sellIn).isEqualTo(9);
    }

    @Test
    void shouldDecreaseQualityBy2IfPassedSellIn() {
        Item item = new Item(ITEM_NAME, 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.startNextDay();

        assertThat(item.name).isEqualTo(ITEM_NAME);
        assertThat(item.quality).isEqualTo(16);
        assertThat(item.sellIn).isEqualTo(-1);
    }

    @Test
    void shouldNeverHaveNegativeQuality() {
        Item item = new Item(ITEM_NAME, 0, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.startNextDay();

        assertThat(item.name).isEqualTo(ITEM_NAME);
        assertThat(item.quality).isEqualTo(0);
        assertThat(item.sellIn).isEqualTo(-1);
    }

    @Test
    void conjuredShouldNeverHaveNegativeQualityEvenIfQualityIsOne() {
        Item item = new Item(ITEM_NAME, 0, 1);
        GildedRose gildedRose = new GildedRose(new Item[] {item});

        gildedRose.startNextDay();

        assertThat(item.quality).isEqualTo(0);
        assertThat(item.sellIn).isEqualTo(-1);
    }
}
