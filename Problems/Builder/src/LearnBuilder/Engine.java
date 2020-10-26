package LearnBuilder;

public class Engine {

    private String pistunSize;
    private String power;
    private String type;

    public Engine(String pistunSize, String power, String type) {
        this.pistunSize = pistunSize;
        this.power = power;
        this.type = type;
    }

    public void getPower() {
        System.out.println("Engine Power: " + power);
    }

    public void getPistunSize() {
        System.out.println("Pistun Size: " + pistunSize);
    }

    public void getType() {
        System.out.println("Engine Type: " + type);
    }
}
