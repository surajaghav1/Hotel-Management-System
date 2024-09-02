import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JButton addRoom,cancel;
    JTextField tfprice,tfroom;
    JComboBox bedCombo,cleanCombo,availableCombo;

    AddRooms(){
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setBounds(330,200,940,470);

        Font font=new Font("Raleway",Font.PLAIN,16);
        JLabel heading=new JLabel("ADD ROOMS");
        heading.setBounds(150,20,200,20);
        add(heading);
        heading.setFont(new Font("Raleway",Font.BOLD,18));

        JLabel roomno=new JLabel("Room Number");
        roomno.setBounds(60,80,120,30);
        roomno.setFont(font);
        add(roomno);

         tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel roomAvailable=new JLabel("Available");
        roomAvailable.setBounds(60,130,120,30);
        roomAvailable.setFont(font);
        add(roomAvailable);

        String availableValues[]={"Available","Occupied"};
         availableCombo=new JComboBox(availableValues);
        availableCombo.setBounds(200,130,150,30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);

        JLabel cleanStatus=new JLabel("Cleaning Status");
        cleanStatus.setBounds(60,180,120,30);
        cleanStatus.setFont(font);
        add(cleanStatus);

        String cleanValues[]={"Clean","Dirty"};
         cleanCombo=new JComboBox(cleanValues);
        cleanCombo.setBounds(200,180,150,30);
        cleanCombo.setBackground(Color.white);
        add(cleanCombo);

        JLabel price=new JLabel("Price");
        price.setFont(font);
        price.setBounds(60,230,130,30);
        add(price);

         tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel bedType=new JLabel("Bed Type");
        bedType.setBounds(60,280,130,30);
        bedType.setFont(font);
        add(bedType);

        String bedValues[]={"Single Bed","Double Bed"};
         bedCombo=new JComboBox(bedValues);
        bedCombo.setBounds(200,280,150,30);
        bedCombo.setBackground(Color.white);
        add(bedCombo);

         addRoom=new JButton("Add Room");
        addRoom.setBounds(60,350,130,30);
        addRoom.setBackground(Color.black);
        addRoom.setForeground(Color.white);
        add(addRoom);
        addRoom.addActionListener(this);

         cancel=new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,350);
        add(image);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
        }
        if (ae.getSource()==addRoom){
            String roomno=tfroom.getText();
            String availability=(String)availableCombo.getSelectedItem();
            String status=(String)cleanCombo.getSelectedItem();
            String type=(String)bedCombo.getSelectedItem();
            String price=tfprice.getText();

            number_validation Number_valid=new number_validation();
            if(roomno.equals("")||price.equals("")){
                JOptionPane.showMessageDialog(null,"All fields are Mandatory");
            }
            else if(!Number_valid.containsOnlyNumbers(roomno)){
                JOptionPane.showMessageDialog(null,"Please enter Correct Room no");
            }
            else if(!Number_valid.containsOnlyNumbers(price)){
                JOptionPane.showMessageDialog(null,"Please enter valid Price\n ONLY Numbers allowed");
            }

            try {
                Conn c=new Conn();
                String query="insert into room values('"+roomno+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }
    public static void main(String args[]){
        new AddRooms();
    }
}
