package com.gildedrose.processor

import com.gildedrose.ItemData

open class NormalProcessor : Processor {
    override fun process(item: ItemData) {
        updateQuality(item)
        getOlder(item)
        if (item.isExpired()) {
            updateQuality(item)
        }
    }

    open fun getOlder(item: ItemData) {
        item.getOlder()
    }

    open fun updateQuality(item: ItemData) {
        item.degradeQuality()
    }
}