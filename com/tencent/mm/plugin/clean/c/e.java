package com.tencent.mm.plugin.clean.c;

import android.os.Looper;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.ArrayList;

public final class e extends Thread implements com.tencent.mm.plugin.clean.c.a.a.a {
    private ag dvh = new ag(Looper.getMainLooper());
    private long endTime = 0;
    private b hQO;
    private int hQQ = 0;
    private int hQR = 0;
    private h hRg;
    private ArrayList<a> hRh;
    private int hRi = 0;
    private boolean isStop;
    private long startTime = 0;

    class a extends com.tencent.mm.plugin.clean.c.a.a {
        private a hRk;

        public a(a aVar) {
            super(e.this);
            this.hRk = aVar;
        }

        public final void execute() {
            au.HU();
            bd dW = c.FT().dW(this.hRk.bIZ);
            if (dW.field_msgId != 0) {
                dW.cmv();
                au.HU();
                c.FT().a(this.hRk.bIZ, dW);
            }
            File file = new File(this.hRk.filePath);
            e.this.hRi = (int) (((long) e.this.hRi) + file.length());
            file.delete();
        }
    }

    public e(b bVar, h hVar, ArrayList<a> arrayList) {
        this.hQO = bVar;
        this.hRg = hVar;
        this.hRh = arrayList;
    }

    public final void run() {
        this.startTime = System.currentTimeMillis();
        this.hQQ = this.hRh.size();
        x.d("MicroMsg.DeleteFileController", "totalTaskCount=%d", new Object[]{Integer.valueOf(this.hQQ)});
        if (this.hQQ == 0) {
            aAZ();
            return;
        }
        int i = 0;
        while (!this.isStop && i < this.hRh.size()) {
            x.d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", new Object[]{Integer.valueOf(i), ((a) this.hRh.get(i)).filePath});
            a aVar = new a(r0);
            while (!this.hQO.b(aVar)) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            x.d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", new Object[]{r0.filePath});
            i++;
        }
    }

    private void aAZ() {
        this.endTime = System.currentTimeMillis();
        x.i("MicroMsg.DeleteFileController", "totalUserTime:%d", new Object[]{Long.valueOf(this.endTime - this.startTime)});
        if (this.hRg != null && !this.isStop) {
            this.dvh.post(new 2(this));
        }
    }

    public final void aBr() {
        x.i("MicroMsg.DeleteFileController", "stop analyseController");
        this.isStop = true;
        interrupt();
    }

    public final void a(com.tencent.mm.plugin.clean.c.a.a aVar) {
        interrupt();
        this.hQR++;
        if (!(this.hRg == null || this.isStop)) {
            this.dvh.post(new 1(this));
        }
        if (this.hQR == this.hQQ) {
            aAZ();
        }
    }
}
