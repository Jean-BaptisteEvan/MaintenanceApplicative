package com.gildedrose;

public class Brie extends BetterItem {
    public Brie(int sellIn, int quality) {
        super(GildedRose.BRIE, sellIn, quality);
    }

    @Override
    void updateQuality() {
        sellIn = sellIn - 1;
        if (quality < 50 && sellIn < 0) {
            quality = quality + 2;
        } else if (quality < 50 ) {
            quality = quality + 1;
        }
    }
}
