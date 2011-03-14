require 'spec_helper.rb'

  describe Thing do
    it "should initialize with correct name" do
      thing = Thing.new('A')
      thing.name.should eql 'A'
    end

    it "should accept new dependencies" do
      thing = Thing.new('A')
      thing.add_dependency Thing.new 'B'
      thing.dependency_names.should eql 'B'
    end

    it "should accept five new dependencies" do
      thing = Thing.new('A')
      %w[B C D E F].each do |n|
        thing.add_dependency Thing.new n
      end
      thing.dependency_names.should eql 'BCDEF'
    end

    it "should not have duplicate dependency names" do
      thing = Thing.new('A')
      thing.add_dependency Thing.new 'B'
      thing.add_dependency Thing.new 'B'
      thing.dependency_names.should eql 'B'
    end

    it "should find dependencies of dependencies" do
      thing_b = Thing.new('B')
      thing_b.add_dependency Thing.new('C')
      thing_a = Thing.new('A')
      thing_a.add_dependency thing_b
      thing_a.dependency_names.should eql 'BC'
    end

    it "should make B equal B" do
      b = "B"
      another_b = "B"
      b.should equal another_b
    end
  end
