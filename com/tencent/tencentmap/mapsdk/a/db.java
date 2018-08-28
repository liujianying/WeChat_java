package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.List;

public final class db implements dh {
    private Context a;
    private boolean b = false;
    private Object c = new Object();
    private Object d = new Object();
    private Object e = new Object();
    private List<di> f;
    private long g = 60000;
    private Runnable h = new 1(this);
    private Runnable i = new 2(this);
    private Runnable j = new 3();

    public db(Context context) {
        this.a = context;
        this.f = new ArrayList(25);
    }

    private synchronized List<di> b() {
        List<di> list;
        if (this.f == null || this.f.size() <= 0 || !d()) {
            list = null;
        } else {
            list = new ArrayList();
            list.addAll(this.f);
            this.f.clear();
            ct.b(" get MN:" + list.size(), new Object[0]);
        }
        return list;
    }

    public final boolean a(di diVar) {
        synchronized (this.c) {
            String str = " BF eN:%s   isRT:%b ";
            Object[] objArr = new Object[2];
            objArr[0] = diVar == null ? "null" : diVar.d();
            objArr[1] = Boolean.valueOf(false);
            ct.f(str, objArr);
            if (this.a == null || diVar == null || !this.b) {
                ct.d(" err BF 1R", new Object[0]);
                return false;
            } else if (d()) {
                df g = dl.d().g();
                int c = g.c();
                this.g = (long) (g.d() * TbsLog.TBSLOG_CODE_SDK_BASE);
                int size = this.f.size();
                if (size >= c) {
                    ct.f(" BF mN!", new Object[0]);
                    b.a().a(this.h);
                    b.a().a(102, this.h, this.g, this.g);
                }
                this.f.add(diVar);
                if (this.f.size() >= c) {
                    ct.c(" err BF 3R! list size:" + size, new Object[0]);
                }
                ct.a("CommonprocessUA:true!", new Object[0]);
                return true;
            } else {
                ct.d(" CommonProcess processUA return false, isEnable is false !", new Object[0]);
                return false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void a() {
        /*
        r8 = this;
        r0 = 0;
        r1 = r8.d;
        monitor-enter(r1);
        r2 = r8.d();	 Catch:{ all -> 0x009e }
        if (r2 != 0) goto L_0x0015;
    L_0x000a:
        r0 = " err su 1R";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x009e }
        com.tencent.tencentmap.mapsdk.a.ct.c(r0, r2);	 Catch:{ all -> 0x009e }
        monitor-exit(r1);	 Catch:{ all -> 0x009e }
    L_0x0014:
        return;
    L_0x0015:
        r2 = r8.b();	 Catch:{ all -> 0x009e }
        if (r2 == 0) goto L_0x00a1;
    L_0x001b:
        r3 = r2.size();	 Catch:{ all -> 0x009e }
        if (r3 <= 0) goto L_0x00a1;
    L_0x0021:
        r3 = r8.a;	 Catch:{ all -> 0x009e }
        r2 = com.tencent.tencentmap.mapsdk.a.e.a(r3, r2);	 Catch:{ all -> 0x009e }
        r3 = r8.a;	 Catch:{ all -> 0x009e }
        r4 = com.tencent.tencentmap.mapsdk.a.dt.a(r3);	 Catch:{ all -> 0x009e }
        if (r2 == 0) goto L_0x009b;
    L_0x002f:
        r2 = com.tencent.tencentmap.mapsdk.a.dl.d();	 Catch:{ all -> 0x009e }
        r2 = r2.g();	 Catch:{ all -> 0x009e }
        r2 = r2.e();	 Catch:{ all -> 0x009e }
        r2 = (long) r2;	 Catch:{ all -> 0x009e }
        r5 = r8.a;	 Catch:{ all -> 0x009e }
        r5 = com.tencent.tencentmap.mapsdk.a.e.l(r5);	 Catch:{ all -> 0x009e }
        if (r5 == 0) goto L_0x005d;
    L_0x0044:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009e }
        r6 = " onwifi, so half mSZ ";
        r5.<init>(r6);	 Catch:{ all -> 0x009e }
        r5 = r5.append(r2);	 Catch:{ all -> 0x009e }
        r5 = r5.toString();	 Catch:{ all -> 0x009e }
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x009e }
        com.tencent.tencentmap.mapsdk.a.ct.e(r5, r6);	 Catch:{ all -> 0x009e }
        r6 = 2;
        r2 = r2 / r6;
    L_0x005d:
        r5 = r8.a;	 Catch:{ all -> 0x009e }
        r5 = com.tencent.tencentmap.mapsdk.a.e.j(r5);	 Catch:{ all -> 0x009e }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009e }
        r7 = "countCommomRecordNum: ";
        r6.<init>(r7);	 Catch:{ all -> 0x009e }
        r6 = r6.append(r5);	 Catch:{ all -> 0x009e }
        r6 = r6.toString();	 Catch:{ all -> 0x009e }
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x009e }
        com.tencent.tencentmap.mapsdk.a.ct.b(r6, r7);	 Catch:{ all -> 0x009e }
        r6 = (long) r5;	 Catch:{ all -> 0x009e }
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x007f;
    L_0x007e:
        r0 = 1;
    L_0x007f:
        if (r0 == 0) goto L_0x009b;
    L_0x0081:
        r0 = r4.a();	 Catch:{ all -> 0x009e }
        if (r0 == 0) goto L_0x009b;
    L_0x0087:
        r0 = r4.b();	 Catch:{ all -> 0x009e }
        if (r0 == 0) goto L_0x009b;
    L_0x008d:
        r0 = r8.j;	 Catch:{ all -> 0x009e }
        r0.run();	 Catch:{ all -> 0x009e }
        r0 = " common max up";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x009e }
        com.tencent.tencentmap.mapsdk.a.ct.e(r0, r2);	 Catch:{ all -> 0x009e }
    L_0x009b:
        monitor-exit(r1);	 Catch:{ all -> 0x009e }
        goto L_0x0014;
    L_0x009e:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x00a1:
        r2 = com.tencent.tencentmap.mapsdk.a.dl.d();	 Catch:{ all -> 0x009e }
        r2 = r2.g();	 Catch:{ all -> 0x009e }
        if (r2 == 0) goto L_0x00af;
    L_0x00ab:
        r0 = r2.g();	 Catch:{ all -> 0x009e }
    L_0x00af:
        if (r0 == 0) goto L_0x009b;
    L_0x00b1:
        r0 = r8.j;	 Catch:{ all -> 0x009e }
        r0.run();	 Catch:{ all -> 0x009e }
        r0 = " common polling up";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x009e }
        com.tencent.tencentmap.mapsdk.a.ct.e(r0, r2);	 Catch:{ all -> 0x009e }
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.db.a():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
        r3 = this;
        r1 = r3.e;
        monitor-enter(r1);
        r0 = r3.d();	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x0014;
    L_0x0009:
        r0 = " err su 1R";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0027 }
        com.tencent.tencentmap.mapsdk.a.ct.c(r0, r2);	 Catch:{ all -> 0x0027 }
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
    L_0x0013:
        return;
    L_0x0014:
        r0 = r3.b();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x0025;
    L_0x001a:
        r2 = r0.size();	 Catch:{ all -> 0x0027 }
        if (r2 <= 0) goto L_0x0025;
    L_0x0020:
        r2 = r3.a;	 Catch:{ all -> 0x0027 }
        com.tencent.tencentmap.mapsdk.a.e.a(r2, r0);	 Catch:{ all -> 0x0027 }
    L_0x0025:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        goto L_0x0013;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.db.c():void");
    }

    private synchronized boolean d() {
        return this.b;
    }

    public final synchronized void a(boolean z) {
        if (this.b != z) {
            if (z) {
                this.b = z;
                this.g = (long) (dl.d().g().d() * TbsLog.TBSLOG_CODE_SDK_BASE);
                b.a().a(102, this.h, this.g, this.g);
            } else {
                b.a().a(102);
                b.a().a(TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW);
                b(true);
                this.b = z;
            }
        }
    }

    public final synchronized void b(boolean z) {
        ct.e("common process flush memory objects to db.", new Object[0]);
        if (z) {
            c();
        } else {
            b.a().a(this.i);
        }
    }
}
