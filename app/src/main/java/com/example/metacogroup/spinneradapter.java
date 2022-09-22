package com.example.metacogroup;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class spinneradapter extends ArrayAdapter<saeidian_klid2> {
    int i=0;
    ArrayList<saeidian_klid2> List;
    Context  context2;
    public spinneradapter(Context context,
                            ArrayList<saeidian_klid2> saeidian_klid)
    {

        super(context, 0, saeidian_klid);
        context2 =context;
        List=saeidian_klid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,
                          ViewGroup parent)
    {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_spinner_profile, parent, false);
        }

         TextView name,family,emtiaz,vaziat,tedadbimaran,code_personally;
         ImageView profile_pic;

        name=convertView.findViewById(R.id.name_prof);
        family=convertView.findViewById(R.id.family_prof);
        vaziat=convertView.findViewById(R.id.vasiat_prof);
        tedadbimaran=convertView.findViewById(R.id.tedad_bimaran);
        emtiaz=convertView.findViewById(R.id.emtiaz_prof);
        code_personally=convertView.findViewById(R.id.code_personaly);
        //profile_pic=convertView.findViewById(R.id.profile_pic);


        name.setText(List.get(position).name);
        family.setText(List.get(position).family);
        vaziat.setText(List.get(position).vaziat);
        emtiaz.setText(List.get(position).emtiaz);
        code_personally.setText(List.get(position).code_personally);
        tedadbimaran.setText(List.get(position).tedadbimaran);
        code_personally.setText(List.get(position).code_personally);
        //profile_pic.setImageResource(R.drawable.user);

        return convertView;
    }
}
