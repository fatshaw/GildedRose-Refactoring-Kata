package com.gildedrose

import com.gildedrose.processor.ItemProcess


class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items = items.map { item ->
            ItemProcess(name = item.name, quality = item.quality, sellIn = item.sellIn).let { itemData ->
                itemData.process().toItem()
            }
        }.toTypedArray()
    }

}


