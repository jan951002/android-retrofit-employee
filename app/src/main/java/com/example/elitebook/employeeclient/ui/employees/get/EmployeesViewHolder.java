package com.example.elitebook.employeeclient.ui.employees.get;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.elitebook.employeeclient.R;
import com.example.elitebook.employeeclient.data.model.Employee;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_employee_id)
    TextView txtEmployeeId;
    @BindView(R.id.txt_employee_name)
    TextView txtEmployeeName;

    public EmployeesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Employee employee, final EmployeesAdapter.OnItemClickListener listener) {
        txtEmployeeId.setText(employee.getId().toString());
        txtEmployeeName.setText(employee.getName());
        setOnClickListener(employee, listener);
        setOnLongClickListener(employee, listener);
    }

    private void setOnClickListener(final Employee employee,
                                    final EmployeesAdapter.OnItemClickListener listener) {

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(employee);
            }
        });
    }

    private void setOnLongClickListener(final Employee employee,
                                        final EmployeesAdapter.OnItemClickListener listener) {

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onItemLongClick(employee);
                return true;
            }
        });
    }
}
