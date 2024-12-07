
import java.io.*;
import java.net.*;
import java.util.*;
import TCP.Product;

public class TCP_Product {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        
        String code = "B21DCCN008;FwHdmWvr";
        
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        
        os.writeObject(code);
        os.flush();
        
        Product x = (Product) is.readObject();
        System.out.println(x);
//        System.out.println(is.readObject());
        String price = x.getPrice() + "";
        
        int discountNew = 0;
        
        for(char c : price.toCharArray()) {
            if(c == '.') break;
            discountNew += Integer.parseInt(c + "");
        }
        System.out.println(discountNew);
        
        x.setDiscount(discountNew);
        
        os.writeObject(x);
        os.flush();
        
        os.close();
        is.close();
        socket.close();
        
    }
}
