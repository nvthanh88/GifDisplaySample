package vn.javis.gifviewexample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GifImageView extends android.support.v7.widget.AppCompatImageView implements Runnable {
    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GifImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public void run() {

    }
}
