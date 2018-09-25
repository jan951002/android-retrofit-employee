package com.example.elitebook.employeeclient.ui.employees.get;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.elitebook.employeeclient.R;
import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.ui.employees.create.CreateEmployeeActivity;
import com.example.elitebook.employeeclient.ui.employees.get.GetEmployeesContract;
import com.example.elitebook.employeeclient.ui.employees.get.GetEmployeesPresenter;
import com.example.elitebook.employeeclient.ultils.IntentHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GetEmployeesActivity extends AppCompatActivity implements GetEmployeesContract.View,
        EmployeesAdapter.OnItemClickListener {

    @BindView(R.id.recycler_employee)
    RecyclerView recyclerEmployee;
    @BindView(R.id.fab_create_employee)
    FloatingActionButton btnCreateEmployee;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;

    private GetEmployeesContract.Presenter presenter;
    private EmployeesAdapter employeesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerEmployee.setLayoutManager(mLayoutManager);
        recyclerEmployee.setItemAnimator(new DefaultItemAnimator());
        presenter = new GetEmployeesPresenter();
        presenter.attachView(this);
        btnCreateEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentHelper.goToCreateEmployeeActivity(GetEmployeesActivity.this, null);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        presenter.getEmployees();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getEmployees();
    }

    @Override
    public void showEmployees(List<Employee> employees) {
        employeesAdapter = new EmployeesAdapter(employees, this, swipeRefreshLayout);
        recyclerEmployee.setAdapter(employeesAdapter);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void onItemClick(Employee item) {
        IntentHelper.goToCreateEmployeeActivity(this, item);
    }

    @Override
    public void onItemLongClick(final Employee item) {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want remove this employee?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        presenter.removeEmployee(item.getId());
                    }
                })
                .setNegativeButton("No", null)
                .show();
        presenter.getEmployees();
    }

    private void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.getEmployees();
                employeesAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}
