Given /^the following prices are defined:$/ do |table|
  @pricelist = {}
  table.hashes.each do |h|
    @pricelist[h[:item]] = Item.new(h[:price],
                                    h[:special_qty],
                                    h[:special_price])
  end
end

When /^I scan "([^"]*)"$/ do |items|
  @checkout = Checkout.new(@pricelist)
  @checkout.scan items
end

Then /^The total should be "([^"]*)"$/ do |total|
  @checkout.total.to_s.should == total
end
