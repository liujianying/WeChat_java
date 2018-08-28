package com.tencent.c.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import java.util.concurrent.atomic.AtomicBoolean;

class g$a implements SensorEventListener {
    long vjP = 0;
    final AtomicBoolean vka = new AtomicBoolean(false);
    int vkb = 0;
    long vkc = 0;
    final /* synthetic */ g vkd;

    g$a(g gVar) {
        this.vkd = gVar;
    }

    public final long cFq() {
        long j;
        synchronized (this.vka) {
            j = this.vjP;
        }
        return j;
    }

    public final long cFr() {
        long j;
        synchronized (this.vka) {
            j = this.vkc;
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSensorChanged(android.hardware.SensorEvent r9) {
        /*
        r8 = this;
        r1 = r8.vka;
        monitor-enter(r1);
        r0 = r8.vka;	 Catch:{ all -> 0x0030 }
        r0 = r0.get();	 Catch:{ all -> 0x0030 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0030 }
    L_0x000c:
        return;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0030 }
        if (r9 == 0) goto L_0x000c;
    L_0x0010:
        r0 = r9.sensor;
        if (r0 == 0) goto L_0x000c;
    L_0x0014:
        r2 = new com.tencent.c.e.a.a.j;
        r0 = java.lang.System.currentTimeMillis();
        r2.<init>(r9, r0);
        r1 = r8.vka;
        monitor-enter(r1);
        r4 = r2.timestamp;	 Catch:{ all -> 0x002d }
        r6 = r8.vjP;	 Catch:{ all -> 0x002d }
        r4 = r4 - r6;
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0033;
    L_0x002b:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        goto L_0x000c;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        throw r0;
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0030 }
        throw r0;
    L_0x0033:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        r1 = r2.vkh;
        r6 = com.tencent.c.e.a.a.f.vjT;
        r4 = r4 / r6;
        r3 = (int) r4;
        r0 = r8.vkd;
        r4 = com.tencent.c.e.a.a.g.a(r0);
        monitor-enter(r4);
        r0 = r8.vkd;	 Catch:{ all -> 0x0086 }
        r0 = com.tencent.c.e.a.a.g.a(r0);	 Catch:{ all -> 0x0086 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0086 }
        r0 = (com.tencent.c.e.a.a.i) r0;	 Catch:{ all -> 0x0086 }
        if (r0 != 0) goto L_0x0089;
    L_0x004f:
        r0 = new com.tencent.c.e.a.a.i;	 Catch:{ all -> 0x0086 }
        r5 = com.tencent.c.e.a.a.f.vjU;	 Catch:{ all -> 0x0086 }
        r6 = r8.vkb;	 Catch:{ all -> 0x0086 }
        r0.<init>(r1, r5, r6);	 Catch:{ all -> 0x0086 }
        r5 = r8.vkd;	 Catch:{ all -> 0x0086 }
        r5 = com.tencent.c.e.a.a.g.a(r5);	 Catch:{ all -> 0x0086 }
        r5.put(r1, r0);	 Catch:{ all -> 0x0086 }
        r1 = r0;
    L_0x0062:
        r0 = r1.dty;	 Catch:{ all -> 0x0086 }
        if (r3 >= r0) goto L_0x0084;
    L_0x0066:
        r0 = r1.iUy;	 Catch:{ all -> 0x0086 }
        if (r3 <= r0) goto L_0x0084;
    L_0x006a:
        r0 = r1.uVx;	 Catch:{ all -> 0x0086 }
        r5 = r3 / r0;
        r0 = r1.tD;	 Catch:{ all -> 0x0086 }
        r0 = r0[r5];	 Catch:{ all -> 0x0086 }
        r0 = (java.util.List) r0;	 Catch:{ all -> 0x0086 }
        if (r0 != 0) goto L_0x007f;
    L_0x0076:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0086 }
        r0.<init>();	 Catch:{ all -> 0x0086 }
        r6 = r1.tD;	 Catch:{ all -> 0x0086 }
        r6[r5] = r0;	 Catch:{ all -> 0x0086 }
    L_0x007f:
        r0.add(r2);	 Catch:{ all -> 0x0086 }
        r1.iUy = r3;	 Catch:{ all -> 0x0086 }
    L_0x0084:
        monitor-exit(r4);	 Catch:{ all -> 0x0086 }
        goto L_0x000c;
    L_0x0086:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0086 }
        throw r0;
    L_0x0089:
        r1 = r0;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.c.e.a.a.g$a.onSensorChanged(android.hardware.SensorEvent):void");
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
