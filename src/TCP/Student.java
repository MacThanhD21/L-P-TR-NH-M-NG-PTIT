
package TCP;

import java.io.Serializable;


public class Student implements Serializable{
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code, gpaLetter;
    private float gpa;

    public Student(int id, String code, String gpaLetter, float gpa) {
        this.id = id;
        this.code = code;
        this.gpaLetter = gpaLetter;
        this.gpa = gpa;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getGpaLetter() {
        return gpaLetter;
    }

    public float getGpa() {
        return gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", gpaLetter=" + gpaLetter + ", gpa=" + gpa + '}';
    }
    
    
}
