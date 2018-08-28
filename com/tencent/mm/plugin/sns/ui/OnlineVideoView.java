package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.u.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class OnlineVideoView extends RelativeLayout implements a, af.a, f.a {
    private String bNH;
    private ate caK;
    private int cbh;
    private boolean cbi;
    private int cbj;
    private int dTR;
    private int duration;
    private d gbl;
    ag hDf;
    private boolean hEj;
    private f hEl;
    private al hEr;
    private RelativeLayout jdF;
    ImageView jdj;
    private TextView jfK;
    private boolean jfL;
    private boolean jfM;
    private int jfN;
    private ProgressBar jfO;
    private MMPinProgressBtn jfP;
    private b ldj;
    private Context mContext;
    private com.tencent.mm.plugin.sns.model.b.b nPA;
    private c nPB;
    c nPC;
    private long nPD;
    private int nPE;
    private boolean nPf;
    private e nPi;
    private int nPm;
    boolean nPn;
    String nPo;
    private boolean nPp;
    private a nPq;
    private TextView nPr;
    private af nPs;
    private boolean nPt;
    private boolean nPu;
    private int nPv;
    private int nPw;
    private long nPx;
    private long nPy;
    private al nPz;
    private av nkT;
    private c nrN;

    static /* synthetic */ void p(OnlineVideoView onlineVideoView) {
        x.i("MicroMsg.OnlineVideoView", "%d save video, download finish path %s", Integer.valueOf(onlineVideoView.hashCode()), aq.a(onlineVideoView.bNH, onlineVideoView.caK));
        if (bi.oW(aq.a(onlineVideoView.bNH, onlineVideoView.caK))) {
            onlineVideoView.nPp = true;
            onlineVideoView.s(true, 34);
            onlineVideoView.aoi();
            h.mEJ.a(354, 220, 1, false);
            return;
        }
        onlineVideoView.bCp();
    }

    public OnlineVideoView(Context context) {
        this(context, null);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nPm = 0;
        this.nPn = false;
        this.jfL = false;
        this.hEj = false;
        this.caK = null;
        this.nPp = false;
        this.nPs = null;
        this.nPu = false;
        this.duration = 0;
        this.nPv = 0;
        this.nPw = 0;
        this.nPx = 0;
        this.nPy = 0;
        this.jfN = 0;
        this.hDf = new ag(Looper.getMainLooper());
        this.nPz = new al(new 16(this), true);
        this.hEr = new al(new 17(this), true);
        this.nPA = new 2(this);
        this.nPB = new c<qr>() {
            {
                this.sFo = qr.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                qr qrVar = (qr) bVar;
                x.i("MicroMsg.OnlineVideoView", "%d sns video menu event local id[%s, %s]", Integer.valueOf(OnlineVideoView.this.hashCode()), qrVar.cbg.bNH, OnlineVideoView.this.bNH);
                if (bi.fS(qrVar.cbg.bNH, OnlineVideoView.this.bNH)) {
                    if (qrVar.cbg.bOh == 1) {
                        OnlineVideoView.a(OnlineVideoView.this, qrVar.cbg.cbj);
                    } else if (qrVar.cbg.bOh == 2) {
                        OnlineVideoView.a(OnlineVideoView.this, qrVar.cbg.cbh, qrVar.cbg.cbi);
                    } else if (qrVar.cbg.bOh == 3) {
                        OnlineVideoView.p(OnlineVideoView.this);
                    }
                }
                return false;
            }
        };
        this.nPC = new 4(this);
        this.nrN = new 5(this);
        this.nPi = new 6(this);
        this.ldj = new 7(this);
        this.mContext = context;
        x.i("MicroMsg.OnlineVideoView", "%d ui init view.", Integer.valueOf(hashCode()));
        LayoutInflater.from(context).inflate(g.sns_video_view, this);
        this.jdj = (ImageView) findViewById(i.f.video_thumb);
        this.jdF = (RelativeLayout) findViewById(i.f.video_root);
        this.nPr = (TextView) findViewById(i.f.video_duration);
        this.nPr.setVisibility(8);
        this.jfP = (MMPinProgressBtn) findViewById(i.f.video_progress);
        this.jfO = (ProgressBar) findViewById(i.f.video_loading);
        this.jfK = (TextView) findViewById(i.f.video_tips);
        com.tencent.mm.modelcontrol.d.NP();
        if (com.tencent.mm.modelcontrol.d.NW()) {
            this.jfM = true;
            this.hEl = new VideoPlayerTextureView(context);
            ((VideoPlayerTextureView) this.hEl).setIOnlineCache(this.ldj);
            ((VideoPlayerTextureView) this.hEl).setOpenWithNoneSurface(true);
            h.mEJ.a(354, 148, 1, false);
        } else {
            this.jfM = false;
            this.hEl = new VideoTextureView(context);
            h.mEJ.a(354, 149, 1, false);
        }
        this.hEl.setVideoCallback(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.jdF.addView((View) this.hEl, layoutParams);
        a(false, 0.0f);
    }

    public final void bCo() {
        x.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", Integer.valueOf(hashCode()));
        com.tencent.mm.sdk.b.a.sFg.c(this.nPC);
    }

    public final void a(ate ate, String str, int i) {
        this.bNH = str;
        this.dTR = i;
        av clY = av.clY();
        clY.time = this.dTR;
        this.nkT = clY;
        if (this.caK != ate) {
            this.caK = ate;
            boolean c = af.byl().c(this.caK, this.jdj, i.e.black, this.mContext.hashCode(), this.nkT);
            x.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", Integer.valueOf(hashCode()), Boolean.valueOf(c));
        }
        this.nPn = false;
        x.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b ", Integer.valueOf(hashCode()), this.bNH, Integer.valueOf(this.dTR), Boolean.valueOf(this.nPn));
    }

    public void setVideoCallback(a aVar) {
        this.nPq = aVar;
    }

    public void setMute(boolean z) {
        this.hEj = z;
        this.hEl.setMute(this.hEj);
    }

    public final void onResume() {
        x.d("MicroMsg.OnlineVideoView", "%d on resume %s", Integer.valueOf(hashCode()), bi.cjd());
        this.nPx = bi.VF();
        if (this.nPs == null) {
            x.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", Integer.valueOf(hashCode()));
            this.nPs = new af(this);
            com.tencent.mm.sdk.b.a.sFg.b(this.nrN);
            com.tencent.mm.sdk.b.a.sFg.b(this.nPB);
            af.byj().a(this.nPA);
            this.gbl = new d();
            this.gbl.a(this);
            if (com.tencent.mm.p.a.vv() != null) {
                com.tencent.mm.p.a.vv().xv();
            }
        }
        if (!this.jfL) {
            bCl();
        }
        this.nPf = true;
    }

    public final void onPause() {
        x.d("MicroMsg.OnlineVideoView", "%d on pause %s ", Integer.valueOf(hashCode()), bi.cjd());
        bCq();
        if (this.hEl != null) {
            this.hEl.stop();
        }
    }

    public final void onDestroy() {
        x.d("MicroMsg.OnlineVideoView", "%d on destroy %s", Integer.valueOf(hashCode()), bi.cjd());
        this.nPy = bi.VF();
        x.i("MicroMsg.OnlineVideoView", "%d logic unInit", Integer.valueOf(hashCode()));
        bCt();
        this.hEl.stop();
        com.tencent.mm.sdk.b.a.sFg.c(this.nrN);
        com.tencent.mm.sdk.b.a.sFg.c(this.nPB);
        af.byj().b(this.nPA);
        bCq();
        this.hDf.removeCallbacksAndMessages(null);
        if (this.nPs != null) {
            this.nPs.bCw();
            this.nPs.clear();
        }
        if (com.tencent.mm.p.a.vv() != null) {
            com.tencent.mm.p.a.vv().xu();
        }
        if (this.gbl != null) {
            this.gbl.bv(false);
        }
        this.gbl = null;
        this.caK = null;
        this.bNH = null;
        this.nPs = null;
        this.nPw = 0;
    }

    private void xl(int i) {
        String str = an.s(af.getAccSnsPath(), this.caK.ksA) + com.tencent.mm.plugin.sns.data.i.e(this.caK);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 11);
        x.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", str, Integer.valueOf(i));
        com.tencent.mm.bg.d.b(this.mContext, ".ui.transmit.SelectConversationUI", intent, i);
        this.cbj = 0;
    }

    private void T(final int i, final boolean z) {
        this.hDf.post(new Runnable() {
            public final void run() {
                n Nl = af.byo().Nl(OnlineVideoView.this.bNH);
                if (Nl != null) {
                    x.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", OnlineVideoView.this.bNH, Integer.valueOf(i), Boolean.valueOf(z));
                    ch chVar = new ch();
                    chVar.bJF.bJM = i;
                    chVar.bJF.activity = (Activity) OnlineVideoView.this.mContext;
                    com.tencent.mm.plugin.sns.i.a.a(chVar, Nl);
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    if (chVar.bJG.ret == 0) {
                        h.mEJ.a(354, 225, 1, false);
                    } else {
                        h.mEJ.a(354, 226, 1, false);
                    }
                    if (z) {
                        pt ptVar = new pt();
                        ptVar.caz.bKW = Nl.bBe();
                        ptVar.caz.bSZ = com.tencent.mm.plugin.sns.data.i.g(Nl);
                        com.tencent.mm.sdk.b.a.sFg.m(ptVar);
                    }
                    OnlineVideoView.this.cbh = 0;
                    if (OnlineVideoView.this.hEl == null) {
                        return;
                    }
                    if (bi.oW(OnlineVideoView.this.hEl.getVideoPath())) {
                        x.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", Integer.valueOf(OnlineVideoView.this.hashCode()));
                        String a = aq.a(OnlineVideoView.this.bNH, OnlineVideoView.this.caK);
                        if (!bi.oW(a)) {
                            OnlineVideoView.this.aX(a, false);
                        }
                    } else if (!OnlineVideoView.this.hEl.isPlaying()) {
                        OnlineVideoView.this.hEl.start();
                    }
                }
            }
        });
    }

    private void bCp() {
        long VG = bi.VG();
        String nX = t.nX(aq.a(this.bNH, this.caK));
        if (bi.oW(nX)) {
            Toast.makeText(this.mContext, this.mContext.getString(j.video_file_save_failed), 1).show();
            h.mEJ.a(354, 222, 1, false);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(j.video_file_saved, new Object[]{nX}), 1).show();
            r.a(nX, this.mContext);
            h.mEJ.a(354, 221, 1, false);
        }
        this.nPp = false;
        x.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", Integer.valueOf(hashCode()), Long.valueOf(bi.bI(VG)), r0);
        this.hDf.post(new 10(this));
    }

    private void a(boolean z, float f) {
        this.hDf.post(new 11(this, z, f));
    }

    private void bCl() {
        String str;
        if (this.nPn) {
            str = this.nPo;
        } else {
            str = aq.a(this.bNH, this.caK);
        }
        x.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", Integer.valueOf(hashCode()), this.bNH, str, Boolean.valueOf(this.nPn));
        if (bi.oW(str)) {
            a(false, 0.0f);
            s(false, 0);
            aoi();
            return;
        }
        x.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", Integer.valueOf(hashCode()));
        a(true, 0.0f);
        aX(str, false);
    }

    private void s(boolean z, int i) {
        if (this.caK == null) {
            x.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", Integer.valueOf(hashCode()));
        } else if (this.nPs == null) {
            x.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", Integer.valueOf(hashCode()));
        } else if (this.caK.rVD == 2) {
            x.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", Integer.valueOf(hashCode()));
            this.nPm = 3;
            af.byj().a(this.caK, 4, null, this.nkT);
        } else {
            boolean z2;
            int i2;
            af afVar;
            ate ate;
            int i3;
            String str;
            if (!z) {
                com.tencent.mm.modelcontrol.d.NP();
                if (com.tencent.mm.modelcontrol.d.NV()) {
                    x.i("MicroMsg.OnlineVideoView", "%d it start online download video", Integer.valueOf(hashCode()));
                    this.nPm = 1;
                    z2 = true;
                    if (i == 0) {
                        i = 30;
                    }
                    i2 = i;
                    afVar = this.nPs;
                    ate = this.caK;
                    i3 = this.dTR;
                    str = this.bNH;
                    afVar.caK = ate;
                    afVar.dTR = i3;
                    afVar.bKW = str;
                    afVar.elA = aq.D(ate);
                    afVar.elz = aq.aG(i3, ate.jPK);
                    if (!bi.oW(afVar.elA) && !bi.oW(afVar.elz)) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", afVar.elz, Boolean.valueOf(z2));
                        af.bym().a(ate, i3, str, z2, true, i2);
                        afVar.elC = 1;
                        afVar.dQj = bi.VF();
                        if (z2) {
                            h.mEJ.a(354, 201, 1, false);
                            return;
                        } else {
                            h.mEJ.a(354, 202, 1, false);
                            return;
                        }
                    }
                }
            }
            x.i("MicroMsg.OnlineVideoView", "%d it start offline download video", Integer.valueOf(hashCode()));
            this.nPm = 2;
            z2 = false;
            if (i == 0) {
                i = 31;
            }
            i2 = i;
            afVar = this.nPs;
            ate = this.caK;
            i3 = this.dTR;
            str = this.bNH;
            afVar.caK = ate;
            afVar.dTR = i3;
            afVar.bKW = str;
            afVar.elA = aq.D(ate);
            afVar.elz = aq.aG(i3, ate.jPK);
            if (!bi.oW(afVar.elA)) {
            }
        }
    }

    private void aoi() {
        this.hDf.post(new 13(this));
    }

    private void aYM() {
        this.hDf.post(new 14(this));
    }

    protected final void bS(boolean z) {
        if (!this.nPt) {
            this.hEr.J(500, 500);
        } else if (z) {
            ah.A(new 15(this));
        } else {
            this.nPz.J(500, 500);
        }
    }

    protected final void bCq() {
        this.nPz.SO();
        this.hEr.SO();
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.nPt), Boolean.valueOf(this.jfM));
        if (this.nPt) {
            h.mEJ.a(354, 230, 1, false);
        } else {
            h.mEJ.a(354, 231, 1, false);
        }
        this.jfN = i2;
        bCt();
        String videoPath = this.hEl.getVideoPath();
        this.nPv = this.hEl.getCurrentPosition() / 1000;
        if (this.nPt) {
            if (i == -2) {
                this.hEl.stop();
            } else if (i == -3) {
                this.nPw = i;
                this.hEl.pause();
            } else {
                bCq();
                this.hEl.stop();
            }
            try {
                aoi();
                if (this.nPs != null) {
                    af afVar = this.nPs;
                    String str = afVar.elz + 0 + "_-1";
                    if (!afVar.nPL.containsKey(str)) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", afVar.elz);
                        o.Tb();
                        com.tencent.mm.modelcdntran.f.g(afVar.elz, 0, -1);
                        afVar.nPL.put(str, Integer.valueOf(0));
                        h.mEJ.a(354, 207, 1, false);
                        h.mEJ.h(13836, Integer.valueOf(403), Long.valueOf(bi.VE()), "");
                    }
                    afVar.elD = 5;
                    afVar.elI = true;
                    afVar.elL = false;
                }
                bCt();
                return;
            } catch (Exception e) {
                return;
            }
        }
        this.hEl.stop();
        this.jfL = true;
        a(false, 0.0f);
        if (!bi.oW(videoPath)) {
            x.w("MicroMsg.OnlineVideoView", "%d start third player to play", Integer.valueOf(hashCode()));
            this.hDf.post(new 8(this, videoPath));
        }
    }

    public final void iy() {
        x.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.jfN), Integer.valueOf(this.nPv));
        this.jfN = 0;
        if (this.nPv > 0) {
            sG(this.nPv);
            this.nPv = 0;
            return;
        }
        this.nPw = 0;
        aYM();
        bCs();
        this.hEl.start();
        this.duration = this.hEl.getDuration() / 1000;
        x.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.bNH);
        bS(false);
    }

    public final void wd() {
        x.i("MicroMsg.OnlineVideoView", "%d on completion", Integer.valueOf(hashCode()));
        if (this.nPq != null) {
            return;
        }
        if (com.tencent.mm.compatible.util.d.fT(18) || !this.jfM) {
            sG(0);
        } else if (this.hEl != null) {
            String videoPath = this.hEl.getVideoPath();
            this.hEl.stop();
            aX(videoPath, this.nPt);
        }
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }

    public final void aX(String str, boolean z) {
        x.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", Integer.valueOf(hashCode()), Boolean.valueOf(z), str);
        if (bi.oW(str)) {
            x.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", Integer.valueOf(hashCode()));
            return;
        }
        this.nPt = z;
        if (this.hEl != null) {
            VideoPlayerTextureView videoPlayerTextureView;
            if (this.nPw != -3) {
                if (this.hEl instanceof VideoPlayerTextureView) {
                    boolean z2;
                    videoPlayerTextureView = (VideoPlayerTextureView) this.hEl;
                    if (this.nPt) {
                        com.tencent.mm.kernel.g.Ek();
                        z2 = com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
                    } else {
                        z2 = false;
                    }
                    videoPlayerTextureView.setNeedResetExtractor(z2);
                    ((VideoPlayerTextureView) this.hEl).setIsOnlineVideoType(z);
                }
                this.hEl.setOneTimeVideoTextureUpdateCallback(this.nPi);
                this.hEl.setVideoPath(str);
                a(true, 0.0f);
            } else {
                x.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", Integer.valueOf(hashCode()));
                if (this.hEl instanceof VideoPlayerTextureView) {
                    videoPlayerTextureView = (VideoPlayerTextureView) this.hEl;
                    x.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", Integer.valueOf(videoPlayerTextureView.hashCode()));
                    if (videoPlayerTextureView.qTy != null) {
                        com.tencent.mm.plugin.u.i iVar = videoPlayerTextureView.qTy;
                        if (iVar.ldy != null) {
                            iVar.ldy.bdB();
                        }
                    }
                }
                sG(this.nPv);
            }
        }
        com.tencent.mm.kernel.g.Ek();
        if (((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            this.jfK.setText(com.tencent.mm.plugin.sight.base.d.Ho(str));
            this.jfK.setVisibility(0);
        }
    }

    public final boolean bCr() {
        x.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", Integer.valueOf(hashCode()));
        if (this.hEl.isPlaying()) {
            return true;
        }
        bCs();
        boolean start = this.hEl.start();
        aYM();
        return start;
    }

    public final void SN() {
        x.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", Integer.valueOf(hashCode()));
        bCt();
        aoi();
        if (this.hEl.isPlaying()) {
            x.i("MicroMsg.OnlineVideoView", "%d pause play", Integer.valueOf(hashCode()));
            bCt();
            this.hEl.pause();
        }
    }

    public final void sG(int i) {
        x.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(true));
        this.nPw = 0;
        aYM();
        this.hEl.d((double) (i * 1000), true);
        bS(false);
    }

    private void bCs() {
        this.nPD = bi.VF();
        x.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", Integer.valueOf(hashCode()), Long.valueOf(this.nPD));
    }

    private void bCt() {
        if (this.nPD > 0) {
            this.nPE = (int) (((long) this.nPE) + ((bi.VF() - this.nPD) / 1000));
        }
        x.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", Integer.valueOf(hashCode()), Integer.valueOf(this.nPE));
        this.nPD = 0;
    }

    public int getPlayVideoDuration() {
        if (this.nPE < 0) {
            this.nPE = 0;
        }
        x.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.nPE));
        return this.nPE;
    }

    public int getPlayErrorCode() {
        return this.jfN;
    }

    public int getUiStayTime() {
        int i;
        if (this.nPy <= 0 || this.nPx <= 0) {
            i = 0;
        } else {
            i = (int) (this.nPy - this.nPx);
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }
}
