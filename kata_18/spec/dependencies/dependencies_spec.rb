require 'spec_helper.rb'

describe Dependencies do
  it "should create a thing" do
    dependencies = Dependencies.new
    dependencies.new_thing 'AB'
    thing = dependencies.things.values[0]
    thing.name.should == 'A'
  end

  it "should create a thing's dependencies" do
    dependencies = Dependencies.new
    dependencies.new_thing 'ABCD'
    thing = dependencies.things.values[0]
    thing.dependency_names.should == 'BCD'
  end
end
