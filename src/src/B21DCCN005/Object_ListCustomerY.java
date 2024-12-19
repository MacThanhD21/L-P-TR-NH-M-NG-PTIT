/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN005;

import vn.medianews.*;
import java.util.*;
import java.time.*;
import javax.xml.datatype.XMLGregorianCalendar;

public class Object_ListCustomerY {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "aYiLQ3wo";
        
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        List<CustomerY> a = port.requestListCustomerY(msv, qCode);
        
        LocalDate today = LocalDate.now();
        System.out.println(today);
        
        List<CustomerY> ans = new ArrayList<>();
        for (CustomerY x : a) {
            // x.getLastTransaction la kieu calendar
            LocalDate lastTransaction = x.getLastTransactionDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
            // Kiem tra cac khach hang co giao dich truoc 6 thang gan day
            if(lastTransaction.isBefore(today.minusMonths(6))) {
                ans.add(x);
            }
        }
        port.submitListCustomerY(msv, qCode, ans);
    }
}
