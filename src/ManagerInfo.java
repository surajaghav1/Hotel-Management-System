import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    ManagerInfo(){
        setBounds(300,200,1050,600);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        Font font=new Font("Raleway",Font.BOLD,20);

        JLabel l1=new JLabel("Name");
        l1.setBounds(40,10,100,30);
        add(l1);
        l1.setFont(font);

        JLabel l2=new JLabel("Age");
        l2.setBounds(160,10,100,30);
        add(l2);
        l2.setFont(font);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(280,10,100,30);
        add(l3);
        l3.setFont(font);

        JLabel l4=new JLabel("Job");
        l4.setBounds(410,10,100,30);
        add(l4);
        l4.setFont(font);

        JLabel l5=new JLabel("Salary");
        l5.setBounds(530,10,100,30);
        add(l5);
        l5.setFont(font);

        JLabel l6=new JLabel("Phone No");
        l6.setBounds(640,10,100,30);
        add(l6);
        l6.setFont(font);

        JLabel l7=new JLabel("Email");
        l7.setBounds(780,10,100,30);
        add(l7);
        l7.setFont(font);

        JLabel l8=new JLabel("Aadhar");
        l8.setBounds(900,10,100,30);
        add(l8);
        l8.setFont(font);


        table=new JTable();
        table.setBounds(0,50,1000,400);
        add(table);

        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from employee where job='Manager'");
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
        new ManagerInfo();
    }
}
