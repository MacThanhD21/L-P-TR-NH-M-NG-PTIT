/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Train_NetProgramming;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_TungXuxSac {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        String code = "B21DCCN008;taLoUUIi";
        
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        
        dos.writeUTF(code);
        dos.flush();
        
        // receive
        int n = dis.readInt();
        int[] a = new int[n], cnt = new int[n + 5];
        
        for(int i = 0; i < n; i++) {
            a[i] = dis.readInt();
            cnt[a[i]]++;
        }
        
        for(int i = 1; i <= 6; i++) {
            float ans = (float) cnt[i] / n;
            dos.writeFloat(ans);

            System.out.println(ans);
        }
        dos.flush();

        dos.close();
        dis.close();
        socket.close();
    }
}
