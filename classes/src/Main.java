

public class Main {

    public static void main(String [] args){
        bankaccount b1=new bankaccount();
//        b1.setAccountNumber(342394238);
//        b1.setCustomerName("Himansh Singh");
//        b1.setBalance(3434334);
//        b1.setPhoneNumber(6382106201d);
//        b1.setEmail("himansh.singh3@gmail.com");
        System.out.printf("Name: "+ b1.getCustomerName() +" \n"+"Account No : " +
                b1.getAccountNumber() +" \n" +"Account Balance : "+b1.getBalance() +"\n"+
                "Phone Number: "+b1.getPhoneNumber()+"\n"+"Email Address: "+b1.getEmail()+"\n");

        b1.depositFund(10000);
        b1.withDrawFund(500);
        b1.withDrawFund(10000000);

        bankaccount b2=new bankaccount(1234,500,"Himansh Singh",
                "himansh.singh3@gmail.com",6382106201d);
        System.out.printf("Name: "+ b2.getCustomerName() +" \n"+"Account No : " +
                b2.getAccountNumber() +" \n" +"Account Balance : "+b2.getBalance() +"\n"+
                "Phone Number: "+b2.getPhoneNumber()+"\n"+"Email Address: "+b2.getEmail()+"\n");

        bankaccount b3=new bankaccount(100,"hero");
        System.out.printf("Name: "+ b3.getCustomerName() +" \n"+"Account No : " +
                b3.getAccountNumber() +" \n" +"Account Balance : "+b3.getBalance() +"\n"+
                "Phone Number: "+b3.getPhoneNumber()+"\n"+"Email Address: "+b3.getEmail()+"\n");

        System.out.println("************************************************");

        vipcustomer v1=new vipcustomer();
        vipcustomer v2=new vipcustomer("Himanshu ",20000);
        vipcustomer v3=new vipcustomer(2999,"himansh.singh3@gmail.com");
        vipcustomer v4=new vipcustomer("Rahul",100000,"rah.fdk@gmail.com");

        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("************************************************");


        // This vehicle class is an example of inheritance


        BMW m4=new BMW(7,4,false,"Red","M4-competition");
//        m4.moving(60,30);
//        m4.changevelocity(80,23);
        m4.accelarate(30);
        m4.accelarate(20);
        m4.accelarate(-110);
        m4.accelarate(200);
        m4.stop();

    }

}
