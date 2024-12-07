/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN005;

import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class Byte_MaHoaCaesarACII {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");
        
        String msv = "B21DCCN005", qCode = "QKsD0gjI";
        byte[] data = sv.requestData(msv, qCode);
        
        System.out.println(data);
        int shift = data.length;
        
        byte[] encodeData = new byte[data.length];
        
        for(int i = 0; i < data.length; i++) {
            encodeData[i] = (byte) ((data[i] + shift) % 256);
        }
        
        sv.submitData(msv, qCode, encodeData);  
    }
}
