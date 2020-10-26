package LearnBuilder;

public class NormalCar {
    private String name;
    private String color;
    private Computer computer;
    private Engine engine;
    private String type;

    public NormalCar(String name, String color, Computer computer, Engine engine, String type) {
        this.name = name;
        this.color = color;
        this.computer = computer;
        this.engine = engine;
        this.type = type;
    }

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
}
