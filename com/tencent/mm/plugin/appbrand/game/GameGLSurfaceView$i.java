package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class GameGLSurfaceView$i {
    EGL10 fbb;
    EGLDisplay fbc;
    EGLContext fbd;
    EGLSurface fbe;
    WeakReference<GameGLSurfaceView> fzn;
    EGLConfig fzo;

    public GameGLSurfaceView$i(WeakReference<GameGLSurfaceView> weakReference) {
        this.fzn = weakReference;
    }

    final void afJ() {
        if (this.fbe != null && this.fbe != EGL10.EGL_NO_SURFACE) {
            this.fbb.eglMakeCurrent(this.fbc, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            GameGLSurfaceView gameGLSurfaceView = (GameGLSurfaceView) this.fzn.get();
            if (gameGLSurfaceView != null) {
                GameGLSurfaceView.d(gameGLSurfaceView).destroySurface(this.fbb, this.fbc, this.fbe);
            }
            this.fbe = null;
        }
    }

    public static void az(String str, int i) {
        String aA = aA(str, i);
        x.e("MicroMsg.GLThread", "throwEglException tid=" + Thread.currentThread().getId() + " " + aA);
        throw new RuntimeException(aA);
    }

    public static void n(String str, String str2, int i) {
        x.w(str, aA(str2, i));
    }

    private static String aA(String str, int i) {
        return str + " failed: " + GameGLSurfaceView$g.kk(i);
    }
}
