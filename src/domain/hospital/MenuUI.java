/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.hospital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author Tamar
 */
public class MenuUI extends JFrame {

    String param, userType;
    
    PatientUI patientUserInterface = new PatientUI();
    StaffUI staffUserInterface = new StaffUI();
    DoctorScheduleUI doctorSchedulerInterface = new DoctorScheduleUI();
    AppointmentUI appointmentInterface = new AppointmentUI();
    AppointmentMaintenanceUI appointmentMaintenanceInterface;
    ReportingUI reportingInterface;
    MedicinePrescriptionUI medicineInterface = new MedicinePrescriptionUI();
    

    //Default Constructor
    public MenuUI() {
        this.reportingInterface = new ReportingUI();
        this.appointmentMaintenanceInterface = new AppointmentMaintenanceUI();

        //Calling the builtMainMenuGUI() Method    
    }

    //Constructor Overload
    public MenuUI(String param, String userType) {
        this.reportingInterface = new ReportingUI(param, userType);
        this.appointmentMaintenanceInterface = new AppointmentMaintenanceUI(param, userType);

        //Checking if userType is equal to Patient
        if (userType.equals("Patient")) {

            //Getting Patient Details
            Patient patientData = ApplicationLogic.GetPatientData(param);

            //Assigning the string Variable loginUser with Patient Name and Surname
            String loginUser = patientData.getName() + " " + patientData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital Application " + loginUser + " - " + userType);

            //Calling the GUI method for Patient
            builtMainMenuGUI_Patient();

              
        }
        
        //Checking if userType is equal to Doctor
        else if (userType.equals("Doctor")) {

            //Getting doctor's Details
            Doctor doctorData = ApplicationLogic.GetDoctorData(param);

            //Assigning the string Variable loginUser with Doctor's Name and Surname
            String loginUser = doctorData.getName() + " " + doctorData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital Application " + loginUser + " - " + userType);

            //Calling the GUI method for Doctor
            builtMainMenuGUI_Doctor();

        }

        //Checking if userType is equal to Secretary
        //Secretary is also considered to be the system admin
        else if (userType.equals("Secretary")) {

            //Getting Receptionist Staff Details
            Staff staffData = ApplicationLogic.GetStaffData(param);

            //Assigning the string Variable loginUser with Receptionist's Name and Surname
            String loginUser = staffData.getName() + " " + staffData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital " + loginUser + " - " + userType);

            //Calling the FULL GUI method 
            builtMainMenuGUI();

        }
        
        //Checking if userType is equal to Pharmacist
        else if (userType.equals("Pharmacist")) {

            //Getting Receptionist Staff Details
            Staff staffData = ApplicationLogic.GetStaffData(param);

            //Assigning the string Variable loginUser with Receptionist's Name and Surname
            String loginUser = staffData.getName() + " " + staffData.getSurname();

            //Setting up the Window Title
            setTitle("Domain Hospital " + loginUser + " - " + userType);

            //Calling the FULL GUI method 
            builtMainMenuGUI_Pharmacist();

        }
        
    }

    private void builtMainMenuGUI() {

        setSize(500, 500);

        //center on screen
        setLocationRelativeTo(null);

        // Creates a menu bar for a JFrame
        JMenuBar menuBar = new JMenuBar();

        // Add the menubar to the frame
        setJMenuBar(menuBar);

        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu doctorSchedule = new JMenu("Doctor Scheduler");
        JMenu reporting = new JMenu("Reports");
        JMenu medicine = new JMenu("Medicine");
        JMenu aboutMenu = new JMenu("About");
        
        menuBar.add(fileMenu);
        menuBar.add(doctorSchedule);
        menuBar.add(aboutMenu);
        menuBar.add(reporting);
        menuBar.add(medicine);

        // Create and add menu item to one of the drop down menu
        JMenu newAction = new JMenu("New");

        JMenuItem newPatient = new JMenuItem("Patient");
        JMenuItem newStaff = new JMenuItem("Staff");
        JMenuItem newAppointment = new JMenuItem("Appointment");
        newAction.add(newPatient);
        newAction.add(newStaff);
        newAction.add(newAppointment);

        JMenu viewAction = new JMenu("View");

        JMenuItem viewAppointmentMaintenance = new JMenuItem("Appointment Maintenance");
        viewAction.add(viewAppointmentMaintenance);

        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem aboutAction = new JMenuItem("About");
        JMenuItem scheduler = new JMenuItem("Scheduler");
        JMenuItem prescriptionMedicine = new JMenuItem("Medicine Prescription");
        JMenuItem report = new JMenuItem("Reporting");

        fileMenu.add(newAction);
        fileMenu.add(viewAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        aboutMenu.add(aboutAction);
        doctorSchedule.add(scheduler);
        reporting.add(report);
        medicine.add(prescriptionMedicine);

        //exit menu item - exit Application
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // about menu item
        aboutAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Domain Hospital Application - Advanced Programming in Java - HND 2 ",
                        "About", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        //new Patient menuitem
        newPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the PatientUI form
                patientUserInterface.setVisible(true);
            }
        });

        //new Staff menuitem
        newStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the StaffUI form
                staffUserInterface.setVisible(true);
            }
        });

        //scheduler menuitem
        scheduler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the DoctorScheduleUI form
                doctorSchedulerInterface.setVisible(true);
            }
        });

        //Appointment menuitem
        newAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the AppointmentUI form
                appointmentInterface.setVisible(true);
            }
        });

        //Appointment Maintenance
        //Appointment menuitem
        viewAppointmentMaintenance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the AppointmentMaintenanceUI form
                appointmentMaintenanceInterface.setVisible(true);
            }
        });

        //Reporting Menu Item
        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the Reporting UI form
                reportingInterface.setVisible(true);
            }
        });
        
        //Reporting Menu Item
        prescriptionMedicine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the Reporting UI form
                medicineInterface.setVisible(true);
            }
        });
    

    }

    private void builtMainMenuGUI_Patient() {

        // setTitle("Domain Hospital Application");
        setSize(500, 500);

        //center on screen
        setLocationRelativeTo(null);

        // Creates a menu bar for a JFrame
        JMenuBar menuBar = new JMenuBar();

        // Add the menubar to the frame
        setJMenuBar(menuBar);

        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu doctorSchedule = new JMenu("Doctor Scheduler");
        JMenu reporting = new JMenu("Reports");
        JMenu aboutMenu = new JMenu("About");
        
        menuBar.add(fileMenu);
        menuBar.add(doctorSchedule);
        menuBar.add(aboutMenu);
        menuBar.add(reporting);


        doctorSchedule.setEnabled(false);
        // Create and add menu item to one of the drop down menu
        JMenu newAction = new JMenu("New");

        JMenuItem newPatient = new JMenuItem("Patient");
        JMenuItem newStaff = new JMenuItem("Staff");
        JMenuItem newAppointment = new JMenuItem("Appointment");
        newAction.add(newPatient);
        newAction.add(newStaff);
        newAction.add(newAppointment);

        newPatient.setEnabled(false);
        newStaff.setEnabled(false);
        newAppointment.setEnabled(false);

        JMenu viewAction = new JMenu("View");

        JMenuItem viewAppointmentMaintenance = new JMenuItem("Appointment Maintenance");
        viewAction.add(viewAppointmentMaintenance);

        viewAppointmentMaintenance.setEnabled(false);

        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem aboutAction = new JMenuItem("About");
        JMenuItem scheduler = new JMenuItem("Scheduler");
        JMenuItem report = new JMenuItem("Reporting");

        scheduler.setEnabled(false);

        fileMenu.add(newAction);
        fileMenu.add(viewAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        aboutMenu.add(aboutAction);
        doctorSchedule.add(scheduler);
        reporting.add(report);

        //exit menu item - exit Application
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // about menu item
        aboutAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Domain Hospital Application - Software Engineering Course Work 2",
                        "About", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        //new Patient menuitem
        newPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the PatientUI form
                patientUserInterface.setVisible(true);
            }
        });

        //new Staff menuitem
        newStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the StaffUI form
                staffUserInterface.setVisible(true);
            }
        });

        //scheduler menuitem
        scheduler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the DoctorScheduleUI form
                doctorSchedulerInterface.setVisible(true);
            }
        });

        //Appointment menuitem
        newAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the AppointmentUI form
                appointmentInterface.setVisible(true);
            }
        });

        //Appointment Maintenance
        //Appointment menuitem
        viewAppointmentMaintenance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the AppointmentMaintenanceUI form
                appointmentMaintenanceInterface.setVisible(true);
            }
        });

        //Reporting Menu Item
        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the Reporting UI form
                reportingInterface.setVisible(true);
            }
        });
        


    }
    
    private void builtMainMenuGUI_Pharmacist() {

        // setTitle("Domain Hospital Application");
        setSize(500, 500);

        //center on screen
        setLocationRelativeTo(null);

        // Creates a menu bar for a JFrame
        JMenuBar menuBar = new JMenuBar();

        // Add the menubar to the frame
        setJMenuBar(menuBar);

        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu doctorSchedule = new JMenu("Doctor Scheduler");
        JMenu reporting = new JMenu("Reports");
        JMenu aboutMenu = new JMenu("About");
        
        menuBar.add(fileMenu);
        menuBar.add(doctorSchedule);
        menuBar.add(aboutMenu);
        menuBar.add(reporting);


        doctorSchedule.setEnabled(false);
        // Create and add menu item to one of the drop down menu
        JMenu newAction = new JMenu("New");

        JMenuItem newPatient = new JMenuItem("Patient");
        JMenuItem newStaff = new JMenuItem("Staff");
        JMenuItem newAppointment = new JMenuItem("Appointment");
        newAction.add(newPatient);
        newAction.add(newStaff);
        newAction.add(newAppointment);

        newPatient.setEnabled(false);
        newStaff.setEnabled(false);
        newAppointment.setEnabled(false);

        JMenu viewAction = new JMenu("View");

        JMenuItem viewAppointmentMaintenance = new JMenuItem("Appointment Maintenance");
        viewAction.add(viewAppointmentMaintenance);

        viewAppointmentMaintenance.setEnabled(false);

        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem aboutAction = new JMenuItem("About");
        JMenuItem scheduler = new JMenuItem("Scheduler");
        JMenuItem report = new JMenuItem("Reporting");

        scheduler.setEnabled(false);

        fileMenu.add(newAction);
        fileMenu.add(viewAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        aboutMenu.add(aboutAction);
        doctorSchedule.add(scheduler);
        reporting.add(report);

        //exit menu item - exit Application
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // about menu item
        aboutAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Domain Hospital Application - Software Engineering Course Work 2",
                        "About", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        //new Patient menuitem
        newPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the PatientUI form
                patientUserInterface.setVisible(true);
            }
        });

        //new Staff menuitem
        newStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the StaffUI form
                staffUserInterface.setVisible(true);
            }
        });

        //scheduler menuitem
        scheduler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the DoctorScheduleUI form
                doctorSchedulerInterface.setVisible(true);
            }
        });

        //Appointment menuitem
        newAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the AppointmentUI form
                appointmentInterface.setVisible(true);
            }
        });

        //Appointment Maintenance
        //Appointment menuitem
        viewAppointmentMaintenance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the AppointmentMaintenanceUI form
                appointmentMaintenanceInterface.setVisible(true);
            }
        });

        //Reporting Menu Item
        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the Reporting UI form
                reportingInterface.setVisible(true);
            }
        });
        


    }

    private void builtMainMenuGUI_Doctor() {

        setSize(500, 500);

        //center on screen
        setLocationRelativeTo(null);

        // Creates a menu bar for a JFrame
        JMenuBar menuBar = new JMenuBar();

        // Add the menubar to the frame
        setJMenuBar(menuBar);

        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu doctorSchedule = new JMenu("Doctor Scheduler");
        JMenu reporting = new JMenu("Reports");
        JMenu aboutMenu = new JMenu("About");
        
        menuBar.add(fileMenu);
        menuBar.add(doctorSchedule);
        menuBar.add(aboutMenu);
        menuBar.add(reporting);

        doctorSchedule.setEnabled(false);
        // Create and add menu item to one of the drop down menu
        JMenu newAction = new JMenu("New");

        JMenuItem newPatient = new JMenuItem("Patient");
        JMenuItem newStaff = new JMenuItem("Staff");
        JMenuItem newAppointment = new JMenuItem("Appointment");
        newAction.add(newPatient);
        newAction.add(newStaff);
        newAction.add(newAppointment);

        newPatient.setEnabled(false);
        newStaff.setEnabled(false);
        newAppointment.setEnabled(false);

        JMenu viewAction = new JMenu("View");

        JMenuItem viewAppointmentMaintenance = new JMenuItem("Appointment Maintenance");
        viewAction.add(viewAppointmentMaintenance);

        viewAppointmentMaintenance.setEnabled(true);

        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem aboutAction = new JMenuItem("About");
        JMenuItem scheduler = new JMenuItem("Scheduler");
        JMenuItem report = new JMenuItem("Reporting");

        scheduler.setEnabled(false);

        fileMenu.add(newAction);
        fileMenu.add(viewAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        aboutMenu.add(aboutAction);
        doctorSchedule.add(scheduler);
        reporting.add(report);

        //exit menu item - exit Application
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // about menu item
        aboutAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Domain Hospital Application - Software Engineering Course Work 2",
                        "About", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        //new Patient menuitem
        newPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the PatientUI form
                patientUserInterface.setVisible(true);
            }
        });

        //new Staff menuitem
        newStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the StaffUI form
                staffUserInterface.setVisible(true);
            }
        });

        //scheduler menuitem
        scheduler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the DoctorScheduleUI form
                doctorSchedulerInterface.setVisible(true);
            }
        });

        //Appointment menuitem
        newAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the AppointmentUI form
                appointmentInterface.setVisible(true);
            }
        });

        //Appointment Maintenance
        //Appointment menuitem
        viewAppointmentMaintenance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the AppointmentMaintenanceUI form
                appointmentMaintenanceInterface.setVisible(true);
            }
        });

        //Reporting Menu Item
        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //open the Reporting UI form
                reportingInterface.setVisible(true);
            }
        });
        

    }

}
