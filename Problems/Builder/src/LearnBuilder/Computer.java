package LearnBuilder;

public class Computer {

    private String model;
    private byte ram;
    private float processor;

    public Computer(String model, byte ram, float processor) {
        this.model = model;
        this.ram = ram;
        this.processor = processor;
    }

    public void getModel() {
        System.out.println("Computer Model: " + model);
    }

    public void getRam() {
        System.out.println("Computer RAM: " + ram);
    }

    public void getProcessor() {
        System.out.println("Computer porcessor: " + processor);
    }

}
