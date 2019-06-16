package com.gildedrose

import com.gildedrose.processor.ProcessorFactory

class ItemData(
        var name: String, var sellIn: Int, var quality: Int
) {

    inline fun degradeQuality() {
        if (quality > MIN_QUALITY) quality -= 1
    }


    inline fun increaseQuality() {
        if (quality < Companion.MAX_QUALITY) quality += 1
    }


    inline fun getOlder() {
        sellIn -= 1
    }

    inline fun isExpired(): Boolean = sellIn < MIN_SELLIN


    inline fun process(): ItemData {
        ProcessorFactory.createProcessor(this).process(this)
        return this
    }

    companion object {
        const val MAX_QUALITY = 50
        const val MIN_QUALITY = 0
        const val MIN_SELLIN = 0
    }
}