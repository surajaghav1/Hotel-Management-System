import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfNumber,tfname,tfcountry,tfdeposite,tfmobileno;
    JRadioButton male,female;
    JLabel checkinTime;
    Choice croom;
    JButton add,back;
    AddCustomer(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setBounds(350,200,800,550);

        Font font=new Font("Raleway",Font.PLAIN,20);

        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);

        JLabel lbid=new JLabel("Document ID");
        lbid.setBounds(35,80,150,20);
        lbid.setFont(font);
        add(lbid);

        String idvalues[]={"Aadhar Card","PAN Card","Passport","Driving Licence","Voter ID"};
        comboid=new JComboBox(idvalues);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.white);
        add(comboid);

        JLabel lbnumber=new JLabel("ID Number");
        lbnumber.setBounds(35,120,100,20);
        lbnumber.setFont(font);
        add(lbnumber);

        tfNumber=new JTextField();
        tfNumber.setBounds(200,120,150,25);
        add(tfNumber);

        JLabel lbname=new JLabel("Name");
        lbname.setBounds(35,160,100,20);
        lbname.setFont(font);
        add(lbname);

        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lbgender=new JLabel("Gender");
        lbgender.setBounds(35,200,100,20);
        lbgender.setFont(font);
        add(lbgender);

        male=new JRadioButton("Male");
        male.setBounds(200,200,60,25);
        male.setBackground(Color.white);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(270,200,100,25);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel lbcountry=new JLabel("Country");
        lbcountry.setBounds(35,240,100,20);
        lbcountry.setFont(font);
        add(lbcountry);

        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lbroom=new JLabel("Room Number");
        lbroom.setBounds(35,280,150,20);
        lbroom.setFont(font);
        add(lbroom);

        croom=new Choice();
        croom.setBounds(200,280,150,25);
        add(croom);

        try {
            Conn conn=new Conn();
            String query="select *from room where availability='Available'";
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("roomno"));

            }

        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

        JLabel lbtime=new JLabel("Checkin Time");
        lbtime.setBounds(35,320,150,20);
        lbtime.setFont(font);
        add(lbtime);

       Date date=new Date();
// we need to concatinate the Date with the string
//      Because after concatination it does not gives an error
        checkinTime=new JLabel(""+date);
        checkinTime.setFont(new Font("Raleway",Font.PLAIN,16));
        checkinTime.setBounds(200,320,150,25);
        add(checkinTime);

//        System.out.println(1+2+3+" suraj "+5+3+2);
//      first it treat that numbers as Interger and after the String it treat all any type of value as String
//  it is used to concatinate the any type to the String

        JLabel lbdeposite=new JLabel("Deposite");
        lbdeposite.setBounds(35,360,100,20);
        lbdeposite.setFont(font);
        add(lbdeposite);

        tfdeposite=new JTextField();
        tfdeposite.setBounds(200,360,150,25);
        add(tfdeposite);

        JLabel lbmobile=new JLabel("Mobile No");
        lbmobile.setBounds(35,400,150,20);
        lbmobile.setFont(font);
        add(lbmobile);

        tfmobileno=new JTextField();
        tfmobileno.setBounds(200,400,150,25);
        add(tfmobileno);

        add=new JButton("ADD");
        add.setBounds(50,450,120,25);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add(add);
        add.addActionListener(this);

        back=new JButton("BACK");
        back.setBounds(200,450,120,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
        else if(ae.getSource()==add){

            String id=(String)comboid.getSelectedItem();
            String name=tfname.getText();
            String number=tfNumber.getText();  // here number is id number which is selected from the Drop Down list
            String gender=null;
            String country=tfcountry.getText();
            String deposite=tfdeposite.getText();
            String mobileno=tfmobileno.getText();

            if(male.isSelected()){
                gender="Male";
            }
            else if(female.isSelected()){
                gender="Female";
            }
            String time=checkinTime.getText();
            String room=croom.getSelectedItem();

            // validation

                name_validation Name_valid=new name_validation();
                number_validation Num_valid=new number_validation();
                aadhar_pan_validation ID_valid=new aadhar_pan_validation(); // it is used for id from Drop Down list

                switch (id){
                    case "Aadhar Card":
                        if(!ID_valid.isValidAadhar(number)){
                            JOptionPane.showMessageDialog(null,"Please Enter Correct Aadhar Number");
                        }
                        break;
                    case "PAN Card":
                        if(!ID_valid.isValidPan(number)){
                            JOptionPane.showMessageDialog(null,"Please Enter Correct PAN Number");
                        }
                        break;
                    case "Passport":
                        if(!ID_valid.isValidPassportNumber(number)){
                            JOptionPane.showMessageDialog(null,"Please Enter Correct Passport  Number");
                        }
                        break;
                    case "Driving Licence":
                        if(!ID_valid.isValidDrivingLicenseNumber(number)){
                            JOptionPane.showMessageDialog(null,"Please Enter Correct Driving Licence  Number");
                        }
                        break;
                    case "Voter ID":
                        if(!ID_valid.isValidVoterID(number)){
                            JOptionPane.showMessageDialog(null,"Please Enter Correct Voter ID Number");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Please Choose Any Id");
                        break;
                }

                // validation for all fields
                if(id.equals("")||name.equals("")||number.equals("")||gender.equals("")||country.equals("")||deposite.equals("")||mobileno.equals("")||time.equals("")||room.equals("")){
                    JOptionPane.showMessageDialog(null,"All Fields are Manadatory ");
                }
                else if(!Name_valid.isValidName(name)){
                        JOptionPane.showMessageDialog(null,"Name is NOT Valid !! Pleasse Enter Valid Name");
                }
                else if(!Name_valid.isValidName(country)){
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Country Name");
                }
                else if(!Num_valid.containsOnlyNumbers(deposite)){
                    JOptionPane.showMessageDialog(null,"Please Enter Correct amount \n Only numbers allowed");
                }
                else if(!Num_valid.isValidMobileNumber(mobileno)){
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Mobile Number \n Only numbers allowed");
                }

                else {
                    try {
                        Conn conn = new Conn();
                        // for storing data to the table of customer
                        String query = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + deposite + "','" + time + "','" + room + "','" + mobileno + "')";

                        // update the room table or status of room
                        String query2 = "update room set availability='Occupied' where roomno='" + room + "'";

                        conn.s.executeUpdate(query);
                        conn.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "New Customer Added Successfully ");
                        setVisible(false);
                        new Reception();
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Can NOT Connect to DataBase");
                        System.out.println(e);
                    }
                }
        }
    }

    public static void main(String args[]){
        new AddCustomer();
    }
}
