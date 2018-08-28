package com.tencent.mm.plugin.appbrand.game;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GameGLSurfaceView$a implements GameGLSurfaceView$e {
    protected int[] fzg;
    final /* synthetic */ GameGLSurfaceView fzh;

    abstract EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

    public GameGLSurfaceView$a(GameGLSurfaceView gameGLSurfaceView, int[] iArr) {
        this.fzh = gameGLSurfaceView;
        if (GameGLSurfaceView.a(this.fzh) == 2 || GameGLSurfaceView.a(this.fzh) == 3) {
            Object obj = new int[15];
            System.arraycopy(iArr, 0, obj, 0, 12);
            obj[12] = 12352;
            if (GameGLSurfaceView.a(this.fzh) == 2) {
                obj[13] = 4;
            } else {
                obj[13] = 64;
            }
            obj[14] = 12344;
            Object iArr2 = obj;
        }
        this.fzg = iArr2;
    }

    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        if (egl10.eglChooseConfig(eGLDisplay, this.fzg, null, 0, iArr)) {
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (egl10.eglChooseConfig(eGLDisplay, this.fzg, eGLConfigArr, i, iArr)) {
                EGLConfig b = b(egl10, eGLDisplay, eGLConfigArr);
                if (b != null) {
                    return b;
                }
                throw new IllegalArgumentException("No config chosen");
            }
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }
}
