package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.l.a;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.cgr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;
import java.util.List;

public enum m {
    ;
    
    public static Integer fmn;

    static {
        fmn = null;
    }

    static void a(int i, int i2, int i3, b bVar) {
        if (bVar != null && (((akt) bVar.dID.dIL).condition & 2) != 0) {
            aku aku = (aku) bVar.dIE.dIL;
            if (i2 == 0 && i3 == 0 && aku != null) {
                if (e.abh() != null) {
                    l abh = e.abh();
                    List<cgr> list = aku.rNI;
                    long dO = abh.fhY.dO(Thread.currentThread().getId());
                    abh.fhY.delete("AppBrandStarApp", "", null);
                    a aVar = new a();
                    for (cgr cgr : list) {
                        if (!bi.oW(cgr.username)) {
                            aVar.field_username = cgr.username;
                            aVar.field_versionType = cgr.rka;
                            aVar.field_updateTime = (long) cgr.rqg;
                            abh.fhY.insert("AppBrandStarApp", null, aVar.wH());
                        }
                    }
                    abh.fhY.gp(dO);
                    abh.b("batch", 3, list);
                    n.a(i, null, aku.rNI);
                }
                g.Ei().DT().a(aa.a.sTz, Boolean.valueOf((aku.status & 1) > 0));
            }
        }
    }
}
