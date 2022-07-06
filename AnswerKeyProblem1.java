import java.util.regex.*;
import java.io.*;

public class AnswerKeyProblem1 {

    /* For No. 4 */
    static String finalAnswers(String answers) {
        String a, b, c, d;
        a = answers.replace('e', 'b');
        b = a.replace('E', 'A');
        c = b.replace('f', 'c');
        d = c.replace('F', 'D');
        System.out.println("The answers are: ");
        for (int i = 0; i < d.length(); i++) {
            char x = d.charAt(i);
            char y = Character.toLowerCase(x);
            System.out.println(y);
        }
        return d;
    }

    public static void main(String args[]) throws IOException {
        String answers = "";
        // read file
        BufferedReader codedAnswers = new BufferedReader(
                new FileReader(new File("E:/FILES/VSCODE/PT2_OOP_GALANG/CodedAnswerKey.txt")));
        // initialize string line as the first line of the file
        String line = codedAnswers.readLine();

        // keep reading each line and adding answers that match answer
        // possibilities to string answers until there are no more lines ni the file
        while (line != null) {
            if (line.matches("[a-fA-F]")) {
                answers = answers + line;
            }
            // read the next line of the file
            line = codedAnswers.readLine();
        }

        System.out.println("The answers are: ");
        for (int i = 0; i < answers.length(); i++) {
            System.out.println(answers.charAt(i));
        }

        finalAnswers(answers);
    }

}