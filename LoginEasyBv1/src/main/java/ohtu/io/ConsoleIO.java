
package ohtu.io;

import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleIO implements IO {
    private Scanner scanner;
    
    public ConsoleIO() {
        scanner = new Scanner(System.in);
    }
    
    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    public int readInt(String prompt) {
        System.out.print(prompt+" ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String readLine(String prompt) {
        System.out.print(prompt+" ");
        return scanner.nextLine();
    }
    
}
