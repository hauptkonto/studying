package Problems.Top50.group10.vendingMachine;


import java.util.HashMap;

public class Inventory<T> {
    private HashMap<T, Integer> content = new HashMap<T, Integer>();

    public Inventory() { }

    /**
     * Constructor that gets an initial set of items
     */
    public Inventory(T[] items) {
        for(T t : items) {
            addItem(t);
        }
    }

    /**
     * Constructor that uses an initial set of items with a given qty.
     */
    public Inventory(T[] items, int qty) {
        for(T t : items) {
            addItem(t, qty);
        }
    }

    /**
     * Adds 1 to the item quantity of the given item.
     */
    public void addItem(T item) {
        addItem(item, 1);
    }

    /**
     * Adds "qty" to the item quantity of the given item.
     */
    public void addItem(T item, int qty) {
        content.put(item, getQty(item) + qty);
    }

    /**
     * Removes an item. Returns true if succeeded, and false if there are no more
     * items in stock to be removed.
     */
    public boolean substractItem(T item) {
        int currentQty = getQty(item);
        currentQty--;
        if (currentQty >= 0) {
            content.put(item, currentQty);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the amount in stock of the given item.
     */
    public int getQty(T item) {
        Integer value = content.get(item);
        return value != null ? value : 0 ;
    }

    @Override
    public String toString() {
        String s = "";
        for(T t : content.keySet()) {
            s += content.get(t) + " x " + t.toString() + "\n";
        }
        return s;
    }
}
