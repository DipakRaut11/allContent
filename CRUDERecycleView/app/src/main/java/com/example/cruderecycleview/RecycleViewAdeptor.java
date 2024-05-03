package com.example.cruderecycleview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecycleViewAdeptor extends RecyclerView.Adapter<RecycleViewAdeptor.viewHolder> {
    Context context;
    ArrayList<contact> arrContact;
    RecycleViewAdeptor(Context context, ArrayList<contact> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }


    @NonNull
    //alt+enter and implement in RecyclerView.Adapter<RecycleContactAdapter.viewHolder> for override
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null; by default after doing alt+enter

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

        // Update code

        holder.IIRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update);


                EditText updateName, updateContact;
                Button updateButton;
                updateName = dialog.findViewById(R.id.updateName);
                updateContact = dialog.findViewById(R.id.updateContact);
                updateButton = dialog.findViewById(R.id.UpdateButton);
                TextView txtTitle = dialog.findViewById(R.id.txtTitle);

                txtTitle.setText("Update Contact");
                updateButton.setText("Update");

                updateName.setText((arrContact.get(position)).name);
                updateContact.setText((arrContact.get(position)).number);
                updateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = updateName.getText().toString();
                        String Contact = updateContact.getText().toString();

                        if (name.isEmpty()) {
                            Toast.makeText(context, "Enter name", Toast.LENGTH_SHORT).show();
                            return; // Exit the method if name is empty
                        }  if (Contact.isEmpty()) {
                            Toast.makeText(context, "Enter Contact", Toast.LENGTH_SHORT).show();
                            return; // Exit the method if contact is empty
                        }


                        //dummy image uses
                        arrContact.set(position,new contact(R.drawable.ic_launcher_foreground,name, Contact));
                        notifyItemChanged(position);
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });
        //Delete
        holder.IIRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder Builder = new AlertDialog.Builder(context).setTitle("Delete Contact")
                        .setMessage("Are you sure you want to delete this")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrContact.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //here we can also use toast message
                            }
                        });

                Builder.show();

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtNumber;
        ImageView imgContact;
        LinearLayout IIRow;
        public viewHolder(View itemView){
            super(itemView);

            txtName = itemView.findViewById(R.id.txtNumber);
            txtNumber = itemView.findViewById(R.id.txtNumber1);
            imgContact = itemView.findViewById(R.id.contImg);
            IIRow = itemView.findViewById(R.id.IIRow);
        }
    }
}

