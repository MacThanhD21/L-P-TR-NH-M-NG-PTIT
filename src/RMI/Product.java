/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;

public class Product implements Serializable{
    private static final long serialVersionUID = 20151107L;
    private String id, code;
    private double importPrice, exportPrice;

    public Product() {
    }

    public Product(String id, String code, double importPrice, double exportPrice) {
        this.id = id;
        this.code = code;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", importPrice=" + importPrice + ", exportPrice=" + exportPrice + '}';
    }
    
    
}
