package com.tencent.mm.plugin.voip.video;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender implements Renderer {
    static String TAG = "OpenGlRender";
    public static int oUA = 2;
    public static int oUB = 0;
    public static int oUC = 1;
    public static int oUD = 0;
    public static int oUE = 1;
    public static int oUF = 2;
    public static int oUG = 3;
    public static int oUH = 4;
    public static int oUI = 12;
    public static int oUJ = 16;
    public static int oUK = 0;
    public static int oUL = 1;
    public static int oUV = 0;
    static boolean oUX = false;
    public static int oUy = 0;
    public static int oUz = 1;
    int mRenderMode = oUK;
    public boolean oUM = false;
    public Bitmap oUN = null;
    private int oUO = 0;
    private int oUP = 0;
    private byte[] oUQ = null;
    private int[] oUR = null;
    private int oUS;
    private int oUT;
    private int oUU;
    WeakReference<Object> oUW;
    boolean oUh = false;
    int oUi = 0;
    long oUj = 0;
    long oUk = 0;
    int oUl = 0;
    a oUm;
    public float oUn = 1.2f;
    public float oUo = 1.93f;
    public float oUp = 1.05f;
    boolean oUq = false;
    public boolean oUr = false;
    boolean oUs = false;
    boolean oUt = false;
    boolean oUu = false;
    int oUv = 0;
    int oUw = 0;
    WeakReference<OpenGlView> oUx;

    private native void render32(int[] iArr, int i, int i2, int i3, int i4);

    private native void render8(byte[] bArr, int i, int i2, int i3, int i4);

    final native void Init(int i, Object obj, int i2);

    final native void Uninit(int i);

    final native void setMode(int i, int i2, int i3, int i4);

    final native void setParam(float f, float f2, float f3, int i);

    public static int bMg() {
        if (oUV == 0) {
            oUV = ((ActivityManager) ad.getContext().getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion == 131072 ? 2 : 1;
            if (Build.MODEL.equals("Nexus 6")) {
                oUV = 2;
            }
        }
        return oUV;
    }

    public OpenGlRender(OpenGlView openGlView, int i) {
        if (!oUX) {
            k.b("mm_gl_disp", OpenGlRender.class.getClassLoader());
            oUX = true;
        }
        this.mRenderMode = i;
        this.oUx = new WeakReference(openGlView);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.oUm = new a(this, myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.oUm = new a(this, myLooper);
            } else {
                this.oUm = null;
            }
        }
        this.oUW = null;
    }

    public final void onDrawFrame(GL10 gl10) {
        if (this.oUr && this.oUq && this.oUx.get() != null) {
            if (this.oUQ != null) {
                render8(this.oUQ, this.oUS, this.oUT, this.oUU, this.mRenderMode);
                this.oUQ = null;
            }
            if (this.oUR != null) {
                render32(this.oUR, this.oUS, this.oUT, this.oUU, this.mRenderMode);
                this.oUR = null;
                return;
            }
            return;
        }
        this.oUQ = null;
        this.oUR = null;
    }

    public final void e(byte[] bArr, int i, int i2, int i3) {
        if (this.oUq && this.oUQ == null) {
            this.oUS = i;
            this.oUT = i2;
            this.oUU = i3;
            this.oUQ = bArr;
            requestRender();
        }
    }

    public final void b(int[] iArr, int i, int i2, int i3) {
        if (this.oUq && this.oUR == null) {
            this.oUS = i;
            this.oUT = i2;
            this.oUU = i3;
            this.oUR = iArr;
            requestRender();
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        x.i(TAG, "%s onSurfaceChanged, width: %s, height: %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.oUv != i || this.oUw != i2) {
            gl10.glViewport(0, 0, i, i2);
            this.oUv = i;
            this.oUw = i2;
            if (VERSION.SDK_INT >= 23) {
                setMode(this.oUv, this.oUw, 1, this.mRenderMode);
            }
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public final void bMh() {
        x.i(TAG, "%s onStop, renderMode: %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode)});
        this.oUr = false;
        this.oUu = false;
    }

    public final void bMi() {
        x.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.oUq), Boolean.valueOf(this.oUr)});
        if (this.oUq && this.oUr) {
            x.i(TAG, "%s steve: Reset GLRender first! mode=%d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode)});
            this.oUq = false;
            this.oUr = false;
            Uninit(this.mRenderMode);
        }
    }

    public final void requestRender() {
        if (this.oUq) {
            if (!this.oUu) {
                setMode(((OpenGlView) this.oUx.get()).getWidth(), ((OpenGlView) this.oUx.get()).getHeight(), 0, this.mRenderMode);
                this.oUu = true;
            }
            if (this.oUx.get() != null) {
                OpenGlView openGlView = (OpenGlView) this.oUx.get();
                openGlView.oUZ = true;
                openGlView.requestRender();
            }
        }
    }
}
