import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ActivationHandler {
    private boolean activation;
    private Timer timer;

    public void launchWindow() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                showMessage();
            }
        };
        timer.schedule(timerTask, 0, 300000);
    }

    public void showMessage() {
        System.out.println("\n****************************************");
        System.out.println("Зареєструйтеся і отримайте повний доступ\nдо інструментів програми");
        System.out.println("****************************************");

    }

    public void accessKey() {
        if(activation) {
            System.out.println("Повний доступ до програми вже надано");
            return;
        }
        System.out.println("Бажаєте ввести ключ доступу?");
        System.out.println("1. так     2. ні");
        System.out.print("--> ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                checkKey();
                break;
            case "2":
                break;
            case "3":
                System.out.println("Неправильний формат відповіді");
        }
    }

    private void stopWindow() {
        if(timer != null) {
            timer.cancel();
        }
    }

    private void checkKey() {
        System.out.println("Будь ласка, введіть ключ доступу");
        System.out.print("--> ");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        CaesarCode caesarCode = new CaesarCode();
        String codedKey = caesarCode.code(key, 3);
        if (Objects.equals(codedKey, "nhb")) {
            stopWindow();
            setActivation(true);
            System.out.println("Повний доступ до програми надано");
        } else {
            System.out.println("Ключ неправильний!");
        }
    }

    public boolean isActivation() {
        return activation;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }
}
