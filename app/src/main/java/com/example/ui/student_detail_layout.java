package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class student_detail_layout extends AppCompatActivity {

    TextView stu_detail_name;
    TextView stu_detail_phonenum;
    TextView stu_detail_mssv;
    TextView stu_detail_mail;
    ImageView stu_detail_face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail_layout);

        addContent();
        addEvent();

    }

    private void addEvent() {
        Intent intent = getIntent();
        student_info data = (student_info) intent.getSerializableExtra("stu");
        Picasso.get().load(data.getFace()).into(stu_detail_face);
        stu_detail_name.setText(data.getName());
        stu_detail_phonenum.setText(data.getPhonenum());
        stu_detail_mail.setText(data.getEmail());
        stu_detail_mssv.setText(data.getMssv());

    }

    private void addContent() {
        stu_detail_face = findViewById(R.id.stu_detail_face);
        stu_detail_phonenum = findViewById(R.id.stu_detail_phonenum);
        stu_detail_name = findViewById(R.id.stu_detail_name);
        stu_detail_mail = findViewById(R.id.stu_detail_mail);
        stu_detail_mssv = findViewById(R.id.stu_detail_mssv);
    }
}
