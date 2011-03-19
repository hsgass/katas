class Digit

  attr_reader :lines

  @@patterns = {:L => '|  ',
                :R => '  |',
                :B => '| |',
                :C => ' - ',
                :N => '   '
  }


  @@digits = [
    [:C, :B, :N, :B, :C],
    [:N, :R, :N, :R, :N],
    [:C, :R, :C, :L, :C],
    [:C, :R, :C, :R, :C],
    [:N, :B, :C, :R, :N],
    [:C, :L, :C, :R, :C],
    [:C, :L, :C, :B, :C],
    [:C, :R, :N, :R, :N],
    [:C, :B, :C, :B, :C],
    [:C, :B, :C, :R, :C]
  ]

  def initialize(digit, size)
    @size = size
    @lines = Array.new
    create_digit digit
  end

  def create_digit(digit)
    @@digits[digit].each do |d|
      create_line @@patterns[d]
    end
  end

  def create_line(pattern)
    line = pattern[0]
    @size.times { line << pattern[1] }
    line << pattern[2] << ' '

    if (line.index '|')
      @size.times { @lines << line }
    else
      @lines << line
    end
  end
end
