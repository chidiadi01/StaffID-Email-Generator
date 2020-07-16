package com.company;
import java.util.Scanner;

/*This is a simple program written to take in a person's name and department and generate an ID and an
  email address based on the entries.

  THE ID IS GENERATED in the format 'AB123' where 'A' is the first name's initial, 'B' is the first letter of the
  last name, '1' is the job code signifying whether he's a teacher or admin staff or something of that sort,
  '2' is the department code signifying in what department the person is and '3' is the staff code, a serial
  number given to every staff and used as a unique identifier.

  THE EMAIL IS GENERATED in the order of firstname@department.schoolname.com which would be (for example)
  chidiadi@accounts.thegreatschool.com.

  My name is Chidiadi Anyanwu. Have a great time!
*/
class Staff {

    private String ID;
    private StringBuilder StaffID = new StringBuilder(" ");
    private StringBuilder email = new StringBuilder(" ");

    private String firstName = "default";
    private String lastName = "default";
    private String fullName;
    private String initials;

    private int departmentCode;
    private String job;
    private int jobCode;
    private int StaffCode;
    private static int COUNT = 0;

    String teacherDepartment;
    String adminDepartment;
    String itDepartment;
    String facilityManagementDepartment;

    String[] jobs = {"Teacher", "Administration", "IT", "FacilityManagement"};

    String[] teacherDepartments = {"Languages", "Mathematics", "Science", "Social_Sciences"};
    String[] adminDepartments = {"Accounts", "HR", "R&D"};
    String[] itDepartments = {"TMC", "Maintenance", "Network"};
    String[] facilityManagementDepartments = {"Cleaning", "HostelStaff", "Security"};

    Staff() {
        StaffCode = ++COUNT;
    }



    //JOBS

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    //This returns the code that represents your type of job in the school
    public int getjobCode() {
        for (
                int i = 0;
                i < jobs.length; i++)
            if (jobs[i] == job) {
                jobCode = i + 1;
            } else {

            }
        return jobCode;
    }


    //NAMES
    //Everything that has to do with names

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setFullName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setFullName() {
        this.fullName = firstName + " " + lastName;
        setInitials(firstName, lastName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setInitials(String firstName, String lastName) {
        this.initials = firstName.substring(0, 1).toUpperCase()
                + lastName.substring(0, 1).toUpperCase();

    }



    //DEPARTMENTS

    public void setTeacherDepartment(String teacherDepartment) {
        this.teacherDepartment = teacherDepartment;
    }
    public void setAdminDepartment(String adminDepartment) {
        this.adminDepartment = adminDepartment;
    }

    public void setItDepartment(String itDepartment) {
        this.itDepartment = itDepartment;
    }

    public void setFacilityManagementDepartment(String facilityManagementDepartment) {
        this.facilityManagementDepartment = facilityManagementDepartment;
    }

    public String getDepartment() {
        if (teacherDepartment != null){
        return teacherDepartment;
        } else if (adminDepartment != null){
            return adminDepartment;
        } else if (itDepartment != null) {
            return itDepartment;
        } else if (facilityManagementDepartment != null) {
            return  facilityManagementDepartment;
        } else{
            return null;
        }
    }

    public int getDepartmentCode() {
        for (
                int i = 0;
                i < teacherDepartments.length; i++) {
            if (teacherDepartments[i] == getDepartment()) {
                departmentCode = i + 1;
            } else {
            }
        }

        for (
                int i = 0;
                i < adminDepartments.length; i++) {
            if (adminDepartments[i] == getDepartment()) {
                departmentCode = i + 1;
            } else {
            }
        }
        for (
                int i = 0;
                i < itDepartments.length; i++) {
            if (itDepartments[i] == getDepartment()) {
                departmentCode = i + 1;
            } else {
            }
        }
        for (
                int i = 0;
                i < facilityManagementDepartments.length; i++) {
            if (facilityManagementDepartments[i] == getDepartment()) {
                departmentCode = i + 1;
            } else {
            }
        }
        return departmentCode;
    }


    //EMAIL & ID GENERATORS

    //Email Generator
    public StringBuilder getEmail() {
        email.append(getFirstName().toLowerCase());
        email.append("@");
        email.append(getDepartment().toLowerCase());
        email.append(".thegreatschool.com");
        return email;
    }

    //ID Generator
    public String getID() {

        StaffID.append(initials);
        StaffID.append(getjobCode());
        StaffID.append(getDepartmentCode());
        StaffID.append(StaffCode);
        ID = String.valueOf(StaffID);
        return ID;
    }

}


public class Main {


    public static void main(String[] args) {
        Staff newStaff = new Staff();

        Scanner entry = new Scanner(System.in);

        System.out.println("Welcome to The Great School. Please enter your first name");
        newStaff.setFirstName(entry.nextLine());

        System.out.println("Enter your last name");
        newStaff.setLastName(entry.nextLine());

        System.out.println("Enter the number that corresponds to your job: " +
                "\n1. Teaching Staff \n2. Administration \n3. IT \n4. Facility Management");
        int jobEntry = entry.nextInt();

        switch (jobEntry) {
            case 1:
                newStaff.setJob("Teacher");
                System.out.println("Enter number to select your department: " +
                        "\n1. Languages \n2. Mathematics \n3. Sciences \n4. Social Sciences");
                int deptEntry = entry.nextInt();
                switch (deptEntry) {
                    case 1:
                        newStaff.setTeacherDepartment("Languages");
                        displayTeacherInfo(newStaff);
                        break;
                    case 2:
                        newStaff.setTeacherDepartment("Mathematics");
                        displayTeacherInfo(newStaff);
                        break;
                    case 3:
                        newStaff.setTeacherDepartment("Sciences");
                        displayTeacherInfo(newStaff);
                        break;
                    case 4:
                        newStaff.setTeacherDepartment("Social_Sciences");
                        displayTeacherInfo(newStaff);
                        break;
                } break;
            case 2:
                newStaff.setJob("Administration");
                System.out.println("Enter number to select your department: " +
                        "\n1. Accounts \n2. HR Team \n3. Research & Development");
                int adminDeptEntry = entry.nextInt();
                switch (adminDeptEntry) {
                    case 1:
                        newStaff.setAdminDepartment("Accounts");
                        displayInfo(newStaff);
                        break;
                    case 2:
                        newStaff.setAdminDepartment("HR");
                        displayInfo(newStaff);
                        break;
                    case 3:
                        newStaff.setAdminDepartment("R&D");
                        displayInfo(newStaff);
                        break;
                } break;
            case 3:
                newStaff.setJob("IT");
                System.out.println("Enter number to select your department: " +
                        "\n1. Teaching Media Creation \n2. Service & Maintenance \n3. NetworkManagement");
                int itDeptEntry = entry.nextInt();
                switch (itDeptEntry) {
                    case 1:
                        newStaff.setItDepartment("TMC");
                        displayInfo(newStaff);
                        break;
                    case 2:
                        newStaff.setItDepartment("Maintenance");
                        displayInfo(newStaff);
                        break;
                    case 3:
                        newStaff.setItDepartment("Network");
                        displayInfo(newStaff);
                        break;
                }break;
            case 4:
                newStaff.setJob("FacilityManagement");
                System.out.println("Enter number to select your department: " +
                        "\n1. Cleaning & Janitorial Services \n2. Security \n3. Hostel Staff");
                int facilityManagementDeptEntry = entry.nextInt();
                switch(facilityManagementDeptEntry) {
                    case 1:
                        newStaff.setFacilityManagementDepartment("Cleaning");
                        displayInfo(newStaff);
                        break;
                    case 2:
                        newStaff.setFacilityManagementDepartment("Security");
                        displayInfo(newStaff);
                        break;
                    case 3:
                        newStaff.setFacilityManagementDepartment("Hostel");
                        displayInfo(newStaff);
                        break;
                }break;
        }




    }

    private static void displayTeacherInfo(Staff newStaff) {
        System.out.println("Welcome to The Great School. Here are your details: " +
                "\nID: " + newStaff.getID() + "\nName: " + newStaff.getFullName() + "\nJob: You " +
                "teach in the department " +
                "of " + newStaff.getDepartment() + ".\n\nYour official email is: " + newStaff.getEmail() + "" +
                "\nCongratulations, you may now proceed!");
    }

    private static void displayInfo(Staff newStaff) {
        System.out.println("Welcome to The Great School. Here are your details: "  + "\nID: " +
                newStaff.getID() + "\nName: " + newStaff.getFullName() + "\nDepartment: "
                + newStaff.getDepartment() + "\nOfficial email: " + newStaff.getEmail() + "\nCongratulations, you"
                + " may now resume duties!");
    }

}
//Your feedback is welcome
// ~ Chidiadi Anyanwu