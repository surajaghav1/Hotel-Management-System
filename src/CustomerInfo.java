import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    CustomerInfo(){
        setBounds(300,200,1050,600);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        Font font=new Font("Raleway",Font.BOLD,14);

        JLabel l1=new JLabel("Document Type");
        l1.setBounds(0,10,150,30);
        add(l1);
        l1.setFont(font);

        JLabel l2=new JLabel("Document No");
        l2.setBounds(135,10,150,30);
        add(l2);
        l2.setFont(font);

        JLabel l3=new JLabel("Name");
        l3.setBounds(260,10,100,30);
        add(l3);
        l3.setFont(font);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(350,10,100,30);
        add(l4);
        l4.setFont(font);

        JLabel l5=new JLabel("Country");
        l5.setBounds(460,10,100,30);
        add(l5);
        l5.setFont(font);

        JLabel l6=new JLabel("Deposite");
        l6.setBounds(560,10,100,30);
        add(l6);
        l6.setFont(font);

        JLabel l7=new JLabel("Checkin Time");
        l7.setBounds(680,10,150,30);
        add(l7);
        l7.setFont(font);

        JLabel l8=new JLabel("Room No");
        l8.setBounds(800,10,100,30);
        add(l8);
        l8.setFont(font);

        JLabel l9=new JLabel("Mobile No");
        l9.setBounds(900,10,100,30);
        add(l9);
        l9.setFont(font);


        table=new JTable();
        table.setBounds(0,50,1000,400);
        add(table);

        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }

        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,450,120,30);
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
        new CustomerInfo();
    }
}
