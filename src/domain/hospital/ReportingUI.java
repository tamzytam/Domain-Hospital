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
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Tamar
 */
public class ReportingUI extends JFrame {
    //Declaration of JButtons
    private JButton exitButton, viewAllPatientAppointmentHistory, viewAllDoctorSchedules, viewAllDoctorAppointments, exportReport, viewPatientMedication, viewAppointmentsByStatus;

    Object[][] data = {};

    //Declaration of Strin Array to contain the field names of the table
    private String[] tableHeader = {"Appointment Date", "Appointment Time Slot", "Appointment Availability"};

    //Declaration of a DefaultTable Model
    DefaultTableModel model = new DefaultTableModel(data, tableHeader);

    //Decleration of JTable
    private JTable tblReport;

    // Instance of ApplicationLogic Class
    ApplicationLogic aLogic = new ApplicationLogic();

    public ReportingUI(String param, String userType) {

        //Checking if userType is equal to Patient
        if (userType.equals("Pharmacist")) {

            Staff staffData = ApplicationLogic.GetStaffData(param);

            //Assigning the string Variable loginUser with staffData's Name and Surname
            String loginUser = staffData.getName() + " " + staffData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital " + loginUser + " - " + userType);

            buildReportingGUI();

            viewPatientMedication.setEnabled(true);
            exitButton.setEnabled(true);
            viewAllPatientAppointmentHistory.setEnabled(false);
            viewAllDoctorSchedules.setEnabled(false);
            viewAllDoctorAppointments.setEnabled(false);
            exportReport.setEnabled(true);
            viewPatientMedication.setEnabled(true);
            viewAppointmentsByStatus.setEnabled(false);

            //View Patient Medication button
            viewPatientMedication.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the getAllDoctorSchedulesByDoctorID method
                    getAllMedications();

                }
            });

            //Export Report button
            exportReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the exportReportFile() method
                    exportReport();
                }
            });

            //Export Report button
            exportReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the exportReportFile() method
                    exportReport();
                }
            });

        }

        //Checking if userType is equal to Patient
        if (userType.equals("Patient")) {

            Patient patientData = ApplicationLogic.GetPatientData(param);

            //Assigning the string Variable loginUser with patient's Name and Surname
            String loginUser = patientData.getName() + " " + patientData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital " + loginUser + " - " + userType);

            buildReportingGUI();

            viewPatientMedication.setEnabled(false);
            exitButton.setEnabled(true);
            viewAllPatientAppointmentHistory.setEnabled(true);
            viewAllDoctorSchedules.setEnabled(false);
            viewAllDoctorAppointments.setEnabled(false);
            exportReport.setEnabled(true);
            viewAppointmentsByStatus.setEnabled(false);

            //Exit button
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Exit
                    System.exit(0);
                }
            });

            //Export Report button
            exportReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the exportReportFile() method
                    exportReport();
                }
            });

            //view All Patient Appointment History button
            viewAllPatientAppointmentHistory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling getAllPatientAppointmentsByPatientID()
                    getAllPatientAppointmentsByPatientID(param);

                }
            });

        }

        //Checking if userType is equal to Doctor
        if (userType.equals("Doctor")) {

            Doctor doctorData = ApplicationLogic.GetDoctorData(param);

            //Assigning the string Variable loginUser with doctorData's Name and Surname
            String loginUser = doctorData.getName() + " " + doctorData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital " + loginUser + " - " + userType);

            buildReportingGUI();

            viewPatientMedication.setEnabled(true);
            exitButton.setEnabled(true);
            viewAllPatientAppointmentHistory.setEnabled(false);
            viewAllDoctorSchedules.setEnabled(true);
            viewAllDoctorAppointments.setEnabled(true);
            exportReport.setEnabled(true);
            viewAppointmentsByStatus.setEnabled(false);

            //View Patient Medication button
            viewPatientMedication.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the getAllDoctorSchedulesByDoctorID method
                    getAllMedications();

                }
            });

            //Export Report button
            exportReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the exportReportFile() method
                    exportReport();
                }
            });

            //view All Patient Appointment History button
            viewAllPatientAppointmentHistory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling getAllPatientAppointmentsByPatientID()
                    getAllPatientAppointmentsByPatientID(param);

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

            //View All Doctor Schedules button
            viewAllDoctorSchedules.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the getAllDoctorSchedulesByDoctorID method
                    getAllDoctorSchedulesByDoctorID(param);

                }
            });

            //View All Appointments Schedules button
            viewAllDoctorAppointments.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the getAllDoctorSchedulesByDoctorID method
                    getAllDoctorAppointmentsByDoctorID(param);

                }
            });

            //View All Appointments By Status button
            viewAppointmentsByStatus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the searchAppointmentByStatus method
                    searchAppointmentByStatus();

                }
            });

        }

        if (userType.equals("Secretary")) {

            Staff staffData = ApplicationLogic.GetStaffData(param);

            //Assigning the string Variable loginUser with staffData's Name and Surname
            String loginUser = staffData.getName() + " " + staffData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital " + loginUser + " - " + userType);

            buildReportingGUI();

            viewPatientMedication.setEnabled(true);
            exitButton.setEnabled(true);
            viewAllPatientAppointmentHistory.setEnabled(true);
            viewAllDoctorSchedules.setEnabled(true);
            viewAllDoctorAppointments.setEnabled(true);
            exportReport.setEnabled(true);
            viewAppointmentsByStatus.setEnabled(true);

            //View Patient Medication button
            viewPatientMedication.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the getAllDoctorSchedulesByDoctorID method
                    getAllMedications();

                }
            });

            //Export Report button
            exportReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the exportReportFile() method
                    exportReport();
                }
            });

            //view All Patient Appointment History button
            viewAllPatientAppointmentHistory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling getAllPatientAppointmentsByPatientID()
                    getAllPatientAppointmentsByPatientID();

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

            //View All Doctor Schedules button
            viewAllDoctorSchedules.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the getAllDoctorSchedulesByDoctorID method
                    getAllDoctorSchedulesByDoctorID();

                }
            });

            //View All Appointments Schedules button
            viewAllDoctorAppointments.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the getAllDoctorSchedulesByDoctorID method
                    getAllDoctorAppointmentsByDoctorID();

                }
            });

            //View All Appointments By Status button
            viewAppointmentsByStatus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the searchAppointmentByStatus method
                    searchAppointmentByStatus();

                }
            });

            //View All Appointments By Status button
            viewAppointmentsByStatus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Calling the searchAppointmentByStatus method
                    searchAppointmentByStatus();

                }
            });

        }

    }

    /**
     * Default Constructor
     */
    public ReportingUI() {

    }

    /**
     *
     */
    public void buildReportingGUI() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporting");
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        //This Panel will contain data input about the Patient in a grid with 15 rows and 2 columns based on fields
        JPanel appointmentSchedulePanel = new JPanel(new GridLayout(3, 2));

        appointmentSchedulePanel.add(new JLabel("Data Access Reports"));
        appointmentSchedulePanel.add(new JLabel(" "));
        appointmentSchedulePanel.add(new JLabel(" "));

        //This Panel will contain form control buttons
        JPanel appointmentScheduleFormControlPanel = new JPanel(new FlowLayout());
        appointmentScheduleFormControlPanel.add(viewAllDoctorSchedules = new JButton("View All Doctor Schedules"));
        appointmentScheduleFormControlPanel.add(viewAllDoctorAppointments = new JButton("View All Doctor Appointments"));
        appointmentScheduleFormControlPanel.add(viewAllPatientAppointmentHistory = new JButton("View All Patient Appointment History by ID"));
        appointmentScheduleFormControlPanel.add(viewPatientMedication = new JButton("View Patient Prescribed Medications"));
        appointmentScheduleFormControlPanel.add(viewAppointmentsByStatus = new JButton("View Appointment by Status"));
        appointmentScheduleFormControlPanel.add(exportReport = new JButton("Export Report"));
        appointmentScheduleFormControlPanel.add(exitButton = new JButton("Exit"));

        JPanel JTablePanel = new JPanel(new GridLayout(1, 1));

        tblReport = new JTable(model);
        JScrollPane tableContainer = new JScrollPane(tblReport);

        JTablePanel.add(tableContainer, BorderLayout.CENTER);
        tblReport.setPreferredScrollableViewportSize(new Dimension());
        tblReport.setFillsViewportHeight(true);

        //add panels to frame
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(appointmentSchedulePanel, BorderLayout.CENTER);
        panel.add(JTablePanel, BorderLayout.CENTER);
        panel.add(appointmentScheduleFormControlPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

    }

    public void getAllDoctorSchedulesByDoctorID() {

        //Showing an input Dialogue for the user to submit search entry
        String view_ID = JOptionPane.showInputDialog(null, "Please Submit Doctor ID as Search Criteria");

        // Declaring a seachDoctorScheduleVector of type Vector to access the SearchDoctorSchedule from the Application Logic Class with the DoctorID as parametre
        Vector<DoctorSchedule> seachDoctorScheduleVector = aLogic.seachDoctorScheduleVector(view_ID);

        if (seachDoctorScheduleVector.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Appointments found with status: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        } else {

            //load JTable tblReport
            DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
            dtm.setRowCount(0);
            dtm.setColumnCount(tableHeader.length);

            JTableHeader header = tblReport.getTableHeader();
            header.setBackground(Color.lightGray);

            for (int i = 0; i < seachDoctorScheduleVector.size(); i++) {

dtm.addRow(new Object[]{seachDoctorScheduleVector.get(i).getAvailableAppointmentDate(), seachDoctorScheduleVector.get(i).getAvailableAppointmentTimeSlot(), seachDoctorScheduleVector.get(i).getAppointmentAvailability()});

            }
            //Setting the focus on first Row.
            tblReport.changeSelection(0, 0, false, false);
        }
    }

    public void getAllDoctorSchedulesByDoctorID(String view_ID) {

        // Declaring a searchDoctorScheduleVector of type Vector to access the SearchDoctorSchedule from the Application Logic Class with the DoctorID as parametre
        Vector<DoctorSchedule> seachDoctorScheduleVector = aLogic.seachDoctorScheduleVector(view_ID);

        if (seachDoctorScheduleVector.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Appointments found with status: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        } else {

            //load JTable tblReport
            DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
            dtm.setRowCount(0);
            dtm.setColumnCount(tableHeader.length);

            JTableHeader header = tblReport.getTableHeader();
            header.setBackground(Color.lightGray);

            for (int i = 0; i < seachDoctorScheduleVector.size(); i++) {

                dtm.addRow(new Object[]{seachDoctorScheduleVector.get(i).getAvailableAppointmentDate(), seachDoctorScheduleVector.get(i).getAvailableAppointmentTimeSlot(), seachDoctorScheduleVector.get(i).getAppointmentAvailability()});

            }
            //Setting the focus on first Row.
            tblReport.changeSelection(0, 0, false, false);
        }
    }

    public void getAllDoctorAppointmentsByDoctorID() {

        //Showing an input Dialogue for the user to submit search entry
        String view_ID = JOptionPane.showInputDialog(null, "Please Submit Doctor ID as Search Criteria");

        // Declaring a appointmentVector of type Vector to access the searchDoctorAppointmentVector from the Application Logic Class with the DoctorID as parametre
        Vector<Appointment> appointmentVector = aLogic.seachDoctorAppointmentsVector(view_ID);

        if (appointmentVector.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Appointments found with status: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        } else {

            String[] tableHeaderAppointments = {"Appointment ID", "Date", "Time Slot", "Status", "Patient ID", "Patient Symptomps", "Patient Medications"};

            model = new DefaultTableModel(data, tableHeaderAppointments);
            model.fireTableStructureChanged();
            model.fireTableDataChanged();

            //load JTable tblReport
            DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
            dtm.setDataVector(data, tableHeaderAppointments);

            //model = new DefaultTableModel(data, tableHeaderAppointments);
            JTableHeader header = tblReport.getTableHeader();
            header.setBackground(Color.lightGray);

            for (int i = 0; i < appointmentVector.size(); i++) {

                dtm.addRow(new Object[]{appointmentVector.get(i).getAppointment_AppointmentID(), appointmentVector.get(i).getAppointmentDate(), appointmentVector.get(i).getAppointment_TimeSlot(), appointmentVector.get(i).getAppointment_AttendanceStatus(), appointmentVector.get(i).getAppointment_PatientID(), appointmentVector.get(i).getAppointment_PatientSymptoms(), appointmentVector.get(i).getAppointment_DoctorMedications()});

            }

            dtm.fireTableDataChanged();
            dtm.fireTableStructureChanged();

            //Setting the focus on first Row.
            tblReport.changeSelection(0, 0, false, false);
        }
    }

    public void getAllDoctorAppointmentsByDoctorID(String view_ID) {

        // Declaring a appointmentVector of type Vector to access the searchDoctorAppointmentVector from the Application Logic Class with the DoctorID as parametre
        Vector<Appointment> appointmentVector = aLogic.seachDoctorAppointmentsVector(view_ID);

        if (appointmentVector.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Appointments found with status: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        } else {

            String[] tableHeaderAppointments = {"Appointment ID", "Date", "Time Slot", "Status", "Patient ID", "Patient Symptomps", "Patient Medications"};

            model = new DefaultTableModel(data, tableHeaderAppointments);
            model.fireTableStructureChanged();
            model.fireTableDataChanged();

            //load JTable tblReport
            DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
            dtm.setDataVector(data, tableHeaderAppointments);

            //model = new DefaultTableModel(data, tableHeaderAppointments);
            JTableHeader header = tblReport.getTableHeader();
            header.setBackground(Color.lightGray);

            for (int i = 0; i < appointmentVector.size(); i++) {

                dtm.addRow(new Object[]{appointmentVector.get(i).getAppointment_AppointmentID(), appointmentVector.get(i).getAppointmentDate(), appointmentVector.get(i).getAppointment_TimeSlot(), appointmentVector.get(i).getAppointment_AttendanceStatus(), appointmentVector.get(i).getAppointment_PatientID(), appointmentVector.get(i).getAppointment_PatientSymptoms(), appointmentVector.get(i).getAppointment_DoctorMedications()});

            }

            dtm.fireTableDataChanged();
            dtm.fireTableStructureChanged();

            //Setting the focus on first Row.
            tblReport.changeSelection(0, 0, false, false);
        }
    }

    public void searchAppointmentByStatus() {

        boolean quit = false;

        while (quit == false) {

            // show searchByMenu and read the option
            String searchByMenu = "1. Attended \n2. Pending \n3. Cancel \n4. No Show \n5. Exit";
            String choice = JOptionPane.showInputDialog(null, searchByMenu, "APPOINTNEMT - SEARCH BY STATUS:",
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
                            viewAppointmentsByStatus("Attended");
                            quit = true;
                            break;

                        case 2:

                            viewAppointmentsByStatus("Pending");
                            quit = true;
                            break;

                        case 3:

                            viewAppointmentsByStatus("Cancel");
                            quit = true;
                            break;

                        case 4:

                            viewAppointmentsByStatus("No Show");
                            quit = true;
                            break;

                        case 5:

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

    public void viewAppointmentsByStatus(String status) {

        //Showing an input Dialogue for the user to submit search entry
        String view_ID = status;

        // Declaring a seachDoctorScheduleVector of type Vector to access the SearchDoctorSchedule from the Application Logic Class with the DoctorID as parametre
        Vector<Appointment> appointmentVector = aLogic.getAllAppointmentsByStatus(view_ID);

        if (appointmentVector.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Appointments found with status: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        } else {

            String[] tableHeaderAppointments = {"Appointment ID", "Date", "Time Slot", "Status", "Patient ID", "Patient Symptomps", "Patient Medications"};

            model = new DefaultTableModel(data, tableHeaderAppointments);
            model.fireTableStructureChanged();
            model.fireTableDataChanged();

            //load JTable tblReport
            DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
            dtm.setDataVector(data, tableHeaderAppointments);

            //model = new DefaultTableModel(data, tableHeaderAppointments);
            JTableHeader header = tblReport.getTableHeader();
            header.setBackground(Color.lightGray);

            for (int i = 0; i < appointmentVector.size(); i++) {

                dtm.addRow(new Object[]{appointmentVector.get(i).getAppointment_AppointmentID(), appointmentVector.get(i).getAppointmentDate(), appointmentVector.get(i).getAppointment_TimeSlot(), appointmentVector.get(i).getAppointment_AttendanceStatus(), appointmentVector.get(i).getAppointment_PatientID(), appointmentVector.get(i).getAppointment_PatientSymptoms(), appointmentVector.get(i).getAppointment_DoctorMedications()});

            }

            dtm.fireTableDataChanged();
            dtm.fireTableStructureChanged();

            //Setting the focus on first Row.
            tblReport.changeSelection(0, 0, false, false);
        }
    }

    public void getAllPatientAppointmentsByPatientID(String view_ID) {

        //Showing an input Dialogue for the user to submit search entry
        //String view_ID = JOptionPane.showInputDialog(null, "Please Submit Patient ID as Search Criteria");
        // Declaring a seachDoctorScheduleVector of type Vector to access the SearchDoctorSchedule from the Application Logic Class with the PatientID as parametre
        Vector<Appointment> appointmentVector = aLogic.seachPatientAppointmentsVector(view_ID);

        if (appointmentVector.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Patients found with ID: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        } else {

            String[] tableHeaderAppointments = {"Appointment ID", "Date", "Time Slot", "Status", "Patient ID", "Patient Symptomps"};

            model = new DefaultTableModel(data, tableHeaderAppointments);
            model.fireTableStructureChanged();
            model.fireTableDataChanged();

            //load JTable tblReport
            DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
            dtm.setDataVector(data, tableHeaderAppointments);

            //model = new DefaultTableModel(data, tableHeaderAppointments);
            JTableHeader header = tblReport.getTableHeader();
            header.setBackground(Color.lightGray);

            for (int i = 0; i < appointmentVector.size(); i++) {

                dtm.addRow(new Object[]{appointmentVector.get(i).getAppointment_AppointmentID(), appointmentVector.get(i).getAppointmentDate(), appointmentVector.get(i).getAppointment_TimeSlot(), appointmentVector.get(i).getAppointment_AttendanceStatus(), appointmentVector.get(i).getAppointment_PatientID(), appointmentVector.get(i).getAppointment_PatientSymptoms()});

            }

            dtm.fireTableDataChanged();
            dtm.fireTableStructureChanged();

            //Setting the focus on first Row.
            tblReport.changeSelection(0, 0, false, false);
        }
    }

    public void getAllPatientAppointmentsByPatientID() {

        //Showing an input Dialogue for the user to submit search entry
        String view_ID = JOptionPane.showInputDialog(null, "Please Submit Patient ID as Search Criteria");

        // Declaring a seachDoctorScheduleVector of type Vector to access the SearchDoctorSchedule from the Application Logic Class with the PatientID as parametre
        Vector<Appointment> appointmentVector = aLogic.seachPatientAppointmentsVector(view_ID);

        if (appointmentVector.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Patients found with ID: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        } else {

            String[] tableHeaderAppointments = {"Appointment ID", "Date", "Time Slot", "Status", "Patient ID", "Patient Symptomps"};

            model = new DefaultTableModel(data, tableHeaderAppointments);
            model.fireTableStructureChanged();
            model.fireTableDataChanged();

            //load JTable tblReport
            DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
            dtm.setDataVector(data, tableHeaderAppointments);

            //model = new DefaultTableModel(data, tableHeaderAppointments);
            JTableHeader header = tblReport.getTableHeader();
            header.setBackground(Color.lightGray);

            for (int i = 0; i < appointmentVector.size(); i++) {

                dtm.addRow(new Object[]{appointmentVector.get(i).getAppointment_AppointmentID(), appointmentVector.get(i).getAppointmentDate(), appointmentVector.get(i).getAppointment_TimeSlot(), appointmentVector.get(i).getAppointment_AttendanceStatus(), appointmentVector.get(i).getAppointment_PatientID(), appointmentVector.get(i).getAppointment_PatientSymptoms()});

            }

            dtm.fireTableDataChanged();
            dtm.fireTableStructureChanged();

            //Setting the focus on first Row.
            tblReport.changeSelection(0, 0, false, false);
        }
    }

    public void getAllMedications() {

        //Showing an input Dialogue for the user to submit search entry
        String view_ID = JOptionPane.showInputDialog(null, "Please Submit Patient ID as Search Criteria");

        // Declaring a appointmentVector of type Vector to access the searchPatientAppointmentsVector from the Application Logic Class with the PatientID as parametre
        Vector<Appointment> appointmentVector = aLogic.seachPatientAppointmentsVector(view_ID);

        if (appointmentVector.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Patients found with ID: " + view_ID, "Search", JOptionPane.WARNING_MESSAGE);

        } else {

            String[] tableHeaderAppointments = {"Appointment ID", "Date", "Status", "Patient Symptomps", "Prescribed Medications"};

            model = new DefaultTableModel(data, tableHeaderAppointments);
            model.fireTableStructureChanged();
            model.fireTableDataChanged();

            //load JTable tblReport
            DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
            dtm.setDataVector(data, tableHeaderAppointments);

            //model = new DefaultTableModel(data, tableHeaderAppointments);
            JTableHeader header = tblReport.getTableHeader();
            header.setBackground(Color.lightGray);

            for (int i = 0; i < appointmentVector.size(); i++) {

                dtm.addRow(new Object[]{appointmentVector.get(i).getAppointment_AppointmentID(), appointmentVector.get(i).getAppointmentDate(), appointmentVector.get(i).getAppointment_AttendanceStatus(), appointmentVector.get(i).getAppointment_PatientSymptoms(), appointmentVector.get(i).getAppointment_DoctorMedications()});

            }

            dtm.fireTableDataChanged();
            dtm.fireTableStructureChanged();

            //Setting the focus on first Row.
            tblReport.changeSelection(0, 0, false, false);

        }
    }

    /*
    * The method will export all the records found in the JTable tblReport into Text File
     */
    public void exportReport() {

        //Try Catch Method
        try {
            //the exportReportFile path
            File exportReportFile = new File("Report.txt");

            //Checking if the exportReportFile does not exist
            if (!exportReportFile.exists()) {

                //File Does Not Exisist and will be created
                exportReportFile.createNewFile();
            }

            //Declaration of the File Writer and Buffered Writer to write to Text File
            try (FileWriter fw = new FileWriter(exportReportFile.getAbsoluteFile()); BufferedWriter bw = new BufferedWriter(fw)) {

                //looping the tblReport  rows
                for (int i = 0; i < tblReport.getRowCount(); i++) {

                    //looping the tblReport  Columns
                    for (int j = 0; j < tblReport.getColumnCount(); j++) {

                        //Writing the Column Name Header : 
                        bw.write("\r\n" + tblReport.getModel().getColumnName(j) + ": \r");

                        //Writing the Values of the row based on the For Loop Iteration
                        bw.write(tblReport.getModel().getValueAt(i, j) + " ");

                    }

                    //Writing -------------------- to seperate records
                    bw.write("\r\n ____________________________________ \r\n");
                }
                //closing the BufferedWriter and buffered Writer within for loop

            }//End Try

            //Showing a message to the user that the Report has been Exported
            JOptionPane.showMessageDialog(null, "Report Exported", "Report Export", JOptionPane.INFORMATION_MESSAGE);

        } catch (HeadlessException | IOException ex) {

            //Showing a message to the user that the Report was not Exported
            JOptionPane.showMessageDialog(null, "Problem encountered whilst Exporting the Report. Error: " + ex.toString(), "Report Export Failure", JOptionPane.WARNING_MESSAGE);

        }
    }
}
