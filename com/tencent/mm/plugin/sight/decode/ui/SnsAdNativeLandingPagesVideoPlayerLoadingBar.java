package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ak.a$e;
import com.tencent.mm.plugin.ak.a$g;
import com.tencent.mm.plugin.ak.a.f;
import com.tencent.mm.sdk.platformtools.x;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar extends RelativeLayout implements a {
    private boolean bPb = false;
    private View contentView = null;
    private boolean fTW = false;
    private int mPosition = 0;
    private b ndh = null;
    private ImageView ndi;
    private ImageView ndj = null;
    private ImageView ndk = null;
    private ImageView ndl = null;
    private TextView ndm;
    private TextView ndn;
    private int ndo = 0;
    private int ndp = 0;
    private float ndr = 0.0f;
    private int nds = -1;
    private int ndt = -1;
    private int ndu = -1;
    private int ndv = -1;

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setIplaySeekCallback(b bVar) {
        this.ndh = bVar;
    }

    private void init() {
        this.contentView = View.inflate(getContext(), f.sns_ad_natvie_landingpages_video_player_loading_bar, this);
        this.ndi = (ImageView) this.contentView.findViewById(a$e.player_progress_bar_front);
        this.ndj = (ImageView) this.contentView.findViewById(a$e.player_progress_bar_background);
        this.ndk = (ImageView) this.contentView.findViewById(a$e.player_progress_point);
        this.ndl = (ImageView) this.contentView.findViewById(a$e.play_btn);
        this.ndm = (TextView) this.contentView.findViewById(a$e.play_current_time_tv);
        this.ndn = (TextView) this.contentView.findViewById(a$e.play_total_time_tv);
        this.ndk.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    x.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.fTW = false;
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndr = motionEvent.getX();
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndh != null) {
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndh.ajO();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndk.getLayoutParams();
                    layoutParams.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, ((int) (x - SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndr)) + layoutParams.leftMargin);
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndk.setLayoutParams(layoutParams);
                    int d = SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndo > 0) {
                        layoutParams = (LayoutParams) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndi.getLayoutParams();
                        layoutParams.width = (int) (((((double) d) * 1.0d) / ((double) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndo)) * ((double) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.getBarLen()));
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndi.setLayoutParams(layoutParams);
                    }
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndm.setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.kT(d / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.kT(d % 60));
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.fTW = true;
                } else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.fTW) {
                    int d2 = SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndh != null) {
                        x.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : " + d2);
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.ndh.kV(d2);
                    }
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.fTW = false;
                }
                return true;
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!(i == this.nds && i2 == this.ndt && i3 == this.ndu && i4 == this.ndv)) {
            ajV();
        }
        this.nds = i;
        this.ndt = i2;
        this.ndu = i3;
        this.ndv = i4;
    }

    public void setOnPlayButtonClickListener(OnClickListener onClickListener) {
        this.ndl.setOnClickListener(onClickListener);
    }

    public void setIsPlay(boolean z) {
        this.bPb = z;
        if (z) {
            this.ndl.setImageResource(a$g.media_player_pause_btn);
        } else {
            this.ndl.setImageResource(a$g.media_player_play_btn);
        }
    }

    public boolean getIsPlay() {
        return this.bPb;
    }

    private int getCurrentTimeByBarPoint() {
        int paddingLeft = (int) (((((double) (((LayoutParams) this.ndk.getLayoutParams()).leftMargin - (((LayoutParams) this.ndj.getLayoutParams()).leftMargin - this.ndk.getPaddingLeft()))) * 1.0d) / ((double) getBarLen())) * ((double) this.ndo));
        if (paddingLeft < 0) {
            return 0;
        }
        return paddingLeft;
    }

    public final void seek(int i) {
        this.mPosition = i;
        ajV();
    }

    public int getVideoTotalTime() {
        return this.ndo;
    }

    public void setVideoTotalTime(int i) {
        if (this.ndk.isShown() && this.ndk.getWidth() == 0) {
            post(new 2(this, i));
            return;
        }
        this.ndo = i;
        this.mPosition = 0;
        this.ndn.setText(kT(this.ndo / 60) + ":" + kT(this.ndo % 60));
        ajV();
    }

    private int getBarLen() {
        this.ndp = this.ndj.getWidth();
        return this.ndp;
    }

    public final void bvT() {
        this.ndp = 0;
    }

    private void ajV() {
        if (this.ndo != 0 && !this.fTW && this.ndk != null && getBarLen() != 0) {
            int width = ((this.ndk.getWidth() - this.ndk.getPaddingLeft()) - this.ndk.getPaddingRight()) / 2;
            this.ndm.setText(kT(this.mPosition / 60) + ":" + kT(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.ndk.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.ndj.getLayoutParams()).leftMargin - this.ndk.getPaddingLeft()) + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.ndo)) * ((double) getBarLen())))) - width;
            this.ndk.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.ndi.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.ndo)) * ((double) getBarLen()));
            this.ndi.setLayoutParams(layoutParams);
        }
    }

    public static String kT(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }
}
