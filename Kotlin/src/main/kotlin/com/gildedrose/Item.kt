package com.gildedrose

data class Item(var name: String, var sellIn: Int, var quality: Int)


const val MAX_QUALITY = 50
const val MIN_QUALITY = 0

const val MIN_SELLIN = 0

inline fun Item.degradeQuality() {
    if (quality > MIN_QUALITY) quality -= 1
}


inline fun Item.increaseQuality() {
    if (quality < MAX_QUALITY) quality += 1
}


inline fun Item.getOlder() {
    sellIn -= 1
}

inline fun Item.isExpired(): Boolean = sellIn < MIN_SELLIN


inline fun Item.process() {
    ProcessorFactory.createProcessor(this).process(this)
}