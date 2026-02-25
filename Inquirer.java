package edu.ucalgary.oop;

public class Inquirer {
    
    private String firstName;
    private String lastName;
    private String servicesPhoneNum;
    private String info;

    public Inquirer(String firstName, String lastName, String phone, String info) {
        this.firstName = firstName;
        
        this.lastName = lastName;
        this.servicesPhoneNum = phone;
        
        this.info = info;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    
    
    public String getServicesPhoneNum() { return servicesPhoneNum; }
    public String getInfo() { return info; }







}

