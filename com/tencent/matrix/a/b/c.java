package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.WorkSource;
import com.tencent.matrix.a.b.e.b;
import com.tencent.matrix.c.c.a;

public final class c implements com.tencent.matrix.a.b.b.c, b, a {
    public final com.tencent.matrix.a.a.a boV;
    public final d bpJ = new d();
    private final com.tencent.matrix.a.a bpK;
    public boolean bpL;
    public f bpM;
    public a bpN;
    final Context mContext;

    public c(com.tencent.matrix.a.a aVar) {
        this.boV = aVar.boV;
        this.bpK = aVar;
        this.mContext = aVar.application;
    }

    public final void a(IBinder iBinder, int i, String str, String str2, WorkSource workSource, String str3) {
        if (this.bpM != null) {
            final String throwableStack = com.tencent.matrix.a.c.a.getThrowableStack(new Throwable());
            final long currentTimeMillis = System.currentTimeMillis();
            final IBinder iBinder2 = iBinder;
            final int i2 = i;
            final String str4 = str;
            final String str5 = str2;
            final WorkSource workSource2 = workSource;
            final String str6 = str3;
            this.bpJ.f(new Runnable() {
                public final void run() {
                    d dVar;
                    f fVar = c.this.bpM;
                    IBinder iBinder = iBinder2;
                    int i = i2;
                    String str = str4;
                    String str2 = throwableStack;
                    long j = currentTimeMillis;
                    com.tencent.matrix.d.b.i("Matrix.WakeLockDetector", "onAcquireWakeLock token:%s tag:%s", iBinder, str);
                    if (fVar.bql != null) {
                        e eVar = fVar.bql;
                        eVar.bqy.append(com.tencent.matrix.d.c.h("yyyy-MM-dd HH:mm", j)).append(" onAcquireWakeLock token:").append(iBinder.toString()).append(" flags:").append(i).append(" tag:").append(str).append(10).append(str2).append(10);
                        eVar.bqx++;
                        eVar.tq();
                    }
                    String obj = iBinder.toString();
                    if (fVar.bqg.containsKey(obj)) {
                        dVar = (d) fVar.bqg.get(obj);
                    } else {
                        dVar = new d(obj, str, i, j);
                        fVar.bqg.put(obj, dVar);
                    }
                    dVar.bqs.bY(str2);
                    if (!fVar.bqh.containsKey(str)) {
                        fVar.bqh.put(str, new c(str));
                    }
                    c cVar = (c) fVar.bqh.get(str);
                    boolean isScreenOn = fVar.bqj.isScreenOn();
                    cVar.bqq++;
                    if (!isScreenOn) {
                        cVar.bqr++;
                    }
                    cVar.bqt.put(obj, Boolean.valueOf(true));
                    if (cVar.bqu < 0) {
                        cVar.bqu = System.currentTimeMillis();
                    }
                    cVar.bqs.bY(str2);
                    fVar.bqj.b(fVar.bqk, (long) fVar.bqi);
                }
            });
        }
    }

    public final void a(IBinder iBinder, int i) {
        if (this.bpM != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final IBinder iBinder2 = iBinder;
            final int i2 = i;
            this.bpJ.f(new Runnable() {
                public final void run() {
                    int i = 1;
                    f fVar = c.this.bpM;
                    IBinder iBinder = iBinder2;
                    int i2 = i2;
                    long j = currentTimeMillis;
                    com.tencent.matrix.d.b.i("Matrix.WakeLockDetector", "onReleaseWakeLock token:%s", iBinder);
                    if (fVar.bql != null) {
                        e eVar = fVar.bql;
                        eVar.bqy.append(com.tencent.matrix.d.c.h("yyyy-MM-dd HH:mm", j)).append(" onReleaseWakeLock token:").append(iBinder.toString()).append(" flags:").append(i2).append("\n\n");
                        eVar.bqx++;
                        eVar.tq();
                    }
                    String obj = iBinder.toString();
                    if (fVar.bqg.containsKey(obj)) {
                        String str = ((d) fVar.bqg.get(obj)).tag;
                        if (fVar.bqh.containsKey(str)) {
                            c cVar = (c) fVar.bqh.get(str);
                            cVar.tp();
                            cVar.bqt.remove(obj);
                            if (cVar.bqt.isEmpty()) {
                                i = 0;
                            }
                            if (i == 0) {
                                cVar.bqu = -1;
                            }
                        }
                    } else {
                        com.tencent.matrix.d.b.i("Matrix.WakeLockDetector", "onReleaseWakeLock not in mWakeLockInfoMap: %s", obj);
                    }
                    fVar.tn();
                    fVar.bqg.remove(obj);
                }
            });
        }
    }

    public final void a(com.tencent.matrix.c.b bVar) {
        this.bpK.a(bVar);
    }

    public final void a(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener) {
        com.tencent.matrix.d.b.d("Matrix.BatteryCanaryCore", "onAlarmSet: type:%d, triggerAtMillis:%d, windowMillis:%d, intervalMillis:%d, flags:%d, operationInfo:%s, onAlarmListener:%s", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), pendingIntent, onAlarmListener);
        if (this.bpN != null) {
            final String throwableStack = com.tencent.matrix.a.c.a.getThrowableStack(new Throwable());
            final int i3 = i;
            final long j4 = j;
            final long j5 = j2;
            final long j6 = j3;
            final int i4 = i2;
            final PendingIntent pendingIntent2 = pendingIntent;
            final OnAlarmListener onAlarmListener2 = onAlarmListener;
            this.bpJ.f(new Runnable() {
                public final void run() {
                    a aVar = c.this.bpN;
                    int i = i3;
                    long j = j4;
                    long j2 = j5;
                    long j3 = j6;
                    int i2 = i4;
                    PendingIntent pendingIntent = pendingIntent2;
                    OnAlarmListener onAlarmListener = onAlarmListener2;
                    String str = throwableStack;
                    if (aVar.bpk != null) {
                        b bVar = aVar.bpk;
                        String str2 = "%s onAlarmSet type:%d triggerAtMillis:%d windowMillis:%d intervalMillis:%d flags:%d operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n";
                        Object[] objArr = new Object[11];
                        objArr[0] = com.tencent.matrix.d.c.h("yyyy-MM-dd HH:mm", System.currentTimeMillis());
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Long.valueOf(j);
                        objArr[3] = Long.valueOf(j2);
                        objArr[4] = Long.valueOf(j3);
                        objArr[5] = Integer.valueOf(i2);
                        objArr[6] = pendingIntent;
                        objArr[7] = Integer.valueOf(pendingIntent == null ? -1 : pendingIntent.hashCode());
                        objArr[8] = onAlarmListener;
                        objArr[9] = Integer.valueOf(onAlarmListener == null ? -1 : onAlarmListener.hashCode());
                        objArr[10] = str;
                        bVar.bX(String.format(str2, objArr));
                    }
                    a aVar2 = new a(i, j, j3, pendingIntent, onAlarmListener, str);
                    aVar.a(aVar2.bpq, aVar2.bpp);
                    aVar.bpl.add(aVar2);
                    aVar.ti();
                }
            });
        }
    }

    public final void a(final PendingIntent pendingIntent, final OnAlarmListener onAlarmListener) {
        com.tencent.matrix.d.b.d("Matrix.BatteryCanaryCore", "onAlarmRemove: operationInfo:%s, onAlarmListener:%s", pendingIntent, onAlarmListener);
        final String throwableStack = com.tencent.matrix.a.c.a.getThrowableStack(new Throwable());
        this.bpJ.f(new Runnable() {
            public final void run() {
                int i = -1;
                a aVar = c.this.bpN;
                PendingIntent pendingIntent = pendingIntent;
                OnAlarmListener onAlarmListener = onAlarmListener;
                String str = throwableStack;
                if (aVar.bpk != null) {
                    b bVar = aVar.bpk;
                    String str2 = "%s onAlarmRemove operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n";
                    Object[] objArr = new Object[6];
                    objArr[0] = com.tencent.matrix.d.c.h("yyyy-MM-dd HH:mm", System.currentTimeMillis());
                    objArr[1] = pendingIntent;
                    objArr[2] = Integer.valueOf(pendingIntent == null ? -1 : pendingIntent.hashCode());
                    objArr[3] = onAlarmListener;
                    if (onAlarmListener != null) {
                        i = onAlarmListener.hashCode();
                    }
                    objArr[4] = Integer.valueOf(i);
                    objArr[5] = str;
                    bVar.bX(String.format(str2, objArr));
                }
                aVar.a(onAlarmListener, new e(pendingIntent));
                aVar.ti();
            }
        });
    }
}
