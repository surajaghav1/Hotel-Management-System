import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice customer;
    JTextField tfroom,tfstatus,tfavailable;
    JButton check,update,back;
    UpdateRoom(){
        setVisible(true);
        setLayout(null);
        setBounds(300,200,980,500);
        getContentPane().setBackground(Color.white);

        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Raleway",Font.BOLD,25));
        text.setBounds(30,20,250,30);
        add(text);
        text.setForeground(Color.BLUE);

        JLabel lbid=new JLabel("Customer ID");
        lbid.setBounds(30,80,100,20);
        add(lbid);

        customer=new Choice();
        customer.setBounds(200,80,150,25);
        add(customer);

        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            while (rs.next()){
                customer.add(rs.getString("idnumber"));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        JLabel lbroom=new JLabel("Room Number");
        lbroom.setBounds(30,130,100,20);
        add(lbroom);

        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,20);
        add(tfroom);

        JLabel lbavailable=new JLabel("Availability");
        lbavailable.setBounds(30,180,100,20);
        add(lbavailable);

        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,20);
        add(tfavailable);

        JLabel lbstatus=new JLabel("Cleaning Status ");
        lbstatus.setBounds(30,230,100,20);
        add(lbstatus);

        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,20);
        add(tfstatus);

        check=new JButton("CHECK");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,340,100,30);
        add(check);
        check.addActionListener(this);

        update=new JButton("UPDATE");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,340,100,30);
        add(update);
        update.addActionListener(this);

        back=new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270,340,100,30);
        add(back);
        back.addActionListener(this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String number=customer.getSelectedItem();
            String roomno=tfroom.getText();
            String available=tfavailable.getText();
            String status=tfstatus.getText();


            try {
                Conn conn=new Conn();
               conn.s.executeUpdate("update room set availability='"+available+"',cleaningstatus='"+status+"'where roomno='"+roomno+"'");

                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
                new Reception();

            }catch (Exception e){
                System.out.println(e);
            }
        }

        else if(ae.getSource()==check){
            String id=customer.getSelectedItem();
            String query="select *from customer where idnumber='"+id+"'";
            ResultSet rs;

            try {
                Conn conn=new Conn();
                rs=conn.s.executeQuery(query);
                while (rs.next()){
                    tfroom.setText(rs.getString("roomno"));
                }
                String roomno=tfroom.getText();
                ResultSet rs2=conn.s.executeQuery("select *from room where roomno='"+roomno+"'");
                while (rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaningstatus"));
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error");
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }

    }
    public static void main(String args[])
    {
        new UpdateRoom();
    }
}
