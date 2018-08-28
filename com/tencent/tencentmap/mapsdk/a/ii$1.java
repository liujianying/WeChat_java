package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.gl.e.f;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class ii$1 implements f {
    final /* synthetic */ ii a;

    ii$1(ii iiVar) {
        this.a = iiVar;
    }

    public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        Object obj = new byte[1];
        ii.a(this.a, obj);
        synchronized (obj) {
            try {
                obj.wait(1000);
            } catch (InterruptedException e) {
            }
        }
        ii.a(this.a);
        egl10.eglMakeCurrent(eGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
    }

    public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr = new int[]{12375, 1, 12374, 1, 12417, 12380, 12416, 12380, 12344};
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        if (ii.b(this.a) == null) {
            ii.a(this.a, new ik(egl10, eglCreateContext, eGLDisplay, eGLConfig, ii.c(this.a), hw.a()));
            ii.b(this.a).start();
        }
        return eglCreateContext;
    }
}
