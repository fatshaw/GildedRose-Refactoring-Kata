package com.gildedrose.processor

import com.gildedrose.ItemData

class AgedBrieProcessor : NormalProcessor() {
    override fun updateQuality(item: ItemData) {
        item.increaseQuality()
    }
}