require 'spec_helper.rb'

module Dependencies

  describe Dependency do

    it "should initialize with a name" do
      dep = Dependency.new('ABC')
      dep.name.should == 'A'
    end

    it "should be in global dependencies hash" do
      Dependencies::Dependency.new('ABC')
      $dependencies.has_key?('A').should be_true
    end

    it "should have dependency names" do
      dep = Dependencies::Dependency.new('ABC')
      dep.dependency_names.should == 'BC'
    end

    it "should not have duplicate dependency names" do
      dep = Dependencies::Dependency.new('ABBBB')
      dep.dependency_names.should == 'B'
    end
  end
  
  describe ""
end
