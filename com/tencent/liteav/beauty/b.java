package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.d.d;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.c;
import com.tencent.liteav.beauty.b.i;
import com.tencent.liteav.beauty.b.j;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.v;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class b extends HandlerThread {
    private int A = 0;
    private int B = 0;
    private boolean C = false;
    private float[] D;
    private int E = 0;
    private int F = 0;
    private a G = null;
    private Bitmap H = null;
    private k I = null;
    private n J = null;
    private com.tencent.liteav.beauty.b.b K = null;
    private com.tencent.liteav.beauty.b.a.a L = null;
    private com.tencent.liteav.beauty.b.b.a M = null;
    private c N = null;
    private l O = null;
    private m P = null;
    private v Q = null;
    private j R = null;
    private i S = null;
    private d T = null;
    private d U = null;
    private e V = null;
    private d W = null;
    private final Queue<Runnable> X = new LinkedList();
    private boolean Y;
    private Object Z = new Object();
    boolean a = false;
    private d aA = null;
    private WeakReference<com.tencent.liteav.basic.c.a> aB = new WeakReference(null);
    private f.a aC = new 8(this);
    private Object aa = new Object();
    private Handler ab;
    private a ac;
    private float ad = 0.5f;
    private int ae = 0;
    private int af = 0;
    private int ag = 0;
    private int ah = 0;
    private int ai = 0;
    private boolean aj = false;
    private com.tencent.liteav.beauty.a.a.c ak = null;
    private com.tencent.liteav.beauty.a.a.a al = null;
    private Bitmap am = null;
    private List<c.d> an = null;
    private long ao = 0;
    private int ap = 0;
    private final int aq = 100;
    private final float ar = 1000.0f;
    private byte[] as = null;
    private int[] at = null;
    private boolean au = false;
    private byte[] av = null;
    private int aw = -1;
    private int ax = 0;
    private int ay = 1;
    private int az = this.aw;
    protected int[] b = null;
    protected int[] c = null;
    com.tencent.liteav.beauty.b.a d = new com.tencent.liteav.beauty.b.a();
    com.tencent.liteav.beauty.b.a e = new com.tencent.liteav.beauty.b.a();
    com.tencent.liteav.beauty.b.a f = new com.tencent.liteav.beauty.b.a();
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private Context m = null;
    private boolean n = true;
    private c.d o = null;
    private int p = -1;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private float x = 1.0f;
    private int y = -1;
    private int z = -1;

    b(Context context, boolean z) {
        super("TXCFilterDrawer");
        this.m = context;
        this.ab = new Handler(this.m.getMainLooper());
        this.Y = z;
    }

    public synchronized boolean a(com.tencent.liteav.beauty.c.b bVar) {
        boolean z;
        z = true;
        if (bVar.j) {
            z = c(bVar);
        } else {
            if (this.ac == null) {
                start();
                this.ac = new a(this, getLooper(), this.m);
            }
            this.ac.obtainMessage(0, bVar).sendToTarget();
            this.ac.b();
        }
        return z;
    }

    public int a(int i, int i2) {
        int b;
        a(this.X);
        int i3 = this.x != 1.0f ? 1 : 0;
        GLES20.glViewport(0, 0, this.v, this.w);
        if (this.U != null) {
            if (4 == i2) {
                this.U.a(this.D);
            }
            i = this.U.b(i);
        }
        if (this.K != null && (this.af > 0 || this.ag > 0 || this.ai > 0)) {
            i = this.K.b(i);
        }
        if (this.O != null) {
            i = this.O.b(i);
        }
        GLES20.glViewport(0, 0, this.t, this.u);
        if (this.R != null) {
            i = this.R.a(i);
            i3 = 0;
        }
        if (this.S != null) {
            b = this.S.b(i);
            i3 = 0;
        } else {
            b = i;
        }
        if (i3 != 0) {
            c(this.t, this.u);
            if (this.W != null) {
                GLES20.glViewport(0, 0, this.t, this.u);
                i3 = this.W.b(b);
                if (this.aA != null) {
                    b = this.aA.a(i3, this.t, this.u);
                    if (b > 0) {
                        i3 = b;
                    }
                }
                GLES20.glViewport(0, 0, this.t, this.u);
                if (this.Q != null) {
                    i3 = this.Q.b(i3);
                }
                if (this.T != null) {
                    GLES20.glViewport(0, 0, this.y, this.z);
                    i3 = this.T.b(i3);
                }
                m(i3);
                return i3;
            }
        }
        i3 = b;
        if (this.aA != null) {
            b = this.aA.a(i3, this.t, this.u);
            if (b > 0) {
                i3 = b;
            }
        }
        GLES20.glViewport(0, 0, this.t, this.u);
        if (this.Q != null) {
            i3 = this.Q.b(i3);
        }
        if (this.T != null) {
            GLES20.glViewport(0, 0, this.y, this.z);
            i3 = this.T.b(i3);
        }
        m(i3);
        return i3;
    }

    public int a(byte[] bArr, int i) {
        a(bArr);
        if (this.Y) {
            b(bArr);
            return n(i);
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        this.ac.obtainMessage(2, bArr2).sendToTarget();
        if (!this.au) {
            TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
            NativeLoad.getInstance();
            NativeLoad.nativeClearQueue();
        }
        this.ac.obtainMessage(3, i, 0).sendToTarget();
        a(bArr2, this.au);
        this.au = true;
        return -1;
    }

    public void a(float f) {
        a(new 1(this, f));
    }

    public void a(float[] fArr) {
        a(new 5(this, fArr));
    }

    private void a(a aVar, int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        int i7;
        if (this.U == null) {
            TXCLog.i("TXCFilterDrawer", "Create CropFilter");
            if (4 == i6) {
                this.U = new d("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
            } else {
                this.U = new d();
            }
            if (true == this.U.a()) {
                this.U.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
            }
        }
        this.U.a(i3, i4);
        float[] a = this.U.a(this.p, this.q, null, aVar, i6);
        int i8 = (720 - i5) % 360;
        if (i8 == 90 || i8 == 270) {
            i7 = i4;
        } else {
            i7 = i3;
        }
        if (i8 == 90 || i8 == 270) {
            i4 = i3;
        }
        this.U.a(i, i2, i8, a, ((float) i7) / ((float) i4), z, false);
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6) {
        synchronized (this.aa) {
            int i7 = ((i6 - i3) + 360) % 360;
            TXCLog.i("TXCFilterDrawer", "real outputAngle " + i7);
            if (this.T == null) {
                if (i == i4 && i2 == i5 && i7 == 0) {
                    TXCLog.i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
                    return;
                }
                this.T = new d();
                if (true == this.T.a()) {
                    this.T.a(true);
                } else {
                    TXCLog.e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
                }
            }
            this.T.a(i4, i5);
            this.T.a((720 - i7) % 360, null);
        }
    }

    public void a(Bitmap bitmap, float f, float f2, float f3) {
        if (this.o == null) {
            this.o = new c.d();
        }
        if (this.o.a == null || bitmap == null || true != this.o.a.equals(bitmap) || f != this.o.b || f2 != this.o.c || f3 != this.o.d) {
            this.o.a = bitmap;
            this.o.b = f;
            this.o.c = f2;
            this.o.d = f3;
            a(new 6(this, bitmap, f, f2, f3));
        }
    }

    void a(d dVar) {
        TXCLog.i("TXCFilterDrawer", "set listener");
        this.aA = dVar;
    }

    void a(com.tencent.liteav.basic.c.a aVar) {
        TXCLog.i("TXCFilterDrawer", "set notify");
        this.aB = new WeakReference(aVar);
    }

    private int m(int i) {
        if (this.F == 0) {
            if (this.aA == null) {
                return i;
            }
            this.aA.a(i, this.y, this.z, TXCTimeUtil.getTimeTick());
            return i;
        } else if (1 == this.F || 3 == this.F || 2 == this.F) {
            GLES20.glViewport(0, 0, this.y, this.z);
            if (this.J == null) {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
                return i;
            }
            GLES20.glBindFramebuffer(36160, this.b[0]);
            this.J.a(i);
            if (2 == this.F) {
                b(this.y, this.z);
            } else {
                b(this.y, (this.z * 3) / 8);
            }
            GLES20.glBindFramebuffer(36160, 0);
            return i;
        } else {
            TXCLog.e("TXCFilterDrawer", "Don't support format!");
            return -1;
        }
    }

    private int b(int i, int i2) {
        ByteBuffer byteBuffer = null;
        if (true == this.Y) {
            if (this.aA != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i, i2, this.as);
                this.aA.a(this.as, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
            } else if (this.av != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i, i2, this.av);
            }
        } else if (3 == f.a()) {
            if (0 == this.ao) {
                this.ao = TXCTimeUtil.getTimeTick();
            }
            int i3 = this.ap + 1;
            this.ap = i3;
            if (i3 >= 100) {
                TXCLog.i("TXCFilterDrawer", "Real fps " + (100.0f / (((float) (TXCTimeUtil.getTimeTick() - this.ao)) / 1000.0f)));
                this.ap = 0;
                this.ao = TXCTimeUtil.getTimeTick();
            }
            GLES30.glPixelStorei(3333, 1);
            if (VERSION.SDK_INT >= 18) {
                GLES30.glReadBuffer(1029);
            }
            GLES30.glBindBuffer(35051, this.at[0]);
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixs(i, i2, null);
            if (VERSION.SDK_INT >= 18) {
                byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, (i * i2) * 4, 1);
                if (byteBuffer == null) {
                    TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
                    return -1;
                }
            }
            NativeLoad.getInstance();
            NativeLoad.nativeGlMapBufferToQueue(i, i2, byteBuffer);
            if (VERSION.SDK_INT >= 18) {
                GLES30.glUnmapBuffer(35051);
            }
            GLES30.glBindBuffer(35051, 0);
        } else {
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixsToQueue(i, i2);
        }
        return 0;
    }

    public void a(int i) {
        a(new 7(this, i));
    }

    private void a(byte[] bArr, boolean z) {
        if (z) {
            int i = (this.z * 3) / 8;
            if (2 == this.F) {
                i = this.z;
            }
            if (this.aA != null) {
                NativeLoad.getInstance();
                if (true == NativeLoad.nativeGlReadPixsFromQueue(this.y, i, this.as)) {
                    this.aA.a(this.as, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
                    return;
                }
                TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
                this.aA.a(bArr, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
                return;
            }
            NativeLoad.getInstance();
            if (!NativeLoad.nativeGlReadPixsFromQueue(this.y, i, this.av)) {
                TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
            }
        } else if (this.aA != null) {
            this.aA.a(bArr, this.y, this.z, this.F, TXCTimeUtil.getTimeTick());
        } else {
            TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
        }
    }

    private int n(int i) {
        GLES20.glViewport(0, 0, this.p, this.q);
        return a(this.I.p(), i);
    }

    public void a(byte[] bArr) {
        this.av = bArr;
    }

    private void b(byte[] bArr) {
        if (this.I == null) {
            TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
        } else {
            this.I.a(bArr);
        }
    }

    public void a() {
        if (this.Y) {
            b();
        } else if (this.ac != null) {
            this.ac.obtainMessage(1).sendToTarget();
            try {
                this.d.b();
            } catch (InterruptedException e) {
            }
        }
    }

    private void b() {
        TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
        this.au = false;
        if (this.I != null) {
            this.I.d();
            this.I = null;
        }
        if (this.J != null) {
            this.J.d();
            this.J = null;
        }
        c();
        if (this.O != null) {
            this.O.d();
            this.O = null;
        }
        if (this.P != null) {
            this.P.a();
            this.P = null;
        }
        if (this.V != null) {
            this.V.d();
            this.V = null;
        }
        if (this.U != null) {
            this.U.d();
            this.U = null;
        }
        if (this.T != null) {
            this.T.d();
            this.T = null;
        }
        if (this.Q != null) {
            this.Q.d();
            this.Q = null;
        }
        if (this.R != null) {
            this.R.a();
            this.R = null;
        }
        if (this.S != null) {
            this.S.d();
            this.S = null;
        }
        if (this.W != null) {
            this.W.d();
            this.W = null;
        }
        if (this.b != null) {
            GLES20.glDeleteFramebuffers(1, this.b, 0);
            this.b = null;
        }
        if (this.c != null) {
            GLES20.glDeleteTextures(1, this.c, 0);
            this.c = null;
        }
        this.o = null;
        TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
    }

    private boolean c(com.tencent.liteav.beauty.c.b bVar) {
        TXCLog.i("TXCFilterDrawer", "come into initInternal");
        b();
        this.Y = bVar.j;
        this.p = bVar.d;
        this.q = bVar.e;
        this.G = bVar.m;
        this.r = bVar.g;
        this.s = bVar.f;
        this.A = bVar.h;
        this.C = bVar.i;
        this.y = bVar.b;
        this.z = bVar.c;
        this.B = bVar.a;
        this.t = bVar.g;
        this.u = bVar.f;
        if (this.A == 90 || this.A == 270) {
            this.t = bVar.f;
            this.u = bVar.g;
        }
        this.F = bVar.l;
        this.E = bVar.k;
        this.as = new byte[((this.y * this.z) * 4)];
        TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is " + this.x);
        if (this.x != 1.0f) {
            int i = this.t < this.u ? this.t : this.u;
            if (i > 368) {
                this.x = 432.0f / ((float) i);
            }
            if (this.x > 1.0f) {
                this.x = 1.0f;
            }
        }
        this.v = (int) (((float) this.t) * this.x);
        this.w = (int) (((float) this.u) * this.x);
        a(this.v, this.w, this.ae);
        if (!(this.o == null || this.o.a == null || this.Q != null)) {
            TXCLog.i("TXCFilterDrawer", "reset water mark!");
            a(this.o.a, this.o.b, this.o.c, this.o.d);
        }
        if (this.H != null && this.O == null) {
            a(this.v, this.w, this.H);
        }
        a(this.G, this.r, this.s, this.v, this.w, this.C, this.A, this.E);
        a(this.t, this.u, this.A, this.y, this.z, this.B);
        if (this.b == null) {
            this.b = new int[1];
        } else {
            GLES20.glDeleteFramebuffers(1, this.b, 0);
        }
        if (this.c == null) {
            this.c = new int[1];
        } else {
            GLES20.glDeleteTextures(1, this.c, 0);
        }
        a(this.b, this.c, this.y, this.z);
        if (3 == f.a()) {
            if (this.at == null) {
                this.at = new int[1];
            } else {
                TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
                GLES30.glDeleteBuffers(1, this.at, 0);
            }
            TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
            f.a(this.r, this.s, this.at);
        }
        TXCLog.i("TXCFilterDrawer", "come out initInternal");
        return true;
    }

    public boolean b(com.tencent.liteav.beauty.c.b bVar) {
        if (this.Y) {
            d(bVar);
        } else if (this.ac == null) {
            TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
            return false;
        } else {
            this.ac.obtainMessage(5, 0, 0, bVar).sendToTarget();
        }
        return true;
    }

    private void a(int[] iArr, int[] iArr2, int i, int i2) {
        GLES20.glGenFramebuffers(1, iArr, 0);
        iArr2[0] = f.a(i, i2, 6408, 6408, iArr2);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private boolean d(com.tencent.liteav.beauty.c.b bVar) {
        if ((1 == bVar.k || 3 == bVar.k || 2 == bVar.k) && this.I == null) {
            this.I = new k(bVar.k);
            this.I.a(true);
            if (this.I.a()) {
                this.I.a(bVar.d, bVar.e);
            } else {
                TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
                return false;
            }
        }
        if ((1 == bVar.l || 3 == bVar.l || 2 == bVar.l) && this.J == null) {
            this.J = new n(bVar.l);
            if (this.J.a()) {
                this.J.a(bVar.b, bVar.c);
            } else {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
                return false;
            }
        }
        return true;
    }

    public void b(int i) {
        this.af = i;
        a(new 9(this, i));
    }

    public void c(int i) {
        if (this.ae != i && i <= 2 && i >= 0) {
            this.ae = i;
            a(new 10(this, i));
        }
    }

    public void d(int i) {
        this.ag = i;
        a(new 11(this, i));
    }

    public void e(int i) {
        this.ah = i;
        a(new 2(this, i));
    }

    public void f(int i) {
        this.ai = i;
        a(new 3(this, i));
    }

    public void a(String str) {
    }

    public void a(String str, boolean z) {
    }

    public void a(Bitmap bitmap) {
        if (this.H != bitmap) {
            this.H = bitmap;
            a(new 4(this));
        }
    }

    public void g(int i) {
    }

    public void h(int i) {
    }

    public void i(int i) {
    }

    public void j(int i) {
    }

    public void k(int i) {
    }

    public void l(int i) {
    }

    private void a(int i, int i2, int i3) {
        TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
        if (i3 == 0) {
            if (this.L == null) {
                this.L = new com.tencent.liteav.beauty.b.a.a();
            }
            this.K = this.L;
        } else if (1 == i3) {
            if (this.M == null) {
                this.M = new com.tencent.liteav.beauty.b.b.a();
            }
            this.K = this.M;
        } else if (2 == i3) {
            if (this.N == null) {
                this.N = new c();
            }
            this.K = this.N;
        }
        if (this.K == null) {
            TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
            return;
        }
        this.K.a(true);
        if (true == this.K.b(i, i2)) {
            if (this.af > 0) {
                this.K.c(this.af);
            }
            if (this.ag > 0) {
                this.K.d(this.ag);
            }
            if (this.ai > 0) {
                this.K.e(this.ai);
            }
            if (this.ah > 0) {
                this.K.f(this.ah);
                return;
            }
            return;
        }
        TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
    }

    private void c() {
        if (this.L != null) {
            this.L.d();
            this.L = null;
        }
        if (this.M != null) {
            this.M.d();
            this.M = null;
        }
        if (this.N != null) {
            this.N.d();
            this.N = null;
        }
        this.K = null;
    }

    private void a(int i, int i2, Bitmap bitmap) {
        if (this.O == null) {
            TXCLog.i("TXCFilterDrawer", "createLoopupFilter");
            this.O = new l(bitmap);
            if (true == this.O.a()) {
                this.O.a(true);
                this.O.a(i, i2);
                return;
            }
            TXCLog.e("TXCFilterDrawer", "mLookupFilter init failed!");
        }
    }

    private void c(int i, int i2) {
        if (this.W == null) {
            TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
            this.W = new d();
            if (true == this.W.a()) {
                this.W.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
            }
        }
        if (this.W != null) {
            this.W.a(i, i2);
        }
    }

    private void a(Runnable runnable) {
        synchronized (this.X) {
            this.X.add(runnable);
        }
    }

    private void a(Queue<Runnable> queue) {
        while (true) {
            Runnable runnable = null;
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    runnable = (Runnable) queue.poll();
                }
            }
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
        while (true) {
        }
    }
}
