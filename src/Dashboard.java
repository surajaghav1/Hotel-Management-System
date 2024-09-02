import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Dashboard extends JFrame implements ActionListener, EventListener {
    JMenu admin;

    Dashboard(){
        setVisible(true);
        setLayout(null);
        setBounds(0,0,1550,1000);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        image.add(text);
        text.setFont(new Font("Tahoma", Font.BOLD,46));
        text.setForeground(Color.white);

        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);


        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);
        JMenuItem reception=new JMenuItem("RECEPTION");
        hotel.add(reception);
        reception.addActionListener(this);


         admin=new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        mb.add(admin);


//        admin.addActionListener(this);
//        MenuListener menuListener =new MenuListener() {
//            @Override
//            public void menuSelected(MenuEvent e) {
//                JMenu m=(JMenu)e.getSource();
//               // JOptionPane.showMessageDialog(null,"new Frame ");
//                setVisible(false);
////                new admin_login();
//            }
//            @Override
//            public void menuDeselected(MenuEvent e) {
//            }@Override
//            public void menuCanceled(MenuEvent e) {
//            }
//        };
//        admin.addMenuListener(menuListener);


        JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
        admin.add(addemployee);
        addemployee.addActionListener(this);

        JMenuItem addrooms=new JMenuItem("ADD ROOMS");
        admin.add(addrooms);
        addrooms.addActionListener(this);

        JMenuItem adddrivers=new JMenuItem("ADD DRIVERS");
        admin.add(adddrivers);
        adddrivers.addActionListener(this);

    }

public void actionPerformed(ActionEvent ae){


            if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
                new AddEmployee();
            } else if (ae.getActionCommand().equals("ADD ROOMS")) {
                new AddRooms();
            } else if (ae.getActionCommand().equals("ADD DRIVERS")) {
                new AddDrivers();
            } else if (ae.getActionCommand().equals("RECEPTION")) {
                new Reception();
            }
        }


    public static void main(String args[]){
        new Dashboard();
    }
}
