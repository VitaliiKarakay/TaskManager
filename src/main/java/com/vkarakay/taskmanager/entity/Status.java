package com.vkarakay.taskmanager.entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "statuses", schema = "task_manager")
public class Status {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "status")
    private List<Task> tasks;
    @OneToMany(mappedBy = "status")
    private List<Task> tasksById;

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (id != status.id) return false;
        if (name != null ? !name.equals(status.name) : status.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Task> getTasksById() {
        return tasksById;
    }

    public void setTasksById(List<Task> tasksById) {
        this.tasksById = tasksById;
    }
}
