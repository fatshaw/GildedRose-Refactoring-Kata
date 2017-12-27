package com.gildedrose;

public class BackstagePassesItemCalculator extends AbstractItemCalculator {


    @Override
    public void accept(Item item) {
        item.improveQuality();
        if (item.getSellIn() <= 10) {
            item.improveQuality();
        }
        if (item.getSellIn() <= 5) {
            item.improveQuality();
        }
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }

}
