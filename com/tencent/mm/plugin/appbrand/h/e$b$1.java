package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.plugin.appbrand.h.e.a;
import com.tencent.mm.plugin.appbrand.h.e.b;
import com.tencent.mm.protocal.c.bni;
import java.util.LinkedList;

class e$b$1 implements Runnable {
    final /* synthetic */ b gkh;

    e$b$1(b bVar) {
        this.gkh = bVar;
    }

    public final void run() {
        LinkedList linkedList = new LinkedList();
        for (a aVar : b.a(this.gkh).values()) {
            if (aVar.alm()) {
                bni bni = new bni();
                bni.slo = aVar.dzR;
                bni.bPS = aVar.appId;
                linkedList.add(bni);
            }
        }
        this.gkh.v(linkedList);
    }
}
