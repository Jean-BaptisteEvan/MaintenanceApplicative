package com.gildedrose;

public class Conjured extends BetterItem {
    public Conjured(int sellIn, int quality) {
        super(GildedRose.CONJURED, sellIn, quality);
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
