package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class e extends SurfaceView implements Callback {
    private static final j a = new j(null);
    private i b;
    private Renderer c;
    protected boolean d = false;
    protected boolean e = false;
    protected final WeakReference<e> f = new WeakReference(this);
    protected boolean g;
    protected boolean h;
    private boolean i;
    private e j;
    private f k;
    private g l;
    private k m;
    private int n;
    private int o;
    private boolean p;

    private static class d implements g {
        private d() {
        }

        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                TXCLog.e("TXCGLSurfaceViewBase", "eglCreateWindowSurface");
                TXCLog.e("TXCGLSurfaceViewBase", e.toString());
                return eGLSurface;
            }
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    static class i extends Thread {
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

        i(WeakReference<e> weakReference) {
            this.t = weakReference;
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                i();
            } catch (InterruptedException e) {
            } finally {
                e.a.a(this);
            }
        }

        public int a() {
            return this.s.c();
        }

        public h b() {
            return this.s;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void i() {
            /*
            r17 = this;
            r1 = new com.tencent.liteav.renderer.e$h;
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
            r15 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a4 }
            monitor-enter(r15);	 Catch:{ all -> 0x01a4 }
        L_0x0029:
            r0 = r17;
            r1 = r0.a;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x0040;
        L_0x002f:
            monitor-exit(r15);	 Catch:{ all -> 0x01a1 }
            r2 = com.tencent.liteav.renderer.e.a;
            monitor-enter(r2);
            r17.j();	 Catch:{ all -> 0x003d }
            r17.k();	 Catch:{ all -> 0x003d }
            monitor-exit(r2);	 Catch:{ all -> 0x003d }
            return;
        L_0x003d:
            r1 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x003d }
            throw r1;
        L_0x0040:
            r0 = r17;
            r1 = r0.q;	 Catch:{ all -> 0x01a1 }
            r1 = r1.isEmpty();	 Catch:{ all -> 0x01a1 }
            if (r1 != 0) goto L_0x005e;
        L_0x004a:
            r0 = r17;
            r1 = r0.q;	 Catch:{ all -> 0x01a1 }
            r4 = 0;
            r1 = r1.remove(r4);	 Catch:{ all -> 0x01a1 }
            r1 = (java.lang.Runnable) r1;	 Catch:{ all -> 0x01a1 }
            r4 = r1;
        L_0x0056:
            monitor-exit(r15);	 Catch:{ all -> 0x01a1 }
            if (r4 == 0) goto L_0x01c6;
        L_0x0059:
            r4.run();	 Catch:{ all -> 0x01a4 }
            r4 = 0;
            goto L_0x0024;
        L_0x005e:
            r1 = 0;
            r0 = r17;
            r13 = r0.d;	 Catch:{ all -> 0x01a1 }
            r0 = r17;
            r0 = r0.c;	 Catch:{ all -> 0x01a1 }
            r16 = r0;
            r0 = r16;
            if (r13 == r0) goto L_0x0298;
        L_0x006d:
            r0 = r17;
            r1 = r0.c;	 Catch:{ all -> 0x01a1 }
            r0 = r17;
            r13 = r0.c;	 Catch:{ all -> 0x01a1 }
            r0 = r17;
            r0.d = r13;	 Catch:{ all -> 0x01a1 }
            r13 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r13.notifyAll();	 Catch:{ all -> 0x01a1 }
            r13 = r1;
        L_0x0081:
            r0 = r17;
            r1 = r0.k;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x0093;
        L_0x0087:
            r17.j();	 Catch:{ all -> 0x01a1 }
            r17.k();	 Catch:{ all -> 0x01a1 }
            r1 = 0;
            r0 = r17;
            r0.k = r1;	 Catch:{ all -> 0x01a1 }
            r7 = 1;
        L_0x0093:
            if (r10 == 0) goto L_0x009c;
        L_0x0095:
            r17.j();	 Catch:{ all -> 0x01a1 }
            r17.k();	 Catch:{ all -> 0x01a1 }
            r10 = 0;
        L_0x009c:
            if (r13 == 0) goto L_0x00a7;
        L_0x009e:
            r0 = r17;
            r1 = r0.i;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x00a7;
        L_0x00a4:
            r17.j();	 Catch:{ all -> 0x01a1 }
        L_0x00a7:
            if (r13 == 0) goto L_0x00cb;
        L_0x00a9:
            r0 = r17;
            r1 = r0.h;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x00cb;
        L_0x00af:
            r0 = r17;
            r1 = r0.t;	 Catch:{ all -> 0x01a1 }
            r1 = r1.get();	 Catch:{ all -> 0x01a1 }
            r1 = (com.tencent.liteav.renderer.e) r1;	 Catch:{ all -> 0x01a1 }
            if (r1 != 0) goto L_0x017a;
        L_0x00bb:
            r1 = 0;
        L_0x00bc:
            if (r1 == 0) goto L_0x00c8;
        L_0x00be:
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r1 = r1.a();	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x00cb;
        L_0x00c8:
            r17.k();	 Catch:{ all -> 0x01a1 }
        L_0x00cb:
            if (r13 == 0) goto L_0x00de;
        L_0x00cd:
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r1 = r1.b();	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x00de;
        L_0x00d7:
            r0 = r17;
            r1 = r0.s;	 Catch:{ all -> 0x01a1 }
            r1.g();	 Catch:{ all -> 0x01a1 }
        L_0x00de:
            r0 = r17;
            r1 = r0.e;	 Catch:{ all -> 0x01a1 }
            if (r1 != 0) goto L_0x0104;
        L_0x00e4:
            r0 = r17;
            r1 = r0.g;	 Catch:{ all -> 0x01a1 }
            if (r1 != 0) goto L_0x0104;
        L_0x00ea:
            r0 = r17;
            r1 = r0.i;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x00f3;
        L_0x00f0:
            r17.j();	 Catch:{ all -> 0x01a1 }
        L_0x00f3:
            r1 = 1;
            r0 = r17;
            r0.g = r1;	 Catch:{ all -> 0x01a1 }
            r1 = 0;
            r0 = r17;
            r0.f = r1;	 Catch:{ all -> 0x01a1 }
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r1.notifyAll();	 Catch:{ all -> 0x01a1 }
        L_0x0104:
            r0 = r17;
            r1 = r0.e;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x011c;
        L_0x010a:
            r0 = r17;
            r1 = r0.g;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x011c;
        L_0x0110:
            r1 = 0;
            r0 = r17;
            r0.g = r1;	 Catch:{ all -> 0x01a1 }
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r1.notifyAll();	 Catch:{ all -> 0x01a1 }
        L_0x011c:
            if (r2 == 0) goto L_0x012c;
        L_0x011e:
            r8 = 0;
            r2 = 0;
            r1 = 1;
            r0 = r17;
            r0.p = r1;	 Catch:{ all -> 0x01a1 }
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r1.notifyAll();	 Catch:{ all -> 0x01a1 }
        L_0x012c:
            r1 = r17.l();	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x01bd;
        L_0x0132:
            r0 = r17;
            r1 = r0.h;	 Catch:{ all -> 0x01a1 }
            if (r1 != 0) goto L_0x013b;
        L_0x0138:
            if (r7 == 0) goto L_0x0180;
        L_0x013a:
            r7 = 0;
        L_0x013b:
            r0 = r17;
            r1 = r0.h;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x014f;
        L_0x0141:
            r0 = r17;
            r1 = r0.i;	 Catch:{ all -> 0x01a1 }
            if (r1 != 0) goto L_0x014f;
        L_0x0147:
            r1 = 1;
            r0 = r17;
            r0.i = r1;	 Catch:{ all -> 0x01a1 }
            r3 = 1;
            r11 = 1;
            r9 = 1;
        L_0x014f:
            r0 = r17;
            r1 = r0.i;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x01bd;
        L_0x0155:
            r0 = r17;
            r1 = r0.r;	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x0295;
        L_0x015b:
            r9 = 1;
            r0 = r17;
            r6 = r0.l;	 Catch:{ all -> 0x01a1 }
            r0 = r17;
            r1 = r0.m;	 Catch:{ all -> 0x01a1 }
            r8 = 1;
            r3 = 1;
            r5 = 0;
            r0 = r17;
            r0.r = r5;	 Catch:{ all -> 0x01a1 }
        L_0x016b:
            r5 = 0;
            r0 = r17;
            r0.o = r5;	 Catch:{ all -> 0x01a1 }
            r5 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r5.notifyAll();	 Catch:{ all -> 0x01a1 }
            r5 = r1;
            goto L_0x0056;
        L_0x017a:
            r1 = r1.p;	 Catch:{ all -> 0x01a1 }
            goto L_0x00bc;
        L_0x0180:
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r0 = r17;
            r1 = r1.b(r0);	 Catch:{ all -> 0x01a1 }
            if (r1 == 0) goto L_0x013b;
        L_0x018c:
            r0 = r17;
            r1 = r0.s;	 Catch:{ RuntimeException -> 0x01b2 }
            r1.a();	 Catch:{ RuntimeException -> 0x01b2 }
            r1 = 1;
            r0 = r17;
            r0.h = r1;	 Catch:{ all -> 0x01a1 }
            r12 = 1;
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r1.notifyAll();	 Catch:{ all -> 0x01a1 }
            goto L_0x013b;
        L_0x01a1:
            r1 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x01a1 }
            throw r1;	 Catch:{ all -> 0x01a4 }
        L_0x01a4:
            r1 = move-exception;
            r2 = com.tencent.liteav.renderer.e.a;
            monitor-enter(r2);
            r17.j();	 Catch:{ all -> 0x028f }
            r17.k();	 Catch:{ all -> 0x028f }
            monitor-exit(r2);	 Catch:{ all -> 0x028f }
            throw r1;
        L_0x01b2:
            r1 = move-exception;
            r2 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r0 = r17;
            r2.c(r0);	 Catch:{ all -> 0x01a1 }
            throw r1;	 Catch:{ all -> 0x01a1 }
        L_0x01bd:
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a1 }
            r1.wait();	 Catch:{ all -> 0x01a1 }
            goto L_0x0029;
        L_0x01c6:
            if (r3 == 0) goto L_0x01e6;
        L_0x01c8:
            r0 = r17;
            r1 = r0.s;	 Catch:{ all -> 0x01a4 }
            r1 = r1.b();	 Catch:{ all -> 0x01a4 }
            if (r1 == 0) goto L_0x026e;
        L_0x01d2:
            r3 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a4 }
            monitor-enter(r3);	 Catch:{ all -> 0x01a4 }
            r1 = 1;
            r0 = r17;
            r0.j = r1;	 Catch:{ all -> 0x026b }
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x026b }
            r1.notifyAll();	 Catch:{ all -> 0x026b }
            monitor-exit(r3);	 Catch:{ all -> 0x026b }
            r1 = 0;
            r3 = r1;
        L_0x01e6:
            if (r11 == 0) goto L_0x0292;
        L_0x01e8:
            r0 = r17;
            r1 = r0.s;	 Catch:{ all -> 0x01a4 }
            r1 = r1.d();	 Catch:{ all -> 0x01a4 }
            r1 = (javax.microedition.khronos.opengles.GL10) r1;	 Catch:{ all -> 0x01a4 }
            r11 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a4 }
            r11.a(r1);	 Catch:{ all -> 0x01a4 }
            r11 = 0;
            r13 = r1;
        L_0x01fb:
            if (r12 == 0) goto L_0x0217;
        L_0x01fd:
            r0 = r17;
            r1 = r0.t;	 Catch:{ all -> 0x01a4 }
            r1 = r1.get();	 Catch:{ all -> 0x01a4 }
            r1 = (com.tencent.liteav.renderer.e) r1;	 Catch:{ all -> 0x01a4 }
            if (r1 == 0) goto L_0x0216;
        L_0x0209:
            r1 = r1.c;	 Catch:{ all -> 0x01a4 }
            r0 = r17;
            r12 = r0.s;	 Catch:{ all -> 0x01a4 }
            r12 = r12.d;	 Catch:{ all -> 0x01a4 }
            r1.onSurfaceCreated(r13, r12);	 Catch:{ all -> 0x01a4 }
        L_0x0216:
            r12 = 0;
        L_0x0217:
            if (r9 == 0) goto L_0x022d;
        L_0x0219:
            r0 = r17;
            r1 = r0.t;	 Catch:{ all -> 0x01a4 }
            r1 = r1.get();	 Catch:{ all -> 0x01a4 }
            r1 = (com.tencent.liteav.renderer.e) r1;	 Catch:{ all -> 0x01a4 }
            if (r1 == 0) goto L_0x022c;
        L_0x0225:
            r1 = r1.c;	 Catch:{ all -> 0x01a4 }
            r1.onSurfaceChanged(r13, r6, r5);	 Catch:{ all -> 0x01a4 }
        L_0x022c:
            r9 = 0;
        L_0x022d:
            r14 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;
            r0 = r17;
            r1 = r0.t;	 Catch:{ all -> 0x01a4 }
            r1 = r1.get();	 Catch:{ all -> 0x01a4 }
            r1 = (com.tencent.liteav.renderer.e) r1;	 Catch:{ all -> 0x01a4 }
            if (r1 == 0) goto L_0x029d;
        L_0x023b:
            r14 = r1.c;	 Catch:{ all -> 0x01a4 }
            r14.onDrawFrame(r13);	 Catch:{ all -> 0x01a4 }
            r1 = r1.c();	 Catch:{ all -> 0x01a4 }
        L_0x0246:
            switch(r1) {
                case 12288: goto L_0x0264;
                case 12302: goto L_0x028a;
                default: goto L_0x0249;
            };	 Catch:{ all -> 0x01a4 }
        L_0x0249:
            r14 = "GLThread";
            r15 = "eglSwapBuffers";
            com.tencent.liteav.renderer.e.h.a(r14, r15, r1);	 Catch:{ all -> 0x01a4 }
            r14 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a4 }
            monitor-enter(r14);	 Catch:{ all -> 0x01a4 }
            r1 = 1;
            r0 = r17;
            r0.f = r1;	 Catch:{ all -> 0x028c }
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x028c }
            r1.notifyAll();	 Catch:{ all -> 0x028c }
            monitor-exit(r14);	 Catch:{ all -> 0x028c }
        L_0x0264:
            if (r8 == 0) goto L_0x029b;
        L_0x0266:
            r1 = 1;
        L_0x0267:
            r2 = r1;
            r14 = r13;
            goto L_0x0024;
        L_0x026b:
            r1 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x026b }
            throw r1;	 Catch:{ all -> 0x01a4 }
        L_0x026e:
            r13 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x01a4 }
            monitor-enter(r13);	 Catch:{ all -> 0x01a4 }
            r1 = 1;
            r0 = r17;
            r0.j = r1;	 Catch:{ all -> 0x0287 }
            r1 = 1;
            r0 = r17;
            r0.f = r1;	 Catch:{ all -> 0x0287 }
            r1 = com.tencent.liteav.renderer.e.a;	 Catch:{ all -> 0x0287 }
            r1.notifyAll();	 Catch:{ all -> 0x0287 }
            monitor-exit(r13);	 Catch:{ all -> 0x0287 }
            goto L_0x0024;
        L_0x0287:
            r1 = move-exception;
            monitor-exit(r13);	 Catch:{ all -> 0x0287 }
            throw r1;	 Catch:{ all -> 0x01a4 }
        L_0x028a:
            r10 = 1;
            goto L_0x0264;
        L_0x028c:
            r1 = move-exception;
            monitor-exit(r14);	 Catch:{ all -> 0x028c }
            throw r1;	 Catch:{ all -> 0x01a4 }
        L_0x028f:
            r1 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x028f }
            throw r1;
        L_0x0292:
            r13 = r14;
            goto L_0x01fb;
        L_0x0295:
            r1 = r5;
            goto L_0x016b;
        L_0x0298:
            r13 = r1;
            goto L_0x0081;
        L_0x029b:
            r1 = r2;
            goto L_0x0267;
        L_0x029d:
            r1 = r14;
            goto L_0x0246;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.e.i.i():void");
        }

        private void j() {
            if (this.i) {
                this.i = false;
                this.s.f();
            }
        }

        private void k() {
            if (this.h) {
                this.s.g();
                this.h = false;
                e eVar = (e) this.t.get();
                if (eVar != null) {
                    eVar.h = false;
                }
                e.a.c(this);
            }
        }

        public boolean c() {
            return this.h && this.i && l();
        }

        private boolean l() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public void a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (e.a) {
                this.n = i;
                e.a.notifyAll();
            }
        }

        public int d() {
            int i;
            synchronized (e.a) {
                i = this.n;
            }
            return i;
        }

        public void e() {
            synchronized (e.a) {
                this.e = true;
                this.j = false;
                e.a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        e.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (e.a) {
                this.e = false;
                e.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        e.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(int i, int i2) {
            synchronized (e.a) {
                this.l = i;
                this.m = i2;
                this.r = true;
                this.o = true;
                this.p = false;
                e.a.notifyAll();
                while (!this.b && !this.d && !this.p && c()) {
                    try {
                        e.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (e.a) {
                this.a = true;
                e.a.notifyAll();
                while (!this.b) {
                    try {
                        e.a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            this.k = true;
            e.a.notifyAll();
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (e.a) {
                this.q.add(runnable);
                e.a.notifyAll();
            }
        }
    }

    public interface k {
        GL a(GL gl);
    }

    public e(Context context) {
        super(context);
        b();
    }

    protected int c() {
        return 0;
    }

    protected void finalize() {
        try {
            if (this.b != null) {
                this.b.g();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    private void b() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.m = kVar;
    }

    public void setDebugFlags(int i) {
        this.n = i;
    }

    public int getDebugFlags() {
        return this.n;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.p = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.p;
    }

    public void setRenderer(Renderer renderer) {
        f();
        if (this.j == null) {
            this.j = new m(this, true);
        }
        if (this.k == null) {
            this.k = new c(this, null);
        }
        if (this.l == null) {
            this.l = new d();
        }
        this.c = renderer;
        this.b = new i(this.f);
        this.b.start();
    }

    public void setEGLContextFactory(f fVar) {
        f();
        this.k = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        f();
        this.l = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        f();
        this.j = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new m(this, z));
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new b(this, i, i2, i3, i4, i5, i6));
    }

    public void setEGLContextClientVersion(int i) {
        f();
        this.o = i;
    }

    public void setRenderMode(int i) {
        this.b.a(i);
    }

    public int getRenderMode() {
        return this.b.d();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.b.e();
        setRunInBackground(false);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        setRunInBackground(true);
        if (!this.d) {
            this.b.a(new 1(this));
            this.b.f();
        }
    }

    protected void a() {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.b.a(i2, i3);
    }

    public void c(boolean z) {
        this.d = z;
        if (!this.d && this.e && this.b != null) {
            TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
            this.b.a(new Runnable() {
                public void run() {
                    e.this.a();
                }
            });
            this.b.f();
        }
    }

    protected void setRunInBackground(boolean z) {
        this.e = z;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i && this.c != null) {
            int d;
            if (this.b != null) {
                d = this.b.d();
            } else {
                d = 1;
            }
            this.b = new i(this.f);
            if (d != 1) {
                this.b.a(d);
            }
            this.b.start();
        }
        this.i = false;
    }

    protected void onDetachedFromWindow() {
        if (this.b != null) {
            this.b.g();
        }
        this.i = true;
        super.onDetachedFromWindow();
    }

    private void f() {
        if (this.b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public int d() {
        return this.b.a();
    }

    public h getEGLHelper() {
        return this.b.b();
    }
}
