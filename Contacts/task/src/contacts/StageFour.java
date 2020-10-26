package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public abstract class StageFour implements Serializable {

    StageFour() {
        setCreationDte();
        setEditionHistory();
    }

    transient protected Scanner scanner = new Scanner(System.in);
    protected String name;
    protected String number;
    protected LocalDateTime creationDte;
    protected LocalDateTime editionHistory;

    public abstract String displayFields();
    public abstract String displayInfo();
    public abstract void changeFields();
    public abstract String displayReaction(String field);
    public abstract void addData();

    protected void setName(String name) {
        this.name = name;
    }
    protected String getName() {
        return name;
    }
    protected void setNumber(String number) {
        if (Utils.isValid(number)) {
            this.number = number;
        }
    }
    protected String getNumber() {
        return number == null ? "[no data]" : number;
    }
    protected void setCreationDte() {
        creationDte = LocalDateTime.now();
    }
    protected String getCreationDate() {
        return String.valueOf(creationDte);
    }
    protected void setEditionHistory() {
        editionHistory = LocalDateTime.now();
    }
    protected String getEditionHistory() {
        return String.valueOf(editionHistory);
    }
}

class Person extends StageFour implements Serializable {
    private String surname;
    private String birthDate;
    private String gender;

    public String getSurname() {
        return surname == null ? "[no data]" : surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate == null || birthDate.equals(" ") || birthDate.equals("") ? "[no data]" : birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender == null || gender.equals(" ") || gender.equals("") ? "[no data]" : gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String displayFields() {
        return getName() + " " + getSurname();
    }

    @Override
    public String displayInfo() {
        return "Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Birth date: " + getBirthDate() + " \n" +
                "Gender: " + getGender() + "\n" +
                "Number: " + getNumber() + "\n" +
                "Time created: " + getCreationDate() + "\n" +
                "Time last edit: " + getEditionHistory() + "\n";

    }

    @Override
    public void changeFields() {

        System.out.println("Select a field (name, surname, birth, gender, number): ");

        switch (scanner.nextLine()) {
            case "name":
                System.out.println("Enter name: ");
                setName(scanner.nextLine());
                break;
            case "surname":
                System.out.println("Enter surname: ");
                setSurname(scanner.nextLine());
                break;
            case "number":
                System.out.println("Enter number: ");
                setNumber(scanner.nextLine());
                break;
            case "birth":
                System.out.println("Enter birth: ");
                setBirthDate(scanner.nextLine());
            case "gender":
                System.out.println("Enter gender: ");
                setGender(scanner.nextLine());
            default:
                System.out.println("Command not found");
        }
        setEditionHistory();
        System.out.println("Saved");
    }

    @Override
    public String displayReaction(String field) {
        return "";
    }

    @Override
    public void addData() {
        System.out.println("Enter the name: ");
        setName(scanner.nextLine());

        System.out.println("Enter the surname: ");
        setSurname(scanner.nextLine());

        System.out.println("Enter the birth date: ");
        String birthDate = scanner.nextLine();

        if (Utils.checkBirthDate(birthDate) != null) {
            setBirthDate(birthDate);
        }

        System.out.println("Enter the gender: ");
        setGender(scanner.nextLine());

        System.out.println("Enter the number: ");
        setNumber(scanner.nextLine());

        System.out.println("The record added. ");
    }
}

class Organization extends StageFour implements Serializable {
    private String address;

    public String getAddress() {
        return address == null ? "[no data]" : address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String displayFields() {
        return getName();
    }

    @Override
    public String displayInfo() {
        return "Organization name: " + getName() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Number: " + getNumber() + "\n" +
                "Time created: " + getCreationDate() + "\n" +
                "Time last edit: " + getEditionHistory() + "\n";
    }

    @Override
    public void changeFields() {

        System.out.println("Select a field (name, address, number): ");

        switch (scanner.nextLine()) {
            case "name":
                System.out.println("Enter name: ");
                setName(scanner.nextLine());
                break;
            case "number":
                System.out.println("Enter number: ");
                setNumber(scanner.nextLine());
                break;
            case "address":
                System.out.println("Enter address: ");
                setAddress(scanner.nextLine());
                break;
            default:
                System.out.println("Command not found: ");
        }
        setEditionHistory();
        System.out.println("Saved");
    }

    @Override
    public String displayReaction(String field) {
        return null;
    }

    @Override
    public void addData() {
        System.out.println("Enter the organization name: ");
        setName(scanner.nextLine());

        System.out.println("Enter the address: ");
        setAddress(scanner.nextLine());

        System.out.println("Enter then number: ");
        setNumber(scanner.nextLine());

        System.out.println("The record added. ");
    }
}
