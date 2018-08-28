package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public class k extends a {
    protected boolean jzn = false;

    public k(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet) {
        this.jzn = false;
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.jst = hashSet;
        iVar.jsv = this;
        iVar.handler = agVar;
        iVar.jsn = 1;
        iVar.jss = 3;
        return ((n) g.n(n.class)).search(3, iVar);
    }

    protected void a(j jVar, HashSet<String> hashSet) {
        if (bk(jVar.jsx)) {
            e.a aVar = new e.a();
            aVar.iPZ = -2;
            aVar.jrx = jVar.jrx;
            aVar.jte = jVar.jsx;
            if (aVar.jte.size() > 3) {
                if (((l) jVar.jsx.get(3)).jrv.equals("create_talker_message​")) {
                    aVar.jtd = false;
                    aVar.jte = aVar.jte.subList(0, 4);
                } else {
                    aVar.jtd = true;
                    aVar.jte = aVar.jte.subList(0, 3);
                }
            } else if (jVar.jsx.size() == 1 && ((l) jVar.jsx.get(0)).jrv.equals("create_talker_message​")) {
                aVar.jtb = false;
            }
            this.jvp.add(aVar);
        }
    }

    protected com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        int i2;
        int i3 = i - aVar.jta;
        if (aVar.jtb) {
            i2 = i3 - 1;
        } else {
            i2 = i3;
        }
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.jte.size() && i2 >= 0) {
            l lVar = (l) aVar.jte.get(i2);
            if (lVar.jrv.equals("create_talker_message​")) {
                com.tencent.mm.plugin.fts.ui.a.i iVar = new com.tencent.mm.plugin.fts.ui.a.i(i);
                iVar.jym = aVar.jte.size() == 1;
                this.jzn = true;
                aVar2 = iVar;
            } else {
                m mVar = new m(i);
                mVar.fyJ = lVar;
                mVar.cF(lVar.type, lVar.jru);
                aVar2 = mVar;
            }
        }
        if (aVar2 != null) {
            aVar2.jtm = i2 + 1;
            aVar2.jrx = aVar.jrx;
        }
        return aVar2;
    }

    public int getType() {
        return 112;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.View r10, com.tencent.mm.plugin.fts.a.d.a.a r11, boolean r12) {
        /*
        r9 = this;
        r8 = 14756; // 0x39a4 float:2.0678E-41 double:7.2904E-320;
        r7 = 2;
        r1 = 1;
        r2 = 0;
        r0 = r11 instanceof com.tencent.mm.plugin.fts.ui.a.m;
        if (r0 == 0) goto L_0x001a;
    L_0x0009:
        r0 = r9.aQR();
        r3 = r9.jzn;
        r4 = r11.jtq;
        r5 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r4 != r5) goto L_0x001a;
    L_0x0015:
        r4 = r11.pageType;
        switch(r4) {
            case 1: goto L_0x001b;
            case 2: goto L_0x001b;
            case 3: goto L_0x001b;
            case 4: goto L_0x001b;
            case 5: goto L_0x0059;
            default: goto L_0x001a;
        };
    L_0x001a:
        return r2;
    L_0x001b:
        r0 = r11.pageType;
    L_0x001d:
        r4 = "%s,%s,%s";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r6 = r11.aQj();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r2] = r6;
        r0 = java.lang.Integer.valueOf(r0);
        r5[r1] = r0;
        if (r3 == 0) goto L_0x0061;
    L_0x0035:
        r0 = r1;
    L_0x0036:
        r0 = java.lang.Integer.valueOf(r0);
        r5[r7] = r0;
        r0 = java.lang.String.format(r4, r5);
        r3 = "MicroMsg.FTS.FTSReportLogic";
        r4 = "reportFTSGlobalMsgResultClick: %d, %s";
        r5 = new java.lang.Object[r7];
        r6 = java.lang.Integer.valueOf(r8);
        r5[r2] = r6;
        r5[r1] = r0;
        com.tencent.mm.sdk.platformtools.x.v(r3, r4, r5);
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1.k(r8, r0);
        goto L_0x001a;
    L_0x0059:
        if (r0 != r1) goto L_0x005d;
    L_0x005b:
        r0 = 6;
        goto L_0x001d;
    L_0x005d:
        if (r0 != r7) goto L_0x001a;
    L_0x005f:
        r0 = 5;
        goto L_0x001d;
    L_0x0061:
        r0 = r2;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.d.k.a(android.view.View, com.tencent.mm.plugin.fts.a.d.a.a, boolean):boolean");
    }

    protected int aQR() {
        return 0;
    }
}
