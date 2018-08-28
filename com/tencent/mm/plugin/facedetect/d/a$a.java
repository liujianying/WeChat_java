package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.c.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class a$a implements Runnable {
    final /* synthetic */ a iOG;
    private Runnable iOH;

    /* synthetic */ a$a(a aVar, Runnable runnable, byte b) {
        this(aVar, runnable);
    }

    private a$a(a aVar, Runnable runnable) {
        this.iOG = aVar;
        this.iOH = null;
        this.iOH = runnable;
    }

    public final void run() {
        synchronized (this.iOG) {
            if (a.a(this.iOG)) {
                x.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
            } else {
                x.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
                a.a(this.iOG, a.ath() + bi.VG() + ".spx");
                try {
                    new File(a.b(this.iOG)).delete();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "hy: delete file failed", new Object[0]);
                }
                a.a(this.iOG, new c(16000, 1, 3));
                a.c(this.iOG).bDQ = -19;
                a.c(this.iOG).aM(false);
                a.a(this.iOG, new d());
                if (a.d(this.iOG).df(a.b(this.iOG))) {
                    if (q.deW.ddI > 0) {
                        a.c(this.iOG).t(q.deW.ddI, true);
                    } else {
                        a.c(this.iOG).t(5, false);
                    }
                    a.c(this.iOG).ey(50);
                    a.c(this.iOG).aN(false);
                    try {
                        a.a(this.iOG, new com.tencent.mm.modelvoiceaddr.a.c(5000, com.tencent.mm.modelvoiceaddr.a.c.duR.getInt("sil_time", 200), com.tencent.mm.modelvoiceaddr.a.c.duR.getFloat("s_n_ration", 2.5f), com.tencent.mm.modelvoiceaddr.a.c.duR.getInt("s_window", 50), com.tencent.mm.modelvoiceaddr.a.c.duR.getInt("s_length", 35), com.tencent.mm.modelvoiceaddr.a.c.duR.getInt("s_delay_time", 20), false, false));
                        a.g(this.iOG).erk = a.f(this.iOG);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + e2.getMessage());
                        if (a.e(this.iOG) != null) {
                            a.e(this.iOG).onError(6);
                        }
                    }
                    a.c(this.iOG).bEb = this.iOG.iOF;
                    this.iOG.a(a.h(this.iOG));
                    if (!a.c(this.iOG).wn()) {
                        x.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
                        if (a.e(this.iOG) != null) {
                            a.e(this.iOG).onError(7);
                        }
                    } else if (this.iOH != null) {
                        this.iOH.run();
                    }
                } else {
                    x.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
                    a.d(this.iOG).wA();
                    a.a(this.iOG, null);
                    if (a.e(this.iOG) != null) {
                        a.e(this.iOG).onError(5);
                    }
                }
            }
        }
    }
}
