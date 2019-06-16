package com.gildedrose.processor

import com.gildedrose.Item

class ItemProcess(
        name: String, sellIn: Int, quality: Int
) {

    var name: String = name
        private set

    var sellIn: Int = sellIn
        private set


    var quality: Int = quality
        private set


    fun degradeQuality() {
        if (quality > MIN_QUALITY) quality -= 1
    }

    fun increaseQuality() {
        if (quality < MAX_QUALITY) quality += 1
    }

    fun setQuanlityToZero() {
        quality = 0
    }

    fun getOlder() {
        sellIn -= 1
    }

    fun isExpired(): Boolean = sellIn < MIN_SELLIN

    fun process(): ItemProcess {
        ProcessorFactory.createProcessor(this).process(this)
        return this
    }

    fun toItem() = Item(name = name, quality = quality, sellIn = sellIn)

    companion object {
        const val MAX_QUALITY = 50
        const val MIN_QUALITY = 0
        const val MIN_SELLIN = 0
    }
}