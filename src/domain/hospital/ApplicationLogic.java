/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.hospital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Tamar
 */
public final class ApplicationLogic implements Serializable{
 //declare and initialize hashmap "myPatient"
    private static Map<String, Patient> myPatient = new HashMap<String, Patient>();

    //declare and initialize hashmap "myStaff"
    private static Map<String, Staff> myStaff = new HashMap<String, Staff>();

    //declare and initialize hashmap "myDoctor"
    private static Map<String, Doctor> myDoctor = new HashMap<String, Doctor>();

    //declare and initialize vector "myAppointmentVector"
    public static Vector myAppointmentVector = new Vector();

    //declare and initialize vector "myDoctorScheduleVector"
    public static Vector myDoctorScheduleVector = new Vector();
    
    //declare and initialize vector "myMedicineVector"
    public static Vector myMedicineVector = new Vector();

    //Path where the Patient file will be saved
    String patientFileName = "Patients.obj";

    //Path where the Staff file will be saved
    String staffFileName = "Staff.obj";

    //Path where the Doctor file will be saved
    String doctorFileName = "Doctors.obj";

    //Path where the DoctorScheduleVector file  will be saved
    String doctorScheduleFileNameVector = "DoctorSchedule.obj";

    //Path where the Appointments file will be saved
    String appointmentFileVector = "Appointments.obj";
    
    //Path where the DoctorScheduleVector file  will be saved
    String medicineFileVector = "Medicine.obj";

    /**
     *
     *
     * The constructor execute the function upon the opening of frame event. The
     * default constructor will load the HashMaps and Vector from the respective
     * classes
     */
    public ApplicationLogic() {

        boolean loadedPatientHashMap = loadFromDisk_Patient(patientFileName);

        if (loadedPatientHashMap == false) {
           // JOptionPane.showMessageDialog(null, "Patient Hashmap was not loaded");
            //myPatient = new HashMap<String, Patient>();
           
             addPatientRecord("1","Kurt","Ellul",30,"Male",null,"NA","NA","No Special Requests");
             addPatientRecord("2","MaryJo","Ellul",32,"Female",null,"NA","NA","No Special Requests");
             addPatientRecord("3","Dwayne","Ellul",29,"Male",null,"Peneceline Intollerant","Asthma","No Special Requests");
             addPatientRecord("4","Elisa","Ellul",3,"Female",null,"NA","Luctose Intollerant","No Special Requests");
             addPatientRecord("5","Marisa","Ellul",50,"Female",null,"NA","NA","No Special Requests");
             addPatientRecord("6","Alphonse","Ellul",54,"Male",null,"NA","NA","No Special Requests");
             addPatientRecord("7","Joseph","Borg",22,"Male",null,"NA","NA","No Special Requests");
             addPatientRecord("8","Carmen","Lautier",69,"Female",null,"NA","NA","No Special Requests");
             addPatientRecord("9","Joe","Lautier",73,"Male",null,"NA","Diabethic","No Special Requests");
             addPatientRecord("10","John","Mula",35,"Male",null,"NA","NA","No Special Requests");
        } 

        //Doctor Hashmap
        boolean loadedstaffHashMap = loadFromDisk_Staff(staffFileName);

        if (loadedstaffHashMap == false) {
           // JOptionPane.showMessageDialog(null, "Staff Hashmap was not loaded");
          //  myStaff = new HashMap<String, Staff>();
            addStaffRecord("Joanne", "Camilleri", 34, "Female", "Administration", "1", "Secretary");
            addStaffRecord("Arlette", "Farrugia", 36, "Female", "Administration", "2", "Pharmacist");
          
        }

        //Doctor Hashmap
        boolean loadedDoctorHashMap = loadFromDisk_Doctor(doctorFileName);

        if (loadedDoctorHashMap == false) {
           // JOptionPane.showMessageDialog(null, "Doctor Hashmap was not loaded");
           // myDoctor = new HashMap<String, Doctor>();
           
              addDoctorRecord("Yyve", "Muscat Barron", 50, "Male", "Operations", "3", "Doctor", "Gynecologist");
              addDoctorRecord("Stephen", "Spiteri", 42, "Male", "Operations", "4", "Doctor", "Family Doctor");
              addDoctorRecord("Patrick", "Zahra", 39, "Male", "Operations", "5", "Doctor", "Pediatrician");
              addDoctorRecord("Joseph", "Zrinzo", 54, "Male", "Operations", "6", "Doctor", "Phisiotherapist");
        }

        //DoctorSchedule Vector
        boolean loadedDoctorScheduleVector = loadFromDisk_DoctorScheduleVector(doctorScheduleFileNameVector);

        if (loadedDoctorScheduleVector == false) {
            //JOptionPane.showMessageDialog(null, "Doctor Schedule Vector was not loaded");
            //myDoctorScheduleVector = new Vector();
            
            addDoctorScheduleVector("1", "17/03/2020","09:00AM - 09:30AM",false);
            addDoctorScheduleVector("1", "17/03/2020","09:30AM - 10:00AM",true);
            addDoctorScheduleVector("1", "17/03/2020","10:00AM - 10:30AM",true);
            addDoctorScheduleVector("1", "24/04/2020","09:00AM - 09:30AM",false);
            addDoctorScheduleVector("1", "24/04/2020","09:30AM - 10:00AM",true);
            addDoctorScheduleVector("1", "24/04/2020","10:00AM - 10:30AM",true);
            addDoctorScheduleVector("1", "25/04/2020","09:00AM - 09:30AM",false);
            addDoctorScheduleVector("1", "25/04/2020","09:30AM - 10:00AM",true);
            addDoctorScheduleVector("1", "25/04/2020","10:00AM - 10:30AM",true);
            addDoctorScheduleVector("1", "25/04/2020","10:30AM - 11:00AM",true);
            addDoctorScheduleVector("1", "25/04/2020","11:00AM - 11:30AM",true);
            addDoctorScheduleVector("1", "25/04/2020","11:30AM - 12:00AM",true);
            addDoctorScheduleVector("1", "25/04/2020","12:00AM - 12:30AM",true);
            
            addDoctorScheduleVector("2", "17/03/2020","09:00AM - 09:30AM",false);
            addDoctorScheduleVector("2", "17/03/2020","09:30AM - 10:00AM",false);
            addDoctorScheduleVector("2", "17/03/2020","10:00AM - 10:30AM",false);
            addDoctorScheduleVector("2", "17/03/2020","10:30AM - 11:00AM",true);
            addDoctorScheduleVector("2", "18/03/2020","09:00AM - 09:30AM",false);
            addDoctorScheduleVector("2", "18/03/2020","09:30AM - 10:00AM",true);
            addDoctorScheduleVector("2", "18/03/2020","10:00AM - 10:30AM",true);
            addDoctorScheduleVector("2", "25/04/2020","09:00AM - 09:30AM",false);
            addDoctorScheduleVector("2", "25/04/2020","09:30AM - 10:00AM",false);
            addDoctorScheduleVector("2", "25/04/2020","10:00AM - 10:30AM",false);
            addDoctorScheduleVector("2", "25/04/2020","10:30AM - 11:00AM",false);
            addDoctorScheduleVector("2", "25/04/2020","11:00AM - 11:30AM",false);
            addDoctorScheduleVector("2", "25/04/2020","11:30AM - 12:00AM",true);
            addDoctorScheduleVector("2", "25/04/2020","12:00AM - 12:30AM",true);
            
            addDoctorScheduleVector("3", "18/03/2020","09:00AM - 09:30AM",false);
            addDoctorScheduleVector("3", "25/04/2020","09:00AM - 09:30AM",false);
            addDoctorScheduleVector("3", "25/04/2020","09:30AM - 10:00AM",true);
            addDoctorScheduleVector("3", "25/04/2020","10:00AM - 10:30AM",true);
            addDoctorScheduleVector("3", "25/04/2020","10:30AM - 11:00AM",true);
            addDoctorScheduleVector("3", "25/04/2020","11:00AM - 11:30AM",true);
            addDoctorScheduleVector("3", "25/04/2020","11:30AM - 12:00AM",true);
            addDoctorScheduleVector("3", "25/04/2020","12:00AM - 12:30AM",true);
            
        }

        //Appointment Vector 
        boolean loadedAppointmentVector = loadFromDisk_Appointments(appointmentFileVector);

        if (loadedAppointmentVector == false) {
           // JOptionPane.showMessageDialog(null, "Appointment Vector was not loaded");
           // myAppointmentVector = new Vector();
           
             addAppointmentVector("1-17/03/2020", "1", "2", "17/03/2020", "09:00AM - 09:30AM", "Fever", "Patient to remain in bed for 3 days", "Anti-Biotics (Augmentine 500MG) and Paracetamol (Panadols)", "Attended", "Finish");
             addAppointmentVector("4-17/03/2020", "4", "1", "17/03/2020", "09:00AM - 09:30AM", "Smear Test", "Test sent to Laboratory. To Schedule anothoer Appointment for coming Month", "Alfoxan 500 MG", "Attended", "Finish");
             addAppointmentVector("2-24/04/2020", "2", "1", "24/04/2020", "09:00AM - 09:30AM", "Smear Test", "", "", "Pending", "Pending");
             addAppointmentVector("2-17/03/2020", "2", "2", "17/03/2020", "10:00AM - 10:30AM", "Eye Infection", "Patient to have some rest due to infection and strain", "Eye Drops (Optrex)", "Attended", "Finish");
             addAppointmentVector("4-18/03/2020", "4", "3", "18/03/2020", "09:00AM - 09:30AM", "Check Up", "Soar Throat", "Paracetamol (Calpol)", "Attended","Finish");
             addAppointmentVector("3-17/03/2020", "3", "2", "17/03/2020", "09:30AM - 10:00AM", "Flu and Fever", "", "", "Pending", "No Show");
             addAppointmentVector("3-18/03/2020", "3", "2", "18/03/2020", "09:30AM - 10:00AM", "Flu and Fever", "Patient to remain in bed for 3 days", "Anti-Biotics (Augmentine 500MG) and Paracetamol (Panadols)", "Attended", "Finish");
             addAppointmentVector("1-25/04/2020", "1", "2", "25/04/2020", "09:00AM - 09:30AM", "Check Up", "", "", "Pending", "Pending");
             addAppointmentVector("5-26/04/2020", "5", "1", "25/04/2020", "09:00AM - 09:30AM", "Check Up", "", "", "Pending", "Pending");
             addAppointmentVector("6-27/04/2020", "6", "2", "27/04/2020", "10:00AM - 10:30AM", "Check Up", "", "", "Pending", "Pending");
             addAppointmentVector("4-28/04/2020", "4", "3", "25/04/2020", "09:00AM - 09:30AM", "Check Up", "", "", "Pending", "Pending");
             addAppointmentVector("7-25/04/2020", "7", "2", "25/04/2020", "09:30AM - 10:00AM", "Check Up", "", "", "Pending", "Pending");
             addAppointmentVector("8-25/04/2020", "8", "2", "25/04/2020", "10:00AM - 10:30AM", "Check Up", "", "", "Pending", "Pending");
             addAppointmentVector("9-25/04/2020", "9", "2", "25/04/2020", "10:30AM - 11:00AM", "Check Up", "", "", "Pending", "Pending");
             addAppointmentVector("10-25/04/2020", "10", "2", "25/04/2020", "11:00AM - 11:30AM", "Check Up", "", "", "Pending", "Pending");
        }
        
        
        //loadedMedicineVector
        boolean loadedMedicineVector = loadFromDisk_Medicine(medicineFileVector);

        if (loadedMedicineVector == false) {
            //JOptionPane.showMessageDialog(null, "Medicine Vector was not loaded");
            //myMedicineVector = new Vector();
            addMedicineVector("Panadol Advanced", "500MG", "Paracetamol tablets- Pain Killers");
            addMedicineVector("Panadol Cold and Flu", "500MG", "Paracetamol tablets- Cold Reliever and Fever Reducer");
            addMedicineVector("Calpol", "250MG", "Paracetamol Syrop- Cold Reliever and Fever Reducer for Kids");
            addMedicineVector("Augmentin", "457MG / 5ml", "Antibiotics Syrop - Kids");
            addMedicineVector("Augmentin", "875MG / 125mg", "Antibiotics tablets - Adults");
            
        }

    }

    //add Patient record to the hashmap
    public void addPatientRecord(String patientID, String patientName, String patientSurname, int patientAge,
            String patientGender, Date patientDOB, String patientPrescription, String patientAllergies,
            String patientRequest) {

        myPatient.put(patientID, new Patient(patientID, patientName, patientSurname, patientAge, patientGender,
                patientDOB, patientPrescription, patientAllergies, patientRequest));

        //Calling the saveToDisk_Patient method to save the new Patient Object in the file passed through string parametre
        saveToDisk_Patient(patientFileName);

    }

    //add Patient record to the hashmap
    public void editPatientRecord(String patientID, String patientName, String patientSurname, int patientAge,
            String patientGender, Date patientDOB, String patientPrescription, String patientAllergies,
            String patientRequest) {

        myPatient.put(patientID, new Patient(patientID, patientName, patientSurname, patientAge, patientGender,
                patientDOB, patientPrescription, patientAllergies, patientRequest));

        //Calling the saveToDisk_Patient method to save the new Patient Object in the file passed through string parametre
        saveToDisk_Patient(patientFileName);

    }

    //add Staff record to the hashmap
    public void addStaffRecord(String personName, String personSurname,
            int personAge, String personGender, String staffType, String staffID,
            String staffQualification) {

        myStaff.put(staffID, new Staff(personName, personSurname, personAge, personGender, staffType,
                staffID, staffQualification));

        //Calling the saveToDisk_Staff method to save the new Staff Object in the file passed through string parametre
        saveToDisk_Staff(staffFileName);

    }

    //edit Staff record to the hashmap
    public void editStaffRecord(String personName, String personSurname,
            int personAge, String personGender, String staffType, String staffID,
            String staffQualification) {

        myStaff.put(staffID, new Staff(personName, personSurname, personAge, personGender, staffType,
                staffID, staffQualification));

        //Calling the saveToDisk_Staff method to save the new Staff Object in the file passed through string parametre
        saveToDisk_Staff(staffFileName);

    }

    //add Doctor record to the hashmap
    public void addDoctorRecord(String personName, String personSurname,
            int personAge, String personGender, String staffType, String staffID,
            String staffQualification, String doctorSpecialisation) {

        myDoctor.put(staffID, new Doctor(personName, personSurname, personAge, personGender, staffType,
                staffID, staffQualification, doctorSpecialisation));

        //Calling the saveToDisk_Doctor method to save the new Doctor Object in 
        //the file passed through string parametre
        saveToDisk_Doctor(doctorFileName);

    }

    //edit Doctor record to the hashmap
    public void editDoctorRecord(String personName, String personSurname,
            int personAge, String personGender, String staffType, String staffID,
            String staffQualification, String doctorSpecialisation) {

        myDoctor.put(staffID, new Doctor(personName, personSurname, personAge, personGender, staffType,
                staffID, staffQualification, doctorSpecialisation));

        //Calling the saveToDisk_Doctor method to save the new Doctor Object in 
        //the file passed through string parametre
        saveToDisk_Doctor(doctorFileName);

    }

    public void addDoctorScheduleVector(String doctorschedule_doctorID, String doctorschedule_appintmentDate,
            String doctorschedule_appointmentTimeSlot, boolean doctorschedule_appointmentAvailability) {

        myDoctorScheduleVector.add(new DoctorSchedule(doctorschedule_doctorID, doctorschedule_appintmentDate,
                doctorschedule_appointmentTimeSlot, doctorschedule_appointmentAvailability));

        //Calling the saveToDisk_DoctorScheduleVector method to save the new DoctorSchedule Object in 
        //the file passed through string parametre
        saveToDisk_DoctorScheduleVector(doctorScheduleFileNameVector);

    }

    //add Appointment record to the Vector
    public void addAppointmentVector(String appointment_appointmentID, String appointment_patientID, String appointment_doctorID, String appointment_date, String appointment_timeslot, String appointment_patientSymptoms, String appointment_doctorNotes, String appointment_doctorMedications, String appointment_appointmentStatus, String appointment_attendanceStatus) {

        myAppointmentVector.add(new Appointment(appointment_appointmentID, appointment_patientID, appointment_doctorID, appointment_date, appointment_timeslot, appointment_patientSymptoms, appointment_doctorNotes, appointment_doctorMedications, appointment_appointmentStatus, appointment_attendanceStatus));

        //Calling the addAppointmentVector method to save the new Appointment Object in 
        //the file passed through string parametre
        saveToDisk_AppointmentVector(appointmentFileVector);

    }
    
    //add Medicine record to the Vector
    public void addMedicineVector(String medicine_medicineName, String medicine_medicineDosage, String medicine_medicineType) {

        myMedicineVector.add(new MedicinePrescription(medicine_medicineName, medicine_medicineDosage, medicine_medicineType));

        //Calling the addMedicineVector method to save the new Medicine Object in 
        //the file passed through string parametre
        saveToDisk_MedicineVector(medicineFileVector);

    }
    

  public void modifyDoctorScheduleVector(int record) {

        myDoctorScheduleVector.removeElementAt(record);
        //the file passed through string parametre
        saveToDisk_DoctorScheduleVector(doctorScheduleFileNameVector);

    }
    
    //method to return an object of type Patient
    public static Patient GetPatientData(String getPatientData) {

        Patient patientData = myPatient.get(getPatientData);
        return patientData;
    }

    //method to return an object of type Staff
    public static Staff GetStaffData(String getStaffData) {

        Staff staffData = myStaff.get(getStaffData);
        return staffData;
    }

    //method to return an object of type Doctor
    public static Doctor GetDoctorData(String getDoctorData) {

        Doctor doctorData = myDoctor.get(getDoctorData);
        return doctorData;
    }

    //method to check if the key name (PatientID) already exists in that hashmap
    public static boolean GetPatientID(String patientID) {
        if (myPatient.containsKey(patientID)) {
            return true;
        } else {
            return false;
        }
    }

    //method to check if the key name (StaffID) already exists in that hashmap
    public static boolean GetStaffID(String staffID) {
        if (myStaff.containsKey(staffID)) {
            return true;
        } else {
            return false;
        }
    }

    //method to check if the key name (doctorID) already exists in that hashmap
    public static boolean GetDoctorID(String doctorID) {
        if (myDoctor.containsKey(doctorID)) {
            return true;
        } else {
            return false;
        }
    }
    
    

    /**
     *
     * @return split
     */
    public static String[] listPatientName() {
        // String[] split = new String[0];
        String[] split = new String[0];
        String p = "";

        for (String key : myPatient.keySet()) {
            p = key + "\n" + p;

            split = p.split("\n");
        }

        return split;

    }

    /**
     *
     * @param Id
     * @return split
     */
    public static String[] listPatientNameByName(String Id) {
        // String[] split = new String[0];
        String[] split = new String[0];
        String p = Id;

        for (String key : myPatient.keySet()) {
            p = key + "\n" + p;

            split = p.split("\n");
        }

        return split;

    }

    //get the list of all the Staff names (key elements in the hashmap)
    public static String[] listStaffName() {
        // String[] split = new String[0];
        String[] split = new String[0];
        String p = "";

        for (String key : myStaff.keySet()) {
            p = key + "\n" + p;

            split = p.split("\n");
        }

        return split;

    }

    //get the list of all the Doctor names (key elements in the hashmap)
    public static String[] listDoctorName() {
        // String[] split = new String[0];
        String[] split = new String[0];
        String p = "";

        for (String key : myDoctor.keySet()) {
            p = key + "\n" + p;

            split = p.split("\n");
        }

        return split;

    }

    /**
     * This method saves the data into an ObjectOutputSteam. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean saveToDisk_Patient(String path) {
        //try - catch in case of error
        try {
            // input and output are always done through streams in Java.
            // This is an Object output stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)); //open stream
            out.writeObject(myPatient); //write object
            out.close(); // close stream <-- COMPULSORY or nothing will be saved!
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; //unsuccessful
        }

        return true; //successful

    }

    /**
     * This method saves the data into an ObjectOutputSteam. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean saveToDisk_Staff(String path) {
        //try - catch in case of error
        try {
            // input and output are always done through streams in Java.
            // This is an Object output stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)); //open stream
            out.writeObject(myStaff); //write object
            out.close(); // close stream <-- COMPULSORY or nothing will be saved!
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; //unsuccessful
        }

        return true; //successful

    }

    /**
     * This method saves the data into an ObjectOutputSteam. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean saveToDisk_Doctor(String path) {
        //try - catch in case of error
        try {
            // input and output are always done through streams in Java.
            // This is an Object output stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)); //open stream
            out.writeObject(myDoctor); //write object
            out.close(); // close stream <-- COMPULSORY or nothing will be saved!
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; //unsuccessful
        }

        return true; //successful

    }

    /**
     * This method saves the data into an ObjectOutputSteam. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean saveToDisk_DoctorScheduleVector(String path) {
        //try - catch in case of error
        try {
            // input and output are always done through streams in Java.
            // This is an Object output stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)); //open stream
            out.writeObject(myDoctorScheduleVector); //write object
            out.close(); // close stream <-- COMPULSORY or nothing will be saved!
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; //unsuccessful
        }

        return true; //successful

    }


    /**
     * This method saves the data into an ObjectOutputSteam. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     * @param path String
     * @return boolean
     */
    public boolean saveToDisk_AppointmentVector(String path) {
        //try - catch in case of error
        try {
            // input and output are always done through streams in Java.
            // This is an Object output stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)); //open stream
            out.writeObject(myAppointmentVector); //write object
            out.close(); // close stream <-- COMPULSORY or nothing will be saved!
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "ERROR encountered whilst Saving: " + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; //unsuccessful
        }

        return true; //successful

    }
    
    /**
     * This method saves the data into an ObjectOutputSteam. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     * @param path String
     * @return boolean
     */
    public boolean saveToDisk_MedicineVector(String path) {
        //try - catch in case of error
        try {
            // input and output are always done through streams in Java.
            // This is an Object output stream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)); //open stream
            out.writeObject(myMedicineVector); //write object
            out.close(); // close stream <-- COMPULSORY or nothing will be saved!
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "ERROR encountered whilst Saving: " + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; //unsuccessful
        }

        return true; //successful

    }

    /**
     * This method loads the data into an ObjectOInputStream. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean loadFromDisk_Patient(String path) {

        if (path != null) {

            try {
                File file = new File(path);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                myPatient = (HashMap<String, Patient>) in.readObject();
                in.close();
                return true; //this will return the hashmap loaded with the data or null
            } catch (FileNotFoundException fnfe) {
                //JOptionPane.showMessageDialog(null, "ERROR: " + fnfe.getMessage());
                return false;
            } catch (Exception e) { //any other exceptions
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                return false;
            }

        }

        return false;
    }

    /**
     * This method loads the data into an ObjectOInputStream. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean loadFromDisk_Staff(String path) {

        if (path != null) {

            try {
                File file = new File(path);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                myStaff = (HashMap<String, Staff>) in.readObject();
                in.close();
                return true; //this will return the hashmap loaded with the data or null
            } catch (FileNotFoundException fnfe) {
                //JOptionPane.showMessageDialog(null, "ERROR: " + fnfe.getMessage());
                return false;
            } catch (Exception e) { //any other exceptions
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                return false;
            }

        }

        return false;
    }

    /**
     * This method loads the data into an ObjectOInputStream. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean loadFromDisk_Doctor(String path) {

        if (path != null) {

            try {
                File file = new File(path);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                myDoctor = (HashMap<String, Doctor>) in.readObject();
                in.close();
                return true; //this will return the hashmap loaded with the data or null
            } catch (FileNotFoundException fnfe) {
                //JOptionPane.showMessageDialog(null, "ERROR: " + fnfe.getMessage());
                return false;
            } catch (IOException | ClassNotFoundException e) { //any other exceptions
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                return false;
            }

        }

        return false;
    }

    /**
     * This method loads the data into an ObjectOInputStream. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean loadFromDisk_DoctorScheduleVector(String path) {

        if (path != null) {

            try {
                File file = new File(path);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                myDoctorScheduleVector = (Vector) in.readObject();
                in.close();
                return true; //this will return the hashmap loaded with the data or null
            } catch (FileNotFoundException fnfe) {
                //JOptionPane.showMessageDialog(null, "ERROR: " + fnfe.getMessage());
                return false;
            } catch (IOException | ClassNotFoundException e) { //any other exceptions
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                return false;
            }

        }

        return false;
    }

    /**
     * This method loads the data into an ObjectOInputStream. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean loadFromDisk_Appointments(String path) {

        if (path != null) {

            try {
                File file = new File(path);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                myAppointmentVector = (Vector) in.readObject();
                in.close();
                return true; //this will return the hashmap loaded with the data or null
            } catch (FileNotFoundException fnfe) {
                //JOptionPane.showMessageDialog(null, "ERROR: " + fnfe.getMessage());
                return false;
            } catch (IOException | ClassNotFoundException e) { //any other exceptions
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                return false;
            }

        }

        return false;
    }
    
    
    /**
     * This method loads the data into an ObjectOInputStream. if the file is not
     * found, an exception occurs and a message is shown stating that the file
     * does not exist.
     *
     * @param path String
     * @return boolean
     */
    public boolean loadFromDisk_Medicine(String path) {

        if (path != null) {

            try {
                File file = new File(path);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                myMedicineVector = (Vector) in.readObject();
                in.close();
                return true; //this will return the hashmap loaded with the data or null
            } catch (FileNotFoundException fnfe) {
                //JOptionPane.showMessageDialog(null, "ERROR: " + fnfe.getMessage());
                return false;
            } catch (IOException | ClassNotFoundException e) { //any other exceptions
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                return false;
            }

        }

        return false;
    }


    public DoctorSchedule searchDoctorSchedule(String doctorID) {

        // loop through the vector of Clients.
        for (int i = 0; i < myDoctorScheduleVector.size(); i++) {

            // take a client from the vector
            DoctorSchedule ds = (DoctorSchedule) myDoctorScheduleVector.get(i);

            if (doctorID.equalsIgnoreCase(ds.getDoctorID())) {

                // found
                return ds;

            }
        } // end for

        return null;

    }

    public DoctorSchedule searchDoctorSchedule(String doctorID, String scheduleDate, String scheduleTimeslot) {

        // loop through the vector of Clients.
        for (int i = 0; i < myDoctorScheduleVector.size(); i++) {

            // take a client from the vector
            DoctorSchedule ds = (DoctorSchedule) myDoctorScheduleVector.get(i);

            if (doctorID.equalsIgnoreCase(ds.getDoctorID()) && scheduleDate.equalsIgnoreCase(ds.getAvailableAppointmentDate()) && scheduleTimeslot.equalsIgnoreCase(ds.getAvailableAppointmentTimeSlot())) {

                // found
                return ds;

            }
        } // end for

        return null;

    }

    public void searchAndDeleteDoctorSchedule(String doctorID, String scheduleDate, String scheduleTimeslot) {

        // loop through the vector of Clients.
        for (int i = 0; i < myDoctorScheduleVector.size(); i++) {

            // take a client from the vector
            DoctorSchedule ds = (DoctorSchedule) myDoctorScheduleVector.get(i);

            if (doctorID.equalsIgnoreCase(ds.getDoctorID()) && scheduleDate.equalsIgnoreCase(ds.getAvailableAppointmentDate()) && scheduleTimeslot.equalsIgnoreCase(ds.getAvailableAppointmentTimeSlot())) {

                // found
                myDoctorScheduleVector.remove(i);

            }
        } // end for

    }
    
    public void searchAndDeleteAppointment(String appID) {

        // loop through the vector of Clients.
        for (int i = 0; i < myAppointmentVector.size(); i++) {

            // take a client from the vector
            Appointment app = (Appointment) myAppointmentVector.get(i);

            if (appID.equalsIgnoreCase(app.getAppointment_AppointmentID())) {

                // found
                myAppointmentVector.remove(i);

            }
        } // end for

    }

    public Vector<DoctorSchedule> seachDoctorScheduleVector(String doctorID) {

        Vector<DoctorSchedule> v = new Vector<>();

        for (int i = 0; i < myDoctorScheduleVector.size(); i++) {

            // take a client from the vector
            DoctorSchedule ds = (DoctorSchedule) myDoctorScheduleVector.get(i);

            if (doctorID.equalsIgnoreCase(ds.getDoctorID())) {

                // found
                v.add(ds);

            }
        } // end for

        return v;

    }
    
    public Vector<Appointment> seachDoctorAppointmentsVector(String doctorID) {

        Vector<Appointment> v = new Vector<>();

        for (int i = 0; i < myAppointmentVector.size(); i++) {

            // take a appointment from the vector
            Appointment app = (Appointment) myAppointmentVector.get(i);

            if (doctorID.equalsIgnoreCase(app.getAppointment_DoctorID())) {

                // found
                v.add(app);

            }
        } // end for

        return v;

    }
    

    public Vector<DoctorSchedule> seachDoctorScheduleVectorByAvailabilityTRUE(String doctorID) {


        Vector<DoctorSchedule> v = new Vector<>();

        for (int i = 0; i < myDoctorScheduleVector.size(); i++) {

            // take a client from the vector
            DoctorSchedule ds = (DoctorSchedule) myDoctorScheduleVector.get(i);

            if (doctorID.equalsIgnoreCase(ds.getDoctorID()) && ds.getAppointmentAvailability() == true) {

                // found
                v.add(ds);

            }
        } // end for

        return v;

    }

    public Vector<DoctorSchedule> seachDoctorScheduleVectorByAvailabilityFALSE(String doctorID) {

        Vector<DoctorSchedule> v = new Vector<>();

        for (int i = 0; i < myDoctorScheduleVector.size(); i++) {

            // take a client from the vector
            DoctorSchedule ds = (DoctorSchedule) myDoctorScheduleVector.get(i);

            if (doctorID.equalsIgnoreCase(ds.getDoctorID()) && ds.getAppointmentAvailability() == false) {

                // found
                v.add(ds);

            }
        } // end for

        return v;

    }

    public Vector<DoctorSchedule> checkScheduleIfExisits(String doctorID, String scheduleDate, String scheduleTimeslot) {

        Vector<DoctorSchedule> v = new Vector<>();

        for (int i = 0; i < myDoctorScheduleVector.size(); i++) {

            // take a client from the vector
            DoctorSchedule ds = (DoctorSchedule) myDoctorScheduleVector.get(i);

            if (doctorID.equalsIgnoreCase(ds.getDoctorID()) && scheduleDate.equalsIgnoreCase(ds.getAvailableAppointmentDate()) && scheduleTimeslot.equalsIgnoreCase(ds.getAvailableAppointmentTimeSlot())) {

                // found
                v.add(ds);

            }
        } // end for

        return v;

    }

    public Vector<DoctorSchedule> deleteScheduleIfExisits(String doctorID, String scheduleDate, String scheduleTimeslot) {

        Vector<DoctorSchedule> v = new Vector<>();

        for (int i = 0; i < myDoctorScheduleVector.size(); i++) {

            // take a client from the vector
            DoctorSchedule ds = (DoctorSchedule) myDoctorScheduleVector.get(i);

            if (doctorID.equalsIgnoreCase(ds.getDoctorID()) && scheduleDate.equalsIgnoreCase(ds.getAvailableAppointmentDate()) && scheduleTimeslot.equalsIgnoreCase(ds.getAvailableAppointmentTimeSlot())) {

                modifyDoctorScheduleVector(i);
                // found
                v.add(ds);

            }
        } // end for

        return v;

    }

    public DoctorSchedule searchAllDoctorSchedule() {

        try {

            Iterator it = myDoctorScheduleVector.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }

        } catch (NoSuchElementException elementException) {

            throw elementException;

        }

        return null;

    }

    
    

    public Appointment searchAppointment(String appointmentID) {

        //Looping through the vector that contains the appointments
        for (int i = 0; i < myAppointmentVector.size(); i++) {

            Appointment app = (Appointment) myAppointmentVector.get(i);

            if (appointmentID.equalsIgnoreCase(app.getAppointment_AppointmentID())) {

                //Appointment Found and app will be returned
                return app;

            }

        }//end of for loop

        //return null    
        return null;
    }
    
    public Appointment searchAppointmentByDoctorID(String doctorID) {

        //Looping through the vector that contains the appointments
        for (int i = 0; i < myAppointmentVector.size(); i++) {

            Appointment app = (Appointment) myAppointmentVector.get(i);

            if (doctorID.equalsIgnoreCase(app.getAppointment_DoctorID())) {

                //Appointment Found and app will be returned
                return app;

            }

        }//end of for loop

        //return null    
        return null;
    }
    
     public Vector<Appointment> getAllAppointmentsByStatus(String status) {

     
        Vector<Appointment> v = new Vector<>();

        for (int i = 0; i < myAppointmentVector.size(); i++) {

            // take a appointment from the vector
            Appointment app = (Appointment) myAppointmentVector.get(i);

            if (status.equalsIgnoreCase(app.getAppointment_AppointmentStatus())) {

                // found
                v.add(app);

            }
        } // end for

        return v;

    }
     
    
      public Vector<Appointment> seachPatientAppointmentsVector(String patientID) {

     
        Vector<Appointment> v = new Vector<>();

        for (int i = 0; i < myAppointmentVector.size(); i++) {

            // take a appointment from the vector
            Appointment app = (Appointment) myAppointmentVector.get(i);

            if (patientID.equalsIgnoreCase(app.getAppointment_PatientID())) {

                // found
                v.add(app);

            }
        } // end for

        return v;

    }
   
   
   public Vector<MedicinePrescription> checkMedicineIfExisits(String medicineName, String medicineDosage, String medicineType) {

        Vector<MedicinePrescription> medicineVector = new Vector<>();

        for (int i = 0; i < myMedicineVector.size(); i++) {

            // take a medicine from the vector
            MedicinePrescription mp = (MedicinePrescription) myMedicineVector.get(i);

            if (medicineName.equalsIgnoreCase(mp.getMedicineName()) && medicineDosage.equalsIgnoreCase(mp.getMedicineDosage()) && medicineType.equalsIgnoreCase(mp.getMedicineType())) {

                // found
                medicineVector.add(mp);

            }
        } // end for

        return medicineVector;

    }
   
   public Vector<MedicinePrescription> searchAllMedicine() {

       Vector<MedicinePrescription> medicineVector = new Vector<>();
       
       for (int i = 0; i < myMedicineVector.size(); i++) {

            // take a medicine from the vector
            MedicinePrescription mp = (MedicinePrescription) myMedicineVector.get(i);
            
            medicineVector.add(mp);
        
              
    }
           return medicineVector;
   }

   
public Vector<MedicinePrescription> getAllMedicine(){


Vector<MedicinePrescription> medicinePrescriptions = new Vector<>();
for (int i = 0; i < myMedicineVector.size(); i++){

MedicinePrescription mp = (MedicinePrescription) myMedicineVector.get(i);
            
            medicinePrescriptions.add(mp);        

}
   return medicinePrescriptions;
}
}








