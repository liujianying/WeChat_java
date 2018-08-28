package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.h;
import com.tencent.mm.sdk.platformtools.x;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class GameGLSurfaceView$d implements h {
    private GameGLSurfaceView$d() {
    }

    /* synthetic */ GameGLSurfaceView$d(byte b) {
        this();
    }

    public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        EGLSurface eGLSurface = null;
        try {
            return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.GameGLSurfaceView", "eglCreateWindowSurface", new Object[]{e});
            return eGLSurface;
        }
    }

    public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }
}
