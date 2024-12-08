
import java.io.*;
import java.net.*;
import TCP.Laptop;

public class TCP_Laptop {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        
        String code = "B21DCCN005;rCry3n4J";
        
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        
        os.writeObject(code);
        os.flush();
        
        Laptop x = (Laptop) is.readObject();
        
        System.out.println(x);
        
        String[] name = x.getName().split("\\s+");
        
        String tmp = name[0];
        name[0] = name[name.length - 1];
        name[name.length - 1] = tmp;
        
        String new_Name = String.join(" ", name);
        System.out.println(new_Name);
        
        StringBuilder quantity = new StringBuilder(x.getQuantity() + "");
        
        x.setName(new_Name);
        x.setQuantity(Integer.parseInt(quantity.reverse().toString()));
        
        System.out.println(x);
        
        os.writeObject(x);
        os.flush();
        
        socket.close();
        os.close();
        is.close();
        
    }
}
