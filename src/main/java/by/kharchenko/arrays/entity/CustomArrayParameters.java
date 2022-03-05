package by.kharchenko.arrays.entity;

import java.util.Objects;

public class CustomArrayParameters {

    private int min;
    private int max;
    private int sum;
    private double average;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayParameters that = (CustomArrayParameters) o;
        return min == that.min && max == that.max && sum == that.sum && Double.compare(that.average, average) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, sum, average);
    }

    @Override
    public String toString() {
        return "min=" + min +
                ", max=" + max +
                ", sum=" + sum +
                ", average=" + average;
    }
}
