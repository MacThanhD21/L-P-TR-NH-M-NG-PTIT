package B21DCCN021;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.time.LocalDate;
import vn.medianews.*;
import java.util.*;
import javax.xml.datatype.XMLGregorianCalendar;

public class Object_ListOrder {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN021", qCode = "CuW1L0ev";

//        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();

        List<Order> a = port.requestListOrder(msv, qCode);
        Map<String, Float> mp = new HashMap<>();
        for(Order x : a) {
            mp.put(x.getCustomerId(), mp.getOrDefault(x.getCustomerId(), 0f) + x.getAmount());
        }
        
        float maxVal = Collections.max(mp.values());
        
        List<Order> ans = new ArrayList<>();
        
        for(Order x : a) {
            if(mp.get(x.getCustomerId()) == maxVal) {
                ans.add(x);
            }
        }
        System.out.println(ans);

        port.submitListOrder(msv, qCode, ans);
    }
}
