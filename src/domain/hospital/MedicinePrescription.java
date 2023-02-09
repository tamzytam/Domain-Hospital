/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.hospital;

import java.io.Serializable;

/**
 *
 * @author kellul
 */
public class MedicinePrescription implements Serializable{
    
    private String medicinePrescription_MedicineName;
    private String medicinePrescription_MedicineDosage;
    private String medicinePrescription_MedicineType;
    
    
    //Default Constructor
    public MedicinePrescription(){
    
    }
    
    public MedicinePrescription(String medicineName, String medicineDosage, String medicineType){
    
        this.medicinePrescription_MedicineName = medicineName;
        this.medicinePrescription_MedicineDosage = medicineDosage;
        this.medicinePrescription_MedicineType = medicineType;
        
    }
    
    
    //--------------------------Get Methods------------------------------
    //get and set methods
    /**
     * This method returns the name of the Medicine
     *
     * @return String
     */
    public String getMedicineName() {
        return this.medicinePrescription_MedicineName;
    }
    
    //get and set methods
    /**
     * This method returns the dosage of the Medicine
     *
     * @return String
     */
    public String getMedicineDosage() {
        return this.medicinePrescription_MedicineDosage;
    }
    
    //get and set methods
    /**
     * This method returns the type of the Medicine
     *
     * @return String
     */
    public String getMedicineType() {
        return this.medicinePrescription_MedicineType;
    }
    
    
    //--------------------------Set Methods------------------------------
    /**
     * This method sets the Name of the Medicine
     *
     * @param medicine_name
     */
    public void setMedicineName(String medicine_name) {
        this.medicinePrescription_MedicineName = medicine_name;
    }
    
    
    /**
     * This method sets the dosage of the Medicine
     *
     * @param medicine_dosage
     */
    public void setMedicineDosage(String medicine_dosage) {
        this.medicinePrescription_MedicineDosage = medicine_dosage;
    }
    
    
    /**
     * This method sets the Type of the Medicine
     *
     * @param medicine_type
     */
    public void setMedicineType(String medicine_type) {
        this.medicinePrescription_MedicineType = medicine_type;
    }
    
    
     //toString method
    @Override
    public String toString() {
        //String viewMedinceDetails contain the details of the Medicine
        String viewMedicineDetails = "\nName :" + this.medicinePrescription_MedicineName + "\nDosage : " + this.medicinePrescription_MedicineDosage + "\nType : " + this.medicinePrescription_MedicineType;
        return viewMedicineDetails;
    }
    
}
