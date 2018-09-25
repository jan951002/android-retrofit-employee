package com.example.elitebook.employeeclient.ui.employees.get;

import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.data.network.api.employee.EmployeeAPIAdapter;
import com.example.elitebook.employeeclient.data.network.api.employee.EmployeeAPIClient;
import com.example.elitebook.employeeclient.data.network.api.employee.EmployeeAPIListener;
import com.example.elitebook.employeeclient.data.network.model.base.BaseErrorResponse;

import java.util.List;

public class GetEmployeesPresenter implements GetEmployeesContract.Presenter {

    private GetEmployeesContract.View view;
    private EmployeeAPIClient employeeAPIClient;
    private EmployeeAPIListener employeeAPIListener;

    public GetEmployeesPresenter() {
        this.employeeAPIListener = createEmployeeAPIListener;
        employeeAPIClient = new EmployeeAPIClient(employeeAPIListener);
    }

    @Override
    public void getEmployees() {
        employeeAPIClient.getEmployees();
    }

    @Override
    public void removeEmployee(Long id) {
        employeeAPIClient.removeEmployee(id);
    }

    @Override
    public void attachView(GetEmployeesContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    private EmployeeAPIListener createEmployeeAPIListener = new EmployeeAPIAdapter() {
        @Override
        public void onGetEmployeesSuccess(List<Employee> employees) {
            if (view != null) {
                view.showEmployees(employees);
            }
        }

        @Override
        public void onGetEmployeeError(BaseErrorResponse baseErrorResponse) {

        }
    };

}
