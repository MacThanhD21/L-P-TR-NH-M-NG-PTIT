
package RMI.B21DCCN677;

import java.rmi.registry.*;
import RMI.CharacterService;
import java.util.Base64;


public class Character_MaHoaBase64 {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) registry.lookup("RMICharacterService");
        
        String rev_Data = sv.requestCharacter("B21DCCN677", "ERQNsL1P");
        System.out.println(rev_Data);
        
        String encoded = Base64.getEncoder().encodeToString(rev_Data.getBytes());
        sv.submitCharacter("B21DCCN677", "ERQNsL1P", encoded);
    }
}
