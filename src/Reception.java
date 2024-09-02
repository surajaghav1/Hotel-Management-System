import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    JButton newCustomer,rooms,department,allEmployee,customers,managerinfo,checkout,pickup,searchRoom,update,roomStatus,logout;
Reception(){
    setLayout(null);
    setBounds(350,200,800,570);
    setVisible(true);
    getContentPane().setBackground(Color.white);

    newCustomer=new JButton("New Customer Form");
    newCustomer.setBackground(Color.black);
    newCustomer.setForeground(Color.white);
    newCustomer.setBounds(10,30,200,30);
    add(newCustomer);
    newCustomer.addActionListener(this);

    rooms=new JButton("Rooms");
    rooms.setBackground(Color.black);
    rooms.setForeground(Color.white);
    rooms.setBounds(10,70,200,30);
    add(rooms);
    rooms.addActionListener(this);

    department=new JButton("Department");
    department.setBounds(10,110,200,30);
    department.setBackground(Color.BLACK);
    department.setForeground(Color.white);
    add(department);
    department.addActionListener(this);

    allEmployee=new JButton("All Employee");
    allEmployee.setBounds(10,150,200,30);
    allEmployee.setBackground(Color.BLACK);
    allEmployee.setForeground(Color.white);
    add(allEmployee);
    allEmployee.addActionListener(this);

    customers=new JButton("Customer Info");
    customers.setForeground(Color.white);
    customers.setBackground(Color.BLACK);
    customers.setBounds(10,190,200,30);
    add(customers);
    customers.addActionListener(this);

    managerinfo=new JButton("Manager Info");
    managerinfo.setForeground(Color.white);
    managerinfo.setBackground(Color.BLACK);
    managerinfo.setBounds(10,230,200,30);
    add(managerinfo);
    managerinfo.addActionListener(this);

    checkout=new JButton("Checkout");
    checkout.setForeground(Color.white);
    checkout.setBackground(Color.BLACK);
    checkout.setBounds(10,270,200,30);
    add(checkout);
    checkout.addActionListener(this);

    update=new JButton("Update Status");
    update.setForeground(Color.white);
    update.setBackground(Color.BLACK);
    update.setBounds(10,310,200,30);
    add(update);
    update.addActionListener(this);

    roomStatus=new JButton("Update Room Status");
    roomStatus.setForeground(Color.white);
    roomStatus.setBackground(Color.BLACK);
    roomStatus.setBounds(10,350,200,30);
    add(roomStatus);
    roomStatus.addActionListener(this);

    pickup=new JButton("Pickup Service");
    pickup.setForeground(Color.white);
    pickup.setBackground(Color.BLACK);
    pickup.setBounds(10,390,200,30);
    add(pickup);
    pickup.addActionListener(this);

    searchRoom=new JButton("Search Room");
    searchRoom.setForeground(Color.white);
    searchRoom.setBackground(Color.BLACK);
    searchRoom.setBounds(10,430,200,30);
    add(searchRoom);
    searchRoom.addActionListener(this);

    logout=new JButton("Logout");
    logout.setForeground(Color.white);
    logout.setBackground(Color.BLACK);
    logout.setBounds(10,470,200,30);
    add(logout);
    logout.addActionListener(this);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
    JLabel image=new JLabel(i1);
    image.setBounds(250,30,500,470);
    add(image);

}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==newCustomer){
        setVisible(false);
        new AddCustomer();
    }
   else if(ae.getSource()==rooms){
        setVisible(false);
        new Rooms();
    }
   else if(ae.getSource()==department){
       setVisible(false);
       new Department();
    }
   else if(ae.getSource()==allEmployee){
       setVisible(false);
       new EmployeeInfo();
    }
   else if(ae.getSource()==managerinfo){
       setVisible(false);
       new ManagerInfo();
    }
   else if(ae.getSource()==customers){
       setVisible(false);
       new CustomerInfo();
    }
   else if(ae.getSource()==searchRoom){
       setVisible(false);
       new SearchRooms();
    }
   else if(ae.getSource()==update){
       setVisible(false);
       new UpdateCheck();
    }
   else if(ae.getSource()==roomStatus){
       setVisible(false);
       new UpdateRoom();
    }
   else if(ae.getSource()==pickup){
       setVisible(false);
       new Pickup();
    }
   else if(ae.getSource()==checkout){
       setVisible(false);
       new Checkout();
    }
   else if(ae.getSource()==logout){
       setVisible(false);
       JOptionPane.showMessageDialog(null,"Logout Successfully ");
       System.exit(0);

    }
}

public static void main(String args[]){
    new Reception();
}
}
