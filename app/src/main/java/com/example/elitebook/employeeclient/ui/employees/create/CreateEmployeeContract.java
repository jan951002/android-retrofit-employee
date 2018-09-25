package com.example.elitebook.employeeclient.ui.employees.create;

import com.example.elitebook.employeeclient.ui.base.BasePresenter;
import com.example.elitebook.employeeclient.ui.base.BaseView;

public interface CreateEmployeeContract {

    interface View extends BaseView{

        Long getId();
        String getName();

    }

    interface Presenter extends BasePresenter<View>{
        void createEmployee();
        void updateEmployee();
    }
}
