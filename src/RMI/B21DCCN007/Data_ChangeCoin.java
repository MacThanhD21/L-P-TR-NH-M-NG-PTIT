/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN007;

import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class Data_ChangeCoin {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) reg.lookup("RMIDataService");
        
        String studentCode = "B21DCCN007", qCode = "b15NqTy4";
        
//        sv.submitData(studentCode, qCode, result);
    }
}
