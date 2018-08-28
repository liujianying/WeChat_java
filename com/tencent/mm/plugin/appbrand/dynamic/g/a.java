package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.c.aqm;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.protocal.c.chy;

public final class a extends com.tencent.mm.ab.a<aqn> {
    private int bPh;
    public final b diG;
    private int fwV;
    public j fxo;

    public a(String str, boolean z, chy chy) {
        aqm aqm = new aqm();
        aqm.jQb = str;
        aqm.rSZ = chy;
        aqm.rKO = z ? 1 : 2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 1181;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
        aVar.dIG = aqm;
        aVar.dIH = new aqn();
        b KT = aVar.KT();
        this.diG = KT;
        this.diG = KT;
        this.fwV = chy.sBT;
        this.bPh = com.tencent.mm.plugin.appbrand.dynamic.k.b.bH(this.fwV, chy.rRb);
    }

    private String getAppId() {
        return ((aqm) this.diG.dID.dIL).jQb;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.protocal.c.aqn r14) {
        /*
        r10 = this;
        r9 = 3;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r0 = "MicroMsg.CgiLaunchWxaWidget";
        r1 = "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s";
        r2 = 4;
        r2 = new java.lang.Object[r2];
        r3 = java.lang.Integer.valueOf(r11);
        r2[r6] = r3;
        r3 = java.lang.Integer.valueOf(r12);
        r2[r7] = r3;
        r2[r8] = r13;
        r3 = r10.getAppId();
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        if (r11 != 0) goto L_0x00a3;
    L_0x0026:
        if (r12 != 0) goto L_0x00a3;
    L_0x0028:
        if (r14 == 0) goto L_0x00a3;
    L_0x002a:
        r1 = r10.getAppId();
        r0 = com.tencent.mm.plugin.appbrand.widget.a.a.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.appbrand.widget.a.a) r0;
        r0 = r0.abc();
        r2 = r10.bPh;
        r3 = r10.fwV;
        r0 = r0.a(r1, r2, r3, r14);
        r10.fxo = r0;
        r0 = r14.rTb;
        if (r0 == 0) goto L_0x0084;
    L_0x0048:
        r0 = com.tencent.mm.plugin.appbrand.a.c.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.appbrand.a.c) r0;
        r0 = r0.aaN();
        r2 = r10.bPh;
        r0 = r0.ai(r1, r2);
        r2 = new com.tencent.mm.protocal.c.cgw;
        r2.<init>();
        r2.sBd = r0;
        r0 = r14.rTb;
        r0 = r0.riv;
        r2.riv = r0;
        r0 = r10.bPh;
        r3 = 10102; // 0x2776 float:1.4156E-41 double:4.991E-320;
        if (r0 != r3) goto L_0x0085;
    L_0x006d:
        r0 = r14.rTb;
        r0 = r0.sAy;
        r2.sBc = r0;
        r0 = com.tencent.mm.plugin.appbrand.a.c.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.appbrand.a.c) r0;
        r0 = r0.aaN();
        r3 = r10.bPh;
        r0.a(r1, r2, r3);
    L_0x0084:
        return;
    L_0x0085:
        r0 = r10.bPh;
        r3 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        if (r0 != r3) goto L_0x0084;
    L_0x008b:
        r0 = r14.rTb;
        r0 = r0.sAx;
        r2.sBc = r0;
        r0 = com.tencent.mm.plugin.appbrand.a.c.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.appbrand.a.c) r0;
        r0 = r0.aaN();
        r3 = r10.bPh;
        r0.a(r1, r2, r3);
        goto L_0x0084;
    L_0x00a3:
        r2 = com.tencent.mm.plugin.appbrand.dynamic.j.aeV();
        r3 = r10.getAppId();
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x012e;
    L_0x00b1:
        r0 = r2.fuI;
        r0 = r0.entrySet();
        r4 = r0.iterator();
    L_0x00bb:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x012e;
    L_0x00c1:
        r0 = r4.next();
        r1 = r0;
        r1 = (java.util.Map.Entry) r1;
        r0 = r1.getValue();
        if (r0 == 0) goto L_0x00bb;
    L_0x00ce:
        r0 = r1.getValue();
        r0 = (com.tencent.mm.plugin.appbrand.dynamic.j.b) r0;
        r0 = r0.appId;
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x00bb;
    L_0x00dc:
        r0 = r1.getKey();
        r0 = (java.lang.String) r0;
    L_0x00e2:
        r1 = 626; // 0x272 float:8.77E-43 double:3.093E-321;
        r3 = 7;
        r2.C(r0, r1, r3);
        r0 = com.tencent.mm.plugin.appbrand.widget.a.a.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.appbrand.widget.a.a) r0;
        r1 = r0.abc();
        r2 = r10.getAppId();
        r3 = r10.bPh;
        r4 = r10.fwV;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r0 != 0) goto L_0x0132;
    L_0x0102:
        r0 = new com.tencent.mm.plugin.appbrand.widget.j;
        r0.<init>();
        r5 = r2.hashCode();
        r0.field_appIdHash = r5;
        r0.field_appId = r2;
        r0.field_pkgType = r3;
        r0.field_widgetType = r4;
        r2 = new java.lang.String[r9];
        r3 = "appId";
        r2[r6] = r3;
        r3 = "pkgType";
        r2[r7] = r3;
        r3 = "widgetType";
        r2[r8] = r3;
        r1 = r1.b(r0, r2);
        if (r1 == 0) goto L_0x0132;
    L_0x012a:
        r10.fxo = r0;
        goto L_0x0084;
    L_0x012e:
        r0 = "";
        goto L_0x00e2;
    L_0x0132:
        r0 = 0;
        goto L_0x012a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.g.a.a(int, int, java.lang.String, com.tencent.mm.protocal.c.aqn):void");
    }
}
