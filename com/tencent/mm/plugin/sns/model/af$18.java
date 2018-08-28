package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

class af$18 extends c<kv> {
    final /* synthetic */ af nqT;

    af$18(af afVar) {
        this.nqT = afVar;
        this.sFo = kv.class.getName().hashCode();
    }

    private static boolean a(kv kvVar) {
        ArrayList arrayList = kvVar.bVg.bQh;
        o byo = af.byo();
        h FO = af.FO();
        long dO = FO.dO(-1);
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                n xd = byo.xd((int) longValue);
                if (xd != null) {
                    xd.field_localFlag |= 64;
                    x.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[]{Long.valueOf(longValue)});
                    byo.b((int) longValue, xd);
                }
            }
            return false;
        } finally {
            FO.gp(dO);
        }
    }
}
