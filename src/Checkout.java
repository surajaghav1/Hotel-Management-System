import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class Checkout extends JFrame implements ActionListener {
    Choice customerid;
    JLabel lbroomno,lbcheckintime,lbcheckOutTime;
    JButton checkOut,back;
    Checkout(){
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setBounds(300,200,800,400);

        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);

        JLabel lbid=new JLabel("Customer ID");
        lbid.setBounds(30,80,100,30);
        add(lbid);

        customerid=new Choice();
        customerid.setBounds(150,80,150,25);
        add(customerid);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel tick=new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);

        JLabel lbroom=new JLabel("Room No");
        lbroom.setBounds(30,130,100,30);
        add(lbroom);

         lbroomno=new JLabel();
        lbroomno.setBounds(150,130,100,30);
        add(lbroomno);

        JLabel lbchekin=new JLabel("Checkin Time");
        lbchekin.setBounds(30,180,100,30);
        add(lbchekin);

        lbcheckintime=new JLabel();
        lbcheckintime.setBounds(150,180,100,30);
        add(lbcheckintime);

        JLabel lbcheckout=new JLabel("Checkout Time");
        lbcheckout.setBounds(30,230,100,30);
        add(lbcheckout);

        Date date=new Date();
        lbcheckOutTime=new JLabel(""+date);
        lbcheckOutTime.setBounds(150,230,150,30);
        add(lbcheckOutTime);


        checkOut=new JButton("CHEK OUT");
        checkOut.setBounds(30,280,120,30);
        checkOut.setForeground(Color.white);
        checkOut.setBackground(Color.BLACK);
        add(checkOut);
        checkOut.addActionListener(this);

        back=new JButton("BACK");
        back.setBounds(200,280,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        add(back);
        back.addActionListener(this);

        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select *from customer");
            while (rs.next()){
                customerid.add(rs.getString("idnumber"));
                lbroomno.setText(rs.getString("roomno"));
                lbcheckintime.setText(rs.getString("checkin_time"));
            }

        }catch (Exception e){
            System.out.println(e);
        }


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);

        JLabel image=new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkOut){
            String query1="delete from customer where idnumber='"+customerid.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomno='"+lbroomno.getText()+"'";

            try {
                Conn conn=new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Checkout Successfully");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String  args[]){
        new Checkout();
    }
}
