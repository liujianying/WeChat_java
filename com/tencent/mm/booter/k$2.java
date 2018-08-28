package com.tencent.mm.booter;

import com.tencent.mm.g.a.dl;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.List;

class k$2 implements a {
    k$2() {
    }

    public final boolean vD() {
        try {
            au.HU();
            Boolean valueOf = Boolean.valueOf(bi.a((Boolean) c.DT().get(aa.a.sRU, null), false));
            List<String> AJ = g.AU().AJ();
            if (AJ != null) {
                for (String str : AJ) {
                    x.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + valueOf + ",iBeacon = %s", new Object[]{str});
                    dl dlVar = new dl();
                    dlVar.bLj.bLl = str;
                    dlVar.bLj.bLi = false;
                    if (!valueOf.booleanValue()) {
                        com.tencent.mm.sdk.b.a.sFg.m(dlVar);
                    }
                }
                ang ang = new ang();
                ang.latitude = (double) k.xJ();
                ang.longitude = (double) k.xK();
                au.HU();
                long a = bi.a((Long) c.DT().get(aa.a.sRL, null), 0);
                if (k.xL().size() <= 0 || k.xM().booleanValue() || k.xN().size() <= 0) {
                    au.HU();
                    c.DT().a(aa.a.sRQ, "");
                } else {
                    k.b(Boolean.valueOf(true));
                    d dVar = new d(k.xN(), a, ang);
                    x.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + a + ",beaconInfos size " + k.xN().size() + ",info:" + k.xN().toString());
                    au.DF().a(1708, new 1(this, dVar));
                    au.DF().a(dVar, 0);
                }
                k.xL().clear();
                k.xN().clear();
                com.tencent.mm.sdk.b.a.sFg.c(k.xO());
            }
        } catch (Exception e) {
            x.e("MicroMsg.PostTaskStartRangeForIBeacon", e.getMessage());
        }
        return false;
    }
}
