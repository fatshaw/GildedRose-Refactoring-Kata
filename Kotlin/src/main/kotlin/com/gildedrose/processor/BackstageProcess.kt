package com.gildedrose.processor

import com.gildedrose.ItemData

class BackstageProcess : NormalProcessor() {

    override fun updateQuality(item: ItemData) {
        item.increaseQuality()

        if (item.sellIn <= 10) {
            item.increaseQuality()
        }
        if (item.sellIn <= 5) {
            item.increaseQuality()
        }
        if (item.sellIn <= 0) {
            item.quality = 0
        }
    }
}