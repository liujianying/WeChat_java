package com.tencent.mm.console.a.b;

import com.tencent.mm.console.a.b.a.a;

class a$4 implements a {
    final /* synthetic */ b dhA;
    final /* synthetic */ a dhC;
    final /* synthetic */ String dhF;
    final /* synthetic */ int dhG;
    final /* synthetic */ int[] dhH;

    a$4(a aVar, String str, int i, int[] iArr, b bVar) {
        this.dhC = aVar;
        this.dhF = str;
        this.dhG = i;
        this.dhH = iArr;
        this.dhA = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void execute() {
        /*
        r13 = this;
        r12 = 1;
        r2 = 0;
        r0 = "MicroMsg.AgingTestCommand";
        r1 = "[oneliang] batch insert test msg info, begin single transaction, username:%s";
        r3 = new java.lang.Object[r12];
        r4 = r13.dhF;
        r3[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
        r6 = java.lang.System.currentTimeMillis();
        r1 = r2;
    L_0x0016:
        r0 = r13.dhG;
        if (r1 >= r0) goto L_0x00dd;
    L_0x001a:
        r0 = r13.dhH;
        r0 = r0.length;
        r0 = com.tencent.mm.console.a.b.a.gc(r0);
        r3 = r13.dhH;
        r5 = r3[r0];
        r3 = 0;
        switch(r5) {
            case 3: goto L_0x004e;
            case 43: goto L_0x0076;
            case 47: goto L_0x009e;
            default: goto L_0x0029;
        };
    L_0x0029:
        r0 = r13.dhF;
        r0 = com.tencent.mm.console.a.b.a.B(r0, r1);
        r4 = r0;
    L_0x0030:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.bcY();
        r8 = r0.T(r4);
        r10 = 0;
        r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x00c9;
    L_0x0046:
        if (r1 <= 0) goto L_0x00c7;
    L_0x0048:
        r1 = r1 + -1;
    L_0x004a:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0016;
    L_0x004e:
        r0 = r13.dhA;
        r0 = r0.dhJ;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x004a;
    L_0x0058:
        r4 = r13.dhF;
        r0 = r13.dhA;
        r0 = r0.dhJ;
        r8 = r13.dhA;
        r8 = r8.dhJ;
        r8 = r8.size();
        r8 = com.tencent.mm.console.a.b.a.gc(r8);
        r0 = r0.get(r8);
        r0 = (com.tencent.mm.console.a.b.c) r0;
        r0 = com.tencent.mm.console.a.b.a.a(r4, r0);
        r4 = r0;
        goto L_0x0030;
    L_0x0076:
        r0 = r13.dhA;
        r0 = r0.dhK;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x004a;
    L_0x0080:
        r0 = r13.dhA;
        r0 = r0.dhK;
        r3 = r13.dhA;
        r3 = r3.dhK;
        r3 = r3.size();
        r3 = com.tencent.mm.console.a.b.a.gc(r3);
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.console.a.b.c) r0;
        r3 = r13.dhF;
        r4 = com.tencent.mm.console.a.b.a.b(r3, r0);
        r3 = r0;
        goto L_0x0030;
    L_0x009e:
        r0 = r13.dhA;
        r0 = r0.dhL;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x004a;
    L_0x00a8:
        r4 = r13.dhF;
        r0 = r13.dhA;
        r0 = r0.dhL;
        r8 = r13.dhA;
        r8 = r8.dhL;
        r8 = r8.size();
        r8 = com.tencent.mm.console.a.b.a.gc(r8);
        r0 = r0.get(r8);
        r0 = (com.tencent.mm.console.a.b.c) r0;
        r0 = com.tencent.mm.console.a.b.a.c(r4, r0);
        r4 = r0;
        goto L_0x0030;
    L_0x00c7:
        r1 = r2;
        goto L_0x004a;
    L_0x00c9:
        r0 = 43;
        if (r5 != r0) goto L_0x004a;
    L_0x00cd:
        r0 = com.tencent.mm.modelvideo.o.Ta();
        r5 = r13.dhF;
        r8 = (int) r8;
        r3 = com.tencent.mm.console.a.b.a.a(r5, r8, r4, r3);
        r0.a(r3);
        goto L_0x004a;
    L_0x00dd:
        r0 = "MicroMsg.AgingTestCommand";
        r1 = "[oneliang] batch insert test msg info, end single transaction, username:%s, cost:%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = r13.dhF;
        r3[r2] = r4;
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r2 = java.lang.Long.valueOf(r4);
        r3[r12] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.a.b.a$4.execute():void");
    }
}
