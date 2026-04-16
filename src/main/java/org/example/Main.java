import org.example.MyServer;

import java.util.Scanner;

final int PORT_NUMBER = 12345;

void main() {
    /*
    * First the code creates a scanner over system.in using try with resources meaning that
        at the end of the try block we are going to close the scanner.
    * We prompt the uer for a yes or a no
    * if we do get a y character, we will start a server
    * otherwise we will create a client
    *  */
    try (var scanner = new Scanner(System.in)) {
        System.out.println("Is this a server? (y/n)");
        if (scanner.nextline().equalsIgnoreCase("y")) {
            new MyServer().start(PORT_NUMBER);
        } else {
            System.out.println("Client TODO");
        }
    }
}