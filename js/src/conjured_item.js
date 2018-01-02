class ConjuredItem extends Item {
    updateQuality() {
        for (var i = 0; i < 2; i++) {
            this.degradeQuality()
            if (this.sellIn < 0) {
                this.degradeQuality()
            }
        }
    }
}