/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B21DCCN007;

import vn.medianews.*;
import java.util.*;

public class CharacterSV_ChuyenDoiChuoi {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN007", qCode = "sBQjqANT";
        
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        String input = port.requestString(studentCode, qCode);
        
        System.out.println(input);
        
        String[] words = input.replace("_", " ").split("\\s+");
        
        String pascalCase = toPascalCase(words);
        String camelCase = toCamelCase(words);
        String snakeCase = toSnakeCase(words);
        
        List<String> result = new ArrayList<>(Arrays.asList(pascalCase, camelCase, snakeCase));
        
        port.submitCharacterStringArray(studentCode, qCode, result);
        
    }
    public static String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
    
    public static String toPascalCase(String[] words) {
        String res = "";
        for(String x : words) {
            res += capitalize(x);
        }
        return res;
    }
    
    public static String toCamelCase(String[] words) {
        String ans = words[0].toLowerCase();
        for(String x : words) {
            if(x == words[0]) continue;
            else ans += capitalize(x);
        }
        return ans;
    }
    public static String toSnakeCase(String[] words) {
        return String.join("_", words);
    }
}


