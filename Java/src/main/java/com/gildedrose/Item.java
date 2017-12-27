package com.gildedrose;

public class Item {

    public static final int MAX_QUALITY_VALUE = 50;
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void improveQuality() {
        if (quality < MAX_QUALITY_VALUE) {
            quality = quality + 1;
        }
    }

    public String getName() {
        return name;
    }


    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }


    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void degradeQuality() {
        quality -= quality > 0 ? 1 : 0;
        quality -= sellIn < 0 ? 1 : 0;
    }

    public int getQuatity() {
        return quality;
    }
}
