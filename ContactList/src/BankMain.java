import java.util.Scanner;

public class BankMain {

    private static Bank bank;
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String [] args){

        boolean quit=true;
        list();
        while(quit){
            System.out.println("Enter the choice of oepration ");
            int i=scanner.nextInt();
            scanner.nextLine();

            switch (i){
                case 0:
                    bank=new Bank();
                case 1:
                    addnewbranch();
                    break;
               case 2:
                    addcustomer();
                    break;
                case 3:
                    displayBranchList();
                    break;
                case 4:
                    list();
                    break;
                case 5:
                    displayCustomerList();
                    break;
                case 6:
                    addTransaction();
                    break;

            }
        }

    }
    public static void list(){
        System.out.println("1.  AddnewBranch \n" +
                            "2. Add new Customer \n" +
                              "3. Display Branch List  \n"+
                                "4. list\n"+
                "5. displayCustomerList \n"+
                "6. AddTransaction \n");
    }
    public static void addnewbranch(){
        System.out.println("Enter the branch name");
        String name=scanner.nextLine();
        bank.addBranch(Branch.addBranch(name));
    }
    public static void addcustomer(){
        System.out.println("Enter the name of the branch to be added ");
        String branchName=scanner.nextLine();
        if(bank.searchBranch(branchName)){
            System.out.println("Enter the name of the customer ");
            String custName=scanner.nextLine();
            System.out.println("Enter the initial transaction Amount");
            double initrans=scanner.nextDouble();
            scanner.nextLine();
            bank.addCustomer(bank.getBranch(branchName),custName,initrans);
        }
        else {
            System.out.println(" No Such Branch Found ");
        }

    }
    public static void displayBranchList(){
        bank.displayBranchList();
    }
    public static void displayCustomerList(){
        System.out.println("Enter the name of the branch to be added ");
        String branchName=scanner.nextLine();
        bank.displayList(bank.getBranch(branchName));
    }

    public static void addTransaction(){
        System.out.println("Enter the name of the branch to be added ");
        String branchName=scanner.nextLine();
        System.out.println("Enter the name of the customer ");
        String custName=scanner.nextLine();
        System.out.println("Enter the transaction Amount");
        double trans=scanner.nextDouble();
        bank.addTransaction(bank.getBranch(branchName),custName,trans);
    }
}
