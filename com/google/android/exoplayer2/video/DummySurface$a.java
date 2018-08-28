package com.google.android.exoplayer2.video;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.i.a;

class DummySurface$a extends HandlerThread implements OnFrameAvailableListener, Callback {
    private final int[] aCV = new int[1];
    private EGLDisplay aCW;
    private EGLContext aCX;
    private EGLSurface aCY;
    private SurfaceTexture aCZ;
    private Error aDa;
    private RuntimeException aDb;
    private DummySurface aDc;
    Handler handler;

    public DummySurface$a() {
        super("dummySurface");
    }

    public final DummySurface aq(boolean z) {
        Object obj = null;
        start();
        this.handler = new Handler(getLooper(), this);
        synchronized (this) {
            this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.aDc == null && this.aDb == null && this.aDa == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            Thread.currentThread().interrupt();
        }
        if (this.aDb != null) {
            throw this.aDb;
        } else if (this.aDa == null) {
            return this.aDc;
        } else {
            throw this.aDa;
        }
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.handler.sendEmptyMessage(2);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                try {
                    boolean z;
                    boolean z2 = message.arg1 != 0;
                    this.aCW = EGL14.eglGetDisplay(0);
                    if (this.aCW != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a.c(z, "eglGetDisplay failed");
                    int[] iArr = new int[2];
                    a.c(EGL14.eglInitialize(this.aCW, iArr, 0, iArr, 1), "eglInitialize failed");
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    int[] iArr2 = new int[1];
                    if (!EGL14.eglChooseConfig(this.aCW, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) || iArr2[0] <= 0 || eGLConfigArr[0] == null) {
                        z = false;
                    } else {
                        z = true;
                    }
                    a.c(z, "eglChooseConfig failed");
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    if (z2) {
                        iArr = new int[]{12440, 2, 12992, 1, 12344};
                    } else {
                        iArr = new int[]{12440, 2, 12344};
                    }
                    this.aCX = EGL14.eglCreateContext(this.aCW, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                    if (this.aCX != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a.c(z, "eglCreateContext failed");
                    if (z2) {
                        iArr = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                    } else {
                        iArr = new int[5];
                        iArr = new int[]{12375, 1, 12374, 1, 12344};
                    }
                    this.aCY = EGL14.eglCreatePbufferSurface(this.aCW, eGLConfig, iArr, 0);
                    if (this.aCY != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a.c(z, "eglCreatePbufferSurface failed");
                    a.c(EGL14.eglMakeCurrent(this.aCW, this.aCY, this.aCY, this.aCX), "eglMakeCurrent failed");
                    GLES20.glGenTextures(1, this.aCV, 0);
                    this.aCZ = new SurfaceTexture(this.aCV[0]);
                    this.aCZ.setOnFrameAvailableListener(this);
                    this.aDc = new DummySurface(this, this.aCZ, z2, (byte) 0);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e) {
                    this.aDb = e;
                    synchronized (this) {
                        notify();
                        break;
                    }
                } catch (Error e2) {
                    this.aDa = e2;
                    synchronized (this) {
                        notify();
                        break;
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                    }
                }
                break;
            case 2:
                this.aCZ.updateTexImage();
                break;
            case 3:
                try {
                    if (this.aCZ != null) {
                        this.aCZ.release();
                        GLES20.glDeleteTextures(1, this.aCV, 0);
                    }
                    if (this.aCY != null) {
                        EGL14.eglDestroySurface(this.aCW, this.aCY);
                    }
                    if (this.aCX != null) {
                        EGL14.eglDestroyContext(this.aCW, this.aCX);
                    }
                    this.aCY = null;
                    this.aCX = null;
                    this.aCW = null;
                    this.aDc = null;
                    this.aCZ = null;
                    quit();
                    break;
                } catch (Throwable th2) {
                    quit();
                }
        }
        return true;
    }
}
