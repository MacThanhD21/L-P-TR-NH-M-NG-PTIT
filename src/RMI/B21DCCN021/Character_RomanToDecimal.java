package RMI.B21DCCN021;

import java.rmi.registry.*;
import RMI.CharacterService;

public class Character_RomanToDecimal {
    public static void main(String[] args) throws Exception {
        CharacterService sv = (CharacterService) LocateRegistry.getRegistry("203.162.10.109", 1099).lookup("RMICharacterService");

        String msv = "B21DCCN021", qCode = "ZSGStZGd";
        
        String inp = sv.requestCharacter(msv, qCode);

        int ans = 0, prev = 0;
 
        for(int i = inp.length() - 1; i >= 0; --i) {
            int cur = convert(inp.charAt(i));
            if(cur < prev) {
                ans -= cur;
            }
            else {
                ans += cur;
            }
            prev = cur;
        }
        String res = ans + "";
        sv.submitCharacter(msv, qCode, res);
    }

    public static int convert(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
