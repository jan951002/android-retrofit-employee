package com.example.elitebook.employeeclient.data.network.api.employee;

import com.example.elitebook.employeeclient.EmployeeClientApplication;
import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.data.network.model.base.BaseErrorResponse;
import com.example.elitebook.employeeclient.data.network.model.response.BaseResponse;
import com.example.elitebook.employeeclient.data.network.model.response.employee.ResponseEmployee;
import com.example.elitebook.employeeclient.data.network.model.response.employee.ResponseEmployees;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HTTP;

public class EmployeeAPIClient {

    private EmployeeAPIListener apiListener;
    private EmployeeAPI employeeAPI;

    public EmployeeAPIClient(EmployeeAPIListener apiListener) {
        this.apiListener = apiListener;
        this.employeeAPI = EmployeeClientApplication.getRetrofit().create(EmployeeAPI.class);
    }

    public void getEmployees() {
        employeeAPI.getEmployees().enqueue(new Callback<ResponseEmployees>() {
            @Override
            public void onResponse(Call<ResponseEmployees> call, Response<ResponseEmployees> response) {
                if (response.body().isSuccess()) {
                    apiListener.onGetEmployeesSuccess(response.body().getEmployees());
                } else {
                    BaseErrorResponse baseErrorResponse = new BaseErrorResponse();
                    apiListener.onGetEmployeeError(baseErrorResponse);
                }
            }

            @Override
            public void onFailure(Call<ResponseEmployees> call, Throwable t) {

            }
        });
    }

    public void createEmployee(Employee employee) {
        employeeAPI.createEmployee(employee).enqueue(new Callback<ResponseEmployee>() {
            @Override
            public void onResponse(Call<ResponseEmployee> call, Response<ResponseEmployee> response) {
                if (response.isSuccessful()) {
                    apiListener.onCreateEmployeeSuccess(response.body().getEmployee());
                } else {
                    BaseErrorResponse baseErrorResponse = new BaseErrorResponse();
                    apiListener.onCreateEmployeeError(baseErrorResponse);
                }
            }

            @Override
            public void onFailure(Call<ResponseEmployee> call, Throwable t) {

            }
        });
    }

    public void updateEmployee(Employee employee) {
        employeeAPI.updateEmployee(employee.getId(), employee).enqueue(new Callback<ResponseEmployee>() {
            @Override
            public void onResponse(Call<ResponseEmployee> call, Response<ResponseEmployee> response) {
                if (response.isSuccessful()) {
                    apiListener.onUpdateEmployeeSuccess(response.body().getEmployee());
                } else {
                    BaseErrorResponse baseErrorResponse = new BaseErrorResponse();
                    apiListener.onUpdateEmployeeError(baseErrorResponse);
                }
            }

            @Override
            public void onFailure(Call<ResponseEmployee> call, Throwable t) {

            }
        });
    }

    public void removeEmployee(Long id) {
        employeeAPI.removeEmployee(id).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful()) {
                    apiListener.onDeleteEmployeeSuccess(response.body());
                } else {
                    BaseErrorResponse baseErrorResponse = new BaseErrorResponse();
                    apiListener.onUpdateEmployeeError(baseErrorResponse);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });
    }

}
