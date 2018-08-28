package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.appbrand.r.k.b;
import com.tencent.mm.plugin.appbrand.r.k.e;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.List;

class a$9 implements Runnable {
    final /* synthetic */ a gyS;
    final /* synthetic */ i gyY;
    final /* synthetic */ b gyZ;

    a$9(a aVar, i iVar, b bVar) {
        this.gyS = aVar;
        this.gyY = iVar;
        this.gyZ = bVar;
    }

    public final void run() {
        a.a(this.gyS).clear();
        a.a(this.gyS).addAll(this.gyY);
        ah.Db(-8);
        b bVar = this.gyZ;
        l d = a.d(this.gyS);
        l jVar = d instanceof j ? (j) d : new j(d);
        List arrayList = new ArrayList();
        int i = bVar.gBV;
        int size = bVar.gBR.size() - 1;
        int i2 = bVar.gBW;
        while (size >= 0) {
            e eVar = (e) bVar.gBR.get(size);
            int i3 = eVar.size;
            int i4 = eVar.x + i3;
            int i5 = eVar.y + i3;
            if (i4 < i) {
                bVar.b(arrayList, jVar, i4, i - i4, i4);
            }
            if (i5 < i2) {
                bVar.a(arrayList, jVar, i4, i2 - i5, i5);
            }
            for (i4 = i3 - 1; i4 >= 0; i4--) {
                if ((bVar.gBS[eVar.x + i4] & 31) == 2) {
                    jVar.d(eVar.x + i4, 1, bVar.gBU.bX(eVar.x + i4, eVar.y + i4));
                }
            }
            i = eVar.x;
            size--;
            i2 = eVar.y;
        }
        jVar.aoz();
    }
}
