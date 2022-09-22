package com.example.metacogroup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class NursePanelRecycleHolder extends RecyclerView.ViewHolder {
    public TextView list_name,list_family,list_vaziat,list_room;
    public ImageView list_profile,list_danger;
    public NursePanelRecycleHolder(View show) {
        super(show);
        list_name=show.findViewById(R.id.name_setting);
        list_family=show.findViewById(R.id.family_setting);
        list_vaziat=show.findViewById(R.id.room_seting);
        list_room=show.findViewById(R.id.vasiat_setting);
        list_profile=show.findViewById(R.id.prof_image);
        list_danger=show.findViewById(R.id.danger);
    }



}