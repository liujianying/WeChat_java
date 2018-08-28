package com.tencent.tencentmap.mapsdk.a;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class ik extends Thread {
    private EGLContext a;
    private EGL10 b;
    private EGLConfig c;
    private EGLDisplay d;
    private hv e;
    private boolean f = false;
    private boolean g = false;
    private boolean h;
    private byte[] i = null;

    public ik(EGL10 egl10, EGLContext eGLContext, EGLDisplay eGLDisplay, EGLConfig eGLConfig, hv hvVar, boolean z) {
        this.b = egl10;
        this.d = eGLDisplay;
        this.c = eGLConfig;
        this.e = hvVar;
        this.h = z;
        if (z) {
            this.a = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{12440, 2, 12344});
        }
    }

    public void run() {
        if (this.h) {
            EGLSurface eglCreatePbufferSurface = this.b.eglCreatePbufferSurface(this.d, this.c, new int[]{12375, 1, 12374, 1, 12417, 12380, 12416, 12380, 12344});
            this.b.eglMakeCurrent(this.d, eglCreatePbufferSurface, eglCreatePbufferSurface, this.a);
        }
        while (!this.f) {
            if (this.g) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                }
            } else if (!d()) {
                try {
                    sleep(160);
                } catch (InterruptedException e2) {
                }
            }
        }
        c();
        if (this.i != null) {
            synchronized (this.i) {
                this.i.notify();
            }
        }
    }

    public void a(byte[] bArr) {
        this.i = bArr;
        this.f = true;
        interrupt();
    }

    public void a() {
        this.g = true;
    }

    public void b() {
        this.g = false;
        synchronized (this) {
            notify();
        }
    }

    public void c() {
        if (this.h) {
            this.b.eglDestroyContext(this.d, this.a);
        }
    }

    private boolean d() {
        if (this.e != null) {
            return this.e.j();
        }
        return false;
    }
}
