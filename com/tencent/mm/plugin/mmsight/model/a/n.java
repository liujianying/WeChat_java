package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import com.tencent.mm.a.e;
import com.tencent.mm.c.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.File;

public final class n implements d {
    private String bKg = "";
    String bOX = null;
    private boolean dtt = false;
    private String fOt = null;
    boolean faL = false;
    VideoTransPara lem;
    private Point lfE = null;
    private boolean lgJ = false;
    int lhM;
    private int liA = 1600000;
    int liB = 480;
    int liC = 640;
    int liD;
    private String liE = null;
    private boolean liJ = false;
    boolean liK = false;
    boolean liM = false;
    int liN = 0;
    d$a liO;
    boolean liQ = true;
    private f liR = new 1(this);
    s lis;
    private String liv = "";
    private int liw = 0;
    private float lix = 0.0f;
    private int liy = 480;
    private int liz = 640;
    c ljf;
    q ljg;
    private m ljh;
    private HandlerThread lji;
    ag ljj;
    private int ljk = 0;
    b ljl = new b("yuvRecorderWriteData");
    b ljm = new b("frameCountCallback");
    Runnable ljn = null;
    private boolean ljo = false;
    private String mFileName;

    public n(VideoTransPara videoTransPara) {
        this.lem = videoTransPara;
        this.liy = videoTransPara.width;
        this.liz = videoTransPara.height;
        this.liA = videoTransPara.videoBitrate;
        k.bey();
        int bez = k.bez();
        if (bez == -1) {
            this.liA = videoTransPara.videoBitrate;
        } else {
            this.liA = bez;
        }
        this.lis = new s();
        x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[]{Integer.valueOf(this.liy), Integer.valueOf(this.liz), Integer.valueOf(this.liA)});
    }

    private boolean sS(int i) {
        long VG = bi.VG();
        this.lgJ = j.lgz.lgJ;
        int i2 = this.liA;
        this.lhM = SightVideoJNI.initDataBufferForMMSight(this.liB, this.liC, i, this.liy, this.liz, (float) this.lem.fps, i2, this.lem.dQI, 8, this.lem.dQH, 23.0f, false, false, this.lem.duration, false);
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[]{Integer.valueOf(this.lhM)});
        if (this.lhM < 0) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
            k.bdV();
            return false;
        }
        this.liD = i;
        this.ljg = new q(this.liB, this.liC, this.liy, this.liz, this.liA, this.lem.dQG, this.lem.fps, this.lgJ);
        int cQ = this.ljg.cQ(this.lhM, i);
        int i3 = 0;
        int i4 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i4 = CaptureMMProxy.getInstance().getInt(a.sUL, -1);
        }
        if (i4 < 0) {
            this.ljf = new g(this.lem.audioSampleRate, this.lem.dQF);
            this.ljf.gt(this.ljo);
            i3 = this.ljf.at(this.lhM, d.Lm(this.liv));
            if (cQ < 0 || i3 < 0) {
                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(cQ), Integer.valueOf(i3)});
                if (i3 < 0 && cQ >= 0) {
                    x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
                    this.ljf.clear();
                    this.ljf = new i(this.lem.audioSampleRate, this.lem.dQF);
                    this.ljf.gt(this.ljo);
                    x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[]{Integer.valueOf(this.ljf.at(this.lhM, d.Lm(this.liv)))});
                    if (this.ljf.at(this.lhM, d.Lm(this.liv)) >= 0) {
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(this.lhM);
                k.bdV();
                return false;
            }
        }
        if (i4 == 1) {
            this.ljf = new g(this.lem.audioSampleRate, this.lem.dQF);
            this.ljf.gt(this.ljo);
            i3 = this.ljf.at(this.lhM, d.Lm(this.liv));
        } else if (i4 == 2) {
            this.ljf = new i(this.lem.audioSampleRate, this.lem.dQF);
            this.ljf.gt(this.ljo);
            i3 = this.ljf.at(this.lhM, d.Lm(this.liv));
        }
        if (cQ < 0 || i3 < 0) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(cQ), Integer.valueOf(i3)});
            SightVideoJNI.releaseBigSightDataBuffer(this.lhM);
            k.bdV();
            return false;
        }
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        return true;
    }

    public final boolean sQ(int i) {
        if (this.dtt) {
            return true;
        }
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
        boolean sS = sS(i);
        this.dtt = true;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[]{Boolean.valueOf(sS)});
        return sS;
    }

    public final int d(int i, boolean z, int i2) {
        int i3 = -1;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        this.ljl.reset();
        this.liw = 0;
        this.ljm.reset();
        this.liK = false;
        this.faL = z;
        this.liN = i2;
        this.lis.a(c.lhB);
        if (bi.oW(this.liv)) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
        } else {
            try {
                this.mFileName = e.cq(this.liv);
                String mK = FileOp.mK(this.liv);
                if (!mK.endsWith("/")) {
                    mK = mK + "/";
                }
                this.liE = mK + "tempRotate.mp4";
            } catch (Exception e) {
                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[]{e.getMessage()});
            }
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[]{this.liv, this.liE});
            this.liD = i;
            this.lji = com.tencent.mm.sdk.f.e.cZ("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
            this.lji.start();
            this.ljj = new 2(this, this.lji.getLooper());
            if (!this.dtt) {
                sS(i);
                this.dtt = true;
            }
            i3 = this.ljf.a(new 3(this));
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[]{Integer.valueOf(i3)});
            this.liM = false;
            if (i3 != 0) {
                this.lis.a(c.lhI);
            } else {
                this.lis.a(c.lhJ);
            }
            k.bdT();
            x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
            h.mEJ.a(440, 2, 1, false);
        }
        return i3;
    }

    public final void E(Runnable runnable) {
        this.ljn = runnable;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[]{runnable});
        if (this.ljg == null || this.ljf == null) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                ah.A(runnable);
            }
        } else if (this.lis == null || this.lis.ljK != c.lhF) {
            this.liR = null;
            this.liw = (int) this.ljg.beD();
            if (this.lis != null) {
                this.lis.a(c.lhD);
            }
            this.ljg.a(new 4(this));
            this.ljf.a(new 5(this));
        } else {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
            if (this.ljf != null) {
                this.ljf.clear();
            }
            if (this.ljg != null) {
                this.ljg.clear();
            }
            if (runnable != null) {
                ah.A(runnable);
            }
        }
    }

    final boolean beC() {
        long VG = bi.VG();
        if (!(this.lji == null || this.ljj == null)) {
            if (com.tencent.mm.compatible.util.d.fR(18)) {
                this.lji.quitSafely();
            } else {
                this.lji.quit();
            }
            this.ljj = null;
        }
        this.lix = (((float) this.ljg.frameCount) * 1000.0f) / ((float) this.liw);
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s", new Object[]{Integer.valueOf(r2), Float.valueOf(this.lix), Integer.valueOf(this.liw), this.liv, Long.valueOf(bi.bI(VG))});
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[]{this.ljm.getValue()});
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[]{this.ljl.getValue()});
        String str = null;
        if (CaptureMMProxy.getInstance() != null) {
            str = CaptureMMProxy.getInstance().getAccVideoPath();
        } else if (!bi.oW(this.liv)) {
            str = new File(this.liv).getParentFile().getAbsolutePath();
        }
        String Hn = !bi.oW(str) ? com.tencent.mm.plugin.mmsight.d.Hn(str) : this.liv;
        this.ljh = new m(this.lhM, Hn, this.lix, this.liA, this.liw, this.lem.audioSampleRate);
        VG = bi.VG();
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[]{Long.valueOf(bi.bI(VG)), Boolean.valueOf(this.ljh.bev())});
        if (this.ljh.bev()) {
            if ((this.faL && this.lgJ) || (!(this.lgJ || this.faL) || ((this.faL && Math.abs(this.liD - this.liN) == 0) || this.liN == 180))) {
                long VG2 = bi.VG();
                int i = (this.lgJ || this.faL) ? this.lgJ ? this.liN : 180 : this.liD;
                if (this.liN == 180 && !this.lgJ) {
                    i += 180;
                    if (i > 360) {
                        i -= 360;
                    }
                }
                SightVideoJNI.tagRotateVideo(Hn, this.liE, i);
                this.liJ = true;
                x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[]{Long.valueOf(bi.bI(VG2)), Integer.valueOf(this.liD), Boolean.valueOf(this.faL), Integer.valueOf(this.liN), Integer.valueOf(i)});
                VG = bi.VG();
                try {
                    FileOp.deleteFile(Hn);
                    FileOp.av(this.liE, Hn);
                    x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[]{Long.valueOf(bi.bI(VG))});
                    com.tencent.mm.sdk.f.e.post(new 7(this, this.liE), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
                    return false;
                }
            }
            SightVideoJNI.releaseBigSightDataBuffer(this.lhM);
            this.lis.a(c.lhF);
            this.bKg = g.cu(Hn);
            if (!(bi.oW(Hn) || Hn.equals(this.liv))) {
                FileOp.av(Hn, this.liv);
                FileOp.deleteFile(Hn);
            }
            return true;
        }
        x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
        h.mEJ.a(440, 31, 1, false);
        return false;
    }

    public final String Xh() {
        return bi.aG(this.bKg, "");
    }

    public final void cancel() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
        if (this.ljg == null || this.ljf == null) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            return;
        }
        this.lis.a(c.lhE);
        this.ljg.a(null);
        this.ljf.a(new 8(this));
        if (!(this.lji == null || this.ljj == null)) {
            this.ljj.removeMessages(0);
            this.lji.quit();
            this.ljj = null;
        }
        SightVideoJNI.releaseBigSightDataBuffer(this.lhM);
        this.lis.a(c.lhF);
        reset();
    }

    public final void clear() {
        try {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
            if (this.ljf != null) {
                this.ljf.clear();
            }
            if (this.ljg != null) {
                this.ljg.clear();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", e, "clear error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void setFilePath(String str) {
        this.liv = str;
    }

    public final void Hr(String str) {
        this.bOX = str;
    }

    public final void Hs(String str) {
        this.fOt = str;
    }

    public final String bej() {
        return this.fOt;
    }

    public final String getFilePath() {
        return this.liv;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final float bek() {
        return this.lix;
    }

    public final void reset() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[]{this.ljg, this.ljf, this.ljh});
        this.ljg = null;
        this.ljf = null;
        this.ljh = null;
        this.dtt = false;
        this.liM = false;
    }

    public final long bel() {
        if (this.ljg != null) {
            return this.ljg.beD();
        }
        return 0;
    }

    public final f bem() {
        return this.liR;
    }

    public final void p(int i, int i2, int i3, int i4) {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.liy = i3;
        this.liz = i4;
        this.liB = i;
        this.liC = i2;
        if (j.lin.i(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3)});
            long VG = bi.VG();
            for (int i5 = 0; i5 < 3; i5++) {
                j.lin.F(new byte[(((i * i2) * 3) / 2)]);
            }
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        }
    }

    public final String aRw() {
        return this.bOX;
    }

    public final c ben() {
        return this.lis.ljK;
    }

    public final int beo() {
        return Math.round(((float) this.liw) / 1000.0f);
    }

    public final Point bep() {
        return new Point(this.liB, this.liC);
    }

    public final int beq() {
        return this.liD;
    }

    public final void pause() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
        if (this.lis != null && this.lis.ljK == c.lhC) {
            this.lis.a(c.lhK);
        }
    }

    public final void O(int i, int i2, int i3) {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        if (this.lis != null && this.lis.ljK == c.lhK) {
            if (this.ljg != null) {
                q qVar = this.ljg;
                qVar.ljx = i;
                qVar.ljy = i2;
                qVar.ljz = i3;
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            this.lis.a(c.lhC);
        }
    }

    public final boolean ber() {
        return this.liM;
    }

    public final void a(d$a d_a) {
        this.liO = d_a;
    }

    public final boolean bdK() {
        return this.faL;
    }

    public final void bes() {
        this.ljo = true;
    }

    public final com.tencent.mm.e.b.c.a bet() {
        return this.ljf != null ? this.ljf.beg() : null;
    }

    public final void beu() {
        this.liQ = false;
    }
}
