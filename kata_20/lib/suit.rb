module Klondike
  class Suit
    include Comparable
    attr_reader :name, :color

    def initialize(name, color)
      @name = name
      @color = color
    end

    def <=> other
      @name <=> other.name
    end

    def opposite? other
      @color != other.color
    end
  end
end
