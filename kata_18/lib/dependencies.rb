class Dependencies

  attr_reader :things

  def initialize
    @things = Hash.new
  end

  def new_thing(dependency_set)
    thing = get_thing(dependency_set[0])

    dependency_set[1..dependency_set.length].each_char do |char|
      thing.add_dependency get_thing char
    end
  end

  def get_thing(name)
    thing = @things[name]
    if (!thing)
      thing = Thing.new name
      @things[name] = thing
    end
    thing
  end
end


class Thing

  attr_reader :name

  def initialize(name)
    @things = Hash.new
    @name = name
  end

  def dependency_names()
    names = ''
    @things.values.each do |thing|
      names << thing.name
      names << thing.dependency_names
    end
    names
  end

  def add_dependency(thing)
    @things[thing.name] = thing
  end
end
