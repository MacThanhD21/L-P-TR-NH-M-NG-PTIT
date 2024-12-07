package RMI.B21DCCN001;

import RMI.CharacterService;
import java.rmi.registry.*;
import java.util.*;
import java.net.*;

public class Character_MaHoaURL {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) registry.lookup("RMICharacterService");
        
        String msv = "B21DCCN001", qCode = "AhrzRLmM";
        String inp = sv.requestCharacter(msv, qCode);
        System.out.println(inp);
        
        String encode = URLEncoder.encode(inp, "UTF-8");
        
        System.out.println(encode);
        
        sv.submitCharacter(msv, qCode, encode);
    }
}
