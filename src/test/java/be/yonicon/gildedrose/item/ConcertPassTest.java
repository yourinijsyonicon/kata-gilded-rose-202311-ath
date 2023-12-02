package be.yonicon.gildedrose.item;

import be.yonicon.gildedrose.GildedRoseInn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConcertPassTest {
    private static final String CONCERT_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    @DisplayName("Concert passes should increase quality by 1 if sellIn is > 10 days away")
    void shouldIncreaseInQualityByOneIfSellInIsMoreThan10DaysAway() {
        Item item = new ConcertPassItem(CONCERT_PASS_NAME, 11, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CONCERT_PASS_NAME);
        assertThat(item.quality).isEqualTo(21);
        assertThat(item.sellIn).isEqualTo(10);
    }

    @Test
    @DisplayName("Concert passes should increase quality by 2 if sellIn is <= 10 (but > 5) days away")
    void shouldIncreaseInQualityByTwoIfSellInIsBetween5And10DaysAway_upperBoundary() {
        Item item = new ConcertPassItem(CONCERT_PASS_NAME, 10, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CONCERT_PASS_NAME);
        assertThat(item.quality).isEqualTo(22);
        assertThat(item.sellIn).isEqualTo(9);
    }

    @Test
    @DisplayName("Concert passes should increase quality by 2 if sellIn is > 5 (but <= 10) days away")
    void shouldIncreaseInQualityByTwoIfSellInIsBetween5And10DaysAway_lowerBoundary() {
        Item item = new ConcertPassItem(CONCERT_PASS_NAME, 6, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CONCERT_PASS_NAME);
        assertThat(item.quality).isEqualTo(22);
        assertThat(item.sellIn).isEqualTo(5);
    }

    @Test
    @DisplayName("Concert passes should increase quality by 3 if sellIn is <= 5 days (but > 0) away")
    void shouldIncreaseInQualityByThreeIfSellInIsBetween0And5DaysAway_upperBoundary() {
        Item item = new ConcertPassItem(CONCERT_PASS_NAME, 5, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CONCERT_PASS_NAME);
        assertThat(item.quality).isEqualTo(23);
        assertThat(item.sellIn).isEqualTo(4);
    }

    @Test
    @DisplayName("Concert passes should increase quality by 3 if sellIn is > 0 (but <= 5) days away")
    void shouldIncreaseInQualityByThreeIfSellInIsBetween0And5DaysAway_lowerBoundary() {
        Item item = new ConcertPassItem(CONCERT_PASS_NAME, 1, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CONCERT_PASS_NAME);
        assertThat(item.quality).isEqualTo(23);
        assertThat(item.sellIn).isEqualTo(0);
    }

    @Test
    @DisplayName("Concert passes should drop quality to zero if sellIn is zero.")
    void shouldDropQualityToZeroIfSellInIs0() {
        Item item = new ConcertPassItem(CONCERT_PASS_NAME, 0, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CONCERT_PASS_NAME);
        assertThat(item.quality).isEqualTo(0);
        assertThat(item.sellIn).isEqualTo(-1);
    }

    @Test
    @DisplayName("Concert passes should drop quality to zero if sellIn is less than zero.")
    void shouldDropQualityToZeroIfSellInIsLessThan0() {
        Item item = new ConcertPassItem(CONCERT_PASS_NAME, -10, 20);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CONCERT_PASS_NAME);
        assertThat(item.quality).isEqualTo(0);
        assertThat(item.sellIn).isEqualTo(-11);
    }

    @Test
    void shouldNeverExceed50InQuality() {
        Item item = new ConcertPassItem(CONCERT_PASS_NAME, 1, 49);
        GildedRoseInn gildedRose = new GildedRoseInn(new Item[]{item});

        gildedRose.openNextDay();

        assertThat(item.name).isEqualTo(CONCERT_PASS_NAME);
        assertThat(item.quality).isEqualTo(50);
        assertThat(item.sellIn).isEqualTo(0);
    }
}
