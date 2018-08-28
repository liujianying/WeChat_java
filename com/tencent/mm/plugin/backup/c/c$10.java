package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.c.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class c$10 implements Runnable {
    final /* synthetic */ c gUr;
    final /* synthetic */ LinkedBlockingQueue gUt;

    c$10(c cVar, LinkedBlockingQueue linkedBlockingQueue) {
        this.gUr = cVar;
        this.gUt = linkedBlockingQueue;
    }

    public final void run() {
        while (!c.n(this.gUr)) {
            a aVar;
            try {
                aVar = (a) this.gUt.poll(500, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                aVar = null;
            }
            x.d("MicroMsg.BackupMoveRecoverServer", "datapushQueue size:%d, startNext receiveData:%s", new Object[]{Integer.valueOf(this.gUt.size()), aVar});
            if (aVar != null) {
                this.gUr.a(aVar.gbk, aVar.type, aVar.buf, aVar.egS);
            }
        }
    }
}
