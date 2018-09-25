package com.example.elitebook.employeeclient.data.network.api.employee;

import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.data.network.model.response.BaseResponse;
import com.example.elitebook.employeeclient.data.network.model.response.employee.ResponseEmployee;
import com.example.elitebook.employeeclient.data.network.model.response.employee.ResponseEmployees;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeAPI {

    @GET("v1/employee")
    Call<ResponseEmployees> getEmployees();

    @POST("v1/employee")
    Call<ResponseEmployee> createEmployee(@Body Employee employee);

    @PUT("v1/employee/{employee_id}")
    Call<ResponseEmployee> updateEmployee(@Path("employee_id") Long id,@Body Employee employee);

    @DELETE("v1/employee/{employee_id}")
    Call<BaseResponse> removeEmployee(@Path("employee_id") Long id);
}
