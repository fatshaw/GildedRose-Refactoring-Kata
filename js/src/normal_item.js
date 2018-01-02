class NormalItem extends Item {
    updateQuality() {
        this.degradeQuality()
        if (this.sellIn < 0) {
            this.degradeQuality()
        }
    }
}