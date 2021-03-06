require 'spec_helper.rb'

describe Dependencies do
  it "should create a dependency" do
    dependencies = Dependencies.new
    dependencies.add 'AB'
    dependencies.get_deps('A').should == 'B'
  end

  it "should create 2 dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'ABC'
    dependencies.get_deps('A').should == 'BC'
  end

  it "should create 5 dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'ABC'
    dependencies.add 'CDE'
    dependencies.add 'EF'
    dependencies.get_deps('A').should == 'BCDEF'
  end

  it "should add dependencies to dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'AB'
    dependencies.add 'BC'
    dependencies.get_deps('A').should == 'BC'
  end

  it "should pick up backwards dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'BC'
    dependencies.add 'CD'
    dependencies.add 'AB'
    dependencies.get_deps('A').should == 'BCD'
  end

  it "should handle indirect dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'BCE'
    dependencies.add 'CG'
    dependencies.add 'EF'
    dependencies.get_deps('C').should == 'EFG'
  end

  it "should handle multiple dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'BCE'
    dependencies.get_deps('B').should == 'CE'
    dependencies.get_deps('C').should == 'E'
  end
end
