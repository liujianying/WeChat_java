package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.p.b;
import com.tencent.mm.plugin.qqmail.b.p.d;

class p$1 implements Runnable {
    final /* synthetic */ d mdf;
    final /* synthetic */ p mdg;

    p$1(p pVar, d dVar) {
        this.mdg = pVar;
        this.mdf = dVar;
    }

    public final void run() {
        b bVar = new b(this.mdg, (byte) 0);
        p.a(this.mdg).put(Long.valueOf(this.mdf.id), this.mdf);
        p.b(this.mdg).put(Long.valueOf(this.mdf.id), bVar);
        bVar.b(this.mdf);
    }
}
