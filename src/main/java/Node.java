public class Node {

    private double weight;
    private int level, profit, bound;

    /**
     * Method gets level of Node
     *
     * @return int level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Method sets level of Node
     *
     * @param level int
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Method gets profit of Node
     *
     * @return int profit
     */
    public int getProfit() {
        return profit;
    }

    /**
     * Method sets profit of Node
     *
     * @param profit int
     */
    public void setProfit(int profit) {
        this.profit = profit;
    }

    /**
     * Method gets bound of Node
     *
     * @return int bound
     */
    public int getBound() {
        return bound;
    }

    /**
     * Method sets bound of Node
     *
     * @param bound int
     */
    public void setBound(int bound) {
        this.bound = bound;
    }

    /**
     * Method gets weight of Node
     *
     * @return double weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Method sets weight of Node
     *
     * @param weight double
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
