package com.example.z_lib_girl.girl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.z_lib_girl.R;
import com.example.z_lib_girl.data.bean.Girls;
import com.example.z_lib_image.imageloader.loader.ImageLoader;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;


public class GirlAdapter extends PagerAdapter {

    private Context mContext;
    private List<Girls> mData;
    private LayoutInflater layoutInflater;
    private View mCurrentView;

    public GirlAdapter(Context context, List<Girls> data) {
        mContext = context;
        mData = data;
        layoutInflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentView = (View) object;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        final String imageUrl = mData.get(position).getUrl();
        View view = layoutInflater.inflate(R.layout.tools_item_detail, container, false);
        PhotoView imageView = (PhotoView) view.findViewById(R.id.girl_image);
        ImageLoader.with(mContext)
                .url(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeHolder(R.mipmap.ic_launcher)
                .thumbnail(0.2f)
                .into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public View getPrimaryItem() {
        return mCurrentView;
    }
}
