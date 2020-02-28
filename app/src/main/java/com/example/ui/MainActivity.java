package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.transition.Transition;
import android.view.animation.AnimationUtils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CardView cdv_schedule, cdv_members, cdv_teacher, cdv_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addContent();
        addEvent();

    }

    private void addContent() {
        cdv_schedule = findViewById(R.id.cdv_schedule);
        cdv_members = findViewById(R.id.cdv_members);
        cdv_teacher = findViewById(R.id.cdv_teacher);
        cdv_course = findViewById(R.id.cdv_course);
    }

    private void addEvent() {
        cdv_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scheduleintent = new Intent(MainActivity.this, schedule.class);
                startActivity(scheduleintent);
            }
        });
        cdv_members.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent memberintent = new Intent(MainActivity.this, listStudent.class);
                startActivity(memberintent);
            }
        });
        cdv_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent teacherintent = new Intent(MainActivity.this, teacher.class);
                startActivity(teacherintent);
            }
        });
    }
}
