package com.vkarakay.taskmanager.dao;

import com.vkarakay.taskmanager.entity.Status;
import com.vkarakay.taskmanager.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskDAOImpl implements TaskDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Task> getAllTasks() {

        Session session = sessionFactory.getCurrentSession();
        List<Task> taskList = session.createQuery("from Task", Task.class).getResultList();

        return taskList;
    }

    public List<Task> getTasksByDoneStatus(int id) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Task where done = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Task> allTasks = query.getResultList();
        return allTasks;
    }

    @Override
    public Task getTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.get(Task.class, id);
        task.setStatusList(fillStatusMap());
        return task;
    }

    public Map<Integer, String> fillStatusMap() {
        Session session = sessionFactory.getCurrentSession();
        Map<Integer, String> statusMap = new HashMap<>();
        String hql = "FROM Status";
        Query query = session.createQuery(hql);
        List<Status> statusList = query.getResultList();
        for (Status status: statusList) {
            statusMap.put(status.getId(), status.getName());
        }
        return statusMap;
    }

    @Override
    public void saveTask(Task task) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(task);
    }
}
