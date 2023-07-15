import java.util.Scanner;

public class LoginApp {

    static boolean active = true; // we declared it here to be accessible
    static int attemptCount = 3;

    public static void main(String[] args) {

        // Allow the user to log in to the application with 3 login attempts.
        // When the user exhausts the attempts, disable the account. If the user enters the correct credentials, grant access.

        Scanner scanner = new Scanner(System.in);

        if (active) {
            if (attemptCount > 0) {

                while (active) {
                    System.out.println("Enter your username:");
                    String username = scanner.nextLine();

                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();

                    boolean result = login(username, password);

                    if (result) {
                        System.out.println("You have successfully logged into the application.");
                        break;
                    } else {
                        continue;
                    }
                }

            } else {
                System.out.println("You have exhausted your login attempts. Your account has been blocked.");
            }
        } else {
            System.out.println("Your account is inactive. Please contact your administrator.");
        }

        scanner.close();
    }

    public static boolean login(String username, String password) {
        if (username.equals("samuelmeto") && password.equals("Mert167.")) {
            return true;
        } else {
            attemptCount--;
            System.out.println("Invalid username or password.");
            if (attemptCount == 0) {
                active = false;
            }
            return false;
        }
    }
}
