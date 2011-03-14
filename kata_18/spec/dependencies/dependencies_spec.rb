require 'spec_helper.rb'

describe Dependencies do
  it "should create a dependency" do
    dependencies = Dependencies.new
    dependencies.add 'AB'
    deps = dependencies.get_deps 'A'
    deps.should == 'B'
  end

  it "should create 2 dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'ABC'
    deps = dependencies.get_deps 'A'
    deps.should == 'BC'
  end

  it "should create 5 dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'ABC'
    dependencies.add 'CDE'
    dependencies.add 'EF'
    deps = dependencies.get_deps 'A'
    deps.should == 'BCDEF'
  end

  it "should add dependencies to dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'AB'
    dependencies.add 'BC'
    deps = dependencies.get_deps 'A'
    deps.should == 'BC'
  end

  it "should pick up backwards dependencies" do
    dependencies = Dependencies.new
    dependencies.add 'BC'
    dependencies.add 'CD'
    dependencies.add 'AB'
    deps = dependencies.get_deps 'A'
    deps.should == 'BCD'
  end
end
