import java.util.*;


public class Knapsack {

    Queue<Node> Q = new LinkedList<Node>();
    Node u = new Node();
    Node v = new Node();
    ArrayList<Item> output = new ArrayList<Item>();
    private double W;
    private int n;
    private int maxProfit;

    /**
     * Constructor for knapsack
     *
     * @param items items to use in knapsack analysis
     * @param maxWeight max weight of Knapsack object
     */
    public Knapsack(ArrayList<Item> items, double maxWeight) {

        // Sorting test with implemented Comparable
        ArrayList<Item> i = new ArrayList<Item>();
        for (Item item : items) {
            i.add(item);
        }
        Collections.sort(i);
        n = items.size();
        W = maxWeight;

        maxProfit = knapsack(i);

    }

    /**
     * Knapsack algorithm using greedy method, backtracking, and branch and bound. I need to revisit and clean up the tracking portion of the output result.
     *
     * @param items items to use in knapsack analysis
     * @return
     */
    public int knapsack(ArrayList<Item> items) {

        // Initial node creation
        u.setLevel(-1);
        u.setProfit(0);
        u.setWeight(0);

        // Put node in queue (LinkedList) to start
        Q.add(u);

        while (!Q.isEmpty()) {

            // Pop front element
            u = Q.remove();

            // Initialize Node v at start
            if (u.getLevel() == -1) {
                v.setLevel(0);
            }

            // Index and bound check
            if (u.getLevel() == n - 1) {
                continue;
            }

            // Go one level into branhc
            v.setLevel(u.getLevel() + 1);

            // Set Node v attributes
            v.setWeight(u.getWeight() + items.get(v.getLevel()).getWeight());
            v.setProfit(u.getProfit() + items.get(v.getLevel()).getValue());

            // Add in value if it does not exceed weight and is greater than existing max profit
            if (v.getWeight() <= W && v.getProfit() > maxProfit) {
                output.add(items.get(v.getLevel()));
                maxProfit += v.getProfit();
            }

            // Visit subtree output
            v.setBound(boundFunc(v, W, items));

            // If this subtree works, try it out and add to queue
            if (v.getBound() > maxProfit) {
                output.add(items.get(v.getLevel()));
                Q.add(v);
            }

            // Set next Node v
            v.setWeight(u.getWeight());
            v.setProfit(u.getProfit());
            v.setBound(boundFunc(v, W, items));
            if (v.getBound() > maxProfit)
                output.add(items.get(v.getLevel()));
            Q.add(v);
        }

        return maxProfit;

    }

    /**
     * Method finds the bound of profit in a subtree rooted at Node u
     *
     * @param x input Node
     * @param maxWeight max weight of knapsack
     * @param items ArrayList of items
     * @return int bound of profit in subtree
     */
    public int boundFunc(Node x, double maxWeight, ArrayList<Item> items) {

        if (x.getWeight() >= maxWeight) {
            return 0;
        }

        int profitBound = u.getProfit();

        int j = u.getLevel() + 1;
        double totalWeight = u.getWeight();

        while ((j < n) && (totalWeight + items.get(j).getWeight() <= W)) {
            totalWeight += items.get(j).getWeight();
            profitBound += items.get(j).getValue();
            j++;
        }

        if (j < n) {
            profitBound += (W - totalWeight) * items.get(j).getValue() / items.get(j).getWeight();
        }

        return profitBound;
    }

    /**
     * Method returns max value attainable in the knapsack
     *
     * @return int maxProfit
     */
    public int getMaxProfit() {
        return maxProfit;
    }

    /**
     * Method returns a no duplicate record of unique items to take in knapsack
     *
     * @return items
     */
    public Set<Item> getOutput() {
        Set<Item> q = new LinkedHashSet<Item>(output);  // Temporary method only works with unique items. Fix later
        return q;
    }

}
