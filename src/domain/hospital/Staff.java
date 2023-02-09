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
public class Staff extends Person implements Serializable {
   private String ID, Type, Qualification;

    //Default Constructor
    public Staff() {

        //Inherits Attributes from the Super Class Person    
        super();

    }

    //over-ride Constructor
    /**
     * In the over-ride constructor all the parameters will be passed and for
     * any instance of the class Staff all the required parameters need to be
     * passed
     *
     * @param staffType // Operational (Doctor) Administration (Pharmacist /
     * Receptionist)
     * @param staffID
     * @param staffQualification //To Determine whether staff is doctor,
     * pharmacist, receptionist
     *
     */
    public Staff(String personName, String personSurname, int personAge, String personGender, String staffType, String staffID, String staffQualification) {
        //Parameters from Super Class Person
        super(personName, personSurname, personAge, personGender);

        this.ID = staffID;
        this.Type = staffType;
        this.Qualification = staffQualification;

    }

    //--------------------------Get Methods------------------------------
    //get and set methods
    /**
     * This method returns the ID of the Staff
     *
     * @return String
     */
    public String getStaffID() {
        return this.ID;
    }

      /**
     * This method sets the ID of the Staff
     *
     * @param staffID String
     */
    public void setStaffID(String staffID) {
        this.ID = staffID;
    }

    /**
     * This method returns the Staff Type
     *
     * @return String
     */
    public String getStaffType() {
        return this.Type;
    }

    /**
     * This method returns the Staff Qualification
     *
     * @return String
     */
    public String getStaffQualification() {
        return this.Qualification;
    }

    //--------------------------Set Methods------------------------------
 
    /**
     * This method sets the Type of the Staff
     *
     * @param staffType String
     */
    public void setStaffType(String staffType) {
        this.Type = staffType;
    }

    /**
     * This method sets the Qualification of the Staff
     *
     * @param staffQualification String
     */
    public void setStaffQualification(String staffQualification) {
        this.Qualification = staffQualification;
    }

}
  
  