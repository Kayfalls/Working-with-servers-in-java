package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class MyServer {
    public void start(final int portNumber) {
        // Server Socket (a server which is listening for connection attempts from these various clients)
        // Server Socket has the port number because it needs to LISTEN on a specific
        // address that clients can find and connect to. The port is the "door" the
        // server opens — clients must knock on that exact port to reach this server.
        try (var serverSocket = new ServerSocket(portNumber)) {
            // The accept() method BLOCKS — the server pauses here and waits until a client
            // actually connects. Once a client connects, it returns a new Socket object
            // representing that specific client's connection, and execution continues.
            var socket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
