package com.tencent.mm.plugin.appbrand.r.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

final class b implements e {
    private final IntentFilter bnc = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private final d gCk = new d();
    Intent gCl = null;
    final e gCm = this;
    private a gCn;
    protected Context mContext;

    b() {
    }

    public final synchronized void init(Context context) {
        this.gCl = null;
        this.mContext = context.getApplicationContext();
    }

    public final synchronized void release() {
        if (this.mContext != null) {
            if (this.gCn != null) {
                this.mContext.unregisterReceiver(this.gCn);
            }
            this.mContext = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.tencent.mm.plugin.appbrand.r.a.c aoB() {
        /*
        r9 = this;
        r8 = 2;
        r1 = 1;
        r2 = 0;
        r3 = -1;
        monitor-enter(r9);
        r0 = r9.mContext;	 Catch:{ all -> 0x0072 }
        if (r0 != 0) goto L_0x0016;
    L_0x0009:
        r0 = "MicroMsg.AppBrandBatteryManagerImplBelow21";
        r1 = "getBatteryInfo no context";
        org.xwalk.core.Log.e(r0, r1);	 Catch:{ all -> 0x0072 }
        r0 = com.tencent.mm.plugin.appbrand.r.a.a.gCh;	 Catch:{ all -> 0x0072 }
    L_0x0014:
        monitor-exit(r9);
        return r0;
    L_0x0016:
        r0 = r9.mContext;	 Catch:{ all -> 0x0072 }
        r4 = r9.gCl;	 Catch:{ all -> 0x0072 }
        if (r4 == 0) goto L_0x002d;
    L_0x001c:
        r0 = r9.gCl;	 Catch:{ all -> 0x0072 }
        r4 = r0;
    L_0x001f:
        if (r4 != 0) goto L_0x0045;
    L_0x0021:
        r0 = "MicroMsg.AppBrandBatteryManagerImplBelow21";
        r1 = "getBatteryInfo no intent got";
        org.xwalk.core.Log.e(r0, r1);	 Catch:{ all -> 0x0072 }
        r0 = com.tencent.mm.plugin.appbrand.r.a.a.gCh;	 Catch:{ all -> 0x0072 }
        goto L_0x0014;
    L_0x002d:
        r4 = new com.tencent.mm.plugin.appbrand.r.a.b$a;	 Catch:{ all -> 0x0072 }
        r5 = 0;
        r4.<init>(r9, r5);	 Catch:{ all -> 0x0072 }
        r9.gCn = r4;	 Catch:{ all -> 0x0072 }
        r0 = r0.getApplicationContext();	 Catch:{ all -> 0x0072 }
        r4 = r9.gCn;	 Catch:{ all -> 0x0072 }
        r5 = r9.bnc;	 Catch:{ all -> 0x0072 }
        r0 = r0.registerReceiver(r4, r5);	 Catch:{ all -> 0x0072 }
        r9.gCl = r0;	 Catch:{ all -> 0x0072 }
        r4 = r0;
        goto L_0x001f;
    L_0x0045:
        r0 = new com.tencent.mm.plugin.appbrand.r.a.c;	 Catch:{ all -> 0x0072 }
        r0.<init>();	 Catch:{ all -> 0x0072 }
        if (r4 != 0) goto L_0x0075;
    L_0x004c:
        r0.gCq = r3;	 Catch:{ all -> 0x0072 }
        if (r4 == 0) goto L_0x00a1;
    L_0x0050:
        r3 = "status";
        r5 = -1;
        r3 = r4.getIntExtra(r3, r5);	 Catch:{ all -> 0x0072 }
        r5 = "plugged";
        r6 = 0;
        r4 = r4.getIntExtra(r5, r6);	 Catch:{ all -> 0x0072 }
        if (r3 == r8) goto L_0x006f;
    L_0x0062:
        if (r4 == r1) goto L_0x006f;
    L_0x0064:
        if (r4 == r8) goto L_0x006f;
    L_0x0066:
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0072 }
        r5 = 17;
        if (r3 < r5) goto L_0x00a1;
    L_0x006c:
        r3 = 4;
        if (r4 != r3) goto L_0x00a1;
    L_0x006f:
        r0.gCp = r1;	 Catch:{ all -> 0x0072 }
        goto L_0x0014;
    L_0x0072:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0075:
        r5 = "level";
        r6 = -1;
        r5 = r4.getIntExtra(r5, r6);	 Catch:{ all -> 0x0072 }
        r6 = "scale";
        r7 = -1;
        r6 = r4.getIntExtra(r6, r7);	 Catch:{ all -> 0x0072 }
        if (r6 <= 0) goto L_0x004c;
    L_0x0087:
        if (r5 < 0) goto L_0x004c;
    L_0x0089:
        r3 = (float) r5;	 Catch:{ all -> 0x0072 }
        r5 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r3 = r3 * r5;
        r5 = (float) r6;	 Catch:{ all -> 0x0072 }
        r3 = r3 / r5;
        r6 = (double) r3;	 Catch:{ all -> 0x0072 }
        r6 = java.lang.Math.floor(r6);	 Catch:{ all -> 0x0072 }
        r3 = (int) r6;	 Catch:{ all -> 0x0072 }
        r5 = 0;
        r3 = java.lang.Math.max(r3, r5);	 Catch:{ all -> 0x0072 }
        r5 = 100;
        r3 = java.lang.Math.min(r3, r5);	 Catch:{ all -> 0x0072 }
        goto L_0x004c;
    L_0x00a1:
        r1 = r2;
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.r.a.b.aoB():com.tencent.mm.plugin.appbrand.r.a.c");
    }
}
