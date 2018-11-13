const Item = require('./item.js')


module.exports = class AgedBrieItem extends Item {
    handle() {
        this.sellIn = this.sellIn - 1;
        this.increaseQuality()
        if (this.sellIn < 0) {
            this.increaseQuality()
        }
    }
}