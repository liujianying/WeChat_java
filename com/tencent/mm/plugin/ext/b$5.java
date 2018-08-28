package com.tencent.mm.plugin.ext;

import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;

class b$5 implements a {
    final /* synthetic */ b iJo;

    b$5(b bVar) {
        this.iJo = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.f r9, com.tencent.mm.plugin.messenger.foundation.a.a.f.c r10) {
        /*
        r8 = this;
        r0 = 0;
        if (r9 == 0) goto L_0x0009;
    L_0x0003:
        if (r10 == 0) goto L_0x0009;
    L_0x0005:
        r1 = r10.lcy;
        if (r1 != 0) goto L_0x0013;
    L_0x0009:
        r0 = "MicroMsg.SubCoreExt";
        r1 = "onMsgChange, wrong args";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0012:
        return;
    L_0x0013:
        r3 = r8.iJo;
        monitor-enter(r3);
        r1 = com.tencent.mm.plugin.ext.b.aIL();	 Catch:{ all -> 0x002b }
        r1 = r1.cmR();	 Catch:{ all -> 0x002b }
        if (r1 != 0) goto L_0x002e;
    L_0x0020:
        r0 = "MicroMsg.SubCoreExt";
        r1 = "onMsgChange onNotifyChange getValidOpenMsgListener cu == null";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0012;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r2 = "MicroMsg.SubCoreExt";
        r4 = "onMsgChange onNotifyChange listener count = %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x002b }
        r6 = 0;
        r7 = r1.getCount();	 Catch:{ all -> 0x002b }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x002b }
        r5[r6] = r7;	 Catch:{ all -> 0x002b }
        com.tencent.mm.sdk.platformtools.x.d(r2, r4, r5);	 Catch:{ all -> 0x002b }
        r2 = r1.getCount();	 Catch:{ all -> 0x002b }
        if (r2 > 0) goto L_0x0059;
    L_0x004b:
        r1.close();	 Catch:{ all -> 0x002b }
        r0 = "MicroMsg.SubCoreExt";
        r1 = "onMsgChange onNotifyChange cu.getCount() <= 0";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0012;
    L_0x0059:
        r1.close();	 Catch:{ all -> 0x002b }
        r2 = r0;
    L_0x005d:
        r0 = r10.lcy;	 Catch:{ all -> 0x002b }
        r0 = r0.size();	 Catch:{ all -> 0x002b }
        if (r2 >= r0) goto L_0x0109;
    L_0x0065:
        r0 = r10.lcy;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r2);	 Catch:{ all -> 0x002b }
        r0 = (com.tencent.mm.storage.bd) r0;	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x00d1;
    L_0x006f:
        r1 = r0.field_isSend;	 Catch:{ all -> 0x002b }
        if (r1 != 0) goto L_0x00d1;
    L_0x0073:
        r1 = r0.field_status;	 Catch:{ all -> 0x002b }
        r4 = 4;
        if (r1 == r4) goto L_0x00d1;
    L_0x0078:
        r1 = r0.getType();	 Catch:{ all -> 0x002b }
        r4 = 9999; // 0x270f float:1.4012E-41 double:4.94E-320;
        if (r1 == r4) goto L_0x00d1;
    L_0x0080:
        r1 = r0.getType();	 Catch:{ all -> 0x002b }
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        if (r1 == r4) goto L_0x00d1;
    L_0x0088:
        r1 = r0.field_talker;	 Catch:{ all -> 0x002b }
        r1 = com.tencent.mm.model.s.hP(r1);	 Catch:{ all -> 0x002b }
        if (r1 != 0) goto L_0x00d1;
    L_0x0090:
        r1 = r0.field_talker;	 Catch:{ all -> 0x002b }
        r1 = com.tencent.mm.model.s.hT(r1);	 Catch:{ all -> 0x002b }
        if (r1 != 0) goto L_0x00d1;
    L_0x0098:
        r1 = r8.iJo;	 Catch:{ all -> 0x002b }
        r1 = com.tencent.mm.plugin.ext.b.a(r1);	 Catch:{ all -> 0x002b }
        r4 = r0.field_talker;	 Catch:{ all -> 0x002b }
        r1 = r1.get(r4);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x002b }
        if (r1 != 0) goto L_0x00d5;
    L_0x00a8:
        r1 = r8.iJo;	 Catch:{ all -> 0x002b }
        r1 = com.tencent.mm.plugin.ext.b.a(r1);	 Catch:{ all -> 0x002b }
        r4 = r0.field_talker;	 Catch:{ all -> 0x002b }
        r5 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x002b }
        r1.put(r4, r5);	 Catch:{ all -> 0x002b }
        r1 = "MicroMsg.SubCoreExt";
        r4 = "onMsgChange %s, %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x002b }
        r6 = 0;
        r0 = r0.field_talker;	 Catch:{ all -> 0x002b }
        r5[r6] = r0;	 Catch:{ all -> 0x002b }
        r0 = 1;
        r6 = 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x002b }
        r5[r0] = r6;	 Catch:{ all -> 0x002b }
        com.tencent.mm.sdk.platformtools.x.d(r1, r4, r5);	 Catch:{ all -> 0x002b }
    L_0x00d1:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x005d;
    L_0x00d5:
        r4 = r8.iJo;	 Catch:{ all -> 0x002b }
        r4 = com.tencent.mm.plugin.ext.b.a(r4);	 Catch:{ all -> 0x002b }
        r5 = r0.field_talker;	 Catch:{ all -> 0x002b }
        r6 = r1.intValue();	 Catch:{ all -> 0x002b }
        r6 = r6 + 1;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x002b }
        r4.put(r5, r6);	 Catch:{ all -> 0x002b }
        r4 = "MicroMsg.SubCoreExt";
        r5 = "onMsgChange %s, %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x002b }
        r7 = 0;
        r0 = r0.field_talker;	 Catch:{ all -> 0x002b }
        r6[r7] = r0;	 Catch:{ all -> 0x002b }
        r0 = 1;
        r1 = r1.intValue();	 Catch:{ all -> 0x002b }
        r1 = r1 + 1;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x002b }
        r6[r0] = r1;	 Catch:{ all -> 0x002b }
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);	 Catch:{ all -> 0x002b }
        goto L_0x00d1;
    L_0x0109:
        r0 = r8.iJo;	 Catch:{ all -> 0x002b }
        r0 = com.tencent.mm.plugin.ext.b.a(r0);	 Catch:{ all -> 0x002b }
        r0 = r0.size();	 Catch:{ all -> 0x002b }
        if (r0 <= 0) goto L_0x011d;
    L_0x0115:
        r0 = r8.iJo;	 Catch:{ all -> 0x002b }
        r0.aIQ();	 Catch:{ all -> 0x002b }
    L_0x011a:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0012;
    L_0x011d:
        r0 = "MicroMsg.SubCoreExt";
        r1 = "notifyMsgUsers.size < 1";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x002b }
        goto L_0x011a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b$5.a(com.tencent.mm.plugin.messenger.foundation.a.a.f, com.tencent.mm.plugin.messenger.foundation.a.a.f$c):void");
    }
}
