package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.me;
import com.tencent.mm.sdk.b.c;

class c$12 extends c<me> {
    final /* synthetic */ c jFM;

    c$12(c cVar) {
        this.jFM = cVar;
        this.sFo = me.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r15) {
        /*
        r14 = this;
        r13 = 12;
        r12 = 11;
        r4 = 2;
        r2 = 0;
        r1 = 1;
        r15 = (com.tencent.mm.g.a.me) r15;
        r0 = r15.bWO;
        r0 = r0.content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0200;
    L_0x0013:
        r0 = com.tencent.mm.plugin.game.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.game.a.b) r0;
        r0.aSi();
        r0 = com.tencent.mm.kernel.g.Ei();
        r0 = r0.DT();
        r3 = com.tencent.mm.storage.aa.a.sRz;
        r6 = 0;
        r5 = java.lang.Long.valueOf(r6);
        r0 = r0.get(r3, r5);
        r0 = (java.lang.Long) r0;
        r6 = r0.longValue();
        r0 = 0;
        r8 = 0;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 == 0) goto L_0x0297;
    L_0x003f:
        r0 = com.tencent.mm.plugin.game.a.c.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.game.a.c) r0;
        r0 = r0.aSj();
        r0 = r0.dH(r6);
        r3 = r0;
    L_0x0050:
        if (r3 == 0) goto L_0x00e8;
    L_0x0052:
        r3.aTW();
        r6 = r3.field_receiveTime;
        r0 = r3.jMY;
        r8 = r0.jNu;
        r6 = r6 + r8;
        r8 = java.lang.System.currentTimeMillis();
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = r8 / r10;
        r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x00e9;
    L_0x0067:
        r0 = r1;
    L_0x0068:
        r3 = r3.jME;
        if (r3 <= 0) goto L_0x01ed;
    L_0x006c:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = com.tencent.mm.sdk.platformtools.ao.isWifi(r3);
        if (r3 == 0) goto L_0x013b;
    L_0x0076:
        r1 = "MicroMsg.GameWifiStrategy";
        r3 = "WifiStrategy:isInWifi";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);
    L_0x007f:
        r1 = r2;
    L_0x0080:
        if (r1 != 0) goto L_0x0093;
    L_0x0082:
        if (r0 == 0) goto L_0x0093;
    L_0x0084:
        r0 = com.tencent.mm.plugin.game.a.c.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.game.a.c) r0;
        r0 = r0.aSj();
        r0.aUd();
    L_0x0093:
        r0 = com.tencent.mm.plugin.game.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.game.a.b) r0;
        r0.aSi();
        r0 = com.tencent.mm.plugin.game.model.v.aTX();
        if (r0 == 0) goto L_0x00e8;
    L_0x00a4:
        r0.aTW();
        r1 = r0.jNb;
        com.tencent.mm.plugin.game.model.an.Dy(r1);
        r1 = r15.bWO;
        r3 = r0.jMt;
        r3 = r3.jNi;
        r1.showType = r3;
        r1 = r15.bWO;
        r3 = r0.field_appId;
        r1.appId = r3;
        r1 = r15.bWO;
        r3 = r0.jMt;
        r3 = r3.gEw;
        r1.appName = r3;
        r1 = r15.bWO;
        r3 = r0.jMt;
        r3 = r3.jNg;
        r1.bWP = r3;
        r1 = r15.bWO;
        r3 = r0.field_msgType;
        r1.msgType = r3;
        r1 = r0.field_msgType;
        r3 = 100;
        if (r1 != r3) goto L_0x00dc;
    L_0x00d6:
        r1 = r15.bWO;
        r3 = r0.jNa;
        r1.msgType = r3;
    L_0x00dc:
        r1 = r15.bWO;
        r3 = r0.field_gameMsgId;
        r1.bWQ = r3;
        r1 = r15.bWO;
        r0 = r0.jNb;
        r1.bHF = r0;
    L_0x00e8:
        return r2;
    L_0x00e9:
        r0 = r3.jMY;
        r0 = r0.hzJ;
        switch(r0) {
            case 0: goto L_0x00f3;
            case 1: goto L_0x00f6;
            case 2: goto L_0x0118;
            default: goto L_0x00f0;
        };
    L_0x00f0:
        r0 = r2;
        goto L_0x0068;
    L_0x00f3:
        r0 = r1;
        goto L_0x0068;
    L_0x00f6:
        r0 = new com.tencent.mm.g.a.ub;
        r0.<init>();
        r5 = r0.cfW;
        r5.bIH = r4;
        r5 = r0.cfW;
        r6 = r3.jMY;
        r6 = r6.jNt;
        r5.cfX = r6;
        r5 = com.tencent.mm.sdk.b.a.sFg;
        r5.m(r0);
        r0 = r0.cfW;
        r0 = r0.cfY;
        if (r0 == 0) goto L_0x0115;
    L_0x0112:
        r0 = r1;
        goto L_0x0068;
    L_0x0115:
        r0 = r2;
        goto L_0x0068;
    L_0x0118:
        r0 = new com.tencent.mm.g.a.ub;
        r0.<init>();
        r5 = r0.cfW;
        r6 = 4;
        r5.bIH = r6;
        r5 = r0.cfW;
        r6 = r3.jMY;
        r6 = r6.jNt;
        r5.cfX = r6;
        r5 = com.tencent.mm.sdk.b.a.sFg;
        r5.m(r0);
        r0 = r0.cfW;
        r0 = r0.cfZ;
        if (r0 <= 0) goto L_0x0138;
    L_0x0135:
        r0 = r1;
        goto L_0x0068;
    L_0x0138:
        r0 = r2;
        goto L_0x0068;
    L_0x013b:
        r3 = new java.util.GregorianCalendar;
        r3.<init>();
        r5 = r3.get(r12);
        r3.get(r13);
        r3 = 21;
        if (r5 < r3) goto L_0x019d;
    L_0x014b:
        r3 = 3;
    L_0x014c:
        r5 = "MicroMsg.GameWifiStrategy";
        r6 = new java.lang.StringBuilder;
        r7 = "WifiStrategy:inWhichTimeRange = ";
        r6.<init>(r7);
        r6 = r6.append(r3);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.x.i(r5, r6);
        if (r3 == 0) goto L_0x0080;
    L_0x0164:
        r5 = 3;
        if (r3 == r5) goto L_0x007f;
    L_0x0167:
        if (r3 != r1) goto L_0x01af;
    L_0x0169:
        r3 = new java.util.GregorianCalendar;
        r3.<init>();
        r3 = r3.get(r12);
        r3 = r3 + -12;
        r3 = r3 << 1;
        r3 = r3 + 1;
        r3 = r3 * 10;
        r3 = r3 + 50;
        r5 = 100;
        r5 = com.tencent.mm.sdk.platformtools.bi.eF(r5, r2);
        r6 = "MicroMsg.GameWifiStrategy";
        r7 = "WifiStrategy:randomHide p = %s, randomNum = %s";
        r4 = new java.lang.Object[r4];
        r8 = java.lang.Integer.valueOf(r3);
        r4[r2] = r8;
        r8 = java.lang.Integer.valueOf(r5);
        r4[r1] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r4);
        if (r3 > r5) goto L_0x007f;
    L_0x019b:
        goto L_0x0080;
    L_0x019d:
        if (r5 >= r13) goto L_0x01a1;
    L_0x019f:
        r3 = r2;
        goto L_0x014c;
    L_0x01a1:
        r3 = 14;
        if (r5 >= r3) goto L_0x01a7;
    L_0x01a5:
        r3 = r1;
        goto L_0x014c;
    L_0x01a7:
        r3 = 18;
        if (r5 >= r3) goto L_0x01ad;
    L_0x01ab:
        r3 = r2;
        goto L_0x014c;
    L_0x01ad:
        r3 = r4;
        goto L_0x014c;
    L_0x01af:
        if (r3 != r4) goto L_0x007f;
    L_0x01b1:
        r3 = new java.util.GregorianCalendar;
        r3.<init>();
        r5 = r3.get(r12);
        r3 = r3.get(r13);
        r5 = r5 + -18;
        r6 = 30;
        if (r3 <= r6) goto L_0x01eb;
    L_0x01c4:
        r3 = r1;
    L_0x01c5:
        r3 = r3 + r5;
        r3 = r3 * 10;
        r3 = r3 + 50;
        r5 = 100;
        r5 = com.tencent.mm.sdk.platformtools.bi.eF(r5, r2);
        r6 = "MicroMsg.GameWifiStrategy";
        r7 = "WifiStrategy:randomHide p = %s, randomNum = %s";
        r4 = new java.lang.Object[r4];
        r8 = java.lang.Integer.valueOf(r3);
        r4[r2] = r8;
        r8 = java.lang.Integer.valueOf(r5);
        r4[r1] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r4);
        if (r3 > r5) goto L_0x007f;
    L_0x01e9:
        goto L_0x0080;
    L_0x01eb:
        r3 = r2;
        goto L_0x01c5;
    L_0x01ed:
        if (r0 == 0) goto L_0x0093;
    L_0x01ef:
        r0 = com.tencent.mm.plugin.game.a.c.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.game.a.c) r0;
        r0 = r0.aSj();
        r0.aUd();
        goto L_0x0093;
    L_0x0200:
        r0 = r15.bWO;
        r0 = r0.content;
        if (r0 == 0) goto L_0x00e8;
    L_0x0206:
        r3 = "//gamemsg:";
        r3 = r0.startsWith(r3);
        if (r3 == 0) goto L_0x00e8;
    L_0x020f:
        r3 = new com.tencent.mm.protocal.c.by;
        r3.<init>();
        r4 = 10;
        r4 = r0.substring(r4);
        r4 = com.tencent.mm.platformtools.ab.oT(r4);
        r3.rcl = r4;
        r3 = 10;
        r0 = r0.substring(r3);
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r3 != 0) goto L_0x00e8;
    L_0x022c:
        r3 = "jumpnative";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x024f;
    L_0x0235:
        r0 = new android.content.Intent;
        r0.<init>();
        r3 = "from_find_more_friend";
        r0.putExtra(r3, r1);
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = "game";
        r4 = ".ui.tab.GameRouteUI";
        com.tencent.mm.bg.d.b(r1, r3, r4, r0);
        goto L_0x00e8;
    L_0x024f:
        r1 = "jumpLibrary";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x026c;
    L_0x0258:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = "game";
        r4 = ".ui.GameLibraryUI";
        com.tencent.mm.bg.d.b(r1, r3, r4, r0);
        goto L_0x00e8;
    L_0x026c:
        r1 = "jumpDetail:";
        r1 = r0.contains(r1);
        if (r1 == 0) goto L_0x00e8;
    L_0x0275:
        r1 = r0.length();
        r0 = r0.substring(r12, r1);
        r1 = new android.content.Intent;
        r1.<init>();
        r3 = "game_app_id";
        r1.putExtra(r3, r0);
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = "game";
        r4 = ".ui.GameDetailUI2";
        com.tencent.mm.bg.d.b(r0, r3, r4, r1);
        goto L_0x00e8;
    L_0x0297:
        r3 = r0;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.c$12.a(com.tencent.mm.sdk.b.b):boolean");
    }
}
