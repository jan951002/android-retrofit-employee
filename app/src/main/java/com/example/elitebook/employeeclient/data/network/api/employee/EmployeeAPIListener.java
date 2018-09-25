package com.example.elitebook.employeeclient.data.network.api.employee;

import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.data.network.model.base.BaseAPIListener;
import com.example.elitebook.employeeclient.data.network.model.base.BaseErrorResponse;
import com.example.elitebook.employeeclient.data.network.model.response.BaseResponse;

import java.util.List;

public interface
EmployeeAPIListener extends BaseAPIListener {

    void onCreateEmployeeSuccess(Employee employee);
    void onCreateEmployeeError(BaseErrorResponse baseErrorResponse);
    void onGetEmployeesSuccess(List<Employee> employees);
    void onGetEmployeeError(BaseErrorResponse baseErrorResponse);
    void onUpdateEmployeeSuccess(Employee employee);
    void onUpdateEmployeeError(BaseErrorResponse baseErrorResponse);
    void onDeleteEmployeeSuccess(BaseResponse baseResponse);
    void onDeleteEmployeeError(BaseErrorResponse baseErrorResponse);
}
