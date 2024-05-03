package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


    public class RecycleContactAdapter extends RecyclerView.Adapter<RecycleContactAdapter.viewHolder> {
    Context context;
    ArrayList<ContactModel> arrContact;
    RecycleContactAdapter(Context context, ArrayList<ContactModel> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }


    @NonNull
    //alt+enter and implement in RecyclerView.Adapter<RecycleContactAdapter.viewHolder> for over ride
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null; by default after doing alt+enter

        //we have to pass value
        View v = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        viewHolder ViewHolder = new viewHolder(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContact.get(position).img);
        holder.txtName.setText(arrContact.get(position).name);
        holder.txtNumber.setText(arrContact.get(position).number);
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtNumber;
        ImageView imgContact;
        public viewHolder(View itemView){
            super(itemView);

            txtName = itemView.findViewById(R.id.txtNumber);
            txtNumber = itemView.findViewById(R.id.txtNumber1);
            imgContact = itemView.findViewById(R.id.contImg);
        }
    }
}
