import java.sql.SQLOutput;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> items= new ArrayList<>();
        ArrayList<Integer> qtys= new ArrayList<>();
        ArrayList<Integer> prices= new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();

        Scanner userInput = new Scanner(System.in);

        // Validate customer name (letters/spaces only)
        String customerName;
        while (true) {
            System.out.println("What is the customer's name?");
            customerName = userInput.nextLine().trim();
            if (!customerName.isEmpty() && customerName.matches("[A-Za-z ]+")) break;
            System.out.println("Invalid name! Use letters only.");
        }


        System.out.println("What did the user buy ");
        items.add(userInput.nextLine());

        // Validate quantity , qty must be a positive integer as it cant be less than 1
        int qty;
        while (true) {
            System.out.println("How many pieces? ");
            try {
                qty = Integer.parseInt(userInput.nextLine());
                if (qty > 0) {
                    qtys.add(qty);
                    break;
                }
                System.out.println("Quantity must be 1 or more!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid input.");
            }
        }

        // Validate price, , priceee must be a positive integer as it cant be less than 1
        int price;
        while (true) {
            System.out.println("How much per unit?");
            try {
                price = Integer.parseInt(userInput.nextLine());
                if (price > 0) {
                    prices.add(price);
                    break;
                }
                System.out.println("Price must be valid");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid input.");
            }
        }

        // Validate yes/no response gotten from user
        String addMoreItems;
        while (true) {
            System.out.println("add more items? (yes/no) ");
            addMoreItems = userInput.nextLine().trim().toLowerCase();
            if (addMoreItems.equals("yes") || addMoreItems.equals("no")) break;
            System.out.println("Invalid input! Enter 'yes' or 'no'.");
        }

        while (Objects.equals(addMoreItems, "yes")){
            System.out.println("What did the user buy");
            items.add(userInput.nextLine());

            // Validate quantity
            while (true) {
                System.out.println("How many pieces? ");
                try {
                    qty = Integer.parseInt(userInput.nextLine());
                    if (qty > 0) {
                        qtys.add(qty);
                        break;
                    }
                    System.out.println("Quantity must be 1 or more!");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a number.");
                }
            }

            // Validate price
            while (true) {
                System.out.println("How much per unit?");
                try {
                    price = Integer.parseInt(userInput.nextLine());
                    if (price > 0) {
                        prices.add(price);
                        break;
                    }
                    System.out.println("Price must be > 0!");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a valid input.");
                }
            }

            // Validate yes/no
            while (true) {
                System.out.println("add more items? (yes/no)");
                addMoreItems = userInput.nextLine().trim().toLowerCase();
                if (addMoreItems.equals("yes") || addMoreItems.equals("no")) break;
                System.out.println("Invalid input! Enter 'yes' or 'no'.");
            }
        }


        String cashierName;
        while (true) {
            System.out.println("What is the cashier's name?");
            cashierName = userInput.nextLine().trim();
            if (!cashierName.isEmpty() && cashierName.matches("[A-Za-z ]+")) break;
            System.out.println("Invalid name! Use letters only.");
        }

        // Validate discount, I hard coded discount to be between 0-100, it could be based on a perentage of the total price of items bought
        int discount;
        while (true) {
            System.out.println("How much discount will he get?");
            try {
                discount = Integer.parseInt(userInput.nextLine());
                if (discount >= 0 && discount <= 100) break;
                System.out.println("Discount must be 0-100!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }

        // Rest of your original code remains unchanged
        System.out.println("EMORINKEN STORES \n MAIN BRANCH \n LOCATION: 3 ABIODUN SADIKU STREET, AGEGE, LAGOS \n Tel: 08078675645");
        System.out.printf("Date: %s \n Cashier's name: %s \n Customer's name: %s%n ",today,cashierName, customerName);

        System.out.println("===========================================================");
        System.out.printf("%-15s %-15s %-15s %-15s%n","ITEM","QTY","PRICE","TOTAL(NGN)");
        System.out.println("------------------------------------------------------------");

        double total=0;
        double VAT;
        for (int i=0; i<items.size();i++){
            double subTotal;
            subTotal= prices.get(i) * qtys.get(i);
            total+=subTotal;
            System.out.printf("%-15s %-15d %-15d %-15.2f%n", items.get(i), qtys.get(i), prices.get(i), subTotal);
        }

        VAT= 0.175*total;
        System.out.printf("%-15s %-10.2f%n","SubTotal",total);
        System.out.printf("%-15s %-10d%n","DISCOUNT",discount);
        System.out.printf("%-15s %-10.2f%n","VAT @ 17.5%",VAT);
        double billTotal= total-discount+VAT;
        System.out.println("===============================================================================");
        System.out.printf("%-15s %10.2f%n", "BILL TOTAL",billTotal);
        System.out.println("================================================================================");
        System.out.printf("%s %.2f%n","THIS IS NOT A RECEIPT, KINDLY PAY ",billTotal);
        System.out.println("================================================================================");

        System.out.println("------------------------------------------------------------");
        System.out.println();
        userInput.close();
    }
}