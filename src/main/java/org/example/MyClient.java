package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

    public void start(final int portNumber, final Scanner scanner) {
        try (var socket = new Socket("localhost", portNumber);
            var writer = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println("Socket created");
            for (String userInput; !(userInput = scanner.nextLine()).isEmpty();) {
                writer.println(UserInput);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
