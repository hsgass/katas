class Checkout

  def initialize(pricelist)
    @items = []
    @pricelist = pricelist
    @count_hash = {}
    pricelist.keys.each do |name|
      @count_hash[name] = 0
    end
  end

  def scan(item_string)
    item_string.each_char do |i|
      @items << i
    end
  end

  def total
    total = 0
    @count_hash.each do |k, v|
      total += @pricelist[k].price(v)
    end
    total
  end
end


class Item
  attr_accessor :name, :price, :special_qty, :special_price

  def initialize(name, price, special_qty, special_price)
    @name = name
    @price = price
    @special_qty = special_qty
    @special_price = special_price
  end

  def price(qty)
      if @special_qty && qty.fdiv(@special_qty) >= 1
        p = (qty / @special_qty) * @special_price
        p + (qty % @special_qty) * @price
      else
        qty * @price
      end
  end
end
