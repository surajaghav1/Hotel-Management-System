import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class SearchRooms extends JFrame implements ActionListener {

    JTable table;
    JButton back,submit;
    JComboBox bedtypecombo;
    JCheckBox available;
    SearchRooms(){
        setVisible(true);
        setLayout(null);
        setBounds(300,200,1000,600);
        getContentPane().setBackground(Color.white);

        JLabel text=new JLabel("Search For Room");
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lbBed=new JLabel("Bed Type");
        lbBed.setBounds(50,100,100,20);
        add(lbBed);

        String bedValues[]={"Single Bed","Double Bed"};
        bedtypecombo=new JComboBox(bedValues);
        bedtypecombo.setBounds(150,100,150,25);
        bedtypecombo.setBackground(Color.white);
        add(bedtypecombo);

        available=new JCheckBox("Only display available");
        available.setBounds(650,100,150,25);
        add(available);
        available.setBackground(Color.white);


        Font font=new Font("Raleway",Font.BOLD,16);

        JLabel l1=new JLabel("Room No");
        l1.setBounds(50,160,100,20);
        l1.setFont(font);
        add(l1);

        JLabel l2=new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        l2.setFont(font);
        add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(450,160,100,20);
        l3.setFont(font);
        add(l3);

        JLabel l5=new JLabel("Price");
        l5.setBounds(670,160,100,20);
        add(l5);
        l5.setFont(font);

        JLabel l4=new JLabel("Bed Type");
        l4.setBounds(870,160,100,20);
        l4.setFont(font);
        add(l4);

        table=new JTable();
        table.setBounds(0,200,1000,300);
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
                String query1="select *from room where bedtype='"+bedtypecombo.getSelectedItem()+"'";
                String query2="select * from room where availability='Available' AND bedtype='"+bedtypecombo.getSelectedItem()+"'";

                Conn conn=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                     rs=conn.s.executeQuery(query2);
                }
                else {
                    rs=conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new SearchRooms();
    }
}
