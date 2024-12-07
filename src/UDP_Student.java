
import java.io.*;
import java.net.*;
import java.util.*;
import UDP.Student;

public class UDP_Student {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;

        String code = ";B21DCCN002;AaAGvWvu";
        DatagramPacket dpSend1 = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpSend1);

        byte[] buf = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length);
        socket.receive(dpNhan);

        // 8 byte dau la id
        String requestId = (new String(dpNhan.getData(), 0, 8));
        System.out.println(requestId);

        // con lai la object
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student x = (Student) ois.readObject();

        System.out.println(x);

        // Chinh sua doi tuong object theo yêu cầu
        String[] name = x.getName().toLowerCase().split("\\s+");
        // Chuan hoa name
        String nor_Name = "";
        for (String xx : name) {
            nor_Name += Character.toUpperCase(xx.charAt(0)) + xx.substring(1).toLowerCase();
            nor_Name += " ";
        }
        x.setName(nor_Name.trim());

        // mail
        String mail = name[name.length - 1];
        System.out.println(mail);
        for (String xxx : name) {
            if (xxx == name[name.length - 1]) {
                break;
            }
            mail += xxx.charAt(0);

        }
        mail += "@ptit.edu.vn";
        x.setEmail(mail);
        System.out.println(mail);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(x);
        oos.flush();

        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(requestId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());

        DatagramPacket dpSend2 = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpSend2);

    }
}
