package ch.heig.dai.lab.protocoldesign;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final String SERVER_ADDRESS = "192.168.105.43";//IP pc serveur
    final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        // Create a new client and run it
        Client client = new Client();
        client.run();
    }

    private void run() {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server at " + SERVER_ADDRESS + ":" + SERVER_PORT);
            System.out.println("Supported operations: ADD, MULT");
            System.out.println("Enter your request in the format: <OPERATION> <NOMBRE1> <NOMBRE2>");
            System.out.println("Type 'quit' to exit.");

            while (true) {
                System.out.print("> ");
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("quit")) {
                    break;
                }

                out.println(userInput);
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}

/*Textual TCP client exemple

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class TextualTCPClient {
    public static void main(String args[]) {

        try (Socket socket = new Socket("localhost", 1234);
             var in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             var out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {

            for (int i = 0; i < 10; i++) {
                // There are two errors here!
                out.write("Hello " + i);
                System.out.println("Echo: " + in.readLine());
            }
        } catch (IOException e) {
            System.out.println("Client: exception while using client socket: " + e);
        }
    }
}
 */