//develop an ecommerce checkout system
//there would be a loop iterating till the customer decides to no longer add a new item
//there would be an array multiple items (array list cos the array needs to be dynamic as more items would be added depending on the iteration)


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
        System.out.println("What is the customer's name?");
        String customerName = userInput.nextLine(); //validate that the user can only input string into the terminal
        System.out.println("What did the user buy ");
        items.add(userInput.nextLine());
        System.out.println("How many pieces? ");
        qtys.add(userInput.nextInt());
        System.out.println("How much per unit?");
        prices.add(userInput.nextInt());
        userInput.nextLine();
        System.out.println("add more items? (yes/no) "); //users should only be able to input yes or no,
        String addMoreItems= userInput.nextLine();
        while (Objects.equals(addMoreItems, "yes")){
            System.out.println("What did the user buy");
            items.add(userInput.nextLine());
            System.out.println("How many pieces? ");
            qtys.add(userInput.nextInt());
            System.out.println("How much per unit?");
            prices.add(userInput.nextInt());
            userInput.nextLine();
            System.out.println("add more items? (yes/no)"); //users should only be able to input yes or no,
             addMoreItems= userInput.nextLine();
        }
        System.out.println("What is the cashier's name?");
        String cashierName= userInput.nextLine();
        System.out.println("How much discount will he get?");
        int discount= userInput.nextInt();


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

    }
}