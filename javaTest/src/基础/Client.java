package 基础;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 65000);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        os.write(new String("hello world").getBytes());
        int ch = 0;
        byte[] buff = new byte[1024];
        ch = is.read(buff);
        String content = new String(buff, 0, ch);
        System.out.println(content);
        is.close();
        os.close();
        socket.close();
    }
}
