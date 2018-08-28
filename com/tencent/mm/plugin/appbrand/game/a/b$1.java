package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.game.a.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class b$1 implements a {
    final /* synthetic */ b fAD;

    b$1(b bVar) {
        this.fAD = bVar;
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.FTS.FTS5SearchMiniGameLogic", "MiniGame storage change: event=%s | eventData=%s", new Object[]{str, lVar});
        List arrayList;
        switch (lVar.fBN) {
            case 2:
            case 3:
                if (!"batch".equals(str)) {
                    arrayList = new ArrayList();
                    arrayList.add(lVar.obj.toString());
                    this.fAD.dhW.a(65601, new b(this.fAD, arrayList));
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    this.fAD.dhW.a(65601, new b(this.fAD, (List) lVar.obj));
                    return;
                } else {
                    return;
                }
            case 5:
                if (!"batch".equals(str)) {
                    arrayList = new ArrayList();
                    arrayList.add(lVar.obj.toString());
                    this.fAD.dhW.a(65601, new b$a(this.fAD, arrayList));
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    this.fAD.dhW.a(65601, new b$a(this.fAD, (List) lVar.obj));
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
