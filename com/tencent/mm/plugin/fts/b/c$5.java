package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.sdk.platformtools.al.a;

class c$5 implements a {
    final /* synthetic */ c jux;

    c$5(c cVar) {
        this.jux = cVar;
    }

    public final boolean vD() {
        if (!this.jux.juq) {
            this.jux.juq = true;
            this.jux.dhW.a(131112, new c$a(this.jux, (byte) 0));
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.jux.juu);
        return false;
    }

    public final String toString() {
        return super.toString() + "|mBackgroundTimer";
    }
}
