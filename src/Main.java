import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");

        Scanner input = new Scanner(System.in);

        //Standard cupcake
        System.out.println("\nWe are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();

        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);


        //red velvet
        System.out.println("\nWe are deciding on the price for our red velvet cupcake. Here is the description:");
        redVelvet.type();

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        //chocolate
        System.out.println("\nWe are deciding on the price for our chocolate cupcake. Here is the description:");
        chocolate.type();

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        //add to arraylist
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);


        ArrayList<Drink> drinkMenu = new ArrayList<>();
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        //water
        System.out.println("\nWe are deciding on the price for our water bottles. Here is the description:");
        water.type();

        System.out.println("How much would you like to charge for the water? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        price = Double.parseDouble(priceText);
        water.setPrice(price);

        //soda
        System.out.println("\nWe are deciding on the price for our soda bottles. Here is the description:");
        soda.type();

        System.out.println("How much would you like to charge for the soda? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        price = Double.parseDouble(priceText);
        soda.setPrice(price);

        //milk
        System.out.println("\nWe are deciding on the price for our milk bottles. Here is the description:");
        milk.type();

        System.out.println("How much would you like to charge for the milk? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();

        price = Double.parseDouble(priceText);
        milk.setPrice(price);

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        new Order(cupcakeMenu,drinkMenu);
    }

    public static class Cupcake {
        public double price;

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void type() {
            System.out.println("A basic, generic cupcake, with vanilla frosting");
        }


    }

    public static class RedVelvet extends Cupcake {
        public void type() {
            System.out.println("A red velvet based cupcake, with cream cheese frosting.");
        }


    }

    public static class Chocolate extends Cupcake {
        public void type() {
            System.out.println("A chocolate based cupcake, with chocolate frosting.");
        }


    }

    public static class Drink {
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void type() {
            System.out.println("A Water Bottle");
        }
    }

    public static class Soda extends Drink {
        public void type() {
            System.out.println("A Soda Bottle");
        }
    }

    public static class Milk extends Drink {
        public void type() {
            System.out.println("A Milk Bottle");
        }
    }

}