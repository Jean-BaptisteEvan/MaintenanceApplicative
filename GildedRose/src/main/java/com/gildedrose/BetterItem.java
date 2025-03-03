package com.gildedrose;

public abstract class BetterItem extends Item {

    public BetterItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    abstract void updateQuality();
}
