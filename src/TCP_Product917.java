
import java.io.*;
import java.net.*;
import TCP.Product917;

public class TCP_Product917 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        
        String code = "B21DCCN002;YBuPjIB7";
        
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        
        os.writeObject(code);
        os.flush();
        
        Product917 x = (Product917) is.readObject();
        
        System.out.println(x);
        
        
    }
}
