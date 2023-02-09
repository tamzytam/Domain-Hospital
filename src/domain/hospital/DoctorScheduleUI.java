/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.hospital;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.*;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Tamar
 */

public class DoctorScheduleUI extends JFrame {
//Declaration of JComboBox
    private JComboBox cmbDoctorID, cmbScheduleAvailability, cmbScheduleTimeslot;

    //Declaration of Textbox
    private JTextField txtScheduleID;

    //Declaration of JLabels
    private JLabel lblDoctorID, lblScheduleID, lblScheduleDate, lblScheduleTimeslot, lblScheduleAvailability;

    //Declaration of JButtons
    private JButton exitButton, clearButton, addButton, editButton, searchButton;

    //Declaration of JFormattedTextField
    private JFormattedTextField txtAppointmentDate;

    //Declaration of String Arrays to be populated as list in the JComboBoxes
    private String[] doctorList = {};
    private final String[] scheduleTimeSlot = {"09:00AM - 09:30AM", "09:30AM - 10:00AM",
        "10:00AM - 10:30AM", "10:30AM - 11:00AM", "11:00AM - 11:30AM",
        "11:30AM - 12:00PM", "16:00PM - 16:30PM", "16:30PM - 17:00PM",
        "17:00PM - 17:30PM", "17:30PM - 18:00PM", "18:00PM - 18:30PM", "18:30PM - 19:00PM"};

    private final String[] availability = {"Available", "Not Available"};
    
    String edit_DoctorID, edit_Date, edit_TimeSlot, edit_Availability;

    // Instance of ApplicationLogic Class
    ApplicationLogic aLogic = new ApplicationLogic();

    //Default Constructor
    public DoctorScheduleUI() {

        buildDoctorScheduleGUI();
        GetDoctorData();
        doctorList = ApplicationLogic.listDoctorName();

        //Assigning an on click event to add button. AddDoctorSchedule() method will be executed
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //method to create New Doctor schedule
                AddDoctorSchedule();
            }
        });

        //exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        //clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the ClearEntry Method
                clearEntry();

            }
        });

        //edit button
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the SearchSchedule Method
                updateDoctorScheduleRecord();

            }
        });
        
         //edit button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calling the SearchSchedule Method
                SearchSchedule();

            }
        });

    }

    /*
    *Building the User Interface to capture the Doctor Schedule Details
     */
    public void buildDoctorScheduleGUI() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doctor Schedule");
        setSize(700, 600);
        setLocationRelativeTo(null);

        //This Panel will contain data input about the Patient in a grid with 10 rows and 2 columns based on fields
        JPanel doctorSchedulePanel = new JPanel(new GridLayout(12, 2));

        doctorSchedulePanel.add(new JLabel("DOCTOR SCHEDULER"));
        doctorSchedulePanel.add(new JLabel(" "));
        doctorSchedulePanel.add(new JLabel(" "));

        //creating a new instance of the label by attributing a name and adding it to the panel
        doctorSchedulePanel.add(lblDoctorID = new JLabel("Doctor ID:"));
        //creating a new instance of the combobox and passing the list from a String Array doctorList
        doctorSchedulePanel.add(cmbDoctorID = new JComboBox(doctorList));

        //creating a new instance of the label by attributing a name and adding it to the panel
        doctorSchedulePanel.add(lblDoctorID = new JLabel("Schedule Date:"));

        //Creating a Date Format Mask
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        DateFormatter formatter = new DateFormatter(format);
        //creating a new instance of the formatted textfield by attributing a textfield size and adding it to the panel
        doctorSchedulePanel.add(txtAppointmentDate = new JFormattedTextField(formatter));

        //creating a new instance of the label by attributing a name and adding it to the panel
        doctorSchedulePanel.add(lblScheduleTimeslot = new JLabel("Schedule Time Slot"));
        //creating a new instance of the combobox and passing the list from a String Array scheduleTimeSlot
        doctorSchedulePanel.add(cmbScheduleTimeslot = new JComboBox(scheduleTimeSlot));

        //creating a new instance of the label by attributing a name and adding it to the panel
        doctorSchedulePanel.add(lblScheduleAvailability = new JLabel("Schedule Availability"));
        //creating a new instance of the combobox and passing the list from a Boolean Array availability
        doctorSchedulePanel.add(cmbScheduleAvailability = new JComboBox(availability));

        //This Panel will contain form control buttons
        JPanel doctorScheduleFormControlPanel = new JPanel(new FlowLayout());
        doctorScheduleFormControlPanel.add(addButton = new JButton("Add New Doctor Schedule"));
        doctorScheduleFormControlPanel.add(clearButton = new JButton("Clear Timeslot Details"));
        doctorScheduleFormControlPanel.add(searchButton = new JButton("Search Doctor Schedule"));
        doctorScheduleFormControlPanel.add(editButton = new JButton("Update Doctor Schedule"));
        doctorScheduleFormControlPanel.add(exitButton = new JButton("Exit"));

        //add panels to frame
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(doctorSchedulePanel, BorderLayout.CENTER);
        panel.add(doctorScheduleFormControlPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
    }

    public void clearEntry() {

        this.txtAppointmentDate.setText("");
        this.cmbDoctorID.setSelectedIndex(0);
        this.cmbScheduleAvailability.setSelectedIndex(0);
        this.cmbScheduleTimeslot.setSelectedIndex(0);

    }

    /*
     *get the necessary data for Doctor
     */
    public String GetDoctorData() {
        doctorList = ApplicationLogic.listDoctorName();
        String doctorData = "";

        //check if hashmap is empty
        if (doctorList.length == 0) {
            JOptionPane.showMessageDialog(null, "There are no records in the DoctorSchedule Table!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //if hashmap is not empty, go through all the names in the hashmap, get the corresponding data Object of that name and
            for (String doctor : doctorList) {
                Doctor myDoctor = ApplicationLogic.GetDoctorData(doctor);
                //JOptionPane.showMessageDialog(null, "Size of result: " + doctorList.length);

                this.cmbDoctorID.addItem(myDoctor.getStaffID());
            } //end for loop
        }//end else

        return doctorData;
    }

    public void AddDoctorSchedule() {

        String doctorschedule_ScheduleID, doctorschedule_doctorID, doctorschedule_appointmentTimeSlot, doctorschedule_getAppointmentAvailability, doctorschedule_appintmentDate, messageTobeDisplay;
        boolean doctorschedule_appointmentAvailability, quit;

        //DO Loop
        do {

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable doctorschedule_doctorID with the selected item from the dropdown list
            doctorschedule_doctorID = this.cmbDoctorID.getSelectedItem().toString();

            //Checking if the string variable doctorschedule_doctorID is not null
            if (doctorschedule_doctorID != null) {

                //Checking if the string variable doctorschedule_doctorID is not empty
                if (doctorschedule_doctorID.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient ID
                    JOptionPane.showMessageDialog(null, "Doctor ID is Mandatory. Kindly select the Doctor", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //Patient ID contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //doctorschedule_doctorID is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable doctorschedule_appintmentDate with the text submitted in the form textbox
            doctorschedule_appintmentDate = this.txtAppointmentDate.getText();

            //Checking if the string variable doctorschedule_appintmentDate is not null
            if (doctorschedule_appintmentDate != null) {

                //Checking if the string variable doctorschedule_appintmentDate is not empty
                if (doctorschedule_appintmentDate.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Prescription
                    JOptionPane.showMessageDialog(null, "Doctor Schedule Date Is Mandatory. Please submit Date", "Error", JOptionPane.ERROR_MESSAGE);

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

            //Assigning the variable doctorschedule_appointmentTimeSlot with the text submitted in the form textbox
            doctorschedule_appointmentTimeSlot = this.cmbScheduleTimeslot.getSelectedItem().toString();

            //Checking if the string variable doctorschedule_appointmentTimeSlot is not null
            if (doctorschedule_appointmentTimeSlot != null) {

                //Checking if the string variable doctorschedule_appointmentTimeSlot is not empty
                if (doctorschedule_appointmentTimeSlot.trim().equals("")) {

                    //Displaying a message box for the user to submit the Patient Special Requests or Remarks
                    JOptionPane.showMessageDialog(null, "Appointment Time Slot. Kindly select the Timeslot ", "Error", JOptionPane.ERROR_MESSAGE);

                    //Boolean quit is switched to true. Do Loop will end
                    quit = true;

                    //Breaking the loop
                    break;

                    //PatientRequest contains text   
                } else {

                    //Boolean variable quit is False. Do Loop will proceed
                    quit = false;
                }
                //doctorschedule_appointmentTimeSlot is null and loop will break 
            } else {

                //Return to User 
                return;
            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Assigning the variable doctorschedule_getAppointmentAvailability with the text submitted in the form textbox
            //doctorschedule_getAppointmentAvailability = this.cmbScheduleAvailability.
            doctorschedule_getAppointmentAvailability = this.cmbScheduleAvailability.getSelectedItem().toString();

            if ("Available".equals(doctorschedule_getAppointmentAvailability)) {
                doctorschedule_appointmentAvailability = true;

            } else {

                doctorschedule_appointmentAvailability = false;

            }

            //-----------------------------------------------------------------------------------------------------------------------------------------------------
            //Setting the String variable messageTobeDisplay to empty
            messageTobeDisplay = "";

            //Validating and checking if a Doctor Schedule object with the same parameters of doctorschedule_doctorID, 
            //doctorschedule_appintmentDate, and doctorschedule_appointmentTimeSlot existis in the system
            Vector<DoctorSchedule> validateAppointmentScheduleEntry = aLogic.checkScheduleIfExisits(doctorschedule_doctorID, doctorschedule_appintmentDate, doctorschedule_appointmentTimeSlot);

            //If the vector validateAppointmentScheduleEntry is returned empty, Schedule is available and a new schedule can be added.
            if (validateAppointmentScheduleEntry.isEmpty()) {

                //Setting the String variable messageTobeDisplay to - Available    
                messageTobeDisplay = "Doctor Schedule is Available - Availability is allocated";

                //Calling the addDoctorScheduleVector from the ApplicationLogic class to add the new Schedule Record
                aLogic.addDoctorScheduleVector(doctorschedule_doctorID, doctorschedule_appintmentDate, doctorschedule_appointmentTimeSlot, doctorschedule_appointmentAvailability);

                //Displaying a message box informing the user that Doctor Availability record was successfully added to the list
                JOptionPane.showMessageDialog(null, "Successfully Added new schedule Availability to the Doctor Schedule List", "Schedule", JOptionPane.INFORMATION_MESSAGE);
            } else {

                //Setting the String variable messageTobeDisplay to - Booked     
                messageTobeDisplay = "Doctor Schedule is already booked";

            }

            //Displaying a messagebox with the messageTobeDisplay    
            JOptionPane.showMessageDialog(null,
                    messageTobeDisplay);

        } while (quit == true);

    }

    public void SearchSchedule() {

        edit_DoctorID = this.cmbDoctorID.getSelectedItem().toString();
        edit_Date = this.txtAppointmentDate.getText();
        edit_TimeSlot = this.cmbScheduleTimeslot.getSelectedItem().toString();
        edit_Availability = this.cmbScheduleAvailability.getSelectedItem().toString();
   
        String messageTobeDisplay = "";
        
        DoctorSchedule ds = aLogic.searchDoctorSchedule(edit_DoctorID, edit_Date, edit_TimeSlot);
        
        if(ds==null)
        {
            messageTobeDisplay = "No Record Found";
            
        }
        
        else
        {
        
        messageTobeDisplay = "Schedule Record Found";
        
        clearEntry();
        
                this.cmbDoctorID.setSelectedItem(ds.getDoctorID());
                this.txtAppointmentDate.setText(ds.getAvailableAppointmentDate());
                this.cmbScheduleAvailability.setSelectedItem(ds.getAppointmentAvailability());
                this.cmbScheduleTimeslot.setSelectedItem(ds.getAvailableAppointmentTimeSlot());
        
        }
        
         //Displaying a messagebox with the messageTobeDisplay    
        JOptionPane.showMessageDialog(null,
                messageTobeDisplay);
        
    }

    /*
     * A Void Method the Search a Doctor Schedule based on the Doctor Id
     */
    public void SearchDoctorSchedule() {

        //Showing an input Dialogue for the customer to submit search entry
        String view_ID = JOptionPane.showInputDialog(null, "Please Submit Doctor ID as Search Criteria");

        // Declaring a seachDoctorScheduleVector of type Vector to access the SearchDoctorSchedule from the Application Logic Class with the DoctorID as parametre
        Vector<DoctorSchedule> seachDoctorScheduleVector = aLogic.seachDoctorScheduleVector(view_ID);

        //Setting the String variable messageTobeDisplay to empty
        String messageTobeDisplay = "";

        //Validating If the vector seachDoctorScheduleVector is returned empty
        if (seachDoctorScheduleVector.isEmpty()) {

            //Setting the String variable messageTobeDisplay to = No Doctor Found
            messageTobeDisplay = "No doctor found with the ID: " + view_ID;
        } //seachDoctorScheduleVector is returned not empty
        else {

            //FOR Loop to iterate through the seachDoctorScheduleVector vector
            for (int i = 0; i < seachDoctorScheduleVector.size(); i++) {
                messageTobeDisplay = messageTobeDisplay + " Appointment Found with Doctor ID:"
                        + view_ID + seachDoctorScheduleVector.get(i).getAvailableAppointmentDate();
            }

        }
        //Displaying a messagebox with the messageTobeDisplay  
        JOptionPane.showMessageDialog(null, messageTobeDisplay);

    }
    
    public void updateDoctorScheduleRecord(){
    
          
   DoctorSchedule ds = aLogic.searchDoctorSchedule(edit_DoctorID, edit_Date, edit_TimeSlot);

        
        if(ds.toString()==null)
        {

             JOptionPane.showMessageDialog(null, "Record Not Found", "Search", JOptionPane.WARNING_MESSAGE);
        }
        
        else
        {

            aLogic.searchAndDeleteDoctorSchedule(edit_DoctorID, edit_Date, edit_TimeSlot);
            
            AddDoctorSchedule();
    
        }
        
    
    }
    
}
