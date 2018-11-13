const Item = require('./item.js')


module.exports = class ConjuredItem extends Item {
    handle() {
        this.sellIn = this.sellIn - 1;
        for (var i = 0; i < 2; i++) {
            this.decreaseQuality()
        }
    }
}
