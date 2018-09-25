package com.example.elitebook.employeeclient.ultils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.elitebook.employeeclient.EmployeeClientApplication;
import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.ui.employees.create.CreateEmployeeActivity;

public class IntentHelper {

    public static void goToCreateEmployeeActivity(AppCompatActivity activity, Employee employee) {
        Intent intent = new Intent(EmployeeClientApplication.getAppContext(), CreateEmployeeActivity.class);
        intent.putExtra(IntentConstants.KEY_OBJECT_CREATE_EMPLOYEE, employee);
        activity.startActivity(intent);
    }

}
