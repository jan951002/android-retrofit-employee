package com.example.elitebook.employeeclient.data.network.api.employee;

import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.data.network.model.base.BaseAPIAdapter;
import com.example.elitebook.employeeclient.data.network.model.base.BaseErrorResponse;
import com.example.elitebook.employeeclient.data.network.model.response.BaseResponse;

import java.util.List;

public class EmployeeAPIAdapter extends BaseAPIAdapter implements EmployeeAPIListener {
    @Override
    public void onCreateEmployeeSuccess(Employee employee) {

    }

    @Override
    public void onCreateEmployeeError(BaseErrorResponse baseErrorResponse) {

    }

    @Override
    public void onGetEmployeesSuccess(List<Employee> employees) {

    }

    @Override
    public void onGetEmployeeError(BaseErrorResponse baseErrorResponse) {

    }

    @Override
    public void onUpdateEmployeeSuccess(Employee employee) {

    }

    @Override
    public void onUpdateEmployeeError(BaseErrorResponse baseErrorResponse) {

    }

    @Override
    public void onDeleteEmployeeSuccess(BaseResponse baseResponse) {

    }

    @Override
    public void onDeleteEmployeeError(BaseErrorResponse baseErrorResponse) {

    }
}
