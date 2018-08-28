package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.a.f$b;
import com.tencent.mm.plugin.backup.b.b.b;
import java.util.LinkedList;

class b$3 implements Runnable {
    final /* synthetic */ b gSb;
    final /* synthetic */ b gSc;
    final /* synthetic */ LinkedList gSd;
    final /* synthetic */ f$b gSe;
    final /* synthetic */ int gSf;

    public b$3(b bVar, b bVar2, LinkedList linkedList, f$b f_b, int i) {
        this.gSb = bVar;
        this.gSc = bVar2;
        this.gSd = linkedList;
        this.gSe = f_b;
        this.gSf = i;
    }

    public final void run() {
        if (!this.gSb.gRY && this.gSc != null) {
            this.gSc.a(this.gSd, this.gSe, this.gSf);
        }
    }
}
