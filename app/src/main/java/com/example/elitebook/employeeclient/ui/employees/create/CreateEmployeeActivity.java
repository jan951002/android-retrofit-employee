package com.example.elitebook.employeeclient.ui.employees.create;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.elitebook.employeeclient.R;
import com.example.elitebook.employeeclient.data.model.Employee;
import com.example.elitebook.employeeclient.ultils.IntentConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateEmployeeActivity extends AppCompatActivity implements CreateEmployeeContract.View{

    @BindView(R.id.txt_employee_id)
    EditText txtEmployeeId;
    @BindView(R.id.txt_employee_name)
    EditText txtEmployeeName;
    @BindView(R.id.btn_create_employee)
    Button btnCreateEmployee;

    private Employee employee;

    private CreateEmployeeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employee);
        this.presenter = new CreateEmployeePresenter();
        presenter.attachView(this);
        ButterKnife.bind(this);
        employee = (Employee) getIntent().getSerializableExtra(IntentConstants.KEY_OBJECT_CREATE_EMPLOYEE);
        if(employee != null){
            btnCreateEmployee.setText(getString(R.string.lab_edit_employee));
            txtEmployeeId.setEnabled(false);
            txtEmployeeId.setText(employee.getId().toString());
            txtEmployeeName.setText(employee.getName());
        }else{
            btnCreateEmployee.setText(getString(R.string.lab_create_employee));
            txtEmployeeId.setEnabled(true);
        }
    }

    @OnClick(R.id.btn_create_employee)
    public void onClickCreateEmployee(){
        if(employee != null){
            presenter.updateEmployee();
        }else{
            presenter.createEmployee();
        }
        onBackPressed();
    }

    @Override
    public Long getId() {
        return Long.valueOf(txtEmployeeId.getText().toString());
    }

    @Override
    public String getName() {
        return txtEmployeeName.getText().toString();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(String message) {

    }
}
