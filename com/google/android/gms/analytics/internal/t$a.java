package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.stats.b;

protected class t$a implements ServiceConnection {
    final /* synthetic */ t aGt;
    private volatile d aGu;
    private volatile boolean aGv;

    protected t$a(t tVar) {
        this.aGt = tVar;
    }

    public final d nz() {
        d dVar = null;
        q.nx();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context context = this.aGt.aFn.mContext;
        intent.putExtra("app_package_name", context.getPackageName());
        b pG = b.pG();
        synchronized (this) {
            this.aGu = null;
            this.aGv = true;
            boolean a = pG.a(context, intent, this.aGt.aGp, 129);
            this.aGt.d("Bind to service requested", Boolean.valueOf(a));
            if (a) {
                try {
                    wait(((Long) aj.aIc.get()).longValue());
                } catch (InterruptedException e) {
                    this.aGt.aR("Wait for service connect was interrupted");
                }
                this.aGv = false;
                dVar = this.aGu;
                this.aGu = null;
                if (dVar == null) {
                    this.aGt.aS("Successfully bound to service but never got onServiceConnected callback");
                }
            } else {
                this.aGv = false;
            }
        }
        return dVar;
    }

    public final void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.analytics.internal.t$a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void, dom blocks: [B:3:0x0009, B:9:0x0017]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:89)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r4 = this;
        r0 = "AnalyticsServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.w.bh(r0);
        monitor-enter(r4);
        if (r6 != 0) goto L_0x0016;
    L_0x0009:
        r0 = r4.aGt;	 Catch:{ all -> 0x005e }
        r1 = "Service connected with null binder";	 Catch:{ all -> 0x005e }
        r0.aS(r1);	 Catch:{ all -> 0x005e }
        r4.notifyAll();	 Catch:{ all -> 0x0048 }
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
    L_0x0015:
        return;
    L_0x0016:
        r0 = 0;
        r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0054 }
        r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0054 }
        r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0054 }
        if (r2 == 0) goto L_0x004b;	 Catch:{ RemoteException -> 0x0054 }
    L_0x0024:
        r0 = com.google.android.gms.analytics.internal.d.a.d(r6);	 Catch:{ RemoteException -> 0x0054 }
        r1 = r4.aGt;	 Catch:{ RemoteException -> 0x0054 }
        r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0054 }
        r1.aO(r2);	 Catch:{ RemoteException -> 0x0054 }
    L_0x0030:
        if (r0 != 0) goto L_0x0063;
    L_0x0032:
        r0 = com.google.android.gms.common.stats.b.pG();	 Catch:{ IllegalArgumentException -> 0x0083 }
        r1 = r4.aGt;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r1 = r1.aFn;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r1 = r1.mContext;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r2 = r4.aGt;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r2 = r2.aGp;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0083 }
    L_0x0043:
        r4.notifyAll();	 Catch:{ all -> 0x0048 }
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        goto L_0x0015;	 Catch:{ all -> 0x0048 }
    L_0x0048:
        r0 = move-exception;	 Catch:{ all -> 0x0048 }
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        throw r0;
    L_0x004b:
        r2 = r4.aGt;	 Catch:{ RemoteException -> 0x0054 }
        r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0054 }
        r2.g(r3, r1);	 Catch:{ RemoteException -> 0x0054 }
        goto L_0x0030;
    L_0x0054:
        r1 = move-exception;
        r1 = r4.aGt;	 Catch:{ all -> 0x005e }
        r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x005e }
        r1.aS(r2);	 Catch:{ all -> 0x005e }
        goto L_0x0030;
    L_0x005e:
        r0 = move-exception;
        r4.notifyAll();	 Catch:{ all -> 0x0048 }
        throw r0;	 Catch:{ all -> 0x0048 }
    L_0x0063:
        r1 = r4.aGv;	 Catch:{ all -> 0x005e }
        if (r1 != 0) goto L_0x0080;	 Catch:{ all -> 0x005e }
    L_0x0067:
        r1 = r4.aGt;	 Catch:{ all -> 0x005e }
        r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x005e }
        r1.aR(r2);	 Catch:{ all -> 0x005e }
        r1 = r4.aGt;	 Catch:{ all -> 0x005e }
        r1 = r1.aFn;	 Catch:{ all -> 0x005e }
        r1 = r1.ns();	 Catch:{ all -> 0x005e }
        r2 = new com.google.android.gms.analytics.internal.t$a$1;	 Catch:{ all -> 0x005e }
        r2.<init>(r4, r0);	 Catch:{ all -> 0x005e }
        r1.d(r2);	 Catch:{ all -> 0x005e }
        goto L_0x0043;	 Catch:{ all -> 0x005e }
    L_0x0080:
        r4.aGu = r0;	 Catch:{ all -> 0x005e }
        goto L_0x0043;
    L_0x0083:
        r0 = move-exception;
        goto L_0x0043;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.t$a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        w.bh("AnalyticsServiceConnection.onServiceDisconnected");
        this.aGt.aFn.ns().d(new 2(this, componentName));
    }
}
