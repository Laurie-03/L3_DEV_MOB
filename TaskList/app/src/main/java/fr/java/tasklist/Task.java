package fr.java.tasklist;

public class Task {

    String task_name;
    String task_description;


    /* ---------- Constructeur ---------- */

    public Task(String name, String description) {
        this.task_name = name;
        this.task_description = description;
    }



    /* ---------- Getters et setters ---------- */

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

    public String toString() {
        return "name : " + task_name +  "\n Descrption :" + task_description + "\n";
    }
}
