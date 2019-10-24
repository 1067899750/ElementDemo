package com.example.z_lib_girl.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.z_lib_girl.R;
import com.example.z_lib_girl.data.bean.Girls;
import com.example.z_lib_image.imageloader.config.ScaleMode;
import com.example.z_lib_image.imageloader.loader.ImageLoader;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


public class GirlsAdapter extends RecyclerArrayAdapter<Girls> {

    public OnMyItemClickListener mOnItemClickListener;

    public GirlsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GirlsViewHolder(parent);
    }

    @Override
    public void OnBindViewHolder(final BaseViewHolder holder, final int position) {
        super.OnBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position, holder);
                }
            }
        });
    }

    private class GirlsViewHolder extends BaseViewHolder<Girls> {

        private ImageView image;

        private GirlsViewHolder(ViewGroup parent) {
            super(parent, R.layout.girl_item_girl);
            image = $(R.id.girl_img);
        }

        @Override
        public void setData(Girls data) {
            super.setData(data);
            ImageLoader.with(getContext())
                    .url(data.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeHolder(R.mipmap.ic_launcher)
                    .scale(ScaleMode.FIT_CENTER)
                    .into(image);
        }
    }

    public interface OnMyItemClickListener {
        void onItemClick(int position, BaseViewHolder holder);
    }

    public void setOnMyItemClickListener(OnMyItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
