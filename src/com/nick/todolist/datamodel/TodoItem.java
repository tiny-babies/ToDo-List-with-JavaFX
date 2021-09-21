package com.nick.todolist.datamodel;

import java.time.LocalDate;

public class TodoItem implements Comparable<TodoItem>{
    private String shortDescription;
    private String details;
    private LocalDate deadline;

    public TodoItem(String shortDescription, String details, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadline = deadline;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public int compareTo(TodoItem o) {
        if(this == o){
            return 0;
        }
        if(o != null){
            return -this.deadline.compareTo(o.deadline);
        }
        throw new NullPointerException();
    }
    //    @Override
//    public String toString() {
//        return shortDescription;
//    } Dont need this with custom cell factory that we overrode
}
