package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.Calendar;

public class nm {
    private boolean a = true;
    private byte[] b = new byte[0];
    private int c = 0;
    private int d = 5000;
    private Context e;
    private ni f;

    public nm(Context context, ni niVar) {
        this.e = context;
        this.f = niVar;
    }

    public void a() {
        synchronized (this.b) {
            this.a = false;
        }
    }

    public void b() {
        synchronized (this.b) {
            this.a = true;
        }
    }

    public void c() {
        g();
    }

    public void d() {
        synchronized (this.b) {
            this.a = false;
        }
    }

    private synchronized void f() {
        synchronized (this.b) {
            if (kh.f != kh$a.TRYING) {
            } else {
                Integer a = new mn(this.e).a();
                if (a != null) {
                    synchronized (this.b) {
                        if (a.intValue() == 0) {
                            kh.f = kh$a.SUCCESS;
                        } else {
                            kh.f = kh$a.FAIL;
                        }
                        kh.g = Calendar.getInstance().get(1);
                        kh.h = Calendar.getInstance().get(2);
                        kh.i = Calendar.getInstance().get(5);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
        r3 = this;
        r1 = r3.b;
        monitor-enter(r1);
        r0 = r3.a;	 Catch:{ all -> 0x0018 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = com.tencent.tencentmap.mapsdk.a.kh.f;	 Catch:{ all -> 0x0018 }
        r2 = com.tencent.tencentmap.mapsdk.a.kh$a.TRYING;	 Catch:{ all -> 0x0018 }
        if (r0 == r2) goto L_0x0013;
    L_0x000f:
        r0 = com.tencent.tencentmap.mapsdk.a.kh$a.TRYING;	 Catch:{ all -> 0x0018 }
        com.tencent.tencentmap.mapsdk.a.kh.f = r0;	 Catch:{ all -> 0x0018 }
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        r3.h();
        goto L_0x0008;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.nm.g():void");
    }

    private void h() {
        synchronized (this.b) {
            if (this.c > 0) {
                return;
            }
            this.c++;
            new 1(this).execute(new String[]{""});
        }
    }

    public void e() {
        if (this.f != null && this.f.a != null) {
            lh lhVar = new lh();
            lhVar.a = 3;
            this.f.a.sendMessage(this.f.a.obtainMessage(lhVar.a, lhVar));
        }
    }
}
