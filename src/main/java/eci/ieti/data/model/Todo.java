/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.ieti.data.model;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author AndrésQuintero
 */
public class Todo {

    @Id
    private String id;
    
    private String description;
    
    private Integer priority;
    
    private Date dueDate;
    
    private String responsible;
    
    private String status;

    public Todo(String description, Integer priority, Date dueDate, String responsible, String status) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.status = status;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", priority=" + priority + ", dueDate=" + dueDate + ", responsible=" + responsible + ", status=" + status + "]";
	}
    
    
}
