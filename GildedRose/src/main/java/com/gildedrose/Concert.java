package com.gildedrose;

public class Concert extends BetterItem{
    public Concert(int sellIn, int quality) {
        super(GildedRose.CONCERT, sellIn, quality);
    }

    @Override
    void updateQuality() {
        sellIn = sellIn - 1;
        if (quality < 50 && sellIn >= 0) {
            quality++;

            if (sellIn < 11) quality++;

            if (sellIn < 6) quality++;
        } else if (sellIn < 0) {
            quality = 0;
        }
    }
}
