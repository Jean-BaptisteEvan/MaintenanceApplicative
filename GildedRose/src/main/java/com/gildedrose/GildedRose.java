package com.gildedrose;

import java.util.Objects;

class GildedRose {
    public static final String BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            handleItems(item);
        }
    }

    public void handleItems(Item item){
        switch (item.name) {
            case BRIE:
                handleBrie(item);
                break;
            case CONCERT:
                handleConcert(item);
                break;
            case SULFURAS:
                //Nothing Happen
                break;
            default:
                handleOthers(item);
                break;
            }
    }

    public void handleBrie(Item item){
        item.sellIn = item.sellIn - 1;
        if (item.quality < 50 && item.sellIn < 0) {
            item.quality = item.quality + 2;
        } else if (item.quality < 50 ) {
            item.quality = item.quality + 1;
        }
    }

    public void handleConcert(Item item){
        if (item.quality < 50 && item.sellIn >= 0) {
            item.quality++;

            if (item.sellIn < 11) {
                item.quality++;
            }

            if (item.sellIn < 6) {
                item.quality++;
            }
        } else if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    public void handleOthers(Item item){
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality > 0) {
                item.quality = item.quality - 1;
        }
    }
}
