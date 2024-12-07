/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN014;

import java.rmi.registry.*;
import RMI.ByteService;

public class Byte_ChuyenDoiOctal {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) reg.lookup("RMIByteService");
        
        String studentCode = "B21DCCN014", qCode = "7iAu1XNt";
        byte[] inp = sv.requestData(studentCode, qCode);
        
        String octal = "";
        for(byte b : inp) {
            octal += (String.format("%03o", (b & 0xFF)));
        }
        sv.submitData(studentCode, qCode, octal.getBytes());
    }
}
