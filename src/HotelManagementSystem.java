import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JButton next;
    HotelManagementSystem(){
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,1366,565);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        add(image);
        image.setBounds(0,0,1366,565);

        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setFont(new Font("serit",Font.PLAIN,50));
        text.setForeground(Color.WHITE);
        image.add(text);

        next=new JButton("NEXT");
        next.setBounds(1150,450,150,50);
        image.add(next);
        next.setBackground(Color.white);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);

        while (true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();

    }

    public static void main(String args[]){
        new HotelManagementSystem();
    }
}
