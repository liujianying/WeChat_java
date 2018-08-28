package com.tencent.mm.plugin.radar.ui;

import com.tencent.mm.plugin.radar.ui.RadarSpecialGridView.a;

public final class RadarViewController$g implements a {
    final /* synthetic */ RadarViewController mmN;

    RadarViewController$g(RadarViewController radarViewController) {
        this.mmN = radarViewController;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(int r7, android.view.View r8) {
        /*
        r6 = this;
        r3 = 1;
        r2 = 0;
        r0 = "view";
        b.c.b.e.i(r8, r0);
        r0 = r6.mmN;
        r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r0);
        r0 = r0.mmP;
        r0 = r0[r7];
        r0 = (com.tencent.mm.protocal.c.beq) r0;
        if (r0 != 0) goto L_0x0017;
    L_0x0016:
        return;
    L_0x0017:
        r1 = r6.mmN;
        r1 = r1.getRadarStatus();
        r4 = com.tencent.mm.plugin.radar.ui.h.mlF;
        r1 = r1.ordinal();
        r1 = r4[r1];
        switch(r1) {
            case 1: goto L_0x003f;
            case 2: goto L_0x003f;
            case 3: goto L_0x00cd;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.mmJ;
        r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.access$getTAG$cp();
        r1 = "unknow status for grid view %s";
        r3 = new java.lang.Object[r3];
        r4 = r6.mmN;
        r4 = r4.getRadarStatus();
        r3[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r3);
        goto L_0x0016;
    L_0x003f:
        r1 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r4 = com.tencent.mm.plugin.radar.ui.g.b(r0);
        if (r0 == 0) goto L_0x0065;
    L_0x0047:
        r1 = r0.hbL;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x0053;
    L_0x004d:
        r1 = b.f.a.U(r1);
        if (r1 == 0) goto L_0x0095;
    L_0x0053:
        r1 = r3;
    L_0x0054:
        if (r1 == 0) goto L_0x0066;
    L_0x0056:
        r1 = r0.ryZ;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x0062;
    L_0x005c:
        r1 = b.f.a.U(r1);
        if (r1 == 0) goto L_0x0097;
    L_0x0062:
        r1 = r3;
    L_0x0063:
        if (r1 == 0) goto L_0x0066;
    L_0x0065:
        r2 = r3;
    L_0x0066:
        if (r2 != 0) goto L_0x0016;
    L_0x0068:
        r1 = r6.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r1);
        r1 = r1.mmU;
        r1 = r1.get(r4);
        r1 = (android.view.View) r1;
        r2 = r6.mmN;
        r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
        r2 = com.tencent.mm.plugin.radar.b.e.a(r2, r0);
        if (r1 == 0) goto L_0x00b9;
    L_0x0082:
        r3 = com.tencent.mm.plugin.radar.b.c.e.mjz;
        if (r2 == r3) goto L_0x00b9;
    L_0x0086:
        r1 = r1.getTag();
        if (r1 != 0) goto L_0x0099;
    L_0x008c:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder";
        r0.<init>(r1);
        throw r0;
    L_0x0095:
        r1 = r2;
        goto L_0x0054;
    L_0x0097:
        r1 = r2;
        goto L_0x0063;
    L_0x0099:
        r1 = (com.tencent.mm.plugin.radar.ui.RadarViewController.c.a) r1;
        r1 = r1.mmY;
        r1.bpG();
        r3 = new com.tencent.mm.sdk.platformtools.ag;
        r3.<init>();
        r1 = new com.tencent.mm.plugin.radar.ui.RadarViewController$g$a;
        r1.<init>(r6, r8, r0, r2);
        r0 = r1;
        r0 = (java.lang.Runnable) r0;
        r1 = com.tencent.mm.plugin.radar.ui.RadarStateView.mlM;
        r1 = com.tencent.mm.plugin.radar.ui.RadarStateView.bpH();
        r4 = (long) r1;
        r3.postDelayed(r0, r4);
        goto L_0x0016;
    L_0x00b9:
        r1 = r6.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.g(r1);
        r1.a(r8, r0, r2);
        r0 = r6.mmN;
        r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.f(r0);
        r0.bpP();
        goto L_0x0016;
    L_0x00cd:
        if (r0 == 0) goto L_0x00ed;
    L_0x00cf:
        r1 = r0.hbL;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x00db;
    L_0x00d5:
        r1 = b.f.a.U(r1);
        if (r1 == 0) goto L_0x0123;
    L_0x00db:
        r1 = r3;
    L_0x00dc:
        if (r1 == 0) goto L_0x0127;
    L_0x00de:
        r1 = r0.ryZ;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x00ea;
    L_0x00e4:
        r1 = b.f.a.U(r1);
        if (r1 == 0) goto L_0x0125;
    L_0x00ea:
        r1 = r3;
    L_0x00eb:
        if (r1 == 0) goto L_0x0127;
    L_0x00ed:
        r1 = r3;
    L_0x00ee:
        if (r1 != 0) goto L_0x013f;
    L_0x00f0:
        r1 = r6.mmN;
        r4 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r1);
        if (r0 == 0) goto L_0x0156;
    L_0x00f8:
        r1 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r1 = com.tencent.mm.plugin.radar.ui.g.b(r0);
        r5 = r4.mmN;
        r5 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r5);
        r5 = r5.mka;
        r5 = r5.containsKey(r1);
        if (r5 == 0) goto L_0x012b;
    L_0x010c:
        r5 = r4.mmN;
        r5 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r5);
        r5 = r5.mka;
        r1 = r5.get(r1);
        if (r1 != 0) goto L_0x0129;
    L_0x011a:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type kotlin.String";
        r0.<init>(r1);
        throw r0;
    L_0x0123:
        r1 = r2;
        goto L_0x00dc;
    L_0x0125:
        r1 = r2;
        goto L_0x00eb;
    L_0x0127:
        r1 = r2;
        goto L_0x00ee;
    L_0x0129:
        r1 = (java.lang.String) r1;
    L_0x012b:
        r4 = r4.mmQ;
        r1 = r4.containsKey(r1);
        if (r1 == 0) goto L_0x0156;
    L_0x0133:
        r1 = r3;
    L_0x0134:
        if (r1 != 0) goto L_0x0158;
    L_0x0136:
        r1 = r6.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r1);
        r1.d(r0);
    L_0x013f:
        r1 = r6.mmN;
        r1 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r1);
        r1.a(r0);
        com.tencent.mm.plugin.radar.ui.RadarViewController.bpM();
        r0 = r6.mmN;
        r0 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r0);
        r0.bpx();
        goto L_0x0016;
    L_0x0156:
        r1 = r2;
        goto L_0x0134;
    L_0x0158:
        r1 = r6.mmN;
        r4 = com.tencent.mm.plugin.radar.ui.RadarViewController.d(r1);
        if (r0 == 0) goto L_0x017e;
    L_0x0160:
        r1 = r0.hbL;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x016c;
    L_0x0166:
        r1 = b.f.a.U(r1);
        if (r1 == 0) goto L_0x01b1;
    L_0x016c:
        r1 = r3;
    L_0x016d:
        if (r1 == 0) goto L_0x01b5;
    L_0x016f:
        r1 = r0.ryZ;
        r1 = (java.lang.CharSequence) r1;
        if (r1 == 0) goto L_0x017b;
    L_0x0175:
        r1 = b.f.a.U(r1);
        if (r1 == 0) goto L_0x01b3;
    L_0x017b:
        r1 = r3;
    L_0x017c:
        if (r1 == 0) goto L_0x01b5;
    L_0x017e:
        r1 = r3;
    L_0x017f:
        if (r1 != 0) goto L_0x013f;
    L_0x0181:
        r1 = com.tencent.mm.plugin.radar.ui.g.mmr;
        if (r0 != 0) goto L_0x0188;
    L_0x0185:
        b.c.b.e.cJM();
    L_0x0188:
        r1 = com.tencent.mm.plugin.radar.ui.g.b(r0);
        r2 = r4.mmN;
        r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
        r2 = r2.mka;
        r2 = r2.containsKey(r1);
        if (r2 == 0) goto L_0x01b9;
    L_0x019a:
        r2 = r4.mmN;
        r2 = com.tencent.mm.plugin.radar.ui.RadarViewController.c(r2);
        r2 = r2.mka;
        r1 = r2.get(r1);
        if (r1 != 0) goto L_0x01b7;
    L_0x01a8:
        r0 = new b.i;
        r1 = "null cannot be cast to non-null type kotlin.String";
        r0.<init>(r1);
        throw r0;
    L_0x01b1:
        r1 = r2;
        goto L_0x016d;
    L_0x01b3:
        r1 = r2;
        goto L_0x017c;
    L_0x01b5:
        r1 = r2;
        goto L_0x017f;
    L_0x01b7:
        r1 = (java.lang.String) r1;
    L_0x01b9:
        r2 = r4.mmQ;
        r2.remove(r1);
        goto L_0x013f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarViewController$g.f(int, android.view.View):void");
    }
}
