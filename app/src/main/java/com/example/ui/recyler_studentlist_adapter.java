package com.example.ui;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class recyler_studentlist_adapter extends RecyclerView.Adapter<recyler_studentlist_adapter.myHolder> implements Filterable {

    ArrayList<student_info> mlist;
    ArrayList<student_info> mlistFilterd;
    Context mcontext;

    public recyler_studentlist_adapter(ArrayList<student_info> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
        this.mlistFilterd = mlist;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.student_info_item, parent, false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, final int position) {
        Picasso.get().load(mlistFilterd.get(position).getFace()).into(holder.student_face_item);
        holder.student_face_item.setAnimation(AnimationUtils.loadAnimation(mcontext, R.anim.anim_translate));
        holder.student_name_item.setText(mlistFilterd.get(position).getName());
        holder.student_phonenum_item.setText(mlistFilterd.get(position).getPhonenum());
        holder.student_mssv_item.setText(mlistFilterd.get(position).getMssv());
        holder.container_stu.setAnimation(AnimationUtils.loadAnimation(mcontext, R.anim.anim_translate));
        holder.container_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent studetail = new Intent(mcontext, student_detail_layout.class);
                studetail.putExtra("stu", mlistFilterd.get(position));
                mcontext.startActivity(studetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlistFilterd.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String key = charSequence.toString();

                if(key.isEmpty()){
                    mlistFilterd = mlist;
                } else {
                    ArrayList<student_info>mlistTemp = new ArrayList<>();
                    for (student_info filter : mlist) {
                        if (filter.getName().toLowerCase().contains(key.toLowerCase())){
                            mlistTemp.add(filter);
                        }
                    }
                    mlistFilterd = mlistTemp;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mlistFilterd;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mlistFilterd = (ArrayList<student_info>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class myHolder extends RecyclerView.ViewHolder {

        ImageView student_face_item;
        TextView student_name_item;
        TextView student_phonenum_item;
        TextView student_mssv_item;
        RelativeLayout container_stu;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            container_stu = itemView.findViewById(R.id.container_stu);
            student_face_item = itemView.findViewById(R.id.student_face_item);
            student_name_item = itemView.findViewById(R.id.student_name_item);
            student_phonenum_item = itemView.findViewById(R.id.student_phonenum_item);
            student_mssv_item = itemView.findViewById(R.id.student_mssv_item);
        }
    }
}
