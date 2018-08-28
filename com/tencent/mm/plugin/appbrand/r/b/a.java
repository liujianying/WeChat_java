package com.tencent.mm.plugin.appbrand.r.b;

import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class a {
    private final TencentLocationManager gCr = TencentLocationManager.getInstance(ad.getContext());
    private final a gCs = new a(this, (byte) 0);
    final HashSet<b> gCt = new HashSet();

    a() {
        x.i("MicroMsg.AppbrandLocationUpdateRegistry", "construct in process %s", new Object[]{((h) g.Ef().DM()).dox});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.r.b.b r8) {
        /*
        r7 = this;
        r6 = 1;
        r1 = r7.gCt;
        monitor-enter(r1);
        r0 = r7.gCt;	 Catch:{ all -> 0x006f }
        r2 = r0.iterator();	 Catch:{ all -> 0x006f }
    L_0x000a:
        r0 = r2.hasNext();	 Catch:{ all -> 0x006f }
        if (r0 == 0) goto L_0x0020;
    L_0x0010:
        r0 = r2.next();	 Catch:{ all -> 0x006f }
        r0 = (com.tencent.mm.plugin.appbrand.r.b.b) r0;	 Catch:{ all -> 0x006f }
        if (r0 == 0) goto L_0x000a;
    L_0x0018:
        r0 = r0.equals(r8);	 Catch:{ all -> 0x006f }
        if (r0 == 0) goto L_0x000a;
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x006f }
    L_0x001f:
        return;
    L_0x0020:
        r0 = r7.gCt;	 Catch:{ all -> 0x006f }
        r0.add(r8);	 Catch:{ all -> 0x006f }
        r0 = "MicroMsg.AppbrandLocationUpdateRegistry";
        r2 = "registerLocationListener %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x006f }
        r4 = 0;
        r5 = r7.gCt;	 Catch:{ all -> 0x006f }
        r5 = r5.size();	 Catch:{ all -> 0x006f }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x006f }
        r3[r4] = r5;	 Catch:{ all -> 0x006f }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x006f }
        r0 = r7.gCt;	 Catch:{ all -> 0x006f }
        r0 = r0.size();	 Catch:{ all -> 0x006f }
        if (r0 != r6) goto L_0x006d;
    L_0x0046:
        r0 = "MicroMsg.AppbrandLocationUpdateRegistry";
        r2 = "registerLocation ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x006f }
        r0 = com.tencent.map.geolocation.TencentLocationRequest.create();	 Catch:{ all -> 0x006f }
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0.setInterval(r2);	 Catch:{ all -> 0x006f }
        r2 = r7.gCr;	 Catch:{ all -> 0x006f }
        r3 = 1;
        r2.setCoordinateType(r3);	 Catch:{ all -> 0x006f }
        r2 = r7.gCr;	 Catch:{ all -> 0x006f }
        r3 = r7.gCs;	 Catch:{ all -> 0x006f }
        r4 = com.tencent.mm.bu.a.coq();	 Catch:{ all -> 0x006f }
        r4 = r4.getLooper();	 Catch:{ all -> 0x006f }
        r2.requestLocationUpdates(r0, r3, r4);	 Catch:{ all -> 0x006f }
    L_0x006d:
        monitor-exit(r1);	 Catch:{ all -> 0x006f }
        goto L_0x001f;
    L_0x006f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x006f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.r.b.a.a(com.tencent.mm.plugin.appbrand.r.b.b):void");
    }

    public final void b(b bVar) {
        if (bVar != null) {
            synchronized (this.gCt) {
                Iterator it = this.gCt.iterator();
                while (it.hasNext()) {
                    b bVar2 = (b) it.next();
                    if (bVar2 != null && bVar2.equals(bVar)) {
                        this.gCt.remove(bVar2);
                        break;
                    }
                }
                x.i("MicroMsg.AppbrandLocationUpdateRegistry", "unregisterLocationListener %d", new Object[]{Integer.valueOf(this.gCt.size())});
                if (this.gCt.size() == 0) {
                    x.i("MicroMsg.AppbrandLocationUpdateRegistry", "unregisterLocation ");
                    this.gCr.removeUpdates(this.gCs);
                }
            }
        }
    }
}
