/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
/**
 *
 * @author dotha
 */
public class History extends Worker implements Comparable<History>{
    private String status;
    private Date date;

    public History() {
    }

   public History(String status, Date date, String code, String name, int age, int salary, String workLocation) {
    super(code, name, age, salary, workLocation);
    this.status = status;
    this.date = date;
}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    
    @Override
    public int compareTo(History o) {
        return this.getCode().compareTo(o.getCode());
    }
    
}