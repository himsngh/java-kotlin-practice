import java.util.ArrayList;
import java.util.List;

public class Branch {
    private static List<Customer> mycustomer;
    private String name;

    public Branch(String name){
        this.name=name;
        mycustomer =new ArrayList<>();
    }
    public static Branch addBranch(String name){
        return new Branch(name);
    }

    public static List<Customer> getMycustomer() {
        return mycustomer;
    }

    public String getName() {
        return name;
    }

    public void addCustomer(String name, double initialTransaction){
        String nameOfCustomer=name;
        double customerTransaction=initialTransaction;
        addCustomer(Customer.addCustomer(nameOfCustomer,customerTransaction));
    }
    private boolean addCustomer(Customer customer){
        if(findCustomer(customer.getName()) >= 0){
            System.out.println("Customer already exist");
            return false;
        }
        this.mycustomer.add(customer);
        System.out.println("Customer added -->> Name :" +customer.getName());
        return true;
    }
    public boolean addTransaction(String name,double trans){
        if(findCustomer(name) >= 0){
            int index=findCustomer(name);
            Customer c= mycustomer.get(index);
            c.getTransaction().add(trans);
            System.out.println("New Transaction added for "+name+" with transactin amount "+trans);
            return true;
        }
        else
            return false;
    }

    public void displayCustomerList(){

        for(int i=0;i<mycustomer.size();i++){
            Customer customer=mycustomer.get(i);
            System.out.println(" Customer name : "+customer.getName());
            customer.transactiondetails();
        }
    }
    private int findCustomer(String name){
        for(int i = 0; i< mycustomer.size(); i++){
            if(mycustomer.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    private int findCustomer(Customer customer){
        return this.mycustomer.indexOf(customer);
    }
}
