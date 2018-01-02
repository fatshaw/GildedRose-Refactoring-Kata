describe("Gilded Rose", function() {

  it("should foo", function() {
    const gildedRose = new Shop([ new NormalItem("foo", 0, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].name).toEqual("foo");
  });

});


describe("Gilded Rose", function() {

  it("should decrease sellin", function() {
    const gildedRose = new Shop([ new Item("foo", 1, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].sellIn).toEqual(0);
  });

});



describe("Gilded Rose", function() {

  it("should decrease quality", function() {
    const gildedRose = new Shop([ new NormalItem("foo", 1, 1) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(0);
  });

});



describe("Gilded Rose", function() {

  it("quality can never be negative", function() {
    const gildedRose = new Shop([ new NormalItem("foo", 0, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(0);
  });

});


describe("Gilded Rose", function() {

  it("sellin can be negative", function() {
    const gildedRose = new Shop([ new NormalItem("foo", 0, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].sellIn).toEqual(-1);
  });

});


describe("Gilded Rose", function() {

  it("should Aged Brie quality increase  when sellin > 0", function() {
    const gildedRose = new Shop([ new AgedBrieItem("Aged Brie", 1, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(1);
  });
});


describe("Gilded Rose", function() {

  it("should Aged Brie quality increase twice when sellinbydate", function() {
    const gildedRose = new Shop([ new AgedBrieItem("Aged Brie", 0, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(2);
  });
});


describe("Gilded Rose", function() {

  it("should Aged Brie quality never greater than 50", function() {
    const gildedRose = new Shop([ new AgedBrieItem("Aged Brie", 0, 49) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(50);
  });
});

describe("Gilded Rose", function() {

  it("should Sulfuras never change quality", function() {
    const gildedRose = new Shop([ new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 49) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(49);
  });
});

describe("Gilded Rose", function() {

  it("should Sulfuras never change sellin", function() {
    const gildedRose = new Shop([ new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 49) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].sellIn).toEqual(0);
  });
});


describe("Gilded Rose", function() {

  it("should Backstage passes increase quality by one when sellin > 10 ", function() {
    const gildedRose = new Shop([ new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 15, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(1);
  });
});


describe("Gilded Rose", function() {

  it("should Backstage passes increase quality by two when sellin <=10 ", function() {
    const gildedRose = new Shop([ new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(2);
  });
});



describe("Gilded Rose", function() {

  it("should Backstage passes increase quality by three when sellin <=5 ", function() {
    const gildedRose = new Shop([ new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(3);
  });
});


describe("Gilded Rose", function() {

  it("should Backstage passes quality drop to zero three when sellin <0", function() {
    const gildedRose = new Shop([ new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 0, 0) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(0);
  });
});


describe("Gilded Rose", function() {

  it("should Conjured drop quality twice as normal", function() {
    const gildedRose = new Shop([ new ConjuredItem("Conjured", 1, 5) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(3);
  });
});

describe("Gilded Rose", function() {

  it("should Conjured drop quality twice as normal when sellin by date", function() {
    const gildedRose = new Shop([ new ConjuredItem("Conjured", 0, 5) ]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(1);
  });
});
