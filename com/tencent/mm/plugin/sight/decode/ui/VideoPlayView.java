package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.ak.a.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class VideoPlayView extends RelativeLayout implements a, f {
    private String dXA;
    private int duration = 0;
    private ag dvh = new ag();
    private ProgressBar eWx;
    public View gFD;
    private boolean hEj = false;
    public f hEl = null;
    private int ndV = 320;
    private int ndW = 240;
    private boolean ndX = true;
    private a ndY;
    private ViewGroup ndZ;
    public a nea;
    private double neb = 0.0d;
    public TextView nec;
    public String ned = "";
    private View nee;
    public boolean neg = true;
    private int neh = 0;
    private int nei = 0;
    private boolean nej = false;
    private boolean nek = false;
    private long nel = 0;
    private Animation nem = new AlphaAnimation(1.0f, 0.0f);
    private Animation nen = new AlphaAnimation(0.0f, 1.0f);
    private Runnable neo = new 4(this);
    public int nep = 0;
    public ImageView tnq;

    static /* synthetic */ void m(VideoPlayView videoPlayView) {
        if (videoPlayView.nee.getVisibility() == 0) {
            videoPlayView.bvY();
        } else {
            videoPlayView.bvX();
        }
    }

    public void setVideoPath(String str) {
        this.dXA = str;
        x.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[]{this.dXA});
        this.hEl.setVideoPath(this.dXA);
    }

    public void setVideoPlayViewEvent(a aVar) {
        this.ndY = aVar;
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.nem.setDuration(200);
        this.nen.setDuration(200);
        View.inflate(getContext(), com.tencent.mm.plugin.ak.a.f.video_play_view, this);
        this.nee = findViewById(e.play_close_btn);
        this.tnq = (ImageView) findViewById(e.menu_btn);
        this.tnq.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
        this.eWx = (ProgressBar) findViewById(e.progressbar);
        this.ndZ = (ViewGroup) findViewById(e.video_container);
        this.hEl = o.fb(getContext());
        this.hEl.setLoop(false);
        this.ndZ.addView((View) this.hEl, 0, new LayoutParams(-1, -1));
        this.nec = (TextView) findViewById(e.show_ad_sight);
        this.gFD = this.nec;
        this.hEl.setVideoCallback(new 1(this));
        if (this.hEl instanceof VideoSightView) {
            ((VideoSightView) this.hEl).setEnableConfigChanged(false);
        }
        setOnTouchListener(new 2(this));
        bvY();
        ((View) this.hEl).post(new 3(this));
    }

    public void setVideoTotalTime(int i) {
        if (this.nea.getVideoTotalTime() != i) {
            this.nea.setVideoTotalTime(i);
        }
    }

    public void setIsDownloading(boolean z) {
        this.nej = z;
        if (this.hEl != null && (this.hEl instanceof VideoSightView)) {
            VideoSightView videoSightView = (VideoSightView) this.hEl;
            if (videoSightView.getController() != null) {
                videoSightView.getController().ncE = !z;
            }
        }
    }

    public final void bvW() {
        this.eWx.setVisibility(0);
    }

    private void bvX() {
        ((View) this.nea).setVisibility(0);
        this.nee.setVisibility(0);
        if (this.neg) {
            this.tnq.setVisibility(0);
        }
        int i = this.nep == 2 ? 0 : bi.oW(this.ned) ? 0 : 1;
        if (i != 0) {
            this.gFD.setVisibility(0);
        }
        this.dvh.removeCallbacks(this.neo);
        this.dvh.postDelayed(this.neo, 3000);
    }

    public final void bvY() {
        if (this.nea != null) {
            ((View) this.nea).setVisibility(4);
        }
        this.nee.setVisibility(8);
        this.tnq.setVisibility(8);
        this.gFD.setVisibility(8);
    }

    public void setLeftButtonOnClickListener(OnClickListener onClickListener) {
        this.nee.setOnClickListener(onClickListener);
    }

    public void setRightButtonOnCliclListener(OnClickListener onClickListener) {
        this.tnq.setOnClickListener(onClickListener);
    }

    public final boolean start() {
        hL(true);
        return true;
    }

    public final void pause() {
        we(-1);
    }

    private void hL(boolean z) {
        this.hEl.x(this.neb);
        this.hEl.start();
        x.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.neb);
        if (this.ndY != null) {
            this.ndY.hM(z);
        }
    }

    private void we(int i) {
        this.neb = i >= 0 ? (double) i : this.hEl.getLastProgresstime();
        x.i("MicroMsg.VideoPlayView", "pause play " + this.neb + " lastTime: " + i + " last " + this.hEl.getLastProgresstime());
        this.hEl.pause();
        this.dvh.post(new 7(this));
        if (this.ndY != null) {
            this.ndY.bvZ();
        }
    }

    public final boolean isPlaying() {
        return this.hEl.isPlaying();
    }

    public String getVideoPath() {
        return this.dXA;
    }

    public final boolean q(Context context, boolean z) {
        return this.hEl.q(context, z);
    }

    public final void stop() {
        this.hEl.stop();
    }

    public final void onDetach() {
        this.hEl.onDetach();
    }

    public void setLoop(boolean z) {
        this.hEl.setLoop(z);
    }

    public double getLastProgresstime() {
        return Math.max(this.neb, this.hEl.getLastProgresstime());
    }

    public void setVideoCallback(f.a aVar) {
        this.hEl.setVideoCallback(aVar);
    }

    public int getCurrentPosition() {
        return this.hEl.getCurrentPosition();
    }

    public int getDuration() {
        if (this.duration == 0) {
            return this.hEl.getDuration();
        }
        return this.duration;
    }

    public void setThumb(Bitmap bitmap) {
        this.hEl.setThumb(bitmap);
    }

    public final void x(double d) {
        this.hEl.x(d);
        this.nea.seek((int) d);
    }

    public void setPlayProgressCallback(boolean z) {
        this.hEl.setPlayProgressCallback(z);
    }

    /* renamed from: update */
    public final void e(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.nek = true;
        if (this.nei == 0 || this.neh == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.nei = displayMetrics.heightPixels;
            this.neh = displayMetrics.widthPixels;
            if (this.nei < this.neh) {
                this.nei = displayMetrics.widthPixels;
                this.neh = displayMetrics.heightPixels;
            }
            x.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.nei + " screen_width:" + this.neh);
        }
        ViewGroup.LayoutParams layoutParams2 = this.ndZ.getLayoutParams();
        if (this.nea == null) {
            layoutParams = null;
        } else {
            layoutParams = (LayoutParams) ((View) this.nea).getLayoutParams();
        }
        ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        if (i == 1) {
            layoutParams3.width = this.neh;
            layoutParams3.height = (int) (((((double) this.neh) * 1.0d) * ((double) this.ndW)) / ((double) this.ndV));
            if (this.nea != null) {
                layoutParams.bottomMargin = b.b(getContext(), 0.0f);
            }
        } else {
            layoutParams3.height = this.neh;
            layoutParams3.width = (int) (((((double) this.neh) * 1.0d) * ((double) this.ndV)) / ((double) this.ndW));
            if (this.nea != null) {
                layoutParams.bottomMargin = b.b(getContext(), 0.0f);
            }
        }
        if (this.nea != null) {
            this.nea.bvT();
            ((View) this.nea).setLayoutParams(layoutParams);
            if (this.nea instanceof AdVideoPlayerLoadingBar) {
                this.dvh.postDelayed(new 8(this), 500);
            }
        }
        x.i("MicroMsg.VideoPlayView", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.hEl).setLayoutParams(layoutParams3);
        if (this.hEl instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.hEl).dt(layoutParams3.width, layoutParams3.height);
        }
        layoutParams2.height = layoutParams3.height;
        layoutParams2.width = layoutParams3.width;
        this.ndZ.setLayoutParams(layoutParams2);
        ((View) this.hEl).requestLayout();
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        this.hEj = z;
    }

    public final void d(double d, boolean z) {
        x(d);
    }

    public void setOneTimeVideoTextureUpdateCallback(f.e eVar) {
    }

    public void setOnSeekCompleteCallback(c cVar) {
    }

    public void setOnInfoCallback(f.b bVar) {
    }

    public void setOnSurfaceCallback(d dVar) {
    }
}
