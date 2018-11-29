public class Item implements Comparable {

    private double weight;
    private int value;

    /**
     * Constructor for item object
     * @param weight double
     * @param value int
     */
    public Item(double weight, int value){
        this.weight = weight;
        this.value = value;
    }

    /**
     * Implemented Comparable method to sort by ratio of value to weight
     * @param object Item
     * @return int Comparator value
     */
    public int compareTo(Object object) {
        Item otherItem = (Item) object;
        double thisRatio = (double) value/weight;
        double otherRatio = (double) otherItem.value/otherItem.weight;
        return Double.compare(thisRatio, otherRatio);
    }

    /**
     * Overridden method to print the details of the item
     * @return String contents of item
     */
    @Override
    public String toString(){
        return "{" + weight + ", " + value + "}";
    }

}
