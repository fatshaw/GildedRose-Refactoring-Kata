package com.gildedrose


class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items = items.map { item ->
            ItemData(name = item.name, quality = item.quality, sellIn = item.sellIn).let { itemData ->
                itemData.process()
                Item(name = itemData.name, quality = itemData.quality, sellIn = itemData.sellIn)
            }
        }.toTypedArray()
    }

}


