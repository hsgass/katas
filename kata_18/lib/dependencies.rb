class Dependencies

  require 'logger'

  def initialize
    @dependency_hash = {}
    @log = Logger.new STDOUT
  end

  def add(dependency_string)
    name = dependency_string[0]
    deps = get name
    if dependency_string.length > 1
      dependency_string[1..dependency_string.length].each_char do |c|
        deps << c
      end
    end
  end

  def get_deps(name)
    deps = get name
    deps.each do |dep|
      deps.concat get dep
    end
    deps.sort!.uniq!
    deps.join
  end

  def get(name)
    deps = @dependency_hash[name]
    if (!deps)
      deps = []
      @dependency_hash[name] = deps
    end
    deps
  end

end

