package com.google.android.gms.c;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;

public final class as {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private final String aPz;
    public final WakeLock aZe;
    private WorkSource aZf;
    private final int aZg;
    private final String aZh;
    private boolean aZi;
    private int aZj;
    private int aZk;
    private final Context mContext;

    private as(Context context, String str) {
        this.aZi = true;
        w.i(str, "Wake lock name can NOT be empty");
        this.aZg = 1;
        this.aPz = str;
        this.aZh = null;
        this.mContext = context.getApplicationContext();
        this.aZe = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
        if (ac.at(this.mContext)) {
            String str2;
            if (!ab.bt(null)) {
                str2 = null;
            } else if (f.aNr && j.isInitialized()) {
                new StringBuilder("callingPackage is not supposed to be empty for wakelock ").append(this.aPz).append("!");
                str2 = "com.google.android.gms";
            } else {
                str2 = context.getPackageName();
            }
            this.aZf = ac.m(context, str2);
            WorkSource workSource = this.aZf;
            if (ac.at(this.mContext) && workSource != null) {
                if (this.aZf != null) {
                    this.aZf.add(workSource);
                } else {
                    this.aZf = workSource;
                }
                this.aZe.setWorkSource(this.aZf);
            }
        }
    }

    public as(Context context, String str, byte b) {
        this(context, str);
    }

    private String aw(boolean z) {
        return this.aZi ? z ? null : this.aZh : this.aZh;
    }

    private boolean qs() {
        Object obj = null;
        return (TextUtils.isEmpty(obj) || obj.equals(this.aZh)) ? false : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void qr() {
        /*
        r7 = this;
        r0 = 14;
        r0 = com.google.android.gms.c.z.dx(r0);
        if (r0 != 0) goto L_0x0023;
    L_0x0008:
        r0 = r7.aZi;
        if (r0 == 0) goto L_0x0023;
    L_0x000c:
        r0 = TAG;
        r1 = new java.lang.StringBuilder;
        r2 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ";
        r1.<init>(r2);
        r2 = r7.aPz;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.wtf(r0, r1);
    L_0x0023:
        r0 = r7.qs();
        r4 = r7.aw(r0);
        r1 = DEBUG;
        if (r1 == 0) goto L_0x0085;
    L_0x002f:
        r1 = new java.lang.StringBuilder;
        r2 = "Acquire:\n mWakeLockName: ";
        r1.<init>(r2);
        r2 = r7.aPz;
        r1 = r1.append(r2);
        r2 = "\n mSecondaryName: ";
        r1 = r1.append(r2);
        r2 = r7.aZh;
        r1 = r1.append(r2);
        r2 = "\nmReferenceCounted: ";
        r1 = r1.append(r2);
        r2 = r7.aZi;
        r1 = r1.append(r2);
        r2 = "\nreason: ";
        r1 = r1.append(r2);
        r2 = 0;
        r1 = r1.append(r2);
        r2 = "\nmOpenEventCount";
        r1 = r1.append(r2);
        r2 = r7.aZk;
        r1 = r1.append(r2);
        r2 = "\nuseWithReason: ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = "\ntrackingName: ";
        r1 = r1.append(r2);
        r1.append(r4);
    L_0x0085:
        monitor-enter(r7);
        r1 = r7.aZi;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x0094;
    L_0x008a:
        r1 = r7.aZj;	 Catch:{ all -> 0x00c4 }
        r2 = r1 + 1;
        r7.aZj = r2;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x009c;
    L_0x0092:
        if (r0 != 0) goto L_0x009c;
    L_0x0094:
        r0 = r7.aZi;	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x00bb;
    L_0x0098:
        r0 = r7.aZk;	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x00bb;
    L_0x009c:
        com.google.android.gms.common.stats.h.pH();	 Catch:{ all -> 0x00c4 }
        r0 = r7.mContext;	 Catch:{ all -> 0x00c4 }
        r1 = r7.aZe;	 Catch:{ all -> 0x00c4 }
        r1 = com.google.android.gms.common.stats.f.a(r1, r4);	 Catch:{ all -> 0x00c4 }
        r2 = 7;
        r3 = r7.aPz;	 Catch:{ all -> 0x00c4 }
        r5 = r7.aZg;	 Catch:{ all -> 0x00c4 }
        r6 = r7.aZf;	 Catch:{ all -> 0x00c4 }
        r6 = com.google.android.gms.c.ac.b(r6);	 Catch:{ all -> 0x00c4 }
        com.google.android.gms.common.stats.h.a(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00c4 }
        r0 = r7.aZk;	 Catch:{ all -> 0x00c4 }
        r0 = r0 + 1;
        r7.aZk = r0;	 Catch:{ all -> 0x00c4 }
    L_0x00bb:
        monitor-exit(r7);	 Catch:{ all -> 0x00c4 }
        r0 = r7.aZe;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.acquire(r2);
        return;
    L_0x00c4:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00c4 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.as.qr():void");
    }

    public final void qt() {
        this.aZe.setReferenceCounted(false);
        this.aZi = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
        r7 = this;
        r0 = r7.qs();
        r4 = r7.aw(r0);
        r1 = DEBUG;
        if (r1 == 0) goto L_0x0062;
    L_0x000c:
        r1 = new java.lang.StringBuilder;
        r2 = "Release:\n mWakeLockName: ";
        r1.<init>(r2);
        r2 = r7.aPz;
        r1 = r1.append(r2);
        r2 = "\n mSecondaryName: ";
        r1 = r1.append(r2);
        r2 = r7.aZh;
        r1 = r1.append(r2);
        r2 = "\nmReferenceCounted: ";
        r1 = r1.append(r2);
        r2 = r7.aZi;
        r1 = r1.append(r2);
        r2 = "\nreason: ";
        r1 = r1.append(r2);
        r2 = 0;
        r1 = r1.append(r2);
        r2 = "\n mOpenEventCount";
        r1 = r1.append(r2);
        r2 = r7.aZk;
        r1 = r1.append(r2);
        r2 = "\nuseWithReason: ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r2 = "\ntrackingName: ";
        r1 = r1.append(r2);
        r1.append(r4);
    L_0x0062:
        monitor-enter(r7);
        r1 = r7.aZi;	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x0071;
    L_0x0067:
        r1 = r7.aZj;	 Catch:{ all -> 0x00a1 }
        r1 = r1 + -1;
        r7.aZj = r1;	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x007a;
    L_0x006f:
        if (r0 != 0) goto L_0x007a;
    L_0x0071:
        r0 = r7.aZi;	 Catch:{ all -> 0x00a1 }
        if (r0 != 0) goto L_0x009a;
    L_0x0075:
        r0 = r7.aZk;	 Catch:{ all -> 0x00a1 }
        r1 = 1;
        if (r0 != r1) goto L_0x009a;
    L_0x007a:
        com.google.android.gms.common.stats.h.pH();	 Catch:{ all -> 0x00a1 }
        r0 = r7.mContext;	 Catch:{ all -> 0x00a1 }
        r1 = r7.aZe;	 Catch:{ all -> 0x00a1 }
        r1 = com.google.android.gms.common.stats.f.a(r1, r4);	 Catch:{ all -> 0x00a1 }
        r2 = 8;
        r3 = r7.aPz;	 Catch:{ all -> 0x00a1 }
        r5 = r7.aZg;	 Catch:{ all -> 0x00a1 }
        r6 = r7.aZf;	 Catch:{ all -> 0x00a1 }
        r6 = com.google.android.gms.c.ac.b(r6);	 Catch:{ all -> 0x00a1 }
        com.google.android.gms.common.stats.h.a(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00a1 }
        r0 = r7.aZk;	 Catch:{ all -> 0x00a1 }
        r0 = r0 + -1;
        r7.aZk = r0;	 Catch:{ all -> 0x00a1 }
    L_0x009a:
        monitor-exit(r7);	 Catch:{ all -> 0x00a1 }
        r0 = r7.aZe;
        r0.release();
        return;
    L_0x00a1:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00a1 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.c.as.release():void");
    }
}
