package com.example.addressexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 멤버 변수 선언
    private ArrayList<Address> address_Arrlist = new ArrayList<Address>();

    private EditText name_edit;
    private EditText phone_edit;
    private EditText email_edit;

    private TextView name_txt;
    private TextView phone_txt;
    private TextView email_txt;

    private int arr_idx = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // App이 실행되면 변수 초기화
        name_edit = findViewById(R.id.edit_name);
        phone_edit = findViewById(R.id.edit_phone);
        email_edit = findViewById(R.id.edit_email);

        name_txt = findViewById(R.id.print_name);
        phone_txt = findViewById(R.id.print_phone);
        email_txt = findViewById(R.id.print_email);

    }

    // 버튼을 눌렀을 때 실행되는 메소드
    public void onClick(View v) {
        if(v.getId() == R.id.add_BTN) {
            if (email_edit.getText().toString().length() == 0 ||
                    name_edit.getText().toString().length() == 0 ||
                    phone_edit.getText().toString().length() == 0) {
                Toast.makeText(MainActivity.this,"내용을 입력해주세요", Toast.LENGTH_SHORT).show();
            }
            else {
                Address address = new Address(name_edit.getText().toString(),
                        phone_edit.getText().toString(),email_edit.getText().toString());
                address_Arrlist.add(address);

                arr_idx = address_Arrlist.size() - 1;

                name_txt.setText(address_Arrlist.get(arr_idx).getName());
                phone_txt.setText(address_Arrlist.get(arr_idx).getPhone_num());
                email_txt.setText(address_Arrlist.get(arr_idx).getE_mail());
                arr_idx++;

                name_edit.getText().clear();
                phone_edit.getText().clear();
                email_edit.getText().clear();

                Toast.makeText(MainActivity.this,"주소록에 추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() == R.id.view_BTN) {
            if (address_Arrlist.size() == 0) {
                Toast.makeText(MainActivity.this,"주소록이 비었습니다.", Toast.LENGTH_SHORT).show();
            }
            else {
                if (arr_idx == address_Arrlist.size())
                {
                    arr_idx = 0;
                }
                name_txt.setText(address_Arrlist.get(arr_idx).getName());
                phone_txt.setText(address_Arrlist.get(arr_idx).getPhone_num());
                email_txt.setText(address_Arrlist.get(arr_idx).getE_mail());
                arr_idx++;
            }
        }
        else if(v.getId() == R.id.del_BTN) {
            if (address_Arrlist.size() == 0)
            {
                Toast.makeText(MainActivity.this,"주소록이 비었습니다.", Toast.LENGTH_SHORT).show();
            }
            else {
                address_Arrlist.remove(--arr_idx);
                arr_idx --;
                if (address_Arrlist.size() == 0) {
                    arr_idx = 0;
                    name_txt.setText("");
                    phone_txt.setText("");
                    email_txt.setText("");
                }
                else {
                    if (arr_idx < 0) {
                        arr_idx = 0;
                    }
                    name_txt.setText(address_Arrlist.get(arr_idx).getName());
                    phone_txt.setText(address_Arrlist.get(arr_idx).getPhone_num());
                    email_txt.setText(address_Arrlist.get(arr_idx).getE_mail());
                    arr_idx++;
                }
            }
        }
    }
}