package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.ab.e;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.2;

class ExtControlProviderMsg$2$1 implements e {
    final /* synthetic */ String iKh;
    final /* synthetic */ 2 iKi;

    ExtControlProviderMsg$2$1(2 2, String str) {
        this.iKi = 2;
        this.iKh = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.ab.l r13) {
        /*
        r9 = this;
        r8 = 522; // 0x20a float:7.31E-43 double:2.58E-321;
        r7 = 4;
        r6 = 2;
        r5 = 1;
        r4 = 0;
        r0 = "MicroMsg.ExtControlProviderMsg";
        r1 = "onSceneEnd errType=%s, errCode=%s";
        r2 = new java.lang.Object[r6];
        r3 = java.lang.Integer.valueOf(r10);
        r2[r4] = r3;
        r3 = java.lang.Integer.valueOf(r11);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
        if (r13 != 0) goto L_0x003e;
    L_0x001f:
        r0 = "MicroMsg.ExtControlProviderMsg";
        r1 = "scene == null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = com.tencent.mm.model.au.DF();
        r0.b(r8, r9);
        r0 = r9.iKi;
        r0 = r0.iKf;
        r0.pr(r7);
        r0 = r9.iKi;
        r0 = r0.heb;
        r0.countDown();
    L_0x003d:
        return;
    L_0x003e:
        r0 = r13.getType();
        switch(r0) {
            case 522: goto L_0x005b;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r9.iKi;
        r0 = r0.iKf;
        r0.pr(r4);
    L_0x004c:
        r0 = r9.iKi;
        r0 = r0.heb;
        r0.countDown();
        r0 = com.tencent.mm.model.au.DF();
        r0.b(r8, r9);
        goto L_0x003d;
    L_0x005b:
        if (r10 != 0) goto L_0x0080;
    L_0x005d:
        if (r11 != 0) goto L_0x0080;
    L_0x005f:
        r0 = "MicroMsg.ExtControlProviderMsg";
        r1 = "rtSENDMSG onSceneEnd ok, ";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r9.iKi;
        r0 = r0.iKf;
        r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.a(r0);
        r1 = new java.lang.Object[r6];
        r2 = r9.iKh;
        r1[r4] = r2;
        r2 = java.lang.Integer.valueOf(r5);
        r1[r5] = r2;
        r0.addRow(r1);
        goto L_0x0045;
    L_0x0080:
        r0 = "MicroMsg.ExtControlProviderMsg";
        r1 = new java.lang.StringBuilder;
        r2 = "rtSENDMSG onSceneEnd err, errType = ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = ", errCode = ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r9.iKi;
        r0 = r0.iKf;
        r0 = com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.a(r0);
        r1 = new java.lang.Object[r6];
        r2 = r9.iKh;
        r1[r4] = r2;
        r2 = java.lang.Integer.valueOf(r6);
        r1[r5] = r2;
        r0.addRow(r1);
        r0 = r9.iKi;
        r0 = r0.iKf;
        r0.pr(r7);
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg$2$1.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }
}
