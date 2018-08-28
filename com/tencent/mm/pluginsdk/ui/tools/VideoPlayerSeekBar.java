package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.ae.a.a;
import com.tencent.mm.plugin.ae.a.b;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;

public class VideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements g {
    public boolean bPb = false;
    private int pNg = -1;
    private int pNh = -1;
    private int pNi = -1;
    private PInt qTw = new PInt();

    static /* synthetic */ int a(VideoPlayerSeekBar videoPlayerSeekBar, int i, PInt pInt) {
        int barPointPaddingLeft = ((LayoutParams) videoPlayerSeekBar.ndj.getLayoutParams()).leftMargin - videoPlayerSeekBar.getBarPointPaddingLeft();
        pInt.value = (int) (((((double) (i - barPointPaddingLeft)) * 1.0d) / ((double) videoPlayerSeekBar.getBarLen())) * ((double) videoPlayerSeekBar.ndo));
        if (pInt.value <= 0) {
            pInt.value = 0;
            return i - barPointPaddingLeft > barPointPaddingLeft ? i - barPointPaddingLeft : barPointPaddingLeft;
        } else if (pInt.value < videoPlayerSeekBar.ndo) {
            return i - barPointPaddingLeft;
        } else {
            pInt.value = videoPlayerSeekBar.ndo;
            return videoPlayerSeekBar.getBarLen() - (((videoPlayerSeekBar.getBarPointWidth() - videoPlayerSeekBar.getBarPointPaddingLeft()) - videoPlayerSeekBar.getBarPointPaddingRight()) / 2);
        }
    }

    public VideoPlayerSeekBar(Context context) {
        super(context);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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

    public final int eB(int i, int i2) {
        if (i <= 0) {
            this.ndj.getLayoutParams();
            return 0;
        } else if (i >= this.ndo) {
            return i2 - (((getBarPointWidth() - getBarPointPaddingLeft()) - getBarPointPaddingRight()) / 2);
        } else {
            return (int) (((((double) i) * 1.0d) / ((double) this.ndo)) * ((double) i2));
        }
    }

    public int getLayoutId() {
        return b.video_player_seek_bar;
    }

    public ImageView getPlayBtn() {
        return this.ndl;
    }

    public TextView getPlaytimeTv() {
        return this.ndm;
    }

    public final void seek(int i) {
        x.d("MicroMsg.VideoPlayerSeekBar", "seek position : " + i);
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
        this.ndn.setText(kT(this.ndo / 60) + ":" + kT(this.ndo % 60));
        ajV();
    }

    public void ajV() {
        if (this.ndo != 0 && !this.fTW && this.ndk != null && getBarLen() != 0) {
            this.ndm.setText(kT(this.mPosition / 60) + ":" + kT(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.ndk.getLayoutParams();
            int barLen = getBarLen();
            layoutParams.leftMargin = eB(this.mPosition, barLen);
            this.ndk.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.ndi.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.ndo)) * ((double) barLen));
            this.ndi.setLayoutParams(layoutParams);
            requestLayout();
        }
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

    public final void wQ(int i) {
        seek(i);
    }

    public final void jQ(boolean z) {
        setIsPlay(z);
    }
}
