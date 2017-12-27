package com.gildedrose;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void should_decrease_quantity_and_sellin_when_sellin_gt_zero() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

    }

    @Test
    public void should_decrease_twice_quantity_and_sellIn_when_sellin_lt_zero() {
        Item[] items = new Item[]{new Item("foo", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

    }

    @Test
    public void should_increase_quantity_for_agedbrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void should_quantity_never_negative() {
        Item[] items = new Item[]{new Item("foo", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void should_quantity_never_gt_50() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void should_quantity_increase_for_backstage_passes() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void should_quantity_increase_two_for_backstage_passes() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void should_quantity_increase_three_for_backstage_passes() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void should_quantity_drop_to_zero_for_backstage_passes() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void should_quantity_drop_twice_fast_for_conjured() {
        Item[] items = new Item[]{new Item("Conjured", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void should_quantity_never_drop_for_sulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }

    @Test
    public void should_quantity_drop_twice_for_conjured() {
        Item[] items = new Item[]{new Item("Conjured", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

}
