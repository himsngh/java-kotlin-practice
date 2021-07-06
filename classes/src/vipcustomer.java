public class vipcustomer {
    private String name;
    private double creditlimit;
    private String email;

    public vipcustomer(){
        this("default name",0,"default.name@gamil.com");
    }
    public vipcustomer(String name,double creditlimit){
        this(name,creditlimit,"default.email.com");

    }

    public vipcustomer(double creditlimit, String email) {
        this("default",creditlimit,email);
//        this.creditlimit = creditlimit;
//        this.email = email;
    }

    public vipcustomer(String name, double creditlimit, String email){
        this.name=name;
        this.creditlimit=creditlimit;
        this.email=email;
        System.out.println("VipCustomer created with name "+this.name+" creditlimit "+creditlimit+" and email :"+email);
    }
}
