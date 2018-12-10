import java.util.ArrayList;


public class KnapsackTest {

    public static void main(String[] args) {

        //  Initialize knapsack of certain weight
        double maxWeight = 10.0;

        //  Initialize a list of items and the respective lists of associated weights and values
        ArrayList<Item> items = new ArrayList<Item>();

        double[] weights = {2, 3.14, 1.98, 5, 3};
        int[] values = {40, 50, 100, 95, 30};

        //  Here we add items with respective weights and values
        for (int i=0; i<weights.length; i++){
            Item newItem = new Item(weights[i], values[i]);
            items.add(newItem);
        }

        System.out.println("Items: " + items);
        Knapsack k = new Knapsack(items, maxWeight);
        System.out.println("Max value: " + k.getMaxProfit());
        System.out.println("Items to take: " + k.getOutput());
    }
}
