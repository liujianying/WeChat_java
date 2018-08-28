package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i;
import com.tencent.mm.sdk.platformtools.x;

class GameGLSurfaceView$k {
    private static String TAG = "GLThreadManager";

    private GameGLSurfaceView$k() {
    }

    /* synthetic */ GameGLSurfaceView$k(byte b) {
        this();
    }

    public final synchronized void g(GameGLSurfaceView$j gameGLSurfaceView$j) {
        x.i("MicroMsg.GLThread", "exiting tid=" + gameGLSurfaceView$j.getId());
        GameGLSurfaceView gameGLSurfaceView = (GameGLSurfaceView) gameGLSurfaceView$j.fzn.get();
        if (gameGLSurfaceView != null) {
            GameGLSurfaceView.g(gameGLSurfaceView).afT();
        } else {
            x.i("MicroMsg.GLThread", "onFinalize:view = null");
        }
        i b = gameGLSurfaceView$j.fzH;
        x.w("MicroMsg.GLThread", "destroySurface()  tid=" + Thread.currentThread().getId());
        b.afJ();
        gameGLSurfaceView$j.afK();
        gameGLSurfaceView$j.afL();
        i b2 = gameGLSurfaceView$j.fzH;
        x.w("MicroMsg.GLThread", "finish() tid=" + Thread.currentThread().getId());
        if (b2.fbd != null) {
            gameGLSurfaceView = (GameGLSurfaceView) b2.fzn.get();
            if (gameGLSurfaceView != null) {
                GameGLSurfaceView.c(gameGLSurfaceView).destroyContext(b2.fbb, b2.fbc, b2.fbd);
            }
            b2.fbd = null;
        }
        if (b2.fbc != null) {
            b2.fbb.eglTerminate(b2.fbc);
            b2.fbc = null;
        }
        gameGLSurfaceView$j.fzq = true;
        notifyAll();
    }
}
