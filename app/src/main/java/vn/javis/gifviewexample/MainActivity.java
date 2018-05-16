package vn.javis.gifviewexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    GifImageView gitImgView;
    ImageView imgView;
    TextView txtView;
    Button btnStartDemo;
    Runnable runnable;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imgView = (ImageView)findViewById(R.id.imgMain);
        txtView = (TextView)findViewById(R.id.txtDesc);
        gitImgView = findViewById(R.id.gifImageView);
        btnStartDemo = (Button)findViewById(R.id.btnStartDemo);
        gitImgView.setBackgroundResource(R.drawable.tenor);


    }
    public static void ImageViewAnimatedChange(Context c, final TextView textView,final String s, final ImageView v, final int new_image) {
        final Animation anim_out = AnimationUtils.loadAnimation(c, android.R.anim.fade_out);
        final Animation anim_in  = AnimationUtils.loadAnimation(c, android.R.anim.fade_in);
        anim_out.setAnimationListener(new Animation.AnimationListener()
        {
            @Override public void onAnimationStart(Animation animation) {}
            @Override public void onAnimationRepeat(Animation animation) {}
            @Override public void onAnimationEnd(Animation animation)
            {   v.setBackgroundResource(new_image);
                v.setTag(new_image);
                textView.setText(s);
                anim_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override public void onAnimationStart(Animation animation) {}
                    @Override public void onAnimationRepeat(Animation animation) {}
                    @Override public void onAnimationEnd(Animation animation) {

                    }
                });
                v.startAnimation(anim_in);
                textView.startAnimation(anim_in);
            }
        });
        v.startAnimation(anim_out);
        textView.startAnimation(anim_out);

    }

    @Override
    protected void onResume() {
        super.onResume();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (imgView.getTag() != null && imgView.getTag().equals(R.drawable.searching))
                {
                    ImageViewAnimatedChange(getApplicationContext(),txtView,"Image 1",imgView,R.drawable.music);
                }else
                    ImageViewAnimatedChange(getApplicationContext(),txtView,"Image 2",imgView,R.drawable.searching);
            }

        };
        btnStartDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageViewAnimatedChange(getApplicationContext(),txtView,"Image 1",imgView,R.drawable.music);
                handler = new Handler();
                handler.postDelayed(runnable,1000);
            }
        });

    }


}
