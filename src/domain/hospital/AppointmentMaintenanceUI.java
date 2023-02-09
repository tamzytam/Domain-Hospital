/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.hospital;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author Tamar
 */
public class AppointmentMaintenanceUI extends JFrame {
   //Declaration of JButtons
    private JButton exitButton, clearButton, updateButton, searchButton, prescribeButton;

    //Declaration of JComboBox
    private JComboBox cmbAppointmentStatus, cmbAttendanceStatus, cmbAppointmentDateTimeSlot;

    //Declaration of JLabels
    private JLabel lblPatientName, lblPatientID, lblDoctorID, lblDoctorName, lblAppointmentDate, lblAppointmentDateTimeSlot, lblPatientSymptoms, lblDoctorNotes, lblDoctorMedications, lblAppointmentStatus, lblAttendanceStatus, lblAppointmentID;

    //Declaration of Textbox
    private JTextField txtPatientName, txtPatientID, txtDoctorID, txtDoctorName, txtAppointmentDate, txtPatientSymptoms, txtDoctorNotes, txtDoctorMedications, txtAppointmentDateTimesSlot, txtAppointmentID;

    private final String[] appoitmentStatusList = {"Pending", "Attended", "Cancel", "No Show"};

    private final String[] attendanceStatusList = {"Pending", "Checked In", "Diagnosed", "Finish"};

    //Declaration of String Arrays to be populated as list in the JComboBoxes
    private String[] doctorList = {};

    //Declaration of Strin Array to contain the field names of the table
    private String[] tableHeader = {"Appointment Date", "Appointment Time Slot", "Appointment Availability"};

    //Decleration of JTable
    private JTable tblAppointments, tblMedicine;

    
    Object[][] data = {};
    DefaultTableModel model = new DefaultTableModel(data, tableHeader);

    // Instance of ApplicationLogic Class
    ApplicationLogic aLogic = new ApplicationLogic();

    String appointmentID = "", edit_doctorID = "", edit_date = "", edit_timeslot = "";

    public AppointmentMaintenanceUI(String param, String userType) {

        //Checking if userType is equal to Patient
        if (userType.equals("Doctor")) {

            Doctor doctorData = ApplicationLogic.GetDoctorData(param);

            //Assigning the string Variable loginUser with Doctor's Name and Surname
            String loginUser = doctorData.getName() + " " + doctorData.getSurname();

            //Setting up the Window Title
            setTitle("Surgical Application " + loginUser + " - " + userType);

            builtAppointmentMaintenanceGUI();
            this.prescribeButton.setEnabled(true);
            this.txtAppointmentDate.setEditable(false);
            this.txtAppointmentDateTimesSlot.setEditable(false);
            this.tblAppointments.setEnabled(false);
            
            //Setting Action Listeners
        //Assigning an on click event to update button. UpdateAppointment method will be executed
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to update Appointment
                updateAppointment();
            }
        });

        //exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Closing the Application
                System.exit(0);

            }
        });

        //clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the clearRecord Method
                clearRecord();

            }
        });

        //search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the Search Method
                searchAppointment();
            }
        });
        
         //prescribe button
        prescribeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the Search Method
                populateMedicineTable();
                tblAppointments.setEnabled(true);
                
            }
        });

        tblAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //load table information into parameters
                txtDoctorMedications.setText(tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 0).toString() 
                        + " - " + tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 1).toString() 
                        + " - " +tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 2).toString());
              

            }
        });

        }
        
        else if (userType.equals("Secretary")) {

            //Getting Receptionist Staff Details
            Staff staffData = ApplicationLogic.GetStaffData(param);

            //Assigning the string Variable loginUser with Receptionist's Name and Surname
            String loginUser = staffData.getName() + " " + staffData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital " + loginUser + " - " + userType);

            builtAppointmentMaintenanceGUI();
            this.prescribeButton.setEnabled(false);
            this.txtAppointmentDate.setEditable(true);
            this.txtAppointmentDateTimesSlot.setEditable(true);
            
            //Setting Action Listeners
        //Assigning an on click event to update button. UpdateAppointment method will be executed
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to update Appointment
                updateAppointment();
            }
        });

        //exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Closing the Application
                System.exit(0);

            }
        });

        //clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the clearRecord Method
                clearRecord();

            }
        });

        //search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the Search Method
                searchAppointment();
            }
        });
        

        tblAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //load table information into parameters
                txtAppointmentDate.setText(tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 0).toString());
                txtAppointmentDateTimesSlot.setText(tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 1).toString());

            }
        });

        }
    }

//Default Constructor
    public AppointmentMaintenanceUI() {

        //Calling the builtAppointmentMaintenanceGUI() method
        builtAppointmentMaintenanceGUI();

        //Setting Action Listeners
        //Assigning an on click event to update button. UpdateAppointment method will be executed
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to update Appointment
                updateAppointment();
            }
        });

        //exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Closing the Application
                System.exit(0);

            }
        });

        //clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the clearRecord Method
                clearRecord();

            }
        });

        //search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the Search Method
                searchAppointment();
            }
        });
        
         //prescribe button
        prescribeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the Search Method
                populateMedicineTable();
            }
        });

        tblAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //load table information into parameters
                txtAppointmentDate.setText(tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 0).toString());
                txtAppointmentDateTimesSlot.setText(tblAppointments.getValueAt(tblAppointments.getSelectedRow(), 1).toString());

            }
        });

    }

    public void builtAppointmentMaintenanceGUI() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //setTitle("Appointment Scheduler");
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        //This Panel will contain data input about the Patient in a grid with 15 rows and 2 columns based on fields
        JPanel appointmentSchedulePanel = new JPanel(new GridLayout(15, 2));

        appointmentSchedulePanel.add(new JLabel("APPOINTMENT SCHEDULER"));
        appointmentSchedulePanel.add(new JLabel(" "));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblAppointmentID = new JLabel("Appointment ID:"));
        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        appointmentSchedulePanel.add(txtAppointmentID = new JTextField(3));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblPatientID = new JLabel("Patient ID:"));
        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        appointmentSchedulePanel.add(txtPatientID = new JTextField(3));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblPatientName = new JLabel("Patient Name:"));
        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        appointmentSchedulePanel.add(txtPatientName = new JTextField(25));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblPatientSymptoms = new JLabel("Patient Symptoms:"));
        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        appointmentSchedulePanel.add(txtPatientSymptoms = new JTextField(50));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblDoctorID = new JLabel("Doctor ID:"));
        //creating a new instance of the combobox and passing the list from a String Array doctorList
        appointmentSchedulePanel.add(txtDoctorID = new JTextField(25));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblDoctorName = new JLabel("Doctor Name:"));
        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        appointmentSchedulePanel.add(txtDoctorName = new JTextField(25));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblAppointmentDate = new JLabel("Appointment Date:"));
        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        appointmentSchedulePanel.add(txtAppointmentDate = new JTextField(10));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblAppointmentDateTimeSlot = new JLabel("Schedule Time Slot:"));
        //creating a new instance of the combobox
        appointmentSchedulePanel.add(txtAppointmentDateTimesSlot = new JTextField(25));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblDoctorNotes = new JLabel("Doctor Notes:"));
        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        appointmentSchedulePanel.add(txtDoctorNotes = new JTextField(150));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblDoctorMedications = new JLabel("Doctor Medications:"));
        //creating a new instance of the textfield by attributing a textfield size and adding it to the panel
        appointmentSchedulePanel.add(txtDoctorMedications = new JTextField(150));
        appointmentSchedulePanel.add(new JLabel(" "));
        this.txtDoctorMedications.setEnabled(false);

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblAppointmentStatus = new JLabel("Appointment Status:"));
        //creating a new instance of the combobox and passing the list from a String Array appointmentStatusList
        appointmentSchedulePanel.add(cmbAppointmentStatus = new JComboBox(appoitmentStatusList));
        appointmentSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        appointmentSchedulePanel.add(lblAttendanceStatus = new JLabel("Attendance Status:"));
        //creating a new instance of the combobox and passing the list from a String Array attendanceStatusList
        appointmentSchedulePanel.add(cmbAttendanceStatus = new JComboBox(attendanceStatusList));
        appointmentSchedulePanel.add(new JLabel(" "));

        JPanel JTablePanel = new JPanel(new GridLayout(1, 1));

        tblAppointments = new JTable(model);
        JScrollPane tableContainer = new JScrollPane(tblAppointments);

        JTablePanel.add(tableContainer, BorderLayout.CENTER);
        tblAppointments.setPreferredScrollableViewportSize(new Dimension());
        tblAppointments.setFillsViewportHeight(true);

        //This Panel will contain form control buttons
        JPanel appointmentScheduleFormControlPanel = new JPanel(new FlowLayout());
        appointmentScheduleFormControlPanel.add(updateButton = new JButton("Update Appointment"));
        appointmentScheduleFormControlPanel.add(clearButton = new JButton("Clear Record"));
        appointmentScheduleFormControlPanel.add(searchButton = new JButton("Search"));
        appointmentScheduleFormControlPanel.add(prescribeButton = new JButton("Prescribe Medicine"));
        appointmentScheduleFormControlPanel.add(exitButton = new JButton("Exit"));

        //add panels to frame
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(appointmentSchedulePanel, BorderLayout.CENTER);
        panel.add(JTablePanel, BorderLayout.CENTER);
        panel.add(appointmentScheduleFormControlPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

    }

    public void searchAppointment() {

        boolean quit = false;

        while (quit == false) {

            // show searchByMenu and read the option
            String searchByMenu = "1. Appointment ID \n2. Cancel";
            String choice = JOptionPane.showInputDialog(null, searchByMenu, "APPOINTNEMT - SEARCH BY:",
                    JOptionPane.PLAIN_MESSAGE);

            // convert choice to integer
            try {
                // to deal with the case taht the user chooses cancel from the searchByMenu.
                if (choice != null) {

                    int iChoice = Integer.parseInt(choice);

                    // do action according to choice
                    switch (iChoice) {
                        case 1:

                            //CALL METHOD
                            searchAppointmentByAppointmentID();
                            quit = true;
                            break;
                     
                        case 2:
                            quit = true;
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Invalid Entry", "Error", JOptionPane.WARNING_MESSAGE);
                            break;
                    } //switch

                }// end if choice is not null

            }//try
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Incorrect Entry\n" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

            }//catch

        }//while

    }
 
     
     public void searchAppointmentByAppointmentID() {

        //Showing an input Dialogue for the user to submit search entry
        String view_ID = JOptionPane.showInputDialog(null, "Please Submit Appointment ID as Search Criteria");

        Appointment app = aLogic.searchAppointment(view_ID);

        if (app == null) {

            JOptionPane.showMessageDialog(null, "Record Not Found", "Search", JOptionPane.WARNING_MESSAGE);

        } //Record Found
        else {

            appointmentID = view_ID;
            //Populating Data to the Form Components
            this.txtAppointmentID.setText(app.getAppointment_AppointmentID());
            appointmentID = app.getAppointment_AppointmentID();

            this.txtPatientID.setText(app.getAppointment_PatientID());
            this.txtDoctorID.setText(app.getAppointment_DoctorID());
            edit_doctorID = app.getAppointment_DoctorID();

            this.txtPatientSymptoms.setText(app.getAppointment_PatientSymptoms());
            this.txtAppointmentDate.setText(app.getAppointmentDate());

            edit_date = app.getAppointmentDate();
            this.txtDoctorMedications.setText(app.getAppointment_DoctorMedications());
            this.txtDoctorNotes.setText(app.getAppointment_DoctorNotes());
            this.txtAppointmentDateTimesSlot.setText(app.getAppointment_TimeSlot());
            edit_timeslot = app.getAppointment_TimeSlot();

            this.cmbAppointmentStatus.addItem(app.getAppointment_AppointmentStatus());
            this.cmbAttendanceStatus.addItem(app.getAppointment_AttendanceStatus());

           
            populateTable();
            searchPatient();
            searchDoctor();
        }

    }

    public void searchPatient() {

        //Assinging the variable view_ID with the text retrieved from txtPatientID.
        String view_ID = this.txtPatientID.getText();

        boolean patientExists = ApplicationLogic.GetPatientID(view_ID);
        //Validation if patient exist already in the Table

        //Validation - Patient with patient ID passed as param exists in table
        if (patientExists == true) {

            this.txtPatientID.setEnabled(false);
            //Getting Patient Data and Bind them to the form components
            Patient patientData = ApplicationLogic.GetPatientData(view_ID);

            this.txtPatientName.setText(patientData.getName());

        } //Validation - Patient with patient ID passed as param does not exists in table
        else {

            //Showing a message to the user informing that no Patiens were found    
            JOptionPane.showMessageDialog(null, "No Patients found with ID: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        }

    }

    /**
     *
     */
    public void searchDoctor() {

        //Showing an input Dialogue for the receptionist to submit search entry
        String view_ID = this.txtDoctorID.getText();

        boolean staffExists = ApplicationLogic.GetStaffID(view_ID);
        //Boolean if staff exist already in the Table

        //Validation - Staff with StaffID passed as param exists in table
        if (staffExists == true) {

            //Getting Staff Data and Bind them to the form components
            Staff staffData = ApplicationLogic.GetStaffData(view_ID);

            this.txtDoctorName.setText(staffData.getName());

        } //Validation - Staff with Staff ID passed as param does not exists in table
        else {

            //Showing a message to the user informing that no Staff were found    
            JOptionPane.showMessageDialog(null, "No Doctor was found with ID: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        }

    }

    public void editDoctorSchedule() {

        String doctorID, scheduleDate, scheduleTimeslot;

        doctorID = this.txtDoctorID.getText();
        scheduleDate = this.txtAppointmentDate.getText();
        scheduleTimeslot = this.txtAppointmentDateTimesSlot.getText();

        DoctorSchedule ds = aLogic.searchDoctorSchedule(edit_doctorID, edit_date, edit_timeslot);

        if (ds.toString() == null) {

            JOptionPane.showMessageDialog(null, "Record Not Found", "Search", JOptionPane.WARNING_MESSAGE);
        } else {

            if (ds.getAppointmentAvailability() == false) {

                aLogic.searchAndDeleteDoctorSchedule(edit_doctorID, edit_date, edit_timeslot);
                aLogic.addDoctorScheduleVector(edit_doctorID, edit_date, edit_timeslot, true);
                aLogic.searchAndDeleteDoctorSchedule(doctorID, scheduleDate, scheduleTimeslot);
                aLogic.addDoctorScheduleVector(doctorID, scheduleDate, scheduleTimeslot, false);

                JOptionPane.showMessageDialog(null, "Doctor Schedule Changed to Available", "Doctor Schedule", JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }

    public void updateAppointment() {

        if (this.cmbAppointmentStatus.getSelectedItem().toString().equals("Cancel")) {

            Appointment app = aLogic.searchAppointment(appointmentID);

            if (app.toString() == null) {

                JOptionPane.showMessageDialog(null, "Record Not Found", "Search", JOptionPane.WARNING_MESSAGE);
            } else {

                aLogic.searchAndDeleteAppointment(appointmentID);

                DoctorSchedule ds = aLogic.searchDoctorSchedule(edit_doctorID, edit_date, edit_timeslot);

                if (ds.toString() == null) {

                    JOptionPane.showMessageDialog(null, "Record Not Found", "Search", JOptionPane.WARNING_MESSAGE);
                } else {

                    if (ds.getAppointmentAvailability() == false) {

                        aLogic.searchAndDeleteDoctorSchedule(edit_doctorID, edit_date, edit_timeslot);
                        aLogic.addDoctorScheduleVector(edit_doctorID, edit_date, edit_timeslot, true);

                        JOptionPane.showMessageDialog(null, "Doctor Schedule Changed to Available", "Doctor Schedule", JOptionPane.INFORMATION_MESSAGE);

                    }

                }
                addAppointment();

                JOptionPane.showMessageDialog(null, "Appoint has been Cancelled.", "Cancel", JOptionPane.WARNING_MESSAGE);

            }

        } else {

            Appointment app = aLogic.searchAppointment(appointmentID);

            if (app.toString() == null) {

                JOptionPane.showMessageDialog(null, "Record Not Found", "Search", JOptionPane.WARNING_MESSAGE);
            } else {

                aLogic.searchAndDeleteAppointment(appointmentID);
                addAppointment();

            }

        }
    }

    public void clearRecord() {
        
        this.txtAppointmentDate.setText("");
        this.txtAppointmentDateTimesSlot.setText("");
        this.txtAppointmentID.setText("");
        this.txtDoctorID.setText("");
        this.txtDoctorMedications.setText("");
        this.txtDoctorName.setText("");
        this.txtDoctorNotes.setText("");
        this.txtPatientID.setText("");
        this.txtPatientName.setText("");
        this.txtPatientSymptoms.setText("");
        this.cmbAppointmentStatus.setSelectedIndex(0);
        this.cmbAttendanceStatus.setSelectedIndex(0);
    }

    public void addAppointment() {

        String appointment_appointmentID;
        String appointment_patientID;
        String appointment_doctorID;
        String appointment_date;
        String appointment_timeslot;
        String appointment_patientSymptoms;
        String appointment_doctorNotes;
        String appointment_doctorMedications;
        String appointment_appointmentStatus;
        String appointment_attendanceStatus;

        boolean quit = true;

        //DO Loop
        do {

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable appointment_patientID with the text submitted in the form textbox
            appointment_patientID = this.txtPatientID.getText();

            //Checking if the string variable appointment_patientID is not null
            if (appointment_patientID != null) {

                //Checking if the string variable patientID is not empty
                if (appointment_patientID.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient ID
                    JOptionPane.showMessageDialog(null, "Patient ID is Mandatory. Kindly submit the Patient ID");

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
            //Assigning the variable appointment_doctorID with the selected item from the combobox cmbDoctorID
            appointment_doctorID = this.txtDoctorID.getText();

            //Checking if the string variable appointment_doctorID is not null
            if (appointment_doctorID != null) {

                //Checking if the string variable appointment_doctorID is not empty
                if (appointment_doctorID.trim().equals("")) {

                    //Displaying a message box for the user to submit the Doctor ID
                    JOptionPane.showMessageDialog(null, "Doctor ID is required for the Appointment. Kindly Select the Doctor ID");

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //appointment_doctorID contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //appointment_doctorID is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable appointment_date with the text submitted in the form textbox
            appointment_date = this.txtAppointmentDate.getText();

            //Checking if the string variable appointment_patientID is not null
            if (appointment_date != null) {

                //Checking if the string variable appointment_date is not empty
                if (appointment_date.trim().equals("")) {

                    //Displaying a message box for the user to submit the appointment_date
                    JOptionPane.showMessageDialog(null, "Appointment Date is Mandatory. Kindly submit the Appointment Date in DD/MM/YYYY");

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //appointment_date contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //appointment_date is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
//Assigning the variable appointment_timeslot with the selected item from the combobox cmbAppointmenDateTimeSlot
            appointment_timeslot = this.txtAppointmentDateTimesSlot.getText();

            //Checking if the string variable appointment_timeslot is not null
            if (appointment_timeslot != null) {

                //Checking if the string variable appointment_timeslot is not empty
                if (appointment_timeslot.trim().equals("")) {

                    //Displaying a message box for the user to select the Appointment Time Slot
                    JOptionPane.showMessageDialog(null, "Appointment Timeslot is required for the Appointment. "
                            + "Kindly submit the appropriate Appointment Timeslot");

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //appointment_timeslot contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //appointment_timeslot is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
//Assigning the variable appointment_patientSymptoms with the text submitted in the form textbox
            appointment_patientSymptoms = this.txtPatientSymptoms.getText();

            //Checking if the string variable appointment_patientSymptoms is not null
            if (appointment_patientSymptoms != null) {

                //Checking if the string variable appointment_patientSymptoms is not empty
                if (appointment_patientSymptoms.trim().equals("")) {

                    //Displaying a message box for the user to submit the patient Symptoms
                    JOptionPane.showMessageDialog(null, "Patient Symptom is Mandatory. Kindly submit the Patient Symptom");

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
            //Assigning the variable appointment_appointmentStatus with the selected item from the combobox cmbAppointmenStatus
            appointment_appointmentStatus = this.cmbAppointmentStatus.getSelectedItem().toString();

            //Checking if the string variable appointment_appointmentStatus is not null
            if (appointment_appointmentStatus != null) {

                //Checking if the string variable appointment_appointmentStatus is not empty
                if (appointment_appointmentStatus.trim().equals("")) {

                    //Displaying a message box for the user to submit the Appointment Status
                    JOptionPane.showMessageDialog(null, "Appointment Status is required for the Appointment. "
                            + "Kindly Select the Pending Appointment Status");

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //appointment_appointmentStatus contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //appointment_appointmentStatus is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable appointment_attendanceStatus with the selected item from the combobox cmbAttendanceStatus
            appointment_attendanceStatus = this.cmbAttendanceStatus.getSelectedItem().toString();

            //Checking if the string variable appointment_attendanceStatus is not null
            if (appointment_attendanceStatus != null) {

                //Checking if the string variable appointment_attendanceStatus is not empty
                if (appointment_attendanceStatus.trim().equals("")) {

                    //Displaying a message box for the user to submit the Appointment Status
                    JOptionPane.showMessageDialog(null, "Patient Attendance Status is required for the Appointment. "
                            + "Kindly Select the Pending Patient Attendance Status");

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //appointment_attendanceStatus contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //appointment_attendanceStatus is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Setting Doctor Notes to Empty
            appointment_doctorNotes = this.txtDoctorNotes.getText();

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Setting Doctor Medications to Empty
            appointment_doctorMedications = this.txtDoctorMedications.getText();

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Setting the Appointent ID for the Appointment Record
            appointment_appointmentID = appointment_patientID + "-" + appointment_date;

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Checking if an existing appointment for the Patient is already scheduled for the given date.
            Appointment app = aLogic.searchAppointment(appointment_appointmentID);

            //If NO appointments are scheduled for the given that for the respective patient Appointment will be scheduled
            if (app == null) {

                //Informing the Receptionist with the following message
                JOptionPane.showMessageDialog(null, "No Appointment Scheduled for this Day for Patient. Proceeding with appointment scheduling.", "Search", JOptionPane.WARNING_MESSAGE);

                //Calling the AddAppointmentVector Method to Add new Appointment to the System
                aLogic.addAppointmentVector(appointment_appointmentID, appointment_patientID, appointment_doctorID, appointment_date, appointment_timeslot, appointment_patientSymptoms, appointment_doctorNotes, appointment_doctorMedications, appointment_appointmentStatus, appointment_attendanceStatus);

                //Calling the Edit Doctor Schedule Method to update the doctor Schedule and remove the time slot from availability pool
                editDoctorSchedule();

                //Informing the Receptionist that the new Appointment has been scheduled. An Appointment ID is issued and is to be passed to the Patient for appointment reference 
                JOptionPane.showMessageDialog(null, "Appointment Details Updated. Appointment ID:  " + appointment_appointmentID, "Appointment Update", JOptionPane.INFORMATION_MESSAGE);
            } else {

                //Patient already have an appointment scheduled for the selected date. Receptionist will inform the Patient and schedule a different Date.  
                JOptionPane.showMessageDialog(null, "Patient already have another appointment scheduled for the selected Date. /nPlease Select a different date. /nExisting Appointment Details: /n Appointment ID: " + app.getAppointment_AppointmentID() + "/n Appointment Time Slot: " + app.getAppointment_TimeSlot() + "/n Doctor ID: " + app.getAppointment_DoctorID() + "/n Symptoms: " + app.getAppointment_PatientSymptoms(), "New Appointment", JOptionPane.INFORMATION_MESSAGE);

            }

        } while (quit == true);

    }

    public void populateTable() {

        //Showing an input Dialogue for the user to submit search entry
        String view_ID = this.txtDoctorID.getText();

        //load JTable
        DefaultTableModel dtm = (DefaultTableModel) tblAppointments.getModel();
        dtm.setRowCount(0);//clear all records

        //Only Available Timeslots will be populated.
        Vector<DoctorSchedule> seachDoctorScheduleVector = aLogic.seachDoctorScheduleVectorByAvailabilityTRUE(view_ID);

        for (int i = 0; i < seachDoctorScheduleVector.size(); i++) {

            dtm.addRow(new Object[]{seachDoctorScheduleVector.get(i).getAvailableAppointmentDate(), seachDoctorScheduleVector.get(i).getAvailableAppointmentTimeSlot(), seachDoctorScheduleVector.get(i).getAppointmentAvailability()});

        }
        //Setting the focus on first Row.
        tblAppointments.changeSelection(0, 0, false, false);
        

    }
    
    public void populateMedicineTable(){
    
      
    //Only Available Timeslots will be populated.
        Vector<MedicinePrescription> getAllMedicine = aLogic.getAllMedicine();
        JOptionPane.showMessageDialog(null, getAllMedicine.size());
    
        
    //load JTable
    String[] tableHeaderAppointments = {"Medicine Name", "Medicine Dosage", "Medicine Type"};   
    

        model = new DefaultTableModel(data, tableHeaderAppointments);
        model.fireTableStructureChanged();
        model.fireTableDataChanged();

        //load JTable tblReport
        DefaultTableModel dtm = (DefaultTableModel) tblAppointments.getModel();
       
        dtm.setRowCount(0);
        
        dtm.setDataVector(data, tableHeaderAppointments);
        dtm.setColumnCount(tableHeaderAppointments.length);

        //model = new DefaultTableModel(data, tableHeaderAppointments);
        JTableHeader header = tblAppointments.getTableHeader();
        header.setBackground(Color.lightGray);

  
        //Only Available Timeslots will be populated.
       
        for (int i = 0; i < getAllMedicine.size(); i++) {

            dtm.addRow(new Object[]{getAllMedicine.get(i).getMedicineName(), getAllMedicine.get(i).getMedicineDosage(), getAllMedicine.get(i).getMedicineType()});

        }
        
        dtm.fireTableDataChanged();
        dtm.fireTableStructureChanged();
        //Setting the focus on first Row.
        tblAppointments.changeSelection(0, 0, false, false);


    
    
    }

}