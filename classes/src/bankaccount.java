public class bankaccount {

    private int accountNumber;
    private double balance;
    private String CustomerName;
    private String email;
    private double phoneNo;

    public bankaccount(){
        this(00000,0,"Default Name","default.name@default.com",000000000);
        System.out.println("Empty constructor called the parametrized constructor with default values ");

    }
    public bankaccount(int accountNumber,double balance,String CustomerName,String email,double phoneNo){
        System.out.println("initializing the object with constructor parameters");
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.phoneNo=phoneNo;
        this.CustomerName=CustomerName;
        this.email=email;
    }

    public bankaccount(double balance, String customerName) {
        this(1234,balance,customerName,"default@gmail.com",111111111);
        System.out.println("parameters passed  ");
//        this.balance = balance;
//        CustomerName = customerName;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setCustomerName(String CustomerName){
        this.CustomerName=CustomerName;
    }
    public String getCustomerName(){
        return this.CustomerName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPhoneNumber(double phoneNo){
        this.phoneNo=phoneNo;
    }
    public double getPhoneNumber(){
        return this.phoneNo;
    }
    public void depositFund(double money){
        System.out.println("Amount deposited :"+money);
        this.balance=this.balance+money;
        System.out.println("Updated Balance : "+this.balance);
    }
    public void withDrawFund(double money){
        if(this.balance <money){
            System.out.println("Insufficient funds");
        }
        else {
            System.out.println("Amount withdrawn :" + money);
            this.balance = this.balance - money;
            System.out.println("Updated Balance : " + this.balance);
        }
    }

}
