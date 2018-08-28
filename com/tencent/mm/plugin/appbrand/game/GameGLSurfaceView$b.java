package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.a;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GameGLSurfaceView$b extends a {
    protected int faQ = 8;
    protected int faR = 8;
    protected int faS = 8;
    protected int faT = 8;
    protected int faU = 16;
    protected int faV = 8;
    private int[] faW = new int[1];
    final /* synthetic */ GameGLSurfaceView fzh;

    public GameGLSurfaceView$b(GameGLSurfaceView gameGLSurfaceView) {
        this.fzh = gameGLSurfaceView;
        super(gameGLSurfaceView, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344});
    }

    public final EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int a = a(egl10, eGLDisplay, eGLConfig, 12325);
            int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
            if (a >= this.faU && a2 >= this.faV) {
                a = a(egl10, eGLDisplay, eGLConfig, 12324);
                a2 = a(egl10, eGLDisplay, eGLConfig, 12323);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12322);
                int a4 = a(egl10, eGLDisplay, eGLConfig, 12321);
                if (a == this.faQ && a2 == this.faR && a3 == this.faS && a4 == this.faT) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.faW)) {
            return this.faW[0];
        }
        return 0;
    }
}
