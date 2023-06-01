import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Main.Cupcake> cupcakeMenu, ArrayList<Main.Drink> drinkMenu) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nHello customer. Would you like to place an order? (Y or N)");
        String input = scan.nextLine();
        ArrayList<Object> order = new ArrayList<>();
        if(input.equalsIgnoreCase("Y")){
            order.add(LocalDate.now());
            order.add(LocalTime.now());

            System.out.println("\nHere is the menu \nCUPCAKES");
            int itemNumber = 0;
            for(int i = 0; i<cupcakeMenu.size();i++){
                itemNumber++;
                System.out.print(itemNumber+" ");
                cupcakeMenu.get(i).type();
                double price = cupcakeMenu.get(i).price;
                System.out.println("Price: "+price);
                System.out.println();
            }

            System.out.println("\nDRINKS");
            for(int i =0 ;i<drinkMenu.size();i++){
                itemNumber++;
                System.out.print(itemNumber+" ");
                drinkMenu.get(i).type();
                double price = drinkMenu.get(i).price;
                System.out.println("Price: "+price);
                System.out.println();
            }
        }else {
            System.out.println("Have a good day!");
        }

        boolean ordering = true;
        while(ordering){
            System.out.println("What would you like to order? Please use the number associated with each item to order.");
            int orderChoice = scan.nextInt();
            scan.nextLine();

            if(orderChoice == 1){
                order.add(cupcakeMenu.get(0));
                System.out.println("Item added to order");
            }else if(orderChoice == 2){
                order.add(cupcakeMenu.get(1));
                System.out.println("Item added to order");
            }else if(orderChoice == 3){
                order.add(cupcakeMenu.get(2));
                System.out.println("Item added to order");
            }else if(orderChoice == 4){
                order.add(drinkMenu.get(0));
                System.out.println("Item added to order");
            }else if(orderChoice == 5){
                order.add(drinkMenu.get(1));
                System.out.println("Item added to order");
            }else if(orderChoice == 6){
                order.add(drinkMenu.get(2));
                System.out.println("Item added to order");
            }else{
                System.out.println("Sorry, we don’t seem to have that on the menu.");
            }
            System.out.println("Would you like to continue ordering? (Y/N)");
            String placeOrder = scan.nextLine();

            if(!placeOrder.equalsIgnoreCase("Y")){
                ordering = false;
            }

        }

        System.out.println(order.get(0));
        System.out.println(order.get(1));

        double subtotal = 0.0;
        for(int i = 2; i < order.size(); i++){
            if(order.get(i) == cupcakeMenu.get(0)){
                cupcakeMenu.get(0).type();
                System.out.println(cupcakeMenu.get(0).price);
                subtotal += cupcakeMenu.get(0).price;
            }else if(order.get(i) == cupcakeMenu.get(1)){
                cupcakeMenu.get(1).type();
                System.out.println(cupcakeMenu.get(1).price);
                subtotal += cupcakeMenu.get(1).price;
            }else if(order.get(i) == cupcakeMenu.get(2)){
                cupcakeMenu.get(2).type();
                System.out.println(cupcakeMenu.get(2).price);
                subtotal += cupcakeMenu.get(2).price;
            }else if(order.get(i) == drinkMenu.get(0)){
                drinkMenu.get(0).type();
                System.out.println(drinkMenu.get(0).price);
                subtotal += drinkMenu.get(0).price;
            }else if(order.get(i) == drinkMenu.get(1)){
                drinkMenu.get(1).type();
                System.out.println(drinkMenu.get(1).price);
                subtotal += drinkMenu.get(1).price;
            }else if(order.get(i) == drinkMenu.get(2)){
                drinkMenu.get(2).type();
                System.out.println(drinkMenu.get(2).price);
                subtotal += drinkMenu.get(2).price;
            }
        }

        System.out.println("Subtotal: "+subtotal);

        new CreateFile();
        new WriteToFile(order);
    }

}
class CreateFile{
    public CreateFile(){
        try{
            File salesData = new File("salesData.txt");
            if(salesData.createNewFile()){
                System.out.println("File Created:" + salesData.getName());

            }
            else{
                System.out.println("File Already Exist");
            }
        }catch (IOException e) {
            System.out.println("An error occurred" + e);
        }
    }
}
class WriteToFile{
    public WriteToFile(ArrayList<Object> order){
        try{
            FileWriter fw = new FileWriter("salesData.txt",true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for(int i = 0;i<order.size();i++){
                salesWriter.println(order.get(i));
            }
            salesWriter.close();
            System.out.println("Successfully wrote to the file.");
        }catch (IOException e) {
            System.out.println("An error occurred" + e);
        }
    }
}