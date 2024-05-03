package com.example.recycleviewanimation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.animation.AnimationUtils;
//import com.google.android.material.animation.AnimationUtils;

import java.util.ArrayList;

public class RecycleViewAdaptor extends RecyclerView.Adapter<RecycleViewAdaptor.viewHolder> {
    Context context;
    ArrayList<contact> arrContact;

    private int lastPosition = -1;
    RecycleViewAdaptor(Context context, ArrayList<contact> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //we have to pass value
        View v = LayoutInflater.from(context).inflate(R.layout.contact, parent, false);
        viewHolder ViewHolder = new viewHolder(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContact.get(position).img);
        holder.txtName.setText(arrContact.get(position).name);
        holder.txtNumber.setText(arrContact.get(position).number);

        //Animation
        setAnimation(holder.itemView, position);


    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtNumber;
        ImageView imgContact;
        LinearLayout IIRow;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtNumber);
            txtNumber = itemView.findViewById(R.id.txtNumber1);
            imgContact = itemView.findViewById(R.id.contImg);
            IIRow = itemView.findViewById(R.id.IIRow);
        }
    }

    //Animation
    private void setAnimation(View view, int position){

        /*for not repeating animation repetadely if condition is use, animation
        appears when app is open for first time , if if is not use the animation appears
                repetadely*/
        if (position>lastPosition) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(slideIn);

            lastPosition = position;
        }
    }
}
