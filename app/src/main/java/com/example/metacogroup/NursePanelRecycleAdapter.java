package com.example.metacogroup;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class NursePanelRecycleAdapter extends RecyclerView.Adapter<NursePanelRecycleHolder> {
    int i=0;
    private ArrayList<NursepPanelRecycleClass> saeidian_list;
    public NursePanelRecycleAdapter(ArrayList<NursepPanelRecycleClass> Data) {
        saeidian_list = Data;
    }
    @Override
    public NursePanelRecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recycle_adapter, parent, false);
        NursePanelRecycleHolder holder = new NursePanelRecycleHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final NursePanelRecycleHolder holder, @SuppressLint("RecyclerView") final int position) {

       // holder.list_info.setOnClickListener(view ->

       // {
//            i++;
//            if(i%2==0)
//            {
//                holder.list_phone.setVisibility(View.GONE);
//            }
//            if(i%2==1)
//            {
//                holder.list_phone.setVisibility(View.VISIBLE);
//            }

       // });
       holder.list_name.setText((saeidian_list.get(position).getName()));
        holder.list_family.setText((saeidian_list.get(position).getFamily()));
        holder.list_room.setText((saeidian_list.get(position).getRoom()));
        holder.list_vaziat.setText((saeidian_list.get(position).getVaziat()));
        holder.list_profile.setImageResource((saeidian_list.get(position).getProfile()));
        holder.list_danger.setImageResource((saeidian_list.get(position).getDanger()));


    }
    @Override
    public int getItemCount() {
        return 5;
    }
}