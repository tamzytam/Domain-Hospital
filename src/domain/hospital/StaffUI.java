/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.hospital;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Tamar
 */
public class StaffUI extends JFrame{
    //Declaration of JTextFields
    private JTextField txtStaffName, txtStaffSurname, txtStaffID, txtStaffAge;

    //Declaration of JComboBox
    private JComboBox cmbStaffGender, cmbStaffType, cmbStaffQualification, cmbDoctorSpecialization;

    //Declaration of JLabels
    private JLabel lblStaffName, lblStaffSurname, lblStaffID, lblStaffAge, lblStaffType,
            lblStaffQualification, lblStaffGender, lblDoctorSpecialization;

    //Declaration of JButtons
    private JButton exitButton, clearButton, addButton, searchButton, editButton;

    //Declaration of String Arrays to be populated as list in the JComboBoxes
    private final String[] staffGenderList = {"Male", "Female"};
    private final String[] staffType = {"Operations", "Administration"};
    private final String[] staffQualification = {"Secretary", "Doctor", "Pharmacist"};
    private final String[] doctorSpecialization = {"Allergist", "Cardiologist",
        "Family Medicine Physician", "Gynecologist", "Pediatrician"};

    /**
     * Path where the file will be saved
     */
    String staffFileName = "Staff.obj";
    ApplicationLogic aLogic = new ApplicationLogic();

    //Default Constructor
    public StaffUI() {

        //Calling the buildDoctorGUI method
        buildStaffGUI();
        openWindow();

//Assigning an on click event to add button. addPatient() method will be executed
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to create Patient
                addStaff();
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

        //Assigning an on click event to edit button. editStaff() method will be executed
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to edit Staff Record
                editStaff();
            }
        });

        //Search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //GetStaffData();
                searchStaff();

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
                  

    public void openWindow() {

        cmbStaffQualification.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if ("Doctor".equals(cmbStaffQualification.getSelectedItem().toString())) {

                    lblDoctorSpecialization.setVisible(true);
                    cmbDoctorSpecialization.setVisible(true);

                } else {
                    lblDoctorSpecialization.setVisible(false);
                    cmbDoctorSpecialization.setVisible(false);

                }

            }

        });

    }
    
    

    /*
    *Building the User Interface to capture the Staff Details
     */
    public void buildStaffGUI() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Staff Screen");
        setSize(700, 700);
        setLocationRelativeTo(null);

        //This Panel will contain data input about the Patient in a grid with 7 rows and 2 columns based on fields
        JPanel staffDetailPanel = new JPanel(new GridLayout(10, 2));

        staffDetailPanel.add(new JLabel("STAFF DETAILS"));
        staffDetailPanel.add(new JLabel(" "));
        staffDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        staffDetailPanel.add(lblStaffID = new JLabel("ID:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        staffDetailPanel.add(txtStaffID = new JTextField(8));

        staffDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        staffDetailPanel.add(lblStaffName = new JLabel("Name:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        staffDetailPanel.add(txtStaffName = new JTextField(25));

        staffDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        staffDetailPanel.add(lblStaffSurname = new JLabel("Surname:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        staffDetailPanel.add(txtStaffSurname = new JTextField(25));

        staffDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        staffDetailPanel.add(lblStaffAge = new JLabel("Age:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        staffDetailPanel.add(txtStaffAge = new JTextField(3));

        staffDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        staffDetailPanel.add(lblStaffGender = new JLabel("Gender:"));

        //creating a new instance of the combobox and passing the list from a String Array staffGenderList
        staffDetailPanel.add(cmbStaffGender = new JComboBox(staffGenderList));

        staffDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        staffDetailPanel.add(lblStaffType = new JLabel("Staff Section Type:"));

        //creating a new instance of the combobox and passing the list from a String Array staffType
        staffDetailPanel.add(cmbStaffType = new JComboBox(staffType));

        staffDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        staffDetailPanel.add(lblStaffQualification = new JLabel("Job Qualification:"));

        //creating a new instance of the combobox and passing the list from a String Array staffType
        staffDetailPanel.add(cmbStaffQualification = new JComboBox(staffQualification));

        staffDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        staffDetailPanel.add(lblDoctorSpecialization = new JLabel("Doctor Specialization:"));

        //creating a new instance of the combobox and passing the list from a String Array doctorSpecialization
        staffDetailPanel.add(cmbDoctorSpecialization = new JComboBox(doctorSpecialization));

        staffDetailPanel.add(new JLabel(" "));

        this.cmbDoctorSpecialization.setVisible(false);
        this.lblDoctorSpecialization.setVisible(false);

        //This Panel will contain form control buttons
        JPanel staffFormControlPanel = new JPanel(new FlowLayout());
        staffFormControlPanel.add(addButton = new JButton("Add Staff Redcord"));
        staffFormControlPanel.add(clearButton = new JButton("Clear Record"));
        staffFormControlPanel.add(searchButton = new JButton("Search Staff Record"));
        staffFormControlPanel.add(editButton = new JButton("Edit Staff Record"));
        staffFormControlPanel.add(exitButton = new JButton("Exit"));

        //add panels to frame
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(staffDetailPanel, BorderLayout.CENTER);
        panel.add(staffFormControlPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

    }

    /*
    * The clearData()Method will reset the form components from any submitted entries
     */
    public void clearData() {

        this.txtStaffAge.setText("");
        this.txtStaffID.setText("");
        this.txtStaffName.setText("");
        this.txtStaffSurname.setText("");
        this.cmbStaffQualification.setSelectedIndex(0);
        this.cmbStaffGender.setSelectedIndex(0);
        this.cmbStaffType.setSelectedIndex(0);

    }

    //check if textfield is not empty
    public boolean ValidateStringEntry(String validate) {
        boolean empty = false;
        empty = validate.isEmpty(); //if empty
        //if not empty
        return empty;
    }

    /**
     * The addStaff() Method will add record to a Serialized Collection Hash Map
     */
    @SuppressWarnings("UnusedAssignment")
    public void addStaff() {

        String staffName, staffSurname, staffGender, staffType, staffID,
                staffQualification, doctorSpecialization;

        int staffAge = 0;

        boolean quit = true;

        //DO Loop
        do {

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable staff ID with the text submitted in the form textbox
            staffID = this.txtStaffID.getText();

            //Checking if the string variable staffID is not null
            if (staffID != null) {

                //Checking if the string variable staffID is not empty
                if (staffID.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient ID
                    JOptionPane.showMessageDialog(null, "Staff ID is Mandatory. Kindly submit the staff ID", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //staff ID contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //staff ID is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable staffName with the text submitted in the form textbox
            staffName = this.txtStaffName.getText();

            //Checking if the string variable patientName is not null
            if (staffName != null) {

                //Checking if the string variable staffName is not empty
                if (staffName.trim().equals("")) {

                    //Displaying a message box for the user to submit the staff Name
                    JOptionPane.showMessageDialog(null, "staff Name is Mandatory. Kindly submit the staff Name", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //stafftName contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //staffName is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable staffSurname with the text submitted in the form textbox
            staffSurname = this.txtStaffSurname.getText();

            //Checking if the string variable staffSurname is not null
            if (staffSurname != null) {

                //Checking if the string variable staffSurname is not empty
                if (staffSurname.trim().equals("")) {

                    //Displaying a message box for the user to submit the staff Surname
                    JOptionPane.showMessageDialog(null, "Staff Surname is Mandatory. Kindly submit the staff Surname", "Error", JOptionPane.ERROR_MESSAGE);
                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //staffSurname contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //staffSurname is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable getstaffAge with the text submitted in the form textbox
            String getStaffAge = this.txtStaffAge.getText();

            //Checking if the string variable getstaffAge is not null
            if (getStaffAge != null) {

                //Checking if the string variable getStaffAge is not empty
                if (getStaffAge.trim().equals("")) {

                    //Displaying a message box for the user to submit the staff Age
                    JOptionPane.showMessageDialog(null, "Staff Age is Mandatory. Kindly submit the Staff Age", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //staffAge contains text   
                } else {

                    //TRY CATCH Block
                    try {

                        //Assigning the variable staffAge with the variable getStaffAge after Type Casting to Integer
                        staffAge = Integer.parseInt(getStaffAge);

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;

                        //Throwing Exception 
                    } catch (NumberFormatException e) {

                        //Displaying a message box for the user to submit the staff appropriate Age in numeric format
                        JOptionPane.showMessageDialog(null, "Please enter a valid Staff Age in Numbers (0 - 9)", "Error Input "
                                + "Type Mismatch", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;
                        throw e;
                    }
                }

                //The String Variable getStaffAge is null 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------  
            //Assigning the variable staffGender with the selected item from the combobox cmbStaffGender
            staffGender = this.cmbStaffGender.getSelectedItem().toString();

            //Checking if the string variable staffGender is not null
            if (staffGender != null) {

                //Checking if the string variable staffGender is not empty
                if (staffGender.trim().equals("")) {

                    //Displaying a message box for the user to select the staff Gender
                    JOptionPane.showMessageDialog(null, "Staff Gender is Mandatory. Kindly select the Staff Gender", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //staffGender contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //staffGender is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------  
            //Assigning the variable staffType with the selected item from the combobox cmbStaffType
            staffType = this.cmbStaffType.getSelectedItem().toString();

            //Checking if the string variable staffType is not null
            if (staffType != null) {

                //Checking if the string variable staffType is not empty
                if (staffType.trim().equals("")) {

                    //Displaying a message box for the user to select the staff Gender
                    JOptionPane.showMessageDialog(null, "Staff Type is Mandatory. Kindly select the Staff Type", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //staffType contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //staffType is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //----------------------------------------------------------------------------------------------------------------------------------------------------- 
            //Assigning the variable staffQualification with the selected item from the combobox cmbStaffQualification
            staffQualification = this.cmbStaffQualification.getSelectedItem().toString();

            //Checking if the string variable staffType is not null
            if (staffQualification != null) {

                //Checking if the string variable staffType is not empty
                if (staffQualification.trim().equals("")) {

                    //Displaying a message box for the user to select the staff Gender
                    JOptionPane.showMessageDialog(null, "Staff Qualification is Mandatory. Kindly select the Staff Qualification", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //staffQualification contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //staffQualification is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable doctorSpecialization with the selected item from the combobox cmbDoctorSpecialization
            doctorSpecialization = this.cmbDoctorSpecialization.getSelectedItem().toString();

            //Checking if the string variable doctorSpecialization is not null
            if (doctorSpecialization != null) {

                //Checking if the string variable doctorSpecialization is not empty
                if (doctorSpecialization.trim().equals("")) {

                    //Displaying a message box for the user to select the staff Gender
                    JOptionPane.showMessageDialog(null, "Doctor is Mandatory. Kindly select the Doctor Specialization", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //doctorSpecialization contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //doctorSpecialization is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //validation if patient ID is empty
            boolean staffIDEmptyValidation = ValidateStringEntry(staffID);

            //Validation if staff exist already in the Table
            boolean staffExist = ApplicationLogic.GetStaffID(staffID);

            //variable StaffIDEmptyValidation is true
            if (staffIDEmptyValidation == true) {

                //Displaying a message box informing the user that Staff ID is a mandatory field
                JOptionPane.showMessageDialog(null, "Staff ID is mandatory", "Error", JOptionPane.ERROR_MESSAGE);

                //staffExist already in the system
            } else if (staffExist == true) {

                //Displaying a message box informing the user that Staff already exists in the system
                JOptionPane.showMessageDialog(null, "Staff ID already exists", "Error", JOptionPane.ERROR_MESSAGE);

                //StaffID is not empty and Staff Record does not exists in the system
            } else {
                //add record to Patient Table Hashmap with the Patient Object parametres
                //ApplicationLogic myTable2 = new ApplicationLogic();

                if(this.cmbStaffQualification.getSelectedItem().toString().equals("Receptionist") || this.cmbStaffQualification.getSelectedItem().toString().equals("Pharmacist"))
                {
                aLogic.addStaffRecord(staffName, staffSurname, staffAge, staffGender, staffType, staffID, staffQualification);

                //Displaying a message box informing the user that Staff record was successfully added to the list
                JOptionPane.showMessageDialog(null, "Successfully Added Staff to the List", "Add Record", JOptionPane.INFORMATION_MESSAGE);
                }
                
                else{

                aLogic.addDoctorRecord(staffName, staffSurname, staffAge, staffGender, staffType, staffID, staffQualification, doctorSpecialization);

                //Displaying a message box informing the user that Staff record was successfully added to the list
                JOptionPane.showMessageDialog(null, "Successfully Added Doctor to the List", "Add Record", JOptionPane.INFORMATION_MESSAGE);
                
                }
                //reset fields
                clearData();

            }

        } while (quit == true);
    }

    public void editStaff() {

        String staffName, staffSurname, staffGender, staffType, staffID,
                staffQualification, doctorSpecialization;

        int staffAge = 0;

        boolean quit = true;

        String view_ID = this.txtStaffID.getText();
        boolean staffExists = ApplicationLogic.GetPatientID(view_ID);

        //Validation - Patient with patient ID passed as param exists in table
        if (staffExists == true) {

            //DO Loop
            do {

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable staff ID with the text submitted in the form textbox
                staffID = this.txtStaffID.getText();

                //Checking if the string variable staffID is not null
                if (staffID != null) {

                    //Checking if the string variable staffID is not empty
                    if (staffID.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient ID
                        JOptionPane.showMessageDialog(null, "Staff ID is Mandatory. Kindly submit the staff ID", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //staff ID contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //staff ID is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable staffName with the text submitted in the form textbox
                staffName = this.txtStaffName.getText();

                //Checking if the string variable patientName is not null
                if (staffName != null) {

                    //Checking if the string variable staffName is not empty
                    if (staffName.trim().equals("")) {

                        //Displaying a message box for the user to submit the staff Name
                        JOptionPane.showMessageDialog(null, "staff Name is Mandatory. Kindly submit the staff Name", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //stafftName contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //staffName is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable staffSurname with the text submitted in the form textbox
                staffSurname = this.txtStaffSurname.getText();

                //Checking if the string variable staffSurname is not null
                if (staffSurname != null) {

                    //Checking if the string variable staffSurname is not empty
                    if (staffSurname.trim().equals("")) {

                        //Displaying a message box for the user to submit the staff Surname
                        JOptionPane.showMessageDialog(null, "Staff Surname is Mandatory. Kindly submit the staff Surname", "Error", JOptionPane.ERROR_MESSAGE);
                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //staffSurname contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //staffSurname is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable getstaffAge with the text submitted in the form textbox
                String getStaffAge = this.txtStaffAge.getText();

                //Checking if the string variable getstaffAge is not null
                if (getStaffAge != null) {

                    //Checking if the string variable getStaffAge is not empty
                    if (getStaffAge.trim().equals("")) {

                        //Displaying a message box for the user to submit the staff Age
                        JOptionPane.showMessageDialog(null, "Staff Age is Mandatory. Kindly submit the Staff Age", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //staffAge contains text   
                    } else {

                        //TRY CATCH Block
                        try {

                            //Assigning the variable staffAge with the variable getStaffAge after Type Casting to Integer
                            staffAge = Integer.parseInt(getStaffAge);

                            //Boolean variable quit is False. Do Loop will proceed
                            quit = false;

                            //Throwing Exception 
                        } catch (NumberFormatException e) {

                            //Displaying a message box for the user to submit the staff appropriate Age in numeric format
                            JOptionPane.showMessageDialog(null, "Please enter a valid Staff Age in Numbers (0 - 9)", "Error Input "
                                    + "Type Mismatch", JOptionPane.ERROR_MESSAGE);

                            //Boolean quit is switched to true. Do Loop will end
                            quit = true;
                            throw e;
                        }
                    }

                    //The String Variable getStaffAge is null 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------  
                //Assigning the variable staffGender with the selected item from the combobox cmbStaffGender
                staffGender = this.cmbStaffGender.getSelectedItem().toString();

                //Checking if the string variable staffGender is not null
                if (staffGender != null) {

                    //Checking if the string variable staffGender is not empty
                    if (staffGender.trim().equals("")) {

                        //Displaying a message box for the user to select the staff Gender
                        JOptionPane.showMessageDialog(null, "Staff Gender is Mandatory. Kindly select the Staff Gender", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //staffGender contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //staffGender is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------  
                //Assigning the variable staffType with the selected item from the combobox cmbStaffType
                staffType = this.cmbStaffType.getSelectedItem().toString();

                //Checking if the string variable staffType is not null
                if (staffType != null) {

                    //Checking if the string variable staffType is not empty
                    if (staffType.trim().equals("")) {

                        //Displaying a message box for the user to select the staff Gender
                        JOptionPane.showMessageDialog(null, "Staff Type is Mandatory. Kindly select the Staff Type", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //staffType contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //staffType is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //----------------------------------------------------------------------------------------------------------------------------------------------------- 
                //Assigning the variable staffQualification with the selected item from the combobox cmbStaffQualification
                staffQualification = this.cmbStaffQualification.getSelectedItem().toString();

                //Checking if the string variable staffType is not null
                if (staffQualification != null) {

                    //Checking if the string variable staffType is not empty
                    if (staffQualification.trim().equals("")) {

                        //Displaying a message box for the user to select the staff Gender
                        JOptionPane.showMessageDialog(null, "Staff Qualification is Mandatory. Kindly select the Staff Qualification", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //staffQualification contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //staffQualification is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable doctorSpecialization with the selected item from the combobox cmbDoctorSpecialization
                doctorSpecialization = this.cmbDoctorSpecialization.getSelectedItem().toString();

                //Checking if the string variable doctorSpecialization is not null
                if (doctorSpecialization != null) {

                    //Checking if the string variable doctorSpecialization is not empty
                    if (doctorSpecialization.trim().equals("")) {

                        //Displaying a message box for the user to select the staff Gender
                        JOptionPane.showMessageDialog(null, "Doctor is Mandatory. Kindly select the Doctor Specialization", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //doctorSpecialization contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //doctorSpecialization is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                    if(this.cmbStaffQualification.getSelectedItem().toString().equals("Receptionist") || this.cmbStaffQualification.getSelectedItem().toString().equals("Pharmacist"))
                    {

                    aLogic.editStaffRecord(staffName, staffSurname, staffAge, staffGender, staffType, staffID, staffQualification);

                    //Displaying a message box informing the user that Staff record was successfully added to the list
                    JOptionPane.showMessageDialog(null, "Successfully Updated Staff Record into the List", "Update Record", JOptionPane.INFORMATION_MESSAGE);

                    }
                    
                    else{
                    aLogic.editDoctorRecord(staffName, staffSurname, staffAge, staffGender, staffType, staffID, staffQualification, doctorSpecialization);

                    //Displaying a message box informing the user that Staff record was successfully added to the list
                    JOptionPane.showMessageDialog(null, "Successfully Updated Doctor Record into the List", "Update Record", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //reset fields
                    clearData();
                    
                    this.txtStaffID.setEnabled(true);

                

            } while (quit == true);

        }//Validation - Staff with staff ID passed as param does not exists in table
        else {

            //Showing a message to the user informing that no Staff were found    
            JOptionPane.showMessageDialog(null, "No Staff was found with Staff ID: " + view_ID,  "Search", JOptionPane.WARNING_MESSAGE);

        }

    }

    /*
     *get the necessary data for Patient
     */
    public String GetStaffData() {
        String[] staffName = ApplicationLogic.listStaffName();
        String staffData = "";

        //check if hashmap is empty
        if (staffName.length == 0) {
            JOptionPane.showMessageDialog(null, "There are no records in the Staff Table!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //if hashmap is not empty, go through all the names in the hashmap, get the corresponding data Object of that name and

            //for (int i = 0; i < staffName.length; i++) {
            for (String staff : staffName) {
                Staff myStaff = ApplicationLogic.GetStaffData(staff);
                JOptionPane.showMessageDialog(null, "Size of result: " + staffName.length);

                this.txtStaffID.setText(myStaff.getStaffID());
                this.txtStaffName.setText(myStaff.getName());
                this.txtStaffSurname.setText(myStaff.getSurname());
                this.txtStaffAge.setText(String.valueOf(myStaff.getAge()));
                this.cmbStaffGender.setSelectedItem(myStaff.getGender());
                this.cmbStaffQualification.setSelectedItem(myStaff.getStaffQualification());
                this.cmbStaffType.setSelectedItem(myStaff.getStaffType());
            } //end for loop
        }//end else

        return staffData;
    }

    /**
     *
     */
    public void searchStaff() {

        //Showing an input Dialogue for the customer to submit search entry
        String view_ID = JOptionPane.showInputDialog(null, "Please Submit Staff ID as Search Criteria");

        boolean staffExists = ApplicationLogic.GetStaffID(view_ID);
        //Boolean if staff exist already in the Table

        //Validation - Staff with StaffID passed as param exists in table
        if (staffExists == true) {

            //Getting Staff Data and Bind them to the form components
            Staff staffData = ApplicationLogic.GetStaffData(view_ID);
            
            this.txtStaffID.setEnabled(false);

            this.txtStaffID.setText(staffData.getStaffID());
            this.txtStaffName.setText(staffData.getName());
            this.txtStaffSurname.setText(staffData.getSurname());
            this.txtStaffAge.setText(String.valueOf(staffData.getAge()));
            this.cmbStaffGender.setSelectedItem(staffData.getGender());
            this.cmbStaffQualification.setSelectedItem(staffData.getStaffQualification());
            this.cmbStaffType.setSelectedItem(staffData.getStaffType());

        } //Validation - Staff with Staff ID passed as param does not exists in table
        else {

            //Showing a message to the user informing that no Staff were found    
            JOptionPane.showMessageDialog(null, "No Staff was found with ID: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        }

    }

}
