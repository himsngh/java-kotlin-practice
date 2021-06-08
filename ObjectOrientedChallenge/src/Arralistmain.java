import java.util.Scanner;

public class Arralistmain {
    private static Arrallist newList=new Arrallist();
    private static Scanner sc=new Scanner(System.in);
    public static void main(String [] args){
        boolean quit=false;
        while (!quit){
            System.out.println(" \n Enter the operation to perform \r");
            printoperations();
            int a=sc.nextInt();
            switch(a){
                case 1:
                    displaylist();
                    break;
                case 2:
                    addtoList();
                    break;
                case 3:
                    removefromlist();
                    break;
                case 4:
                    searchItem();
                    break;
                case 5:
                    modifyItem();
                    break;
                case 6:
                    quit=true;
                    break;
                default:
                    printoperations();
            }
        }
    }
    private static void printoperations(){
        System.out.println("1. Press 1 to display the list ");
        System.out.println("2. Press 2 to add to the list ");
        System.out.println("3. Press 3 to remove form the list ");
        System.out.println("4. Press 4 to search an item form the list ");
        System.out.println("5. Press 5 to modify an item form the list");
        System.out.println("6. Press 6 to quit the list ");
    }
    private static void displaylist(){
        newList.display();
    }
    private static void addtoList(){
        System.out.println("Enter the item to be added to the list \r");
        sc.nextLine();
        String itemName=sc.nextLine();
        newList.addItem(itemName);
    }
    private static void removefromlist(){
        System.out.println("Enter the item to be removed  from the list \r");
        sc.nextLine();
        String itemName=sc.nextLine();
        newList.removeItem(itemName);
    }
    private static void modifyItem(){
        System.out.println("Enter the item to be modified .  \r");
        sc.nextLine();
        String itemName=sc.nextLine();
        System.out.println("Enter the newitem to be added to the list \r");
        String newItem=sc.nextLine();
        newList.modifyItem(itemName,newItem);
    }
    private static void searchItem(){
        System.out.println("Enter the item to be searched \r");
        sc.nextLine();
        String Item=sc.nextLine();
        newList.search(Item);
    }
}
