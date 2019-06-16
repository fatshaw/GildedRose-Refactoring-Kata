package com.gildedrose.processor

import com.gildedrose.ItemData

interface Processor {
    fun process(item: ItemData)
}