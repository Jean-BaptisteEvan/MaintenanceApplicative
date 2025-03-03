package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        BetterItem[] items = new BetterItem[] { new Other("foo", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void cassoulet() {
        BetterItem[] items = new BetterItem[]{
                new Brie(5, 10),
                new Sulfuras(0, 80),
                new Concert(4, 1),
                new Other("Patate", 1, 1),
                new Other("Patate",0,0),
                new Concert(0, 10),
                new Brie(0, 10),
                new Concert(30, 50),
                new Concert(30, 40),
                new Brie(0, 50),

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(80, app.items[1].quality);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(4, app.items[2].quality);
        assertEquals(3, app.items[2].sellIn);
        assertEquals(0, app.items[3].quality);
        assertEquals(0, app.items[3].sellIn);
        assertEquals(0, app.items[4].quality);
        assertEquals(-1, app.items[4].sellIn);
        assertEquals(0, app.items[5].quality);
        assertEquals(-1, app.items[5].sellIn);
        assertEquals(12, app.items[6].quality);
        assertEquals(-1, app.items[6].sellIn);
        assertEquals(50, app.items[7].quality);
        assertEquals(29, app.items[7].sellIn);
        assertEquals(41, app.items[8].quality);
        assertEquals(29, app.items[8].sellIn);
    }

    @Test
    void conjured(){
        BetterItem[] items = new BetterItem[]{
                new Conjured(1, 8)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);
    }

    @Test
    void StringItem(){
        Item i = new Item("foo", 0, 2);
        assertEquals("foo, 0, 2",i.toString());
    }
}
