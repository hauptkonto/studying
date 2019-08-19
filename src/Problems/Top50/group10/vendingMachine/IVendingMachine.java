package Problems.Top50.group10.vendingMachine;

public interface IVendingMachine {
    /**
     * How does it work?
     * 1) Producs are displayed and the user selects one by
     * introducing an index.
     * 2) The user is requested to put coins. To do that,
     * coins are displated and an index is requested to identify the current coin.
     * As long as the value of the selected item is not met, the machine will keep
     * asking for coins.
     * 3) Once the amount of money is met, the change is
     * calculated, the purchased product is returned with the proper change. The
     * returned stuff should be printed on screen.
     * 4) Once all of this is finished, the process should start over.
     */

    // Step 1
    void ListProducts();
    void SelectItem(Product item);

    // Step 2
    void ListCurrency();
    boolean InsertCoin(Coin coin);

    // Step 3
    double CalculateChange();
    void PrintReturnedStuff();
}
