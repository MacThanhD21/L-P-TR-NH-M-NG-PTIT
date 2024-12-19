package B21DCCN001;

import vn.medianews.*;
import java.util.*;

public class CharacterService_SapXepChuoi {

    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN002", qCode = "x5TIDg1S";
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        List<String> inp = port.requestStringArray(msv, qCode);
        System.out.println(inp);
        
        Collections.sort(inp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return countVowels(o1) - countVowels(o2);
            }
        });
        
        port.submitCharacterStringArray(msv, qCode, inp);
    }

    private static int countVowels(String str) {
        int cnt = 0;
        String nAm = "ueoaiUEOAI";
        for (char c : str.toCharArray()) {
            if (nAm.indexOf(c) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
}