package com.gildedrose;

class GildedRose {
    public static final String BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";
    BetterItem[] items;

    public GildedRose(BetterItem[] items) {
        this.items = items;
    }

    public void updateQuality(){
        for (BetterItem item : items) {
            item.updateQuality();
        }
    }
    /*
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
            case CONJURED:
                handleConjured(item);
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
        item.sellIn = item.sellIn - 1;
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

    public void handleConjured(Item item){
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 2;
        }
    }

    public void handleOthers(Item item){
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality > 0) {
                item.quality--;
        }
    }
    */
}
