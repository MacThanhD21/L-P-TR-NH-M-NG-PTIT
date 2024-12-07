
package RMI.B21DCCN004;

import java.rmi.registry.*;
import java.util.*;
import RMI.ObjectService;
import RMI.Event;

public class Object_Event {
    public static void main(String[] args) throws Exception, ClassNotFoundException{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) reg.lookup("RMIObjectService");
        
        String studentCode = "B21DCCN004", qAlias = "QgVz8P8C";
        Event x = (Event) sv.requestObject(studentCode, qAlias);
        System.out.println(x);
        
        String eventCode = "";
        int expectedAttendance =  x.getExpectedAttendance();
        
        if(expectedAttendance >= 1000) {
            eventCode += "L";
        } else if (expectedAttendance >= 500) {
            eventCode += "M";
        } else {
            eventCode += "S";
        }
        String[] eventName = x.getEventName().split("\\s+");
        eventCode += "" + Character.toUpperCase(eventName[0].charAt(0)) + Character.toUpperCase(eventName[eventName.length - 1].charAt(eventName[eventName.length - 1].length() - 1));
        System.out.println(eventCode);
        
        String[] evenDate = x.getEventDate().split("-");
        eventCode += evenDate[2] + evenDate[1];
        
        System.out.println(eventCode);
        x.setEventCode(eventCode);
        
        System.out.println(x);
        sv.submitObject(studentCode, qAlias, x);
    }
}
