class BackstagePassesItem extends Item {
    updateQuality() {
        this.improveQuality()
        if (this.sellIn < 10) {
            this.improveQuality()
        }
        if (this.sellIn < 5) {
            this.improveQuality()
        }
        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }

}