import javax.xml.namespace.QName;
import java.util.Scanner;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    private static Mobile mobile=new Mobile();

    public static void main(String [] args){

        boolean index=true;
        operation();
        while(index){
            System.out.println("\t Enter the no to perform  an operation \t");
            int i=sc.nextInt();
            sc.nextLine();
            switch (i){
                case 1:
                    mobile.displayContact();
                    break;

                case 2:
                    addcontact();
                    break;

                case 3:
                    updatecontact();
                    break;

                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    operation();
                    break;
                case 7:
                    index=false;
            }
        }

    }
    public static void operation(){
        System.out.println("************************************************");
        System.out.println("1. Print the Contact List \t\n" +
                           "2. Add to Contact List \t \n"+
                           "3. Update Contact List \t \n"+
                            "4. Delete Contact \t \n"+
                            "5. Search Contact \n"+
                            "6. Show operations \n"+
                            "7. Quit \n");
        //System.out.println("\t Enter the operation no to perform \t");
    }

    public static void addcontact(){
        System.out.println("Enter the name of the contact : \r");
        String name=sc.nextLine();
        System.out.println("Enter the phoneNumber of the contact :");
        String phoneNo= sc.nextLine();
        if(mobile.addContact(Contacts.addContact(name,phoneNo))){
            System.out.println("Contact added "+name +" Phoneno "+phoneNo);
        }else
            System.out.println("Cannot add Contact");
    }
    public static void updatecontact(){
        System.out.println("Enter the name of the contact to be updated :");
        String name=sc.nextLine();
        System.out.println("Enter the name of the new contact :");
        String newName=sc.nextLine();
        System.out.println("Enter the phone number of the new contact ");
        String phoneNo= sc.nextLine();
        if(mobile.updateContact(name,Contacts.addContact(newName,phoneNo))){
            System.out.println("Successfully updated Contact");
        }
        else
            System.out.println("Unable to update contact ");
    }
    public static void deleteContact(){
        System.out.println("Enter the name of the contact to be deleted :");
        String name=sc.nextLine();
        mobile.deleteContact(name);
    }
    public static void searchContact(){
        System.out.println("Enter the name of the contact to be searched");
        String name=sc.nextLine();
        boolean exist=mobile.searchContact(name);
        if(exist){
            System.out.println("Contact is present in the list");
            mobile.displayContact(name);
        }
        else
            System.out.println("Contact does not exist ");
    }
}
