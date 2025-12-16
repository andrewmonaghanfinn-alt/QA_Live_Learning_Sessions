package Labs.lab8;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Employee {

    public static void main(String[] args) {
        Manager m01 = new Manager("Bobert", "Manager");

        Employee e01 = new Employee("Jimmy", "Sales Rep");
        m01.addEmployee(e01);

        Employee e02 = new Employee("Jack", "Sales Rep");
        m01.addEmployee(e02);

        Employee e03 = new Employee("Jennifer", "Accountant");
        m01.addEmployee(e03);

        Employee e04 = new Employee("Jane", "Sales Rep");
        m01.addEmployee(e04);

        SkilledWorker e05 = new SkilledWorker("Jessica", "Consultant");
        m01.addEmployee(e05);
        e05.addSkill("Client relations");
        e05.addSkill("Yo-yoing");
        e05.addSkill("Legal compliance");

        System.out.println(m01.getInfo());

    }









    private String name;
    private String jobTitle;
    private int id;
    protected static int idCount;
    public String getName() {  return name; }
    private void setName(String name) { this.name = name; }
    public String getJobTitle() { return jobTitle; }
    private void setJobTitle(String jobTitle) { this.jobTitle = jobTitle;}
    private void setId(int id) { this.id = id; }
    public int getId() { return id;	}

    public Employee(String name, String jobTitle ) {
        setId(++Employee.idCount * 10);
        setName(name);
        setJobTitle(jobTitle);
    }
    public String getInfo() {
        String info = "\n**** *****";
        info += "Name: " + getName() + "\n";
        info += "Job Title: "+ getJobTitle() + "\n";
        info += "Employee ID: "+ getId()+ "\n";
        return info;
    }
}

class Manager extends Employee{
    private ArrayList<Employee> employees;

    Manager(String name, String jobTitle) {
        super(name, jobTitle);
        employees = new ArrayList<>();
    }
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public String getInfo() {
        StringBuilder output = new StringBuilder(super.getInfo() + "\n");
        for (Employee emp : employees) {
            output.append(emp.getInfo());
        }
        return output.toString();
    }
}

class SkilledWorker extends Employee{
    private ArrayList<String> skills;

    SkilledWorker(String name, String jobTitle) {
        super(name, jobTitle);
        skills = new ArrayList<>();
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public String getInfo() {
        String output = super.getInfo();
        output += getSkills();
        return output;
    }

    public String getSkills() {
        StringBuilder output = new StringBuilder("Skills: ");
        for (String skill : skills) {
            output.append(skill).append(" ");
        }
        return output.toString();
    }
}