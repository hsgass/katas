
Given /^the following dependencies are defined:$/ do |table|
  # table is a Cucumber::Ast::Table
  @dependencies = Dependencies.new
  table.rows.each do |row|
    @dependencies.add row[0]
  end
end

When /^I test the dependencies for "([^"]*)"$/ do |thing_name|
  @dep = @dependencies.get_deps thing_name
end

Then /^I should get "([^"]*)"$/ do |dep|
  @dep.should == dep
end
