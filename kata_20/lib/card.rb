module Klondike
  class Card
    attr_reader :rank, :suit

    def initialize(rank, suit)
      @rank = rank
      @suit = suit
      @visible = false
    end

    def next_tableau?(other)
      other.rank.to_i - 1 == @rank.to_i &&
        other.suit.opposite?(@suit)
    end

    def next_foundation?(other)
      other.rank.to_i + 1 == @rank.to_i && other.suit == @suit
    end

    def visible?
     @visible
    end

    def flip
      @visible = true
    end
  end
end

