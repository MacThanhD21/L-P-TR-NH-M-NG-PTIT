/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN016;

import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class Byte_TanSuatNhieuNhat {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");
        
        String studentCode = "B21DCCN016", qCode = "M6mZRLvw";
        byte[] data = sv.requestData(studentCode, qCode);
        
        System.out.println(Arrays.toString(data));
        
        Map<Byte, Integer> mp = new HashMap<>();
        byte Element = data[0];
        int maxFre = 0;
        
        for(byte b : data) {
            mp.put(b, mp.getOrDefault(b, 0) + 1);
            if(mp.get(b) > maxFre) {
                maxFre = mp.get(b);
                Element = b;
            }
        }
        
        byte[] result = new byte[2];
        result[0] = Element;
        result[1] = (byte) maxFre;
        
        System.out.println(Arrays.toString(result));
        
        sv.submitData(studentCode, qCode, result);
    }
}
