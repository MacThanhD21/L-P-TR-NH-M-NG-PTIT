package RMI.B21DCCN011;

import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;


public class Character_ChuyenDoiSoLaMa {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");
        
        String studentCode = "B21DCCN011", qCode = "FoM2RGr0";
        String inp = sv.requestCharacter(studentCode, qCode);
        
        System.out.println(inp.trim());
        
        int num = Integer.parseInt(inp.trim());
        String roman = "";
        
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        for(int i = 0; i < values.length; i++) {
            while(num >= values[i]) {
                roman += symbols[i];
                num -= values[i];
            }
        }
        System.out.println(roman);
        sv.submitCharacter(studentCode, qCode, roman);
    }
}
