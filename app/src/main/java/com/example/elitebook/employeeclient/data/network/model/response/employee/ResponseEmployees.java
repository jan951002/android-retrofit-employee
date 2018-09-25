package com.example.elitebook.employeeclient.data.network.model.response.employee;

import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.data.network.model.response.BaseResponse;

import java.io.Serializable;
import java.util.List;

public class ResponseEmployees extends BaseResponse implements Serializable {
    private List<Employee> employees;

    public ResponseEmployees(int status, String message, boolean success, List<Employee> employees) {
        super(status, message, success);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
