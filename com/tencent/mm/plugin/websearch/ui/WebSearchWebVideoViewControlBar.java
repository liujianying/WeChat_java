package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.websearch.ui.a.a;
import com.tencent.mm.plugin.websearch.ui.a.c;
import com.tencent.mm.plugin.websearch.ui.a.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public class WebSearchWebVideoViewControlBar extends WebSearchVideoPlayerSeekBar {
    private static int gba = -1;
    private ImageView gaP;
    private ImageView gaS;
    private FrameLayout gaU;
    private al gaW;
    private al gaX;
    public boolean gaY;
    private ImageView pNk;
    public RelativeLayout pNl;
    private ImageView pNm;
    private a pNn;

    public WebSearchWebVideoViewControlBar(Context context) {
        super(context);
    }

    public WebSearchWebVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebSearchWebVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStatePorter(a aVar) {
        this.pNn = aVar;
    }

    public final void onDestroy() {
        if (this.gaX != null) {
            this.gaX.SO();
        }
        if (this.gaW != null) {
            this.gaW.SO();
        }
    }

    public int getLayoutId() {
        return a$d.fts_web_videoview_control_bar;
    }

    public void init() {
        super.init();
        this.gaP = (ImageView) this.contentView.findViewById(c.full_screen_btn);
        this.pNk = (ImageView) this.contentView.findViewById(c.voice_btn);
        this.gaS = (ImageView) this.contentView.findViewById(c.player_progress_bar_middle);
        this.gaU = (FrameLayout) this.contentView.findViewById(c.player_progress_root);
        this.pNl = (RelativeLayout) findViewById(c.root);
        this.pNm = (ImageView) this.contentView.findViewById(c.exit_fullscreen_btn);
        if (gba < 0) {
            gba = getResources().getDimensionPixelSize(a.fts_web_video_progress_bar_margin_right);
        }
    }

    public void setIsPlay(boolean z) {
        this.bPb = z;
        ajP();
    }

    protected int getBarPointWidth() {
        return this.ndk.getWidth();
    }

    private void ajP() {
        if (this.gaY) {
            if (this.bPb) {
                this.ndl.setImageResource(a$b.fts_pause_btn);
            } else {
                this.ndl.setImageResource(a$b.fts_video_play_btn);
            }
        } else if (this.bPb) {
            this.ndl.setImageResource(a$b.fts_pause_btn);
        } else {
            this.ndl.setImageResource(a$b.fts_video_play_btn);
        }
    }

    public final void Bo() {
        this.pNk.setImageResource(a$b.fts_video_unmute_op_btn);
    }

    public final void bTu() {
        this.pNk.setImageResource(a$b.fts_video_mute_op_btn);
    }

    public void setMuteBtnOnClickListener(OnClickListener onClickListener) {
        this.pNk.setOnClickListener(onClickListener);
    }

    public void setEnterFullScreenBtnClickListener(OnClickListener onClickListener) {
        this.gaP.setOnClickListener(onClickListener);
    }

    public void setExitFullScreenBtnClickListener(OnClickListener onClickListener) {
        this.pNm.setOnClickListener(onClickListener);
    }

    public void iD(boolean z) {
        setVisibility(0);
        if (z) {
            bTz();
        } else {
            bTA();
        }
        if (this.gaW == null) {
            this.gaW = new al(new 1(this), false);
        }
        this.gaW.SO();
        this.gaW.J(2000, 2000);
    }

    public final void bTv() {
        if (this.gaW != null) {
            this.gaW.SO();
        }
    }

    public final void bTw() {
        if (this.gaW != null) {
            this.gaW.SO();
            this.gaW.J(2000, 2000);
        }
    }

    public final void jR(boolean z) {
        if ((getVisibility() == 0 ? 1 : null) != null) {
            setVisibility(8);
        } else {
            iD(z);
        }
    }

    public void bIz() {
        this.gaY = true;
        ajT();
    }

    public void ajc() {
        this.gaY = false;
        ajT();
    }

    private void ajT() {
        LayoutParams layoutParams = this.pNl.getLayoutParams();
        if (this.gaY) {
            layoutParams.height = getResources().getDimensionPixelSize(a.fts_web_video_fullscreen_control_bar_height);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(a.fts_web_video_control_bar_height);
        }
        this.pNl.setLayoutParams(layoutParams);
        if (this.gaY) {
            this.gaP.setImageResource(e.fts_web_video_fullscreen_op_fullscreen_btn);
            this.gaP.setVisibility(8);
            this.pNm.setVisibility(0);
        } else {
            this.pNm.setVisibility(8);
            this.gaP.setVisibility(0);
            this.gaP.setImageResource(a$b.fts_video_fullscreen_op_btn);
        }
        ajP();
        float dimensionPixelSize = this.gaY ? (float) getResources().getDimensionPixelSize(a.fts_web_video_fullscreen_control_bar_time_textsize) : (float) getResources().getDimensionPixelSize(a.fts_web_video_control_bar_time_textsize);
        this.ndm.setTextSize(0, dimensionPixelSize);
        this.ndn.setTextSize(0, dimensionPixelSize);
    }

    public final void bTx() {
        if (this.gaX == null) {
            this.gaX = new al(new 2(this), true);
        }
        ajU();
        this.gaX.SO();
        this.gaX.J(500, 500);
    }

    public final void bTy() {
        if (this.gaX != null) {
            this.gaX.SO();
        }
    }

    private boolean ajU() {
        if (this.pNn == null) {
            x.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
            return false;
        }
        int ajH = this.pNn.ajH();
        int ajI = this.pNn.ajI();
        if (ajH < 0 || ajI < 0) {
            return false;
        }
        int width = this.gaU.getWidth();
        if (width <= 0) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gaS.getLayoutParams();
        if (ajI != 0) {
            width = (int) (((float) width) * (1.0f - (((float) ajH) / ((float) ajI))));
        }
        if (width <= 0) {
            width = 0;
        }
        layoutParams.rightMargin = width + gba;
        this.gaS.setLayoutParams(layoutParams);
        if (ajH < ajI || ajI == 0) {
            return true;
        }
        return false;
    }

    public final void bTz() {
        this.ndl.setVisibility(8);
    }

    public final void bTA() {
        this.ndl.setVisibility(0);
    }

    public final void wQ(int i) {
        seek((int) Math.ceil((((double) this.pNn.bIw()) * 1.0d) / 1000.0d));
    }

    public ImageView getExitFullscreenIv() {
        return this.pNm;
    }
}
