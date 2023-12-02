package be.yonicon.gildedrose.item;

import be.yonicon.gildedrose.GildedRose;
import be.yonicon.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegendaryTest {

    private static final String LEGENDARY_ITEM_NAME = "Sulfuras, Hand of Ragnaros";

    @Test
    void shouldNeverChange() {
        Item sulfuras = new Item(LEGENDARY_ITEM_NAME, 100, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.startNextDay();
        gildedRose.startNextDay();

        assertThat(sulfuras.name).isEqualTo(LEGENDARY_ITEM_NAME);
        assertThat(sulfuras.quality).isEqualTo(80);
        assertThat(sulfuras.sellIn).isEqualTo(100);
    }

    @Test
    void shouldNeverChangeEvenIfQualityIsBelow50() {
        Item sulfuras = new Item(LEGENDARY_ITEM_NAME, 100, 49);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.startNextDay();
        gildedRose.startNextDay();

        assertThat(sulfuras.name).isEqualTo(LEGENDARY_ITEM_NAME);
        assertThat(sulfuras.quality).isEqualTo(49);
        assertThat(sulfuras.sellIn).isEqualTo(100);
    }

    @Test
    void sellInPassedHasNoImpactOnQuality() {
        Item sulfuras = new Item(LEGENDARY_ITEM_NAME, -10, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

        gildedRose.startNextDay();
        gildedRose.startNextDay();

        assertThat(sulfuras.name).isEqualTo(LEGENDARY_ITEM_NAME);
        assertThat(sulfuras.quality).isEqualTo(80);
        assertThat(sulfuras.sellIn).isEqualTo(-10);
    }
}
