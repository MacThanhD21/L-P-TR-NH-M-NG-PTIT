
import TCP.Student;
import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_Student {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        
        String code = "B21DCCN677;vDgMdyZC";
        
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        
        os.writeObject(code);
        os.flush();
        
        Student x = (Student) is.readObject();
        System.out.println(x);
        
        float gpaF = x.getGpa();
        String gpaLet = "";
        System.out.println(gpaF);
        if(gpaF >= 3.7) {
            gpaLet = "A";
        }
        else if(gpaF >= 3.0) {
            gpaLet = "B";
        } else if(gpaF >= 2.0) {
            gpaLet = "C";
        } else if(gpaF >= 1.0) {
            gpaLet = "D";
        } else {
            gpaLet = "F";
        }
        x.setGpaLetter(gpaLet);
        System.out.println(x);
        
        os.writeObject(x);
        os.flush();
        
        socket.close();
        is.close();
        os.close();
    }
}
