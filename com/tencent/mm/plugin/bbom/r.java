package com.tencent.mm.plugin.bbom;

import com.tencent.mm.model.ao;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class r implements s {
    private static List<ao> heC = new ArrayList();
    private boolean heD;
    private boolean heE;
    private List<bd> heF;

    public static void a(ao aoVar) {
        synchronized (heC) {
            if (!heC.contains(aoVar)) {
                heC.add(aoVar);
            }
        }
    }

    public static void b(ao aoVar) {
        synchronized (heC) {
            heC.remove(aoVar);
        }
    }

    public r() {
        this(false);
    }

    public r(boolean z) {
        this.heD = false;
        this.heE = false;
        this.heF = new LinkedList();
        this.heD = z;
        this.heE = false;
        this.heF = new LinkedList();
    }

    public final void atH() {
        List linkedList = new LinkedList();
        linkedList.addAll(this.heF);
        this.heF.clear();
        if (linkedList.size() != 0) {
            List<ao> arrayList = new ArrayList();
            synchronized (heC) {
                for (ao add : heC) {
                    arrayList.add(add);
                }
            }
            for (ao add2 : arrayList) {
                new ag(add2.getLooper()).post(new 1(this, add2, linkedList));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final com.tencent.mm.storage.bd r5, final com.tencent.mm.protocal.c.by r6) {
        /*
        r4 = this;
        r0 = r4.heD;
        if (r0 == 0) goto L_0x000e;
    L_0x0004:
        r0 = "MicroMsg.SyncMessageNotifier";
        r1 = "mDummy is true, do nothing and return.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x000d:
        return;
    L_0x000e:
        r1 = heC;
        monitor-enter(r1);
        r0 = heC;	 Catch:{ all -> 0x0024 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0027;
    L_0x0019:
        r0 = "MicroMsg.SyncMessageNotifier";
        r2 = "no notifiers, ignore";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0024 }
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        goto L_0x000d;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        throw r0;
    L_0x0027:
        monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        r0 = r5.field_isSend;
        if (r0 != 0) goto L_0x0031;
    L_0x002c:
        r0 = r5.field_status;
        r1 = 4;
        if (r0 != r1) goto L_0x003b;
    L_0x0031:
        r0 = "MicroMsg.SyncMessageNotifier";
        r1 = "not new msg, ignore";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x000d;
    L_0x003b:
        r0 = r6.rcj;
        r0 = com.tencent.mm.platformtools.ab.a(r0);
        com.tencent.mm.model.au.HU();
        r1 = com.tencent.mm.model.c.FZ();
        r2 = new com.tencent.mm.storage.bl$a;
        r2.<init>(r0);
        r0 = "";
        r0 = r2.Zk(r0);
        r0 = r1.Hg(r0);
        if (r0 == 0) goto L_0x006a;
    L_0x005a:
        r0 = r0.cmV();
        if (r0 != 0) goto L_0x006a;
    L_0x0060:
        r0 = "MicroMsg.SyncMessageNotifier";
        r1 = "account no notification";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        goto L_0x000d;
    L_0x006a:
        r0 = r4.heE;
        if (r0 != 0) goto L_0x00b5;
    L_0x006e:
        r0 = 1;
        r4.heE = r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = heC;
        monitor-enter(r2);
        r0 = heC;	 Catch:{ all -> 0x008f }
        r3 = r0.iterator();	 Catch:{ all -> 0x008f }
    L_0x007f:
        r0 = r3.hasNext();	 Catch:{ all -> 0x008f }
        if (r0 == 0) goto L_0x0092;
    L_0x0085:
        r0 = r3.next();	 Catch:{ all -> 0x008f }
        r0 = (com.tencent.mm.model.ao) r0;	 Catch:{ all -> 0x008f }
        r1.add(r0);	 Catch:{ all -> 0x008f }
        goto L_0x007f;
    L_0x008f:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x008f }
        throw r0;
    L_0x0092:
        monitor-exit(r2);	 Catch:{ all -> 0x008f }
        r1 = r1.iterator();
    L_0x0097:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x000d;
    L_0x009d:
        r0 = r1.next();
        r0 = (com.tencent.mm.model.ao) r0;
        r2 = new com.tencent.mm.sdk.platformtools.ag;
        r3 = r0.getLooper();
        r2.<init>(r3);
        r3 = new com.tencent.mm.plugin.bbom.r$2;
        r3.<init>(r6, r0, r5);
        r2.post(r3);
        goto L_0x0097;
    L_0x00b5:
        r0 = r4.heF;
        r0.add(r5);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.bbom.r.a(com.tencent.mm.storage.bd, com.tencent.mm.protocal.c.by):void");
    }
}
