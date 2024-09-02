import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JButton submit,cancel;
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JLabel name,age,phone,email,salary,job,gender,aadhar;
    JRadioButton male,female;
    JComboBox cbjob;
    AddEmployee(){
        Font font=new Font("Raleway",Font.PLAIN,17);
        setLayout(null);
        setBounds(350,200,850,540);
        setVisible(true);
        getContentPane().setBackground(Color.white);

         JLabel addEmp=new JLabel("Add Employee");
         addEmp.setBounds(400,30,200,30);
         addEmp.setFont(new Font("Raleway",Font.BOLD,25));
         add(addEmp);

         name=new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(font);
        add(name);

         tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

         age=new JLabel("AGE");
        age.setBounds(60,80,120,30);
        age.setFont(font);
        add(age);

         tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

         gender=new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(font);
        add(gender);

         male=new JRadioButton("MALE");
        male.setBounds(200,130,70,30);
        male.setFont(new Font("Raleway",Font.PLAIN,14));
        male.setBackground(Color.white);
        add(male);

         female=new JRadioButton("FEMALE");
        female.setBounds(280,130,100,30);
        female.setFont(new Font("Raleway",Font.PLAIN,14));
        female.setBackground(Color.white);
        add(female);

        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);

         job=new JLabel("JOB");
        job.setFont(font);
        job.setBounds(60,180,120,30);
        add(job);

        String values[]={"Front Desk Clerks","Porters","Houskeeping","Kitchen Staff","Room Service","Chefs","Waiter","Manager","Accountant"};
         cbjob=new JComboBox(values);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);

         salary=new JLabel("SALARY");
        salary.setBounds(60,230,120,30);
        salary.setFont(font);
        add(salary);

         tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

         phone=new JLabel("PHONE");
        phone.setBounds(60,280,120,30);
        phone.setFont(font);
        add(phone);

         tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);
        aadhar=new JLabel("AADHAR");
        aadhar.setBounds(60,380,120,30);
        aadhar.setFont(font);
        add(aadhar);

        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

         email=new JLabel("EMAIL");
        email.setBounds(60,330,120,30);
        email.setFont(font);
        add(email);

         tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        submit=new JButton("SUBMIT");
        submit.setBounds(210,430,150,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.black);
        add(submit);
        submit.addActionListener(this);

        cancel=new JButton("CANCEL");
        cancel.setBounds(40,430,150,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==cancel){
            setVisible(false);
        }
        else if(ae.getSource()==submit) {

            String name = tfname.getText();
            String age = tfage.getText();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
            String job = (String) cbjob.getSelectedItem();

            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            }
            if (female.isSelected()) {
                gender = "Female";
            }

            aadhar_pan_validation aadharPanValidation = new aadhar_pan_validation();
            name_validation Name_valid = new name_validation();
            number_validation Number_valid = new number_validation();


            if (name.equals("") || age.equals("") || salary.equals("") || phone.equals("") || email.equals("") || aadhar.equals("") || gender.equals("")) {
                JOptionPane.showMessageDialog(null, "All Fields are Mandatory");
            } else if (!Name_valid.isValidName(name)) {
                JOptionPane.showMessageDialog(null, "Please enter Valid Name");
            } else if (!Name_valid.isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Please enter Valid Email");
            } else if (!Number_valid.containsOnlyNumbers(age)) {
                JOptionPane.showMessageDialog(null, "Please enter Valid age");
            } else if (!Number_valid.containsOnlyNumbers(salary)) {
                JOptionPane.showMessageDialog(null, "Please enter Valid Salary");
            } else if (!Number_valid.isValidMobileNumber(phone)) {
                JOptionPane.showMessageDialog(null, "Please enter Valid Mobile no ");
            } else if (!aadharPanValidation.isValidAadhar(aadhar)) {
                JOptionPane.showMessageDialog(null, "Please Enter valid Aadhar number");
            }
            else {
                try {
                    Conn c = new Conn();
                    String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee added successfully ");
                    setVisible(false);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String args[]){
    new AddEmployee();
    }
}
