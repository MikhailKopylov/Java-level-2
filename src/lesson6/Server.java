package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static int PORT = 8181;

    private ServerSocket server;
    private Socket socket;

    private String consoleMessage;
    private Scanner consoleIn;
    private DataOutputStream out;

    private String messageIn;
    private DataInputStream in;

    public Server() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подсоединен");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            sendConsoleMessage();

            readIncomingMessage();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readIncomingMessage() {
        new Thread(() -> {
            try {
                while (true) {

                    messageIn = in.readUTF();
                    if (messageIn.equals("/end")) {
                        break;
                    }
                    System.out.println("                                                        Client: " + messageIn);
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

    private void sendConsoleMessage() {
        new Thread(() -> {
            try {
                consoleIn = new Scanner(System.in);
                while (true) {
                    consoleMessage = readConsole();
                    if (consoleMessage.equals("/end")) {
                        break;
                    }
                    out.writeUTF(  consoleMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert in != null;
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
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

    private String readConsole() {
        System.out.println("Введите сообщение:");
        return consoleIn.nextLine();
    }
}
