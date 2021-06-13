

public class Account {
    private int accountId;
    private String holderName;
    private double accountBalance;

    public Account(int accountId, String holderName, double accountBalance) {
        setAccountId(accountId);
        this.holderName = holderName;
        setAccountBalance(accountBalance);
    }
    public void setAccountId(int accountId) {
        if(accountId >= 1000 && accountId <= 9999){
            this.accountId = accountId;
        }else {
            this.accountId = -1;
        }
    }
    public void setAccountBalance(double accountBalance) {
        System.out.println("Account set account balance called.");
        if(accountBalance >= 0){
            this.accountBalance = accountBalance;
        }else{
            this.accountBalance = 0;
        }
    }

    public double credit(double amount){
       setAccountBalance(amount + this.accountBalance);
       return this.accountBalance;
    }
}

class VIPAccount extends Account{
    private double accountBalance;
    public VIPAccount(int accountId, String holderName, double accountBalance) {
        super(accountId, holderName, accountBalance);
    }
    @Override
    public void setAccountBalance(double accountBalance) {
        System.out.println("Vip set account balance called");
            if(accountBalance >= -10000){
                this.accountBalance = accountBalance;
            }else {
                this.accountBalance = 0;
            }
    }
    public double getVipAccountBalance() {
        return accountBalance;
    }
}
