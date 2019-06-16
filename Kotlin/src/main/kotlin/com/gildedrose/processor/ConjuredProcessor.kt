package com.gildedrose.processor

class ConjuredProcessor : NormalProcessor() {
    override fun updateQuality(item: ItemProcess) {
        for (i in 1..2) {
            item.degradeQuality()
        }
    }
}