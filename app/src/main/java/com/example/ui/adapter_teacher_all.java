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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class adapter_teacher_all extends RecyclerView.Adapter<adapter_teacher_all.myHolder> {

    ArrayList<teacher_info> mlist;
    Context mcontext;

    public adapter_teacher_all(ArrayList<teacher_info> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.teacher_info_item, parent, false);

        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        holder.teacher_name_item.setText(mlist.get(position).getName());
        holder.teacher_phonenum_item.setText(mlist.get(position).getPhonenum());
        holder.teacher_email_item.setText(mlist.get(position).getEmail());
        Picasso.get().load(mlist.get(position).getFace()).into(holder.teacher_face_item);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {

        ImageView teacher_face_item;
        TextView teacher_name_item;
        TextView teacher_phonenum_item;
        TextView teacher_email_item;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            teacher_email_item = itemView.findViewById(R.id.teacher_email_item);
            teacher_face_item = itemView.findViewById(R.id.teacher_face_item);
            teacher_name_item = itemView.findViewById(R.id.teacher_name_item);
            teacher_phonenum_item = itemView.findViewById(R.id.teacher_phonenum_item);
        }
    }
}
