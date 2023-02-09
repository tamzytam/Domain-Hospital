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
public class Doctor extends Staff implements Serializable{
private String Specialization;

//default constructor

    public Doctor() {
        super();
    }
/**
 * 
 * @param personName
 * @param personSurname
 * @param personAge
 * @param personGender
 * @param staffID
 * @param staffType
 * @param staffQualification
 * @param doctorSpecialization 
 */
    public Doctor(String personName, String personSurname, int personAge, String personGender, String staffID, String staffType, String staffQualification, String doctorSpecialization){
        super(personName,personSurname, personAge, personGender,staffType, staffID, staffQualification );
        
        this.Specialization = doctorSpecialization;
}
    //--------------------------------------------------------------------------GETTERS AND SETTERS
    //--------------------------------------------------------GET METHODS
    /**
     * 
     * @return String Specialization 
     */
    public String getDoctorSpecialization(){
        return this.Specialization;
    }
    //--------------------------------------------------------SET METHODS
    /**
     * 
     * @param doctorSpecialization 
     */
    public void setDoctorSpecialization(String doctorSpecialization){
        this.Specialization = doctorSpecialization;
    }
} 