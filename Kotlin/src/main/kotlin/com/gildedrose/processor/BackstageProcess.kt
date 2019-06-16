package com.gildedrose.processor

class BackstageProcess : NormalProcessor() {

    override fun updateQuality(item: ItemProcess) {
        item.increaseQuality()

        if (item.sellIn <= 10) {
            item.increaseQuality()
        }
        if (item.sellIn <= 5) {
            item.increaseQuality()
        }
        if (item.sellIn <= 0) {
            item.setQuanlityToZero()
        }
    }
}