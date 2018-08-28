package com.tencent.c.e.a;

import com.tencent.c.e.a.a.c;
import com.tencent.c.e.a.a.e;
import com.tencent.c.e.a.a.h;
import com.tencent.c.e.a.b.a;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class e$4 extends c {
    final /* synthetic */ e vjJ;
    final /* synthetic */ e vjN;
    final /* synthetic */ String vjO;

    e$4(e eVar, e eVar2, String str) {
        this.vjJ = eVar;
        this.vjN = eVar2;
        this.vjO = str;
    }

    public final void cFm() {
        Map cFt = h.cFs().cFt();
        Map hashMap = new HashMap();
        if (cFt.size() != 0) {
            h$a d = h.d(cFt, 0);
            if (d != null) {
                hashMap.put(d.vke, d.vkf);
            }
            d = h.d(cFt, 1);
            if (d != null) {
                hashMap.put(d.vke, d.vkf);
            }
            h$a d2 = h.d(cFt, 2);
            if (d2 != null) {
                hashMap.put(d2.vke, d2.vkf);
            }
        }
        if (hashMap.size() == 0) {
            this.vjN.ZZ();
            return;
        }
        for (a aVar : hashMap.keySet()) {
            aVar.vkm = System.currentTimeMillis();
            aVar.vkn = this.vjO;
            boolean a = this.vjN instanceof a ? e.a((a) this.vjN, aVar) : this.vjN instanceof c ? e.a((c) this.vjN, aVar) : false;
            if (a) {
                for (String file : (List) hashMap.get(aVar)) {
                    try {
                        new File(file).delete();
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public final void cFn() {
        if (e.f(this.vjJ) != null) {
            e.f(this.vjJ);
        }
    }
}
