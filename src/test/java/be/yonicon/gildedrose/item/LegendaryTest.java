package be.yonicon.gildedrose.item;

import be.yonicon.gildedrose.GildedRoseInn;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegendaryTest {

    private static final String LEGENDARY_ITEM_NAME = "Sulfuras, Hand of Ragnaros";

    @Test
    void shouldNeverChange() {
        Item sulfuras = new LegendaryItem(LEGENDARY_ITEM_NAME, 100, 80);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{sulfuras});

        gildedRose.openNextDay();
        gildedRose.openNextDay();

        assertThat(sulfuras.name).isEqualTo(LEGENDARY_ITEM_NAME);
        assertThat(sulfuras.quality).isEqualTo(80);
        assertThat(sulfuras.sellIn).isEqualTo(100);
    }

    @Test
    void shouldNeverChangeEvenIfQualityIsBelow50() {
        Item sulfuras = new LegendaryItem(LEGENDARY_ITEM_NAME, 100, 49);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{sulfuras});

        gildedRose.openNextDay();
        gildedRose.openNextDay();

        assertThat(sulfuras.name).isEqualTo(LEGENDARY_ITEM_NAME);
        assertThat(sulfuras.quality).isEqualTo(49);
        assertThat(sulfuras.sellIn).isEqualTo(100);
    }

    @Test
    void sellInPassedHasNoImpactOnQuality() {
        Item sulfuras = new LegendaryItem(LEGENDARY_ITEM_NAME, -10, 80);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{sulfuras});

        gildedRose.openNextDay();
        gildedRose.openNextDay();

        assertThat(sulfuras.name).isEqualTo(LEGENDARY_ITEM_NAME);
        assertThat(sulfuras.quality).isEqualTo(80);
        assertThat(sulfuras.sellIn).isEqualTo(-10);
    }
}
