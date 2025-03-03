package com.gildedrose;

public class Other extends BetterItem {

    public Other(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void updateQuality() {
        if (this.quality > 0) {
            this.quality--;
        }
        this.sellIn = this.sellIn - 1;
        if (this.sellIn < 0 && this.quality > 0) {
            this.quality--;
        }
    }
}
