/**
 * 
 */
/**
 * @author zhangjuan
 *
 */
package Utils;





import java.util.Scanner;

public class JmossUtils {
    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Invalid input -- You have not entered a number.");
            System.out.println("Pleas enter again.");
            scanner.next();
            return getInt();
        }
    }
}























