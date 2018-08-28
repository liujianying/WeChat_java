package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class i$2 implements a {
    i$2() {
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandUsage storage change: event=%s | eventData=%s", new Object[]{str, lVar});
        k sQ;
        List<String> list;
        List arrayList;
        switch (lVar.fBN) {
            case 2:
            case 3:
                if (!"batch".equals(str)) {
                    sQ = i.sQ(lVar.obj.toString());
                    if (sQ != null) {
                        e.abo().a(i.b(sQ), true);
                        return;
                    }
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    list = (List) lVar.obj;
                    arrayList = new ArrayList();
                    for (String sQ2 : list) {
                        sQ = i.sQ(sQ2);
                        if (sQ != null) {
                            arrayList.add(i.b(sQ));
                        }
                    }
                    e.abo().d(arrayList, true);
                    return;
                } else {
                    return;
                }
            case 5:
                if (!"batch".equals(str)) {
                    e.abo().U(lVar.obj.toString(), true);
                    return;
                } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                    list = (List) lVar.obj;
                    arrayList = new ArrayList();
                    for (String sQ22 : list) {
                        sQ = i.sQ(sQ22);
                        if (sQ != null) {
                            com.tencent.mm.plugin.appbrand.game.a.a.a b = i.b(sQ);
                            if (b != null) {
                                arrayList.add(b.dfX);
                            }
                        }
                    }
                    e.abo().an(arrayList);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
