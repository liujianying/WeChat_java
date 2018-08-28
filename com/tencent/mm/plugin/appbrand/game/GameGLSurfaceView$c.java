package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.f;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i;
import com.tencent.mm.sdk.platformtools.x;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class GameGLSurfaceView$c implements f {
    private int EGL_CONTEXT_CLIENT_VERSION;
    final /* synthetic */ GameGLSurfaceView fzh;

    private GameGLSurfaceView$c(GameGLSurfaceView gameGLSurfaceView) {
        this.fzh = gameGLSurfaceView;
        this.EGL_CONTEXT_CLIENT_VERSION = 12440;
    }

    /* synthetic */ GameGLSurfaceView$c(GameGLSurfaceView gameGLSurfaceView, byte b) {
        this(gameGLSurfaceView);
    }

    public final EGLContext b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
        x.i("MicroMsg.GLThread", "createContext");
        int[] iArr = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GameGLSurfaceView.a(this.fzh), 12344};
        if (GameGLSurfaceView.a(this.fzh) == 0) {
            iArr = null;
        }
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
    }

    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        x.i("MicroMsg.GLThread", " destroyContext tid=" + Thread.currentThread().getId());
        if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            x.e("MicroMsg.GLThread", "display:" + eGLDisplay + " context: " + eGLContext);
            i.az("eglDestroyContex", egl10.eglGetError());
        }
    }
}
