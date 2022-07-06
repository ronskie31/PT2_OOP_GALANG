import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class accountgenerator {

    // instance variables
    private String name;
    private String username;
    private String email;
    private String password;

    public accountgenerator() {
        name = setName();
        username = setUsername(name);
        email = setEmail(username);
        password = setPassword(username);
    }

    private int countChars(String s, char p) {

        int count = 0;
        for (int x = 0; x < s.length(); x++) { // will count the number of times the char appears in a String
            if (s.charAt(x) == p)
                count++;
        }
        return count;
    } // end

    // methods for instance variables

    private String setName() {

        int count;
        String name = "";

        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("[a-zA-Z]+\\s[a-zA-Z]+.+");

        System.out.print("Enter your Full name: ");
        name = in.nextLine();
        Matcher m = p.matcher(name);
        boolean b = m.matches();

        if (b != true) {
            System.out.println("Incorrect format for name");
        } else {
            count = countChars(name, ' ');
        }
        return name;

    }

    // G

    private String setUsername(String name) {
        return name.replace(' ', '.').toLowerCase();
    }

    // H

    private String setEmail(String username) {
        return username.charAt(0) + username.substring(username.indexOf('.') + 1) + "@oracleacademy.Test";
    }

    // I

    private String setPassword(String username) {
        String password = "";

        // loop over the username or until 8 characters have been added to password
        for (int i = 0; i < username.length() && i < 8; i++) {
            // replace all vowels by *
            if (username.charAt(i) == 'a' || username.charAt(i) == 'e' || username.charAt(i) == 'i'
                    || username.charAt(i) == 'o' || username.charAt(i) == 'u')
                password += "*";
            else // add all the consonants to password
                password += username.charAt(i);
        }

        // password length < 8, append * to password
        while (password.length() < 8)
            ;
        password += "*";

        // loop to find the first alphabetic character and convert it to uppercase
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) != '*') {
                password = password.substring(0, i) + (password.charAt(i) + "").toUpperCase()
                        + password.substring(i + 1);
                break;
            }
        }

        return password;
    }

    public String toString() {
        return "Employee Details\nName : " + name + "\nUsername : " + username + "\nEmail : " + email
                + "\nInitial Password : " + password;
    }

    public static void main(String[] args) {

        accountgenerator acc1 = new accountgenerator();

        System.out.println(acc1);
    }
}
