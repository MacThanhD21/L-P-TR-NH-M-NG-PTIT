/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN014;

import vn.medianews.*;
import java.util.*;


public class Object_ListCustomer {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN014", qCode = "lgKj7lIF";
        
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = sv.getObjectServicePort();
        
        List<Customer> a = (List<Customer>) port.requestListCustomer(msv, qCode);
        System.out.println(a);
        
        List<Customer> ans = new ArrayList<>();
        
        for(Customer x : a) {
            if(x.getTotalSpent() > 5000 && x.getPurchaseCount() >= 5) ans.add(x);
        }
        port.submitListCustomer(msv, qCode, ans);
    }
}
