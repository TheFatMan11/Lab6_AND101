package com.thuydev.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class bai31 extends AppCompatActivity {

    String a = null;
    String b =null;


    ActivityResultLauncher getData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {


                       if(result.getResultCode()==2){
                           Intent intent = result.getData();
                           Bundle bundle =intent.getExtras();
                           EditText user = findViewById(R.id.txt_User);
                           EditText pass = findViewById(R.id.txt_Pass);
                           a = bundle.getString("user");
                           b = bundle.getString("pass");
                          if(a!=null&&b!=null){
                               user.setText(a);
                               pass.setText(b);
                           }



                       }
                   }

            }
    );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai31);



        Button bnt = findViewById(R.id.btn_login);
        Button bnt1 = findViewById(R.id.btn_dk);
        EditText user = findViewById(R.id.txt_User);
        EditText pass = findViewById(R.id.txt_Pass);
        bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bai31.this, bai32.class);

                getData.launch(intent);
            }
        });


        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUser = user.getText().toString();
                String sPass = pass.getText().toString();
                if(sUser.equals(a)&&sPass.equals(b)){
                   Intent intent = new Intent(bai31.this,Adapter_sinhvien.class);
                   startActivity(intent);

                }else {
                    Toast.makeText(bai31.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
          }


}