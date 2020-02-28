package com.example.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class recyler_adapter extends RecyclerView.Adapter<recyler_adapter.myViewHolder> {

    Context mcontext;
    ArrayList<daySchedule> mlist;

    public recyler_adapter(Context mcontext, ArrayList<daySchedule> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.schedule_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.dayname.setText(mlist.get(position).getDayname());
        holder.morning_name_course_item.setText(mlist.get(position).getMorning_name_course_item());
        holder.morning_time_course_item.setText(mlist.get(position).getMorning_time_course_item());
        holder.afternoon_name_course_item.setText(mlist.get(position).getAfternoon_name_course_item());
        holder.afternoon_time_course_item.setText(mlist.get(position).getAfternoon_time_course_item());
        holder.container.setAnimation(AnimationUtils.loadAnimation(mcontext, R.anim.anim_scale));

        String weekday_name = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
        if(mlist.get(position).getDayname().equals(weekday_name)){
            holder.container.setBackgroundResource(R.drawable.bg_schedule_currentday);
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout container;
        TextView dayname;
        TextView morning_name_course_item;
        TextView morning_time_course_item;
        TextView afternoon_name_course_item;
        TextView afternoon_time_course_item;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            dayname = itemView.findViewById(R.id.dayname);
            morning_name_course_item = itemView.findViewById(R.id.morning_name_course_item);
            morning_time_course_item = itemView.findViewById(R.id.morning_time_course_item);
            afternoon_name_course_item = itemView.findViewById(R.id.afternoon_name_course_item);
            afternoon_time_course_item = itemView.findViewById(R.id.afternoon_time_course_item);
        }
    }
}
