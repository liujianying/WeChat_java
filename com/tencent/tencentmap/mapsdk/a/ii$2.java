package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.gl.e.g;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class ii$2 implements g {
    final /* synthetic */ ii a;

    ii$2(ii iiVar) {
        this.a = iiVar;
    }

    public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        EGLSurface eGLSurface = null;
        try {
            return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, ii.d(this.a), null);
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
