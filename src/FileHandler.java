import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class FileHandler {
    ActivationHandler activationHandler;

    public FileHandler(ActivationHandler activationHandler) {
        this.activationHandler = activationHandler;
    }

    public void newFile() throws IOException {
        System.out.println("\nСтворення нового файлу");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я файлу (без зазначення формату):");
        System.out.print("--> ");
        String answer = scanner.nextLine();
        String fileName = "D:\\Учеба\\Безопасность ПО\\lab1\\Catalogue\\" +  answer + ".txt";
        File file = new File(fileName);
        if(file.createNewFile()) {
            System.out.println("Файл успішно створено!");
        } else {
            System.out.println("Помилка! Файл з такою назвою вже існує");
            return;
        }

        Menu menu = new Menu();
        menu.showOptions();
        System.out.print("--> ");

        answer = scanner.nextLine();
        switch (answer){
            case "1":
                editFile(fileName);
                break;
            case "2":
                renameFile(fileName);
                break;
            case "3":
                deleteFile(fileName);
                break;
            case "4":
                fileLength(fileName);
                break;
            case "5":
                printFile();
                break;
            case "6":
                break;
            default:
                System.out.println("Помилка! Неправильний формат відповіді!");
        }
    }

    public void openFile() throws IOException {
        System.out.println("\nВідкриття файлу");
        System.out.println("Введіть ім'я файлу:");
        System.out.print("--> ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        String fileName = "D:\\Учеба\\Безопасность ПО\\lab1\\Catalogue\\" + answer;
        File file = new File(fileName);
        if(!file.exists()){
            System.out.println("Помилка! Файл з такою назвою не існує!");
            return;
        }
        FileReader fileReader = new FileReader(fileName);
        Scanner scanFile = new Scanner(fileReader);

        while (scanFile.hasNextLine()) {
            System.out.println(scanFile.nextLine());
        }
        fileReader.close();

        Menu menu = new Menu();
        menu.showOptions();
        System.out.print("--> ");

        answer = scanner.nextLine();
        switch (answer){
            case "1":
                editFile(fileName);
                break;
            case "2":
                renameFile(fileName);
                break;
            case "3":
                deleteFile(fileName);
                break;
            case "4":
                fileLength(fileName);
                break;
            case "5":
                printFile();
                break;
            case "6":
                break;
            default:
                System.out.println("Помилка! Неправильний формат відповіді!");
        }
    }

    public void editFile(String fileName) throws IOException {
        System.out.println("\nРедагування файлу");
        FileWriter fileWriter = new FileWriter(fileName, true);
        System.out.println("Введіть ваш текст (введіть q, щоб закінчити):");
        System.out.print("--> ");
        Scanner scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine() + '\n';

        while (!Objects.equals(answer, "q\n")) {
            fileWriter.write(answer);
            System.out.print("--> ");
            answer = scanner.nextLine() + '\n';
        }
        System.out.println("Файл успішно доповнено!");
        fileWriter.close();
    }

    public void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Файл успішно видалено!");
        } else {
            System.out.println("Помилка! Не вдалося видалити файл!");
        }
    }

    public void fileLength(String fileName) {
        if (activationHandler.isActivation()) {
            File file = new File(fileName);
            System.out.println("Розмір файлу: " + file.length() + " байтів");
        } else {
            System.out.println("Ви не маєте доступу до даного інструменту\nу пробній версії продукту");
            activationHandler.accessKey();
        }
    }

    public void renameFile(String fileName) {
        System.out.println("\nПерейменування файлу");
        System.out.println("Введіть нове ім'я (без зазначення формату)");
        System.out.print("-->");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        File file = new File(fileName);
        File file1 = new File("D:\\Учеба\\Безопасность ПО\\lab1\\Catalogue", answer + ".txt");
        if(file.renameTo(file1)) {
            System.out.println("Файл успішно перейменовано!");
        } else {
            System.out.println("Помилка! Не вдалося перейменувати файл");
        }
    }

    public void printFile() {
        System.out.println("Друк файлу...");
    }

    public void showCatalogue() {
        if (activationHandler.isActivation()) {
            File folder = new File("D:\\Учеба\\Безопасность ПО\\lab1\\Catalogue");
            System.out.println("D:\\Учеба\\Безопасность ПО\\lab1\\Catalogue");
            if (folder.listFiles().length == 0) {
                System.out.println("Каталог пустий");
            }
            for (File file : folder.listFiles()) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Ви не маєте доступу до даного інструменту\nу пробній версії продукту");
            activationHandler.accessKey();
        }
    }

    public void search() {
        System.out.println("\nПошук файлу");
        if (activationHandler.isActivation()) {
            System.out.println("Введіть ім'я файлу:");
            System.out.print("--> ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            String fileName = "D:\\Учеба\\Безопасность ПО\\lab1\\Catalogue\\" + answer;
            File file = new File(fileName);
            if (file.exists()) {
                System.out.println("Файл знайдено!");
            } else {
                System.out.println("Файл не знайдено!");
            }
        } else {
            System.out.println("Ви не маєте доступу до даного інструменту\nу пробній версії продукту");
            activationHandler.accessKey();
        }
    }
}
