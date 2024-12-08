
import java.io.IOException;

import java.net.*;
import java.util.*;
import TCP.Customer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TCP_Customer918 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);

        String code = "B21DCCN007;vBJR86q1";
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

        os.writeObject(code);
        os.flush();

        Customer x = (Customer) is.readObject();
        System.out.println(x);

        String[] name = x.getName().split("\\s+");
//        System.out.println(name);
        String new_Name = name[name.length - 1].toUpperCase() + ", ";
        for (String v : name) {
            if (v == name[name.length - 1]) {
                break;
            }
            new_Name += Character.toUpperCase(v.charAt(0)) + v.substring(1).toLowerCase()+ " ";
        }
        new_Name = new_Name.trim();
        System.out.println(new_Name);
        String[] date = x.getDayOfBirth().split("-");
        String tmp = date[0];
        date[0] = date[1];
        date[1] = tmp;
        String new_Date = String.join("/", date);
        System.out.println(new_Date);
        
        String new_userName = "" ;
        for(String u : name) {
            if(u == name[name.length - 1]) break;
            new_userName += Character.toLowerCase(u.charAt(0));
        }
        new_userName += name[name.length - 1].toLowerCase();
        System.out.println(new_userName.toLowerCase());
        
        
        x.setName(new_Name);
        x.setDayOfBirth(new_Date);
        x.setUserName(new_userName);
        
        os.writeObject(x);
        os.flush();
        
        socket.close();
        is.close();
        os.close();
    }
}
