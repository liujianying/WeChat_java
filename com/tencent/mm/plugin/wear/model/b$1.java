package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.tq;
import com.tencent.mm.sdk.b.c;

class b$1 extends c<tq> {
    final /* synthetic */ b pIZ;

    b$1(b bVar) {
        this.pIZ = bVar;
        this.sFo = tq.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r10) {
        /*
        r9 = this;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r10 = (com.tencent.mm.g.a.tq) r10;
        r0 = r10 instanceof com.tencent.mm.g.a.tq;
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r10.cfq;
        r0 = r0.bIH;
        switch(r0) {
            case 2: goto L_0x0011;
            case 3: goto L_0x0010;
            case 4: goto L_0x0010;
            case 5: goto L_0x0062;
            case 6: goto L_0x007e;
            case 7: goto L_0x0010;
            case 8: goto L_0x0038;
            case 9: goto L_0x0032;
            default: goto L_0x0010;
        };
    L_0x0010:
        return r6;
    L_0x0011:
        r0 = "MicroMsg.Wear.WearBizLogic";
        r1 = "receive register response, deviceId=%s | isSuccess=%b";
        r2 = new java.lang.Object[r8];
        r3 = r10.cfq;
        r3 = r3.byN;
        r2[r6] = r3;
        r3 = r10.cfq;
        r3 = r3.bLW;
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r10.cfq;
        r0 = r0.bLW;
        if (r0 == 0) goto L_0x0010;
    L_0x0032:
        r0 = r9.pIZ;
        r0.connect();
        goto L_0x0010;
    L_0x0038:
        r0 = "MicroMsg.Wear.WearBizLogic";
        r1 = "receive auth response, deviceId=%s | isSuccess=%b";
        r2 = new java.lang.Object[r8];
        r3 = r10.cfq;
        r3 = r3.byN;
        r2[r6] = r3;
        r3 = r10.cfq;
        r3 = r3.bLW;
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r9.pIZ;
        r1 = r10.cfq;
        r1 = r1.bLW;
        r0.pIW = r1;
        r0 = r9.pIZ;
        r0 = r0.pIW;
        if (r0 == 0) goto L_0x0010;
    L_0x0061:
        goto L_0x0032;
    L_0x0062:
        r0 = "MicroMsg.Wear.WearBizLogic";
        r1 = "receive send response, deviceId=%s | isSuccess=%b";
        r2 = new java.lang.Object[r8];
        r3 = r10.cfq;
        r3 = r3.byN;
        r2[r6] = r3;
        r3 = r10.cfq;
        r3 = r3.bLW;
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        goto L_0x0010;
    L_0x007e:
        r0 = com.tencent.mm.plugin.wear.model.a.bSl();
        r0 = r0.pIM;
        r0 = r0.pJd;
        r0 = r0.pJT;
        if (r0 == 0) goto L_0x0096;
    L_0x008a:
        r0 = r0.szd;
        r1 = r10.cfq;
        r1 = r1.byN;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x00a1;
    L_0x0096:
        r0 = "MicroMsg.Wear.WearBizLogic";
        r1 = "request is null or request.LocalNodeId is not same!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0010;
    L_0x00a1:
        r0 = "MicroMsg.Wear.WearBizLogic";
        r1 = "request step count deviceId=%s";
        r2 = new java.lang.Object[r7];
        r3 = r10.cfq;
        r3 = r3.byN;
        r2[r6] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r9.pIZ;
        r1 = r10.cfq;
        r1 = r1.byN;
        r1 = com.tencent.mm.plugin.wear.model.b.PJ(r1);
        r2 = com.tencent.mm.plugin.wear.model.b.bSm();
        if (r1 == 0) goto L_0x00d8;
    L_0x00c2:
        r3 = r0.pIW;
        if (r3 == 0) goto L_0x00d8;
    L_0x00c6:
        if (r2 == 0) goto L_0x00d8;
    L_0x00c8:
        r1 = com.tencent.mm.plugin.wear.model.a.bSl();
        r1 = r1.pIS;
        r2 = new com.tencent.mm.plugin.wear.model.b$2;
        r2.<init>(r0);
        r1.a(r2);
        goto L_0x0010;
    L_0x00d8:
        r3 = "MicroMsg.Wear.WearBizLogic";
        r4 = "isRegister=%b | isFocus=%b | isAuth=%b";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r1 = java.lang.Boolean.valueOf(r1);
        r5[r6] = r1;
        r1 = java.lang.Boolean.valueOf(r2);
        r5[r7] = r1;
        r0 = r0.pIW;
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r8] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.b$1.a(com.tencent.mm.sdk.b.b):boolean");
    }
}
