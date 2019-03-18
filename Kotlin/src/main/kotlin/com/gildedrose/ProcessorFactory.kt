package com.gildedrose

import com.gildedrose.ItemName.AGED_BRIE
import com.gildedrose.ItemName.BACKSTAGE
import com.gildedrose.ItemName.CONJURED
import com.gildedrose.ItemName.SULFURAS

interface Processor {
    fun process(item: Item)
}

open class NormalProcessor : Processor {
    override fun process(item: Item) {
        updateQuality(item)
        getOlder(item)
        if (item.isExpired()) {
            updateQuality(item)
        }
    }

    open fun getOlder(item: Item) {
        item.getOlder()
    }

    open fun updateQuality(item: Item) {
        item.degradeQuality()
    }
}

class AgedBrieProcessor : NormalProcessor() {
    override fun updateQuality(item: Item) {
        item.increaseQuality()
    }
}


class BackstageProcess : NormalProcessor() {

    override fun updateQuality(item: Item) {
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


class ConjuredProcessor : NormalProcessor() {
    override fun updateQuality(item: Item) {
        for (i in 1..2) {
            item.degradeQuality()
        }
    }
}


class SulfurasProcessor : Processor {
    override fun process(item: Item) {}
}


class ProcessorFactory {


    companion object {

        private val processorMap = mapOf(
                AGED_BRIE to AgedBrieProcessor(),
                BACKSTAGE to BackstageProcess(),
                SULFURAS to SulfurasProcessor(),
                CONJURED to ConjuredProcessor()
        )

        fun createProcessor(item: Item) = processorMap[item.name] ?: NormalProcessor()
    }
}
