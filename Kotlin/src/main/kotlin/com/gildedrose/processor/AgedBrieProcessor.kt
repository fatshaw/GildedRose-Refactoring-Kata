package com.gildedrose.processor

class AgedBrieProcessor : NormalProcessor() {
    override fun updateQuality(item: ItemProcess) {
        item.increaseQuality()
    }
}