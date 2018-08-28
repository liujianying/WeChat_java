package com.tencent.mm.model;

import com.tencent.mm.model.w.1;

class w$1$1 implements Runnable {
    final /* synthetic */ c dBh;
    final /* synthetic */ 1 dBi;

    w$1$1(1 1, c cVar) {
        this.dBi = 1;
        this.dBh = cVar;
    }

    public final void run() {
        if (this.dBi.dBg.dBf != null) {
            this.dBi.dBg.dBf.c(this.dBh.url, this.dBh.filename, this.dBh.pos);
        }
    }
}
