package com.tencent.liteav.beauty;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.a.a.a;
import com.tencent.liteav.beauty.a.a.c;
import com.tencent.liteav.beauty.c.b;

class b$a extends Handler {
    final /* synthetic */ b a;
    private String b = "EGLDrawThreadHandler";

    b$a(b bVar, Looper looper, Context context) {
        this.a = bVar;
        super(looper);
    }

    private void a(Object obj) {
        TXCLog.i(this.b, "come into InitEGL");
        b bVar = (b) obj;
        a();
        b.a(this.a, new a());
        b.a(this.a, new c(b.i(this.a), bVar.g, bVar.f, false));
        b.j(this.a).b();
        if (b.a(this.a, bVar)) {
            TXCLog.i(this.b, "come out InitEGL");
        } else {
            TXCLog.e(this.b, "initInternal failed!");
        }
    }

    public void a() {
        TXCLog.i(this.b, "come into releaseEGL");
        if (b.k(this.a) != null && b.k(this.a)[0] > 0) {
            GLES20.glDeleteBuffers(1, b.k(this.a), 0);
            b.a(this.a, null);
        }
        b.l(this.a);
        if (b.j(this.a) != null) {
            b.j(this.a).c();
            b.a(this.a, null);
        }
        if (b.i(this.a) != null) {
            b.i(this.a).a();
            b.a(this.a, null);
        }
        b.a(this.a, false);
        NativeLoad.getInstance();
        NativeLoad.nativeDeleteYuv2Yuv();
        TXCLog.i(this.b, "come out releaseEGL");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r10) {
        /*
        r9 = this;
        r7 = 1;
        super.handleMessage(r10);
        r8 = 0;
        r0 = r10.what;
        switch(r0) {
            case 0: goto L_0x0013;
            case 1: goto L_0x001f;
            case 2: goto L_0x002b;
            case 3: goto L_0x0038;
            case 4: goto L_0x0041;
            case 5: goto L_0x0066;
            case 6: goto L_0x000a;
            case 7: goto L_0x0071;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = r8;
    L_0x000b:
        monitor-enter(r9);
        if (r7 != r0) goto L_0x0011;
    L_0x000e:
        r9.notify();	 Catch:{ all -> 0x009d }
    L_0x0011:
        monitor-exit(r9);	 Catch:{ all -> 0x009d }
        return;
    L_0x0013:
        r0 = r10.obj;
        r9.a(r0);
        r0 = r9.a;
        com.tencent.liteav.beauty.b.a(r0, r7);
        r0 = r7;
        goto L_0x000b;
    L_0x001f:
        r9.a();
        r0 = r9.a;
        r0 = r0.d;
        r0.a();
        r0 = r8;
        goto L_0x000b;
    L_0x002b:
        r1 = r9.a;
        r0 = r10.obj;
        r0 = (byte[]) r0;
        r0 = (byte[]) r0;
        com.tencent.liteav.beauty.b.a(r1, r0);
        r0 = r8;
        goto L_0x000b;
    L_0x0038:
        r0 = r9.a;
        r1 = r10.arg1;
        com.tencent.liteav.beauty.b.b(r0, r1);
        r0 = r7;
        goto L_0x000b;
    L_0x0041:
        r0 = r9.a;
        r1 = r10.arg1;
        r2 = (double) r1;
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 / r4;
        r1 = (float) r2;
        com.tencent.liteav.beauty.b.a(r0, r1);
        r0 = r9.a;
        r0 = com.tencent.liteav.beauty.b.a(r0);
        if (r0 == 0) goto L_0x000a;
    L_0x0055:
        r0 = r9.a;
        r0 = com.tencent.liteav.beauty.b.a(r0);
        r1 = r9.a;
        r1 = com.tencent.liteav.beauty.b.m(r1);
        r0.a(r1);
        r0 = r8;
        goto L_0x000b;
    L_0x0066:
        r0 = r10.obj;
        r0 = (com.tencent.liteav.beauty.c.b) r0;
        r1 = r9.a;
        com.tencent.liteav.beauty.b.b(r1, r0);
        r0 = r8;
        goto L_0x000b;
    L_0x0071:
        r0 = r9.a;
        r1 = r9.a;
        r1 = com.tencent.liteav.beauty.b.c(r1);
        r2 = r9.a;
        r2 = com.tencent.liteav.beauty.b.d(r2);
        r3 = r9.a;
        r3 = com.tencent.liteav.beauty.b.n(r3);
        r4 = r10.arg1;
        r5 = r10.arg2;
        r6 = r10.obj;
        r6 = (java.lang.Integer) r6;
        r6 = r6.intValue();
        com.tencent.liteav.beauty.b.a(r0, r1, r2, r3, r4, r5, r6);
        r0 = r9.a;
        r0 = r0.f;
        r0.a();
        goto L_0x000a;
    L_0x009d:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x009d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.beauty.b$a.handleMessage(android.os.Message):void");
    }

    void b() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
