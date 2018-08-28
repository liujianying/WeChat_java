package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.ac.z;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.r.c;

class a$1 implements c {
    final /* synthetic */ a hqX;

    a$1(a aVar) {
        this.hqX = aVar;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            if (aVar.sNY == b.sOa && aVar.sNZ != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a.a(this.hqX).size()) {
                        break;
                    }
                    if (aVar.sNZ.field_orderFlag > ((q) a.a(this.hqX).get(i2)).field_orderFlag) {
                        a.a(this.hqX).add(i2, aVar.sNZ);
                        break;
                    }
                    i = i2 + 1;
                }
            } else if (aVar.sNY == b.sOb) {
                a aVar2 = this.hqX;
                q avf = aVar2.avf();
                if (avf != null) {
                    aVar2.gxs.clear();
                    aVar2.gxs.addAll(z.Ne().gh(avf.field_orderFlag));
                }
            }
        }
        a.b(this.hqX).avn();
        this.hqX.notifyDataSetChanged();
    }
}
