package Problems.Top50.group10.vendingMachine;

public enum Product {
    COKE(0.30, "Coke"), PEPSI(0.25, "Pepsi"), FANTA(0.2, "Fanta"), WATER(0.15, "Water");

    double price;
    String description;

    private Product(double price, String description) {
        this.price = price;
        this.description = description;
    }

    public double GetPrice() {
        return price;
    }

    public String GetDescription() {
        return description;
    }

    public static Product GetByIndex(int index) {
        if (index < Product.values().length) {
            return Product.values()[index];
        } else {
            return null;
        }
    }
}
