class Shop {
  constructor(items = []) {
    this.items = items;
  }
  updateQuality() {

    this.items.forEach(function (item) {
      if (item.name != 'Sulfuras, Hand of Ragnaros') {
        item.sellIn = item.sellIn - 1;
      }

      item.updateQuality();
    })

    return this.items;
  }
}
