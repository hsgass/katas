require 'spec_helper.rb'

describe Digit do

  it "should have 5 lines for size 1" do
    d = Digit.new 0, 1
    d.lines.length.should == 5
  end

  it "should have 7 lines for size 2" do
    d = Digit.new 0, 2
    d.lines.length.should == 7
  end

  it "should have 9 lines for size 3" do
    d = Digit.new 0, 3
    d.lines.length.should == 9
  end

  it "should create a 0 at size 1" do
    d = Digit.new 0, 1
    d.lines[0].should == ' -  '
    d.lines[1].should == '| | '
    d.lines[2].should == '    '
    d.lines[3].should == '| | '
    d.lines[4].should == ' -  '
  end

  it "should create a 0 at size 2" do
    d = Digit.new 0, 2
    d.lines[0].should == ' --  '
    d.lines[1].should == '|  | '
    d.lines[2].should == '|  | '
    d.lines[3].should == '     '
    d.lines[4].should == '|  | '
    d.lines[5].should == '|  | '
    d.lines[6].should == ' --  '
  end

  it "should create a 1 at size 1" do
    d = Digit.new 1, 1
    d.lines[0].should == '    '
    d.lines[1].should == '  | '
    d.lines[2].should == '    '
    d.lines[3].should == '  | '
    d.lines[4].should == '    '
  end

  it "should create a 2 at size 1" do
    d = Digit.new 2, 1
    d.lines[0].should == ' -  '
    d.lines[1].should == '  | '
    d.lines[2].should == ' -  '
    d.lines[3].should == '|   '
    d.lines[4].should == ' -  '
  end

  it "should create a 2 at size 2" do
    d = Digit.new 2, 2
    d.lines[0].should == ' --  '
    d.lines[1].should == '   | '
    d.lines[2].should == '   | '
    d.lines[3].should == ' --  '
    d.lines[4].should == '|    '
    d.lines[5].should == '|    '
    d.lines[6].should == ' --  '
  end
end
