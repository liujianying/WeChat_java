package com.tencent.mm.modelstat;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.by.c;
import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.network.x;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;

public class q implements ar {
    private static HashMap<Integer, d> cVM;
    private n dOT = new 3(this);
    private l ekX = new l();
    private h<m> ekY = new h(new c<m>() {
        public final /* synthetic */ Object get() {
            return new m(g.Ei().dqq);
        }
    });
    private x ekZ = new x();
    private h<g> ela = new h(new 2(this));

    public static g Sh() {
        g.Eg().Ds();
        return (g) Si().ela.get();
    }

    private static q Si() {
        return (q) p.v(q.class);
    }

    public static m Sj() {
        g.Eg().Ds();
        return (m) Si().ekY.get();
    }

    public static void e(e eVar) {
        boolean z;
        String str = "MicroMsg.SubCoreStat";
        String str2 = "dknetstat setNetworkMoniter  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        if (eVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = bi.cjd();
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Si().ekX);
        }
    }

    public static void f(e eVar) {
        String str = "MicroMsg.SubCoreStat";
        String str2 = "setKVReportMonitor  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(eVar == null);
        objArr[1] = bi.cjd();
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (eVar != null) {
            eVar.a(Si().ekZ);
        }
    }

    public final void onAccountRelease() {
        g.Eh().b(this.dOT);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(9998), this.ekX);
        this.ekX = new l();
        a.dBs = null;
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new 4());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(9998), this.ekX);
        g.Eh().a(this.dOT);
        a.dBs = new am.e() {
            public final void aY(int i, int i2) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), bi.cjd()});
                n.aY(i, i2);
            }
        };
    }

    public final void bo(boolean z) {
    }
}
