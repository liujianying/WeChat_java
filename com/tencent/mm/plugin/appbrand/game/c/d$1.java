package com.tencent.mm.plugin.appbrand.game.c;

import java.util.LinkedList;

class d$1 implements Runnable {
    final /* synthetic */ d fBs;
    final /* synthetic */ String fwv;

    d$1(d dVar, String str) {
        this.fBs = dVar;
        this.fwv = str;
    }

    public final void run() {
        if (d.a(this.fBs) != null) {
            b a = d.a(this.fBs);
            String str = this.fwv;
            if (a.fBg) {
                a.a(str);
                return;
            }
            if (a.fBf == null) {
                a.fBf = new LinkedList();
            }
            a.fBf.add(str);
        }
    }
}
