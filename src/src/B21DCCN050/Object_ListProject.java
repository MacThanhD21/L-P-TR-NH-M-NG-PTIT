/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN050;

import vn.medianews.*;
import java.util.*;
import java.time.*;
import javax.xml.datatype.XMLGregorianCalendar;

public class Object_ListProject {
    public static void main(String[] args) {
        String msv = "B21DCCN050", qCode = "FGAYNXQm";
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        List<Project> a = port.requestListProject(msv, qCode);
        System.out.println(a);
        
        LocalDate today = LocalDate.now();
        
        List<Project> ans = new ArrayList<>();
        for(Project x : a) {
            LocalDate dueDate = x.getDueDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
            if((int) x.getCompletionPercentage() >= 80 && dueDate.isBefore(today.plusDays(15))) {
                ans.add(x);
            }
        }
        port.submitListProject(msv, qCode, ans);
    }
}
