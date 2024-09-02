import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    Rooms(){
    setVisible(true);
    setLayout(null);
    setBounds(300,200,1100,600);
    getContentPane().setBackground(Color.white);


    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
    Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(510,0,600,600);
    add(image);

    Font font=new Font("Raleway",Font.BOLD,16);

    JLabel l1=new JLabel("Room NO");
    l1.setBounds(10,10,100,20);
    l1.setFont(font);
    add(l1);

    JLabel l2=new JLabel("Availability");
    l2.setBounds(110,10,100,20);
    l2.setFont(font);
    add(l2);

    JLabel l3=new JLabel("Status");
    l3.setBounds(230,10,100,20);
    l3.setFont(font);
    add(l3);

    JLabel l5=new JLabel("Price");
    l5.setBounds(330,10,100,20);
    add(l5);
    l5.setFont(font);

    JLabel l4=new JLabel("Bed Type");
    l4.setBounds(410,10,100,20);
    l4.setFont(font);
    add(l4);

    table=new JTable();
    table.setBounds(0,40,500,400);
    add(table);
    table.setFont(new Font("Raleway",Font.PLAIN,15));

    // insert data to the table dynamically
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e){
            System.out.println(e);
        }

        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        add(back);
        back.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String args[]){
        new Rooms();
    }
}
