
package B21DCCN020;

import vn.medianews.*;
import java.util.*;
import java.time.*;
import javax.xml.datatype.XMLGregorianCalendar;

public class Object_ListCustomerY {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN020", qCode = "YVBYyeFZ";
        
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        List<CustomerY> a = port.requestListCustomerY(msv, qCode);
        
        System.out.println(a);
        
        List<CustomerY> ans = new ArrayList<>();
        
        LocalDate tod = LocalDate.now();
        
        for(CustomerY x : a) {
            LocalDate lastTr = x.getLastTransactionDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
            if(lastTr.isBefore(tod.minusMonths(6))) {
                ans.add(x);
            }
        }
        port.submitListCustomerY(msv, qCode, ans);
    }
}
