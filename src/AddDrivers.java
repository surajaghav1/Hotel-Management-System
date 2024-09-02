import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {
    JButton addDriver,cancel;
    JTextField tfage,tfname,tfcarcomp,tfcarModel,tflocation;
    JComboBox genderCombo,availableCombo;

    AddDrivers(){
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setBounds(300,200,980,470);

        Font font=new Font("Raleway",Font.PLAIN,16);
        JLabel heading=new JLabel("ADD DRIVERS");
        heading.setBounds(150,10,200,20);
        add(heading);
        heading.setFont(new Font("Raleway",Font.BOLD,18));

        JLabel name=new JLabel("Name");
        name.setBounds(60,70,120,30);
        name.setFont(font);
        add(name);

        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);

        JLabel age=new JLabel("Age");
        age.setBounds(60,110,120,30);
        age.setFont(font);
        add(age);

        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);

        JLabel gender=new JLabel("Gedner");
        gender.setBounds(60,150,120,30);
        gender.setFont(font);
        add(gender);

        String genderValues[]={"Male","Female"};
        genderCombo=new JComboBox(genderValues);
        genderCombo.setBounds(200,150,150,30);
        genderCombo.setBackground(Color.white);
        add(genderCombo);

        JLabel car=new JLabel("Car Company");
        car.setFont(font);
        car.setBounds(60,190,130,30);
        add(car);

        tfcarcomp=new JTextField();
        tfcarcomp.setBounds(200,190,150,30);
        add(tfcarcomp);

        JLabel carModel=new JLabel("Car Model");
        carModel.setBounds(60,230,130,30);
        carModel.setFont(font);
        add(carModel);

        tfcarModel=new JTextField();
        tfcarModel.setBounds(200,230,150,30);
        add(tfcarModel);

        JLabel available=new JLabel("Available");
        available.setBounds(60,270,130,30);
        available.setFont(font);
        add(available);

        String availableValues[]={"Available","Busy"};
        availableCombo =new JComboBox(availableValues);
        availableCombo.setBackground(Color.white);
        availableCombo.setBounds(200,270,150,30);
        add(availableCombo);

        JLabel location=new JLabel("Location");
        location.setBounds(60,310,130,30);
        location.setFont(font);
        add(location);

        tflocation=new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);

        addDriver=new JButton("Add Driver");
        addDriver.setBounds(60,370,130,30);
        addDriver.setBackground(Color.black);
        addDriver.setForeground(Color.white);
        add(addDriver);
        addDriver.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBounds(220,370,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,350);
        add(image);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
        }
        if (ae.getSource()==addDriver) {

            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String comapany = tfcarcomp.getText();
            String brand = tfcarModel.getText();
            String available = (String) availableCombo.getSelectedItem();
            String location = tflocation.getText();

            name_validation Name_valid = new name_validation();
            number_validation Number = new number_validation();

            if (name.equals("") || age.equals("") || gender.equals("") || comapany.equals("") || brand.equals("") || available.equals("") || location.equals("")) {
                JOptionPane.showMessageDialog(null, "All Fields Are Mandatory");
            } else if (!Name_valid.isValidName(name)) {
                JOptionPane.showMessageDialog(null, "Please enter valid Name");
            } else if (!Name_valid.isValidCompany(comapany)) {
                JOptionPane.showMessageDialog(null, "Please enter valid Company Name");
            } else if (!Name_valid.isValidCompany(brand)) {
                JOptionPane.showMessageDialog(null, "Please enter valid Brand Name");
            } else if (!Name_valid.isValidCompany(location)) {
                JOptionPane.showMessageDialog(null, "Please enter valid Location");
            } else if (!Number.containsOnlyNumbers(age)) {
                JOptionPane.showMessageDialog(null, "Please enter valid age");
            } else {

                try {
                    Conn c = new Conn();
                    String query = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + comapany + "','" + brand + "','" + available + "','" + location + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                    setVisible(false);
                }
                catch (Exception e) {
                    System.out.println(e);
                }

            }
        }

    }
    public static void main(String args[]){
        new AddDrivers();
    }
}
