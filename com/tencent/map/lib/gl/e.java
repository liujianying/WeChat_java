package com.tencent.map.lib.gl;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class e extends SurfaceView implements Callback {
    private static final j a = new j(null);
    private final WeakReference<e> b = new WeakReference(this);
    private i c;
    private m d;
    private boolean e;
    private e f;
    private f g;
    private g h;
    private k i;
    private int j;
    private int k;
    private boolean l;

    private class c implements f {
        private int b;

        private c() {
            this.b = 12440;
        }

        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = new int[]{this.b, e.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (e.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                new StringBuilder("display:").append(eGLDisplay).append(" context: ").append(eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    private static class d implements g {
        private d() {
        }

        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                return eGLSurface;
            } catch (OutOfMemoryError e2) {
                return eGLSurface;
            }
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public e(Context context) {
        super(context);
        a();
    }

    protected void finalize() {
        try {
            if (this.c != null) {
                this.c.h();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    private void a() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.i = kVar;
    }

    public void setDebugFlags(int i) {
        this.j = i;
    }

    public int getDebugFlags() {
        return this.j;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.l = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.l;
    }

    public void setRenderer(m mVar) {
        d();
        if (this.f == null) {
            this.f = new n(this, true);
        }
        if (this.g == null) {
            this.g = new c();
        }
        if (this.h == null) {
            this.h = new d();
        }
        this.d = mVar;
        this.c = new i(this.b);
        this.c.start();
    }

    public void setEGLContextFactory(f fVar) {
        d();
        this.g = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        d();
        this.h = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        d();
        this.f = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new n(this, z));
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new b(this, i, i2, i3, i4, i5, i6));
    }

    public void setEGLContextClientVersion(int i) {
        d();
        this.k = i;
    }

    public void setRenderMode(int i) {
        this.c.a(i);
    }

    public int getRenderMode() {
        return this.c.b();
    }

    public void f() {
        this.c.c();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.c.d();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.c.e();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.c.a(i2, i3);
    }

    public void c() {
        this.c.f();
    }

    public void b() {
        this.c.g();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            int b;
            if (this.c != null) {
                b = this.c.b();
            } else {
                b = 1;
            }
            this.c = new i(this.b);
            if (b != 1) {
                this.c.a(b);
            }
            this.c.start();
        }
        this.e = false;
    }

    protected void onDetachedFromWindow() {
        if (this.c != null) {
            this.c.h();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    private void d() {
        if (this.c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }
}
