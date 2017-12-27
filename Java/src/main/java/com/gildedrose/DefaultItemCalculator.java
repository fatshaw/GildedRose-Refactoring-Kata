package com.gildedrose;

public class DefaultItemCalculator extends AbstractItemCalculator {


    @Override
    public void accept(Item item) {
        item.degradeQuality();
    }

}
