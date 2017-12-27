package com.gildedrose;

public class ConjuredItemCalculator extends AbstractItemCalculator {


    @Override
    public void accept(Item item) {
        for (int i = 0; i < 2; ++i) {
            item.degradeQuality();
        }
    }
}
