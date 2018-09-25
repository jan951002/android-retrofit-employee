package com.example.elitebook.employeeclient.ui.employees.get;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elitebook.employeeclient.R;
import com.example.elitebook.employeeclient.data.model.Employee;

import java.util.List;
import java.util.Random;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesViewHolder> {

    private List<Employee> employees;
    private OnItemClickListener listener;
    private SwipeRefreshLayout swipeRefreshLayout;

    public EmployeesAdapter(List<Employee> employees, OnItemClickListener listener,
                            SwipeRefreshLayout swipeRefreshLayout) {
        this.employees = employees;
        this.listener = listener;
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    @Override
    public EmployeesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.cardview_employee, parent, false);

        return new EmployeesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EmployeesViewHolder holder, int position) {
        holder.bind(employees.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }



    interface OnItemClickListener {
        void onItemClick(Employee item);

        void onItemLongClick(Employee item);
    }
}
