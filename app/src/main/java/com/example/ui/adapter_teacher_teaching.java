package com.example.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter_teacher_teaching extends RecyclerView.Adapter<adapter_teacher_teaching.myHolder> {

    ArrayList<teacher_info> mlist;
    Context mcontext;

    public adapter_teacher_teaching(ArrayList<teacher_info> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.teacher__teaching_info, parent, false);

        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        holder.teacher_name_item_teaching.setText(mlist.get(position).getName());
        holder.teacher_email_item_teaching.setText(mlist.get(position).getEmail());
        holder.teacher_phonenum_item_teaching.setText(mlist.get(position).getPhonenum());
        holder.teacher_course_item_teaching.setText(mlist.get(position).getCourse());
        Picasso.get().load(mlist.get(position).getFace()).into(holder.teacher_face_working);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class myHolder extends RecyclerView.ViewHolder{

        ImageView teacher_face_working;
        TextView teacher_name_item_teaching;
        TextView teacher_phonenum_item_teaching;
        TextView teacher_email_item_teaching;
        TextView teacher_course_item_teaching;

        public myHolder(@NonNull View itemView) {
            super(itemView);

            teacher_face_working = itemView.findViewById(R.id.teacher_face_working);
            teacher_name_item_teaching = itemView.findViewById(R.id.teacher_name_item_teaching);
            teacher_email_item_teaching = itemView.findViewById(R.id.teacher_email_item_teaching);
            teacher_phonenum_item_teaching = itemView.findViewById(R.id.teacher_phonenum_item_teaching);
            teacher_course_item_teaching = itemView.findViewById(R.id.teacher_course_item_teaching);

        }
    }
}
