public class Node {

    private int level, profit, bound;
    private static double weight;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getLevel() {
        return level;
    }

    public int getProfit() {
        return profit;
    }

    public int getBound() {
        return bound;
    }

    public double getWeight() {
        return weight;
    }
}
