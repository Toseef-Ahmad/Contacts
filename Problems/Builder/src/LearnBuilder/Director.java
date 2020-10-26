package LearnBuilder;

public class Director {
    public void buildSupportCar(CarInterface builder) {
        builder.setColor("Black");
        builder.setComputer(new Computer("P8Q77", (byte) 3, 2.3f));
        builder.setEngine(new Engine("1890", "3200rpm", "uro 3"));
        builder.setName("Ferrari");
        builder.setType("Support Card");
    }

    public void buildNormalCar(CarInterface builder) {
        builder.setColor("white");
        builder.setComputer(new Computer("Q4500", (byte) 1, 1.6f));
        builder.setEngine(new Engine("770", "1200rpm", "uro 1"));
        builder.setName("Mehran");
        builder.setType("Normal Card");
    }
}
