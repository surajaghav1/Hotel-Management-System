import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysql_transaction extends JFrame implements ActionListener {
    JButton check;
    JTextField t1,t2;
    mysql_transaction(){
        setVisible(true);
        setLayout(null);
        setBounds(100,100,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel amount=new JLabel("AMT");
        amount.setBounds(10,10,100,30);
        add(amount);
        t1=new JTextField();
        t1.setBounds(110,10,100,30);
        add(t1);

        check=new JButton("CHECK");
        add(check);
        check.setBounds(100,100,100,40);
        check.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try {
            Connection c=null;
            Statement s=null;
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_demo","root","");
            s=c.createStatement();
            ResultSet rs=s.executeQuery("select * from transaction where UserName='Suraj'");

//            Conn conn=new Conn();
//            ResultSet rs=conn.s.executeQuery("select * from room where roomno='101'");
            while (rs.next()){
                int amt=rs.getInt(4);
                int n=100;
                int ans=amt-n;
                t1.setText(""+ans);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String ar[]){
        new mysql_transaction();
    }
}
