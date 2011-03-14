class Dependencies

  attr_reader :things


  def initialize
    @things = Hash.new
  end


  def new_thing(dependency_string)
    thing = get_thing(dependency_string[0])

    dependency_string[1..dependency_string.length].each_char do |char|
      thing.add_dependency get_thing char
    end
  end


  def get_thing(name)
    dep = @things[name]
    if (!dep)
      dep = Thing.new name
      @things[name] = dep
    end
    dep
  end
end


class Thing
  require 'set'
  require 'logger'
  attr_reader :name
  attr_reader :children

  def initialize(name)
    @children = SortedSet.new
    @parents = SortedSet.new
    @name = name
  end

  def dependency_names()
    names = ''
    @children.each do |c|
      names << c.name
      c.children.each { |cc| names << cc.name }
    end
    names
  end

  def add_dependency(thing)
    @children << thing
  end

  def eql?(other)
    name.eql? other.name
  end

  def <=>(other)
    name <=> other.name
  end

  def hash
    @name.hash
  end
end
