/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN677;

import java.rmi.registry.*;
import java.util.*;
import RMI.Employee;
import RMI.ObjectService;

public class Object_Employee {
    public static void main(String[] args) throws Exception, ClassNotFoundException{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) registry.lookup("RMIObjectService");
        
        String studentCode = "B21DCCN677", qAlias = "7Ho56ws5";
        Employee employee = (Employee) sv.requestObject(studentCode, qAlias);
        System.out.println(employee);
        
        // Get attribute
        double baseSalary = employee.getBaseSalary();
        int experienceYears = employee.getExperienceYears();
        
        int sumDigit = sumDigits(experienceYears);

        int divisorCount = countDivisors(experienceYears);
        
        System.out.println(sumDigit + " " + divisorCount);
        
        double factor = (experienceYears + sumDigit + divisorCount) / 100.0;
        
        double finalSalary = baseSalary * (1 + factor);
        
        employee.setFinalSalary(finalSalary);
        System.out.println(employee);
        
        sv.submitObject(studentCode, qAlias, employee);
    }
    private static int sumDigits(int exY) {
        int sum = 0;
        while(exY > 0) {
            sum += exY % 10;
            exY /= 10;
        }
        return sum;
    }
    public static int countDivisors(int exY) {
        int coun = 0;
        for(int i = 1; i <= exY; i++) {
            if(exY % i == 0) {
                coun++;
            }
        }
        return coun;
    }
}
