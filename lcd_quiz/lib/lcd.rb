  class Lcd

    def initialize(digit_string, size = 2)
      @digits = []
      digit_string.each_char do |c|
        @digits << Digit.new(c.to_i, size)
      end
    end

    def lines(i)
      line = ''
      @digits.each do |d|
        line += d.lines[i]
      end
      line
    end

    def to_s
      s = ''
      (0..@digits[0].lines.length - 1).each do |l|
        s << lines(l) << "\n"
      end
      s
    end
  end

