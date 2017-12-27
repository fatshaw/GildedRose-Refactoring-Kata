package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        Arrays.stream(items).forEach(item -> {

            decreaseItemSellin(item);

            calcItemQuantity(item);

            callQuantityForSellInByDate(item);

            checkQuantityLimit(item);

        });
    }

    private void calcItemQuantity(Item item) {
        List<Predicate<Item>> lists = new ArrayList<>();
        lists.add(i -> calcQuantityForAgedBrie(i));
        lists.add(i -> calcQuantityForBackstagePasses(i));
        lists.add(i -> calcQuantityForConjured(i));
        lists.add(i -> calcQuantityForSulfuras(i));
        lists.add(i -> calcQuantityForOthers(i));

        lists.stream().filter(i -> i.test(item)).findFirst();
    }

    private boolean calcQuantityForSulfuras(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality;
            return true;
        }
        return false;
    }

    private void callQuantityForSellInByDate(Item item) {
        if (isLegendaryItem(item) || isQuantityIncreaseItem(item)) {
            return;
        }

        if (item.sellIn < 0) {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else {
                item.quality -= 1;
            }
            if (item.name.equals("Conjured")) {
                item.quality -= 1;
            }
        }

    }

    private boolean calcQuantityForOthers(Item item) {
        item.quality = item.quality - 1;
        return true;
    }

    private boolean calcQuantityForAgedBrie(Item item) {
        if (item.name.equals("Aged Brie")) {
            item.quality = item.quality + 1;
            return true;
        }
        return false;
    }

    private boolean calcQuantityForConjured(Item item) {
        if (item.name.equals("Conjured")) {
            item.quality -= 2;
            return true;
        }
        return false;
    }

    private boolean calcQuantityForBackstagePasses(Item item) {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return false;
        }
        item.quality += 1;
        if (item.sellIn <= 10) {
            item.quality += 1;
        }
        if (item.sellIn <= 5) {
            item.quality += 1;
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
        }
        return true;
    }

    private boolean isLegendaryItem(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isQuantityIncreaseItem(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void checkQuantityLimit(Item item) {
        item.quality = item.quality > 50 ? 50 : item.quality;
        item.quality = item.quality <= 0 ? 0 : item.quality;

    }

    private void decreaseItemSellin(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }
}