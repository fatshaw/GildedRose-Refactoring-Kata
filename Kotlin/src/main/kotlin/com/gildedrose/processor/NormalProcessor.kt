package com.gildedrose.processor

open class NormalProcessor : Processor {
    override fun process(item: ItemProcess) {
        updateQuality(item)
        getOlder(item)
        if (item.isExpired()) {
            updateQuality(item)
        }
    }

    open fun getOlder(item: ItemProcess) {
        item.getOlder()
    }

    open fun updateQuality(item: ItemProcess) {
        item.degradeQuality()
    }
}