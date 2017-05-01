package zj.io.classic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用BIO实现的ServerSocketLoop
 */
class Server implements Runnable {
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9527);
            while (!Thread.interrupted())
                new Thread(new Handler(ss.accept())).start();
            // or, single-threaded, or a thread pool
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static class Handler implements Runnable {
        private static final int MAX_INPUT = 10000;
        final Socket socket;

        Handler(Socket s) {
            socket = s;
        }

        public void run() {
            try {
                byte[] input = new byte[MAX_INPUT];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        private byte[] process(byte[] cmd) {
            return cmd;
        }
    }
}