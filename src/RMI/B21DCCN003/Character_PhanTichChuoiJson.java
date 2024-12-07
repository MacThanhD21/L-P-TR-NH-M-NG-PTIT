/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN003;

import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;

public class Character_PhanTichChuoiJson {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");
        
        String studentCode = "B21DCCN003", qCode = "Me7DUKOl";
        String inp = sv.requestCharacter(studentCode, qCode);
        
        inp = inp.replace("\"", "");
        inp = inp.replace("{", "");
        inp = inp.replace("}", "");
        
        System.out.println(inp);
        
        String odd = "", even = "";
        
        String[] data = inp.split(", ");
        
        for(int i = 0; i < data.length; i++) {
            if(i % 2 == 0) {
                even += data[i] + ", ";
            }
            else {
                odd += data[i] + ", "; 
            }
        }
        even = even.substring(0, even.length() - 2);
        odd = odd.substring(0, odd.length() - 2);

        String ans = even + "; " + odd;
        System.out.println(ans);
        
        sv.submitCharacter(studentCode, qCode, ans);
    }
}
