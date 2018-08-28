package com.tencent.liteav.basic.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

@TargetApi(17)
public class c {
    private static int a = 2;
    private static final String b = c.class.getSimpleName();
    private static int[] k;
    private static int[] l;
    private EGLDisplay c = EGL14.EGL_NO_DISPLAY;
    private EGLContext d = EGL14.EGL_NO_CONTEXT;
    private EGLConfig e = null;
    private int f = 0;
    private int g = 0;
    private boolean h;
    private EGLSurface i;
    private int j = -1;

    public static c a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i, int i2) {
        c cVar = new c();
        cVar.f = i;
        cVar.g = i2;
        return cVar.a(eGLConfig, eGLContext, surface) ? cVar : null;
    }

    public void a() {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public void b() {
        if (this.c != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.c, this.i);
            EGL14.eglDestroyContext(this.c, this.d);
            this.d = EGL14.EGL_NO_CONTEXT;
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.c);
        }
        this.c = EGL14.EGL_NO_DISPLAY;
    }

    public boolean c() {
        return EGL14.eglSwapBuffers(this.c, this.i);
    }

    private boolean a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        this.c = EGL14.eglGetDisplay(0);
        if (this.c == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.c, iArr, 0, iArr, 1)) {
            if (eGLConfig != null) {
                this.e = eGLConfig;
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!EGL14.eglChooseConfig(this.c, surface == null ? l : k, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    return false;
                }
                this.e = eGLConfigArr[0];
            }
            if (eGLContext != null) {
                this.h = true;
            } else {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            this.d = EGL14.eglCreateContext(this.c, this.e, eGLContext, new int[]{12440, a, 12344}, 0);
            iArr = new int[]{12344};
            if (this.d == EGL14.EGL_NO_CONTEXT) {
                a();
                return false;
            }
            if (surface == null) {
                this.i = EGL14.eglCreatePbufferSurface(this.c, this.e, new int[]{12375, this.f, 12374, this.g, 12344}, 0);
            } else {
                this.i = EGL14.eglCreateWindowSurface(this.c, this.e, surface, iArr, 0);
            }
            a();
            if (EGL14.eglMakeCurrent(this.c, this.i, this.i, this.d)) {
                return true;
            }
            a();
            return false;
        }
        this.c = null;
        throw new RuntimeException("unable to initialize EGL14");
    }

    public void a(long j) {
        EGLExt.eglPresentationTimeANDROID(this.c, this.i, j);
    }

    static {
        int i;
        int i2 = 4;
        int[] iArr = new int[17];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12325;
        iArr[9] = 0;
        iArr[10] = 12326;
        iArr[11] = 0;
        iArr[12] = 12352;
        if (a == 2) {
            i = 4;
        } else {
            i = 68;
        }
        iArr[13] = i;
        iArr[14] = 12610;
        iArr[15] = 1;
        iArr[16] = 12344;
        k = iArr;
        int[] iArr2 = new int[19];
        iArr2[0] = 12339;
        iArr2[1] = 1;
        iArr2[2] = 12324;
        iArr2[3] = 8;
        iArr2[4] = 12323;
        iArr2[5] = 8;
        iArr2[6] = 12322;
        iArr2[7] = 8;
        iArr2[8] = 12321;
        iArr2[9] = 8;
        iArr2[10] = 12325;
        iArr2[11] = 0;
        iArr2[12] = 12326;
        iArr2[13] = 0;
        iArr2[14] = 12352;
        if (a != 2) {
            i2 = 68;
        }
        iArr2[15] = i2;
        iArr2[16] = 12610;
        iArr2[17] = 1;
        iArr2[18] = 12344;
        l = iArr2;
    }
}
