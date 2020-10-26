package LearnBuilder;

public class Main {
    public static void main(String[] args) {
        SupportCarBuilder supportCarBuilder = new SupportCarBuilder();
        Director director = new Director();
        director.buildSupportCar(supportCarBuilder);
        SupportCar supportCar = supportCarBuilder.build();

        NormalCardBuilder normalCardBuilder = new NormalCardBuilder();
        director.buildNormalCar(normalCardBuilder);
        NormalCar normalCar = normalCardBuilder.build();
        display(supportCar);
    }

    public static void display(SupportCar supportCar) {
        System.out.println("I am displaying SupportCar :");
        supportCar.getEngine().getPistunSize();
        supportCar.getEngine().getPower();
        System.out.println(supportCar.getColor());
        System.out.println(supportCar.getFual());
        System.out.println(supportCar.getName());
        System.out.println(supportCar.getType());
        supportCar.getComputer().getModel();
        supportCar.getComputer().getProcessor();
    }
}
