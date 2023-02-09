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
public class DoctorSchedule implements Serializable {
 private String schedule_ID;
    private String schedule_doctorID;
    private String schedule_appintmentDate;
    private String schedule_appointmentTimeSlot;
    private boolean schedule_appointmentStatus;


    /**
     * Default Constructor
     */
    public DoctorSchedule() {
    }

    /**
     *
     * @param doctorSchedule_ScheduleID
     * @param doctorSchedule_doctorID
     * @param doctorSchedule_AppointmentDate
     * @param doctorSchedule_appointmentTimeSlot
     * @param doctorSchedule_scheduleStatus
     */
    public DoctorSchedule(String doctorSchedule_ScheduleID,String doctorSchedule_doctorID, String doctorSchedule_AppointmentDate, String doctorSchedule_appointmentTimeSlot, boolean doctorSchedule_scheduleStatus) {

        this.schedule_ID = doctorSchedule_ScheduleID;
        this.schedule_doctorID = doctorSchedule_doctorID;
        this.schedule_appintmentDate = doctorSchedule_AppointmentDate;
        this.schedule_appointmentTimeSlot = doctorSchedule_appointmentTimeSlot;
        this.schedule_appointmentStatus = doctorSchedule_scheduleStatus;


    }

    /**
     *
     * @param doctorSchedule_doctorID
     * @param doctorSchedule_AppointmentDate
     * @param doctorSchedule_appointmentTimeSlot
     * @param doctorSchedule_scheduleStatus
     */
    public DoctorSchedule(String doctorSchedule_doctorID, String doctorSchedule_AppointmentDate, String doctorSchedule_appointmentTimeSlot, boolean doctorSchedule_scheduleStatus) {

        this.schedule_doctorID = doctorSchedule_doctorID;
        this.schedule_appintmentDate = doctorSchedule_AppointmentDate;
        this.schedule_appointmentTimeSlot = doctorSchedule_appointmentTimeSlot;
        this.schedule_appointmentStatus = doctorSchedule_scheduleStatus;


    }
    
    
    //--------------------------Get Methods------------------------------
    //get and set methods
    
     /**
     * @return schedule_doctorID
     */
    public String getScheduleID() {
        return this.schedule_ID;
    }
    
    
    /**
     * @return schedule_doctorID
     */
    public String getDoctorID() {
        return this.schedule_doctorID;
    }

    /**
     *
     * @return appointmentDate
     */
    public String getAvailableAppointmentDate() {
        return this.schedule_appintmentDate;
    }

    /**
     *
     * @return schedule_appointmentTimeSlot
     */
    public String getAvailableAppointmentTimeSlot() {
        return this.schedule_appointmentTimeSlot;
    }

    /**
     *
     * @return schedule_appointmentStatus
     */
    public Boolean getAppointmentAvailability() {
        return this.schedule_appointmentStatus;
    }

    
    //--------------------------Set Methods------------------------------
    /**
      * This method sets the DoctorID of the Doctor
     *
     * @param doctorSchedule_ScheduleID
     */
    public void setScheduleID(String doctorSchedule_ScheduleID) {
        this.schedule_ID = doctorSchedule_ScheduleID;
    }
     
     
     /**
     * This method sets the DoctorID of the Doctor
     *
     * @param doctorSchedule_doctorID String
     */
    public void setDoctorID(String doctorSchedule_doctorID) {
        this.schedule_doctorID = doctorSchedule_doctorID;
    }

    /**
     *
     * @param doctorSchedule_AppointmentDate
     */
    public void setDoctorAppointmentDate(String doctorSchedule_AppointmentDate) {
        this.schedule_appintmentDate = doctorSchedule_AppointmentDate;
    }

    /**
     *
     * @param doctorSchedule_appointmentTimeSlot
     */
    public void setDoctorAvailableAppointmentTimeSlot(String doctorSchedule_appointmentTimeSlot) {
        this.schedule_appointmentTimeSlot = doctorSchedule_appointmentTimeSlot;
    }

    /**
     *
     * @param doctorSchedule_available
     */
    public void setDoctorAvailability(Boolean doctorSchedule_available) {
        this.schedule_appointmentStatus = doctorSchedule_available;
    }

    

    /*
    *   //Method to viewScheduleDetails of the Doctor
     */
    @Override
    public String toString() {

        String viewDoctorScheduleDetails = "\nSchedule ID :" + this.schedule_ID + "\nDoctor ID :" + this.schedule_doctorID + "\nAvailable Date: " + this.schedule_appintmentDate + "\nAvailable Time Slot : " + this.schedule_appointmentTimeSlot + "\nStatus: " + this.schedule_appointmentStatus;
        return viewDoctorScheduleDetails;
    }

}
