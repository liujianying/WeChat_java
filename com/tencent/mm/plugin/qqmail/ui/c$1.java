package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.g.a.ju;

class c$1 implements Runnable {
    final /* synthetic */ ju fah;
    final /* synthetic */ c mhQ;

    c$1(c cVar, ju juVar) {
        this.mhQ = cVar;
        this.fah = juVar;
    }

    public final void run() {
        if (this.fah.bTJ.bJm) {
            c.a(this.mhQ);
        } else if (c.b(this.mhQ) != null) {
            c.b(this.mhQ).boA();
        }
    }
}
