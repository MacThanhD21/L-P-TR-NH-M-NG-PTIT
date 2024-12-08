/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_LoaiBo_KyTuDacBiet_So_KyTuTrung;

import java.net.*;
import java.io.*;
import java.util.*;

public class TCP_LoaiBo_KyTuDacBiet_So_KyTuTrung {
    public static void main(String[] args) throws IOException{
        Socket soc = new Socket("203.162.10.109", 2208);
        String code = "B21DCCN010;QchrSRGT";
        
        BufferedReader is = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
        
        os.write(code);
        os.newLine();
        os.flush();
        
        String inp = is.readLine();
        System.out.println(inp);

        LinkedHashSet<Character> res = new LinkedHashSet<>();
        for(char c : inp.toCharArray()) {
            if(Character.isLetter(c)) {
                res.add(c);
            }
        }
        
        String ans = "";
        for(Character c : res) {
            ans += c;
        }
        System.out.println(ans);
        
        os.write(ans);
        os.newLine();
        os.flush();
        
        os.close();
        is.close();
        soc.close();
        
    }
}
