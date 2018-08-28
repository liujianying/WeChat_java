package com.tencent.map.lib.gl;

import com.tencent.map.lib.gl.e.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class e$i extends Thread {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l = 0;
    private int m = 0;
    private int n = 1;
    private boolean o = true;
    private boolean p;
    private ArrayList<Runnable> q = new ArrayList();
    private boolean r = true;
    private h s;
    private WeakReference<e> t;

    e$i(WeakReference<e> weakReference) {
        this.t = weakReference;
    }

    public void run() {
        setName("GLThread " + getId());
        try {
            l();
        } catch (InterruptedException e) {
        } finally {
            e.g().a(this);
        }
    }

    private void j() {
        if (this.i) {
            this.i = false;
            this.s.e();
        }
    }

    private void k() {
        if (this.h) {
            this.s.f();
            this.h = false;
            e.g().c(this);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l() {
        /*
        r17 = this;
        r1 = new com.tencent.map.lib.gl.e$h;
        r0 = r17;
        r2 = r0.t;
        r1.<init>(r2);
        r0 = r17;
        r0.s = r1;
        r1 = 0;
        r0 = r17;
        r0.h = r1;
        r1 = 0;
        r0 = r17;
        r0.i = r1;
        r1 = 0;
        r12 = 0;
        r3 = 0;
        r11 = 0;
        r10 = 0;
        r9 = 0;
        r8 = 0;
        r2 = 0;
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r14 = r1;
    L_0x0024:
        r15 = com.tencent.map.lib.gl.e.g();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        monitor-enter(r15);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x0029:
        r0 = r17;
        r1 = r0.a;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x0053;
    L_0x002f:
        r0 = r17;
        r1 = r0.t;	 Catch:{ all -> 0x01b4 }
        r1 = r1.get();	 Catch:{ all -> 0x01b4 }
        r1 = (com.tencent.map.lib.gl.e) r1;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x0042;
    L_0x003b:
        r1 = com.tencent.map.lib.gl.e.g(r1);	 Catch:{ all -> 0x01b4 }
        r1.a_();	 Catch:{ all -> 0x01b4 }
    L_0x0042:
        monitor-exit(r15);	 Catch:{ all -> 0x01b4 }
        r2 = com.tencent.map.lib.gl.e.g();
        monitor-enter(r2);
        r17.j();	 Catch:{ all -> 0x0050 }
        r17.k();	 Catch:{ all -> 0x0050 }
        monitor-exit(r2);	 Catch:{ all -> 0x0050 }
    L_0x004f:
        return;
    L_0x0050:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0050 }
        throw r1;
    L_0x0053:
        r0 = r17;
        r1 = r0.q;	 Catch:{ all -> 0x01b4 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x01b4 }
        if (r1 != 0) goto L_0x0071;
    L_0x005d:
        r0 = r17;
        r1 = r0.q;	 Catch:{ all -> 0x01b4 }
        r4 = 0;
        r1 = r1.remove(r4);	 Catch:{ all -> 0x01b4 }
        r1 = (java.lang.Runnable) r1;	 Catch:{ all -> 0x01b4 }
        r4 = r1;
    L_0x0069:
        monitor-exit(r15);	 Catch:{ all -> 0x01b4 }
        if (r4 == 0) goto L_0x01dd;
    L_0x006c:
        r4.run();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r4 = 0;
        goto L_0x0024;
    L_0x0071:
        r1 = 0;
        r0 = r17;
        r13 = r0.d;	 Catch:{ all -> 0x01b4 }
        r0 = r17;
        r0 = r0.c;	 Catch:{ all -> 0x01b4 }
        r16 = r0;
        r0 = r16;
        if (r13 == r0) goto L_0x02c3;
    L_0x0080:
        r0 = r17;
        r1 = r0.c;	 Catch:{ all -> 0x01b4 }
        r0 = r17;
        r13 = r0.c;	 Catch:{ all -> 0x01b4 }
        r0 = r17;
        r0.d = r13;	 Catch:{ all -> 0x01b4 }
        r13 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r13.notifyAll();	 Catch:{ all -> 0x01b4 }
        r13 = r1;
    L_0x0094:
        r0 = r17;
        r1 = r0.k;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x00a6;
    L_0x009a:
        r17.j();	 Catch:{ all -> 0x01b4 }
        r17.k();	 Catch:{ all -> 0x01b4 }
        r1 = 0;
        r0 = r17;
        r0.k = r1;	 Catch:{ all -> 0x01b4 }
        r7 = 1;
    L_0x00a6:
        if (r10 == 0) goto L_0x00af;
    L_0x00a8:
        r17.j();	 Catch:{ all -> 0x01b4 }
        r17.k();	 Catch:{ all -> 0x01b4 }
        r10 = 0;
    L_0x00af:
        if (r13 == 0) goto L_0x00ba;
    L_0x00b1:
        r0 = r17;
        r1 = r0.i;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x00ba;
    L_0x00b7:
        r17.j();	 Catch:{ all -> 0x01b4 }
    L_0x00ba:
        if (r13 == 0) goto L_0x00de;
    L_0x00bc:
        r0 = r17;
        r1 = r0.h;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x00de;
    L_0x00c2:
        r0 = r17;
        r1 = r0.t;	 Catch:{ all -> 0x01b4 }
        r1 = r1.get();	 Catch:{ all -> 0x01b4 }
        r1 = (com.tencent.map.lib.gl.e) r1;	 Catch:{ all -> 0x01b4 }
        if (r1 != 0) goto L_0x018d;
    L_0x00ce:
        r1 = 0;
    L_0x00cf:
        if (r1 == 0) goto L_0x00db;
    L_0x00d1:
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r1 = r1.a();	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x00de;
    L_0x00db:
        r17.k();	 Catch:{ all -> 0x01b4 }
    L_0x00de:
        if (r13 == 0) goto L_0x00f1;
    L_0x00e0:
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r1 = r1.b();	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x00f1;
    L_0x00ea:
        r0 = r17;
        r1 = r0.s;	 Catch:{ all -> 0x01b4 }
        r1.f();	 Catch:{ all -> 0x01b4 }
    L_0x00f1:
        r0 = r17;
        r1 = r0.e;	 Catch:{ all -> 0x01b4 }
        if (r1 != 0) goto L_0x0117;
    L_0x00f7:
        r0 = r17;
        r1 = r0.g;	 Catch:{ all -> 0x01b4 }
        if (r1 != 0) goto L_0x0117;
    L_0x00fd:
        r0 = r17;
        r1 = r0.i;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x0106;
    L_0x0103:
        r17.j();	 Catch:{ all -> 0x01b4 }
    L_0x0106:
        r1 = 1;
        r0 = r17;
        r0.g = r1;	 Catch:{ all -> 0x01b4 }
        r1 = 0;
        r0 = r17;
        r0.f = r1;	 Catch:{ all -> 0x01b4 }
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r1.notifyAll();	 Catch:{ all -> 0x01b4 }
    L_0x0117:
        r0 = r17;
        r1 = r0.e;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x012f;
    L_0x011d:
        r0 = r17;
        r1 = r0.g;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x012f;
    L_0x0123:
        r1 = 0;
        r0 = r17;
        r0.g = r1;	 Catch:{ all -> 0x01b4 }
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r1.notifyAll();	 Catch:{ all -> 0x01b4 }
    L_0x012f:
        if (r2 == 0) goto L_0x013f;
    L_0x0131:
        r8 = 0;
        r2 = 0;
        r1 = 1;
        r0 = r17;
        r0.p = r1;	 Catch:{ all -> 0x01b4 }
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r1.notifyAll();	 Catch:{ all -> 0x01b4 }
    L_0x013f:
        r1 = r17.m();	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x01d4;
    L_0x0145:
        r0 = r17;
        r1 = r0.h;	 Catch:{ all -> 0x01b4 }
        if (r1 != 0) goto L_0x014e;
    L_0x014b:
        if (r7 == 0) goto L_0x0193;
    L_0x014d:
        r7 = 0;
    L_0x014e:
        r0 = r17;
        r1 = r0.h;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x0162;
    L_0x0154:
        r0 = r17;
        r1 = r0.i;	 Catch:{ all -> 0x01b4 }
        if (r1 != 0) goto L_0x0162;
    L_0x015a:
        r1 = 1;
        r0 = r17;
        r0.i = r1;	 Catch:{ all -> 0x01b4 }
        r3 = 1;
        r11 = 1;
        r9 = 1;
    L_0x0162:
        r0 = r17;
        r1 = r0.i;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x01d4;
    L_0x0168:
        r0 = r17;
        r1 = r0.r;	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x02c0;
    L_0x016e:
        r9 = 1;
        r0 = r17;
        r6 = r0.l;	 Catch:{ all -> 0x01b4 }
        r0 = r17;
        r1 = r0.m;	 Catch:{ all -> 0x01b4 }
        r8 = 1;
        r3 = 1;
        r5 = 0;
        r0 = r17;
        r0.r = r5;	 Catch:{ all -> 0x01b4 }
    L_0x017e:
        r5 = 0;
        r0 = r17;
        r0.o = r5;	 Catch:{ all -> 0x01b4 }
        r5 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r5.notifyAll();	 Catch:{ all -> 0x01b4 }
        r5 = r1;
        goto L_0x0069;
    L_0x018d:
        r1 = com.tencent.map.lib.gl.e.h(r1);	 Catch:{ all -> 0x01b4 }
        goto L_0x00cf;
    L_0x0193:
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r0 = r17;
        r1 = r1.b(r0);	 Catch:{ all -> 0x01b4 }
        if (r1 == 0) goto L_0x014e;
    L_0x019f:
        r0 = r17;
        r1 = r0.s;	 Catch:{ RuntimeException -> 0x01c9 }
        r1.a();	 Catch:{ RuntimeException -> 0x01c9 }
    L_0x01a6:
        r1 = 1;
        r0 = r17;
        r0.h = r1;	 Catch:{ all -> 0x01b4 }
        r12 = 1;
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r1.notifyAll();	 Catch:{ all -> 0x01b4 }
        goto L_0x014e;
    L_0x01b4:
        r1 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x01b4 }
        throw r1;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x01b7:
        r1 = move-exception;
        r2 = com.tencent.map.lib.gl.e.g();
        monitor-enter(r2);
        r17.j();	 Catch:{ all -> 0x01c6 }
        r17.k();	 Catch:{ all -> 0x01c6 }
        monitor-exit(r2);	 Catch:{ all -> 0x01c6 }
        goto L_0x004f;
    L_0x01c6:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x01c6 }
        throw r1;
    L_0x01c9:
        r1 = move-exception;
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r0 = r17;
        r1.c(r0);	 Catch:{ all -> 0x01b4 }
        goto L_0x01a6;
    L_0x01d4:
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x01b4 }
        r1.wait();	 Catch:{ all -> 0x01b4 }
        goto L_0x0029;
    L_0x01dd:
        if (r3 == 0) goto L_0x01fd;
    L_0x01df:
        r0 = r17;
        r1 = r0.s;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = r1.b();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        if (r1 == 0) goto L_0x0299;
    L_0x01e9:
        r3 = com.tencent.map.lib.gl.e.g();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        monitor-enter(r3);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = 1;
        r0 = r17;
        r0.j = r1;	 Catch:{ all -> 0x0288 }
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x0288 }
        r1.notifyAll();	 Catch:{ all -> 0x0288 }
        monitor-exit(r3);	 Catch:{ all -> 0x0288 }
        r1 = 0;
        r3 = r1;
    L_0x01fd:
        if (r11 == 0) goto L_0x02bd;
    L_0x01ff:
        r0 = r17;
        r1 = r0.s;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = r1.c();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = (javax.microedition.khronos.opengles.GL10) r1;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r11 = com.tencent.map.lib.gl.e.g();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r11.a(r1);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r11 = 0;
        r13 = r1;
    L_0x0212:
        if (r12 == 0) goto L_0x022e;
    L_0x0214:
        r0 = r17;
        r1 = r0.t;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = r1.get();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = (com.tencent.map.lib.gl.e) r1;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        if (r1 == 0) goto L_0x022d;
    L_0x0220:
        r1 = com.tencent.map.lib.gl.e.g(r1);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r0 = r17;
        r12 = r0.s;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r12 = r12.d;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1.a(r13, r12);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x022d:
        r12 = 0;
    L_0x022e:
        if (r9 == 0) goto L_0x0244;
    L_0x0230:
        r0 = r17;
        r1 = r0.t;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = r1.get();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = (com.tencent.map.lib.gl.e) r1;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        if (r1 == 0) goto L_0x0243;
    L_0x023c:
        r1 = com.tencent.map.lib.gl.e.g(r1);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1.a(r13, r6, r5);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x0243:
        r9 = 0;
    L_0x0244:
        r14 = 0;
        r0 = r17;
        r1 = r0.t;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = r1.get();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = (com.tencent.map.lib.gl.e) r1;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        if (r1 == 0) goto L_0x02c8;
    L_0x0251:
        r1 = com.tencent.map.lib.gl.e.g(r1);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = r1.a(r13);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x0259:
        if (r1 == 0) goto L_0x0281;
    L_0x025b:
        r0 = r17;
        r1 = r0.s;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = r1.d();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        switch(r1) {
            case 12288: goto L_0x0281;
            case 12302: goto L_0x02b5;
            default: goto L_0x0266;
        };	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x0266:
        r14 = "GLThread";
        r15 = "eglSwapBuffers";
        com.tencent.map.lib.gl.e.h.a(r14, r15, r1);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r14 = com.tencent.map.lib.gl.e.g();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        monitor-enter(r14);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = 1;
        r0 = r17;
        r0.f = r1;	 Catch:{ all -> 0x02b7 }
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x02b7 }
        r1.notifyAll();	 Catch:{ all -> 0x02b7 }
        monitor-exit(r14);	 Catch:{ all -> 0x02b7 }
    L_0x0281:
        if (r8 == 0) goto L_0x02c6;
    L_0x0283:
        r1 = 1;
    L_0x0284:
        r2 = r1;
        r14 = r13;
        goto L_0x0024;
    L_0x0288:
        r1 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0288 }
        throw r1;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x028b:
        r1 = move-exception;
        r2 = com.tencent.map.lib.gl.e.g();
        monitor-enter(r2);
        r17.j();	 Catch:{ all -> 0x02ba }
        r17.k();	 Catch:{ all -> 0x02ba }
        monitor-exit(r2);	 Catch:{ all -> 0x02ba }
        throw r1;
    L_0x0299:
        r13 = com.tencent.map.lib.gl.e.g();	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        monitor-enter(r13);	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
        r1 = 1;
        r0 = r17;
        r0.j = r1;	 Catch:{ all -> 0x02b2 }
        r1 = 1;
        r0 = r17;
        r0.f = r1;	 Catch:{ all -> 0x02b2 }
        r1 = com.tencent.map.lib.gl.e.g();	 Catch:{ all -> 0x02b2 }
        r1.notifyAll();	 Catch:{ all -> 0x02b2 }
        monitor-exit(r13);	 Catch:{ all -> 0x02b2 }
        goto L_0x0024;
    L_0x02b2:
        r1 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x02b2 }
        throw r1;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x02b5:
        r10 = 1;
        goto L_0x0281;
    L_0x02b7:
        r1 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x02b7 }
        throw r1;	 Catch:{ Exception -> 0x01b7, all -> 0x028b }
    L_0x02ba:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x02ba }
        throw r1;
    L_0x02bd:
        r13 = r14;
        goto L_0x0212;
    L_0x02c0:
        r1 = r5;
        goto L_0x017e;
    L_0x02c3:
        r13 = r1;
        goto L_0x0094;
    L_0x02c6:
        r1 = r2;
        goto L_0x0284;
    L_0x02c8:
        r1 = r14;
        goto L_0x0259;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.lib.gl.e$i.l():void");
    }

    public boolean a() {
        return this.h && this.i && m();
    }

    private boolean m() {
        return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
    }

    public void a(int i) {
        if (i < 0 || i > 1) {
            throw new IllegalArgumentException("renderMode");
        }
        synchronized (e.g()) {
            this.n = i;
            e.g().notifyAll();
        }
    }

    public int b() {
        int i;
        synchronized (e.g()) {
            i = this.n;
        }
        return i;
    }

    public void c() {
        synchronized (e.g()) {
            this.o = true;
            e.g().notifyAll();
        }
    }

    public void d() {
        synchronized (e.g()) {
            this.e = true;
            this.j = false;
            e.g().notifyAll();
            while (this.g && !this.j && !this.b) {
                try {
                    e.g().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void e() {
        synchronized (e.g()) {
            this.e = false;
            e.g().notifyAll();
            while (!this.g && !this.b) {
                try {
                    e.g().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void f() {
        synchronized (e.g()) {
            this.c = true;
            e.g().notifyAll();
            while (!this.b && !this.d) {
                try {
                    e.g().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void g() {
        synchronized (e.g()) {
            this.c = false;
            this.o = true;
            this.p = false;
            e.g().notifyAll();
            while (!this.b && this.d && !this.p) {
                try {
                    e.g().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void a(int i, int i2) {
        synchronized (e.g()) {
            this.l = i;
            this.m = i2;
            this.r = true;
            this.o = true;
            this.p = false;
            e.g().notifyAll();
            while (!this.b && !this.d && !this.p && a()) {
                try {
                    e.g().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void h() {
        synchronized (e.g()) {
            this.a = true;
            e.g().notifyAll();
            while (!this.b) {
                try {
                    e.g().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void i() {
        this.k = true;
        e.g().notifyAll();
    }
}
