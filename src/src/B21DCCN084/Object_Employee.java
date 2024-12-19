/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN084;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import vn.medianews.*;

public class Object_Employee {
    public static void main(String[] args) {
        String msv = "B21DCCN084", qCode = "L8CainEX";
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        Employee e = (Employee) port.requestEmployee(msv, qCode);
        System.out.println(e);
        
        String st = e.getStartDate().toString().substring(0, 10), en = e.getEndDate().toString().substring(0, 10);
        
        System.out.println(st + " " + en);
        
        LocalDate stDay = LocalDate.parse(st), enDay = LocalDate.parse(en);
        
        long bet = ChronoUnit.DAYS.between(stDay, enDay);
        System.out.println(bet);
        
        int ans = 0;
        for(int i = 0; i <= bet; i++) {
            LocalDate curDay = stDay.plusDays(i);
            if(curDay.getDayOfWeek().getValue() <= 5) ans++;
        }
        e.setWorkingDays(ans);
        port.submitEmployee(msv, qCode, e);
    }
}
