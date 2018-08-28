package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.b.a;
import java.util.LinkedList;

class b$2 implements Runnable {
    final /* synthetic */ a gRZ;
    final /* synthetic */ LinkedList gSa;
    final /* synthetic */ b gSb;

    b$2(b bVar, a aVar, LinkedList linkedList) {
        this.gSb = bVar;
        this.gRZ = aVar;
        this.gSa = linkedList;
    }

    public final void run() {
        if (!this.gSb.gRY && this.gRZ != null) {
            this.gRZ.y(this.gSa);
        }
    }
}
