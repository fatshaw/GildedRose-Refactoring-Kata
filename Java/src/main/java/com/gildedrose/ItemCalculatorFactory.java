package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemCalculatorFactory {


    static Map<String, AbstractItemCalculator> itemCalculatorMap = new HashMap<>();

    static {
        itemCalculatorMap.put("Aged Brie", new AgedBrieItemCalculator());
        itemCalculatorMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesItemCalculator());
        itemCalculatorMap.put("Conjured", new ConjuredItemCalculator());
        itemCalculatorMap.put("Sulfuras, Hand of Ragnaros", new SulfurasItemCalculator());
    }

    public static AbstractItemCalculator create(Item item) {
        return itemCalculatorMap.get(item.getName()) == null ? new DefaultItemCalculator()
            : itemCalculatorMap.get(item.getName());
    }
}
