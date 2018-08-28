package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;

class b$1 implements Runnable {
    final /* synthetic */ int kPA;
    final /* synthetic */ int kPB;
    final /* synthetic */ int qBM;
    final /* synthetic */ boolean qBN;
    final /* synthetic */ b qBO;

    b$1(b bVar, int i, int i2, int i3, boolean z) {
        this.qBO = bVar;
        this.kPA = i;
        this.kPB = i2;
        this.qBM = i3;
        this.qBN = z;
    }

    public final void run() {
        s Tn = a.ccH().Tn(i.ex(this.kPA, this.kPB));
        if (Tn == null) {
            return;
        }
        if (-1 == this.qBM || String.valueOf(this.qBM).equals(Tn.field_fileVersion)) {
            Tn.field_needRetry = !this.qBN;
            a.ccH().g(Tn);
        }
    }
}
