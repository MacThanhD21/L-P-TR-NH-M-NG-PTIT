package RMI.B21DCCN012;

import java.net.URLEncoder;
import java.rmi.registry.*;
import RMI.CharacterService;

public class Character_URLEncode {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) reg.lookup("RMICharacterService");

        String studentCode = "B21DCCN012", qCode = "sqIYe0Jb";

        String input = sv.requestCharacter(studentCode, qCode);

        String urlEncoded = URLEncoder.encode(input, "UTF-8");

        sv.submitCharacter(studentCode, qCode, urlEncoded);
    }
}
