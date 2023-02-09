

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.hospital;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tamar
 */
public class Patient extends Person implements Serializable{
  //Private Attributes   
    private String ID;
    private Date DOB;
    private String PresrciptionHistory;
    private String Allergies;
    private String SpecialRequests;

    // Default Constructor as inherited from Person Class
    /**
     *
     */
    public Patient() {
        super();
    }

    //over-ride Constructor
    /**
     * In the over-ride constructor all the parameters will be passed and for
     * any instance of the class Patient all the required parameters need to be
     * passed
     *
     * @param patientID
     * @param personName
     * @param personSurname
     * @param personAge
     * @param personGender
     * @param patientDOB
     * @param patientPrescriptionHistory
     * @param patientAllergies
     * @param patientSpecialRequests
     *
     */
    public Patient(String patientID, String personName, String personSurname, int personAge, String personGender, Date patientDOB, String patientPrescriptionHistory, String patientAllergies, String patientSpecialRequests) {
        //Parameters from Super Class Person
        super(personName, personSurname, personAge, personGender);

        this.ID = patientID;
        this.DOB = patientDOB;
        this.PresrciptionHistory = patientPrescriptionHistory;
        this.Allergies = patientAllergies;
        this.SpecialRequests = patientSpecialRequests;

    }

    //--------------------------Get Methods------------------------------
    /**
     * This method returns the ID of the Patient
     *
     * @return String
     */
    public String getPatientID() {
        return this.ID;
    }

    /**
     * This method returns the prescriptionHisotry of the Patient
     *
     * @return String
     */
    public String getPatientPrescriptionHistory() {
        return this.PresrciptionHistory;
    }

    /**
     * This method returns the Diagnosed Allergies (if Any) of the Patient
     *
     * @return String
     */
    public String getPatientAllergies() {
        return this.Allergies;
    }

    /**
     * This method returns specialRequests of the Patient
     *
     * @return String
     */
    public String getPatientSpecialRequests() {
        return this.SpecialRequests;
    }

    /**
     * This method returns Date of Birth of the Patient
     *
     * @return Date
     */
    public Date getPatientDOB() {
        return this.DOB;
    }

    //--------------------------Set Methods------------------------------ 
    /**
     * This method sets the ID of the Patient
     *
     * @param patient_ID String
     */
    public void setPatientID(String patient_ID) {
        this.ID = patient_ID;
    }

    /**
     * This method sets the PrescriptionHistory of the Patient
     *
     * @param patient_PrescriptionHistory String
     */
    public void setPatientPrescriptionHistory(String patient_PrescriptionHistory) {
        this.PresrciptionHistory = patient_PrescriptionHistory;
    }

    /**
     * This method sets the Diagnosed Allergies of the Patient
     *
     * @param patient_Allergies String
     */
    public void setPatientAllergies(String patient_Allergies) {
        this.Allergies = patient_Allergies;
    }

    /**
     * This method sets the Special Requests of the Patient
     *
     * @param patient_SpecialRequests String
     */
    public void setPatientSpecialRequests(String patient_SpecialRequests) {
        this.SpecialRequests = patient_SpecialRequests;
    }

    /**
     * This method sets the DOB of the Patient
     *
     * @param patient_DOB Date
     */
    public void setPatientDOB(Date patient_DOB) {
        this.DOB = patient_DOB;
    }

}
