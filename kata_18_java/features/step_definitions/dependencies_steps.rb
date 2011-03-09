include_class 'com.gass.kata18.Dependencies'

Given /^the following dependencies are defined:$/ do |table|
  # table is a Cucumber::Ast::Table
  @dependencies = Dependencies.new
    @dependencies.add(table.rows)
end

When /^I test the dependencies for "([^"]*)"$/ do |thing_name|
  @dep = @dependencies.get thing_name
end

Then /^I should get "([^"]*)"$/ do |dep|
  @dep.should == dep
end
