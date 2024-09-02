import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class admin_login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    admin_login(){
        setLayout(null);
        setBounds(500,200,600,300);
        getContentPane().setBackground(Color.white);
        setVisible(true);

        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        password=new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);

        login=new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        add(login);
        login.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String user=username.getText();
            String pass=password.getText();
            try {
                Conn c=new Conn();
                String query="select *from admin where username='"+user+"'and password='"+pass+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Usrname or Password");
                    setVisible(false);
                }
            }catch (Exception e){
                System.out.println(e);
            }

        }
        if (ae.getSource()==cancel){
            setVisible(false);
        }

    }
    public static void main(String args[]){
        new admin_login();
    }
}
