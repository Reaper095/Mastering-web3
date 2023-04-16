class Car{
    String make;
    String model;
    int year;
    int speed;
    int x;
    int y;
    int z;
    public Car(String make, String model, int year, int speed, int x, int y,int z) {
        this.make =make;
        this.model =model;
        this.year =year;
        this.speed =speed;
        this.x =x;
        this.y =y;
        this.z =z;
    }

    //increases the speed by x;
    public void accelerate(int x){
        this.speed+=x;
    }

    // decreases the speed by x
    public void brake(int x){
        if(speed>x){
            this.speed-=x;
        }
        else{
            this.speed=0;
        }
    }

    //updates the position in 3D
    public void move(){
        this.y+=speed;
        this.x+=speed;
        this.z+=speed;
    }

    //detects whether the cars have collided or not
    public boolean detect_collision(Car car2){
        return (car2.x==this.x && car2.y==this.y && car2.z==this.z);
    }

    //returns the time taken to collide
    public double time_to_collision(Car car2) {
        int DistanceinX = car2.x-this.x;
        int DistanceinY = car2.y-this.y;
        int DistanceinZ = car2.z-this.z;
        double speed = this.speed - car2.speed;
        return ((Math.sqrt(DistanceinX * DistanceinX+ DistanceinY * DistanceinY + DistanceinZ*DistanceinZ) )/ Math.abs(speed));
    }

}
public class masterweb3 {
    public static void main(String[] args) {
        Car car1=new Car("Maruti","Grand Vitar",2022,20,5,10,13);
        Car car2=new Car("BMW","X7",2023,10,10,15,12);
        car1.accelerate(3);
        car2.accelerate(5);
        car2.brake(4);
        System.out.println(car1.detect_collision(car2));
        car1.move();
        System.out.println(car1.time_to_collision(car2));


    }
}