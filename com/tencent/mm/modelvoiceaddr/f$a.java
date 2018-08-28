package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.e.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class f$a implements Runnable {
    final /* synthetic */ f eqI;

    private f$a(f fVar) {
        this.eqI = fVar;
    }

    public /* synthetic */ f$a(f fVar, byte b) {
        this(fVar);
    }

    public final void run() {
        synchronized (this.eqI) {
            x.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
            long nanoTime = System.nanoTime() & 4294967295L;
            if (nanoTime < 0) {
                nanoTime = Math.abs(nanoTime);
            }
            String valueOf = String.valueOf(nanoTime);
            try {
                File file = new File(f.bP());
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(f.Ua());
                if (!file.exists()) {
                    file.createNewFile();
                }
                file.delete();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "delete file failed", new Object[0]);
            }
            f.a(this.eqI, new c(16000, 1, 3));
            f.a(this.eqI).bDQ = -19;
            f.a(this.eqI).aM(false);
            f.a(this.eqI, new com.tencent.mm.e.c.c(16000, 23900));
            if (f.b(this.eqI).df(f.Ua())) {
                if (q.deW.ddI > 0) {
                    f.a(this.eqI).t(q.deW.ddI, true);
                } else {
                    f.a(this.eqI).t(5, false);
                }
                f.a(this.eqI).ey(50);
                f.a(this.eqI).aN(false);
                try {
                    f.a(this.eqI, new com.tencent.mm.modelvoiceaddr.a.c());
                    f.d(this.eqI).erk = f.c(this.eqI);
                    com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100235");
                    f.a(this.eqI, new b(f.Ua(), valueOf, String.valueOf(fJ.isValid() ? bi.getInt((String) fJ.ckq().get("MMVoipVadOn"), 0) : 0)));
                    f.a(this.eqI).bEb = f.e(this.eqI);
                    if (!f.a(this.eqI).wn()) {
                        x.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
                        this.eqI.bs(8, -1);
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "init VoiceDetectAPI failed", new Object[0]);
                    this.eqI.bs(7, -1);
                }
            } else {
                x.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
                f.b(this.eqI).wA();
                f.a(this.eqI, null);
                this.eqI.bs(5, -1);
            }
        }
    }
}
