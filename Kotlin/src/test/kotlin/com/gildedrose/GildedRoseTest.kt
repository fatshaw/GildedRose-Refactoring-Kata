package com.gildedrose

import com.gildedrose.ItemName.AGED_BRIE
import com.gildedrose.ItemName.BACKSTAGE
import com.gildedrose.ItemName.CONJURED
import com.gildedrose.ItemName.SULFURAS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private const val FOO_NAME = "foo"

class GildedRoseTest {

    @Test
    fun item_name_should_never_change_when_get_older() {
        val items = arrayOf(Item(FOO_NAME, 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(FOO_NAME, app.items[0].name)
    }

    @Test
    fun normal_item_should_decrease_sellin_when_get_older() {
        val items = arrayOf(Item(FOO_NAME, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun normal_item_should_decrease_quality_when_get_older() {
        val items = arrayOf(Item(FOO_NAME, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun normal_item_should_decrease_quality_twice_when_sell_by_date() {
        val items = arrayOf(Item(FOO_NAME, 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun normal_item_should_never_be_negative() {
        val items = arrayOf(Item(FOO_NAME, 1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun aged_briel_should_increase_quality_when_get_older() {
        val items = arrayOf(Item(AGED_BRIE, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun aged_briel_should_increase_twice_quality_when_sell_by_date() {
        val items = arrayOf(Item(AGED_BRIE, 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun aged_briel_quality_never_more_than_50_when_get_older() {
        val items = arrayOf(Item(AGED_BRIE, 10, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun aged_briel_should_decrease_sellin_when_get_older() {
        val items = arrayOf(Item(AGED_BRIE, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun backstage_should_increase_quality_by_2_when_sellin_less_or_equal_10() {
        val items = arrayOf(Item(BACKSTAGE, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun backstage_should_increase_quality_by_3_when_sellin_less_or_equal_5() {
        val items = arrayOf(Item(BACKSTAGE, 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun backstage_quality_should_never_more_than_50_when_get_older() {
        val items = arrayOf(Item(BACKSTAGE, 5, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstage_quality_should_be_0_when_after_the_concert() {
        val items = arrayOf(Item(BACKSTAGE, 0, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun conjured_quality_should_decrease_twice_as_normal_when_get_older() {
        val items = arrayOf(Item(CONJURED, 2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun conjured_quality_should_decrease_twice_as_normal_when_sell_by_date() {
        val items = arrayOf(Item(CONJURED, 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun conjured_quality_should_never_be_negative_when_get_older() {
        val items = arrayOf(Item(CONJURED, 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun sulfuras_never_get_old_and_degrade_quality() {
        val items = arrayOf(Item(SULFURAS, 1, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)
        assertEquals(1, app.items[0].sellIn)

    }

}


