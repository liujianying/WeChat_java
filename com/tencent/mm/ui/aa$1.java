package com.tencent.mm.ui;

class aa$1 implements Runnable {
    final /* synthetic */ aa toC;

    aa$1(aa aaVar) {
        this.toC = aaVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r12 = this;
        r8 = 0;
        r5 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
        r6 = 0;
        r1 = 0;
        r3 = 1;
        r0 = com.tencent.mm.kernel.g.Eg();
        r0 = r0.Dx();
        if (r0 != 0) goto L_0x001c;
    L_0x0012:
        r0 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
        r1 = "Account not Ready!!!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x001b:
        return;
    L_0x001c:
        r0 = r12.toC;
        r0 = r0.tow;
        if (r0 != 0) goto L_0x002c;
    L_0x0022:
        r0 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
        r1 = "set tag job, but tab view is null";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        goto L_0x001b;
    L_0x002c:
        r0 = com.tencent.mm.model.au.HX();
        if (r0 != 0) goto L_0x00a1;
    L_0x0032:
        r0 = "MicroMsg.UnreadCountHelper";
        r2 = "getFindTabUnreadCount, but mmcore not ready";
        com.tencent.mm.sdk.platformtools.x.w(r0, r2);
        r2 = r1;
    L_0x003c:
        r0 = r12.toC;
        r0 = r0.tow;
        r0.ls(r1);
        r0 = r12.toC;
        r0 = r0.tow;
        r0.DF(r2);
        if (r2 > 0) goto L_0x0063;
    L_0x004c:
        r0 = com.tencent.mm.be.a.cbf();
        if (r0 == 0) goto L_0x0063;
    L_0x0052:
        r0 = com.tencent.mm.az.d.SG();
        r0 = r0.axd();
        if (r0 <= 0) goto L_0x0063;
    L_0x005c:
        r0 = r12.toC;
        r0 = r0.tow;
        r0.ls(r3);
    L_0x0063:
        if (r2 > 0) goto L_0x0156;
    L_0x0065:
        r0 = com.tencent.mm.model.q.GQ();
        r0 = r0 & r5;
        if (r0 != 0) goto L_0x0156;
    L_0x006c:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r4 = 68384; // 0x10b20 float:9.5826E-41 double:3.3786E-319;
        r0 = r0.get(r4, r8);
        r0 = (java.lang.Boolean) r0;
        r0 = com.tencent.mm.platformtools.ai.e(r0);
        if (r0 == 0) goto L_0x0156;
    L_0x0082:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r4 = 68377; // 0x10b19 float:9.5817E-41 double:3.37827E-319;
        r0 = r0.get(r4, r8);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.platformtools.ai.oW(r0);
        if (r0 != 0) goto L_0x0100;
    L_0x0098:
        r0 = r12.toC;
        r0 = r0.tow;
        r0.ls(r3);
        goto L_0x001b;
    L_0x00a1:
        r0 = com.tencent.mm.model.q.GJ();
        r2 = com.tencent.mm.model.q.GQ();
        r2 = r2 & 64;
        if (r2 != 0) goto L_0x0368;
    L_0x00ad:
        r0 = r0 & r5;
        if (r0 != 0) goto L_0x0368;
    L_0x00b0:
        r0 = com.tencent.mm.model.k.GB();
        r0 = r0 + 0;
    L_0x00b6:
        r2 = com.tencent.mm.model.q.GQ();
        r2 = r2 & 512;
        if (r2 != 0) goto L_0x0365;
    L_0x00be:
        r2 = com.tencent.mm.be.a.cbf();
        if (r2 != 0) goto L_0x0365;
    L_0x00c4:
        r2 = com.tencent.mm.az.d.SG();
        r2 = r2.axd();
        r2 = r2 + 0;
    L_0x00ce:
        r4 = com.tencent.mm.model.q.GQ();
        r4 = r4 & 256;
        if (r4 != 0) goto L_0x00ea;
    L_0x00d6:
        r4 = com.tencent.mm.az.d.SH();
        if (r4 == 0) goto L_0x00e1;
    L_0x00dc:
        r4 = r4.axd();
        r2 = r2 + r4;
    L_0x00e1:
        r4 = com.tencent.mm.pluginsdk.o.a.cbj();
        r4 = r4.buv();
        r2 = r2 + r4;
    L_0x00ea:
        r0 = r0 + r2;
        r2 = com.tencent.mm.model.q.GQ();
        r2 = r2 & r5;
        if (r2 != 0) goto L_0x00fd;
    L_0x00f2:
        r2 = com.tencent.mm.plugin.sns.b.n.nkz;
        if (r2 == 0) goto L_0x00fd;
    L_0x00f6:
        r2 = com.tencent.mm.plugin.sns.b.n.nkz;
        r2 = r2.axd();
        r0 = r0 + r2;
    L_0x00fd:
        r2 = r0;
        goto L_0x003c;
    L_0x0100:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r4 = 589825; // 0x90001 float:8.26521E-40 double:2.914123E-318;
        r5 = java.lang.Boolean.valueOf(r1);
        r0 = r0.get(r4, r5);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0123;
    L_0x011a:
        r0 = r12.toC;
        r0 = r0.tow;
        r0.ls(r3);
        goto L_0x001b;
    L_0x0123:
        r0 = com.tencent.mm.kernel.g.Ei();
        r0 = r0.DT();
        r4 = com.tencent.mm.storage.aa.a.tah;
        r0 = r0.get(r4, r8);
        if (r0 != 0) goto L_0x014f;
    L_0x0133:
        r4 = r6;
    L_0x0134:
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x0156;
    L_0x0138:
        r0 = com.tencent.mm.plugin.sns.b.m.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.sns.b.m) r0;
        r0 = r0.ew(r4);
        if (r0 == 0) goto L_0x0156;
    L_0x0146:
        r0 = r12.toC;
        r0 = r0.tow;
        r0.ls(r3);
        goto L_0x001b;
    L_0x014f:
        r0 = (java.lang.Long) r0;
        r4 = r0.longValue();
        goto L_0x0134;
    L_0x0156:
        if (r2 > 0) goto L_0x020b;
    L_0x0158:
        r4 = com.tencent.mm.model.q.GK();
        r8 = 4194304; // 0x400000 float:5.877472E-39 double:2.0722615E-317;
        r4 = r4 & r8;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x01ff;
    L_0x0164:
        r0 = r3;
    L_0x0165:
        r4 = com.tencent.mm.k.g.AT();
        r5 = "JDEntranceConfigName";
        r4 = r4.getValue(r5);
        r5 = com.tencent.mm.k.g.AT();
        r8 = "JDEntranceConfigIconUrl";
        r5 = r5.getValue(r8);
        r8 = com.tencent.mm.k.g.AT();
        r9 = "JDEntranceConfigJumpUrl";
        r8 = r8.getValue(r9);
        r9 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
        r10 = new java.lang.StringBuilder;
        r11 = "jd tryshow configName ";
        r10.<init>(r11);
        r10 = r10.append(r4);
        r11 = " iconUrl ";
        r10 = r10.append(r11);
        r10 = r10.append(r5);
        r11 = " jumpUrl ";
        r10 = r10.append(r11);
        r10 = r10.append(r8);
        r10 = r10.toString();
        com.tencent.mm.sdk.platformtools.x.i(r9, r10);
        if (r0 != 0) goto L_0x020b;
    L_0x01b4:
        r0 = com.tencent.mm.platformtools.ai.oW(r4);
        if (r0 != 0) goto L_0x020b;
    L_0x01ba:
        r0 = com.tencent.mm.platformtools.ai.oW(r5);
        if (r0 != 0) goto L_0x020b;
    L_0x01c0:
        r0 = com.tencent.mm.platformtools.ai.oW(r8);
        if (r0 != 0) goto L_0x020b;
    L_0x01c6:
        r0 = com.tencent.mm.pluginsdk.f.f.qBo;
        if (r0 == 0) goto L_0x020b;
    L_0x01ca:
        r4 = r0.bGi();
        r5 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
        r8 = new java.lang.StringBuilder;
        r9 = "jdshowFriend ";
        r8.<init>(r9);
        r8 = r8.append(r4);
        r8 = r8.toString();
        com.tencent.mm.sdk.platformtools.x.i(r5, r8);
        if (r4 == 0) goto L_0x020b;
    L_0x01e6:
        r0 = r0.bGq();
        r4 = r0.aiS();
        if (r4 == 0) goto L_0x0202;
    L_0x01f0:
        r0 = r0.bFZ();
        if (r0 != 0) goto L_0x0202;
    L_0x01f6:
        r0 = r12.toC;
        r0 = r0.tow;
        r0.ls(r3);
        goto L_0x001b;
    L_0x01ff:
        r0 = r1;
        goto L_0x0165;
    L_0x0202:
        r0 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
        r4 = "jd time is not start or jd time isExpire";
        com.tencent.mm.sdk.platformtools.x.i(r0, r4);
    L_0x020b:
        r4 = com.tencent.mm.model.q.GK();
        r8 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;
        r4 = r4 & r8;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x0337;
    L_0x0217:
        r0 = r3;
    L_0x0218:
        r4 = com.tencent.mm.plugin.ipcall.d.aWV();
        if (r4 == 0) goto L_0x033a;
    L_0x021e:
        if (r0 != 0) goto L_0x0270;
    L_0x0220:
        r0 = r12.toC;
        r0 = r0.tow;
        r0 = r0.getShowFriendPoint();
        if (r0 != 0) goto L_0x0270;
    L_0x022a:
        if (r2 > 0) goto L_0x0270;
    L_0x022c:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r2 = com.tencent.mm.storage.aa.a.sRg;
        r4 = java.lang.Integer.valueOf(r1);
        r0 = r0.get(r2, r4);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r2 = com.tencent.mm.k.g.AT();
        r4 = "WCOEntranceRedDot";
        r2 = r2.getInt(r4, r1);
        if (r0 < r2) goto L_0x0269;
    L_0x0250:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r2 = com.tencent.mm.storage.aa.a.sRi;
        r4 = java.lang.Boolean.valueOf(r1);
        r0 = r0.get(r2, r4);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != r3) goto L_0x0270;
    L_0x0269:
        r0 = r12.toC;
        r0 = r0.tow;
        r0.ls(r3);
    L_0x0270:
        r4 = com.tencent.mm.model.q.GK();
        r8 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        r4 = r4 & r8;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x034c;
    L_0x027c:
        r0 = r3;
    L_0x027d:
        if (r0 != 0) goto L_0x02dc;
    L_0x027f:
        r0 = com.tencent.mm.plugin.websearch.api.ac.bTg();
        r2 = r0.pMk;
        if (r2 == 0) goto L_0x035b;
    L_0x0287:
        r2 = r0.pMk;
        r2 = r2.isValid();
        if (r2 == 0) goto L_0x035b;
    L_0x028f:
        r0 = r0.pMk;
        r0 = r0.pMo;
        if (r0 != r3) goto L_0x035b;
    L_0x0295:
        r0 = "discoverSearchEntry";
        r2 = com.tencent.mm.plugin.websearch.api.r.PX(r0);
        r0 = com.tencent.mm.plugin.welab.a.a.a.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.welab.a.a.a) r0;
        r4 = "labs1de6f3";
        r0 = r0.RZ(r4);
        if (r0 == 0) goto L_0x034f;
    L_0x02ad:
        r0 = com.tencent.mm.plugin.welab.a.a.a.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.welab.a.a.a) r0;
        r2 = "labs1de6f3";
        r0 = r0.RX(r2);
        if (r0 == 0) goto L_0x0362;
    L_0x02be:
        r0 = r3;
    L_0x02bf:
        r2 = "MicroMsg.WebSearch.WebSearchRedPointMgr";
        r4 = "search show %b";
        r5 = new java.lang.Object[r3];
        r6 = java.lang.Boolean.valueOf(r0);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
        if (r0 == 0) goto L_0x035b;
    L_0x02d2:
        r0 = r3;
    L_0x02d3:
        if (r0 == 0) goto L_0x02dc;
    L_0x02d5:
        r0 = r12.toC;
        r0 = r0.tow;
        r0.ls(r3);
    L_0x02dc:
        com.tencent.mm.plugin.websearch.api.ac.bTg();
        com.tencent.mm.plugin.websearch.api.ac.bTh();
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r2 = 40;
        r0 = r0.getInt(r2, r1);
        r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r0 = r0 & r2;
        if (r0 != 0) goto L_0x0360;
    L_0x02f4:
        r2 = r3;
    L_0x02f5:
        r0 = com.tencent.mm.k.g.AT();
        r4 = "VoiceprintEntry";
        r0 = r0.getValue(r4);
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r1);
        if (r0 != r3) goto L_0x035e;
    L_0x0306:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r4 = com.tencent.mm.storage.aa.a.sPp;
        r5 = java.lang.Boolean.valueOf(r3);
        r0 = r0.get(r4, r5);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
    L_0x031d:
        if (r0 == 0) goto L_0x0331;
    L_0x031f:
        if (r2 == 0) goto L_0x0331;
    L_0x0321:
        r0 = "MicroMsg.LauncherUI.MainTabUnreadMgr";
        r2 = "show voiceprint dot";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        r0 = r12.toC;
        r0 = r0.tow;
        r0.lt(r3);
    L_0x0331:
        r0 = r12.toC;
        r0.tox = r1;
        goto L_0x001b;
    L_0x0337:
        r0 = r1;
        goto L_0x0218;
    L_0x033a:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r2 = com.tencent.mm.storage.aa.a.sRf;
        r4 = java.lang.Boolean.valueOf(r1);
        r0.a(r2, r4);
        goto L_0x0270;
    L_0x034c:
        r0 = r1;
        goto L_0x027d;
    L_0x034f:
        r0 = "entrySwitch";
        r0 = r2.optInt(r0);
        if (r0 != r3) goto L_0x0362;
    L_0x0358:
        r0 = r3;
        goto L_0x02bf;
    L_0x035b:
        r0 = r1;
        goto L_0x02d3;
    L_0x035e:
        r0 = r1;
        goto L_0x031d;
    L_0x0360:
        r2 = r1;
        goto L_0x02f5;
    L_0x0362:
        r0 = r1;
        goto L_0x02bf;
    L_0x0365:
        r2 = r1;
        goto L_0x00ce;
    L_0x0368:
        r0 = r1;
        goto L_0x00b6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.aa$1.run():void");
    }

    public final String toString() {
        return super.toString() + "|setTagRunnable";
    }
}
