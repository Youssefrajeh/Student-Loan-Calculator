/*
 * Coder: Youssef Rajeh, 
 * March, 2024
 *
 * This class represents a student OBJECT, holding details like name, address, ID, and loan amounts.
 * It includes the student's ID, full name, home address, and details on Canada and Ontario student loans.
 * The constructor sets all this information. You can read each detail with getters and change most of them with setters,
 * except the student ID. The toString method makes a student's info easy to read, listing key details in a formatted string.
 */
 
public class Student {

	    // Data members
	    private String studentID;
	    private String surname;
	    private String middleName;
	    private String firstName;
	    private String aptNumber;
	    private String streetNumber;
	    private String streetName;
	    private String city;
	    private String province;
	    private String postalCode;
	    private double cslLoanAmount;
	    private double oslLoanAmount;

	    // Constructor
	    public Student(String studentID, String surname, String middleName, String firstName, 
	                   String aptNumber, String streetNumber, String streetName, String city, 
	                   String province, String postalCode, double cslLoanAmount, double oslLoanAmount) 
	    {
	        this.studentID = studentID;
	        this.surname = surname;
	        this.middleName = middleName;
	        this.firstName = firstName;
	        this.aptNumber = aptNumber;
	        this.streetNumber = streetNumber;
	        this.streetName = streetName;
	        this.city = city;
	        this.province = province;
	        this.postalCode = postalCode;
	        this.cslLoanAmount = cslLoanAmount;
	        this.oslLoanAmount = oslLoanAmount;
	    }

	    // Getters
	    public String getStudentID()
	    { 
	    	return studentID;
	    }
	    public String getSurname() { return surname; }
	    public String getMiddleName() { return middleName; }
	    public String getFirstName() { return firstName; }
	    public String getAptNumber() { return aptNumber; }
	    public String getStreetNumber() { return streetNumber; }
	    public String getStreetName() { return streetName; }
	    public String getCity() { return city; }
	    public String getProvince() { return province; }
	    public String getPostalCode() { return postalCode; }
	    public double getCslLoanAmount() { return cslLoanAmount; }
	    public double getOslLoanAmount() { return oslLoanAmount; }

	    // Setters (No setter for studentID as per instructions)
	    public void setSurname(String surname) { this.surname = surname; }
	    public void setMiddleName(String middleName) { this.middleName = middleName; }
	    public void setFirstName(String firstName) { this.firstName = firstName; }
	    public void setAptNumber(String aptNumber) { this.aptNumber = aptNumber; }
	    public void setStreetNumber(String streetNumber) { this.streetNumber = streetNumber; }
	    public void setStreetName(String streetName) { this.streetName = streetName; }
	    public void setCity(String city) { this.city = city; }
	    public void setProvince(String province) { this.province = province; }
	    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
	    public void setCslLoanAmount(double cslLoanAmount) { this.cslLoanAmount = cslLoanAmount; }
	    public void setOslLoanAmount(double oslLoanAmount) { this.oslLoanAmount = oslLoanAmount; }

	    /*
	     * Youssef Rajeh
	     * April 2024
	     * The toString method creates a text summary of the student's information,
	     * including their full name, ID, and how much they've borrowed through CSL and OSL.
	     * It formats money amounts to show two digits after the decimal, making it clearer to read.
	     */
	    @Override
	    public String toString()
	    {
	        return String.format("Student Name: %s, %s %s\nStudent Number: %s\nCSL Amount is $%.2f\nOSL Amount is $%.2f",
	                this.surname, this.firstName, this.middleName, this.studentID, this.cslLoanAmount, this.oslLoanAmount);
	    }
	}
