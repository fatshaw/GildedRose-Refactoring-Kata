package com.gildedrose.processor

import com.gildedrose.ItemData

class ConjuredProcessor : NormalProcessor() {
    override fun updateQuality(item: ItemData) {
        for (i in 1..2) {
            item.degradeQuality()
        }
    }
}