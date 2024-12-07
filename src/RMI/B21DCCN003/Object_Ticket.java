/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN003;

import java.rmi.registry.*;
import java.util.*;
import RMI.ObjectService;
import RMI.Ticket;

public class Object_Ticket {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) reg.lookup("RMIObjectService");
        
        String studentCode = "B21DCCN003", qAlias = "twAinQEm";
        
        Ticket x = (Ticket) sv.requestObject(studentCode, qAlias);
        
        System.out.println(x);
        
        String new_TicketCode = (Character.toUpperCase(x.getEventName().charAt(0)) + "") + Character.toUpperCase(x.getEventName().charAt(x.getEventName().length() - 1));
        
        System.out.println(new_TicketCode);
        new_TicketCode += x.getSaleDate().substring(3, 5) + x.getSaleDate().substring(0, 2);
        
        System.out.println(new_TicketCode);
        
        List<Integer> ar = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            if(x.getSaleDate().indexOf(i + "") == -1) {
                ar.add(i);
            }
        }
        System.out.println(ar);
        new_TicketCode += ar.get(ar.size() - 1) + "" + ar.get(0);
        System.out.println(new_TicketCode);
        
        x.setTicketCode(new_TicketCode);
        
        sv.submitObject(studentCode, qAlias, x);
    }
}
