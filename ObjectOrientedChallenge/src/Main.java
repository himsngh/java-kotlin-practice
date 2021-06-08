import java.util.Scanner;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("*******************************");
        boolean quit=false;
        while(!quit){
            System.out.println("Welcome to Bill's Burger");
            printInstructions();
            int a=sc.nextInt();
            switch(a){
                case 1:
                    createNormalBurger();
                    break;
                case 2:
                    createHealthyBurger();
                    break;
                case 3:
                    createDeluxBurger();
                    break;
            }
        }
    }
    public static void printInstructions(){
        System.out.println("Enter the required burger and details");
        System.out.println("1.Normal Bills Burger  \n"+
                           "2.Healthy Bill's Burger \n"+
                           "3.Delux Bill's Burger \n");
    }
    public static void createNormalBurger(){
        Hamburgers ham1 = new Hamburgers("McChicken", "Brown Bread", 124,true);
        ham1.getBasePrice();
        addAdditionals(ham1);
        ham1.hamburgerPrice();
        System.out.println("***********************************");
    }
    public static void createHealthyBurger(){
        HealthyHamburger hham=new HealthyHamburger(150,true);
        addAdditionals(hham);
        hham.hamburgerPrice();
        System.out.println("***********************************");

    }
    public static void createDeluxBurger(){
        DeluxHamburger DHam= new DeluxHamburger("Delux Burger","Max Bread",200,true);
        DHam.getBasePrice();
        System.out.println("***********************************");
    }
    public static void addAdditionals(Hamburgers h) {
        System.out.println("Enter the addtionals you want in your burger");
        boolean quit=false;
        while(!quit){
            System.out.println("1.Lettuce -> 23.50 \n" +
                    "2.Tomato -> 12.50 \n" +
                    "3.Eggs -> 40.00 \n" +
                    "4.ExtraMeat -> 100.00 \n" +
                    "5.Done");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    h.setAdditionalItem1("Lettuce", 23.50);
                    break;
                case 2:
                    h.setAdditionalItem2("Tomato", 12.50);
                    break;
                case 3:
                    h.setAdditionalItem3("Eggs", 50);
                    break;
                case 4:
                    h.setAdditionalItem4("Extra Meat", 100);
                    break;
                case 5:
                    quit=true;
            }
        }
    }

    public static void addAdditionals(HealthyHamburger h) {
        System.out.println("Enter the addtionals you want in your burger");
        boolean quit = false;
        while(!quit){
            System.out.println("1.Lettuce -> 23.50 \n"+
                    "2.Tomato -> 12.50 \n"+
                    "3.Eggs -> 40.00 \n"+
                    "4.ExtraMeat -> 100.00 \n"+
                    "5.Veggies -> 30.30\n"+
                    "6.ExtraCheese -> 50\n"+
                    "7.Done");
            int a =sc.nextInt();
            switch (a){
                case 1:
                    h.setAdditionalItem1("Lettuce",23.50);
                    break;
                case 2:
                    h.setAdditionalItem2("Tomato",12.50);
                    break;
                case 3:
                    h.setAdditionalItem3("Eggs",50);
                    break;
                case 4:
                    h.setAdditionalItem4("Extra Meat",100);
                    break;
                case 5:
                    h.setAdditionalItem5("Veggie",30.50);
                    break;
                case 6:
                    h.setAdditionalItem6("ExtraCheese" , 50);
                    break;
                case 7:
                    quit=true;
            }
        }
    }

}
