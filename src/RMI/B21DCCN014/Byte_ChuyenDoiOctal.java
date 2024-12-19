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
        
        String studentCode = "B21DCCN029", qCode = "iyxsSwVQ";
        byte[] inp = sv.requestData(studentCode, qCode);
        
        String ans = "";
        
        String ans2 = "";
        String ansHex = "";
        for(byte b : inp) {
            ans += (String.format("%03o", b & 0xFF));
        }
        System.out.println(ans);
        System.out.println(ans2);
        sv.submitData(studentCode, qCode, ans.getBytes());
    }
}
