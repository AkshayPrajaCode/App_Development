package com.example.wscube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylerAdapterContact extends RecyclerView.Adapter<RecylerAdapterContact.viewHolder> {

    Context context;
  ArrayList<ContactMoodel> arrContact ;
    RecylerAdapterContact(Context context, ArrayList<ContactMoodel> arrContact){
        this.context=context;
        this.arrContact=arrContact;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View view  =  LayoutInflater.from(context).inflate(R.layout.contactrow,parent,false);
        viewHolder viewHolder= new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.imageContact.setImageResource(arrContact.get(position).img);
        holder.textName.setText(arrContact.get(position).name);
        holder.TextNumber.setText(arrContact.get(position).number);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class viewHolder extends RecyclerView.ViewHolder{
        TextView textName, TextNumber;
        ImageView imageContact;

        public viewHolder( View itemView) {
            super(itemView);
            textName= itemView.findViewById(R.id.textName);
            TextNumber= itemView.findViewById(R.id.textNumber);
            imageContact= itemView.findViewById(R.id.proimageContact);

        }
    }
}
