public class Hamburgers {


    private String name;
    private String breadType;
    private double price;
    private boolean meat;
    private double basePrice;

    private String additionalItem1;
    private double additionalItem1price;


    private String additionalItem2;
    private double additionalItem2price;


    private String additionalItem3;
    private double additionalItem3price;


    private String additionalItem4;
    private double additionalItem4price;

    public Hamburgers(String name,String breadType,double price,boolean meat){
        this.name=name;
        this.breadType=breadType;
        this.price=price;
        this.meat=meat;
        this.basePrice=price;
    }

    public double getBasePrice(){
        System.out.println("The base price of the hamburger is "+basePrice);
        return this.basePrice;
    }
    public void setAdditionalItem1(String additionalItem1,double additionalItem1price ) {
        this.additionalItem1 = additionalItem1;
        this.additionalItem1price=additionalItem1price;
        this.price+=additionalItem1price;
        if(additionalItem1 != null){
            System.out.println("Additional item "+this.additionalItem1 +" added at a cost of "+this.additionalItem1price);
        }
    }
    public void setAdditionalItem2(String additionalItem2,double additionalItem2price){
        this.additionalItem2 = additionalItem2;
        this.additionalItem2price=additionalItem2price;
        this.price+=additionalItem2price;
        if(additionalItem2 != null){
            System.out.println("Additional item "+this.additionalItem2 +" added at a cost of "+this.additionalItem2price);
        }
    }
    public void setAdditionalItem3(String additionalItem3 ,double additionalItem3price) {
        this.additionalItem3 = additionalItem3;
        this.price+=additionalItem3price;
        this.additionalItem3price=additionalItem3price;
        if(additionalItem3 != null){
            System.out.println("Additional item "+this.additionalItem3 +" added at a cost of "+this.additionalItem3price);
        }

    }
    public void setAdditionalItem4(String additionalItem4 , double additionalItem4price) {
        this.additionalItem4 = additionalItem4;
        this.additionalItem4price=additionalItem4price;
        this.price+=additionalItem4price;
        if(additionalItem4 != null){
            System.out.println("Additional item "+this.additionalItem4 +" added at a cost of "+this.additionalItem4price);
        }
    }
    public void hamburgerPrice(){
        getPrice();

    }
    public void setPrice(double price){
        this.price+=price;
    }
    private double getPrice(){
        System.out.println("The price of the hamburger is "+this.price);
        return this.price;
    }

}
class HealthyHamburger extends Hamburgers{

    private String additionalitem5;
    private double additionalItem5Price;

    private String additionalItem6;
    private double additionalItem6Price;

    public HealthyHamburger(double price, boolean meat) {
        super("Healthy Burger ","Brown Rye Bread", price, meat);
    }
    public void setAdditionalItem5(String additionalItem5 , double additionalItem5price) {
        this.additionalitem5 = additionalItem5;
        this.additionalItem5Price=additionalItem5price;
        setPrice(additionalItem5price);
        if(additionalItem5 != null){
            System.out.println("Additional item "+this.additionalitem5 +" added at a cost of "+this.additionalItem5Price);
        }
    }
    public void setAdditionalItem6(String additionalItem6 , double additionalItem6price) {
        this.additionalItem6 = additionalItem6;
        this.additionalItem6Price=additionalItem6price;
        setPrice(additionalItem6price);
        if(additionalItem6 != null){
            System.out.println("Additional item "+this.additionalItem6 +" added at a cost of "+this.additionalItem6Price);
        }
    }

}

class DeluxHamburger extends Hamburgers{
    private String coke;
    private String chips;
    public DeluxHamburger(String name, String breadType, double price, boolean meat) {
        super(name, breadType, price, true);
        this.chips="Chips";
        this.coke="Coke";
        System.out.println("Chips and Coke added in the burger");

    }

    @Override
    public void setAdditionalItem1(String additionalItem1, double additionalItem1price) {
        System.out.println("Not Possible for delux burgers ");
    }

    @Override
    public void setAdditionalItem2(String additionalItem2, double additionalItem2price) {
        System.out.println("Not Possible for delux burgers ");
    }

    @Override
    public void setAdditionalItem3(String additionalItem3, double additionalItem3price) {
        System.out.println("Not Possible for delux burgers ");
    }

    @Override
    public void setAdditionalItem4(String additionalItem4, double additionalItem4price) {
        System.out.println("Not Possible for delux burgers ");
    }

}
