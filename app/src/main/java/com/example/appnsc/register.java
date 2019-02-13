package com.example.appnsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class register extends AppCompatActivity {
    private EditText editFname,editLname,editEmail,editDOB,editPassword;
    private Button btn_Summit;
    private RadioGroup radioGroup;
    private RadioButton radioButton,radioButton_Normal,radioButton_Disabled;
    private static final String URL = "http://10.0.2.2/Code_nsc/insertData.php";
    private String fname,lname,email,password,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        onBildView();
        btn_Summit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onEditText();
                onButtonClick();
            }
        });
    }

    private void onBildView() {
        editEmail = (EditText)findViewById(R.id.edit_email);
        editPassword = (EditText)findViewById(R.id.edit_pass);
        editFname = (EditText)findViewById(R.id.edit_fname);
        editLname = (EditText)findViewById(R.id.edit_lname);
        btn_Summit = (Button)findViewById(R.id.btn_summit);
        radioGroup = (RadioGroup)findViewById(R.id.radioGrp);
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        radioButton_Normal = (RadioButton)findViewById(R.id.radioN);
        radioButton_Disabled = (RadioButton)findViewById(R.id.radioD);
    }


//    public void checkButton(View v){
//        int radioId = radioGroup.getCheckedRadioButtonId();
//        radioButton = findViewById(radioId);
//        String id = String.valueOf(radioButton.getId());
//        Toast.makeText(register.this,id,Toast.LENGTH_SHORT).show();
//    }

    private void onEditText(){
        email = editEmail.getText().toString();
        password = editPassword.getText().toString();
        fname = editFname.getText().toString();
        lname = editLname.getText().toString();
       // int n = radioButton.getId();
        if (radioButton_Normal.isChecked()){
            status = "0";
        }
        else if (radioButton_Disabled.isChecked()){
            status = "1";
        }
    }

    private void onButtonClick(){
        if (!fname.isEmpty() && !lname.isEmpty() && !email.isEmpty() && !password.isEmpty() && !status.isEmpty()){
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("onResponse", response);
                    editEmail.setText("");
                    editPassword.setText("");
                    editFname.setText("");
                    editLname.setText("");
                    Toast.makeText(register.this, "เพิ่มข้อมูลเแล้ววววว", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("onError",error.toString());
                    Toast.makeText(register.this,"เกิดข้อผิดพลาด",Toast.LENGTH_SHORT).show();
                }
            })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError{
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("firstname",fname);
                    params.put("lastname",lname);
                    params.put("email",email);
                    params.put("password",password);
                    params.put("status",status);
                    return params;
                }
            };
            requestQueue.add(request);
            Intent it = new Intent(register.this,MainActivity.class);
            startActivity(it);
        }
        else{
            Toast.makeText(register.this, "กรุณากรอกข้อมูลให้ครบ", Toast.LENGTH_SHORT).show();
        }
    }

}
