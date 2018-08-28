package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class dk implements dh {
    private boolean a = false;
    private List<di> b;
    private Context c;
    private Runnable d = new Runnable() {
        public final void run() {
            try {
                dk.this.a();
            } catch (Throwable th) {
                ct.a(th);
            }
        }
    };
    private Runnable e = new 2(this);

    static class a extends dn {
        private List<di> e = null;
        private Context f;
        private Long[] g = null;
        private boolean h = false;

        public a(Context context, List<di> list) {
            super(context, 1, 2);
            this.e = list;
            this.f = context;
            this.e.size();
            if (this.e.size() == 1 && "rqd_heartbeat".equals(((di) this.e.get(0)).d())) {
                this.h = true;
            }
            this.d = e.b(context, 2);
            ct.a("real rid:%s", new Object[]{this.d});
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized com.tencent.tencentmap.mapsdk.a.cn a() {
            /*
            r3 = this;
            r1 = 0;
            monitor-enter(r3);
            r0 = " TUUD.GetUD start";
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0034 }
            com.tencent.tencentmap.mapsdk.a.ct.b(r0, r2);	 Catch:{ all -> 0x0034 }
            r0 = r3.e;	 Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0017;
        L_0x000f:
            r0 = r3.e;	 Catch:{ all -> 0x0034 }
            r0 = r0.size();	 Catch:{ all -> 0x0034 }
            if (r0 > 0) goto L_0x001a;
        L_0x0017:
            r0 = r1;
        L_0x0018:
            monitor-exit(r3);
            return r0;
        L_0x001a:
            r0 = r3.a;	 Catch:{ Throwable -> 0x0026 }
            r2 = r3.e;	 Catch:{ Throwable -> 0x0026 }
            r0 = a(r0, r2);	 Catch:{ Throwable -> 0x0026 }
            if (r0 != 0) goto L_0x0018;
        L_0x0024:
            r0 = r1;
            goto L_0x0018;
        L_0x0026:
            r0 = move-exception;
            com.tencent.tencentmap.mapsdk.a.ct.a(r0);	 Catch:{ all -> 0x0034 }
            r0 = " TUUD.GetUD start error";
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0034 }
            com.tencent.tencentmap.mapsdk.a.ct.d(r0, r2);	 Catch:{ all -> 0x0034 }
            goto L_0x0024;
        L_0x0034:
            r0 = move-exception;
            monitor-exit(r3);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.dk.a.a():com.tencent.tencentmap.mapsdk.a.cn");
        }

        private static cn a(int i, List<di> list) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            try {
                ct.b(" current size:" + list.size(), new Object[0]);
                cq a = a(list);
                if (a == null) {
                    return null;
                }
                byte[] a2 = a.a();
                if (a2 != null) {
                    return a(i, a2);
                }
                return null;
            } catch (Throwable th) {
                ct.a(th);
                ct.d(" RealTimeRecordUploadDatas.encode2EventRecordPackage error}", new Object[0]);
                return null;
            }
        }

        private static cq a(List<di> list) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            try {
                cq cqVar = new cq();
                ArrayList arrayList = new ArrayList();
                for (di a : list) {
                    cp a2 = e.a(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                cqVar.a = arrayList;
                ct.b(" RealTimeRecordUploadDatas.encode2EventRecordPackage() end}", new Object[0]);
                return cqVar;
            } catch (Throwable th) {
                ct.a(th);
                return null;
            }
        }

        public final synchronized void b(boolean z) {
            ct.b(" TimeUpUploadDatas.done(), result:%b", new Object[]{Boolean.valueOf(z)});
            if (!(this.e == null || z)) {
                ct.f(" upload failed, save to db", new Object[0]);
                if (!this.h) {
                    this.g = e.a(this.f, this.e);
                    this.e = null;
                }
            }
            if (z && this.h) {
                Context context = this.f;
                b.a().a(108);
                a.a(context, "HEART_DENGTA", e.g());
                ct.a("heartbeat uploaded sucess!", new Object[0]);
            }
            if (z && this.g != null) {
                e.a(this.f, this.g);
            }
            if (z && this.g == null && this.e != null) {
                this.e = null;
            }
        }
    }

    public dk(Context context) {
        this.c = context;
        this.b = Collections.synchronizedList(new ArrayList(25));
    }

    public final synchronized boolean a(di diVar) {
        boolean z = false;
        synchronized (this) {
            String str = " BF eN:%s   isRT:%b";
            Object[] objArr = new Object[2];
            objArr[0] = diVar == null ? "null" : diVar.d();
            objArr[1] = Boolean.valueOf(true);
            ct.f(str, objArr);
            if (this.c == null || diVar == null) {
                ct.c("processUA return false, context is null or bean is null !", new Object[0]);
            } else if (c()) {
                df g = dl.d().g();
                int a = g.a();
                long b = (long) (g.b() * TbsLog.TBSLOG_CODE_SDK_BASE);
                if (this.b.size() >= a || diVar.f()) {
                    ct.f(" BF mN!", new Object[0]);
                    b.a().a(this.d);
                    b.a().a(103, this.d, b, b);
                }
                this.b.add(diVar);
                if (this.b.size() >= a) {
                    ct.c(" err BF 3R! num:" + this.b.size(), new Object[0]);
                }
                if ("rqd_applaunched".equals(diVar.d())) {
                    b.a().a(this.d);
                }
                ct.a("processUA:true!", new Object[0]);
                z = true;
            } else {
                ct.c("processUA return false, isEnable is false !", new Object[0]);
            }
        }
        return z;
    }

    private synchronized List<di> b() {
        List<di> list;
        if (this.b == null || this.b.size() <= 0 || !c()) {
            list = null;
        } else {
            list = new ArrayList();
            list.addAll(this.b);
            this.b.clear();
            ct.b(" get realEventCnt in Mem:" + list.size(), new Object[0]);
        }
        return list;
    }

    private synchronized boolean c() {
        return this.a;
    }

    public final synchronized void a(boolean z) {
        if (this.a != z) {
            if (z) {
                this.a = z;
                b.a().a(103, this.d, 5000, (long) (dl.d().g().b() * TbsLog.TBSLOG_CODE_SDK_BASE));
            } else {
                b.a().a(103);
                b(true);
                this.a = z;
            }
        }
    }

    public final synchronized void b(boolean z) {
        ct.e("realtime process flush memory objects to db.", new Object[0]);
        if (z) {
            d();
        } else {
            b.a().a(this.e);
        }
    }

    private void d() {
        List b = b();
        if (b != null && b.size() > 0) {
            ct.f(" dsb real events 2 db" + b.size(), new Object[0]);
            e.a(this.c, b);
        }
    }

    protected final void a() {
        if (c()) {
            List b = b();
            if (b != null && b.size() > 0) {
                ds f = dl.d().f();
                if (!e.m(this.c) || f == null) {
                    ct.f(" dsu real events 2 db" + b.size(), new Object[0]);
                    e.a(this.c, b);
                    return;
                }
                ct.f(" dsu real events 2 up " + b.size(), new Object[0]);
                f.a(new a(this.c, b));
                return;
            }
            return;
        }
        ct.c(" err su 1R", new Object[0]);
    }
}
