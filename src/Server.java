import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(65000);
        while (true) {
            Socket socket = ss.accept();
            new MyThread(socket).start();
        }
    }
}
