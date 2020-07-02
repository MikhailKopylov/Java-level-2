package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String IP_ADDRESS = "localhost";

    private Socket socket;
    private String consoleMessage;
    private Scanner consoleIn;
    private DataOutputStream out;

    private String messageIn;
    private DataInputStream in;

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS, Server.PORT);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            sendConsoleMessage();

            readIncomingMessage();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendConsoleMessage() {
        new Thread(() -> {
            consoleIn = new Scanner(System.in);
            try {
                while (true) {
                    System.out.println("Введите новое сообщение");
                    consoleMessage = consoleIn.nextLine();
                    if (consoleMessage.equals("/end")) {
                        break;
                    }
                    out.writeUTF(consoleMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void readIncomingMessage() {
        new Thread(() -> {
            try {
                while (true) {
                    messageIn = in.readUTF();
                    System.out.println("                                                        Server: " + messageIn);
                    System.out.println("Введите сообщение:");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
