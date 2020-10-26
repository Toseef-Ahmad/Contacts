package LearnBuilder;

public class SupportCarBuilder implements CarInterface {
    private String name;
    private String color;
    private Computer computer;
    private Engine engine;
    private String type;


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public SupportCar build() {
        return new SupportCar(name, color, computer, engine, color);
    }
}
