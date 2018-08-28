package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ boolean[] gmQ;
    final /* synthetic */ c jIM;
    final /* synthetic */ b jIN;
    final /* synthetic */ b jIO;

    c$2(c cVar, boolean[] zArr, b bVar, b bVar2) {
        this.jIM = cVar;
        this.gmQ = zArr;
        this.jIN = bVar;
        this.jIO = bVar2;
    }

    public final void run() {
        boolean z = true;
        x.i("MicroMsg.GameWebPageContainer", "loadUrl costTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - c.b(this.jIM))});
        if (!this.gmQ[0]) {
            this.gmQ[0] = true;
            synchronized (this.jIM) {
                if (this.jIN != null) {
                    c cVar = this.jIM;
                    b bVar = this.jIN;
                    boolean booleanExtra = c.c(this.jIM).getBooleanExtra("finish_recent_page", false);
                    if (c.c(this.jIM).getBooleanExtra("transparent_page", false)) {
                        z = false;
                    }
                    c.a(cVar, bVar, booleanExtra, z);
                }
                c.a(this.jIM, this.jIO);
            }
        }
    }
}
