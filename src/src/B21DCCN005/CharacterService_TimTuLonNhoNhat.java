package B21DCCN005;

import vn.medianews.*;
import java.util.*;

public class CharacterService_TimTuLonNhoNhat {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN005", qCode = "9n2rfqST";
        
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        String input = port.requestString(studentCode, qCode);
        System.out.println(input);
        
        String[] words = input.split("\\s+");
        
        String longestWord = "", shortestWord = words[0];
        
        for(String word : words) {
            if(word.length() > longestWord.length()) {
                longestWord = word;
            }
            if(word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }
        String result = longestWord + "; " + shortestWord;
        port.submitCharacterString(studentCode, qCode, result);
//        System.out.println(words);
    }
}
