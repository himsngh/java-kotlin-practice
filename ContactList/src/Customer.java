import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Double> transaction=new ArrayList<>();
    private String name;

    public Customer(String name,double initialTransactin){
        this.name=name;
        transaction.add(initialTransactin);
    }
    public List<Double> getTransaction() {
        return transaction;
    }

    public String getName() {
        return name;
    }

    public static Customer addCustomer(String name,double initalTransaction){
        return new Customer(name,initalTransaction);
    }

    public void transactiondetails(){
        System.out.println(" Transaction Details ");
        for(int i=0;i<transaction.size();i++){
            System.out.println(transaction.get(i));
        }
    }
}
