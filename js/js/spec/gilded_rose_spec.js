
describe("Gilded Rose", function () {
  const DEFAULT_QUALITY = 10
  const DEFAULT_SELLIN = 20  
  const MAX_QUALITY = 50   
  const NORMAL_ITEM = 'Normal'
  const AGED_BRIE = 'AgedBrie'
  const SULFURAS = 'Sulfuras'
  const BACKSTAGE = 'Backstage'
  const CONJURED = 'Conjured'

  beforeEach(() => {
    console.log(123)
  })

  it("should Normal item name not change", function () {
    const gildedRose = new Shop([ItemFactory.create(NORMAL_ITEM, 0, 0)]);
    const items = gildedRose.updateQuality();
    expect(items[0].name).toEqual(NORMAL_ITEM);
  });

  it("should normal item sellIn -1", function () {
    const gildedRose = new Shop([ItemFactory.create(NORMAL_ITEM, DEFAULT_SELLIN, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].sellIn).toEqual(DEFAULT_SELLIN - 1);
  });

  it("should normal item quality -1", function () {
    const gildedRose = new Shop([ItemFactory.create(NORMAL_ITEM, DEFAULT_SELLIN, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY - 1);
  });

  it("Once the sell by date has passed, Quality degrades twice as fast", function () {
    const gildedRose = new Shop([ItemFactory.create(NORMAL_ITEM, 0, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY - 2);
  });

  it("Once the sell by date has passed, AGED_BRIE Quality increases twice as fast", function () {
    const gildedRose = new Shop([ItemFactory.create(AGED_BRIE, 0, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY + 2);
  });

  it("The Quality of an item is never negative", function () {
    const gildedRose = new Shop([ItemFactory.create(NORMAL_ITEM, 0, 0)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(0);
  });

  it("‘Aged Brie’ actually increases in Quality the older it gets", function () {
    const gildedRose = new Shop([ItemFactory.create(AGED_BRIE, DEFAULT_SELLIN, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY + 1);
  });

  it(" The Quality of an item is never more than 50", function () {
    const gildedRose = new Shop([ItemFactory.create(AGED_BRIE, DEFAULT_SELLIN, MAX_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(MAX_QUALITY);
  });

  it("Sulfuras never has to be sold or decreases in Quality", function () {
    const gildedRose = new Shop([ItemFactory.create(SULFURAS, DEFAULT_SELLIN, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY);
    expect(items[0].sellIn).toEqual(DEFAULT_SELLIN);
  });

  it("'Backstage passes', like aged brie, increases in Quality as its SellIn value approaches", function () {
    const gildedRose = new Shop([ItemFactory.create(BACKSTAGE, DEFAULT_SELLIN, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY + 1);
  });

  it("'Backstage passes' Quality increases by 2 when there are 6 - 10 days", function () {
    const gildedRose = new Shop([ItemFactory.create(BACKSTAGE, 6, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY + 2);
  });
  
  it("'Backstage passes' Quality increases by 3 when there are 1 - 5 days", function () {
    const gildedRose = new Shop([ItemFactory.create(BACKSTAGE, 5, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY + 3);
  });

  it("'Backstage passes' Quality drops to 0 after the concert", function () {
    const gildedRose = new Shop([ItemFactory.create(BACKSTAGE, 0, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(0);
  });

  it("'Conjured' items degrade in Quality twice as fast as normal items", function () {
    const gildedRose = new Shop([ItemFactory.create(CONJURED, DEFAULT_SELLIN, DEFAULT_QUALITY)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(DEFAULT_QUALITY - 2);
  });

  it("The Quality of an 'Conjured' item is never negative", function () {
    const gildedRose = new Shop([ItemFactory.create(CONJURED, 0, 1)]);
    const items = gildedRose.updateQuality();
    expect(items[0].quality).toEqual(0);
  });
});
