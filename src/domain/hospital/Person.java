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
public class Person implements Serializable {
    // The Person's Name.
    private String name;
    // The Person's Surname.
    private String surname;
    // The Person's Age
    private int age;
    //The Person's Gender
    private String gender;

    // Default Constructor
    /**
     *
     */
    public Person() {

    }

    //over-ride Constructor
    /**
     * In the over-ride constructor all the parameters will be passed and for
     * any instance of the class Persons all the required parameters need to be
     * passed
     *
     * @param personName
     * @param personSurname
     * @param personAge
     * @param personGender
     *
     */
    public Person(String personName, String personSurname, int personAge, String personGender) {
        this.name = personName;
        this.surname = personSurname;
        this.age = personAge;
        this.gender = personGender;
    }

    //--------------------------Get Methods------------------------------
    //get and set methods
    /**
     * This method returns the name of the Person
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the surname of the Person
     *
     * @return String
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * This method returns the gender of the Person
     *
     * @return String
     */
    public String getGender() {
        return this.gender;
    }

    //--------------------------Set Methods------------------------------
    /**
     * This method sets the Name of the Person
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method sets the Surname of the Person
     *
     * @param surname String
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * This method sets the Age of the Person
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This method sets the Gender of the Person
     *
     * @param gender - Gender to Set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    //toString method
    @Override
    public String toString() {
        //String viewPersonalDetails contain the details of the Person
        String viewPersonalDetails = "\nName :" + this.name + "\nSurname : " + this.surname + "\nAge : " + this.age + "\nGender : " + this.gender;
        return viewPersonalDetails;
    }

}
