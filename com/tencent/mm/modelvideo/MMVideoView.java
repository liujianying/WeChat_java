package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MMVideoView extends CommonVideoView implements a {
    public String elA;
    private h.a elB;
    public int elC = 0;
    public int elD = 0;
    public f elE;
    public int elF;
    public int elG;
    private boolean elH;
    public boolean elI;
    public int elJ = 0;
    public int elK;
    private boolean elL = false;
    private boolean elM = false;
    private boolean elN = false;
    public a elO;
    private boolean elP = false;
    private al elQ = new al(new 1(this), true);
    private String elx;
    public b ely;
    public String elz;

    public MMVideoView(Context context) {
        super(context);
    }

    public MMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        super.initView();
        this.TAG = "MicroMsg.MMVideoView";
        this.elE = new f();
        this.elO = new a();
        SJ();
        reset();
    }

    public void SJ() {
        this.elO.elS = 5;
        this.elO.elT = 2;
    }

    private void reset() {
        this.elG = -1;
        this.elJ = 0;
        this.elF = 0;
        this.elD = 0;
        this.elC = 0;
        this.elI = false;
        this.elL = false;
        this.elM = false;
        if (this.elO != null) {
            this.elK = this.elO.elS;
        }
    }

    public void setIOnlineVideoProxy(b bVar) {
        this.ely = bVar;
        this.ely.a(this);
    }

    public void setIMMDownloadFinish(h.a aVar) {
        this.elB = aVar;
    }

    public final void c(boolean z, String str, int i) {
        super.c(z, str, i);
        if (!bi.oW(str)) {
            this.elz = "MMVideo_" + str.hashCode();
            this.elA = getRootPath() + "MMVideo_" + str.hashCode() + ".mp4";
            e.cs(this.elA);
            x.i(this.TAG, "%s set video path [%s %s]", new Object[]{avy(), this.elz, this.elA});
        }
    }

    public void setRootPath(String str) {
        this.elx = str;
    }

    private String getRootPath() {
        return !bi.oW(this.elx) ? this.elx : com.tencent.mm.compatible.util.e.bnE + "appbrandvideo/";
    }

    private void SK() {
        if (this.hEl != null) {
            this.elL = true;
            this.hEl.setVideoPath(this.elA);
        }
    }

    public void SL() {
        super.SL();
        if (this.elP) {
            this.elN = true;
            stop();
        }
    }

    public void SM() {
        super.SM();
        x.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[]{avy(), Boolean.valueOf(this.elN), Integer.valueOf(this.qEo), Boolean.valueOf(this.qEp)});
        if (this.elN) {
            x(this.qEo, this.qEp);
        } else if (this.hEl != null && d.fR(24) && (this.hEl instanceof VideoPlayerTextureView)) {
            ((VideoPlayerTextureView) this.hEl).bdC();
        }
    }

    public void start() {
        x.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[]{avy(), this.elz, Integer.valueOf(this.elF)});
        if (this.hEl != null) {
            if (bi.oW(this.hEl.getVideoPath())) {
                aoi();
                this.elP = true;
                this.elF = 0;
                this.elC = 1;
                this.ely.q(this.elz, this.elA, this.url);
                this.ely.a(this);
                bCy();
            } else {
                play();
            }
            bQ((long) (getReportIdkey() + 1));
        }
    }

    public final void wd() {
        this.ely.ny(this.elz);
        reset();
        if (this.hEl != null) {
            this.hEl.stop();
        }
        super.wd();
    }

    public void stop() {
        this.ely.ny(this.elz);
        reset();
        super.stop();
    }

    public com.tencent.mm.pluginsdk.ui.tools.f bT(Context context) {
        this.qEq = 1;
        VideoPlayerTextureView videoPlayerTextureView = new VideoPlayerTextureView(context);
        videoPlayerTextureView.setNeedResetExtractor(true);
        return videoPlayerTextureView;
    }

    public void setScaleType(h.d dVar) {
        if (this.hEl instanceof VideoPlayerTextureView) {
            ((VideoPlayerTextureView) this.hEl).setScaleType(dVar);
            bQ((long) (getReportIdkey() + 14));
        }
    }

    public final boolean iC(int i) {
        int i2;
        boolean z = false;
        if (this.elG != -1) {
            i2 = this.elG;
        } else {
            i2 = i;
        }
        x.i(this.TAG, "%s check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s isPrepareVideo[%b]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.elJ), Integer.valueOf(this.elF), Integer.valueOf(this.elD), Integer.valueOf(this.elC), this.elz, Boolean.valueOf(this.elL)});
        switch (this.elC) {
            case 1:
                boolean z2;
                if (!iD(i2)) {
                    this.elI = true;
                    if (this.elJ > 0) {
                        x.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[]{avy(), this.elz, Integer.valueOf(this.elD)});
                        ccV();
                        if (!(this.elD == 2 || this.elD == 4)) {
                            this.elK += this.elO.elS;
                            this.elK = Math.min(this.elK, 60);
                            ccX();
                            this.elD = 4;
                        }
                        SN();
                    } else if (this.elG == -1) {
                        this.elD = 1;
                    } else {
                        this.elD = 2;
                    }
                    z2 = false;
                } else if (this.elL) {
                    MMVideoView mMVideoView;
                    int i3;
                    mH(i2);
                    if (this.elI) {
                        ccW();
                        ccY();
                        x.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[]{avy(), this.elz});
                        if (this.elG != -1) {
                            x(this.elG, this.elH);
                            this.elG = -1;
                            z2 = false;
                            mMVideoView = this;
                        } else if (play()) {
                            z2 = false;
                            mMVideoView = this;
                        } else {
                            z2 = true;
                            mMVideoView = this;
                        }
                        mMVideoView.elI = z2;
                        i3 = 3;
                        mMVideoView = this;
                    } else {
                        if (this.elD != 3) {
                            x.i(this.TAG, "%s start to play video playStatus[%d]", new Object[]{avy(), Integer.valueOf(this.elD)});
                            if (play()) {
                                i3 = 3;
                                mMVideoView = this;
                            } else {
                                i3 = this.elD;
                                mMVideoView = this;
                            }
                        }
                        z2 = true;
                    }
                    mMVideoView.elD = i3;
                    z2 = true;
                } else {
                    x.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[]{avy(), this.elz});
                    if (this.elD == 5) {
                        this.elD = 1;
                    }
                    SK();
                    z2 = true;
                }
                mH(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (!a(i2, pInt, pInt2)) {
                    x.d(this.TAG, "%s can not calc download.", new Object[]{avy()});
                } else if (f(pInt.value, pInt2.value, false)) {
                    this.elJ = Math.max(this.elJ, pInt2.value);
                    return true;
                }
                return z2;
            case 2:
                x.w(this.TAG, "%s download error.", new Object[]{avy()});
                return false;
            case 3:
                if (this.elL) {
                    if (this.elI) {
                        MMVideoView mMVideoView2;
                        if (this.elG != -1) {
                            x(this.elG, true);
                            this.elG = -1;
                            mMVideoView2 = this;
                        } else if (play()) {
                            mMVideoView2 = this;
                        } else {
                            z = true;
                            mMVideoView2 = this;
                        }
                        mMVideoView2.elI = z;
                    }
                    this.elD = 3;
                    mH(i2);
                    return true;
                }
                if (this.elD == 5) {
                    this.elD = 1;
                }
                SK();
                return true;
            default:
                x.w(this.TAG, "%s check time default.", new Object[]{avy()});
                return false;
        }
    }

    public boolean x(int i, boolean z) {
        boolean z2;
        switch (this.elC) {
            case 0:
                if (!isPrepared()) {
                    if (this.qEt) {
                        this.qEr = z;
                        this.elH = z;
                        this.qEs = i;
                        this.elG = i;
                    } else {
                        this.qEr = z;
                        this.qEs = this.qEo;
                    }
                    start();
                    break;
                }
                break;
            case 1:
                this.elD = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!f(pInt.value, pInt2.value, true)) {
                    this.elG = i;
                    this.elH = z;
                    this.elI = true;
                    SN();
                    z2 = false;
                    break;
                }
                this.elG = -1;
                this.elI = false;
                this.elJ = pInt2.value;
                this.elD = 3;
                super.x(i, z);
                z2 = true;
                break;
            case 2:
                z2 = true;
                break;
            case 3:
                super.x(i, z);
                z2 = true;
                break;
        }
        z2 = true;
        x.l(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(this.elC), Integer.valueOf(this.elD)});
        return z2;
    }

    public final void bR(boolean z) {
        super.bR(z);
        aYM();
    }

    public boolean iD(int i) {
        Exception e;
        if (this.elC == 3) {
            return true;
        }
        if (this.elJ - i <= 1 && this.elJ < this.elF) {
            return false;
        }
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.elE.a(i, i + 1, pInt, pInt2)) {
                isVideoDataAvailable = this.ely.isVideoDataAvailable(this.elz, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    try {
                        this.elJ = i;
                    } catch (Exception e2) {
                        e = e2;
                        x.e(this.TAG, "%s check video data error %s ", new Object[]{avy(), e.toString()});
                        return isVideoDataAvailable;
                    }
                }
            }
            isVideoDataAvailable = false;
        } catch (Exception e3) {
            e = e3;
            isVideoDataAvailable = false;
            x.e(this.TAG, "%s check video data error %s ", new Object[]{avy(), e.toString()});
            return isVideoDataAvailable;
        }
        return isVideoDataAvailable;
    }

    public boolean a(int i, PInt pInt, PInt pInt2) {
        pInt.value = Math.max(i, this.elJ);
        if (this.elD == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.elK;
        }
        if (this.elD == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.elK) + 8;
        }
        if (this.elD == 3 || this.elD == 4) {
            pInt.value = this.elJ;
            pInt2.value = ((this.elK + i) + 1) + this.elO.elT;
        }
        if (pInt2.value >= this.elF + 1) {
            pInt2.value = this.elF + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.elO.elT;
            return false;
        }
        x.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[]{avy(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.elD), Integer.valueOf(this.elJ), Integer.valueOf(this.elK), this.elz});
        return true;
    }

    private void SN() {
        x.i(this.TAG, "%s pauseByDataBlock ", new Object[]{avy()});
        aoi();
        pause();
    }

    public final boolean pause() {
        boolean pause = super.pause();
        if (pause) {
            this.elD = 4;
        }
        return pause;
    }

    public final boolean play() {
        boolean play = super.play();
        if (play) {
            this.elD = 3;
        }
        return play;
    }

    private boolean f(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.elE.a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = this.ely.isVideoDataAvailable(this.elz, pInt.value, pInt2.value);
                if (isVideoDataAvailable) {
                    String str = this.elz + "_" + pInt.value + "_" + pInt2.value;
                    if (!this.elM || z) {
                        this.elM = true;
                        this.ely.j(this.elz, pInt.value, pInt2.value);
                    } else {
                        x.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[]{avy(), str, Boolean.valueOf(this.elM), Boolean.valueOf(z)});
                    }
                } else {
                    x.d(this.TAG, "%s already had video data.", new Object[]{avy()});
                }
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            x.e(this.TAG, "%s check video data error[%s] ", new Object[]{avy(), e.toString()});
        }
        isVideoDataAvailable = false;
        if (isVideoDataAvailable) {
            x.d(this.TAG, "%s already had video data.", new Object[]{avy()});
        } else {
            String str2 = this.elz + "_" + pInt.value + "_" + pInt2.value;
            if (!this.elM || z) {
                this.elM = true;
                this.ely.j(this.elz, pInt.value, pInt2.value);
            } else {
                x.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[]{avy(), str2, Boolean.valueOf(this.elM), Boolean.valueOf(z)});
            }
        }
        return isVideoDataAvailable;
    }

    public final void iB(int i) {
        x.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(this.elF), this.elz});
        if (this.elF != 0) {
            x.w(this.TAG, "moov had callback, do nothing.");
            return;
        }
        ccU();
        try {
            if (this.elE == null) {
                x.w(this.TAG, "%s parser is null, thread is error.", new Object[]{avy()});
            } else if (this.elE.s(this.elA, (long) i)) {
                this.elF = this.elE.eyV;
                x.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[]{avy(), Integer.valueOf(this.elF), this.elz});
                if (iC(0)) {
                    SK();
                }
                if (this.elG == -1) {
                    this.elD = 1;
                } else {
                    this.elD = 2;
                }
            } else {
                x.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[]{avy(), this.elz});
                this.ely.j(this.elz, 0, -1);
            }
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "%s deal moov ready error [%s]", new Object[]{avy(), this.elz});
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        this.elM = false;
        if (i < 0 || i2 < 0) {
            x.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bi.fS(this.elz, str)) {
            try {
                this.elJ = this.elE.bw(i, i2);
            } catch (Exception e) {
                x.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[]{avy(), e.toString()});
            }
            x.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.elJ)});
            bS(true);
        }
    }

    public void h(String str, int i, int i2) {
        if (bi.fS(this.elz, str)) {
            x.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public void L(String str, int i) {
        if (bi.fS(this.elz, str) && this.elC != 3) {
            x.i(this.TAG, "%s download finish [%d]", new Object[]{avy(), Integer.valueOf(i)});
            if (i == 0) {
                this.elC = 3;
            }
            if (this.elB != null) {
                boolean z;
                h.a aVar = this.elB;
                String str2 = this.elA;
                if (this.elD > 0) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.aa(str2, z);
            }
            bS(true);
            this.elM = false;
        }
    }

    public final void bS(boolean z) {
        x.d(this.TAG, "%s start timer rightNow[%b]", new Object[]{avy(), Boolean.valueOf(z)});
        this.elQ.SO();
        this.elQ.J(500, 500);
    }

    public final void SO() {
        this.elQ.SO();
    }

    public int getCacheTimeSec() {
        if (this.elC == 3) {
            return getVideoDurationSec();
        }
        return this.elJ;
    }

    public final void SP() {
    }

    public int getReportIdkey() {
        return 100;
    }

    protected void setDownloadStatus(int i) {
        this.elC = i;
    }

    protected void setFilepath(String str) {
        this.elA = str;
    }

    public String getMediaId() {
        return this.elz;
    }
}
