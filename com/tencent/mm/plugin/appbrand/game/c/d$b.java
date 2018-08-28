package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.plugin.appbrand.game.c.d.c;

class d$b implements Runnable {
    private c fBo;
    private c fBr;

    private d$b() {
    }

    /* synthetic */ d$b(byte b) {
        this();
    }

    public final void run() {
        if (this.fBo != null && this.fBr != null) {
            this.fBr.j(this);
        }
    }
}
