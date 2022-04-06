package com.vkarakay.taskmanager.dao;

import com.vkarakay.taskmanager.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Task> getAllTasks() {

        Session session = sessionFactory.getCurrentSession();
        List<Task> taskList = session.createQuery("from Task", Task.class).getResultList();

        return taskList;
    }
}
