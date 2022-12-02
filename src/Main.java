import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        /* Initialize two maps for two databases:
         * usersData is for saving id as key and User object as value
         * usersDataNick is for saving username as key and password as value
         */

        Map<String, User> usersData = new HashMap<>();
        Map<String, String> usersDataNick = new HashMap<>();

        System.out.println("Hi, there! Make your choice! If you want to register new user press 1 " +
                "\n If you want to login - press 2 " +
                "\n If you want to find user by ID - press 3!" +
                "\n If you want to exit - press 4!");

        makeChoice(usersData, usersDataNick);

        // printing all users list
        System.out.println(usersData);
    }

    /**
     * In the method user can make his choise: register, login,
     * find user by id or exit
     *
     * @param usersData     - database for finding by id
     * @param usersDataNick - database for login user
     */
    private static void makeChoice(Map<String, User> usersData, Map<String, String> usersDataNick) {
        Scanner scanner = new Scanner(System.in);
        int num;
        User user;
        while (scanner.hasNextInt()) {

            num = scanner.nextInt();

            switch (num) {
                case 1:
                    user = new User();
                    user.addUser();
                    usersData.put(user.getId(), user);
                    usersDataNick.put(user.getUsername(), user.getPassword());
                    System.out.println(user.getFirstName() + "! You are registered!");
                    break;
                case 2:
                    try {
                        loginUser(usersDataNick);
                        break;
                    } catch (UserNameOrPasswIsWrong e) {
                        System.out.println("" + e.getMessage());
                        break;
                    }
                case 3:
                    System.out.println("Please, write id: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String k = scanner1.next();
                    try {
                        findUserById(usersData, k);
                        break;
                    } catch (UserIsNotFoundException ex) {
                        System.out.println(" " + ex.getMessage());
                        break;
                    }
                case 4:
                    System.exit(0);
            }
            System.out.println("Make your choice! If you want to register new user press 1 " +
                    "\n If you want to login - press 2 " +
                    "\n If you want to find user by ID - press 3!" +
                    "\n If you want to exit - press 4!");
        }
    }

    private static void loginUser(Map<String, String> usersDataNick) throws UserNameOrPasswIsWrong {
        System.out.println("Input your nickname: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Input your password: ");
        Scanner pas = new Scanner(System.in);
        String passw = pas.nextLine();

        if ((usersDataNick.containsKey(name)) && (usersDataNick.containsValue(passw))) {
            System.out.println("You are logging! Congrats!");
        } else {
            throw new UserNameOrPasswIsWrong("Wrong nickname or password!");

        }

    }

    private static void findUserById(Map<String, User> usersData, String k) throws UserIsNotFoundException {
        if ((!usersData.isEmpty()) && (usersData.containsKey(k))) {
            System.out.println("Find user for id! The user is: " + usersData.get(k).getFirstName());
        } else {
            throw new UserIsNotFoundException("There is not user with this ID!");
        }
    }
}

