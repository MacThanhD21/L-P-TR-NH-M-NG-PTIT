package B21DCCN818;

import vn.medianews.*;
import java.util.*;

public class CharacterService_MinMaxLengthString {

    public static void main(String[] args) throws Exception {
        
        // khai bao msv, qcode
        String msv = "B21DCCN818", qCode = "9asU1NDN";
        // khai bao doi tuong cchch
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        String[] inp = ((String) port.requestString(msv, qCode)).split("[\\s_]+");
        
        String s1 = "", s2 = "9ifvksdnvkjsnvkjsnvksjdnvjksnvskjdnvkjsdnvksdjvnskdjnvjsdvnksjdvnks";
        for(String x : inp) {
            System.out.println(x);
            if(x.length() > s1.length()) {
                s1 = x;
            }
            if(x.length() < s2.length()) {
                s2 = x;
            }
        }
        String ans = s1 + "; " + s2;
        System.out.println(ans);
        List<String> s = new ArrayList<>();
        s.add(ans);
//        port.submitCharacterString(qCode, qCode, s);
        
    }
}