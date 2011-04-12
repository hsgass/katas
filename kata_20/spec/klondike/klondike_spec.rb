require 'spec_helper'

module Klondike

  describe Card do

    it "should retain its suit" do
      c = Klondike::Card.new('A', Klondike::SPADE)
      c.suit.should == Klondike::SPADE
    end

    it "should retain its rank" do
      c = Klondike::Card.new 'A', Klondike::SPADE
      c.rank.should == 'A'
    end

    it "should determine if it is the next tableau card" do
      t = Klondike::Card.new '13', Klondike::SPADE
      n = Klondike::Card.new '12', Klondike::HEART
      (n.next_tableau?(t)).should be_true

      t = Klondike::Card.new '13', Klondike::SPADE
      n = Klondike::Card.new '12', Klondike::SPADE
      (n.next_tableau?(t)).should be_false

      t = Klondike::Card.new '11', Klondike::SPADE
      n = Klondike::Card.new '11', Klondike::HEART
      (n.next_tableau?(t)).should be_false
    end

    it "should determine if it is the next foundation card" do
      f = Klondike::Card.new '1', Klondike::SPADE
      n = Klondike::Card.new '2', Klondike::SPADE
      (n.next_foundation?(f)).should be_true

      f = Klondike::Card.new '2', Klondike::SPADE
      n = Klondike::Card.new '1', Klondike::SPADE
      (n.next_foundation?(f)).should be_false

      f = Klondike::Card.new '1', Klondike::CLUB
      n = Klondike::Card.new '2', Klondike::SPADE
      (n.next_foundation?(f)).should be_false
     end
  end

  describe Suit do

    it "should have a name" do
      Klondike::SPADE.name.should == :spade
    end

    it "a spade should be a spade" do
      Klondike::SPADE.should == Klondike::SPADE
    end

    it "should tell if another suit is the other color" do
      (Klondike::SPADE.opposite?(Klondike::HEART)).should be_true
    end
  end
end



