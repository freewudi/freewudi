package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo extends JDialog {
    public Demo(JFrame jFrame){
        super(jFrame,"对话标题",true);
        Container container = getContentPane();
        container.add(new JLabel("这是一个对话框"));
        setBounds(100,100,100,100);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(50,50,300,300);
        Container container = jFrame.getContentPane();
        JButton jButton = new JButton("弹出对话框");
        container.setVisible(true);
        container.add(jButton);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //jFrame.setVisible(true);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Demo demo = new Demo(jFrame);
                demo.setVisible(true);
            }
        });
    }
}
