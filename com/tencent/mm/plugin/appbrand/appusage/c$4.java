package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.cgr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

class c$4 extends r {
    final /* synthetic */ c fld;
    final /* synthetic */ long flf;
    final /* synthetic */ Bundle flg;
    final /* synthetic */ int flh;
    final /* synthetic */ int fli;

    c$4(c cVar, int i, int i2, int i3, int i4, int i5, Bundle bundle, long j) {
        this.fld = cVar;
        this.flh = i4;
        this.fli = i5;
        this.flg = bundle;
        this.flf = j;
        super(i, i2, i3, 30);
    }

    protected final /* synthetic */ void a(int i, int i2, String str, bhp bhp, l lVar) {
        aku aku = (aku) bhp;
        if (g.Eg().Dx()) {
            String str2;
            if (aku == null) {
                str2 = "null";
            } else {
                Locale locale = Locale.US;
                String str3 = "%d %d %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(aku.rNI == null ? -1 : aku.rNI.size());
                objArr[1] = Integer.valueOf(aku.rNJ == null ? -1 : aku.rNJ.size());
                objArr[2] = Integer.valueOf(aku.status);
                str2 = String.format(locale, str3, objArr);
            }
            x.i("MicroMsg.AppBrandHistoryLogic", "onCgiBack, errType %d, errCode %d, errMsg %s, resp %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2});
            if (aku != null && i == 0 && i2 == 0) {
                if ((this.flh & 4) > 0 && !i.acR() && (aku.status & 8) > 0) {
                    i.acS();
                }
                g.Ei().DT().a(a.sTC, Boolean.valueOf((aku.status & 4) > 0));
                b.jI(aku.status);
                if (!bi.cX(aku.rNJ)) {
                    p abg = e.abg();
                    List<cgr> list = aku.rNJ;
                    p$a p_a = new p$a();
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    long dO = abg.fhY.dO(Thread.currentThread().getId());
                    for (cgr cgr : list) {
                        if (!bi.oW(cgr.username)) {
                            p_a.field_brandId = cgr.username;
                            p_a.field_versionType = cgr.rka;
                            p_a.field_scene = 2;
                            if (abg.fms.b(p_a, new String[0])) {
                                p_a.field_updateTime = Math.max((long) cgr.rqg, p_a.field_updateTime);
                                if (abg.fms.c(p_a, new String[0])) {
                                    linkedList2.add(String.valueOf(p_a.field_recordId));
                                }
                            } else {
                                p_a.field_updateTime = (long) cgr.rqg;
                                if (abg.a(p_a)) {
                                    linkedList.add(String.valueOf(p_a.field_recordId));
                                }
                            }
                        }
                    }
                    abg.fhY.gp(dO);
                    if (!bi.cX(linkedList)) {
                        abg.b("batch", 2, linkedList);
                    }
                    if (!bi.cX(linkedList2)) {
                        abg.b("batch", 3, linkedList2);
                    }
                    if (!bi.cX(aku.rNJ)) {
                        int i3;
                        int i4 = ((cgr) aku.rNJ.getFirst()).rqg;
                        Iterator it = aku.rNJ.iterator();
                        while (true) {
                            i3 = i4;
                            if (!it.hasNext()) {
                                break;
                            }
                            i4 = Math.min(i3, ((cgr) it.next()).rqg);
                        }
                        if (i3 > 0) {
                            g.Ei().DT().a(a.sTD, Long.valueOf((long) i3));
                        }
                    }
                    n.a(this.fli, this.flg, aku.rNJ);
                }
                m.a(this.fli, i, i2, (b) lVar.dJd);
            }
            this.fld.b("batch", 3, Long.valueOf(this.flf));
        }
    }
}
