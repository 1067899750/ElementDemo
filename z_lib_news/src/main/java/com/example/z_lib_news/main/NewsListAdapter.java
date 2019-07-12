package com.example.z_lib_news.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.z_lib_news.R;
import com.example.z_lib_news.data.bean.Story;
import com.example.z_lib_news.detail.NewsDetailActivity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;


/**
 * <p>类说明</p>
 */
public class NewsListAdapter extends RecyclerArrayAdapter<Story> {

    public NewsListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsListHolder(parent);
    }

    private class NewsListHolder extends BaseViewHolder<Story> {

        private TextView mTextView;
        private ImageView mImageView;

        NewsListHolder(ViewGroup parent) {
            super(parent, R.layout.news_item_news_list);
            mTextView = $(R.id.news_title);
            mImageView = $(R.id.news_image);
        }

        @Override
        public void setData(final Story data) {
            super.setData(data);
            mTextView.setText(data.getTitle());
            Glide.with(getContext())
                    .load(data.getImages()[0])
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(mImageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), NewsDetailActivity.class);
                    intent.putExtra("id", data.getId());
                    getContext().startActivity(intent);
                }
            });
        }
    }
}
