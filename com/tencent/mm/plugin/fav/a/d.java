package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.Iterator;

public final class d {
    private static d iVz = null;
    private long endTime = -1;
    private Object iVA = new Object();
    private Runnable iVB = new 1(this);
    public ArrayList<a> iVy = new ArrayList();
    private boolean ikj = false;
    ag mHandler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            Iterator it = d.this.iVy.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.onFinish();
                }
            }
            d.this.iVy.clear();
        }
    };
    private long startTime = -1;

    private d() {
    }

    public static synchronized d aLb() {
        d dVar;
        synchronized (d.class) {
            if (iVz == null) {
                iVz = new d();
            }
            dVar = iVz;
        }
        return dVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.fav.a.d.a r5) {
        /*
        r4 = this;
        r1 = r4.iVA;
        monitor-enter(r1);
        r0 = com.tencent.mm.kernel.g.Ei();	 Catch:{ all -> 0x003b }
        r0 = r0.DT();	 Catch:{ all -> 0x003b }
        r2 = com.tencent.mm.storage.aa.a.sRp;	 Catch:{ all -> 0x003b }
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x003b }
        r0 = r0.get(r2, r3);	 Catch:{ all -> 0x003b }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x003b }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        if (r5 == 0) goto L_0x0023;
    L_0x0020:
        r5.onFinish();	 Catch:{ all -> 0x003b }
    L_0x0023:
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
    L_0x0024:
        return;
    L_0x0025:
        if (r5 == 0) goto L_0x002c;
    L_0x0027:
        r0 = r4.iVy;	 Catch:{ all -> 0x003b }
        r0.add(r5);	 Catch:{ all -> 0x003b }
    L_0x002c:
        r0 = r4.ikj;	 Catch:{ all -> 0x003b }
        if (r0 == 0) goto L_0x003e;
    L_0x0030:
        r0 = "MicroMsg.FavCleanFirstLoader";
        r2 = "isLoading is true, ignore";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x003b }
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
        goto L_0x0024;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r0 = 1;
        r4.ikj = r0;	 Catch:{ all -> 0x003b }
        monitor-exit(r1);	 Catch:{ all -> 0x003b }
        r0 = java.lang.System.currentTimeMillis();
        r4.startTime = r0;
        r0 = r4.iVB;
        r1 = "FavCleanFirstLoader_CalFavDataLength";
        com.tencent.mm.sdk.f.e.post(r0, r1);
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.a.d.a(com.tencent.mm.plugin.fav.a.d$a):void");
    }
}
