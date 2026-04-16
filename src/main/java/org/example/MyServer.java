package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class MyServer {
    public void start(final int portNumber) {
        // Server Socket (a server which is listening for connection attempts from these various clients)
        // Server Socket has the port number because it needs to LISTEN on a specific
        // address that clients can find and connect to. The port is the "door" the
        // server opens — clients must knock on that exact port to reach this server.
        try (var serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Waiting for client");
            // The accept() method BLOCKS — the server pauses here and waits until a client
            // actually connects. Once a client connects, it returns a new Socket object
            // representing that specific client's connection, and execution continues.
            var client = serverSocket.accept();
            var clientIp = client.getInetAddress().getHostAddress();
            var clientPort = client.getPort();
            var clientInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
            // This for loop uses an unusual but valid form: the initializer declares the variable,
            // and the condition both reads a line AND checks if it's null in one step.
            // readLine() returns null when the client disconnects — so the loop runs for as long
            // as the client is sending data, and exits cleanly the moment they disconnect.
            for (String inputLine; (inputLine = clientInput.readLine()) != null;) {

                // STR."..." is a Java 21 String Template (preview feature). The \{...} syntax
                // interpolates variables directly into the string — cleaner than concatenation
                // or String.format(). This prints who sent the message and what they said.
                System.out.println(String.format("(%s:%s): %s", clientIp, clientPort, inputLine));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
