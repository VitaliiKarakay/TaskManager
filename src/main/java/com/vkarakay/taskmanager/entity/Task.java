package com.vkarakay.taskmanager.entity;

import javax.persistence.*;
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
    private String shortName;
    @Basic
    @Column(name = "developer")
    private String developer;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "done")
    private int done;

    public Task() {
        this.status = 1;
        this.done = 0;
    }

    public Task(String shortName, String developer, int status, int done) {
        this.shortName = shortName;
        this.developer = developer;
        this.status = status;
        this.done = done;
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

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (status != task.status) return false;
        if (done != task.done) return false;
        if (!Objects.equals(shortName, task.shortName)) return false;
        if (!Objects.equals(developer, task.developer)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortName, developer, status, done);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", developer='" + developer + '\'' +
                ", status=" + status +
                ", done=" + done +
                '}';
    }
}
