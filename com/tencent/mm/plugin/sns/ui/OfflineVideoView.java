package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class OfflineVideoView extends RelativeLayout implements a {
    private int aBN;
    private int duration;
    private ag hDf;
    private boolean hEj;
    public f hEl;
    private al hEr;
    private RelativeLayout jdF;
    private ImageView jdj;
    private boolean jfL;
    private boolean jfM;
    private ProgressBar jfO;
    private Context mContext;
    a nPe;
    private boolean nPf;
    private boolean nPg;
    private int nPh;
    private e nPi;

    public OfflineVideoView(Context context) {
        this(context, null);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.mContext = null;
        this.hEj = false;
        this.jfL = false;
        this.nPf = false;
        this.nPg = true;
        this.nPh = -1;
        this.aBN = 0;
        this.duration = 0;
        this.hDf = new ag(Looper.getMainLooper());
        this.hEr = new al(new al.a() {
            public final boolean vD() {
                if (OfflineVideoView.this.hEl == null) {
                    return false;
                }
                if (((View) OfflineVideoView.this.hEl).getAlpha() < 1.0f) {
                    OfflineVideoView.this.a(true, 1.0f);
                }
                if (OfflineVideoView.this.hEl.isPlaying()) {
                    OfflineVideoView.this.aYM();
                    OfflineVideoView offlineVideoView = OfflineVideoView.this;
                    int currentPosition = OfflineVideoView.this.hEl.getCurrentPosition() / 1000;
                    if (offlineVideoView.nPe != null) {
                        offlineVideoView.nPe.wQ(currentPosition);
                    }
                }
                return true;
            }
        }, true);
        this.nPi = new 8(this);
        this.mContext = context;
        x.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[]{Integer.valueOf(hashCode())});
        LayoutInflater.from(this.mContext).inflate(g.sns_video_view, this);
        this.jdj = (ImageView) findViewById(i.f.video_thumb);
        this.jdF = (RelativeLayout) findViewById(i.f.video_root);
        this.jfO = (ProgressBar) findViewById(i.f.video_loading);
        if (d.fS(18)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.jfM = true;
            this.hEl = new VideoPlayerTextureView(this.mContext);
        } else {
            this.jfM = false;
            this.hEl = new VideoTextureView(this.mContext);
        }
        this.hEl.setVideoCallback(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.jdF.addView((View) this.hEl, layoutParams);
        a(false, 0.0f);
    }

    public void setVideoCallback(a aVar) {
        this.nPe = aVar;
    }

    public void setMute(boolean z) {
        this.hEj = z;
        this.hEl.setMute(this.hEj);
    }

    private void onResume() {
        x.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
        if (!this.jfL) {
            bCl();
        }
        this.nPf = true;
    }

    public final void onDestroy() {
        x.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
        x.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[]{Integer.valueOf(hashCode())});
        this.hDf.removeCallbacksAndMessages(null);
        this.hEr.SO();
        if (this.hEl != null) {
            this.hEl.stop();
        }
    }

    public final void bCl() {
        if (this.nPe != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            if (this.nPe.a(pString)) {
                if (!bi.oW(pString2.value)) {
                    NR(pString2.value);
                }
                if (!bi.oW(pString.value)) {
                    BK(pString.value);
                    return;
                }
                return;
            }
            this.hDf.post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[]{Integer.valueOf(OfflineVideoView.this.hashCode()), Integer.valueOf(OfflineVideoView.this.hashCode())});
                    if (OfflineVideoView.this.jfO != null && OfflineVideoView.this.jfO.getVisibility() != 0) {
                        OfflineVideoView.this.jfO.setVisibility(0);
                    }
                }
            });
            a(false, 0.0f);
            return;
        }
        x.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[]{Integer.valueOf(hashCode())});
    }

    public final void NR(String str) {
        if (!bi.oW(str)) {
            this.hDf.post(new 1(this, str));
        }
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.jfM), Integer.valueOf(this.aBN)});
        this.aBN++;
        String videoPath = this.hEl.getVideoPath();
        this.hEl.stop();
        this.jfL = true;
        a(false, 0.0f);
        if (this.aBN <= 3) {
            this.hDf.postDelayed(new 2(this, videoPath), 200);
        } else if (!bi.oW(videoPath)) {
            x.w("MicroMsg.OfflineVideoView", "%d start third player to play", new Object[]{Integer.valueOf(hashCode())});
            this.hDf.post(new 3(this, videoPath));
        }
    }

    private void a(boolean z, float f) {
        this.hDf.post(new 4(this, z, f));
    }

    public final void iy() {
        a(true, 0.0f);
        this.jfL = false;
        aYM();
        this.duration = this.hEl.getDuration() / 1000;
        x.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.nPg), Integer.valueOf(this.nPh)});
        if (this.nPg) {
            if (this.nPh <= 0) {
                this.hEl.start();
            } else {
                R(this.nPh, true);
            }
            anA();
            if (this.nPe != null) {
                this.nPe.onStart(this.duration);
            }
        } else {
            R(this.nPh > 0 ? this.nPh : 0, false);
        }
        this.nPh = -1;
    }

    private void aYM() {
        this.hDf.post(new 6(this));
    }

    public final void anA() {
        this.hEr.J(500, 500);
    }

    public final void wd() {
        x.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        if (this.nPe != null) {
            this.nPe.wd();
        } else if (d.fT(18) || !this.jfM) {
            R(0, true);
        } else if (this.hEl != null) {
            String videoPath = this.hEl.getVideoPath();
            this.hEl.stop();
            BK(videoPath);
        }
    }

    public final void BK(String str) {
        x.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[]{Integer.valueOf(hashCode()), str});
        if (bi.oW(str)) {
            x.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[]{Integer.valueOf(hashCode())});
        } else if (this.hEl != null) {
            this.hEl.setOneTimeVideoTextureUpdateCallback(this.nPi);
            this.hEl.setVideoPath(str);
        }
    }

    public final void R(int i, boolean z) {
        x.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z)});
        aYM();
        this.hEl.d((double) (i * 1000), z);
        anA();
    }

    public final void bCm() {
        x.i("MicroMsg.OfflineVideoView", "%d pause", new Object[]{Integer.valueOf(hashCode())});
        x.d("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
        this.nPg = false;
        if (this.hEl.isPlaying()) {
            this.nPh = this.hEl.getCurrentPosition() / 1000;
        }
        x.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[]{Integer.valueOf(hashCode())});
        this.hEl.pause();
        aYM();
        this.hEr.SO();
    }

    public final void bCn() {
        x.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.nPf)});
        this.nPg = true;
        if (!this.nPf) {
            onResume();
        } else if (bi.oW(this.hEl.getVideoPath())) {
            onResume();
        } else if (this.hEl.start() && this.nPe != null) {
            this.nPe.onStart(this.duration);
        }
        anA();
    }

    public final void S(int i, boolean z) {
        x.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z)});
        R(i, z);
        anA();
    }

    public final boolean isPlaying() {
        return this.hEl != null ? this.hEl.isPlaying() : false;
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }

    public int getCurrentPosition() {
        if (this.hEl != null) {
            return this.hEl.getCurrentPosition() / 1000;
        }
        return 0;
    }
}
