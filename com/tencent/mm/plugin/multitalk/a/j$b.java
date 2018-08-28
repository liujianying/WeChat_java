package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;

public class j$b implements Runnable {
    final /* synthetic */ j lui;

    public j$b(j jVar) {
        this.lui = jVar;
    }

    public final void run() {
        this.lui.luh.iKs = true;
        if (this.lui.luh.jDx != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.lui.ltC != null) {
                this.lui.ltC.a(q.GF(), this.lui.luh.jDx, this.lui.luh.luk, this.lui.luh.angle);
            }
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
            this.lui.luh.iKs = false;
        }
        try {
            Thread.sleep(20);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoNativeReceiver", e, "", new Object[0]);
        }
    }
}
