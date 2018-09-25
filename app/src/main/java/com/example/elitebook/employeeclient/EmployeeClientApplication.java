package com.example.elitebook.employeeclient;

import android.app.Application;
import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeClientApplication extends Application {

    private final static String BASE_URL = "https://employee-soaint-db.herokuapp.com/";

    private static Retrofit mrRetrofit;
    private static EmployeeClientApplication appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        setAppContext(this);
        mrRetrofit = createRetrofit();

    }

    public static Retrofit getRetrofit(){
        return mrRetrofit;
    }

    public static EmployeeClientApplication getAppContext() {
        return appContext;
    }

    public static void setAppContext(EmployeeClientApplication appContext) {
        EmployeeClientApplication.appContext = appContext;
    }

    private static Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
