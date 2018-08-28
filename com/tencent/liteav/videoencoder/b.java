package com.tencent.liteav.videoencoder;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.k;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

public class b extends a {
    private static Integer r = Integer.valueOf(1);
    private static final String u = b.class.getSimpleName();
    private static int v = 0;
    private c a = null;
    private d b = null;
    private WeakReference<com.tencent.liteav.basic.c.a> c = null;
    private int d = 0;
    private int e = 2;
    private int f = 1;
    private Timer g = null;
    private TimerTask h = null;
    private LinkedList<Runnable> i = new LinkedList();
    private TXSVideoEncoderParam j;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private int n = 0;
    private int o = 0;
    private com.tencent.liteav.basic.d.b p;
    private com.tencent.liteav.basic.util.b q;
    private boolean s;
    private k t;

    static /* synthetic */ int j(b bVar) {
        int i = bVar.n + 1;
        bVar.n = i;
        return i;
    }

    public b(int i) {
        this.e = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.tencent.liteav.videoencoder.TXSVideoEncoderParam r10) {
        /*
        r9 = this;
        r8 = 3;
        r7 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        r1 = 2;
        r6 = 0;
        r5 = 1;
        r9.j = r10;
        r2 = 10000002; // 0x989682 float:1.4012987E-38 double:4.9406574E-317;
        r0 = r10.enableBlackList;
        if (r0 == 0) goto L_0x0064;
    L_0x000f:
        r0 = com.tencent.liteav.basic.e.b.a();
        r0 = r0.c();
    L_0x0017:
        r3 = r9.e;
        if (r3 != r5) goto L_0x0066;
    L_0x001b:
        if (r0 == 0) goto L_0x0066;
    L_0x001d:
        r0 = new com.tencent.liteav.videoencoder.a;
        r0.<init>();
        r9.a = r0;
        r9.f = r5;
        r0 = "启动硬编";
        r9.a(r7, r0, r5);
    L_0x002c:
        r0 = 4004; // 0xfa4 float:5.611E-42 double:1.978E-320;
        r1 = r9.f;
        r4 = (long) r1;
        r1 = java.lang.Long.valueOf(r4);
        r9.setStatusValue(r0, r1);
        r0 = r9.a;
        if (r0 == 0) goto L_0x0098;
    L_0x003c:
        r0 = r9.b;
        if (r0 == 0) goto L_0x0047;
    L_0x0040:
        r0 = r9.a;
        r1 = r9.b;
        r0.setListener(r1);
    L_0x0047:
        r0 = r9.d;
        if (r0 == 0) goto L_0x0052;
    L_0x004b:
        r0 = r9.a;
        r1 = r9.d;
        r0.setBitrate(r1);
    L_0x0052:
        r0 = r9.a;
        r1 = r9.getID();
        r0.setID(r1);
        r0 = r9.a;
        r0 = r0.start(r10);
        if (r0 == 0) goto L_0x0099;
    L_0x0063:
        return r0;
    L_0x0064:
        r0 = r1;
        goto L_0x0017;
    L_0x0066:
        r3 = r9.e;
        if (r3 != r8) goto L_0x0088;
    L_0x006a:
        r3 = r10.width;
        r4 = 720; // 0x2d0 float:1.009E-42 double:3.557E-321;
        if (r3 != r4) goto L_0x0088;
    L_0x0070:
        r3 = r10.height;
        r4 = 1280; // 0x500 float:1.794E-42 double:6.324E-321;
        if (r3 != r4) goto L_0x0088;
    L_0x0076:
        if (r0 == 0) goto L_0x0088;
    L_0x0078:
        r0 = new com.tencent.liteav.videoencoder.a;
        r0.<init>();
        r9.a = r0;
        r9.f = r5;
        r0 = "启动硬编";
        r9.a(r7, r0, r5);
        goto L_0x002c;
    L_0x0088:
        r0 = new com.tencent.liteav.videoencoder.TXCSWVideoEncoder;
        r0.<init>();
        r9.a = r0;
        r9.f = r1;
        r0 = "启动软编";
        r9.a(r7, r0, r1);
        goto L_0x002c;
    L_0x0098:
        r0 = r2;
    L_0x0099:
        r1 = r9.e;
        if (r1 != r8) goto L_0x0063;
    L_0x009d:
        r9.k = r6;
        r9.l = r6;
        r9.m = r6;
        r1 = 0;
        r9.n = r1;
        r1 = com.tencent.liteav.basic.e.b.a();
        r1 = r1.f();
        r9.o = r1;
        r9.c();
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.b.a(com.tencent.liteav.videoencoder.TXSVideoEncoderParam):int");
    }

    public void setID(String str) {
        super.setID(str);
        if (this.a != null) {
            this.a.setID(str);
        }
        setStatusValue(4004, Long.valueOf((long) this.f));
    }

    public EGLContext a(int i, int i2) {
        if (!this.s) {
            this.s = true;
            synchronized (r) {
                StringBuilder stringBuilder = new StringBuilder("CVGLThread");
                Integer num = r;
                r = Integer.valueOf(r.intValue() + 1);
                this.q = new com.tencent.liteav.basic.util.b(stringBuilder.append(num).toString());
            }
            boolean[] zArr = new boolean[1];
            this.q.a(new 1(this, i, i2, zArr));
            if (zArr[0]) {
                return this.p.c();
            }
            return null;
        } else if (this.p != null) {
            return this.p.c();
        } else {
            return null;
        }
    }

    public void a(Runnable runnable) {
        if (this.q != null) {
            this.q.a(runnable);
        }
    }

    protected void b(Runnable runnable) {
        synchronized (this.i) {
            this.i.add(runnable);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r3) {
        /*
        r2 = this;
        r1 = 0;
        monitor-enter(r3);
        r0 = r3.isEmpty();	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        monitor-exit(r3);	 Catch:{ all -> 0x0016 }
        r0 = r1;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r3.poll();	 Catch:{ all -> 0x0016 }
        r0 = (java.lang.Runnable) r0;	 Catch:{ all -> 0x0016 }
        monitor-exit(r3);	 Catch:{ all -> 0x0016 }
        if (r0 != 0) goto L_0x0019;
    L_0x0014:
        r0 = r1;
        goto L_0x000a;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0016 }
        throw r0;
    L_0x0019:
        r0.run();
        r0 = 1;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.b.a(java.util.Queue):boolean");
    }

    public long a(byte[] bArr, int i, int i2, int i3, long j) {
        if (this.p == null) {
            return -1;
        }
        this.q.b(new 2(this, i2, i3, i, bArr, j));
        return 0;
    }

    public void a() {
        this.i.clear();
        if (this.a != null) {
            this.a.stop();
        }
        if (this.q != null) {
            this.q.b(new 3(this, this.t, this.p));
            this.q = null;
            this.t = null;
            this.p = null;
        }
        if (this.e == 3) {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0;
            d();
        }
        this.b = null;
        this.d = 0;
    }

    public long a(int i, int i2, int i3, long j) {
        do {
        } while (a(this.i));
        if (this.a != null) {
            return this.a.pushVideoFrame(i, i2, i3, j);
        }
        return 10000002;
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.c = new WeakReference(aVar);
    }

    public void a(d dVar) {
        this.b = dVar;
        b(new 4(this));
    }

    public void a(int i) {
        this.d = i;
        b(new 5(this));
    }

    public long b() {
        if (this.a != null) {
            return this.a.getRealFPS();
        }
        return 0;
    }

    private void c() {
        if (this.h == null) {
            this.h = new a(this);
        }
        this.g = new Timer();
        this.g.schedule(this.h, 1000, 1000);
    }

    private void d() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    private void a(int i, String str) {
        if (this.c != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) this.c.get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence("EVT_MSG", str);
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    private void a(int i, String str, int i2) {
        if (this.c != null) {
            com.tencent.liteav.basic.c.a aVar = (com.tencent.liteav.basic.c.a) this.c.get();
            if (aVar != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_ID", i);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence("EVT_MSG", str);
                bundle.putInt("EVT_PARAM1", i2);
                aVar.onNotifyEvent(i, bundle);
            }
        }
    }

    private void e() {
        b(new 6(this));
        TXCLog.w("TXCVideoEncoder", "switchSWToHW");
    }
}
