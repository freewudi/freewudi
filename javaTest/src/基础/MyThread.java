package 基础;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyThread extends Thread{
    private Socket socket;

    public MyThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            int ch = 0;
            byte[] buff = new byte[1024];
            ch = is.read(buff);
            String content = new String(buff, 0, ch);
            System.out.println(content);
            os.write(String.valueOf(content.length()).getBytes());

            is.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
