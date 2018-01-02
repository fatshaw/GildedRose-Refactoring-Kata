
class AgedBrieItem extends Item {

    updateQuality() {
        this.improveQuality()
        if (this.sellIn < 0) {
            this.improveQuality();
        }
    }
}