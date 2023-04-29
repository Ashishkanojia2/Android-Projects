package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter  extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>{
 Context Context;
 ArrayList<ContactModel> arrayContact;
 RecyclerContactAdapter(Context context  , ArrayList<ContactModel> arrayContact){
     this.Context= context;
     this.arrayContact = arrayContact;
 }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View view =  LayoutInflater.from(Context).inflate(R.layout.contact_row,parent,false);
      ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.imgContact.setImageResource(arrayContact.get(position).image);
   holder.txtName.setText(arrayContact.get(position).name);
   holder.txtNumber.setText(arrayContact.get(position).number);


    }

    @Override
    public int getItemCount() {
        return arrayContact.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

     TextView txtName,txtNumber;
     ImageView imgContact;


        public ViewHolder(View itemView){
            super(itemView);

         txtName =itemView.findViewById(R.id.textView);
         txtNumber =itemView.findViewById(R.id.textView2);
            imgContact =itemView.findViewById(R.id.imageView2);


        }

    }
}
