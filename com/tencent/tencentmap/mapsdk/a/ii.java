package com.tencent.tencentmap.mapsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.map.lib.a;
import com.tencent.map.lib.gl.JNICallback.f;
import com.tencent.map.lib.gl.e;
import com.tencent.map.lib.gl.e.m;
import com.tencent.map.lib.util.b;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class ii extends e implements f, m, hp {
    private com.tencent.map.lib.f a;
    private hv b;
    private hy c;
    private ik d = null;
    private boolean e;
    private float f = 0.5f;
    private Handler g = new Handler();
    private int h = 0;
    private Surface i;

    public ii(Context context, Surface surface) {
        super(context);
        a(surface);
    }

    private void a(Surface surface) {
        if (surface != null) {
            this.i = surface;
        }
        e();
        setRenderer(this);
        setRenderMode(0);
        this.c = new hy(getContext());
        this.b = new hv(getContext(), this);
        this.a = new com.tencent.map.lib.f(this.b);
        this.c.a(this.b);
        this.e = gg.a(this, true);
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.b.b(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
    }

    private void e() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        a(8, 8, 8, 8, 16, 0);
        setEGLContextFactory(new 1(this));
        if (this.i != null) {
            setEGLWindowSurfaceFactory(new 2(this));
        }
    }

    public void setAdapter(a aVar) {
        if (this.b.a(getContext().getApplicationContext(), aVar)) {
            this.b.a().k();
        }
    }

    public void a(a aVar, jg jgVar) {
        if (this.b.a(getContext().getApplicationContext(), aVar, jgVar)) {
            this.b.a().k();
        }
    }

    public a getAdapter() {
        return this.b.E();
    }

    public com.tencent.map.lib.f getMap() {
        return this.a;
    }

    public void b() {
        if (this.e) {
            super.b();
        }
        if (this.d != null) {
            this.d.b();
        }
        this.b.m();
    }

    public void c() {
        if (this.e) {
            super.c();
        }
        if (this.d != null) {
            this.d.a();
        }
        this.b.n();
    }

    public void d() {
        b.a();
    }

    public void setNeedDisplay(boolean z) {
        this.b.a(z);
    }

    protected com.tencent.map.lib.gl.b getTextureCache() {
        return this.b.k();
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        this.b.a(gl10);
        this.b.a(this);
    }

    public void a(GL10 gl10, int i, int i2) {
        this.b.a(i, i2);
    }

    public void a_() {
    }

    public boolean a(GL10 gl10) {
        return this.b.b(gl10);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c != null) {
            return this.c.onTouch(this, motionEvent);
        }
        return false;
    }

    public void a() {
        if (getVisibility() == 0) {
            f();
        }
    }

    public void a(hz hzVar) {
        this.c.a(hzVar);
    }

    public void b(hz hzVar) {
        this.c.b(hzVar);
    }

    public int getGLContext() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        if (egl10 != null) {
            EGLContext eglGetCurrentContext = egl10.eglGetCurrentContext();
            if (eglGetCurrentContext != null) {
                return eglGetCurrentContext.hashCode();
            }
        }
        return 0;
    }

    private void h() {
        if (this.b != null) {
            getGLContext();
            this.b.o();
            this.b.a(null);
        }
    }

    private void a(byte[] bArr) {
        if (this.d != null) {
            this.d.b();
            this.d.a(bArr);
        }
    }
}
