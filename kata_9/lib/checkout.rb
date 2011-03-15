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
  require 'logger'
  attr_accessor :name, :price, :special_qty, :special_price

  def initialize(name, price, special_qty, special_price)
    @name = name
    @price = price
    @special_qty = special_qty
    @special_price = special_price
    @log = Logger.new STDOUT
  end

  def price(qty)
    p = 0
    if @special_qty && @special_qty > 0
      if qty.fdiv(@special_qty) >= 1
        p = (qty / @special_qty) * @special_price
        p += (qty % @special_qty) * @price
      else
        p += qty * @price
      end
    end
    p
  end
end
