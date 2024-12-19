package B21DCCN012;

import vn.medianews.*;
import java.util.*;

public class CharacterSV_PhanLoaiTu {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN012", qCode = "32He7sZg";
        
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        List<String> inp = port.requestStringArray(msv, qCode);
        System.out.println(inp);
        
        Map<Integer, List<String>> mp = new TreeMap<>(); // su dung treemap
        
        for(String x : inp) {
            int coun = coun(x);
            mp.putIfAbsent(coun, new ArrayList<>());
            mp.get(coun).add(x);
        }
        
        List<String> ans = new ArrayList<>();
        
        for(int x : mp.keySet()) {
            List<String> words = mp.get(x);
            Collections.sort(words);
            ans.add(String.join(", ", words));
        }
        
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    public static int coun(String word) {
        int coun = 0;
        String nam = "ueoaiUEOAI";
        for(char c : word.toCharArray()) {
            if(nam.indexOf(c) != -1) {
                coun++;
            }
        }
        return coun;
    }
}