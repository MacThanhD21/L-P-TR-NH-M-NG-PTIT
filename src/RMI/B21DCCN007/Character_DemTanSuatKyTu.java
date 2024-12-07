
package RMI.B21DCCN007;

import java.rmi.registry.*;
import RMI.CharacterService;
import java.util.*;
import java.util.stream.*;

public class Character_DemTanSuatKyTu {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");
        
        String msv = "B21DCCN007", qCode = "PNw9F7PD";
        String inp = sv.requestCharacter(msv, qCode);
        
        System.out.println(inp);
        
        Map<Character, Integer> mp = new HashMap<>();
        for(char c : inp.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        String result = "{";
        for(char c : inp.toCharArray()) {
            if(mp.get(c) > 0) {
                result += "\"" + c + "\": " + mp.get(c) + ", ";
                mp.put(c, 0);
            }
        }
        result = result.substring(0, result.length() - 2);
        result += "}";
        
        System.out.println(result);
        sv.submitCharacter(msv, qCode, result);
    }
}
