const SulfurasItem = require('./sulfuras_item');

const AgedBrieItem = require('./aged_brie_item');

const BackstageItem = require('./backstage_item');

const ConjuredItem = require('./conjured_item');

const NormalItem = require('./normal_item');
const Item = require('./item.js')


const itemMap = new Map([
    ['Sulfuras', SulfurasItem],
    ['AgedBrie', AgedBrieItem],
    ['Backstage', BackstageItem],
    ['Conjured', ConjuredItem],
    ['Normal', NormalItem]
])

module.exports = class ItemFactory {
    static create(itemName, sellIn, quality) {
        const itemClass = itemMap.get(itemName)
        return itemClass ?
            new itemClass(itemName, sellIn, quality) :
            new Item(itemName, sellIn, quality)
    }
}