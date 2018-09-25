package com.example.elitebook.employeeclient.data.network.model.response.employee;

import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.data.network.model.response.BaseResponse;

import java.io.Serializable;

public class ResponseEmployee extends BaseResponse implements Serializable {

    private Employee employee;

    public ResponseEmployee(int status, String message, boolean success, Employee employee) {
        super(status, message, success);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
