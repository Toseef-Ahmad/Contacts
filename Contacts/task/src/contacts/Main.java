package contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<StageFour> list = new ArrayList<>();
    static List<StageFour> searched = new ArrayList<>();

    transient static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        mainMenu();
    }

    public static void displayList(List<StageFour> list) {
        byte i = 1;
        for (StageFour s : list) {
            System.out.println(i + " " + s.displayFields());
            ++i;
        }
    }

    public static void search(List<StageFour> list) {
        System.out.println("Enter search query: ");
        String item = scanner.nextLine().toLowerCase();
        System.out.println(item);
        for (StageFour s : list) {
            if ((s.displayFields() + s.getNumber()).toLowerCase().contains(item)) {
                searched.add(s);
            }
        }
        System.out.printf("Found %d results: \n", searched.size());
        displayList(searched);
        System.out.println();
    }

    public static void displayInfo(List<StageFour> list, byte number) {
        System.out.println(list.get(number).displayInfo());
    }

    public static void edit(StageFour object) {
        System.out.println("");
        object.changeFields();
    }

    public static void mainMenu() throws IOException, ClassNotFoundException {
        System.out.println("[menu] Enter action (add, list, search, count, serialized, deserialized, exit): ");
        switch (scanner.nextLine()) {
            case "serialized":
                setSerialized();
                break;
            case "deserialized":
                setDesirialized();
                break;
            case "count":
                System.out.printf("The Phone Book has %d records. \n", list.size());
                System.out.println();
                mainMenu();
                break;
            case "search":
                search(list);
                while (true) {
                    System.out.println("[search] Enter action ([number], back, again): ");
                    String command = scanner.nextLine();
                    switch (command) {
                        case "back":
                            mainMenu();
                            break;
                        case "again":
                            searched.clear();
                            search(list);
                            break;
                        default:
                            displayInfo(searched, (byte) (Byte.parseByte(command) - 1));
                            editDeleteMenu(searched, command);
                    }
                }

            case "list":
                displayList(list);
                System.out.println();
                System.out.println("[list] Enter action ([number], back): ");
                String subCommand = scanner.nextLine();
                switch (subCommand) {
                    case "back":
                        mainMenu();
                        break;
                    default:
                        displayInfo(list, (byte) (Integer.parseInt(subCommand) - 1));
                        editDeleteMenu(list, subCommand);
                        break;
                }
                break;
            case "add":
                add();
                System.out.println();
                mainMenu();
                break;
            case "exit":
                System.exit(0);
        }
    }

    public static void editDeleteMenu(List<StageFour> list, String command) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("[record] Enter action (edit, delete, menu): ");
            switch (scanner.nextLine()) {
                case "edit":
                    edit(list.get(Integer.parseInt(command) - 1));
                    displayInfo(list, (byte) (Integer.parseInt(command) - 1));
                    break;
                case "delete":
                    deleteObject(list, Integer.parseInt(command) - 1);
                    searched.clear();
                    mainMenu();
                    break;
                case "menu":
                    System.out.println("Going to menu: ");
                    searched.clear();
                    mainMenu();
                    break;
            }
        }

    }

    public static void deleteObject(List<StageFour> list, int index) {
        list.remove(index);
    }

    public static void add() {
        StageFour object;
        System.out.println("Enter the type (person, organization): ");
        switch (scanner.nextLine()) {
            case "person":
                object = new Person();
                object.addData();
                list.add(object);
                break;
            case "organization":
                object = new Organization();
                object.addData();
                list.add(object);
                break;
        }

    }

    public static void setSerialized() throws IOException {
        FileOutputStream fos = new FileOutputStream("d://abc.db");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
    }

    public static void setDesirialized() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("d://abc.db");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ois.readObject();
        System.out.println(list.size() + " contacts is loaded: ");
    }
}
