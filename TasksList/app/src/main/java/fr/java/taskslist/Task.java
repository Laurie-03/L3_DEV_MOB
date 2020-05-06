package fr.java.taskslist;

import androidx.annotation.NonNull;

import java.util.Date;

public class Task {

    private String task_name;
    private String task_description;
    private Date task_date;
    private String task_duration;

    public Task(String task_name, String task_description, Date task_date, String task_duration) {
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_date = task_date;
        this.task_duration = task_duration;
    }

    public Task(String task_name, String task_description) {
        this.task_name = task_name;
        this.task_description = task_description;
    }

    public String getTaskName() {
        return task_name;
    }

    public void setTaskName(String task_name) {
        this.task_name = task_name;
    }

    public String getTaskDescription() {
        return task_description;
    }

    public void setTaskDescription(String task_description) {
        this.task_description = task_description;
    }

    public Date getTaskDate() {
        return task_date;
    }

    public void setTaskDate(Date task_date) {
        this.task_date = task_date;
    }

    public String getTaskDuration() {
        return task_duration;
    }

    public void setTaskDuration(String task_duration) {
        this.task_duration = task_duration;
    }

    public String getFormattedDate() {
        int taskDay = task_date.getDay();
        int taskMonth = task_date.getMonth();
        int taskYear = task_date.getYear();

        String date =  taskDay + " / " + taskMonth + " / " + taskYear;

        return date;
    }
}
