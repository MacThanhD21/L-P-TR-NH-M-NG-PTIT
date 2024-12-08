import java.io.*;
import java.net.*;
import java.util.*;
import UDP.Product;

public class UDP_Product {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        DatagramSocket soc = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        
        String code = ";B21DCCN007;SyHxJlP9";
        DatagramPacket dpGui1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        soc.send(dpGui1);
        
        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket (buf, buf.length);
        soc.receive(dpNhan);
        
        String reqId = (new String(dpNhan.getData(), 0, 8));
        System.out.println(reqId);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        
        Product x = (Product) ois.readObject();
        
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
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream (baos);
        oos.writeObject(x);
        oos.flush();
        
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reqId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        
        DatagramPacket dpGui2 = new DatagramPacket (sendData, sendData.length, sA, sP);
        soc.send(dpGui2);
        
    }
}
