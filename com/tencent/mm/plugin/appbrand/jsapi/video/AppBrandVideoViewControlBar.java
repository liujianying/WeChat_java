package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s$e;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public class AppBrandVideoViewControlBar extends VideoPlayerSeekBar {
    private static int gba = -1;
    private ImageView gaP;
    private ImageView gaQ;
    private LinearLayout gaR;
    private ImageView gaS;
    private TextView gaT;
    private FrameLayout gaU;
    private b gaV;
    al gaW;
    al gaX;
    boolean gaY;
    boolean gaZ;

    static /* synthetic */ void a(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        appBrandVideoViewControlBar.gaZ = !appBrandVideoViewControlBar.gaZ;
        appBrandVideoViewControlBar.ajQ();
    }

    public AppBrandVideoViewControlBar(Context context) {
        super(context);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStatePorter(b bVar) {
        this.gaV = bVar;
    }

    protected int getLayoutId() {
        return h.app_brand_videoview_control_bar;
    }

    protected final void init() {
        super.init();
        this.gaP = (ImageView) this.contentView.findViewById(g.full_screen_btn);
        this.gaQ = (ImageView) this.contentView.findViewById(g.danmaku_btn);
        this.gaS = (ImageView) this.contentView.findViewById(g.player_progress_bar_middle);
        this.gaU = (FrameLayout) this.contentView.findViewById(g.player_progress_root);
        this.gaT = (TextView) findViewById(g.live_tips_tv);
        this.gaR = (LinearLayout) findViewById(g.root);
        if (gba < 0) {
            gba = getResources().getDimensionPixelSize(s$e.app_brand_video_progress_bar_margin_right);
        }
    }

    public void setIsPlay(boolean z) {
        this.bPb = z;
        ajP();
    }

    private void ajP() {
        if (this.gaY) {
            if (this.bPb) {
                this.ndl.setImageResource(i.app_brand_video_fullscreen_stop_btn);
            } else {
                this.ndl.setImageResource(i.app_brand_video_fullscreen_play_btn);
            }
        } else if (this.bPb) {
            this.ndl.setImageResource(i.app_brand_video_stop_btn);
        } else {
            this.ndl.setImageResource(i.app_brand_video_play_btn);
        }
    }

    public void setFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        this.gaP.setOnClickListener(onClickListener);
    }

    public void setDanmakuBtnOnClickListener(a aVar) {
        this.gaQ.setOnClickListener(new 1(this, aVar));
    }

    public void setDanmakuBtnOpen(boolean z) {
        this.gaZ = z;
        ajQ();
    }

    private void ajQ() {
        if (this.gaY) {
            if (this.gaZ) {
                this.gaQ.setImageResource(i.app_brand_video_fullscreen_danmaku_showed_btn);
            } else {
                this.gaQ.setImageResource(i.app_brand_video_fullscreen_danmaku_hided_btn);
            }
        } else if (this.gaZ) {
            this.gaQ.setImageResource(i.app_brand_video_danmaku_showed_btn);
        } else {
            this.gaQ.setImageResource(i.app_brand_video_danmaku_hided_btn);
        }
    }

    public void setShowDanmakuBtn(boolean z) {
        if (z) {
            this.gaQ.setVisibility(0);
        } else {
            this.gaQ.setVisibility(8);
        }
    }

    public final void ajR() {
        setVisibility(0);
        if (this.gaW == null) {
            this.gaW = new al(new 2(this), false);
        }
        this.gaW.SO();
        this.gaW.J(7000, 7000);
    }

    public final void ajS() {
        if ((getVisibility() == 0 ? 1 : null) != null) {
            setVisibility(8);
        } else {
            ajR();
        }
    }

    public final void ajc() {
        this.gaY = false;
        ajT();
    }

    final void ajT() {
        LayoutParams layoutParams = this.gaR.getLayoutParams();
        if (this.gaY) {
            layoutParams.height = getResources().getDimensionPixelSize(s$e.app_brand_video_fullscreen_control_bar_height);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(s$e.app_brand_video_control_bar_height);
        }
        this.gaR.setLayoutParams(layoutParams);
        ajQ();
        if (this.gaY) {
            this.gaP.setImageResource(i.app_brand_video_fullscreen_op_fullscreen_btn);
        } else {
            this.gaP.setImageResource(i.app_brand_video_op_fullscreen_btn);
        }
        ajP();
        float dimensionPixelSize = this.gaY ? (float) getResources().getDimensionPixelSize(s$e.app_brand_video_fullscreen_control_bar_time_textsize) : (float) getResources().getDimensionPixelSize(s$e.app_brand_video_control_bar_time_textsize);
        this.ndm.setTextSize(0, dimensionPixelSize);
        this.ndn.setTextSize(0, dimensionPixelSize);
    }

    /* renamed from: ajU */
    final boolean d() {
        if (this.gaV == null) {
            x.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
            return false;
        }
        int ajH = this.gaV.ajH();
        int ajI = this.gaV.ajI();
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

    public final void ajV() {
        if (this.ndo != 0 && !this.fTW && this.ndk != null) {
            this.ndm.setText(kT(this.mPosition / 60) + ":" + kT(this.mPosition % 60));
            if (getBarLen() != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ndk.getLayoutParams();
                int barLen = getBarLen();
                layoutParams.leftMargin = eB(this.mPosition, barLen);
                this.ndk.setLayoutParams(layoutParams);
                layoutParams = (FrameLayout.LayoutParams) this.ndi.getLayoutParams();
                layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.ndo)) * ((double) barLen));
                this.ndi.setLayoutParams(layoutParams);
                requestLayout();
            }
        }
    }

    public void setShowLiveBtn(boolean z) {
        this.gaT.setVisibility(z ? 0 : 8);
    }

    public void setShowFullScreenBtn(boolean z) {
        this.gaP.setVisibility(z ? 0 : 8);
    }

    public void setShowPlayBtn(boolean z) {
        this.ndl.setVisibility(z ? 0 : 8);
    }

    public void setShowProgress(boolean z) {
        int i;
        int i2 = 0;
        FrameLayout frameLayout = this.gaU;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        frameLayout.setVisibility(i);
        TextView textView = this.ndm;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = this.ndn;
        if (!z) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
    }
}
