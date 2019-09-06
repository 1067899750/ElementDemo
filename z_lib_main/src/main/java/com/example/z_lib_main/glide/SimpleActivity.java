package com.example.z_lib_main.glide;

import android.animation.ObjectAnimator;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.example.z_lib_common.imageloader.config.Contants;
import com.example.z_lib_common.imageloader.config.PriorityMode;
import com.example.z_lib_common.imageloader.config.ScaleMode;
import com.example.z_lib_common.imageloader.imagei.ImageDownLoadCallBack;
import com.example.z_lib_common.imageloader.loader.ImageLoader;
import com.example.z_lib_common.imageloader.utils.DownLoadImageService;
import com.example.z_lib_main.R;
import com.example.z_lib_main.glide.config.ImageConfig;

import java.io.File;



public class SimpleActivity extends AppCompatActivity {

    private ImageView iv_test1;
    private ImageView iv_test2;
    private ImageView iv_test3;
    private ImageView iv_test4;
    private ImageView iv_test5;
    private ImageView iv_test6;
    private ImageView iv_test7;
    private ImageView iv_test8;
    private ImageView iv_test9;
    private ImageView iv_test10;
    private ImageView iv_test11;
    private ImageView iv_test12;
    private ImageView iv_test13;
    private ImageView iv_test14;
    private ImageView iv_test15;

    private static final String TAG = SimpleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_sample);

        findview();

        load();
    }

    private void findview() {
        iv_test1 = (ImageView) findViewById(R.id.iv_test1);
        iv_test2 = (ImageView) findViewById(R.id.iv_test2);
        iv_test3 = (ImageView) findViewById(R.id.iv_test3);
        iv_test4 = (ImageView) findViewById(R.id.iv_test4);
        iv_test5 = (ImageView) findViewById(R.id.iv_test5);
        iv_test6 = (ImageView) findViewById(R.id.iv_test6);
        iv_test7 = (ImageView) findViewById(R.id.iv_test7);
        iv_test8 = (ImageView) findViewById(R.id.iv_test8);
        iv_test9 = (ImageView) findViewById(R.id.iv_test9);
        iv_test10 = (ImageView) findViewById(R.id.iv_test10);
        iv_test11 = (ImageView) findViewById(R.id.iv_test11);
        iv_test12 = (ImageView) findViewById(R.id.iv_test12);
        iv_test13 = (ImageView) findViewById(R.id.iv_test13);
        iv_test14 = (ImageView) findViewById(R.id.iv_test14);
        iv_test15 = (ImageView) findViewById(R.id.iv_test15);
    }

    private void load() {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                view.setAlpha(0f);

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
                fadeAnim.setDuration(2500);
                fadeAnim.start();
            }
        };

        ImageLoader.with(this)
                .url(ImageConfig.URL1)
                .animate(animationObject)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.CENTER_CROP)
                .into(iv_test1);

        ImageLoader.with(this)
                .url(ImageConfig.URL1)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test2);

        ImageLoader.with(this)
                .res(R.drawable.ads)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test3);

//        Glide.with(this).load(ImageConfig.URL4).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .into(iv_test3);

        ImageLoader.with(this)
                .url(ImageConfig.URL4)
                .placeHolder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test4);

        ImageLoader.with(this)
                .url(ImageConfig.URL3)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test5);

        ImageLoader.with(this)
                .url(ImageConfig.URL5)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test6);

        ImageLoader.with(this)
                .res(R.drawable.gif_test)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test7);

        ImageLoader.with(this)
                .res(R.drawable.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test8);

        ImageLoader.with(this)
                .res(R.drawable.b000)
                .vignetteFilter()
                .priority(PriorityMode.PRIORITY_NORMAL)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
//                .ignoreCertificateVerify()
                .into(iv_test9);

        ImageLoader.with(this)
                .res(R.drawable.b000)
                .sketchFilter()
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test10);

//        ImageLoader.with(this)
//                .content("content://media/external/images/media/"+getContentId())
//                .placeHolder(R.mipmap.ic_launcher)
//                .scale(ScaleMode.FIT_CENTER)
//                .into(iv_test10);

        ImageLoader.with(this)
                .file("file://" + Environment.getExternalStorageDirectory().getPath() + Contants.FOREWARD_SLASH + ImageConfig.IMG_NAME)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test11);


        ImageLoader.with(this)
                .file(new File(getFilesDir(), ImageConfig.IMG_NAME_C))
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test12);

        ImageLoader.with(this)
                .asserts(Contants.ASSERTS_PATH + ImageConfig.IMG_NAME_C)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .rectRoundCorner(50)
                .into(iv_test13);

        ImageLoader.with(this)
                .raw(Contants.ANDROID_RESOURCE + getPackageName() + Contants.RAW + R.raw.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .asCircle()
                .into(iv_test14);

        ImageLoader.with(this)
                .raw(Contants.ANDROID_RESOURCE + getPackageName() + Contants.RAW + R.raw.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .asSquare()
                .into(iv_test15);

        ImageLoader.saveImageIntoGallery(new DownLoadImageService(SimpleActivity.this, ImageConfig.URL3, true, "lala", new ImageDownLoadCallBack() {

            @Override
            public void onDownLoadSuccess(Bitmap bitmap) {
                Log.e(TAG, "下载图片成功 bitmap");
            }

            @Override
            public void onDownLoadFailed() {
                Log.e(TAG, "下载图片失败");
            }

        }));
    }

    public long getContentId() {
        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        long aLong = 0;
        if (cursor != null && cursor.moveToFirst()) {
            aLong = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
        }

        return aLong;
    }


}
