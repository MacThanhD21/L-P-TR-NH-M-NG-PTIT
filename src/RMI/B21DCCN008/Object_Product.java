
package RMI.B21DCCN008;

import java.rmi.registry.*;
import java.util.*;
import RMI.ObjectService;
import RMI.Product;

public class Object_Product {
    public static void main(String[] args) throws Exception{
        ObjectService sv = (ObjectService) LocateRegistry.getRegistry("203.162.10.109", 1099).lookup("RMIObjectService");
        String msv = "B21DCCN008", qAlias = "ZYG9nHVU";
        Product x = (Product) sv.requestObject(msv, qAlias);
        
        System.out.println(x);
        
        x.setCode(x.getCode().toUpperCase());
        
        double exp = x.getImportPrice() + x.getImportPrice() * 0.2;
        
        x.setExportPrice(exp);
        
        System.out.println(x);
        sv.submitObject(msv, qAlias, x);
        
    }
}
