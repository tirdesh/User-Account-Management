/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Gautam16
 */
public class PersonsList {
    
    private  ArrayList<Person> plist;
    
    public PersonsList(){
        this.plist = new ArrayList<Person>();
    }

    public ArrayList<Person> getPlist() {
        return plist;
    }

    public void setPlist(ArrayList<Person> plist) {
        this.plist = plist;
    }
    
    public Person addNewPerson(){
        Person pdeets = new Person();
        plist.add(pdeets);
        return pdeets;
    }
    
     /**
     * Search for a person by their NUID.
     *
     * @param nuid The NUID to search for.
     * @return The found person or null if not found.
     */
    public Person searchByNUID(String nuid) {
        for (Person person : plist) {
            if (person.getNUID().equals(nuid)) {
                return person; // Person with matching NUID found
            }
        }
        return null; // Person with matching NUID not found
    }
    
}
