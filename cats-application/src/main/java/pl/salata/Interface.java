package pl.salata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import pl.salata.Cat;

public class Interface {
    private static Scanner sc = new Scanner(System.in);
    static CatDAO cats = new CatDAO();

    public static void main(String[] args) {
        String choise;
        do {
            System.out.println("Welcome, what would you like to do?");
            System.out.println("Press:");
            System.out.println("[1] - to add new cat");
            System.out.println("[2] - to browse cats");
            System.out.println("[x] - to exit program");
            choise = sc.nextLine();
            if (choise.equals("1")) {
                addCat();
            } else if (choise.equals("2")) {
                browseCat();
            }
        } while (!choise.equals("x"));
    }

    private static void browseCat() {
        System.out.println("List of all cats in the database:");
        for (int i = 0; i < cats.getCats().size(); i++) {
            System.out.println(i + " " + cats.getCats().get(i).getName());
        }

        String catChosen;
        do {
            System.out.println("Enter a number, to see details about chosen cat:");
            catChosen = sc.nextLine();
        } while (!Pattern.matches("\\d+", catChosen));

        int catChosenIndex = Integer.parseInt(catChosen);
        if (catChosenIndex < cats.getCats().size()) {
            System.out.println("Cats name: " + cats.getCats().get(catChosenIndex).getName());
            System.out.println("Cats date of birth: " + cats.getCats().get(catChosenIndex).getDateBirth());
            System.out.println("Cats weight: " + cats.getCats().get(catChosenIndex).getWeight());
            System.out.println("Cats handler is: " + cats.getCats().get(catChosenIndex).getNameHandler());
        } else {
            System.out.println("There is no such cat in our system");
        }

    }

    private static void addCat() {
        Cat cat = new Cat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        String name;
        do {
            System.out.println("Enter cat's name: ");
            name = getUserInput();
        } while (!Pattern.matches(".+", name));
        cat.setName(name);

        String date;
        do {
            System.out.println("Enter date of cats birth: ");
            date = getUserInput();

        } while (!Pattern.matches("[0-9]{1,4}\\.[0-9]{1,2}\\.[0-9]{1,2}", date));
        try {
            cat.setDateBirth(sdf.parse(date));
        } catch (ParseException pe) {
            System.out.println("parse exception");
        }

        String weight;
        do {
            System.out.println("How much does the cat weights? ");
            weight = getUserInput();
        } while (!Pattern.matches("\\d+\\.?\\d*", weight));
        try {
            cat.setWeight(Float.parseFloat(weight));
        } catch (NumberFormatException nfe) {
            System.out.println("parsing gone wrong with float");
        }
        String nameHandler;
        do {
            System.out.println("Enter handler's name: ");
            nameHandler = getUserInput();
        } while (!Pattern.matches(".+", nameHandler));
        cat.setNameHandler(nameHandler);

        cats.addCat(cat);
    }

    private static String getUserInput() {
        return sc.nextLine();
    }
}