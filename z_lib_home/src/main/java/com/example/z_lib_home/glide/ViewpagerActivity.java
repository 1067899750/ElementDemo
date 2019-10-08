package com.example.z_lib_home.glide;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.z_lib_common.base.activity.BaseActionBarActivity;
import com.example.z_lib_common.imageloader.config.ScaleMode;
import com.example.z_lib_common.imageloader.loader.ImageLoader;
import com.example.z_lib_home.R;
import com.example.z_lib_home.glide.config.ImageConfig;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/8 9:34
 */
public class ViewpagerActivity extends BaseActionBarActivity {
    private ViewPager viewPager;

    @Override
    protected int setLayoutId() {
        return R.layout.home_activity_viewpager;
    }


    @Override
    protected void initViews() {
        viewPager =  findViewById(R.id.viewpager);
    }

    @Override
    protected void initDate() {
        List<String> urls = new ArrayList<>();
        ArrayList<View> views = new ArrayList<>();
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359324536&di=f1c2dfd6b0ebe0043f089d933d5d9e10&imgtype=0&src=http%3A%2F%2Fyouimg1.c-ctrip.com%2Ftarget%2Ffd%2Ftg%2Fg1%2FM02%2FFE%2FB5%2FCghzfFSrqqCATzfcACG0aD33PsY070.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359343773&di=9fc5478b63f369090613c1c27d56f237&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201510%2F04%2F20151004210446_usmze.jpeg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359365740&di=f02eadaa956bef73d64cf9fb86969228&imgtype=0&src=http%3A%2F%2Fupload4.hlgnet.com%2Fbbsupfile%2F2012%2F2012-07-17%2F20120717003503_80.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359415501&di=2457a1060f3ccde0bd7f7b5d0891918d&imgtype=0&src=http%3A%2F%2Fdimg09.c-ctrip.com%2Fimages%2Ffd%2Ftg%2Fg2%2FM03%2FCB%2F19%2FCghzf1UualCAdMmaABQVh70n7_g185.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359451818&di=b3031652757061d8d9a681e824c8a9e5&imgtype=0&src=http%3A%2F%2Flvyou.panjin.net%2Ffjpic%2F1299485962.jpg");

        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490954196&di=9d3311b40886fc2c670a31f7ba1edb68&imgtype=jpg&er=1&src=http%3A%2F%2Fdimg05.c-ctrip.com%2Fimages%2Ffd%2Ftg%2Fg2%2FM0B%2FCB%2F14%2FCghzgFUuapGABMHyACKrkXeB1zo976.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359527096&di=ec923d22df64850456fa01de50540ed3&imgtype=0&src=http%3A%2F%2Ffile28.mafengwo.net%2FM00%2F38%2FEB%2FwKgB6lTHUrKAMiRNABF8ZlX_qGY71.jpeg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490954377&di=c037874ec1de4ad2528708b89123ffb9&imgtype=jpg&er=1&src=http%3A%2F%2Ffile27.mafengwo.net%2FM00%2F44%2FFA%2FwKgB6lTHYfuAGx8tAAyTEuzr7rQ63.jpeg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359641404&di=f0e34cfcfd8789ad6fdddf28ad7dc49b&imgtype=0&src=http%3A%2F%2Ffile27.mafengwo.net%2FM00%2F23%2FFC%2FwKgB6lSBlHCAa62UAAt4XAl0sUc50.jpeg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490359621573&di=fe03f67cb5b06f8961ceb8e21ca07db7&imgtype=0&src=http%3A%2F%2Ffile21.mafengwo.net%2FM00%2F7B%2F55%2FwKgB3FDF162Afrj8ACtU8-OAkZ484.jpeg");


        for (int i = 0; i < urls.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            ImageLoader.with(this)
                    .url(ImageConfig.URL1)
                    .placeHolder(R.mipmap.ic_launcher)
                    .scale(ScaleMode.FIT_CENTER)
                    .into(imageView);
            views.add(imageView);
        }

        PagerAdapterForBigImage adapter = new PagerAdapterForBigImage(views);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //viewPager.destroyDrawingCache();
//        ImageLoader.clearAllMemoryCaches();//调了没用,也不需要调,下次进来自动会刷新内存
    }

    @Override
    protected String setTitle() {
        return getResources().getString(R.string.home_title_activity_fragment_module);
    }

}
