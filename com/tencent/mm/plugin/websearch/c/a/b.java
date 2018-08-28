package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.c.a.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b implements c {
    Map<a, a> diQ = new HashMap();
    Map<a, CountDownLatch> pNa = new ConcurrentHashMap();
    private l pNb = new 1(this);
    private l pNc = new l() {
        public final void b(j jVar) {
            a aVar = (a) jVar.jsw.jrq;
            if (aVar != null) {
                a aVar2 = (a) b.this.diQ.remove(aVar);
                if (aVar2 != null) {
                    switch (jVar.bjW) {
                        case -3:
                        case -2:
                        case -1:
                            aVar.cL(Collections.emptyList());
                            break;
                        case 0:
                            if (jVar.jsx != null && jVar.jsx.size() != 0) {
                                aVar.cL(jVar.jsx);
                                break;
                            }
                            x.i("FTSMatchContact", "local contact search size 0");
                            aVar2.bTt();
                            return;
                            break;
                    }
                    aVar2.bTt();
                }
            }
        }
    };

    public final a Qb(String str) {
        a eVar = new e(str);
        CountDownLatch countDownLatch = (CountDownLatch) this.pNa.get(eVar);
        if (countDownLatch != null) {
            x.i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", new Object[]{str, Integer.valueOf(Integer.MAX_VALUE)});
        } else if (a(eVar, this.pNb)) {
            x.i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", new Object[]{str, Integer.valueOf(Integer.MAX_VALUE)});
            countDownLatch = new CountDownLatch(1);
            this.pNa.put(eVar, countDownLatch);
        } else {
            x.i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", new Object[]{str, Integer.valueOf(Integer.MAX_VALUE)});
        }
        if (countDownLatch != null) {
            try {
                countDownLatch.await(2000, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                x.printErrStackTrace("FTSMatchContact", e, "", new Object[0]);
            }
        }
        this.pNa.remove(eVar);
        return eVar;
    }

    public final void a(a aVar, a aVar2) {
        this.diQ.put(aVar, aVar2);
        a(aVar, this.pNc);
    }

    private static boolean a(a aVar, l lVar) {
        if (bi.oW(aVar.bWm)) {
            return false;
        }
        int[] iArr = new int[]{131072};
        int[] iArr2 = new int[]{1, 5};
        i iVar = new i();
        iVar.bWm = aVar.bWm;
        iVar.jsq = iArr;
        iVar.jsr = iArr2;
        iVar.jss = aVar.pMZ;
        iVar.jsu = com.tencent.mm.plugin.fts.a.c.b.jsU;
        iVar.jst = new HashSet();
        iVar.jsv = lVar;
        iVar.scene = 1;
        ((n) g.n(n.class)).search(2, iVar).jrq = aVar;
        return true;
    }
}
