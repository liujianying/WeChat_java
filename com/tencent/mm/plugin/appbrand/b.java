package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.pluginsdk.cmd.a;

public final class b implements a {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r8, java.lang.String[] r9) {
        /*
        r7 = this;
        r5 = 3;
        r3 = -1;
        r4 = 2;
        r1 = 1;
        r0 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bj.cjh();
        if (r2 != 0) goto L_0x0010;
    L_0x000b:
        r2 = com.tencent.mm.sdk.platformtools.d.sFy;
        if (r2 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r2 = "//enable_appbrand_monkey_test";
        r6 = r9[r0];
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x001f;
    L_0x001b:
        com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.aes();
        goto L_0x000f;
    L_0x001f:
        r2 = "//disable_appbrand_monkey_test";
        r6 = r9[r0];
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.aet();
        goto L_0x000f;
    L_0x002e:
        r2 = "//wxafts";
        r6 = r9[r0];
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0067;
    L_0x0039:
        r0 = r9[r1];
        r2 = "delete";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x000f;
    L_0x0044:
        r2 = com.tencent.mm.plugin.appbrand.m.c.a.gsM;
        r0 = com.tencent.mm.plugin.appbrand.compat.a.f.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.appbrand.compat.a.f) r0;
        r0 = r0.adP();
        r3 = new java.io.File;
        r3.<init>(r0);
        com.tencent.mm.a.e.k(r3);
        r0 = "MicroMsg.WxaFTSSearchCore";
        r3 = "forceUnzipBasicTemplate";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r2.prepare();
        goto L_0x000f;
    L_0x0067:
        r2 = "//localwxalibrary";
        r6 = r9[r0];
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x00d4;
    L_0x0072:
        r2 = com.tencent.mm.sdk.platformtools.ad.chZ();
        r5 = r9[r1];
        r6 = r5.hashCode();
        switch(r6) {
            case 3569038: goto L_0x009e;
            case 94746189: goto L_0x0093;
            case 97196323: goto L_0x00a9;
            default: goto L_0x007f;
        };
    L_0x007f:
        switch(r3) {
            case 0: goto L_0x0083;
            case 1: goto L_0x00b4;
            case 2: goto L_0x00c4;
            default: goto L_0x0082;
        };
    L_0x0082:
        goto L_0x000f;
    L_0x0083:
        r0 = r2.edit();
        r2 = "localwxalibrary";
        r0 = r0.remove(r2);
        r0.commit();
        goto L_0x000f;
    L_0x0093:
        r4 = "clear";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x007f;
    L_0x009c:
        r3 = r0;
        goto L_0x007f;
    L_0x009e:
        r4 = "true";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x007f;
    L_0x00a7:
        r3 = r1;
        goto L_0x007f;
    L_0x00a9:
        r6 = "false";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x007f;
    L_0x00b2:
        r3 = r4;
        goto L_0x007f;
    L_0x00b4:
        r0 = r2.edit();
        r2 = "localwxalibrary";
        r0 = r0.putBoolean(r2, r1);
        r0.commit();
        goto L_0x000f;
    L_0x00c4:
        r2 = r2.edit();
        r3 = "localwxalibrary";
        r0 = r2.putBoolean(r3, r0);
        r0.commit();
        goto L_0x000f;
    L_0x00d4:
        r2 = "//getsearchshowoutwxaapp";
        r6 = r9[r0];
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x00fb;
    L_0x00df:
        r0 = r9.length;
        if (r0 <= r1) goto L_0x00f4;
    L_0x00e2:
        r0 = r9[r1];
        r2 = "daily";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x00f4;
    L_0x00ed:
        r0 = com.tencent.mm.plugin.appbrand.appusage.q.a.fmx;
        com.tencent.mm.plugin.appbrand.appusage.q.adh();
        goto L_0x000f;
    L_0x00f4:
        r0 = com.tencent.mm.plugin.appbrand.appusage.q.a.fmy;
        com.tencent.mm.plugin.appbrand.appusage.q.adh();
        goto L_0x000f;
    L_0x00fb:
        r2 = "//callsearchshowoutwxaapp";
        r6 = r9[r0];
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0113;
    L_0x0106:
        r0 = com.tencent.mm.plugin.appbrand.n.g.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.appbrand.n.g) r0;
        r0.adj();
        goto L_0x000f;
    L_0x0113:
        r2 = r9[r1];
        r2 = r2.toLowerCase();
        r6 = r2.hashCode();
        switch(r6) {
            case -2120258717: goto L_0x01c7;
            case -2120258713: goto L_0x01d4;
            case -2094503115: goto L_0x01e1;
            case -2086708598: goto L_0x0148;
            case -1958532869: goto L_0x0174;
            case -1897191982: goto L_0x0195;
            case -1513405239: goto L_0x0208;
            case -917899243: goto L_0x0169;
            case -901868261: goto L_0x0215;
            case -725390129: goto L_0x01ad;
            case -681162920: goto L_0x015e;
            case -501183631: goto L_0x01ba;
            case -358696710: goto L_0x0153;
            case -78191370: goto L_0x01ee;
            case 3545755: goto L_0x018a;
            case 98712316: goto L_0x01a0;
            case 424332448: goto L_0x01fb;
            case 1005455806: goto L_0x0222;
            case 1127987502: goto L_0x017f;
            default: goto L_0x0120;
        };
    L_0x0120:
        r2 = r3;
    L_0x0121:
        switch(r2) {
            case 0: goto L_0x0126;
            case 1: goto L_0x022f;
            case 2: goto L_0x0240;
            case 3: goto L_0x024c;
            case 4: goto L_0x0253;
            case 5: goto L_0x0273;
            case 6: goto L_0x027a;
            case 7: goto L_0x0281;
            case 8: goto L_0x0295;
            case 9: goto L_0x02a4;
            case 10: goto L_0x02b7;
            case 11: goto L_0x02d4;
            case 12: goto L_0x02f9;
            case 13: goto L_0x031e;
            case 14: goto L_0x0337;
            case 15: goto L_0x0350;
            case 16: goto L_0x0364;
            case 17: goto L_0x0377;
            case 18: goto L_0x038a;
            default: goto L_0x0124;
        };
    L_0x0124:
        goto L_0x000f;
    L_0x0126:
        r0 = com.tencent.mm.plugin.appbrand.app.e.abi();
        r2 = new com.tencent.mm.plugin.appbrand.appcache.al;
        r2.<init>();
        r3 = "@LibraryAppId";
        r2.field_appId = r3;
        r3 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        r2.field_debugType = r3;
        r2.field_version = r1;
        r0 = r0.fhZ;
        r3 = com.tencent.mm.plugin.appbrand.appcache.al.fhI;
        r0.a(r2, r3);
        r0 = com.tencent.mm.plugin.appbrand.appcache.af.VERSION;
        com.tencent.mm.plugin.appbrand.task.e.lE(r4);
        goto L_0x000f;
    L_0x0148:
        r6 = "deletebetalib";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x0151:
        r2 = r0;
        goto L_0x0121;
    L_0x0153:
        r6 = "deletelib";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x015c:
        r2 = r1;
        goto L_0x0121;
    L_0x015e:
        r6 = "pkgcleanup";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x0167:
        r2 = r4;
        goto L_0x0121;
    L_0x0169:
        r6 = "deletecontact";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x0172:
        r2 = r5;
        goto L_0x0121;
    L_0x0174:
        r6 = "historycount";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x017d:
        r2 = 4;
        goto L_0x0121;
    L_0x017f:
        r6 = "resetsyncversion";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x0188:
        r2 = 5;
        goto L_0x0121;
    L_0x018a:
        r6 = "sync";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x0193:
        r2 = 6;
        goto L_0x0121;
    L_0x0195:
        r6 = "starmax";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x019e:
        r2 = 7;
        goto L_0x0121;
    L_0x01a0:
        r6 = "guide";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x01a9:
        r2 = 8;
        goto L_0x0121;
    L_0x01ad:
        r6 = "clearguide";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x01b6:
        r2 = 9;
        goto L_0x0121;
    L_0x01ba:
        r6 = "releasepkghighversion";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x01c3:
        r2 = 10;
        goto L_0x0121;
    L_0x01c7:
        r6 = "incremental_insert_24";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x01d0:
        r2 = 11;
        goto L_0x0121;
    L_0x01d4:
        r6 = "incremental_insert_28";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x01dd:
        r2 = 12;
        goto L_0x0121;
    L_0x01e1:
        r6 = "incremental_delete_28";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x01ea:
        r2 = 13;
        goto L_0x0121;
    L_0x01ee:
        r6 = "incremental_delete_latest";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x01f7:
        r2 = 14;
        goto L_0x0121;
    L_0x01fb:
        r6 = "incremental_lib";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x0204:
        r2 = 15;
        goto L_0x0121;
    L_0x0208:
        r6 = "clear_mocklib";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x0211:
        r2 = 16;
        goto L_0x0121;
    L_0x0215:
        r6 = "force_modularizing";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x021e:
        r2 = 17;
        goto L_0x0121;
    L_0x0222:
        r6 = "useisolatectxwxalibrary";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0120;
    L_0x022b:
        r2 = 18;
        goto L_0x0121;
    L_0x022f:
        r2 = com.tencent.mm.plugin.appbrand.app.e.abi();
        r3 = "@LibraryAppId";
        r2.al(r3, r0);
        r0 = com.tencent.mm.plugin.appbrand.appcache.af.VERSION;
        com.tencent.mm.plugin.appbrand.task.e.lE(r4);
        goto L_0x000f;
    L_0x0240:
        r0 = com.tencent.mm.plugin.appbrand.appcache.h.c.abz();
        r2 = "WxaPkgCleanupByCMD";
        com.tencent.mm.sdk.f.e.post(r0, r2);
        goto L_0x000f;
    L_0x024c:
        r0 = r9[r4];
        com.tencent.mm.plugin.appbrand.config.q.sa(r0);
        goto L_0x000f;
    L_0x0253:
        r2 = r9[r4];
        r2 = r2.trim();
        r2 = com.tencent.mm.sdk.platformtools.bi.getInt(r2, r0);
        if (r2 <= 0) goto L_0x0260;
    L_0x025f:
        r0 = r1;
    L_0x0260:
        r2 = com.tencent.mm.kernel.g.Ei();
        r2 = r2.DT();
        r3 = com.tencent.mm.storage.aa.a.sTB;
        r0 = java.lang.Boolean.valueOf(r0);
        r2.a(r3, r0);
        goto L_0x000f;
    L_0x0273:
        r0 = r9[r4];
        com.tencent.mm.plugin.appbrand.config.q.rZ(r0);
        goto L_0x000f;
    L_0x027a:
        r0 = r9[r4];
        com.tencent.mm.plugin.appbrand.config.r.se(r0);
        goto L_0x000f;
    L_0x0281:
        r2 = r9[r4];
        r3 = 10;
        r2 = com.tencent.mm.sdk.platformtools.bi.getInt(r2, r3);
        r0 = java.lang.Math.max(r0, r2);
        r0 = java.lang.Integer.valueOf(r0);
        com.tencent.mm.plugin.appbrand.appusage.m.fmn = r0;
        goto L_0x000f;
    L_0x0295:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = "appbrand";
        r3 = ".ui.AppBrandGuideUI";
        com.tencent.mm.bg.d.A(r0, r2, r3);
        goto L_0x000f;
    L_0x02a4:
        r2 = com.tencent.mm.kernel.g.Ei();
        r2 = r2.DT();
        r3 = com.tencent.mm.storage.aa.a.sTA;
        r0 = java.lang.Boolean.valueOf(r0);
        r2.a(r3, r0);
        goto L_0x000f;
    L_0x02b7:
        r0 = 2;
        r0 = r9[r0];	 Catch:{ Exception -> 0x02d1 }
        r2 = new com.tencent.mm.plugin.appbrand.config.WxaAttributes$d;	 Catch:{ Exception -> 0x02d1 }
        r2.<init>();	 Catch:{ Exception -> 0x02d1 }
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2.cbu = r3;	 Catch:{ Exception -> 0x02d1 }
        r3 = "fake";
        r2.fsj = r3;	 Catch:{ Exception -> 0x02d1 }
        r3 = com.tencent.mm.plugin.appbrand.app.e.abi();	 Catch:{ Exception -> 0x02d1 }
        r3.a(r0, r2);	 Catch:{ Exception -> 0x02d1 }
        goto L_0x000f;
    L_0x02d1:
        r0 = move-exception;
        goto L_0x000f;
    L_0x02d4:
        r2 = new com.tencent.mm.plugin.appbrand.appcache.al;
        r2.<init>();
        r3 = "wx4ffb369b6881ee5e";
        r2.field_appId = r3;
        r3 = 24;
        r2.field_version = r3;
        r3 = "a47b978d23679075cbbed1030f71b7bb";
        r2.field_versionMd5 = r3;
        r2.field_versionState = r0;
        r2.field_debugType = r0;
        r0 = "/sdcard/_276854502_24.wxapkg";
        r2.field_pkgPath = r0;
        r0 = com.tencent.mm.plugin.appbrand.app.e.abi();
        r0.d(r2);
        goto L_0x000f;
    L_0x02f9:
        r2 = new com.tencent.mm.plugin.appbrand.appcache.al;
        r2.<init>();
        r3 = "wx4ffb369b6881ee5e";
        r2.field_appId = r3;
        r3 = 28;
        r2.field_version = r3;
        r3 = "5713e70880cc2d356905d6189ba37a72";
        r2.field_versionMd5 = r3;
        r2.field_versionState = r0;
        r2.field_debugType = r0;
        r0 = "/sdcard/_276854502_28.wxapkg";
        r2.field_pkgPath = r0;
        r0 = com.tencent.mm.plugin.appbrand.app.e.abi();
        r0.d(r2);
        goto L_0x000f;
    L_0x031e:
        r2 = new com.tencent.mm.plugin.appbrand.appcache.al;
        r2.<init>();
        r3 = "wx4ffb369b6881ee5e";
        r2.field_appId = r3;
        r3 = 28;
        r2.field_version = r3;
        r2.field_debugType = r0;
        r0 = com.tencent.mm.plugin.appbrand.app.e.abi();
        r0.a(r2);
        goto L_0x000f;
    L_0x0337:
        r2 = com.tencent.mm.plugin.appbrand.app.e.abi();
        r3 = "wx4ffb369b6881ee5e";
        r4 = new java.lang.String[r1];
        r5 = "version";
        r4[r0] = r5;
        r0 = r2.a(r3, r0, r4);
        if (r0 == 0) goto L_0x000f;
    L_0x034b:
        r2.a(r0);
        goto L_0x000f;
    L_0x0350:
        r0 = r9[r4];
        r2 = 78;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r2);
        r2 = r9[r5];
        r3 = new com.tencent.mm.plugin.appbrand.appcache.j;
        r3.<init>(r0, r2);
        r3.run();
        goto L_0x000f;
    L_0x0364:
        com.tencent.mm.plugin.appbrand.appcache.af.abS();
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = "MockLib已清除，重启微信生效";
        r0 = android.widget.Toast.makeText(r0, r2, r1);
        r0.show();
        goto L_0x000f;
    L_0x0377:
        r2 = r9.length;
        if (r2 < r5) goto L_0x0385;
    L_0x037a:
        r2 = r9[r4];
        r3 = "false";
        r2 = r2.equalsIgnoreCase(r3);
        if (r2 != 0) goto L_0x0386;
    L_0x0385:
        r0 = r1;
    L_0x0386:
        com.tencent.mm.plugin.appbrand.launching.z.ggw = r0;
        goto L_0x000f;
    L_0x038a:
        r2 = com.tencent.mm.sdk.platformtools.ad.chZ();
        r5 = r9.length;
        if (r5 <= r4) goto L_0x000f;
    L_0x0391:
        r5 = "open";
        r6 = r9[r4];
        r5 = r5.equalsIgnoreCase(r6);
        if (r5 == 0) goto L_0x03ac;
    L_0x039c:
        r0 = r2.edit();
        r2 = "useisolatectxwxalibrary";
        r0 = r0.putInt(r2, r1);
        r0.commit();
        goto L_0x000f;
    L_0x03ac:
        r5 = "close";
        r6 = r9[r4];
        r5 = r5.equalsIgnoreCase(r6);
        if (r5 == 0) goto L_0x03c7;
    L_0x03b7:
        r0 = r2.edit();
        r2 = "useisolatectxwxalibrary";
        r0 = r0.putInt(r2, r3);
        r0.commit();
        goto L_0x000f;
    L_0x03c7:
        r3 = "auto";
        r4 = r9[r4];
        r3 = r3.equalsIgnoreCase(r4);
        if (r3 == 0) goto L_0x000f;
    L_0x03d2:
        r2 = r2.edit();
        r3 = "useisolatectxwxalibrary";
        r0 = r2.putInt(r3, r0);
        r0.commit();
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.b.a(android.content.Context, java.lang.String[]):boolean");
    }
}
