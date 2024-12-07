/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN014;

import java.rmi.registry.*;
import java.util.*;
import RMI.ObjectService;
import RMI.Order;

public class Object_Order {
    public static void main(String[] args) throws Exception, ClassNotFoundException{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) reg.lookup("RMIObjectService");
        
        String studentCode = "B21DCCN014", qAlias = "bBKKGiD2";
        Order x = (Order) sv.requestObject(studentCode, qAlias);
        System.out.println(x);
        
        String orderCode = x.getShippingType().substring(0, 2).toUpperCase();
        orderCode += x.getCustomerCode().substring(x.getCustomerCode().length() - 3);
        orderCode += x.getOrderDate().substring(8) + x.getOrderDate().substring(5, 7);
        System.out.println(orderCode);
        
        x.setOrderCode(orderCode);
        
        sv.submitObject(studentCode, qAlias, x);
    }
}
