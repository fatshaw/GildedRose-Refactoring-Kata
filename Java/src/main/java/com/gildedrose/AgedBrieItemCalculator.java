package com.gildedrose;

public class AgedBrieItemCalculator extends AbstractItemCalculator {

    @Override
    public void accept(Item item) {
        item.improveQuality();
    }

}
