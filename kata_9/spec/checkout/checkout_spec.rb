require 'spec_helper.rb'
require 'yaml'
require 'logger'

log = Logger.new STDOUT

pricelist = {
  'A' => Item.new('A', 50, 3, 130),
  'B' => Item.new('B', 30, 2, 45),
  'C' => Item.new('C', 20, nil, nil),
  'D' => Item.new('D', 15, nil, nil)
}


describe Checkout do

  it "should total 0 items as 0" do
    checkout = Checkout.new pricelist
    checkout.total.should == 0
  end

  it "should total 'A' as 50" do
    checkout = Checkout.new pricelist
    checkout.scan 'A'
    checkout.total.should == 50
  end

  it "should total 'AA' as 100" do
    checkout = Checkout.new pricelist
    checkout.scan 'AA'
    checkout.total.should == 100
  end

  it "should total 'AAA' as 130" do
    checkout = Checkout.new pricelist
    checkout.scan 'AAA'
    checkout.total.should == 130
  end
end


describe Item do
  it "should correctly calculate total for normal quantity" do
    item = Item.new('A', 50, 3, 130)
    item.price(2).should == 100
  end

  it "should correctly calculate total for special quantity" do
    item = Item.new('A', 50, 3, 130)
    item.price(3).should == 130
  end

  it "should correctly calculate total for more than special quantity" do
    item = Item.new('A', 50, 3, 130)
    item.price(4).should == 180
  end
end
