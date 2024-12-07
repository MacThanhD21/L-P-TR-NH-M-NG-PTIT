
package RMI;

import java.io.Serializable;

public class Employee implements Serializable{
    private static final long serialVersionUID = 20241119L;
    private String id, name;
    private double baseSalary, finalSalary;
    private int experienceYears;

    public Employee() {
    }

    public Employee(String id, String name, double baseSalary, double finalSalary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.finalSalary = finalSalary;
        this.experienceYears = experienceYears;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + ", finalSalary=" + finalSalary + ", experienceYears=" + experienceYears + '}';
    }
    
    
}
