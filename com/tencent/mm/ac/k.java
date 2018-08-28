package com.tencent.mm.ac;

import android.net.Uri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.pd;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.util.Iterator;
import java.util.LinkedList;

public final class k {
    private a cXs;
    int dMl;
    private c dMm;
    private int dMn;
    int dMo;
    boolean dMp;
    b dMq;
    String userName;

    protected k() {
        this.userName = null;
        this.dMl = 0;
        this.dMn = 2;
        this.dMo = 10;
        this.dMp = false;
        this.dMq = new 1(this);
        this.cXs = new a() {
            long lastReportTime = 0;

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                if (!z) {
                    return true;
                }
                x.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
                if (bi.VE() >= this.lastReportTime + ((long) k.this.dMo)) {
                    k.a(k.this.userName, 11, 0, f2, f, (int) d2, null);
                    this.lastReportTime = bi.VE();
                }
                if (k.this.dMl == 2) {
                    k.this.MR();
                }
                if (!k.this.dMp) {
                    k.this.dMp = true;
                    o.a(2013, f, f2, (int) d2);
                }
                return true;
            }
        };
        this.dMo = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AU().G("BrandService", "continueLocationReportInterval"), 5);
        if (this.dMo < this.dMn) {
            this.dMo = this.dMn;
        }
        x.i("MicroMsg.ReportLocation", "reportLocation interval %d", new Object[]{Integer.valueOf(this.dMo)});
    }

    public final void b(final String str, final bd bdVar) {
        if (bdVar == null || !bdVar.cky()) {
            a(str, 10, 0, 0.0f, 0.0f, 0, null);
        } else {
            g.Em().H(new Runnable() {
                public final void run() {
                    LinkedList linkedList = new LinkedList();
                    l wS = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(bdVar.field_content);
                    if (wS == null || bi.cX(wS.dzs)) {
                        k.a(str, 10, 0, 0.0f, 0.0f, 0, null);
                        return;
                    }
                    Iterator it = wS.dzs.iterator();
                    while (it.hasNext()) {
                        m mVar = (m) it.next();
                        String str = mVar.url;
                        if (!bi.oW(str)) {
                            Uri parse = Uri.parse(str);
                            try {
                                String queryParameter = parse.getQueryParameter("mid");
                                str = parse.getQueryParameter("idx");
                                pd pdVar = new pd();
                                pdVar.rty = bi.getLong(queryParameter, 0);
                                pdVar.mQH = bi.getInt(str, 0);
                                pdVar.bPS = mVar.dzH;
                                pdVar.path = mVar.dzE;
                                linkedList.add(pdVar);
                            } catch (UnsupportedOperationException e) {
                                x.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", new Object[]{e.getMessage()});
                            }
                        }
                    }
                    k.a(str, 10, 0, 0.0f, 0.0f, 0, linkedList);
                }
            });
        }
    }

    public static void kS(String str) {
        a(str, 12, 0, 0.0f, 0.0f, 0, null);
    }

    public final void kT(String str) {
        x.i("MicroMsg.ReportLocation", "Start report");
        this.userName = str;
        d kH = f.kH(str);
        if (kH != null) {
            if (this.dMl != 0) {
                MR();
            }
            this.dMl = 0;
            if (kH.LS()) {
                x.i("MicroMsg.ReportLocation", "need update contact %s", new Object[]{str});
                com.tencent.mm.aa.c.jN(str);
            }
            d.b bG = kH.bG(false);
            if (bG == null) {
                return;
            }
            if (bG.LU() && kH.LR()) {
                this.dMm = c.OB();
                bG = kH.bG(false);
                if (bG.dKT != null) {
                    boolean z;
                    if (bi.getInt(bG.dKT.optString("ReportLocationType"), 0) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bG.dLg = z;
                }
                this.dMl = bG.dLg ? 3 : 2;
                if (c.OC() || c.OD()) {
                    this.dMm.a(this.cXs, true);
                } else {
                    a(str, 11, 2, 0.0f, 0.0f, 0, null);
                }
            } else if (bG.LU() && !kH.LR()) {
                a(str, 11, 1, 0.0f, 0.0f, 0, null);
            }
        }
    }

    public final void MR() {
        x.i("MicroMsg.ReportLocation", "Stop report");
        this.dMl = 0;
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
        if (g.Eg().Dx()) {
            ((i) g.l(i.class)).FR().b(this.dMq);
        }
    }

    private static void a(String str, int i, int i2, float f, float f2, int i3, LinkedList<pd> linkedList) {
        String str2;
        if (i2 == 3) {
            str2 = "<event></event>";
        } else {
            str2 = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i3)});
        }
        x.i("MicroMsg.ReportLocation", "doScene, info: %s", new Object[]{str2});
        g.Eh().dpP.a(new q(str, i, str2, linkedList), 0);
    }
}
