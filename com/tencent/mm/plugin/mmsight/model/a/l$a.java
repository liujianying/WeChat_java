package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Process;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class l$a implements Runnable {
    Runnable bJX = null;
    int duration;
    final /* synthetic */ l liS;
    int liT;
    volatile int liU = 0;
    float liV;
    volatile boolean liW = true;
    boolean liX = false;
    boolean liY = false;
    boolean liZ = false;
    boolean lja = false;
    final Object ljb = new Object();

    public l$a(l lVar) {
        this.liS = lVar;
        synchronized (this.ljb) {
            try {
                String mK = FileOp.mK(lVar.liv);
                if (!mK.endsWith("/")) {
                    mK = mK + "/";
                }
                lVar.liE = mK + "tempRotate.mp4";
            } catch (Exception e) {
                x.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void run() {
        if (this.liS.liI == -1) {
            this.liS.liI = Process.myTid();
            Process.setThreadPriority(Process.myTid(), -2);
            x.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[]{Integer.valueOf(this.liS.liI)});
        }
        synchronized (this.ljb) {
            long VG;
            while (!this.liY) {
                VG = bi.VG();
                int triggerEncode = SightVideoJNI.triggerEncode(this.liT, Math.max(0, this.liU), false);
                x.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(this.liU), Integer.valueOf(triggerEncode), Long.valueOf(Thread.currentThread().getId())});
                if (Math.abs(triggerEncode - this.liU) <= 5) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        x.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
                    }
                }
                this.liU = triggerEncode;
            }
            VG = bi.VG();
            if (!this.liZ) {
                this.liU = SightVideoJNI.triggerEncode(this.liT, this.liU, true);
            }
            x.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(this.liU), Boolean.valueOf(this.liZ), Long.valueOf(Thread.currentThread().getId())});
            if (!this.liZ) {
                this.liS.liu = new m(this.liT, this.liS.liv, this.liV, this.liS.liA, Math.max(1000, this.duration), this.liS.lem.audioSampleRate);
                VG = bi.VG();
                x.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[]{Long.valueOf(bi.bI(VG)), Boolean.valueOf(this.liS.liu.bev())});
                if (!this.liS.liu.bev()) {
                    x.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
                    SightVideoJNI.releaseBigSightDataBuffer(this.liT);
                    ah.A(new Runnable() {
                        public final void run() {
                            if (l$a.this.liS.liO != null) {
                                l$a.this.liS.liO.ZZ();
                            }
                        }
                    });
                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
                    h.mEJ.a(440, 30, 1, false);
                    return;
                } else if ((this.liS.faL && this.liS.lgJ) || (!(this.liS.lgJ || this.liS.faL) || ((this.liS.faL && Math.abs(this.liS.liD - this.liS.liN) == 0) || this.liS.liN == 180))) {
                    int i;
                    long VG2 = bi.VG();
                    if (!this.liS.lgJ && !this.liS.faL) {
                        i = this.liS.liD;
                    } else if (this.liS.lgJ) {
                        i = this.liS.liN;
                    } else {
                        i = 180;
                    }
                    if (this.liS.liN == 180 && !this.liS.lgJ) {
                        i += 180;
                        if (i > 360) {
                            i -= 360;
                        }
                    }
                    SightVideoJNI.tagRotateVideo(this.liS.liv, this.liS.liE, i);
                    x.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[]{Long.valueOf(bi.bI(VG2)), Integer.valueOf(this.liS.liD), Boolean.valueOf(this.liS.faL), Integer.valueOf(this.liS.liN), Integer.valueOf(i)});
                    String str = this.liS.liE;
                    try {
                        FileOp.y(this.liS.liE, this.liS.liv);
                        e.post(new 3(this, str), "BigSightFFMpegRecorder_tagRotate_after_process");
                        x.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[]{Long.valueOf(bi.bI(VG2))});
                    } catch (Exception e2) {
                        x.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
                        SightVideoJNI.releaseBigSightDataBuffer(this.liT);
                        ah.A(new Runnable() {
                            public final void run() {
                                if (l$a.this.liS.liO != null) {
                                    l$a.this.liS.liO.ZZ();
                                }
                            }
                        });
                        return;
                    }
                }
            }
            SightVideoJNI.releaseBigSightDataBuffer(this.liT);
            x.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[]{this.bJX});
            this.liS.reset();
            ah.A(this.bJX);
            this.lja = true;
            this.liS.liI = -1;
            this.liS.liH = -1;
        }
    }
}
