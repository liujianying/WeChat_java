package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ae.a.a;
import com.tencent.mm.plugin.ae.a.b;
import com.tencent.mm.plugin.ae.a.c;

public class AdVideoPlayerLoadingBar extends RelativeLayout implements a {
    public View contentView = null;
    public boolean fTW = false;
    public int mPosition = 0;
    public b ndh = null;
    public ImageView ndi;
    public ImageView ndj = null;
    public ImageView ndk = null;
    public ImageView ndl = null;
    public TextView ndm;
    public TextView ndn;
    public int ndo = 0;
    private int ndp = 0;
    private int ndq = 0;
    public float ndr = 0.0f;
    private int nds = -1;
    private int ndt = -1;
    private int ndu = -1;
    private int ndv = -1;

    static /* synthetic */ int a(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar, int i) {
        int barPointWidth = ((adVideoPlayerLoadingBar.getBarPointWidth() - adVideoPlayerLoadingBar.ndk.getPaddingLeft()) - adVideoPlayerLoadingBar.ndk.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) adVideoPlayerLoadingBar.ndj.getLayoutParams();
        if (i < (layoutParams.leftMargin - adVideoPlayerLoadingBar.ndk.getPaddingLeft()) - barPointWidth) {
            return (layoutParams.leftMargin - adVideoPlayerLoadingBar.ndk.getPaddingLeft()) - barPointWidth;
        }
        if (i <= ((adVideoPlayerLoadingBar.getBarLen() + layoutParams.leftMargin) - barPointWidth) - adVideoPlayerLoadingBar.ndk.getPaddingLeft()) {
            return i;
        }
        return ((layoutParams.leftMargin + adVideoPlayerLoadingBar.getBarLen()) - barPointWidth) - adVideoPlayerLoadingBar.ndk.getPaddingLeft();
    }

    public AdVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int getLayoutId() {
        return b.video_player_loading_bar;
    }

    public void setIplaySeekCallback(b bVar) {
        this.ndh = bVar;
    }

    public void init() {
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.ndi = (ImageView) this.contentView.findViewById(a.player_progress_bar_front);
        this.ndj = (ImageView) this.contentView.findViewById(a.player_progress_bar_background);
        this.ndk = (ImageView) this.contentView.findViewById(a.player_progress_point);
        this.ndl = (ImageView) this.contentView.findViewById(a.play_btn);
        this.ndm = (TextView) this.contentView.findViewById(a.play_current_time_tv);
        this.ndn = (TextView) this.contentView.findViewById(a.play_total_time_tv);
        this.ndk.setOnTouchListener(new 1(this));
        this.ndk.post(new 2(this));
        LayoutParams layoutParams = (LayoutParams) this.ndi.getLayoutParams();
        layoutParams.width = 0;
        this.ndi.setLayoutParams(layoutParams);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.ndp = 0;
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
        if (z) {
            this.ndl.setImageResource(c.media_player_pause_btn);
        } else {
            this.ndl.setImageResource(c.media_player_play_btn);
        }
    }

    protected int getCurrentTimeByBarPoint() {
        return Math.max(0, (int) (((((double) ((((LayoutParams) this.ndk.getLayoutParams()).leftMargin - (((LayoutParams) this.ndj.getLayoutParams()).leftMargin - this.ndk.getPaddingLeft())) + (((getBarPointWidth() - this.ndk.getPaddingLeft()) - this.ndk.getPaddingRight()) / 2))) * 1.0d) / ((double) getBarLen())) * ((double) this.ndo)));
    }

    public void seek(int i) {
        this.mPosition = i;
        ajV();
    }

    public int getmPosition() {
        return this.mPosition;
    }

    public int getVideoTotalTime() {
        return this.ndo;
    }

    public void setVideoTotalTime(int i) {
        this.ndo = i;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new 3(this));
        } else {
            bvS();
        }
    }

    public final void bvS() {
        this.ndn.setText(kT(this.ndo / 60) + ":" + kT(this.ndo % 60));
        ajV();
    }

    public int getBarLen() {
        if (this.ndp <= 0) {
            this.ndp = this.ndj.getWidth();
        }
        return this.ndp;
    }

    public final void bvT() {
        this.ndp = 0;
    }

    public int getBarPointWidth() {
        if (this.ndq <= 0) {
            this.ndq = this.ndk.getWidth();
        }
        return this.ndq;
    }

    public void ajV() {
        if (this.ndo != 0 && !this.fTW && this.ndk != null && getBarLen() != 0) {
            int barPointWidth = ((getBarPointWidth() - this.ndk.getPaddingLeft()) - this.ndk.getPaddingRight()) / 2;
            this.ndm.setText(kT(this.mPosition / 60) + ":" + kT(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.ndk.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.ndj.getLayoutParams()).leftMargin - this.ndk.getPaddingLeft()) + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.ndo)) * ((double) getBarLen())))) - barPointWidth;
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
