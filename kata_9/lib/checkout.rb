class Checkout

  def initialize(pricelist)
    @pricelist = pricelist
    @items = {}
    setup_item_hash
  end

  def setup_item_hash
    @pricelist.keys.each do |name|
      @items[name] = 0
    end
  end

  def scan(item_string)
    item_string.each_char do |i|
      @items[i] += 1
    end
  end

  def total
    total = 0
    @items.each do |name, count|
      total += @pricelist[name].ext_price(count)
    end
    total
  end
end


class Item
  attr_accessor :price, :special_qty, :special_price

  def initialize(price, special_qty, special_price)
    @price = price.to_i || 0
    @special_qty = special_qty.to_i || 0
    @special_price = special_price.to_i || 0
  end

  def ext_price(qty)
    if @special_qty > 0 && qty.fdiv(@special_qty) >= 1
      p = (qty / @special_qty) * @special_price
      p + (qty % @special_qty) * @price
    else
      qty * @price
    end
  end
end
