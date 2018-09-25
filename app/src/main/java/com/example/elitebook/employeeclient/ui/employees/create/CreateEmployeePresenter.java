package com.example.elitebook.employeeclient.ui.employees.create;

import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.data.network.api.employee.EmployeeAPIAdapter;
import com.example.elitebook.employeeclient.data.network.api.employee.EmployeeAPIClient;
import com.example.elitebook.employeeclient.data.network.api.employee.EmployeeAPIListener;
import com.example.elitebook.employeeclient.data.network.model.base.BaseErrorResponse;

public class CreateEmployeePresenter implements CreateEmployeeContract.Presenter {

    private CreateEmployeeContract.View view;
    private EmployeeAPIClient employeeAPIClient;
    private EmployeeAPIListener employeeAPIListener;

    public CreateEmployeePresenter() {
        employeeAPIListener = createEmployeeListener;
        employeeAPIClient = new EmployeeAPIClient(employeeAPIListener);
    }

    @Override
    public void createEmployee() {
        if (view != null) {
            Long id = view.getId();
            String name = view.getName();

            Employee employee = new Employee(id, name);
            employeeAPIClient.createEmployee(employee);
        }
    }

    @Override
    public void updateEmployee() {
        if (view != null) {
            Long id = view.getId();
            String name = view.getName();

            Employee employee = new Employee(id, name);
            employeeAPIClient.updateEmployee(employee);
        }
    }

    @Override
    public void attachView(CreateEmployeeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    private EmployeeAPIListener createEmployeeListener = new EmployeeAPIAdapter() {

        @Override
        public void onCreateEmployeeSuccess(Employee employee) {
            super.onCreateEmployeeSuccess(employee);
        }

        @Override
        public void onCreateEmployeeError(BaseErrorResponse baseErrorResponse) {
            super.onCreateEmployeeError(baseErrorResponse);
        }
    };
}
