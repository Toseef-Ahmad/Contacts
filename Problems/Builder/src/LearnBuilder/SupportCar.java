package LearnBuilder;

public class SupportCar {

    private String name;
    private String color;
    private Computer computer;
    private Engine engine;
    private String type;
    private int fual = 0;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Computer getComputer() {
        return computer;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getType() {
        return type;
    }

    public void setFual(int fual) {
        this.fual = fual;
    }

    public int getFual() {
        return fual;
    }
    public SupportCar(String name, String color, Computer computer, Engine engine, String type) {
        this.name = name;
        this.color = color;
        this.computer = computer;
        this.engine = engine;
        this.type = type;
    }
}
