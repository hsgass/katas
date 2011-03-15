class Dependencies

  def initialize
    @dependency_hash = {}
  end

  def add(dependency_string)
    deps = get_internal dependency_string[0]
    length = dependency_string.length
    if length > 1
      [1..length].each do |i|
        add(dependency_string[i])
      end
      dependency_string[1..length].each_char do |c|
        deps << c
      end
    end
  end

  def get_deps(name)
    deps = get_internal name
    deps.each do |dep|
      deps.concat get_internal dep
    end
    deps.sort!.uniq!
    deps.join
  end

  def get_internal(name)
    deps = @dependency_hash[name]
    if (!deps)
      deps = []
      @dependency_hash[name] = deps
    end
    deps
  end

end

