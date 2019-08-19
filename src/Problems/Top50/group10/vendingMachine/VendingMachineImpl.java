package Problems.Top50.group10.vendingMachine;


import java.util.Scanner;

public class VendingMachineImpl {
    private static final int INITIAL_QTY = 5;
    private Inventory<Coin> coinInv = new Inventory<Coin>(Coin.values(), INITIAL_QTY);
    private Inventory<Product> productInv = new Inventory<Product>(Product.values(), INITIAL_QTY);
    private double currentBalance = 0;
    private Scanner sc = new Scanner(System.in);

    public VendingMachineImpl() {
    }

    /**
     * Runs the vending Machine.
     */
    public void run() {
        while(true) {
            ListProducts();
            ListCurrency();
            InsertCoins();
            SelectProduct();
            System.out.println("\n\n\n");
        }
    }

    /**
     * Shows products available.
     */
    private void ListProducts() {
        System.out.println("Products");
        int index = 0;
        String products = "";
        for (Product p : Product.values()) {
            products += "[" + index + "]: $" + p.GetPrice() + " " + p.GetDescription() + "    ";
            index++;
        }
        PrintWithLine(products);
    }

    /**
     * Shows available currency.
     */
    private void ListCurrency() {
        System.out.println("\nInsert Coins");
        // Build the string with the information
        String coins = "";
        int size = Coin.values().length;
        for (int i = 0; i < size; i++) {
            coins += "[" + i + "]: $" + Coin.values()[i].getValue() + "      ";
        }
        PrintWithLine(coins);
    }

    /**
     * Prettier print.
     */
    private void PrintWithLine(String toPrint) {
        toPrint = "| " + toPrint.trim() + " |";
        // Build a line
        String line = "";
        for (int i = 0; i < toPrint.length(); i++) {
            line += "-";
        }
        System.out.println(line);
        System.out.println(toPrint);
        System.out.println(line);
    }

    /**
     * Takes coins from the user input.
     */
    private void InsertCoins() {
        System.out.println("Insert coins by typing the coin index and then hit enter." + " Type \"done\" to finish");
        String input = "";
        do {
            input = sc.nextLine();
            ParseAndAddCoin(input);
        } while (!input.equals("done"));
    }

    /**
     * Parses a given input and adds the corresponding coin to the inventory.
     */
    private void ParseAndAddCoin(String input) {
        try {
            if (input.equals("done")) {
                return;
            } else {
                int index = Integer.parseInt(input);
                Coin insertedCoin = Coin.getByIndex(index);
                if (insertedCoin != null) {
                    currentBalance += insertedCoin.getValue();
                    currentBalance = Math.round(currentBalance*100.0)/100.0;
                    coinInv.addItem(insertedCoin);
                    System.out.print("Added: " + insertedCoin.getValue() + " Balance: "
                            + currentBalance + "\n");
                } else {
                    System.out.println("Invalid number input");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input");
        }
    }

    private void SelectProduct() {
        System.out.println("Type the index of the product and then hit enter "
                + "or \"cancel\" to get your money back");
        String input = "";
        boolean done = false;

        while(!done) {
            try {
                input = sc.nextLine();
                if (input.equals("cancel")) {
                    CancelPurchase();
                    done = true;
                }
                else {
                    int index = Integer.parseInt(input);
                    Product p = Product.GetByIndex(index);
                    if(p != null ) {
                        done = PerformPurchase(p);
                    } else {
                        System.out.println("Invalid number input");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number input");
            }
        }
    }

    /**
     * Purchases and returns the given product.
     */
    private boolean PerformPurchase(Product p) {
        if(p.GetPrice() > currentBalance) {
            System.out.println("You don't have enough money for that product. Select another one or cancel and start over.");
            return false;
        }

        double amountToReturn = Math.round((currentBalance - p.GetPrice()) * 100.0)/100.0;
        if(!thereIsEnoughChange(amountToReturn)) {
            System.out.println("Can't return the proper change if that product is purchased. Plese cancel and start over.");
            return false;
        }

        if(productInv.getQty(p) < 1) {
            System.out.println("The product you chose sold out.");
            return false;
        }

        // Get Product
        System.out.println("Here's your product: " + p.GetDescription());
        productInv.substractItem(p);

        // Get Change
        Inventory<Coin> change = GatherChange(amountToReturn);
        System.out.println("Here's your Change...");
        System.out.println(change.toString());
        return true;
    }

    /**
     * Collects the coins to be returned to the user.
     */
    private Inventory<Coin> GatherChange(double amount) {
        Inventory<Coin> cash = new Inventory<Coin>(Coin.values(), 0);
        if(amount > 0) {
            // Iterate over coins from highest denomination to lowest
            Coin[] coinValues = Coin.values();
            for(int coinIndex = coinValues.length - 1; coinIndex >= 0 ; coinIndex--) {
                Coin c = coinValues[coinIndex];
                while(amount >= c.getValue() && coinInv.getQty(c) > 0) {
                    double newValue = (amount - c.getValue()) * 100.0;
                    amount = Math.round(newValue) * 100.0;
                    cash.addItem(c);
                    coinInv.substractItem(c);
                }
            }
        }
        return cash;
    }

    /**
     * Aborts the purchase.
     */
    private void CancelPurchase() {
        Inventory<Coin> cash = new Inventory<Coin>(Coin.values(), 0);
        // Iterate over coins from highest denomination to lowest
        Coin[] coinValues = Coin.values();
        for(int coinIndex = coinValues.length - 1; coinIndex >= 0 ; coinIndex--) {
            Coin c = coinValues[coinIndex];
            while(currentBalance >= c.getValue() && coinInv.getQty(c) > 0) {
                double newValue = (currentBalance - c.getValue()) * 100.0;
                currentBalance = Math.round(newValue) * 100.0;
                coinInv.substractItem(c);
                cash.addItem(c);
            }
        }
        System.out.println("Canceled, Here's your money back...");
        System.out.println(cash.toString());
        cash = null;
    }

    /**
     * Checks if there's enough change to be returned.
     */
    private boolean thereIsEnoughChange(double amountToReturn) {
        if(amountToReturn > 0) {
            Inventory<Coin> cash = new Inventory<Coin>(Coin.values(), 0);
            double balance = amountToReturn; // Math.round((currentBalance - productAmount) * 100.0) /100.0;
            // Iterate over coins from highest denomination to lowest
            Coin[] coinValues = Coin.values();
            for(int coinIndex = coinValues.length - 1; coinIndex >= 0 ; coinIndex--) {
                Coin c = coinValues[coinIndex];
                while(balance >= c.getValue() && coinInv.getQty(c) > cash.getQty(c)) {
                    double newValue = (balance - c.getValue()) * 100.0;
                    balance = Math.round(newValue) * 100.0;
                    cash.addItem(c);
                }
            }
            if(balance != 0) {
                return false;
            }
        }
        return true;
    }

}













