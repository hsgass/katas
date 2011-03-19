require 'spec_helper.rb'

describe Lcd do

  it "should create 12345 at size 1" do
    lcd = Lcd.new('12345', 1)

    lcd.lines(0).should == '     -   -       -  '
    lcd.lines(1).should == '  |   |   | | | |   '
    lcd.lines(2).should == '     -   -   -   -  '
    lcd.lines(3).should == '  | |     |   |   | '
    lcd.lines(4).should == '     -   -       -  '
  end

end
