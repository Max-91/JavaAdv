package Homework6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 Написать консольный вариант клиент\серверного приложения,
 в котором пользователь может писать сообщения, как на клиентской стороне,
 так и на серверной. Т.е. если на клиентской стороне написать «Привет»,
 нажать Enter, то сообщение должно передаться на сервер и там отпечататься
 в консоли. Если сделать то же самое на серверной стороне, то сообщение
 передается клиенту и печатается у него в консоли. Есть одна особенность,
 которую нужно учитывать: клиент или сервер может написать несколько
 сообщений подряд. Такую ситуацию необходимо корректно обработать.
 */
/* СЕРВЕРНАЯ ЧАСТЬ */
public class StartServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket ;
        final int PORT = 8189;
        DataInputStream in;
        DataOutputStream out;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Клиент подключился");
            // Поток для чтение
            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            break;
                        }
                        System.out.println("Клиент: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                        in.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            // Поток для отправки
            new Thread(() -> {
                try {
                    while (true) {
                        Scanner sc = new Scanner(System.in);
                        String str= sc.nextLine();
                        if (str.equals("/end")) {
                            break;
                        }
                        out.writeUTF(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                        in.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
