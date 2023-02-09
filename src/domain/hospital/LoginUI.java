/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.hospital;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tamar
 */
public class LoginUI extends JFrame {
     //Declaration of JTextFields
    public JTextField txtUserID;

    //Declaration of JComboBox
    private JComboBox cmbLoginUserAs;

    //Declaration of JLabels
    private JLabel lblLoginUserAs, lblUserID;

    //Declaration of JButtons
    private JButton exitButton, clearButton, loginButton;

    // Instance of ApplicationLogic Class
    ApplicationLogic aLogic = new ApplicationLogic();

    //Declaration of String Array to be populated as list in the JComboBox
    private final String[] loginAsUser = {"Doctor", "Patient", "Pharmacist", "Secretary"};
    public String userID;

    //Default Constructor
    public LoginUI() {

        //Calling the buildLoginGUI() method
        buildLoginGUI();

//Assigning an on click event to login button. login() method will be executed
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to create Patient
                Login();
            }
        });

//Assigning an on click event to clear button. clearData() method will be executed
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to clear all field records
                clearData();
            }
        });

        //exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

    }

    /*
    *Building the User Interface to capture the Login Details and Identify User
     */
    public void buildLoginGUI() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Screen");
        setSize(800, 400);
        setLocationRelativeTo(null);

        //This Panel will contain data input about the login Details of the user in a grid with 5 rows and 2 columns based on fields
        JPanel loginDetailPanel = new JPanel(new GridLayout(4, 2));

        loginDetailPanel.add(new JLabel("Welcome To Domain Hospital!"));
        loginDetailPanel.add(new JLabel(" "));
        loginDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        loginDetailPanel.add(lblLoginUserAs = new JLabel("Log in as:"));

        //creating a new instance of the combobox and passing the list from a String Array loginAsUser
        loginDetailPanel.add(cmbLoginUserAs = new JComboBox(loginAsUser));

        loginDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        loginDetailPanel.add(lblUserID = new JLabel("User ID:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        loginDetailPanel.add(txtUserID = new JTextField(8));

        loginDetailPanel.add(new JLabel(" "));

        //This Panel will contain form control buttons
        JPanel loginFormControlPanel = new JPanel(new FlowLayout());
        loginFormControlPanel.add(loginButton = new JButton("Login"));
        loginFormControlPanel.add(clearButton = new JButton("Clear"));
        loginFormControlPanel.add(exitButton = new JButton("Exit"));

        //add panels to frame
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(loginDetailPanel, BorderLayout.CENTER);
        panel.add(loginFormControlPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

    }

    /*
    * The clearData()Method will reset the form components from any submitted entries
     */
    public void clearData() {

        this.txtUserID.setText("");
        this.cmbLoginUserAs.setSelectedIndex(0);

    }

    public void Login() {

        

        userID = txtUserID.getText();

        //Checking if the string variable patientID is not empty
        if (userID.trim().equals("")) {

            //Displaying a message box for the user to submit the Patient ID
            JOptionPane.showMessageDialog(null, "User ID is Mandatory. Kindly submit the User ID", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            if (cmbLoginUserAs.getSelectedItem().equals("Patient") == true) {

                boolean patientExists = ApplicationLogic.GetPatientID(userID);
                //Validation if patient exist already in the Table

                //Validation - Patient with patient ID passed as param exists in table
                if (patientExists == true) {

                    //Getting Patient Data and Bind them to the form components
                    Patient patientData = ApplicationLogic.GetPatientData(userID);
                    JOptionPane.showMessageDialog(null, "Hello " + patientData.getName());

                    String getuserID = this.txtUserID.getText();

                    MenuUI mainMenuInterface = new MenuUI(getuserID, cmbLoginUserAs.getSelectedItem().toString());
                    mainMenuInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainMenuInterface.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "No User Found", "Search", JOptionPane.INFORMATION_MESSAGE);

                }
            } else if (cmbLoginUserAs.getSelectedItem().equals("Doctor") == true) {

                boolean doctorExists = ApplicationLogic.GetDoctorID(userID);
                //Validation if Doctor exist already in the Table

                //Validation - Doctor with doctor ID passed as param exists in table
                if (doctorExists == true) {

                    //Getting Doctor Data and Bind them to the form components
                    Doctor doctorData = ApplicationLogic.GetDoctorData(userID);
                    JOptionPane.showMessageDialog(null, "Hello " + doctorData.getName());

                    String getuserID = this.txtUserID.getText();

                    MenuUI mainMenuInterface = new MenuUI(getuserID, cmbLoginUserAs.getSelectedItem().toString());
                    mainMenuInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainMenuInterface.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "No User Found", "Search", JOptionPane.INFORMATION_MESSAGE);

                }
            } else if (cmbLoginUserAs.getSelectedItem().equals("Secretary") == true) {

                boolean staffExists = ApplicationLogic.GetStaffID(userID);
                //Validation if Staff - Receptionist exist already in the Table

                //Validation - Staff with staff ID passed as param exists in table
                if (staffExists == true) {

                    //Getting Staff Data and Bind them to the form components
                    Staff staffData = ApplicationLogic.GetStaffData(userID);
                    JOptionPane.showMessageDialog(null, "Hello " + staffData.getName());

                    String getuserID = this.txtUserID.getText();

                    MenuUI mainMenuInterface = new MenuUI(getuserID, cmbLoginUserAs.getSelectedItem().toString());
                    mainMenuInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainMenuInterface.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "No User Found", "Search", JOptionPane.INFORMATION_MESSAGE);

                }
            }else if (cmbLoginUserAs.getSelectedItem().equals("Pharmacist") == true) {

                boolean staffExists = ApplicationLogic.GetStaffID(userID);
                //Validation if Staff - Receptionist exist already in the Table

                //Validation - Staff with staff ID passed as param exists in table
                if (staffExists == true) {

                    //Getting Staff Data and Bind them to the form components
                    Staff staffData = ApplicationLogic.GetStaffData(userID);
                    JOptionPane.showMessageDialog(null, "Hello " + staffData.getName());

                    String getuserID = this.txtUserID.getText();

                    MenuUI mainMenuInterface = new MenuUI(getuserID, cmbLoginUserAs.getSelectedItem().toString());
                    mainMenuInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainMenuInterface.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "No User Found", "Search", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }
}
