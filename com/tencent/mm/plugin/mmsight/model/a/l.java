package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.c.g;
import com.tencent.mm.e.b.c$a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class l implements d {
    String bKg = "";
    String bOX = null;
    private boolean dtt = false;
    private String fOt = null;
    boolean faL = false;
    VideoTransPara lem;
    boolean lgJ = false;
    int liA = 1600000;
    int liB = 480;
    int liC = 640;
    int liD = 0;
    String liE = null;
    private HandlerThread liF = null;
    ag liG = null;
    int liH = -1;
    int liI = -1;
    private boolean liJ = false;
    boolean liK = false;
    private int liL = -1;
    boolean liM = false;
    int liN = 0;
    a liO;
    boolean liP = false;
    boolean liQ = true;
    private f liR = new f() {
        public final boolean T(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            if (l.this.lis.ljK != c.lhC) {
                return false;
            }
            l lVar = l.this;
            if (!lVar.liK && lVar.liQ) {
                lVar.liK = true;
                Object obj = new byte[bArr.length];
                System.arraycopy(bArr, 0, obj, 0, bArr.length);
                e.post(new 6(lVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
            }
            if (l.this.liG == null) {
                return true;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            l.this.liG.sendMessage(obtain);
            return true;
        }
    };
    c liq;
    p lir;
    s lis;
    a lit = null;
    e liu;
    String liv = "";
    int liw = 0;
    float lix = 0.0f;
    private int liy = 480;
    private int liz = 640;
    private String mFileName;

    public l(VideoTransPara videoTransPara) {
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
        this.dtt = false;
        x.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[]{Integer.valueOf(this.liy), Integer.valueOf(this.liz), Integer.valueOf(this.liA), Integer.valueOf(bez)});
    }

    public final void p(int i, int i2, int i3, int i4) {
        x.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.liy = i3;
        this.liz = i4;
        this.liB = i;
        this.liC = i2;
        if (j.lin.c(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            x.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3)});
            long VG = bi.VG();
            for (int i5 = 0; i5 < 3; i5++) {
                j.lin.aQ(new byte[(((i * i2) * 3) / 2)]);
            }
            x.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        }
    }

    public final String aRw() {
        return this.bOX;
    }

    private boolean sR(int i) {
        if (this.lit == null || this.lit.lja) {
            return false;
        }
        if (!this.lit.liX) {
            this.lit.bJX = null;
            this.lit.liZ = true;
            this.lit.liY = true;
            e.remove(this.lit);
        }
        synchronized (this.lit.ljb) {
            SightVideoJNI.releaseBigSightDataBuffer(i);
            if (this.lit.liT != i) {
                SightVideoJNI.releaseBigSightDataBuffer(this.lit.liT);
            }
        }
        return true;
    }

    public final void clear() {
        boolean z;
        boolean z2 = false;
        int i = -1;
        if (this.lir != null) {
            i = this.lir.ljv;
            if (i < 0) {
                x.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
                return;
            }
            this.lir.stop();
        }
        if (this.liq != null) {
            this.liq.a(null);
        }
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        if (this.lit == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.lit != null) {
            z2 = this.lit.liZ;
        }
        objArr[2] = Boolean.valueOf(z2);
        x.v(str, str2, objArr);
        if (i >= 0 && !sR(i)) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseBigSightDataBuffer(i);
        }
    }

    public final void cancel() {
        x.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
        this.lis.a(c.lhE);
        clear();
        this.lis.a(c.lhF);
    }

    public final void E(final Runnable runnable) {
        boolean z;
        boolean z2 = true;
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.lit == null);
        if (this.lit == null || !this.lit.liX) {
            z = false;
        } else {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.lit == null || !this.lit.liY) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        x.i(str, str2, objArr);
        if (this.lit == null || !this.lit.liX) {
            e.post(new Runnable() {
                public final void run() {
                    l lVar = l.this;
                    Runnable runnable = runnable;
                    lVar.lis.a(c.lhE);
                    if (lVar.lir != null) {
                        int i = lVar.lir.ljv;
                        float beD = (((float) lVar.lir.frameCount) * 1000.0f) / ((float) lVar.lir.beD());
                        x.i("MicroMsg.MMSightFFMpegRecorder", "stop, bufID %d, frameCount %d, duration %dms, %.6ffps", new Object[]{Integer.valueOf(i), Integer.valueOf(lVar.lir.frameCount), Long.valueOf(lVar.lir.beD()), Float.valueOf(beD)});
                        lVar.liw = (int) lVar.lir.beD();
                        lVar.lix = beD;
                        lVar.lir.stop();
                        if (lVar.lit != null) {
                            lVar.lit.liV = beD;
                            lVar.lit.duration = lVar.liw;
                            lVar.lit.bJX = runnable;
                            lVar.lit.liX = true;
                            e.remove(lVar.lit);
                        }
                    }
                    if (!(lVar.liq == null || lVar.liP)) {
                        lVar.liq.a(new 3(lVar));
                    }
                    lVar.lis.a(c.lhF);
                    lVar.bKg = g.cu(lVar.liv);
                    if (lVar.lit == null) {
                        x.e("MicroMsg.MMSightFFMpegRecorder", "encodeRunnable is null!, directly call stopcallback");
                        lVar.reset();
                        ah.A(runnable);
                    }
                    if (lVar.liP) {
                        lVar.bei();
                    }
                }
            }, "MMSightFFMpegRecorder_stop");
            return;
        }
        synchronized (this.lit.ljb) {
            reset();
            ah.A(runnable);
        }
    }

    final void bei() {
        if (this.lit != null) {
            this.lit.liY = true;
        }
    }

    public final String Xh() {
        return bi.aG(this.bKg, "");
    }

    public final c ben() {
        return this.lis.ljK;
    }

    public final long bel() {
        return this.lir.beD();
    }

    public final f bem() {
        return this.liR;
    }

    public final String getFilePath() {
        return this.liv;
    }

    public final String getFileName() {
        return this.mFileName;
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

    public final void reset() {
        x.i("MicroMsg.MMSightFFMpegRecorder", "reset");
        this.lis.ljK = c.lhF;
        this.liM = false;
        if (this.liq != null) {
            this.liq.clear();
        }
        if (this.lir != null) {
            p pVar = this.lir;
            SightVideoJNI.releaseBigSightDataBuffer(pVar.ljv);
            pVar.ljv = -1;
            synchronized (p.class) {
                pVar.frameCount = 0;
            }
            pVar.hng = 0;
        }
        clear();
    }

    private boolean sS(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long VG = bi.VG();
        this.lgJ = j.lgz.lgJ;
        this.liD = i;
        if (this.lgJ) {
            i2 = (i == 0 || i == 180) ? this.liB : this.liC;
            i3 = (i == 0 || i == 180) ? this.liC : this.liB;
            i4 = (i == 0 || i == 180) ? this.liy : this.liz;
            if (i == 0 || i == 180) {
                i5 = this.liz;
            } else {
                i5 = this.liy;
            }
        } else {
            i6 = (i == 0 || i == 180) ? this.liB : this.liC;
            i3 = (i == 0 || i == 180) ? this.liC : this.liB;
            i4 = this.liy;
            i5 = this.liz;
            i2 = i6;
        }
        i6 = SightVideoJNI.initDataBufferForMMSight(i2, i3, i, i4, i5, (float) this.lem.fps, this.liA, this.lem.dQI, 8, this.lem.dQH, 23.0f, this.lgJ, true, this.lem.duration, false);
        if (i6 < 0) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
            k.bdU();
            return false;
        }
        this.liL = i6;
        this.lir = new p(this.lgJ, i, i4, i5);
        i4 = this.lir.sT(i6);
        i2 = 0;
        i3 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i3 = CaptureMMProxy.getInstance().getInt(aa.a.sUL, -1);
        }
        if (i3 < 0) {
            this.liq = new g(this.lem.audioSampleRate, this.lem.dQF);
            this.liq.gt(this.liP);
            i2 = this.liq.at(i6, d.Lm(this.liv));
            if (i4 < 0 || i2 < 0) {
                x.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2)});
                if (i2 < 0 && i4 >= 0) {
                    x.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
                    this.liq.clear();
                    this.liq = new i(this.lem.audioSampleRate, this.lem.dQF);
                    this.liq.gt(this.liP);
                    x.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[]{Integer.valueOf(this.liq.at(i6, d.Lm(this.liv)))});
                    if (this.liq.at(i6, d.Lm(this.liv)) >= 0) {
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(i6);
                k.bdU();
                return false;
            }
        }
        if (i3 == 1) {
            this.liq = new g(this.lem.audioSampleRate, this.lem.dQF);
            this.liq.gt(this.liP);
            i2 = this.liq.at(i6, d.Lm(this.liv));
        } else if (i3 == 2) {
            this.liq = new i(this.lem.audioSampleRate, this.lem.dQF);
            this.liq.gt(this.liP);
            i2 = this.liq.at(i6, d.Lm(this.liv));
        }
        if (i4 < 0 || i2 < 0) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2)});
            SightVideoJNI.releaseBigSightDataBuffer(i6);
            k.bdU();
            return false;
        }
        x.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        return true;
    }

    public final boolean sQ(int i) {
        if (this.dtt) {
            return true;
        }
        x.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        boolean sS = sS(i);
        this.dtt = true;
        x.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[]{Boolean.valueOf(sS)});
        return sS;
    }

    public final int d(int i, boolean z, int i2) {
        x.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[]{this.lis.ljK, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        this.faL = z;
        this.liw = 0;
        this.liN = i2;
        this.lis.a(c.lhB);
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]";
        Object[] objArr = new Object[3];
        objArr[0] = this.liv;
        objArr[1] = Boolean.valueOf(this.lit == null);
        objArr[2] = Boolean.valueOf(this.lit == null ? true : this.lit.lja);
        x.i(str, str2, objArr);
        if (this.lit != null && !this.lit.lja) {
            x.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
            return -1;
        } else if (bi.oW(this.liv)) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
            return -1;
        } else {
            int i3;
            this.mFileName = com.tencent.mm.a.e.cq(this.liv);
            x.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[]{this.liv});
            this.liD = i;
            x.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[]{Integer.valueOf(this.liD)});
            if (!this.dtt) {
                sS(i);
                this.dtt = true;
            }
            p pVar = this.lir;
            if (0 == pVar.hng) {
                pVar.hng = System.currentTimeMillis();
            }
            if (this.liP) {
                i3 = 0;
            } else {
                i3 = this.liq.a(new 4(this));
            }
            x.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[]{Integer.valueOf(i3)});
            this.liF = e.cZ("BigSightWriteCameraData", 0);
            this.liF.start();
            this.liG = new 5(this, this.liF.getLooper());
            this.liM = false;
            if (i3 != 0) {
                this.lis.a(c.lhI);
            } else {
                this.lis.a(c.lhJ);
            }
            k.bdT();
            x.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
            h.mEJ.a(440, 1, 1, false);
            if (!this.liP) {
                return i3;
            }
            beh();
            return i3;
        }
    }

    final void beh() {
        x.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
        if (!(this.lit == null || this.lit.lja)) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[]{this.lit});
            synchronized (this.lit.ljb) {
                sR(this.lit.liT);
            }
        }
        if (this.lis.ljK != c.lhJ) {
            x.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
            return;
        }
        this.lis.a(c.lhC);
        this.lit = new a(this);
        this.lit.liT = this.liL;
        e.b(this.lit, "SightCustomAsyncMediaRecorder_encode_" + bi.VG(), 5);
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
        x.i("MicroMsg.MMSightFFMpegRecorder", "pause");
        if (this.lis != null && this.lis.ljK == c.lhC) {
            this.lis.a(c.lhK);
        }
    }

    public final void O(int i, int i2, int i3) {
        x.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        if (this.lis != null && this.lis.ljK == c.lhK) {
            if (this.lir != null) {
                p pVar = this.lir;
                x.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                pVar.ljx = i;
                pVar.ljy = i2;
                pVar.ljz = i3;
            }
            this.lis.a(c.lhC);
        }
    }

    public final boolean ber() {
        return this.liM;
    }

    public final void a(a aVar) {
        this.liO = aVar;
    }

    public final boolean bdK() {
        return this.faL;
    }

    public final void bes() {
        this.liP = true;
    }

    public final c$a bet() {
        return this.liq != null ? this.liq.beg() : null;
    }

    public final void beu() {
        this.liQ = false;
    }

    public final float bek() {
        return this.lix;
    }
}
