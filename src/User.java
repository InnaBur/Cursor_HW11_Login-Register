import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {


    private String id = createID();
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    //public Map<Integer, User> users = new HashMap<>();

 /*   public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

  */

    private static long idCounter = 0;

    public static String createID()
    {
        return String.valueOf(idCounter++);
    }
    public User() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addUser() {

//        var scanner = new Scanner(System.in);
        String[] array = new String[4];
        for (int i = 0; i < 1; i++) {
            switch (i) {
                case (0):
                    Scanner username = new Scanner(System.in);
                    System.out.println("Input your nickname: ");
                    String u = username.nextLine();
                    array[0] = u;
                case (1):
                    Scanner password = new Scanner(System.in);
                    System.out.println("Input your password: ");
                    String p = password.nextLine();
                    array[1] = p;
                case (2):
                    Scanner name = new Scanner(System.in);
                    System.out.println("Input your name: ");
                    String n = name.nextLine();
                    array[2] = n;
                case (3):
                    Scanner lastName = new Scanner(System.in);
                    System.out.println("Input your last name: ");
                    String l = lastName.nextLine();
                    array[3] = l;
            }

        }

        this.username = array[0];
        this.password = array[1];
        this.firstName = array[2];
        this.lastName = array[3];



    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }


}
