package com.example.weatherapp.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.weatherapp.R;

public class Utility {
    public static String CURRENT_TEMPERATURE = "";
    static ProgressDialog progressDialog = null;

    public static void showProgress(Context context){
        try {
            if (context != null) {

                if (progressDialog != null && progressDialog.isShowing()) {
                    return;
                }

                progressDialog = ProgressDialog.show(context, null, null);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                progressDialog.setContentView(R.layout.progress_bar);


            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void hideProgress(){
        try {
            if(progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
