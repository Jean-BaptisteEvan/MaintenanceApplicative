package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void cassoulet() {
        Item[] items = new Item[]{
                new Item(GildedRose.BRIE, 5, 10),
                new Item(GildedRose.SULFURAS, 0, 80),
                new Item(GildedRose.CONCERT, 4, 1),
                new Item("Patate", 1, 1),
                new Item("Patate",0,1),
                new Item(GildedRose.CONCERT, 0, 10),
                new Item(GildedRose.BRIE, 0, 10)
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
    }

}
