require 'spec_helper.rb'

  describe Thing do
    it "should initialize with a name" do
      thing = Thing.new('A')
      thing.name.should == 'A'
    end

    it "should accept new dependencies" do
      thing = Thing.new('A')
      thing.add_dependency Thing.new 'B'
      thing.dependency_names.should == 'B'
    end

    it "should not have duplicate dependency names" do
      thing = Thing.new('A')
      thing.add_dependency Thing.new 'B'
      thing.add_dependency Thing.new 'B'
      thing.dependency_names.should == 'B'
    end

    it "should find dependencies of dependencies" do
      thing_b = Thing.new('B')
      thing_b.add_dependency Thing.new('C')
      thing_a = Thing.new('A')
      thing_a.add_dependency thing_b
      thing_a.dependency_names.should == 'BC'
    end
  end
