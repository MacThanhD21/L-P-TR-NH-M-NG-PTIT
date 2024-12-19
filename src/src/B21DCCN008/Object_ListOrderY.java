/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN008;

import java.time.*;
import vn.medianews.*;
import java.util.*;

public class Object_ListOrderY {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN008", qCode = "46WF6Fg5";
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        List<OrderY> a = (List<OrderY>) port.requestListOrderY (msv, qCode);
        System.out.println(a);
        
        List<OrderY> ans = new ArrayList<>();
        LocalDate today = LocalDate.now();
        
        for(OrderY x : a) {
            LocalDate orderDate = x.getOrderDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
            if((x.getStatus().equals("pending")|| x.getStatus().equals("processing")) && orderDate.isBefore(today.minusDays(30))) {
                ans.add(x);
            }
        }
        port.submitListOrderY(msv, qCode, ans);
    }
}
