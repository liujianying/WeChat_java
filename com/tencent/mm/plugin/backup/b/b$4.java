package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.b.b;
import java.util.LinkedList;

class b$4 implements Runnable {
    final /* synthetic */ b gSb;
    final /* synthetic */ b gSc;
    final /* synthetic */ LinkedList gSd;

    public b$4(b bVar, b bVar2, LinkedList linkedList) {
        this.gSb = bVar;
        this.gSc = bVar2;
        this.gSd = linkedList;
    }

    public final void run() {
        if (!this.gSb.gRY && this.gSc != null) {
            this.gSc.z(this.gSd);
        }
    }
}
