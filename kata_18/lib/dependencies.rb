module Dependencies

  $dependencies = Hash.new

  class Dependency
    attr_accessor :name

    def initialize(dependency_set)
      @dependency_names = Array.new
      
      dependency_set.each_char do |char|
        if (!@name)
          @name = char
        else
          add_dependency_name(char)
        end
      end
      $dependencies[@name] = self
    end

    def dependency_names()
      @dependency_names.join
    end

    def add_dependency_name(char)
       @dependency_names.push(char) unless @dependency_names.index(char)
    end
  end
end
