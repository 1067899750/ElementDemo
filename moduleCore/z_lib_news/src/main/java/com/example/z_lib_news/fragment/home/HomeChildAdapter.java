package com.example.z_lib_news.fragment.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.z_lib_news.R;

import java.util.ArrayList;

/**
 * @author puyantao
 * @describe
 * @create 2019/11/5 17:18
 */
public class HomeChildAdapter extends RecyclerView.Adapter<HomeChildAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<String> mDates;

    public HomeChildAdapter(Context context, ArrayList<String> dates) {
        mContext = context;
        mDates = dates;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(mContext).inflate(R.layout.news_home_child_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.mTextView.setText(mDates.get(i));
    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textName);
        }
    }





}






















