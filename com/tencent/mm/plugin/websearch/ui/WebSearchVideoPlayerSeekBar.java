package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.websearch.ui.a.c;
import com.tencent.mm.plugin.websearch.ui.a.d;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.sdk.platformtools.x;

public class WebSearchVideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements g {
    protected boolean bPb = false;
    private float fto;
    private int pNg = -1;
    private int pNh = -1;
    private int pNi = -1;

    public WebSearchVideoPlayerSeekBar(Context context) {
        super(context);
    }

    public WebSearchVideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebSearchVideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init() {
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.ndi = (ImageView) this.contentView.findViewById(c.player_progress_bar_front);
        this.ndj = (ImageView) this.contentView.findViewById(c.player_progress_bar_background);
        this.ndk = (ImageView) this.contentView.findViewById(c.player_progress_point);
        this.ndl = (ImageView) this.contentView.findViewById(c.play_btn);
        this.ndm = (TextView) this.contentView.findViewById(c.play_current_time_tv);
        this.ndn = (TextView) this.contentView.findViewById(c.play_total_time_tv);
        this.ndk.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int g;
                if (motionEvent.getAction() == 0) {
                    x.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
                    WebSearchVideoPlayerSeekBar.this.fTW = false;
                    WebSearchVideoPlayerSeekBar.this.fto = motionEvent.getX();
                    WebSearchVideoPlayerSeekBar.this.ndr = (float) ((LayoutParams) WebSearchVideoPlayerSeekBar.this.ndk.getLayoutParams()).leftMargin;
                    if (WebSearchVideoPlayerSeekBar.this.ndh != null) {
                        WebSearchVideoPlayerSeekBar.this.ndh.ajO();
                    }
                } else if (motionEvent.getAction() == 2) {
                    x.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", new Object[]{Float.valueOf(motionEvent.getX() - WebSearchVideoPlayerSeekBar.this.fto)});
                    WebSearchVideoPlayerSeekBar.this.yk((int) ((r0 - WebSearchVideoPlayerSeekBar.this.fto) + ((float) WebSearchVideoPlayerSeekBar.this.getCurProgressBarLen())));
                    g = WebSearchVideoPlayerSeekBar.this.getCurTimeByProgressBar();
                    WebSearchVideoPlayerSeekBar.this.ndm.setText(AdVideoPlayerLoadingBar.kT(g / 60) + ":" + AdVideoPlayerLoadingBar.kT(g % 60));
                    WebSearchVideoPlayerSeekBar.this.fTW = true;
                } else {
                    x.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch up");
                    g = WebSearchVideoPlayerSeekBar.this.mPosition;
                    if (WebSearchVideoPlayerSeekBar.this.fTW) {
                        g = WebSearchVideoPlayerSeekBar.this.mPosition = WebSearchVideoPlayerSeekBar.this.getCurTimeByProgressBar();
                    }
                    if (WebSearchVideoPlayerSeekBar.this.ndh != null) {
                        x.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "current time : " + g);
                        WebSearchVideoPlayerSeekBar.this.ndh.kV(g);
                    }
                    WebSearchVideoPlayerSeekBar.this.fTW = false;
                }
                return true;
            }
        });
        this.ndk.addOnLayoutChangeListener(new 2(this));
        this.ndj.addOnLayoutChangeListener(new 3(this));
    }

    private int getCurTimeByProgressBar() {
        return (int) (((((double) getCurProgressBarLen()) * 1.0d) / ((double) getBarLen())) * ((double) this.ndo));
    }

    private int getCurProgressBarLen() {
        return this.ndi.getWidth();
    }

    protected int getBarPointWidth() {
        if (this.pNg == -1) {
            this.pNg = this.ndk.getWidth();
        }
        return this.pNg;
    }

    private int getBarPointPaddingLeft() {
        if (this.pNh == -1) {
            this.pNh = this.ndk.getPaddingLeft();
        }
        return this.pNh;
    }

    private int getBarPointPaddingRight() {
        if (this.pNi == -1) {
            this.pNi = this.ndk.getPaddingRight();
        }
        return this.pNi;
    }

    public int getBarLen() {
        return this.ndj.getWidth();
    }

    public int getLayoutId() {
        return d.video_player_seek_bar;
    }

    public ImageView getPlayBtn() {
        return this.ndl;
    }

    public TextView getPlaytimeTv() {
        return this.ndm;
    }

    public final void seek(int i) {
        x.d("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "seek position : " + i);
        if (i < 0) {
            i = 0;
        }
        if (i >= this.ndo) {
            i = this.ndo;
        }
        if (this.mPosition != i) {
            this.mPosition = i;
            ajV();
        }
    }

    public void setVideoTotalTime(int i) {
        this.ndo = i;
        this.mPosition = 0;
        this.ndn.setText(AdVideoPlayerLoadingBar.kT(this.ndo / 60) + ":" + AdVideoPlayerLoadingBar.kT(this.ndo % 60));
        ajV();
    }

    public final void ajV() {
        if (this.ndo != 0 && !this.fTW && this.ndk != null && getBarLen() != 0) {
            if (this.mPosition == this.ndo) {
                x.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "test");
            }
            this.ndm.setText(AdVideoPlayerLoadingBar.kT(this.mPosition / 60) + ":" + AdVideoPlayerLoadingBar.kT(this.mPosition % 60));
            int i = this.mPosition;
            i = i <= 0 ? 0 : i >= this.ndo ? getBarLen() : (int) (((((double) i) * 1.0d) / ((double) this.ndo)) * ((double) getBarLen()));
            yk(i);
        }
    }

    public void yk(int i) {
        int barLen;
        if (i > getBarLen()) {
            i = getBarLen();
        } else if (i < 0) {
            i = 0;
        }
        LayoutParams layoutParams = (LayoutParams) this.ndk.getLayoutParams();
        if (i > getBarLen()) {
            barLen = getBarLen();
        } else {
            barLen = i;
        }
        layoutParams.leftMargin = (((LayoutParams) this.ndj.getLayoutParams()).leftMargin + barLen) - (getBarPointWidth() >>> 1);
        this.ndk.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.ndi.getLayoutParams();
        layoutParams.width = i;
        this.ndi.setLayoutParams(layoutParams);
        this.ndk.requestLayout();
        this.ndi.requestLayout();
    }

    public void setPlayBtnOnClickListener(OnClickListener onClickListener) {
        if (this.ndl != null) {
            this.ndl.setOnClickListener(onClickListener);
        }
    }

    public void setIsPlay(boolean z) {
        this.bPb = z;
        super.setIsPlay(z);
    }

    public void wQ(int i) {
        seek(i);
    }

    public final void jQ(boolean z) {
        setIsPlay(z);
    }
}
