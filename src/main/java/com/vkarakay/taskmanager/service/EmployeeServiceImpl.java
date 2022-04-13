package com.vkarakay.taskmanager.service;

import com.vkarakay.taskmanager.dao.EmployeeDAO;
import com.vkarakay.taskmanager.dao.TaskDAO;
import com.vkarakay.taskmanager.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private TaskDAO taskDAO;

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }
}
