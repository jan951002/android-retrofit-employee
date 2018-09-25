package com.example.elitebook.employeeclient.ui.employees.get;

import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.ui.base.BasePresenter;
import com.example.elitebook.employeeclient.ui.base.BaseView;

import java.util.List;

public interface GetEmployeesContract {

    interface View extends BaseView {

        void showEmployees(List<Employee> employees);

    }

    interface Presenter extends BasePresenter<View> {
        void getEmployees();
        void removeEmployee(Long id);
    }
}
