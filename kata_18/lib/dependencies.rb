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
  attr_reader :name

  def initialize(name)
    @children = SortedSet.new
    @parents = SortedSet.new
    @name = name
  end

  def dependency_names()
    names = ''
    @children.each do |thing|
      names << thing.name
    end
    names
  end

  def add_dependency(thing)
    @children.add thing

  end

  def add_parent(thing)
    @parents.add(thing)
  end

  def <=>(other)
    name <=> other.name
  end
end
