
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.hospital;

import java.io.Serializable;

/**
 *
 * @author Tamar
 */
public class Appointment implements Serializable{
    //declaring attributes for appointment
    String appointment_AppointmentID; 
    String appointment_patientID;
    String appointment_doctorID;
    String appointment_date;
    String appointment_timeslot;
    String appointment_patientSymptoms;
    String appointment_doctorNotes;
    String appointment_doctorMedications;
    String appointment_appointmentStatus;// Show status of the appointment, pending, done, cancelled etc
    String appointment_attendance_Status; //Show or no show
    
    //default constructor 
    
    public Appointment(){
        
    }
    /**
     * 
     * @param a_AppointmentID
     * @param a_PatientID
     * @param a_DoctorID
     * @param a_TimeSlot
     * @param a_PatientSymptoms
     * @param a_DoctorNotes
     * @param a_DoctorMedications
     * @param a_AppointmentStatus
     * @param a_AttendanceStatus
     * @param a_Date 
     */
    public Appointment(String a_AppointmentID, String a_PatientID, String a_DoctorID, String a_TimeSlot, String a_PatientSymptoms, String a_DoctorNotes, String a_DoctorMedications, String a_AppointmentStatus, String a_AttendanceStatus, String a_Date){
       this.appointment_AppointmentID = a_AppointmentID;
       this.appointment_patientID = a_PatientID;
       this.appointment_doctorID = a_DoctorID;
       this.appointment_timeslot = a_TimeSlot;
       this.appointment_patientSymptoms = a_PatientSymptoms;
       this.appointment_doctorNotes = a_DoctorNotes;
       this.appointment_doctorMedications = a_DoctorMedications;
       this.appointment_appointmentStatus = a_AppointmentStatus;
       this.appointment_attendance_Status = a_AttendanceStatus;
       this.appointment_date = a_Date;
    }
    //-------------------------------------------------------------------------------------GETTERS AND SETTERS
    /**
     * 
     * @return  String appointment_AppointmentID
     */
    public String getAppointment_AppointmentID(){
        return this.appointment_AppointmentID;
    }
    /**
     * 
     * @return String appointment_patientID
     */
    public String getAppointment_PatientID(){
        return this.appointment_patientID;
    }
    /**
     * 
     * @return String appointment_doctorID
     */
    public String getAppointment_DoctorID(){
        return this.appointment_doctorID;
    }
    /**
     * 
     * @return String appointment_timeslot;
     */
    public String getAppointment_TimeSlot(){
        return this.appointment_timeslot;
        
    }
    /**
     * 
     * @return  String appointment_patientSymptoms;

     */
    public String getAppointment_PatientSymptoms(){
        return this.appointment_patientSymptoms;
    }
    /**
     * 
     * @return String appointment_doctorNotes;
     */
    public String getAppointment_DoctorNotes(){
        return this.appointment_doctorNotes;
    }
    /**
     * 
     * @return  String appointment_doctorMedications;
     */
    public String getAppointment_DoctorMedications(){
        return this.appointment_doctorMedications;
    }
    /**
     * 
     * @return   String appointment_appointmentStatus
     */
    public String getAppointment_AppointmentStatus(){
        return this.appointment_appointmentStatus;
    }
    /**
     * 
     * @return  String appointment_attendance_Status
     */
    public String getAppointment_AttendanceStatus(){
        return this.appointment_attendance_Status;
        
    }
    /**
     * 
     * @return String appointment_Date
     */
    public String getAppointmentDate(){
        return this.appointment_date;
    }
    //--------------Set methods
    /**
     * 
     * @param app_AppointmentID 
     */

    public void setAppointment_AppointmentID(String app_AppointmentID) {
        this.appointment_AppointmentID = app_AppointmentID;
    }
/**
 * 
 * @param app_patientID 
 */
    public void setAppointment_patientID(String app_patientID) {
        this.appointment_patientID = app_patientID;
    }
/**
 * 
 * @param app_doctorID 
 */
    public void setAppointment_doctorID(String app_doctorID) {
        this.appointment_doctorID = app_doctorID;
    }
/**
 * 
 * @param app_date 
 */
    public void setAppointment_date(String app_date) {
        this.appointment_date = app_date;
    }
/**
 * 
 * @param app_timeslot 
 */
    public void setAppointment_timeslot(String app_timeslot) {
        this.appointment_timeslot = app_timeslot;
    }
/**
 * 
 * @param app_patientSymptoms 
 */
    public void setAppointment_patientSymptoms(String app_patientSymptoms) {
        this.appointment_patientSymptoms = app_patientSymptoms;
    }
/**
 * 
 * @param app_doctorNotes 
 */
    public void setAppointment_doctorNotes(String app_doctorNotes) {
        this.appointment_doctorNotes = app_doctorNotes;
    }
/**
 * 
 * @param app_doctorMedications 
 */
    public void setAppointment_doctorMedications(String app_doctorMedications) {
        this.appointment_doctorMedications = app_doctorMedications;
    }
/**
 * 
 * @param app_appointmentStatus 
 */
    public void setAppointment_appointmentStatus(String app_appointmentStatus) {
        this.appointment_appointmentStatus = app_appointmentStatus;
    }
/**
 * 
 * @param app_attendance_Status 
 */
    public void setAppointment_attendance_Status(String app_attendance_Status) {
        this.appointment_attendance_Status = app_attendance_Status;
    }
    
    
}
