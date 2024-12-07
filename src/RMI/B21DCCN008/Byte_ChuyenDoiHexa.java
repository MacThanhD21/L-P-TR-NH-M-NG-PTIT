/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN008;

import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class Byte_ChuyenDoiHexa {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) reg.lookup("RMIByteService");
        
        String msv = "B21DCCN008", qCode = "uHhGDBz0";
        byte[] data = sv.requestData(msv, qCode);
        System.out.println(data);
        
        String ans = "";
        for(byte c : data) {
            ans += String.format("%02x", c);
        }
        System.out.println(ans);
        sv.submitData(msv, qCode, ans.getBytes());
    }
}
