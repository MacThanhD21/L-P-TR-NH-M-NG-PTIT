/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN002;

import java.rmi.registry.*;
import java.util.*;
import RMI.ObjectService;
import RMI.Product;

public class Object_Product {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) reg.lookup("RMIObjectService");
        
        String studentCode = "B21DCCN002", qAlias = "x4Wf54Vc";
        
        Product x = (Product) sv.requestObject(studentCode, qAlias);
        
        System.out.println(x);
        
        String msp = x.getCode().toUpperCase();
        double exportP = x.getExportPrice() + x.getImportPrice() + 0.2  * x.getImportPrice();
        x.setCode(msp);
        x.setExportPrice(exportP);
        
        System.out.println(x);
        
        sv.submitObject(studentCode, qAlias, x);
    }
}
