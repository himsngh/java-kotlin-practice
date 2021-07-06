public class vehicle {
    private String name;
    private double size;
    private int velocity;
    private int direction;
    public vehicle(String name,double size){
        this.name=name;
        this.size=size;
        this.direction=0;
        this.velocity=0;
    }
    public void steer(int direction){
        this.direction+=direction;
        System.out.println("Vehicle : this vehicle is steering in direction "+ this.direction +" degrees.");
    }
    public void moving(int velocity,int direction){
        this.velocity=velocity;
        this.direction=direction;
        System.out.println("The vehicle is moving at a speed of "+this.velocity +" km in the direciton "+this.direction);
    }
    public void stop(){
        this.velocity=0;
       System.out.println("The vehicle is stopped ");
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getDirection() {
        return direction;
    }
}
class car extends vehicle{
    private int wheels;
    private int gears;
    private int doors;
    private boolean gearsIsManual;

    private int currentGear;

    public car(String name, double size, int gears, int doors, boolean gearsIsManual) {
        super(name, size);
        this.wheels = 4;
        this.gears = gears;
        this.doors = doors;
        this.gearsIsManual = gearsIsManual;
        this.currentGear=1;
    }
    public void changevelocity(int velocity,int direction){
        System.out.println(("changed velocity  to "+velocity+" km in direction "+direction));
        moving(velocity, direction);

    }
    public void changegear(int gear){
        this.currentGear=gear;
        System.out.println("current gear is changed to : "+currentGear);
    }
}
class BMW extends car{
    private String model;
    private String color;

    public BMW(int gears, int doors, boolean gearsIsManual, String color,String Model) {
        super("BMW ",24,gears, doors, gearsIsManual);
        this.color = color;
        this.model=Model;
    }
    @Override
    public void stop(){
        changegear(1);
        super.stop();
    }
    public void accelarate(int rate){
        int newVelocity= super.getVelocity() + rate;
        if(newVelocity <= 0){
            stop();
        }
        else if(newVelocity >0 && newVelocity <=20){
            changegear(1);
        }
        else if(newVelocity >20 && newVelocity <=40){
            changegear(2);
        }
        else if(newVelocity >40 && newVelocity <=55){
            changegear(3);
        }
        else if(newVelocity >55 && newVelocity <=90){
            changegear(4);
        }
        else if(newVelocity >90 && newVelocity <150){
            changegear(5);
        }
        else if(newVelocity >150 && newVelocity <=200){
            changegear(6);
        }
        else if(newVelocity >200){
            changegear(7);
        }
        if(newVelocity>0){
            changevelocity(newVelocity,getDirection());
        }
    }


}
