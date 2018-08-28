package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.d;

public abstract class a<_Ret, _CmdStruct> implements com.tencent.mm.vending.c.a<_Ret, d<String, String, _CmdStruct>> {
    abstract String acp();

    abstract _Ret b(String str, String str2, _CmdStruct _cmdstruct);

    abstract chl bf(_CmdStruct _cmdstruct);

    public final /* synthetic */ Object call(Object obj) {
        Object obj2;
        d dVar = (d) obj;
        String str = (String) dVar.get(1);
        if (bi.oW(str)) {
            x.e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) invalid appId", new Object[]{acp()});
            obj2 = null;
        } else {
            chl bf = bf(dVar.get(2));
            if (bf == null) {
                x.e("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) null CmdBase", new Object[]{acp()});
                obj2 = null;
            } else {
                int i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) bf.sBs, (long) com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiZ.get(getClass()));
                long j = ((long) bf.sBq) & 4294967295L;
                x.i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s) DealEndTime %d , now %d", new Object[]{acp(), Long.valueOf(j), Long.valueOf(bi.VE())});
                int i2;
                if (j < bi.VE()) {
                    i2 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                    com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) bf.sBs, (long) com.tencent.mm.plugin.appbrand.appcache.a.c.a.fja.get(getClass()));
                    obj2 = null;
                } else {
                    long j2 = bi.getLong(e.abf().get("PredownloadCmdSequence$" + acp() + '$' + str, "0"), 0);
                    j = ((long) bf.sBr) & 4294967295L;
                    x.i("MicroMsg.AppBrand.Predownload.AbstractCmd", "precondition(%s), lastSeq %d, cmdSeq %d", new Object[]{acp(), Long.valueOf(j2), Long.valueOf(j)});
                    if (j2 > j) {
                        i2 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                        com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) bf.sBs, (long) com.tencent.mm.plugin.appbrand.appcache.a.c.a.fjb.get(getClass()));
                        obj2 = null;
                    } else if (j2 == j) {
                        i2 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                        com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) bf.sBs, (long) com.tencent.mm.plugin.appbrand.appcache.a.c.a.fjc.get(getClass()));
                        obj2 = null;
                    } else {
                        e.abf().bd("PredownloadCmdSequence$" + acp() + '$' + str, Long.toString(j));
                        obj2 = 1;
                    }
                }
            }
        }
        if (obj2 != null) {
            return b((String) dVar.get(0), (String) dVar.get(1), dVar.get(2));
        }
        g.cBF().ct(null);
        return null;
    }
}
