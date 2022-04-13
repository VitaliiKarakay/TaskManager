package com.vkarakay.taskmanager.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "tasks", schema = "task_manager")
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "shortname")
    @NotBlank(message = "Should be filled")
    private String shortName;
    @Basic
    @Column(name = "done")
    private int done;
    @Transient
    private Map<Integer, String> statusList;
//    @Basic
//    @Column(name = "developerId")
//    private int developerId;
    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "developerId", referencedColumnName = "id")
    private Employee employeeByDeveloperId;

    public Task() {
    }

    //    public Task() {
//        this.status.setId(1);
//        this.done = 0;
//        statusList = new HashMap<>();
//    }

    public Task(String shortName, Status status, Employee employeeByDeveloperId) {
        this.shortName = shortName;
        this.status = status;
        this.employeeByDeveloperId = employeeByDeveloperId;
    }

    public Map<Integer, String> getStatusList() {
        return statusList;
    }

    public void setStatusList(Map<Integer, String> statusList) {
        this.statusList = statusList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortname) {
        this.shortName = shortname;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

//    public int getDeveloperId() {
//        return developerId;
//    }
//
//    public void setDeveloperId(int developerId) {
//        this.developerId = developerId;
//    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getEmployeeByDeveloperId() {
        return employeeByDeveloperId;
    }

    public void setEmployeeByDeveloperId(Employee employeeByDeveloperId) {
        this.employeeByDeveloperId = employeeByDeveloperId;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Task task = (Task) o;
//        return id == task.id && done == task.done && developerId == task.developerId && Objects.equals(shortName, task.shortName) && Objects.equals(statusList, task.statusList) && Objects.equals(status, task.status) && Objects.equals(employeeByDeveloperId, task.employeeByDeveloperId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, shortName, done, statusList, developerId, status, employeeByDeveloperId);
//    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", done=" + done +
                ", statusList=" + statusList +
//                ", developerId=" + developerId +
                ", statusesByStatus=" + status +
                ", employeeByDeveloperId=" + employeeByDeveloperId +
                '}';
    }
}
