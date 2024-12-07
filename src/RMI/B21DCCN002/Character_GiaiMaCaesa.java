
package RMI.B21DCCN002;

import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;

public class Character_GiaiMaCaesa {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");
        
        String msv = "B21DCCN002", qCode = "yBwAovez";
        String inp = sv.requestCharacter(msv, qCode);
        
        System.out.println(inp);
        
        int shift = inp.length() % 7;
        
        // giai ma: - shift
        String ans = "";
        for(Character c : inp.toCharArray()) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            char x = (char) ((c - base - shift + 26) % 26 + base);
            ans += x;
        }
        System.out.println(ans);
        sv.submitCharacter(msv, qCode, ans);
    }
}
