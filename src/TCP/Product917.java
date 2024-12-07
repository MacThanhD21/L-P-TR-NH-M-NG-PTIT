package TCP;

import java.io.Serializable;

public class Product917 implements Serializable {

    private static final long serialVersionUID = 917;
    private int id, quantity;
    private String code, name;

    public Product917(int id, int quantity, String code, String name) {
        this.id = id;
        this.quantity = quantity;
        this.code = code;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product917{" + "id=" + id + ", quantity=" + quantity + ", code=" + code + ", name=" + name + '}';
    }

}
