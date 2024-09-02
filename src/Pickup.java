import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {

    JTable table;
    JButton back,submit;
    Choice typeofCar;
    JCheckBox available;
    Pickup(){
        setVisible(true);
        setLayout(null);
        setBounds(300,200,1000,600);
        getContentPane().setBackground(Color.white);

        JLabel text=new JLabel("Pickup Service");
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lbBed=new JLabel("Type of Car");
        lbBed.setBounds(50,100,100,20);
        add(lbBed);

        typeofCar=new Choice();
        typeofCar.setBounds(150,100,200,25);
        typeofCar.setBackground(Color.white);
        add(typeofCar);

         try {
                Conn conn=new Conn();
                ResultSet rs=conn.s.executeQuery("select *from driver");
                while (rs.next()){
                    typeofCar.add(rs.getString("brand"));
                }
         }
         catch (Exception e){
             System.out.println(e);
         }

        Font font=new Font("Raleway",Font.BOLD,16);

        JLabel l1=new JLabel("Name");
        l1.setBounds(30,160,100,20);
        l1.setFont(font);
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(200,160,100,20);
        l2.setFont(font);
        add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(330,160,100,20);
        l3.setFont(font);
        add(l3);

        JLabel l5=new JLabel("Company");
        l5.setBounds(460,160,100,20);
        add(l5);
        l5.setFont(font);

        JLabel l4=new JLabel("Brand");
        l4.setBounds(630,160,100,20);
        l4.setFont(font);
        add(l4);

        JLabel l6=new JLabel("Availability");
        l6.setBounds(740,160,100,20);
        l6.setFont(font);
        add(l6);

        JLabel l7=new JLabel("Location");
        l7.setBounds(890,160,100,20);
        l7.setFont(font);
        add(l7);

        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        table.setFont(new Font("Raleway",Font.PLAIN,15));

        // insert data to the table dynamically
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e){
            System.out.println(e);
        }

        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        add(back);
        back.addActionListener(this);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        add(submit);
        submit.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
        else if(ae.getSource()==submit){
            try {
                String query1="select *from driver where brand='"+typeofCar.getSelectedItem()+"'";

                Conn conn=new Conn();
                ResultSet rs;
                rs=conn.s.executeQuery(query1);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new Pickup();
    }
}
