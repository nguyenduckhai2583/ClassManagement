package com.example.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class teacher extends AppCompatActivity {

    ArrayList<teacher_info> mlist_teacher;
    ArrayList<teacher_info> mlist_teacher_teaching;

    adapter_teacher_all adapterTeacherAll;
    adapter_teacher_teaching adapterTeacherTeaching;

    RecyclerView recyler_teacherList;
    RecyclerView recyler_teachingList;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        addContent();
        addEvent();
     //   databaseReference.child("teacherInfo").push().setValue(new teacher_info("alo", "1", "2", "3","4"));

    }

    private void addEvent() {

        databaseReference.child("teacherInfo").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                teacher_info data = dataSnapshot.getValue(teacher_info.class);
                if(data.getCourse().length() > 0){
                    mlist_teacher_teaching.add(data);
                }
                else{
                    mlist_teacher.add(data);
                }
                adapterTeacherAll.notifyDataSetChanged();
                adapterTeacherTeaching.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void addContent() {
        mlist_teacher = new ArrayList<>();
        mlist_teacher_teaching = new ArrayList<>();

        adapterTeacherAll = new adapter_teacher_all(mlist_teacher, this);
        adapterTeacherTeaching = new adapter_teacher_teaching(mlist_teacher_teaching, this);

        recyler_teacherList = findViewById(R.id.recyler_teacherList);
        recyler_teachingList = findViewById(R.id.recyler_teachingList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyler_teacherList.setLayoutManager(linearLayoutManager);
        recyler_teacherList.setAdapter(adapterTeacherAll);

        recyler_teachingList.setLayoutManager(linearLayoutManager1);
        recyler_teachingList.setAdapter(adapterTeacherTeaching);

    }
}
