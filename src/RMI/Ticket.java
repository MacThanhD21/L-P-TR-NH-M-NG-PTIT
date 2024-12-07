/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;


public class Ticket implements Serializable{
    private static final long serialVersionUID = 20241133L;
    private String id, eventName, saleDate, ticketCode;

    public Ticket() {
    }

    public Ticket(String id, String eventName, String saleDate, String ticketCode) {
        this.id = id;
        this.eventName = eventName;
        this.saleDate = saleDate;
        this.ticketCode = ticketCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", eventName=" + eventName + ", saleDate=" + saleDate + ", ticketCode=" + ticketCode + '}';
    }
}
