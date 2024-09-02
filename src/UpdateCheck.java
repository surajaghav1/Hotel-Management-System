import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    Choice customer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton check,update,back;
    UpdateCheck(){
        setVisible(true);
        setLayout(null);
        setBounds(300,200,980,500);
        getContentPane().setBackground(Color.white);

        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Raleway",Font.BOLD,25));
        text.setBounds(90,20,200,30);
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
        lbroom.setBounds(30,120,100,20);
        add(lbroom);

        tfroom=new JTextField();
        tfroom.setBounds(200,120,150,20);
        add(tfroom);

        JLabel lbname=new JLabel("Name");
        lbname.setBounds(30,160,100,20);
        add(lbname);

        tfname=new JTextField();
        tfname.setBounds(200,160,150,20);
        add(tfname);

        JLabel lbcheck=new JLabel("Checkin Time");
        lbcheck.setBounds(30,200,100,20);
        add(lbcheck);

        tfcheckin=new JTextField();
        tfcheckin.setBounds(200,200,150,20);
        add(tfcheckin);

        JLabel lbpaid=new JLabel("Amount Paid");
        lbpaid.setBounds(30,240,100,20);
        add(lbpaid);

        tfpaid=new JTextField();
        tfpaid.setBounds(200,240,150,20);
        add(tfpaid);

        JLabel lbpending=new JLabel("Pending Amount");
        lbpending.setBounds(30,280,100,20);
        add(lbpending);

        tfpending=new JTextField();
        tfpending.setBounds(200,280,150,20);
        add(tfpending);

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

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(450,50,500,300);
        add(image);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String number=customer.getSelectedItem();
            String roomno=tfroom.getText();
            String name=tfname.getText();
            String checkin=tfcheckin.getText();
            String deposite=tfpaid.getText();

            try {
                Conn conn=new Conn();
                conn.s.executeUpdate("update customer set roomno='"+roomno+"',name='"+name+"',checkin_time='"+checkin+"',deposite='"+deposite+"'where idnumber='"+number+"'");
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
            String ramt = null;
            Conn conn=new Conn();
            rs=conn.s.executeQuery(query);
            while (rs.next()){
                tfroom.setText(rs.getString("roomno"));
                tfname.setText(rs.getString("name"));
                tfcheckin.setText(rs.getString("checkin_time"));
                tfpaid.setText(rs.getString("deposite"));
                ramt=rs.getString("deposite");
            }
            String roomno=tfroom.getText();
            ResultSet rs2=conn.s.executeQuery("select *from room where roomno='"+roomno+"'");
            while (rs2.next()){
                    int price=rs2.getInt(4);
                    int amt=Integer.parseInt(tfpaid.getText());
                    int amountPaid=price - amt;
                    tfpending.setText(""+amountPaid);
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
    public static void main(String args[]){
        new UpdateCheck();
    }
}
