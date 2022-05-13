/*
* Nagware
* Діалогове вікно нагадування про реєстрацію програми через кожні 5 хвилин роботи з нею
* Цезаря*/

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ActivationHandler activationHandler = new ActivationHandler();
        activationHandler.launchWindow();

        Menu menu = new Menu();

        while (true) {
            menu.showMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("--> ");
            String option = scanner.nextLine();

            FileHandler fileHandler = new FileHandler(activationHandler);
            switch (option) {
                case "1":
                    fileHandler.newFile();
                    break;
                case "2":
                    fileHandler.openFile();
                    break;
                case "3":
                    fileHandler.showCatalogue();
                    break;
                case "4":
                    fileHandler.search();
                    break;
                case "5":
                    activationHandler.accessKey();
                    break;
                case "h":
                    menu.showHelp();
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Неправильний формат відповіді!");
            }
        }
    }
}
