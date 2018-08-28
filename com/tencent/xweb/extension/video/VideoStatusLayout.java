package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.xwalk.core.R;

public class VideoStatusLayout extends RelativeLayout {
    private int duration = 1000;
    private ImageView hDT;
    private VideoDotPercentIndicator vBd;
    private TextView vBe;
    private TextView vBf;
    private LinearLayout vBg;
    private a vBh;

    public VideoStatusLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.show_change_layout, this);
        this.hDT = (ImageView) findViewById(R.id.image_xweb_video_status);
        this.vBd = (VideoDotPercentIndicator) findViewById(R.id.progress_xweb_video_status);
        this.vBe = (TextView) findViewById(R.id.tv_progress);
        this.vBf = (TextView) findViewById(R.id.text_xweb_video_status);
        this.vBg = (LinearLayout) findViewById(R.id.layout_xweb_video_status);
        this.vBh = new a(this, (byte) 0);
        setVisibility(8);
    }

    public final void show() {
        setVisibility(0);
        removeCallbacks(this.vBh);
        postDelayed(this.vBh, (long) this.duration);
    }

    public void setVolumnProgress(int i) {
        this.vBd.setProgress((float) i);
        this.vBd.setVisibility(0);
        this.vBf.setText(R.string.xweb_video_volume);
        this.vBg.setVisibility(0);
        this.hDT.setImageResource(R.drawable.xweb_video_volume_icon);
        this.vBe.setVisibility(8);
    }

    public void setBrightProgress(int i) {
        this.vBd.setProgress((float) i);
        this.vBd.setVisibility(0);
        this.vBf.setText(R.string.xweb_video_brightness);
        this.vBg.setVisibility(0);
        this.hDT.setImageResource(R.drawable.xweb_video_brightness_icon);
        this.vBe.setVisibility(8);
    }

    public void setVideoTimeProgress(String str) {
        this.vBe.setText(str);
        this.vBe.setVisibility(0);
        this.vBg.setVisibility(8);
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setImageResource(int i) {
        this.hDT.setImageResource(i);
    }
}
