package Problems.Top50.group10.vendingMachine;


public enum Coin {
    PENNY(0.01), NICKLE(0.05), DIME(0.10), QUARTER(0.25);

    private double value;

    private Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static Coin doubleToCoin(Double val) {
        for (int i = 0; i < Coin.values().length; i++) {
            if (val.equals(Coin.values()[i].getValue())) {
                return Coin.values()[i];
            }
        }
        return null;
    }

    public static Coin getByIndex(int index) {
        if (index < Coin.values().length) {
            return Coin.values()[index];
        } else {
            return null;
        }
    }
}