import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        // Create a new server and run it
        Server server = new Server();
        server.run();
    }

    private void run() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    String request = in.readLine();
                    if (request != null) {
                        String response = handleRequest(request);
                        out.println(response);
                    }
                } catch (Exception e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private String handleRequest(String request) {
        String[] parts = request.split(" ");
        if (parts.length != 3) {
            return "ERROR Requête Invalide";
        }

        String operation = parts[0];
        int number1, number2;

        try {
            number1 = Integer.parseInt(parts[1]);
            number2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return "ERROR Requête Invalide";
        }

        switch (operation) {
            case "ADD":
                return "RESULT " + (number1 + number2);
            case "MULT":
                return "RESULT " + (number1 * number2);
            default:
                return "ERROR Requête Invalide";
        }
    }
}



/*Textual TCP server exemple

import java.io.*;
import java.net.*;
import static java.nio.charset.StandardCharsets.*;

class TextualTCPServer {
    public static void main(String args[]) {

        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (true) {

                try (Socket socket = serverSocket.accept();
                     var in = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
                     var out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), UTF_8))) {

                    String line;
                    while ((line = in.readLine()) != null) {
                        // There are two errors here!
                        out.write(line);
                    }

                } catch (IOException e) {
                    System.out.println("Server: socket ex.: " + e);
                }
            }
        } catch (IOException e) {
            System.out.println("Server: server socket ex.: " + e);
        }
    }
}
 */