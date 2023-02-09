/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.hospital;

/**
 *
 * @author Tamar
 */
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.text.DateFormatter;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PatientUI extends JFrame {
     //Declaration of JTextFields
    private JTextField txtPatientName, txtPatientSurname, txtPatientID, txtPatientAge,
            txtPatientPrescriptionHistory, txtPatientSpecialRequests;

    //Declaration of JComboBox
    private JComboBox cmbPatientGender, cmbPatientAllergies;

    //Declaration of JFormattedTextField
    private JFormattedTextField txtPatientDOB;

    //Declaration of JLabels
    private JLabel lblPatientName, lblPatientSurname, lblPatientID, lblPatientAge, lblPatientPrescriptionHistory,
            lblPatientSpecialRequests, lblPatientGender, lblPatientAllergies, lblPatientDOB;

    //Declaration of JButtons
    private JButton exitButton, clearButton, addButton, editButton, searchButton;

    //Declaration of String Arrays to be populated as list in the JComboBoxes
    private final String[] patientGenderList = {"Male", "Female"};
    private final String[] patientAllergiesList = {"Allergy1", "Allergy2", "Allergy3"};

    //Path where the file will be saved
    String patientFileName = "Patients.obj";

    // Instance of ApplicationLogic Class
    ApplicationLogic aLogic = new ApplicationLogic();

    //Default Constructor
    public PatientUI() {

        //Calling the buildPatientGUI method
        buildPatientGUI();

//Assigning an on click event to add button. addPatient() method will be executed
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to create Patient
                addPatient();
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
       // GetPatientData();
 
            }
        });

        //edit button
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                editPatient();
            }
        });
        
         //search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Calling the searchPatient() method
                searchPatient();
            }
        });

    }


    /*
    *Building the User Interface to capture the Patient Details
     */
    public void buildPatientGUI() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Screen");
        setSize(700, 700);
        setLocationRelativeTo(null);

        //This Panel will contain data input about the Patient in a grid with 10 rows and 2 columns based on fields
        JPanel patientDetailPanel = new JPanel(new GridLayout(10, 2));

        patientDetailPanel.add(new JLabel("PATIENT DETAILS"));
        patientDetailPanel.add(new JLabel(" "));
        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientID = new JLabel("ID:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        patientDetailPanel.add(txtPatientID = new JTextField(8));

        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientName = new JLabel("Name:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        patientDetailPanel.add(txtPatientName = new JTextField(25));

        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientSurname = new JLabel("Surname:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        patientDetailPanel.add(txtPatientSurname = new JTextField(25));

        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientAge = new JLabel("Age:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        patientDetailPanel.add(txtPatientAge = new JTextField(3));

        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientDOB = new JLabel("Date Of Birth:"));

        //Creating a Date Format Mask
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        DateFormatter formatter = new DateFormatter(format);
        //format.setLenient(false);
        //formatter.setAllowsInvalid(false);
        // formatter.setOverwriteMode(true);

        //creating a new instance of the formattedtextfield by attributing a textfield size and adding it to the panel
        patientDetailPanel.add(txtPatientDOB = new JFormattedTextField(formatter));

        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientGender = new JLabel("Gender:"));

        //creating a new instance of the combobox and passing the list from a String Array patientGenderList
        patientDetailPanel.add(cmbPatientGender = new JComboBox(patientGenderList));

        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientPrescriptionHistory = new JLabel("Prescription History:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        patientDetailPanel.add(txtPatientPrescriptionHistory = new JTextField(100));

        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientAllergies = new JLabel("Allergies:"));

        //creating a new instance of the combobox and passing the list from a String Array patientAllergiesList
        patientDetailPanel.add(cmbPatientAllergies = new JComboBox(patientAllergiesList));

        patientDetailPanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        patientDetailPanel.add(lblPatientSpecialRequests = new JLabel("Request and Remarks:"));

        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        patientDetailPanel.add(txtPatientSpecialRequests = new JTextField(100));

        //This Panel will contain form control buttons
        JPanel patientFormControlPanel = new JPanel(new FlowLayout()); //Order Left to Right
        patientFormControlPanel.add(addButton = new JButton("Add Patient"));
        patientFormControlPanel.add(clearButton = new JButton("Clear Patient"));
        patientFormControlPanel.add(searchButton = new JButton("Search Patient"));
        patientFormControlPanel.add(editButton = new JButton("Edit Patient"));
        patientFormControlPanel.add(exitButton = new JButton("Exit"));
        
        //add panels to frame
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(patientDetailPanel, BorderLayout.CENTER);
        panel.add(patientFormControlPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
    }

    /*
    * The clearData()Method will reset the form components from any submitted entries
     */
    public void clearData() {

        this.txtPatientAge.setText("");
        this.txtPatientDOB.setText("");
        this.txtPatientID.setText("");
        this.txtPatientName.setText("");
        this.txtPatientSurname.setText("");
        this.txtPatientPrescriptionHistory.setText("");
        this.txtPatientSpecialRequests.setText("");
        this.cmbPatientAllergies.setSelectedIndex(0);
        this.cmbPatientGender.setSelectedIndex(0);

    }

    //check if textfield is not empty
    public boolean ValidateStringEntry(String validate) {
        boolean empty = false;
        empty = validate.isEmpty(); //if empty
        //if not empty
        return empty;
    }

    /**
     * The addPatient() Method will add record to a Serialized Vector and to a
     * Collection Hash Map
     */
    @SuppressWarnings("UnusedAssignment")
    public void addPatient() {

        String patientID, patientName, patientSurname, patientGender, patientPrescription, patientAllergies,
                patientRequest;
        int patientAge = 0;
        Date patientDOB = null;

        boolean quit = true;

        //DO Loop
        do {

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable Patient ID with the text submitted in the form textbox
            patientID = this.txtPatientID.getText();

            //Checking if the string variable patientID is not null
            if (patientID != null) {

                //Checking if the string variable patientID is not empty
                if (patientID.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient ID
                    JOptionPane.showMessageDialog(null, "Patient ID is Mandatory. Kindly submit the Patient ID", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //Patient ID contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //Patient ID is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable PatientName with the text submitted in the form textbox
            patientName = this.txtPatientName.getText();

            //Checking if the string variable patientName is not null
            if (patientName != null) {

                //Checking if the string variable patientName is not empty
                if (patientName.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Name
                    JOptionPane.showMessageDialog(null, "Patient Name is Mandatory. Kindly submit the Patient Name", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientName contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //PatientName is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable PatientSurname with the text submitted in the form textbox
            patientSurname = this.txtPatientSurname.getText();

            //Checking if the string variable patientSurname is not null
            if (patientSurname != null) {

                //Checking if the string variable patientSurname is not empty
                if (patientSurname.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Surname
                    JOptionPane.showMessageDialog(null, "Patient Surname is Mandatory. Kindly submit the Patient Surname", "Error", JOptionPane.ERROR_MESSAGE);
                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientSurname contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //PatientSurname is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable getPatientAge with the text submitted in the form textbox
            String getPatientAge = this.txtPatientAge.getText();

            //Checking if the string variable getPatientAge is not null
            if (getPatientAge != null) {

                //Checking if the string variable getPatientAge is not empty
                if (getPatientAge.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Age
                    JOptionPane.showMessageDialog(null, "Patient Age is Mandatory. Kindly submit the Patient Age", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientAge contains text   
                } else {

                    //TRY CATCH Block
                    try {

                        //Assigning the variable patientAge with the variable getPatientAge after Type Casting to Integer
                        patientAge = Integer.parseInt(getPatientAge);

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;

                        //Throwing Exception 
                    } catch (NumberFormatException e) {

                        //Displaying a message box for the user to submit the Patient appropriate Age in numeric format
                        JOptionPane.showMessageDialog(null, "Please enter a valid Patient Age in Numbers (0 - 9)", "Error Input "
                                + "Type Mismatch", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;
                        throw e;
                    }
                }

                //The String Variable getPatientAge is null 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------  
            //Assigning the variable PatientGender with the selected item from the combobox cmbPatientGender
            patientGender = this.cmbPatientGender.getSelectedItem().toString();

            //Checking if the string variable patientGender is not null
            if (patientGender != null) {

                //Checking if the string variable patientGender is not empty
                if (patientGender.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Gender
                    JOptionPane.showMessageDialog(null, "Patient Gender is Mandatory. Kindly select the Patient Gender", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientGender contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //PatientGender is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------  
            //Assigning the variable PatientPrescription with the text submitted in the form textbox
            patientPrescription = this.txtPatientPrescriptionHistory.getText();

            //Checking if the string variable patientPrescription is not null
            if (patientPrescription != null) {

                //Checking if the string variable patientPrescription is not empty
                if (patientPrescription.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Prescription
                    JOptionPane.showMessageDialog(null, "Patient Prescription is Mandatory. Kindly submit the Patient "
                            + "Prescription. Submit N/A if not applicable", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientPrescription contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //PatientSurname is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable PatientAllergies with the selected item from the combobox cmbPatientAllergies
            patientAllergies = this.cmbPatientAllergies.getSelectedItem().toString();

            //Checking if the string variable patientAllergies is not null
            if (patientAllergies != null) {

                //Checking if the string variable patientAllergies is not empty
                if (patientAllergies.trim().equals("")) {

                    //Displaying a message box for the user to select the Patient Diagnosed Allergies
                    JOptionPane.showMessageDialog(null, "Patient Allergies is Mandatory. Kindly select the appropriate "
                            + "Patient Allergies", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientAllergies contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //PatientSurname is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable getPatientDOB with the text submitted in the form textbox
            String getPatientDOB = this.txtPatientDOB.getText();

            //Checking if the string variable getPatientDOB is not null
            if (getPatientDOB != null) {

                //Checking if the string variable getPatientDOB is not empty
                if (getPatientDOB.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Date of Birth
                    JOptionPane.showMessageDialog(null, "Patient DOB is Mandatory. Kindly Submit the Patient DOB", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientDOB contains text      
                } else {

                    //TRY CATCH Block
                    try {

                        //Setting a Date format in Day Month Year (Short Date) 
                        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                        //Setting Date Formatter SetLenient to TRUE
                        formatter.setLenient(true);

                        //Assigning the variable patientDOB with the variable getPatientDOB after DateTypeCasting
                        patientDOB = formatter.parse(getPatientDOB);

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;

                        //Throwing Exception 
                    } catch (ParseException e) {

                        //Displaying a message box for the user to submit the Patient DOB with the appropriate format
                        JOptionPane.showMessageDialog(null, "Please enter a valid Patient DOB with DD/MM/YYYY format",
                                "Error - Input Type Mismatch", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                    }
                }
                // The variable getPatientDOB is null  
            } else {

                //Return to User
                return;
            }
            //-----------------------------------------------------------------------------------------------------------------------------------------------------

            //Assigning the variable PatientRequest with the text submitted in the form textbox
            patientRequest = this.txtPatientSpecialRequests.getText();

            //Checking if the string variable patientRequest is not null
            if (patientRequest != null) {

                //Checking if the string variable patientRequest is not empty
                if (patientRequest.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Special Requests or Remarks
                    JOptionPane.showMessageDialog(null, "Patient Request is Mandatory. Kindly submit the Patient "
                            + "Request or N/A if not applicable", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientRequest contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //PatientSurname is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //validation if patient ID is empty
            boolean patientIDEmptyValidation = ValidateStringEntry(patientID);

            //Validation if patient exist already in the Table
            boolean patientExist = ApplicationLogic.GetPatientID(patientID);

            //variable PatientIDEmptyValidation is true
            if (patientIDEmptyValidation == true) {

                //Displaying a message box informing the user that Patient ID is a mandatory field
                JOptionPane.showMessageDialog(null, "Patient ID is mandatory", "Error", JOptionPane.ERROR_MESSAGE);

                //PatientExists already in the system
            } else if (patientExist == true) {

                //Displaying a message box informing the user that Patient already exists in the system
                JOptionPane.showMessageDialog(null, "Patient ID already exists", "Error", JOptionPane.ERROR_MESSAGE);

                //PatientID is not empty and Patient Record does not exists in the system
            } else {
                //add record to Patient Table Hashmap with the Patient Object parametres
                //ApplicationLogic myTable2 = new ApplicationLogic();

                aLogic.addPatientRecord(patientID, patientName, patientSurname, patientAge, patientGender, patientDOB,
                        patientPrescription, patientAllergies, patientRequest);

                //Displaying a message box informing the user that Patient record was successfully added to the list
                JOptionPane.showMessageDialog(null, "Successfully Added Patient to the List", "Add Record", JOptionPane.INFORMATION_MESSAGE);

                //reset fields
                clearData();

            }

        } while (quit == true);

    }

    public void editPatient() {

        String patientID, patientName, patientSurname, patientGender, patientPrescription, patientAllergies, patientRequest;
        int patientAge = 0;
        
        Date patientDOB = null;

        boolean quit = true;

        String view_ID = this.txtPatientID.getText();
        boolean patientExists = ApplicationLogic.GetPatientID(view_ID);

        //Validation - Patient with patient ID passed as param exists in table
        if (patientExists == true) {
            
 
            //DO Loop
            do {

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable Patient ID with the text submitted in the form textbox
                patientID = this.txtPatientID.getText();

                //Checking if the string variable patientID is not null
                if (patientID != null) {

                    //Checking if the string variable patientID is not empty
                    if (patientID.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient ID
                        JOptionPane.showMessageDialog(null, "Patient ID is Mandatory. Kindly submit the Patient ID", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //Patient ID contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //Patient ID is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable PatientName with the text submitted in the form textbox
                patientName = this.txtPatientName.getText();

                //Checking if the string variable patientName is not null
                if (patientName != null) {

                    //Checking if the string variable patientName is not empty
                    if (patientName.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient Name
                        JOptionPane.showMessageDialog(null, "Patient Name is Mandatory. Kindly submit the Patient Name", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //PatientName contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //PatientName is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable PatientSurname with the text submitted in the form textbox
                patientSurname = this.txtPatientSurname.getText();

                //Checking if the string variable patientSurname is not null
                if (patientSurname != null) {

                    //Checking if the string variable patientSurname is not empty
                    if (patientSurname.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient Surname
                        JOptionPane.showMessageDialog(null, "Patient Surname is Mandatory. Kindly submit the Patient Surname", "Error", JOptionPane.ERROR_MESSAGE);
                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //PatientSurname contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //PatientSurname is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable getPatientAge with the text submitted in the form textbox
                String getPatientAge = this.txtPatientAge.getText();

                //Checking if the string variable getPatientAge is not null
                if (getPatientAge != null) {

                    //Checking if the string variable getPatientAge is not empty
                    if (getPatientAge.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient Age
                        JOptionPane.showMessageDialog(null, "Patient Age is Mandatory. Kindly submit the Patient Age", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //PatientAge contains text   
                    } else {

                        //TRY CATCH Block
                        try {

                            //Assigning the variable patientAge with the variable getPatientAge after Type Casting to Integer
                            patientAge = Integer.parseInt(getPatientAge);

                            //Boolean variable quit is False. Do Loop will proceed
                            quit = false;

                            //Throwing Exception 
                        } catch (NumberFormatException e) {

                            //Displaying a message box for the user to submit the Patient appropriate Age in numeric format
                            JOptionPane.showMessageDialog(null, "Please enter a valid Patient Age in Numbers (0 - 9)", "Error Input "
                                    + "Type Mismatch", JOptionPane.ERROR_MESSAGE);

                            //Boolean quit is switched to true. Do Loop will end
                            quit = true;
                            throw e;
                        }
                    }

                    //The String Variable getPatientAge is null 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------  
                //Assigning the variable PatientGender with the selected item from the combobox cmbPatientGender
                patientGender = this.cmbPatientGender.getSelectedItem().toString();

                //Checking if the string variable patientGender is not null
                if (patientGender != null) {

                    //Checking if the string variable patientGender is not empty
                    if (patientGender.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient Gender
                        JOptionPane.showMessageDialog(null, "Patient Gender is Mandatory. Kindly select the Patient Gender", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //PatientGender contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //PatientSurname is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------  
                //Assigning the variable PatientPrescription with the text submitted in the form textbox
                patientPrescription = this.txtPatientPrescriptionHistory.getText();

                //Checking if the string variable patientPrescription is not null
                if (patientPrescription != null) {

                    //Checking if the string variable patientPrescription is not empty
                    if (patientPrescription.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient Prescription
                        JOptionPane.showMessageDialog(null, "Patient Prescription is Mandatory. Kindly submit the Patient "
                                + "Prescription. Submit N/A if not applicable", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //PatientPrescription contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //PatientSurname is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable PatientAllergies with the selected item from the combobox cmbPatientAllergies
                patientAllergies = this.cmbPatientAllergies.getSelectedItem().toString();

                //Checking if the string variable patientAllergies is not null
                if (patientAllergies != null) {

                    //Checking if the string variable patientAllergies is not empty
                    if (patientAllergies.trim().equals("")) {

                        //Displaying a message box for the user to select the Patient Diagnosed Allergies
                        JOptionPane.showMessageDialog(null, "Patient Allergies is Mandatory. Kindly select the appropriate "
                                + "Patient Allergies", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //PatientAllergies contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //PatientSurname is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------
                //Assigning the variable getPatientDOB with the text submitted in the form textbox
                String getPatientDOB = this.txtPatientDOB.getText();

                //Checking if the string variable getPatientDOB is not null
                if (getPatientDOB != null) {

                    //Checking if the string variable getPatientDOB is not empty
                    if (getPatientDOB.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient Date of Birth
                        JOptionPane.showMessageDialog(null, "Patient DOB is Mandatory. Kindly Submit the Patient DOB", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //PatientDOB contains text      
                    } else {

                        //TRY CATCH Block
                        try {

                            //Setting a Date format in Day Month Year (Short Date) 
                            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                            //Setting Date Formatter SetLenient to TRUE
                            formatter.setLenient(true);

                            //Assigning the variable patientDOB with the variable getPatientDOB after DateTypeCasting
                            patientDOB = formatter.parse(getPatientDOB);

                            //Boolean variable quit is False. Do Loop will proceed
                            quit = false;

                            //Throwing Exception 
                        } catch (ParseException e) {

                            //Displaying a message box for the user to submit the Patient DOB with the appropriate format
                            JOptionPane.showMessageDialog(null, "Please enter a valid Patient DOB with DD/MM/YYYY format",
                                    "Error - Input Type Mismatch", JOptionPane.ERROR_MESSAGE);

                            //Boolean quit is switched to true. Do Loop will end
                            quit = true;

                        }
                    }
                    // The variable getPatientDOB is null  
                } else {

                    //Return to User
                    return;
                }
                //-----------------------------------------------------------------------------------------------------------------------------------------------------

                //Assigning the variable PatientRequest with the text submitted in the form textbox
                patientRequest = this.txtPatientSpecialRequests.getText();

                //Checking if the string variable patientRequest is not null
                if (patientRequest != null) {

                    //Checking if the string variable patientRequest is not empty
                    if (patientRequest.trim().equals("")) {

                        //Displaying a message box for the user to submit the Patient Special Requests or Remarks
                        JOptionPane.showMessageDialog(null, "Patient Request is Mandatory. Kindly submit the Patient "
                                + "Request or N/A if not applicable", "Error", JOptionPane.ERROR_MESSAGE);

                        //Boolean quit is switched to true. Do Loop will end
                        quit = true;

                        //Breaking the loop
                        break;

                        //PatientRequest contains text   
                    } else {

                        //Boolean variable quit is False. Do Loop will proceed
                        quit = false;
                    }
                    //PatientSurname is null and loop will break 
                } else {

                    //Return to User 
                    return;
                }

                aLogic.editPatientRecord(patientID, patientName, patientSurname, patientAge, patientGender, patientDOB,
                        patientPrescription, patientAllergies, patientRequest);

                //Displaying a message box informing the user that Patient record was successfully added to the list
                JOptionPane.showMessageDialog(null, "Successfully Updated Patient Detail Records", "Update Record", JOptionPane.INFORMATION_MESSAGE);
                this.txtPatientID.setEnabled(true);

                //reset fields
                clearData();

            } while (quit == true);


        } //Validation - Patient with patient ID passed as param does not exists in table
        else {

            //Showing a message to the user informing that no Patiens were found    
            JOptionPane.showMessageDialog(null, "No Patients found with ID: " + view_ID,"Search",JOptionPane.WARNING_MESSAGE);

        }
    }

    /*
     *get the necessary data for Patient
     */
    public String GetPatientData() {
        String[] patientName = ApplicationLogic.listPatientName();
        String patientData = "";

        //check if hashmap is empty
        if (patientName.length == 0) {
            JOptionPane.showMessageDialog(null, "There are no records in the Patient Table!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //if hashmap is not empty, go through all the names in the hashmap, get the corresponding data Object of that name and

            for (int i = 0; i < patientName.length; i++) {
                String patient = patientName[i];
                Patient myPatient = ApplicationLogic.GetPatientData(patient);
                JOptionPane.showMessageDialog(null, "Size of result: " + patientName.length);

                this.txtPatientID.setText(myPatient.getPatientID());
                this.txtPatientName.setText(myPatient.getName());
                this.txtPatientSurname.setText(myPatient.getSurname());
                this.txtPatientAge.setText(String.valueOf(myPatient.getAge()));
                this.cmbPatientGender.setSelectedItem(myPatient.getGender());
                this.txtPatientPrescriptionHistory.setText(myPatient.getPatientPrescriptionHistory());
                this.txtPatientSpecialRequests.setText(myPatient.getPatientSpecialRequests());
                this.cmbPatientAllergies.setSelectedItem(myPatient.getPatientAllergies());
                this.txtPatientDOB.setText(String.valueOf(myPatient.getPatientDOB()));

            }//end for loop
        }//end else

        return patientData;
    }

    public void searchPatient() {

        //Showing an input Dialogue for the customer to submit search entry
        String view_ID = JOptionPane.showInputDialog(null, "Please Submit Patient ID as Search Criteria");

        boolean patientExists = ApplicationLogic.GetPatientID(view_ID);
        //Validation if patient exist already in the Table

        //Validation - Patient with patient ID passed as param exists in table
        if (patientExists == true) {

            this.txtPatientID.setEnabled(false);
            //Getting Patient Data and Bind them to the form components
            Patient patientData = ApplicationLogic.GetPatientData(view_ID);          

            this.txtPatientID.setText(patientData.getPatientID());
            this.txtPatientName.setText(patientData.getName());
            this.txtPatientSurname.setText(patientData.getSurname());
            this.txtPatientAge.setText(String.valueOf(patientData.getAge()));
            this.cmbPatientGender.setSelectedItem(patientData.getGender());
            this.txtPatientPrescriptionHistory.setText(patientData.getPatientPrescriptionHistory());
            this.txtPatientSpecialRequests.setText(patientData.getPatientSpecialRequests());
            this.cmbPatientAllergies.setSelectedItem(patientData.getPatientAllergies());
            this.txtPatientDOB.setText(String.valueOf(patientData.getPatientDOB()));

        } //Validation - Patient with patient ID passed as param does not exists in table
        else {

            //Showing a message to the user informing that no Patiens were found    
            JOptionPane.showMessageDialog(null, "No Patients found with ID: " + view_ID,"Search",JOptionPane.WARNING_MESSAGE);

        }

    }

}



