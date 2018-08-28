package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class AbstractVideoView extends RelativeLayout implements h, a, b, c, d, e {
    private boolean Fd;
    public String TAG;
    private int aBN;
    protected ag dvh;
    public h.b gbe;
    public f hEl;
    protected TextView hSJ;
    protected ImageView iYZ;
    protected ProgressBar jfO;
    public Context mContext;
    protected TextView nPr;
    private OnClickListener qEA;
    private h.c qEB;
    protected k qEC;
    public boolean qEh;
    protected RelativeLayout qEi;
    protected LinearLayout qEj;
    protected VideoPlayerSeekBar qEk;
    protected g qEl;
    protected boolean qEm;
    protected boolean qEn;
    public int qEo;
    public boolean qEp;
    public int qEq;
    public boolean qEr;
    public int qEs;
    public boolean qEt;
    public long qEu;
    public int qEv;
    protected al qEw;
    protected al qEx;
    protected al qEy;
    private com.tencent.mm.plugin.sight.decode.ui.b qEz;

    public abstract int getReportIdkey();

    static /* synthetic */ void b(AbstractVideoView abstractVideoView) {
        x.i(abstractVideoView.TAG, "%s reset error count ", new Object[]{abstractVideoView.avy()});
        abstractVideoView.aBN = 0;
        abstractVideoView.bQ((long) (abstractVideoView.getReportIdkey() + 91));
    }

    public AbstractVideoView(Context context) {
        this(context, null);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.AbstractVideoView";
        this.qEh = true;
        this.qEn = true;
        this.qEo = 0;
        this.qEp = false;
        this.dvh = new ag(Looper.getMainLooper());
        this.qEq = 0;
        this.qEr = true;
        this.qEs = -1;
        this.aBN = 0;
        this.qEt = false;
        this.Fd = false;
        this.qEu = 0;
        this.qEv = 0;
        this.qEw = new al(new 1(this), true);
        this.qEx = new al(new al.a() {
            public final boolean vD() {
                boolean isPlaying = AbstractVideoView.this.isPlaying();
                x.i(AbstractVideoView.this.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[]{AbstractVideoView.this.avy(), Boolean.valueOf(isPlaying), Integer.valueOf(AbstractVideoView.this.getCurrPosMs())});
                if (AbstractVideoView.this.hEl != null && r1 <= 50) {
                    AbstractVideoView.this.hEl.x(0.0d);
                }
                return false;
            }
        }, false);
        this.qEy = new al(new 5(this), true);
        this.qEz = new 6(this);
        this.qEA = new OnClickListener() {
            public final void onClick(View view) {
                x.i(AbstractVideoView.this.TAG, "%s seek bar play button on click ", new Object[]{AbstractVideoView.this.avy()});
                AbstractVideoView abstractVideoView = AbstractVideoView.this;
                if (abstractVideoView.hEl == null) {
                    return;
                }
                if (abstractVideoView.isPlaying()) {
                    abstractVideoView.pause();
                } else if (bi.oW(abstractVideoView.hEl.getVideoPath())) {
                    abstractVideoView.start();
                } else {
                    abstractVideoView.play();
                }
            }
        };
        this.qEB = null;
        this.qEC = new k();
        this.mContext = context;
        initView();
    }

    public f bT(Context context) {
        return null;
    }

    public void initView() {
        x.i(this.TAG, "%s init view ", new Object[]{avy()});
        LayoutInflater.from(this.mContext).inflate(com.tencent.mm.plugin.ae.a.b.comm_video_view, this);
        this.iYZ = (ImageView) findViewById(com.tencent.mm.plugin.ae.a.a.video_thumb);
        this.qEi = (RelativeLayout) findViewById(com.tencent.mm.plugin.ae.a.a.video_root);
        this.nPr = (TextView) findViewById(com.tencent.mm.plugin.ae.a.a.video_duration);
        this.jfO = (ProgressBar) findViewById(com.tencent.mm.plugin.ae.a.a.video_loading);
        this.hSJ = (TextView) findViewById(com.tencent.mm.plugin.ae.a.a.video_tips);
        this.qEj = (LinearLayout) findViewById(com.tencent.mm.plugin.ae.a.a.video_footer_root);
        VideoPlayerSeekBar videoPlayerSeekBar = (VideoPlayerSeekBar) findViewById(com.tencent.mm.plugin.ae.a.a.video_player_seek_bar);
        this.qEk = videoPlayerSeekBar;
        this.qEl = videoPlayerSeekBar;
        this.qEk.setIplaySeekCallback(this.qEz);
        this.qEk.setOnClickListener(this.qEA);
        this.hEl = bT(this.mContext);
        this.hEl.setVideoCallback(this);
        this.hEl.setOnSeekCompleteCallback(this);
        this.hEl.setOnInfoCallback(this);
        this.hEl.setOnSurfaceCallback(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.qEi.addView((View) this.hEl, layoutParams);
    }

    public void setVideoFooterView(g gVar) {
        if (gVar instanceof View) {
            ajY();
            this.qEl = gVar;
            this.qEn = false;
            this.qEj.addView((View) this.qEl);
            return;
        }
        x.w(this.TAG, "%s set video footer view but is not view", new Object[]{avy()});
    }

    public final void ajY() {
        this.qEj.removeView((View) this.qEl);
    }

    private void jQ(boolean z) {
        this.qEl.jQ(z);
    }

    private void setVideoTotalTime(int i) {
        if (this.qEl != null && this.qEl.getVideoTotalTime() != i) {
            this.qEl.setVideoTotalTime(i);
        }
    }

    public void bS(boolean z) {
        x.d(this.TAG, "%s start timer rightNow[%b]", new Object[]{avy(), Boolean.valueOf(z)});
        this.qEw.J(500, 500);
    }

    public int getCacheTimeSec() {
        return 0;
    }

    public void SO() {
        this.qEw.SO();
        this.qEx.SO();
    }

    public final void mH(int i) {
        this.qEl.wQ(i);
    }

    public final void aoi() {
        this.dvh.post(new 8(this));
    }

    public final void aYM() {
        x.d(this.TAG, "%s hide loading %s", new Object[]{avy(), bi.cjd()});
        this.dvh.post(new Runnable() {
            public final void run() {
                if (AbstractVideoView.this.jfO != null && AbstractVideoView.this.jfO.getVisibility() != 8) {
                    x.i(AbstractVideoView.this.TAG, "%s hide loading", new Object[]{AbstractVideoView.this.avy()});
                    AbstractVideoView.this.jfO.setVisibility(8);
                    if (AbstractVideoView.this.gbe != null) {
                        AbstractVideoView.this.gbe.bz(AbstractVideoView.this.getSessionId(), AbstractVideoView.this.getMediaId());
                    }
                }
            }
        });
    }

    public final String avy() {
        return hashCode();
    }

    public int getPlayerType() {
        return this.qEq;
    }

    public boolean play() {
        if (this.qEh) {
            bQ((long) (getReportIdkey() + 3));
            if (this.hEl == null) {
                return false;
            }
            boolean start = this.hEl.start();
            x.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[]{avy(), Boolean.valueOf(start), Boolean.valueOf(this.qEp)});
            jQ(start);
            if (start) {
                this.qEp = false;
                bS(false);
                if (this.gbe != null) {
                    this.gbe.bx(getSessionId(), getMediaId());
                }
            }
            return start;
        }
        x.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[]{avy(), bi.cjd()});
        return false;
    }

    public boolean pause() {
        x.i(this.TAG, "%s pause", new Object[]{avy()});
        bQ((long) (getReportIdkey() + 4));
        if (this.hEl == null) {
            return false;
        }
        jQ(false);
        this.hEl.pause();
        SO();
        if (this.gbe != null) {
            this.gbe.bw(getSessionId(), getMediaId());
        }
        this.qEC.nPR = bi.VF();
        return true;
    }

    public final boolean kW(int i) {
        return x(i, isPlaying());
    }

    public boolean x(int i, boolean z) {
        int i2;
        boolean isPrepared = isPrepared();
        int videoDurationSec = getVideoDurationSec();
        if (videoDurationSec <= 0 || i <= videoDurationSec) {
            i2 = i;
        } else {
            i2 = videoDurationSec;
        }
        boolean z2 = this.hEl != null ? !bi.oW(this.hEl.getVideoPath()) : false;
        x.l(this.TAG, "%s seek to [%d %d] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[]{avy(), Integer.valueOf(i2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(isPrepared), Integer.valueOf(videoDurationSec), Boolean.valueOf(z2)});
        bQ((long) (getReportIdkey() + 5));
        if (!isPrepared) {
            this.qEs = i2;
            if (z2) {
                this.qEr = true;
            } else {
                this.qEr = z;
                start();
            }
        } else if (this.hEl != null) {
            aoi();
            mH(i2);
            this.hEl.d((double) (i2 * 1000), z);
            return z;
        }
        return false;
    }

    public int getVideoDurationSec() {
        if (this.hEl != null) {
            return Math.round((((float) this.hEl.getDuration()) * 1.0f) / 1000.0f);
        }
        return -1;
    }

    public int getCurrPosMs() {
        if (this.hEl != null) {
            return this.hEl.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrPosSec() {
        if (this.hEl != null) {
            return Math.round((((float) this.hEl.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        return 0;
    }

    public boolean isPlaying() {
        if (this.hEl != null) {
            return this.hEl.isPlaying();
        }
        return false;
    }

    public final boolean isPrepared() {
        boolean z = this.hEl != null ? !bi.oW(this.hEl.getVideoPath()) && this.Fd : false;
        x.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[]{avy(), Boolean.valueOf(z), Boolean.valueOf(this.Fd)});
        return z;
    }

    public void setIsShowBasicControls(boolean z) {
        x.i(this.TAG, "%s is show seek bar[%b]", new Object[]{avy(), Boolean.valueOf(z)});
        this.qEm = z;
        if (this.qEm) {
            this.dvh.post(new 10(this));
        } else {
            this.dvh.post(new 11(this));
        }
    }

    public void setCover(Bitmap bitmap) {
        x.i(this.TAG, "%s set cover", new Object[]{avy()});
        if (bitmap != null && !bitmap.isRecycled()) {
            this.iYZ.setImageBitmap(bitmap);
        }
    }

    public void setFullDirection(int i) {
    }

    public void setIMMVideoViewCallback(h.b bVar) {
        this.gbe = bVar;
    }

    public void stop() {
        x.i(this.TAG, "%s stop [%s]", new Object[]{avy(), bi.cjd()});
        bQ((long) (getReportIdkey() + 6));
        if (this.hEl != null) {
            this.hEl.stop();
        }
        this.qEs = -1;
        this.qEr = true;
        this.Fd = false;
        this.qEv = 0;
        this.qEu = 0;
        SO();
        this.dvh.postDelayed(new 2(this), 10);
        this.qEC.qGy = bi.VF();
        if (this.qEC.blockCount > 0) {
            int i;
            int i2;
            if (ao.isWifi(this.mContext)) {
                i = 41;
                i2 = 45;
            } else if (ao.is4G(this.mContext)) {
                i = 46;
                i2 = 50;
            } else if (ao.is3G(this.mContext)) {
                i = 51;
                i2 = 55;
            } else if (ao.is2G(this.mContext)) {
                i = 56;
                i2 = 60;
            }
            x.d(this.TAG, "%s rptBlockCount [%d]", new Object[]{avy(), Integer.valueOf(bi.f((Integer) com.tencent.mm.plugin.report.f.a(this.qEC.blockCount, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey())))});
            bQ((long) i2);
        }
        if (this.qEC.qGw != 0) {
            long j;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.qEC.qGw).append(",");
            stringBuffer.append(this.qEC.qGx).append(",");
            stringBuffer.append(this.qEC.qGy).append(",");
            stringBuffer.append(this.qEC.nPR).append(",");
            stringBuffer.append(this.qEC.qGz).append(",");
            stringBuffer.append(this.qEC.qGA).append(",");
            stringBuffer.append(this.qEC.qGB).append(",");
            stringBuffer.append(this.qEC.blockCount).append(",");
            if (this.qEC.qGx > 0) {
                j = this.qEC.qGx - this.qEC.qGw;
            } else {
                j = 0;
            }
            stringBuffer.append(j).append(",");
            stringBuffer.append(this.qEC.url).append(",");
            stringBuffer.append(this.qEC.duration).append(",");
            stringBuffer.append(this.qEC.qGC).append(",");
            stringBuffer.append(this.qEC.qGD).append(",");
            stringBuffer.append(this.qEC.nPP).append(",");
            stringBuffer.append(this.qEC.nPP > this.qEC.qGw ? this.qEC.nPP - this.qEC.qGw : 0).append(",");
            stringBuffer.append(getPlayerType());
            x.i(this.TAG, "%s rpt video kv stat{%s}", new Object[]{avy(), stringBuffer.toString()});
            if (this.qEB != null) {
                this.qEB.pV(r0);
            }
            k kVar = this.qEC;
            kVar.qGw = 0;
            kVar.qGx = 0;
            kVar.qGy = 0;
            kVar.nPR = 0;
            kVar.qGz = 0;
            kVar.qGA = 0;
            kVar.qGB = 0;
            kVar.blockCount = 0;
            kVar.url = "";
            kVar.duration = 0;
            kVar.qGC = 0;
            kVar.qGD = 0;
            kVar.nPP = 0;
        }
    }

    public void setMute(boolean z) {
        if (this.hEl != null) {
            this.hEl.setMute(z);
        }
    }

    public void SM() {
        x.i(this.TAG, "%s onUIResume %s", new Object[]{avy(), bi.cjd()});
        this.qEh = true;
        bQ((long) (getReportIdkey() + 10));
    }

    public void SL() {
        x.i(this.TAG, "%s onUIPause %s", new Object[]{avy(), bi.cjd()});
        this.qEo = getCurrPosSec();
        this.qEp = isPlaying();
        this.qEv = 0;
        this.qEu = 0;
        pause();
        SO();
        this.qEh = false;
        bQ((long) (getReportIdkey() + 11));
    }

    public void ajZ() {
        x.i(this.TAG, "%s onUIDestroy", new Object[]{avy()});
        stop();
        this.dvh.removeCallbacksAndMessages(null);
        SO();
        this.qEy.SO();
        bQ((long) (getReportIdkey() + 12));
    }

    public void onError(int i, int i2) {
        x.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.aBN)});
        bQ((long) (getReportIdkey() + 90));
        this.aBN++;
        if (this.aBN > 5) {
            bQ((long) (getReportIdkey() + 92));
            this.qEC.qGC = i;
            this.qEC.qGD = i2;
            if (this.gbe != null) {
                h.b bVar = this.gbe;
                String sessionId = getSessionId();
                String mediaId = getMediaId();
                String str = i == -1010 ? "MEDIA_ERR_SRC_NOT_SUPPORTED" : i == -1007 ? "MEDIA_ERR_SRC_NOT_SUPPORTED" : i == -1004 ? !ao.isConnected(this.mContext) ? "MEDIA_ERR_NETWORK" : "MEDIA_ERR_DECODE" : !ao.isConnected(this.mContext) ? "MEDIA_ERR_NETWORK" : "MEDIA_ERR_DECODE";
                bVar.d(sessionId, mediaId, str, i, i2);
            }
            stop();
            aYM();
            return;
        }
        x.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d] seekTimeWhenPrepared[%d] currPosSec[%d]", new Object[]{avy(), Integer.valueOf(this.qEs == -1 ? getCurrPosSec() : this.qEs), Integer.valueOf(this.qEs), Integer.valueOf(getCurrPosSec())});
        stop();
        aoi();
        this.dvh.postDelayed(new 3(this, r0), 200);
    }

    public final void iy() {
        x.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[]{avy(), Boolean.valueOf(this.qEr), Integer.valueOf(this.qEs), Boolean.valueOf(this.Fd)});
        this.Fd = true;
        if (this.hEl != null) {
            this.hEl.setOneTimeVideoTextureUpdateCallback(this);
        }
        setVideoTotalTime(getVideoDurationSec());
        if (!this.qEr) {
            x(this.qEs < 0 ? 0 : this.qEs, this.qEr);
        } else if (this.qEs < 0) {
            if (play() && bIj()) {
                this.qEx.J(1000, 1000);
            }
        } else if (ajG()) {
            play();
        } else {
            x(this.qEs, this.qEr);
        }
        this.qEs = -1;
        this.qEr = true;
        this.qEv = 0;
        this.qEu = 0;
        if (this.gbe != null) {
            this.gbe.bu(getSessionId(), getMediaId());
        }
        if (this.aBN > 0) {
            x.d(this.TAG, "%s start error check timer", new Object[]{avy()});
            this.qEy.J(5000, 5000);
        }
        bQ((long) (getReportIdkey() + 2));
        if (this.qEC.qGx == 0) {
            this.qEC.qGx = bi.VF();
        }
        this.qEC.duration = getVideoDurationSec();
        if (this.qEC.qGw > 0 && this.qEC.qGx > 0) {
            int i;
            int i2;
            int i3 = (int) ((this.qEC.qGx - this.qEC.qGw) / 1000);
            if (ao.isWifi(this.mContext)) {
                i = 20;
                i2 = 24;
            } else if (ao.is4G(this.mContext)) {
                i = 25;
                i2 = 29;
            } else if (ao.is3G(this.mContext)) {
                i = 30;
                i2 = 34;
            } else if (ao.is2G(this.mContext)) {
                i = 35;
                i2 = 39;
            } else {
                return;
            }
            x.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[]{avy(), Integer.valueOf(bi.f((Integer) com.tencent.mm.plugin.report.f.a(i3, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey())))});
            bQ((long) i2);
        }
    }

    public final void bfs() {
        x.i(this.TAG, "%s onTextureUpdate ", new Object[]{avy()});
        aYM();
    }

    public void wd() {
        x.i(this.TAG, "%s onCompletion", new Object[]{avy()});
        aYM();
        SO();
        if (this.gbe != null) {
            this.gbe.bv(getSessionId(), getMediaId());
        }
        this.qEv = 0;
        this.qEu = 0;
        bQ((long) (getReportIdkey() + 7));
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
        x.i(this.TAG, "%s on get video size [%d, %d]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.gbe != null) {
            this.gbe.d(getSessionId(), getMediaId(), i, i2);
        }
        bQ((long) (getReportIdkey() + 8));
    }

    public void bR(boolean z) {
        x.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[]{avy(), Boolean.valueOf(z)});
        if (this.hEl != null) {
            this.hEl.setOneTimeVideoTextureUpdateCallback(this);
        }
        aYM();
        jQ(z);
        mH(getCurrPosSec());
        if (z) {
            bS(false);
            this.qEp = false;
            if (this.gbe != null) {
                this.gbe.bx(getSessionId(), getMediaId());
            }
        }
    }

    public void SP() {
        x.i(this.TAG, "%s on surface available", new Object[]{avy()});
        bS(false);
    }

    public boolean bIj() {
        return true;
    }

    public void setReporter(h.c cVar) {
        this.qEB = cVar;
    }

    public final void bQ(long j) {
        if (this.qEB != null) {
            this.qEB.bQ(j);
        }
    }

    public final void bCy() {
        if (this.qEC.qGw == 0) {
            this.qEC.qGw = bi.VF();
        }
    }

    public final void ccU() {
        if (this.qEC.nPP == 0) {
            this.qEC.nPP = bi.VF();
        }
    }

    public final void ccV() {
        this.qEC.qGz = bi.VF();
    }

    public final void ccW() {
        this.qEC.qGA = bi.VF();
        if (this.qEC.qGz > 0) {
            k kVar = this.qEC;
            kVar.qGB += this.qEC.qGA - this.qEC.qGz;
        }
    }

    public final void ccX() {
        k kVar = this.qEC;
        kVar.blockCount++;
    }

    protected final void Tv(String str) {
        this.qEC.url = str;
    }

    public final void ccY() {
        if (this.qEC.qGA > 0 && this.qEC.qGz > 0) {
            int i;
            int i2;
            int i3 = (int) ((this.qEC.qGA - this.qEC.qGz) / 1000);
            if (ao.isWifi(this.mContext)) {
                i = 70;
                i2 = 74;
            } else if (ao.is4G(this.mContext)) {
                i = 75;
                i2 = 79;
            } else if (ao.is3G(this.mContext)) {
                i = 80;
                i2 = 84;
            } else if (ao.is2G(this.mContext)) {
                i = 85;
                i2 = 89;
            } else {
                return;
            }
            x.d(this.TAG, "%s rptResumeTime [%d]", new Object[]{avy(), Integer.valueOf(bi.f((Integer) com.tencent.mm.plugin.report.f.a(i3, new int[]{1, 2, 3, 4}, i + getReportIdkey(), i2 + getReportIdkey())))});
            bQ((long) i2);
        }
    }

    public String getSessionId() {
        return "";
    }

    public String getMediaId() {
        return "";
    }
}
