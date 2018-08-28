package com.tencent.mm.plugin.base.model;

import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ d$a hdx;
    final /* synthetic */ c hdz;

    d$3(c cVar, d$a d_a, String str) {
        this.hdz = cVar;
        this.hdx = d_a;
        this.dhF = str;
    }

    public final void run() {
        x.i("MicroMsg.WebviewShrotcutManager", "expired");
        if (d.KC().contains(this.hdz)) {
            d.KC().remove(this.hdz);
            q.Kp().b(this.hdz);
            if (this.hdx != null) {
                this.hdx.dF(false);
            }
        }
    }
}
