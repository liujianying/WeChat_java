package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.b.a;
import java.util.LinkedList;

class b$1 implements Runnable {
    final /* synthetic */ a gRZ;
    final /* synthetic */ LinkedList gSa;
    final /* synthetic */ b gSb;

    b$1(b bVar, a aVar, LinkedList linkedList) {
        this.gSb = bVar;
        this.gRZ = aVar;
        this.gSa = linkedList;
    }

    public final void run() {
        if (this.gRZ != null) {
            this.gRZ.y(this.gSa);
        }
    }
}
