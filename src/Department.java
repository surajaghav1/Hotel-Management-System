import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    Department(){
        setVisible(true);
        setLayout(null);
        setBounds(400,200,700,480);
        getContentPane().setBackground(Color.white);

        Font font=new Font("Raleway",Font.BOLD,20);
        JLabel l1=new JLabel("Department");
        l1.setBounds(150,10,200,30);
        l1.setFont(font);
        add(l1);

        JLabel l2=new JLabel("Budget");
        l2.setBounds(440,10,200,30);
        add(l2);
        l2.setFont(font);

        table=new JTable();
        table.setBounds(10,50,650,350);
        add(table);
        table.setFont(new Font("Raleway",Font.PLAIN,15));

        // insert data to the table dynamically
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e){
            System.out.println(e);
        }

        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,400,120,30);
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
        new Department();
    }
}
