package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.model.au;

class d$1 implements Runnable {
    final /* synthetic */ String dUN;
    final /* synthetic */ int oCo;
    final /* synthetic */ d qqm;

    d$1(d dVar, String str, int i) {
        this.qqm = dVar;
        this.dUN = str;
        this.oCo = i;
    }

    public final void run() {
        d.b(this.qqm).a(this.dUN, d.a(this.qqm));
        if (d.c(this.qqm) || this.oCo != -50006) {
            au.Em().h(new Runnable() {
                public final void run() {
                    d.b(d$1.this.qqm).b(d.d(d$1.this.qqm), d.a(d$1.this.qqm));
                }
            }, 80);
        }
    }
}
