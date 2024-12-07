/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Event implements Serializable{
    private static final long serialVersionUID = 20241131L;
    private String id, eventName, eventDate, eventCode ;
    private int expectedAttendance;

    public Event() {
    }

    public Event(String id, String eventName, String eventDate, int expectedAttendance, String eventCode) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.expectedAttendance = expectedAttendance;
        this.eventCode = eventCode;
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

    public String getEventDate() {
        return eventDate;
    }

    public int getExpectedAttendance() {
        return expectedAttendance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setExpectedAttendance(int expectedAttendance) {
        this.expectedAttendance = expectedAttendance;
    }
    
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", eventName=" + eventName + ", eventDate=" + eventDate + ", expectedAttendance=" + expectedAttendance + '}';
    }

    
}
