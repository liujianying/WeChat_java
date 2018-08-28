package com.tencent.mm.ui;

public class w$a {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(final android.content.Context r9, int r10, int r11, java.lang.String r12, int r13) {
        /*
        r1 = 0;
        r8 = 2;
        r3 = 0;
        r2 = 1;
        switch(r10) {
            case 1: goto L_0x0009;
            case 2: goto L_0x00ed;
            case 3: goto L_0x010b;
            case 4: goto L_0x010e;
            default: goto L_0x0007;
        };
    L_0x0007:
        r0 = r3;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = r13 & 2;
        if (r0 == 0) goto L_0x0028;
    L_0x000d:
        r0 = com.tencent.mm.model.au.DF();
        r0 = r0.Lh();
        if (r0 == 0) goto L_0x0028;
    L_0x0017:
        r0 = com.tencent.mm.model.au.DF();
        r0.getNetworkServerIp();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r11);
    L_0x0026:
        r0 = r2;
        goto L_0x0008;
    L_0x0028:
        r0 = r13 & 1;
        if (r0 == 0) goto L_0x0038;
    L_0x002c:
        r0 = com.tencent.mm.network.ab.bU(r9);
        if (r0 == 0) goto L_0x0038;
    L_0x0032:
        r0 = com.tencent.mm.pluginsdk.ui.j.eY(r9);
        if (r0 != 0) goto L_0x0026;
    L_0x0038:
        r0 = r13 & 4;
        if (r0 == 0) goto L_0x004b;
    L_0x003c:
        r0 = com.tencent.mm.sdk.platformtools.ao.isWap(r9);
        if (r0 == 0) goto L_0x004b;
    L_0x0042:
        r0 = com.tencent.mm.model.au.HX();
        if (r0 != 0) goto L_0x0067;
    L_0x0048:
        r0 = r3;
    L_0x0049:
        if (r0 != 0) goto L_0x0026;
    L_0x004b:
        r0 = com.tencent.mm.R.l.fmt_http_err;
        r1 = new java.lang.Object[r8];
        r4 = java.lang.Integer.valueOf(r2);
        r1[r3] = r4;
        r3 = java.lang.Integer.valueOf(r11);
        r1[r2] = r3;
        r0 = r9.getString(r0, r1);
        r0 = android.widget.Toast.makeText(r9, r0, r2);
        r0.show();
        goto L_0x0026;
    L_0x0067:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r4 = 61;
        r0 = r0.get(r4, r1);
        r0 = (java.lang.Boolean) r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.d(r0);
        if (r0 == 0) goto L_0x007e;
    L_0x007c:
        r0 = r3;
        goto L_0x0049;
    L_0x007e:
        r0 = "show_wap_adviser";
        r0 = com.tencent.mm.sdk.platformtools.af.Wp(r0);
        if (r0 != 0) goto L_0x0089;
    L_0x0087:
        r0 = r3;
        goto L_0x0049;
    L_0x0089:
        r0 = com.tencent.mm.R.i.network_tips;
        r1 = android.view.View.inflate(r9, r0, r1);
        r0 = com.tencent.mm.R.h.network_tips_content;
        r0 = r1.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r4 = com.tencent.mm.R.l.network_wap_limited;
        r0.setText(r4);
        r0 = com.tencent.mm.R.h.network_tips_cb;
        r0 = r1.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r4 = com.tencent.mm.R.l.process_limited_cancel;
        r4 = r9.getString(r4);
        r0.setText(r4);
        r4 = new com.tencent.mm.ui.MMAppMgr$13;
        r4.<init>();
        r0.setOnCheckedChangeListener(r4);
        r0.setVisibility(r3);
        r0 = new com.tencent.mm.ui.widget.a.c$a;
        r0.<init>(r9);
        r4 = com.tencent.mm.R.l.app_tip;
        r0.Gq(r4);
        r0.dR(r1);
        r1 = com.tencent.mm.R.l.process_limited_ok;
        r1 = r0.Gt(r1);
        r4 = new com.tencent.mm.ui.MMAppMgr$14;
        r4.<init>(r9);
        r1.a(r4);
        r0.mF(r3);
        r1 = com.tencent.mm.R.l.process_limited_next;
        r0.Gu(r1);
        r1 = new com.tencent.mm.ui.MMAppMgr$15;
        r1.<init>();
        r0.a(r1);
        r0 = r0.anj();
        r0.show();
        r0 = r2;
        goto L_0x0049;
    L_0x00ed:
        r0 = com.tencent.mm.R.l.fmt_iap_err;
        r1 = new java.lang.Object[r8];
        r4 = java.lang.Integer.valueOf(r8);
        r1[r3] = r4;
        r3 = java.lang.Integer.valueOf(r11);
        r1[r2] = r3;
        r0 = r9.getString(r0, r1);
        r0 = android.widget.Toast.makeText(r9, r0, r2);
        r0.show();
        r0 = r2;
        goto L_0x0008;
    L_0x010b:
        r0 = r2;
        goto L_0x0008;
    L_0x010e:
        r4 = com.tencent.mm.h.a.eV(r12);
        if (r4 == 0) goto L_0x0007;
    L_0x0114:
        r0 = "MicroMsg.MMErrorProcessor";
        r5 = "summertips errCode[%d], showType[%d], url[%s], desc[%s]";
        r6 = 4;
        r6 = new java.lang.Object[r6];
        r7 = java.lang.Integer.valueOf(r11);
        r6[r3] = r7;
        r7 = r4.showType;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r2] = r7;
        r7 = r4.url;
        r6[r8] = r7;
        r7 = 3;
        r8 = r4.desc;
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r0, r5, r6);
        r0 = r4.url;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x014d;
    L_0x013f:
        r0 = new com.tencent.mm.ui.w$a$1;
        r0.<init>(r4, r9);
    L_0x0144:
        r0 = r4.a(r9, r0, r1);
        if (r0 == 0) goto L_0x0007;
    L_0x014a:
        r0 = r2;
        goto L_0x0008;
    L_0x014d:
        r0 = r1;
        goto L_0x0144;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.w$a.a(android.content.Context, int, int, java.lang.String, int):boolean");
    }
}
