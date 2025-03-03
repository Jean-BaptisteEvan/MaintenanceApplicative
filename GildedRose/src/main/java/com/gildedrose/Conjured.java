package com.gildedrose;

public class Conjured extends BetterItem {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
        if (quality > 0) {
            quality = quality - 2;
        }
        sellIn = sellIn - 1;
        if (sellIn < 0 && quality > 0) {
            quality = quality - 2;
        }
    }
}
