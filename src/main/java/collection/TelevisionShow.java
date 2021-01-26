package collection;

import java.util.Objects;

public class TelevisionShow {
    private double frequency;
    private Channel channel;
    private String name;

    public TelevisionShow(double frequency, Channel channel, String name) {
        this.frequency = frequency;
        this.channel = channel;
        this.name = name;
    }

    public double getFrequency() {
        return frequency;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " on " + channel + " at " + frequency + "Hz";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelevisionShow that = (TelevisionShow) o;
        return Double.compare(that.frequency, frequency) == 0 && channel == that.channel && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency, channel, name);
    }
}