package com.gildedrose.processor

import com.gildedrose.ItemData
import com.gildedrose.ItemName.AGED_BRIE
import com.gildedrose.ItemName.BACKSTAGE
import com.gildedrose.ItemName.CONJURED
import com.gildedrose.ItemName.SULFURAS


class ProcessorFactory {


    companion object {

        private val processorMap = mapOf(
                AGED_BRIE to AgedBrieProcessor(),
                BACKSTAGE to BackstageProcess(),
                SULFURAS to SulfurasProcessor(),
                CONJURED to ConjuredProcessor()
        )

        fun createProcessor(item: ItemData) = processorMap[item.name] ?: NormalProcessor()
    }
}
