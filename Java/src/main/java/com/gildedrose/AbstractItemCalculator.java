package com.gildedrose;

import java.util.function.Consumer;

public abstract class AbstractItemCalculator implements Consumer<Item> {

    public void calc(Item item) {
        item.setSellIn(item.getSellIn() - 1);
        accept(item);
    }
}
