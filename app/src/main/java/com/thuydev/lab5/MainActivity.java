package com.thuydev.lab5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    int bien = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai11);

        ArrayList<modle_location> location1 = new ArrayList<>();
        spinner = findViewById(R.id.sp_Location);

        location1.add(new modle_location("Hà nội", R.drawable.logo_ha_noi));
        location1.add(new modle_location("Hồ chí minh", R.drawable.hcm_icn));
        location1.add(new modle_location("Tây nguyên", R.drawable.tn_icon));
        location1.add(new modle_location("Cần thơ", R.drawable.ct_icon));
        location1.add(new modle_location("Đà nẵng", R.drawable.danang_icon));

        Adapter_location adapter = new Adapter_location(this, location1);
        spinner.setAdapter(adapter);

        Button button = findViewById(R.id.btn_login);
        EditText ten = findViewById(R.id.txt_ten);
        EditText diachi = findViewById(R.id.txt_diachia);
        TextView teuDe = findViewById(R.id.tv_tieude);
        Intent intent = getIntent();

        String td = intent.getStringExtra(Adapter_location.KEY_SV);
        teuDe.setText(td);

        modle_sinhvien sv = (modle_sinhvien) getIntent().getSerializableExtra(Adapter_location.KEY_List);
        if (sv != null) {
            ten.setText(sv.getName().toString());
            diachi.setText(sv.getLocation().toString());
            int i = location1.indexOf(sv.getLocation());
            spinner.setSelection(i);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = spinner.getSelectedItemPosition();
                String sTen = ten.getText().toString();
                String sDiachi = diachi.getText().toString();
                String sCoSo = location1.get(index).getName();


                Intent intent = new Intent();
                Bundle bundle = new Bundle();

                if (!sTen.equals("") && !sDiachi.equals("") && !sCoSo.equals("")) {
                    bundle.putString(Adapter_location.KEY_TEN, sTen);
                    bundle.putString(Adapter_location.KEY_DIACHI, sDiachi);
                    bundle.putString(Adapter_location.KEY_COSO, sCoSo);
                    intent.putExtras(bundle);
                    setResult(2, intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}