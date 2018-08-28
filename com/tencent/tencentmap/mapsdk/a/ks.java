package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.e;
import com.tencent.map.lib.listener.a;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.tencentmap.mapsdk.a.ac.c;
import com.tencent.tencentmap.mapsdk.a.ac.d;
import com.tencent.tencentmap.mapsdk.a.ac.f;
import com.tencent.tencentmap.mapsdk.a.ac.g;
import com.tencent.tencentmap.mapsdk.a.ac.h;
import com.tencent.tencentmap.mapsdk.a.ac.i;
import com.tencent.tencentmap.mapsdk.a.ac.j;
import com.tencent.tencentmap.mapsdk.a.ac.k;
import com.tencent.tencentmap.mapsdk.a.ac.l;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.opengles.GL10;

public class ks extends kq implements a, nl.a {
    private static final String I = ks.class.getSimpleName();
    public int A;
    public int B;
    public ac.a C;
    public d D;
    public float E;
    public float F;
    public float G;
    public float H;
    private String J;
    private boolean K;
    private lh.a L;
    private ArrayList<ke> M;
    private List<ke> N;
    private List<ke> O;
    private List<ke> P;
    private nr Q;
    private Map<Class<? extends ke>, od> R;
    private List<mq> S;
    private ac$e T;
    private float U;
    private float V;
    private boolean W;
    private AtomicBoolean aA;
    private Comparator<ke> aB;
    private e aC;
    private final id aD;
    private boolean aE;
    private boolean aF;
    private volatile boolean aG;
    private volatile boolean aH;
    private int aI;
    private final he aJ;
    private final Handler aK;
    private nj aL;
    private Handler aM;
    private Config aN;
    private boolean aO;
    private mp.a aP;
    private int aQ;
    private int aR;
    private int aS;
    private int aT;
    private GeoPoint aU;
    private lo aV;
    private boolean aW;
    private final hz aX;
    private hg aY;
    private boolean aZ;
    private volatile boolean aa;
    private lq ab;
    private nl ac;
    private lp ad;
    private kx ae;
    private boolean af;
    private lg ag;
    private le ah;
    private f ai;
    private int aj;
    private int ak;
    private int al;
    private boolean am;
    private pk an;
    private nf ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private boolean at;
    private boolean au;
    private int av;
    private int aw;
    private oj ax;
    private k ay;
    private int az;
    public byte[] e;
    public kc f;
    public kk g;
    public kk h;
    public kk i;
    public kk j;
    public om k;
    public h l;
    public mu.a m;
    public c n;
    public j o;
    public volatile i p;
    public l q;
    public g r;
    public Handler s;
    public ox t;
    public ox u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    static /* synthetic */ int s(ks ksVar) {
        int i = ksVar.aI - 1;
        ksVar.aI = i;
        return i;
    }

    private or getCurrentCameraPosition() {
        com.tencent.map.lib.f map = getMap();
        GeoPoint f = map.f();
        if (f == null || (this.n == null && this.aX == null)) {
            return null;
        }
        ox a = kh.a(f);
        float p = map.p();
        if (p < 0.0f) {
            p = (p % 360.0f) + 360.0f;
        }
        float q = map.q();
        float h = (float) (((double) ((float) map.h())) + (Math.log((double) map.j()) / Math.log(2.0d)));
        if (h < ((float) this.aw)) {
            h = (float) this.aw;
        } else if (h > ((float) ne.b(this.av))) {
            h = (float) ne.b(this.av);
        }
        return or.a().a(h).a(a).c(p).b(q).a();
    }

    private void v() {
        boolean z = true;
        lo.a c = this.aV.c();
        if (y()) {
            getMap().g(false);
            getMap().h(false);
            setShouldShowWorldMap(true);
            if (c.b()) {
                u();
                c.c();
            }
            if (!b(c.a())) {
                z = false;
            }
            b(z);
            if (this.ag != null) {
                String a = c.a();
                if (a == null || a.equals("taiwanmap")) {
                    this.ag.a(lg.a.b);
                    return;
                } else {
                    this.ag.a(lg.a.a);
                    return;
                }
            }
            return;
        }
        setShouldShowWorldMap(false);
        u();
        getMap().g(true);
        getMap().h(true);
        if (this.ag != null) {
            this.ag.a(lg.a.b);
        }
    }

    public ks(Context context, ad adVar) {
        super(context, adVar);
        this.e = new byte[0];
        this.J = "";
        this.f = null;
        this.K = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.L = null;
        this.M = new ArrayList();
        this.N = new ArrayList();
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.R = new HashMap();
        this.S = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.T = null;
        this.U = 100.0f;
        this.V = 100.0f;
        this.W = true;
        this.aa = false;
        this.ab = null;
        this.ac = null;
        this.af = false;
        this.aj = 10;
        this.ak = 0;
        this.al = 0;
        this.am = false;
        this.an = null;
        this.ap = true;
        this.aq = true;
        this.ar = true;
        this.as = true;
        this.at = true;
        this.au = true;
        this.av = 19;
        this.aw = 3;
        this.q = null;
        this.r = null;
        this.ax = null;
        this.ay = null;
        this.az = 0;
        this.aA = new AtomicBoolean(false);
        this.aB = new 1(this);
        this.aC = new b(this);
        this.aD = new c(this);
        this.s = null;
        this.aE = true;
        this.aF = true;
        this.aG = false;
        this.aH = false;
        this.aI = 0;
        this.aJ = new d(this);
        this.aK = new a(this);
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = null;
        this.aN = Config.RGB_565;
        this.aO = true;
        this.D = null;
        this.aP = null;
        this.aQ = Integer.MIN_VALUE;
        this.aR = Integer.MIN_VALUE;
        this.aS = Integer.MIN_VALUE;
        this.aT = Integer.MIN_VALUE;
        this.E = 0.5f;
        this.F = 0.5f;
        this.G = 0.5f;
        this.H = 0.5f;
        this.aU = null;
        this.aV = null;
        this.aW = false;
        this.aX = new 2(this);
        this.aY = new e(this);
        this.aZ = false;
        this.aV = new lo();
        this.aV.a(context);
        kv.a(context);
        this.av = ne.a(getMap().c());
        this.aw = getMap().b();
        ll.a(context).a(this.aV);
        this.aL = new lr(this.aV);
        a(this.aX);
        getMap().a(this.aD);
        getMap().a(this.aY);
        getMap().a(this.aC);
        getMap().a(this.aJ);
        getMap().a(this);
        if (this.s == null) {
            this.s = new Handler();
        }
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.A = windowManager.getDefaultDisplay().getWidth();
        this.B = windowManager.getDefaultDisplay().getHeight();
        this.ax = new oj(this);
        this.ax.a(new f(this));
        this.ab = new lq(this);
        this.ab.a(this.aV);
        this.ac = new nl(context, this.aV, this);
        if (adVar != null) {
            this.aW = adVar.c();
        }
    }

    public lo getWorldMapConfig() {
        return this.aV;
    }

    public void a(Context context) {
        super.h();
        pl.a(context.getApplicationContext());
        if (getMap().g()) {
            getMap().a(5);
        } else {
            getMap().a(0);
        }
        this.ac.a();
        if (this.aW) {
            r();
        }
    }

    public void a(GL10 gl10, int i, int i2) {
        super.a(gl10, i, i2);
        this.A = i;
        this.B = i2;
        b((int) (((float) this.A) * this.E), (int) (((float) this.B) * this.F));
        c((int) (((float) this.A) * this.G), (int) (((float) this.B) * this.H));
        if (this.aP != null) {
            this.aP.a();
        }
    }

    public void a(Handler handler, Config config) {
        this.aM = handler;
        this.aN = config;
        getMap().a();
    }

    private void b(GL10 gl10) {
        Object createBitmap;
        int i = this.A;
        int i2 = this.B;
        int[] iArr = new int[(i * i2)];
        int[] iArr2 = new int[(i * i2)];
        Buffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        gl10.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = iArr[(i3 * i) + i4];
                iArr2[(((i2 - i3) - 1) * i) + i4] = ((i5 & -16711936) | ((i5 << 16) & 16711680)) | ((i5 >> 16) & 255);
            }
        }
        try {
            createBitmap = Bitmap.createBitmap(iArr2, i, i2, this.aN);
        } catch (OutOfMemoryError e) {
            createBitmap = null;
        }
        this.aM.sendMessage(this.aM.obtainMessage(0, createBitmap));
        this.aM = null;
    }

    public void a(String str, boolean z) {
        a(str, z, false);
    }

    public void a(String str, boolean z, boolean z2) {
        if (z) {
            synchronized (this.e) {
                if (!z2) {
                    this.J = str;
                }
                if (((this.J != null && this.J.trim().length() == 0) || z2) && this.f != null) {
                    this.f.i();
                }
            }
            return;
        }
        if (!z2) {
            this.J = str;
        }
        if (((this.J != null && this.J.trim().length() == 0) || z2) && this.f != null) {
            this.f.i();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.map.lib.basemap.data.GeoPoint getMarkerOnTapedPosition() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.e;
        monitor-enter(r2);
        r0 = r3.J;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x0014;
    L_0x0008:
        r0 = r3.J;	 Catch:{ all -> 0x002a }
        r0 = r0.trim();	 Catch:{ all -> 0x002a }
        r0 = r0.length();	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0017;
    L_0x0014:
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        r0 = r1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r3.J;	 Catch:{ all -> 0x002a }
        r0 = r3.a(r0);	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0022;
    L_0x001f:
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        r0 = r1;
        goto L_0x0016;
    L_0x0022:
        r0 = (com.tencent.tencentmap.mapsdk.a.kd) r0;	 Catch:{ all -> 0x002a }
        r0 = r0.g();	 Catch:{ all -> 0x002a }
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        goto L_0x0016;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.ks.getMarkerOnTapedPosition():com.tencent.map.lib.basemap.data.GeoPoint");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(boolean r4) {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.e;
        monitor-enter(r2);
        r0 = r3.J;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x0014;
    L_0x0008:
        r0 = r3.J;	 Catch:{ all -> 0x002a }
        r0 = r0.trim();	 Catch:{ all -> 0x002a }
        r0 = r0.length();	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0017;
    L_0x0014:
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        r0 = r1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r3.J;	 Catch:{ all -> 0x002a }
        r0 = r3.a(r0);	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0022;
    L_0x001f:
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        r0 = r1;
        goto L_0x0016;
    L_0x0022:
        r0 = (com.tencent.tencentmap.mapsdk.a.kd) r0;	 Catch:{ all -> 0x002a }
        r0 = r0.c(r4);	 Catch:{ all -> 0x002a }
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        goto L_0x0016;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.ks.a(boolean):int");
    }

    public String getMarkerOnTapedId() {
        return this.J;
    }

    public boolean a(ke keVar) {
        if (keVar == null) {
            return false;
        }
        synchronized (this.e) {
            int size = this.M.size();
            int i = 0;
            boolean z = false;
            int i2 = size;
            while (i < size) {
                boolean z2;
                ke keVar2 = (ke) this.M.get(i);
                if (keVar2 == null || z || keVar2.w() < keVar.w()) {
                    z2 = z;
                } else {
                    z2 = true;
                    i2 = i;
                }
                i++;
                z = z2;
            }
            this.M.add(i2, keVar);
            if (keVar instanceof kd) {
                this.N.add(keVar);
                Collections.sort(this.N, this.aB);
            } else if (keVar instanceof kg) {
                this.O.add(keVar);
                Collections.sort(this.O, this.aB);
            } else {
                this.P.add(keVar);
                Collections.sort(this.P, this.aB);
            }
        }
        return true;
    }

    public ke b(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ke keVar;
        synchronized (this.e) {
            Iterator it = this.M.iterator();
            while (it.hasNext()) {
                keVar = (ke) it.next();
                if (keVar != null && TextUtils.equals(keVar.v(), str)) {
                    it.remove();
                    if (z) {
                        keVar.d();
                    }
                }
            }
            keVar = null;
        }
        if (keVar == null) {
            return keVar;
        }
        this.N.remove(keVar);
        this.O.remove(keVar);
        this.P.remove(keVar);
        return keVar;
    }

    public nr getBubblesOverlay() {
        nr nrVar;
        synchronized (this.e) {
            nrVar = this.Q;
        }
        return nrVar;
    }

    public void a(nr nrVar) {
        if (nrVar != null) {
            synchronized (this.e) {
                this.Q = nrVar;
            }
        }
    }

    public void i() {
        synchronized (this.e) {
            if (this.Q != null) {
                this.Q.e();
                this.Q = null;
            }
        }
    }

    public void j() {
        synchronized (this.e) {
            if (this.Q != null) {
                this.Q.f();
            }
        }
    }

    public void a(Class<? extends ke> cls, od odVar) {
        this.R.put(cls, odVar);
    }

    public od a(Class<? extends ke> cls) {
        return (od) this.R.get(cls);
    }

    public od b(Class<? extends ke> cls) {
        return (od) this.R.remove(cls);
    }

    private void d(int i, int i2) {
        if (this.S != null) {
            int size = this.S.size();
            for (int i3 = 0; i3 < size; i3++) {
                mq mqVar = (mq) this.S.get(i3);
                if (mqVar != null) {
                    mqVar.a(i, i2);
                }
            }
        }
        if (this.e != null && this.M != null) {
            synchronized (this.e) {
                Iterator it = this.M.iterator();
                while (it.hasNext()) {
                    ((ke) it.next()).u();
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d(i, i2);
    }

    private boolean b(float f, float f2) {
        if (this.m != null) {
            String a = a(f, f2);
            if (!(a == null || a.trim().length() == 0)) {
                this.m.a(a);
                return true;
            }
        }
        if (this.o != null && this.au) {
            this.o.a(kh.a(getMap().s().a(new DoublePoint((double) f, (double) f2))));
        }
        return false;
    }

    public void a(mq mqVar) {
        if (mqVar != null) {
            if (this.S == null) {
                this.S = new ArrayList();
            }
            if (!this.S.contains(mqVar)) {
                this.S.add(mqVar);
            }
        }
    }

    private void c(GL10 gl10) {
        synchronized (this.e) {
            ke keVar = null;
            int size = this.M.size();
            for (int i = 0; i < size; i++) {
                ke keVar2 = (ke) this.M.get(i);
                if (keVar2 != null) {
                    if (TextUtils.equals(keVar2.v(), this.J)) {
                        if (keVar2.a() || this.am) {
                            keVar = keVar2;
                        } else {
                            keVar2.b();
                        }
                    } else if (keVar2 instanceof kf) {
                        ((kf) keVar2).a(getMap().y(), getMap().s(), gl10);
                    } else {
                        keVar2.a(gl10);
                    }
                }
            }
            if (keVar != null) {
                keVar.a(gl10);
            }
            d(gl10);
            if (!(this.f == null || !this.f.j() || keVar == null)) {
                kd kdVar = (kd) keVar;
                if (kdVar != null && kdVar.s()) {
                    this.f.a(kdVar.i(), kdVar.j(), kdVar.k(), kdVar.l());
                    this.f.b(kdVar.o());
                    this.f.b(kdVar.g());
                    this.f.a(kdVar.e());
                    if (kdVar.o() && !kdVar.r()) {
                        Point p = kdVar.p();
                        this.f.a(p.x, p.y);
                    }
                }
                List arrayList = new ArrayList();
                for (kr krVar : this.N) {
                    if (krVar instanceof kd) {
                        arrayList.add((kd) krVar);
                    }
                }
                this.f.b(kdVar.c(false), kdVar.c(true));
                this.f.f(a(this.f, kdVar, arrayList));
                this.f.a(gl10);
            }
        }
    }

    private void d(GL10 gl10) {
        if (this.Q != null) {
            hh s = getMap().s();
            this.Q.b(getMap().y(), s);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(float r9, float r10) {
        /*
        r8 = this;
        r1 = 1;
        r2 = 0;
        r3 = 0;
        r5 = r8.e;
        monitor-enter(r5);
        r0 = r8.J;	 Catch:{ all -> 0x0054 }
        r4 = "";
        r0 = r0.equals(r4);	 Catch:{ all -> 0x0054 }
        if (r0 != 0) goto L_0x0123;
    L_0x0011:
        r0 = r8.f;	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0123;
    L_0x0015:
        r0 = r8.f;	 Catch:{ all -> 0x0054 }
        r4 = r0.a(r9, r10);	 Catch:{ all -> 0x0054 }
        if (r4 != r1) goto L_0x0120;
    L_0x001d:
        r0 = r8.J;	 Catch:{ all -> 0x0054 }
        r0 = r8.a(r0);	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0120;
    L_0x0025:
        r0 = (com.tencent.tencentmap.mapsdk.a.kd) r0;	 Catch:{ all -> 0x0054 }
        r0 = r0.x;	 Catch:{ all -> 0x0054 }
    L_0x0029:
        monitor-exit(r5);	 Catch:{ all -> 0x0054 }
        if (r4 != r1) goto L_0x0057;
    L_0x002c:
        r2 = r8.r;
        if (r2 == 0) goto L_0x0052;
    L_0x0030:
        if (r0 == 0) goto L_0x0052;
    L_0x0032:
        r2 = r0.p();
        if (r2 == 0) goto L_0x0052;
    L_0x0038:
        r2 = r8.r;
        r2.a(r0);
        r0 = r8.r;
        r2 = r8.f;
        r2 = r2.l;
        r3 = r8.f;
        r3 = r3.m;
        r4 = r8.f;
        r4 = r4.G;
        r5 = r8.f;
        r5 = r5.H;
        r0.a(r2, r3, r4, r5);
    L_0x0052:
        r0 = r1;
    L_0x0053:
        return r0;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        r4 = r8.e;
        monitor-enter(r4);
        r0 = r8.N;	 Catch:{ all -> 0x007a }
        r0 = r0.size();	 Catch:{ all -> 0x007a }
        r3 = r0 + -1;
        r0 = r2;
    L_0x0063:
        if (r3 < 0) goto L_0x0076;
    L_0x0065:
        r0 = r8.N;	 Catch:{ all -> 0x007a }
        r0 = r0.get(r3);	 Catch:{ all -> 0x007a }
        r0 = (com.tencent.tencentmap.mapsdk.a.ke) r0;	 Catch:{ all -> 0x007a }
        r0 = r8.a(r0, r9, r10);	 Catch:{ all -> 0x007a }
        if (r0 != 0) goto L_0x0076;
    L_0x0073:
        r3 = r3 + -1;
        goto L_0x0063;
    L_0x0076:
        if (r0 == 0) goto L_0x007d;
    L_0x0078:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        goto L_0x0053;
    L_0x007a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        throw r0;
    L_0x007d:
        r3 = r8.Q;	 Catch:{ all -> 0x007a }
        if (r3 == 0) goto L_0x0097;
    L_0x0081:
        r3 = r8.Q;	 Catch:{ all -> 0x007a }
        r5 = r8.getMap();	 Catch:{ all -> 0x007a }
        r5 = r5.s();	 Catch:{ all -> 0x007a }
        r3 = r3.a(r5, r9, r10);	 Catch:{ all -> 0x007a }
        if (r3 == 0) goto L_0x0097;
    L_0x0091:
        r8.f();	 Catch:{ all -> 0x007a }
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        r0 = r1;
        goto L_0x0053;
    L_0x0097:
        r1 = r8.O;	 Catch:{ all -> 0x007a }
        r1 = r1.size();	 Catch:{ all -> 0x007a }
        r1 = r1 + -1;
    L_0x009f:
        if (r1 < 0) goto L_0x00b2;
    L_0x00a1:
        r0 = r8.O;	 Catch:{ all -> 0x007a }
        r0 = r0.get(r1);	 Catch:{ all -> 0x007a }
        r0 = (com.tencent.tencentmap.mapsdk.a.ke) r0;	 Catch:{ all -> 0x007a }
        r0 = r8.a(r0, r9, r10);	 Catch:{ all -> 0x007a }
        if (r0 != 0) goto L_0x00b2;
    L_0x00af:
        r1 = r1 + -1;
        goto L_0x009f;
    L_0x00b2:
        if (r0 == 0) goto L_0x00b6;
    L_0x00b4:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        goto L_0x0053;
    L_0x00b6:
        r1 = r8.P;	 Catch:{ all -> 0x007a }
        r1 = r1.size();	 Catch:{ all -> 0x007a }
        r1 = r1 + -1;
    L_0x00be:
        if (r1 < 0) goto L_0x00d1;
    L_0x00c0:
        r0 = r8.P;	 Catch:{ all -> 0x007a }
        r0 = r0.get(r1);	 Catch:{ all -> 0x007a }
        r0 = (com.tencent.tencentmap.mapsdk.a.ke) r0;	 Catch:{ all -> 0x007a }
        r0 = r8.a(r0, r9, r10);	 Catch:{ all -> 0x007a }
        if (r0 != 0) goto L_0x00d1;
    L_0x00ce:
        r1 = r1 + -1;
        goto L_0x00be;
    L_0x00d1:
        if (r0 == 0) goto L_0x00d6;
    L_0x00d3:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        goto L_0x0053;
    L_0x00d6:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        r0 = r8.K;
        if (r0 == 0) goto L_0x00e9;
    L_0x00db:
        r1 = r8.e;
        monitor-enter(r1);
        r0 = r8.f;	 Catch:{ all -> 0x011a }
        if (r0 == 0) goto L_0x00e8;
    L_0x00e2:
        r0 = r8.f;	 Catch:{ all -> 0x011a }
        r3 = 0;
        r0.h(r3);	 Catch:{ all -> 0x011a }
    L_0x00e8:
        monitor-exit(r1);	 Catch:{ all -> 0x011a }
    L_0x00e9:
        r0 = r8.l;
        if (r0 == 0) goto L_0x010d;
    L_0x00ed:
        r0 = r8.au;
        if (r0 == 0) goto L_0x010d;
    L_0x00f1:
        r0 = new com.tencent.map.lib.basemap.data.DoublePoint;
        r4 = (double) r9;
        r6 = (double) r10;
        r0.<init>(r4, r6);
        r1 = r8.getMap();
        r1 = r1.s();
        r0 = r1.a(r0);
        r0 = com.tencent.tencentmap.mapsdk.a.kh.a(r0);
        r1 = r8.l;
        r1.a(r0);
    L_0x010d:
        r1 = r8.e;
        monitor-enter(r1);
        r8.j();	 Catch:{ all -> 0x011d }
        monitor-exit(r1);	 Catch:{ all -> 0x011d }
        r8.f();
        r0 = r2;
        goto L_0x0053;
    L_0x011a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x011a }
        throw r0;
    L_0x011d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x011d }
        throw r0;
    L_0x0120:
        r0 = r3;
        goto L_0x0029;
    L_0x0123:
        r0 = r3;
        r4 = r2;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.ks.c(float, float):boolean");
    }

    private boolean a(ke keVar, float f, float f2) {
        if (keVar == null || !keVar.a() || !keVar.q()) {
            return false;
        }
        if (!keVar.a(f, f2)) {
            return false;
        }
        od odVar = (od) this.R.get(keVar.getClass());
        return odVar != null ? odVar.a(keVar, true, getMap().s().a(new DoublePoint((double) f, (double) f2))) : false;
    }

    public void setOnTapMapViewInfoWindowHidden(boolean z) {
        this.K = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r9, float r10) {
        /*
        r8 = this;
        r4 = -1;
        if (r9 == 0) goto L_0x000c;
    L_0x0003:
        r0 = "";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r6 = r8.e;
        monitor-enter(r6);
        r0 = r8.M;	 Catch:{ all -> 0x0043 }
        r5 = r0.size();	 Catch:{ all -> 0x0043 }
        r1 = 0;
        r2 = r4;
        r3 = r5;
    L_0x0019:
        if (r1 >= r5) goto L_0x003d;
    L_0x001b:
        r0 = r8.M;	 Catch:{ all -> 0x0043 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0043 }
        r0 = (com.tencent.tencentmap.mapsdk.a.ke) r0;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x005d;
    L_0x0025:
        r7 = r0.w();	 Catch:{ all -> 0x0043 }
        r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x002e;
    L_0x002d:
        r3 = r1;
    L_0x002e:
        r0 = r0.v();	 Catch:{ all -> 0x0043 }
        r0 = android.text.TextUtils.equals(r0, r9);	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x005d;
    L_0x0038:
        r0 = r1;
    L_0x0039:
        r1 = r1 + 1;
        r2 = r0;
        goto L_0x0019;
    L_0x003d:
        if (r2 == r4) goto L_0x0041;
    L_0x003f:
        if (r2 != r3) goto L_0x0046;
    L_0x0041:
        monitor-exit(r6);	 Catch:{ all -> 0x0043 }
        goto L_0x000c;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        if (r3 < r2) goto L_0x004a;
    L_0x0048:
        r3 = r3 + -1;
    L_0x004a:
        r0 = r8.M;	 Catch:{ all -> 0x0043 }
        r0 = r0.remove(r2);	 Catch:{ all -> 0x0043 }
        r0 = (com.tencent.tencentmap.mapsdk.a.ke) r0;	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x0056;
    L_0x0054:
        monitor-exit(r6);	 Catch:{ all -> 0x0043 }
        goto L_0x000c;
    L_0x0056:
        r1 = r8.M;	 Catch:{ all -> 0x0043 }
        r1.add(r3, r0);	 Catch:{ all -> 0x0043 }
        monitor-exit(r6);	 Catch:{ all -> 0x0043 }
        goto L_0x000c;
    L_0x005d:
        r0 = r2;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.ks.a(java.lang.String, float):void");
    }

    public ke a(String str) {
        if (!this.J.equals("") && this.f != null && TextUtils.equals(this.f.v(), str)) {
            return this.f;
        }
        int size = this.M.size();
        ke keVar = null;
        for (int i = 0; i < size; i++) {
            keVar = (ke) this.M.get(i);
            if (keVar != null) {
                if (TextUtils.equals(keVar.v(), str)) {
                    return keVar;
                }
                keVar = null;
            }
        }
        return keVar;
    }

    public void setScrollGestureEnable(boolean z) {
        this.aq = z;
    }

    public void setFlingGestureEnabled(boolean z) {
        this.ap = z;
    }

    public void setZoomGestureEnable(boolean z) {
        this.ar = z;
    }

    public void setSkewGestureEnable(boolean z) {
        this.as = z;
    }

    public void setRotateGestureEnable(boolean z) {
        this.at = z;
    }

    public void setAllGestureEnable(boolean z) {
        this.au = z;
    }

    public void setCompassEnable(boolean z) {
        this.W = z;
        getMap().f(z);
        getMap().a();
    }

    public boolean k() {
        return this.as;
    }

    public boolean l() {
        return this.at;
    }

    public String a(float f, float f2) {
        String v;
        synchronized (this.e) {
            if (this.J.equals("") || this.f == null || !this.f.a(f, f2)) {
                for (int size = this.M.size() - 1; size >= 0; size--) {
                    ke keVar = (ke) this.M.get(size);
                    if (keVar != null && keVar.a() && (keVar instanceof kd) && keVar.a(f, f2)) {
                        v = keVar.v();
                        break;
                    }
                }
                v = null;
            } else {
                v = "";
            }
        }
        return v;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.m != null) {
            this.m.a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCamerChangeListener(boolean z) {
        if (!z || z()) {
            getMap().a(this.aD);
        } else {
            getMap().a(null);
        }
    }

    public void d() {
        getMap().a(null);
        this.af = true;
        super.d();
        pl.a();
    }

    public void c() {
        super.c();
    }

    public void b() {
        super.b();
        this.aI = 0;
        this.aH = false;
    }

    public void m() {
        if (this.s != null) {
            this.s.removeCallbacksAndMessages(null);
        }
        if (this.S != null) {
            this.S.clear();
            this.S = null;
        }
        n();
        if (this.R != null) {
            this.R.clear();
        }
    }

    public void n() {
        if (this.M != null) {
            Iterator it = this.M.iterator();
            while (it.hasNext()) {
                ke keVar = (ke) it.next();
                if (keVar != null) {
                    keVar.d();
                }
                it.remove();
            }
            this.N.clear();
            this.O.clear();
            this.P.clear();
        }
    }

    public void c(Class<? extends ke> cls) {
        if (cls != null) {
            synchronized (this.e) {
                Iterator it = this.M.iterator();
                while (it.hasNext()) {
                    ke keVar = (ke) it.next();
                    if (keVar != null && cls.isInstance(keVar)) {
                        keVar.d();
                        it.remove();
                        this.N.remove(keVar);
                        this.O.remove(keVar);
                        this.P.remove(keVar);
                    }
                }
            }
            getMap().a();
        }
    }

    public void a() {
        f();
    }

    public void setInfoWindowStill(boolean z) {
        this.am = z;
    }

    public void setCompassExtraPadding(int i) {
        this.al = i;
        getMap().e(this.ak, i);
        f();
    }

    public boolean a(GL10 gl10) {
        c(gl10);
        boolean a = super.a(gl10);
        if (this.aM != null) {
            b(gl10);
        }
        return a;
    }

    public void setOnSurfaceChangedListener(mp.a aVar) {
        this.aP = aVar;
    }

    private boolean d(float f, float f2) {
        if (this.au) {
            return getMap().a(f, f2);
        }
        return false;
    }

    private void w() {
        int h = getMap().h();
        this.aE = true;
        this.aF = true;
        if (h <= this.aw) {
            this.aF = false;
        } else if (h >= ne.b(this.av)) {
            this.aE = false;
        }
        if (this.L != null) {
            lh lhVar = new lh();
            lhVar.a = 0;
            lhVar.b = this.aE;
            lhVar.c = this.aF;
            this.L.a(lhVar);
        }
    }

    private void x() {
        if (this.L != null) {
            lh lhVar = new lh();
            lhVar.a = 0;
            lhVar.b = this.aE;
            lhVar.c = this.aF;
            this.L.a(lhVar);
        }
    }

    public void a(int i) {
        if (this.az != i) {
            this.az = i;
            if (this.L != null) {
                lh lhVar = new lh();
                lhVar.a = 1;
                lhVar.d = getMap().h();
                lhVar.e = getMap().s().a(new Point(0, getHeight() / 2), new Point(getWidth(), getHeight() / 2));
                this.L.a(lhVar);
            }
        }
    }

    public boolean getZoomInEnable() {
        return this.aE;
    }

    public boolean getZoomOutEnable() {
        return this.aF;
    }

    public le getIndoorFloorControlManager() {
        return this.ah;
    }

    public oj getIndoorMapControl() {
        return this.ax;
    }

    public void a(int i, int i2) {
        if (i != 0 && i2 != 0) {
            if (this.aU == null) {
                GeoPoint f = getMap().f();
                this.aU = new GeoPoint(f.getLatitudeE6(), f.getLongitudeE6());
            }
            this.aU.setLatitudeE6(i);
            this.aU.setLongitudeE6(i2);
        }
    }

    public GeoPoint getNaviCenter() {
        if (this.aU == null) {
            if (this.aQ == Integer.MIN_VALUE) {
                this.aQ = this.A / 2;
            }
            if (this.aR == Integer.MIN_VALUE) {
                this.aR = this.B / 2;
            }
            this.aU = getMap().s().a(new DoublePoint((double) this.aQ, (double) this.aR));
        }
        return this.aU;
    }

    public int getNaviFixX2D() {
        return this.aS;
    }

    public int getNaviFixY2D() {
        return this.aT;
    }

    public int getNaviFixX() {
        return this.aQ;
    }

    public int getNaviFixY() {
        return this.aR;
    }

    public void b(int i, int i2) {
        this.aQ = i;
        this.aR = i2;
    }

    public void c(int i, int i2) {
        this.aS = i;
        this.aT = i2;
    }

    public void setMapEventHandler(lh.a aVar) {
        this.L = aVar;
    }

    private boolean a(kc kcVar, kd kdVar, List<kd> list) {
        pa paVar = kdVar.x;
        if (paVar == null || !paVar.x() || !a(true, kcVar, kdVar, list) || a(false, kcVar, kdVar, list)) {
            return false;
        }
        return true;
    }

    private boolean a(boolean z, kc kcVar, kd kdVar, List<kd> list) {
        hh s = getMap().s();
        CharSequence v = kdVar.v();
        int w = kdVar.x.w();
        Rect a;
        if (z) {
            a = kcVar.a(s);
        } else {
            a = kcVar.b(s);
        }
        for (kd kdVar2 : list) {
            if (!TextUtils.equals(kdVar2.v(), v)) {
                pa paVar = kdVar2.x;
                if (paVar != null) {
                    int w2 = paVar.w();
                    if (w2 > 0 && w2 <= w && a(a, kdVar2.m())) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private boolean a(Rect rect, Rect rect2) {
        if (rect2 == null || rect == null) {
            return false;
        }
        return Rect.intersects(rect2, rect);
    }

    public void e() {
        getMap().k();
        if (this.D != null) {
            this.D.a();
        }
    }

    public void setOnDismissCallback(ac$e ac_e) {
        this.T = ac_e;
    }

    public void setOnIndoorMapStateChangeCallback(f fVar) {
        this.ai = fVar;
    }

    private void e(float f, float f2) {
        TappedElement b = getMap().b(f, f2);
        if (b != null && 1 == b.type && this.ay != null) {
            oz ozVar = new oz();
            ozVar.a = b.name;
            GeoPoint a = com.tencent.map.lib.util.d.a(b.pixelX, b.pixelY);
            if (a != null) {
                ozVar.b = new ox(((double) a.getLatitudeE6()) / 1000000.0d, ((double) a.getLongitudeE6()) / 1000000.0d);
            }
            this.ay.a(ozVar);
        }
    }

    public void setOnAnnocationClickedCallback(k kVar) {
        this.ay = kVar;
    }

    private boolean y() {
        boolean z = false;
        if (z()) {
            GeoPoint f = getMap().f();
            int h = getMap().h();
            if (a(f) && h > 5) {
                z = true;
            }
            if (z) {
                lo.a c = this.aV.c();
                boolean p = p();
                if (!this.aV.b()) {
                    c.a(c.f);
                } else if (p) {
                    c.a(c.g);
                } else {
                    c.a(c.f);
                }
            }
        }
        return z;
    }

    private boolean z() {
        return this.aV.a();
    }

    private boolean a(GeoPoint geoPoint) {
        ln.c(((double) geoPoint.getLongitudeE6()) / 1000000.0d, ((double) geoPoint.getLatitudeE6()) / 1000000.0d);
        return !o();
    }

    public boolean o() {
        boolean z = false;
        for (ox oxVar : getScreenFrontierPoint()) {
            z |= ln.a(oxVar.b, oxVar.a);
            if (z) {
                return true;
            }
        }
        return z;
    }

    public boolean p() {
        boolean z = false;
        for (ox oxVar : getScreenFrontierPoint()) {
            z |= ln.b(oxVar.b, oxVar.a);
            if (z) {
                return true;
            }
        }
        return z;
    }

    public ox[] getScreenFrontierPoint() {
        r1 = new ox[8];
        r2 = new DoublePoint[8];
        float width = (float) getWidth();
        float height = (float) getHeight();
        r2[0] = new DoublePoint(0.0d, 0.0d);
        r2[1] = new DoublePoint((double) (width / 2.0f), 0.0d);
        r2[2] = new DoublePoint((double) width, 0.0d);
        r2[3] = new DoublePoint((double) width, (double) (height / 2.0f));
        r2[4] = new DoublePoint((double) width, (double) height);
        r2[5] = new DoublePoint((double) (width / 2.0f), (double) height);
        r2[6] = new DoublePoint(0.0d, (double) height);
        r2[7] = new DoublePoint(0.0d, (double) (height / 2.0f));
        for (int i = 0; i < 8; i++) {
            GeoPoint a = getMap().s().a(r2[i]);
            r1[i] = new ox(((double) a.getLatitudeE6()) / 1000000.0d, ((double) a.getLongitudeE6()) / 1000000.0d);
        }
        return r1;
    }

    public boolean q() {
        return this.aa;
    }

    public void setShouldShowWorldMap(boolean z) {
        this.aa = z;
    }

    public void setLogoAndScaleManager(lg lgVar) {
        this.ag = lgVar;
    }

    public void setIndoorFloorControlManager(le leVar) {
        this.ah = leVar;
    }

    private void b(boolean z) {
        if (this.ad == null) {
            this.ad = a(this.aL, z);
        }
    }

    public void r() {
        if (this.ae == null) {
            this.ae = new kx(new kw(this));
            a(this.ae);
            new kz(getContext().getApplicationContext(), this.ae).a();
        }
    }

    public void s() {
        if (this.ae != null) {
            this.ae.e();
            this.ae = null;
        }
    }

    public boolean t() {
        return this.ae != null;
    }

    void u() {
        if (this.ad != null) {
            this.ad.a();
            this.ad = null;
        }
    }

    lp a(nj njVar, boolean z) {
        if (this.af) {
            return null;
        }
        if (this.ab == null) {
            this.ab = new lq(this);
        }
        return this.ab.a(njVar, z);
    }

    public void a(nl.c cVar) {
        if (cVar != null) {
            this.aV.a(cVar.a(), cVar.c(), cVar.b(), cVar.e(), cVar.f(), cVar.d(), cVar.g());
            this.aV.a = true;
            v();
            if (lo.b && !b(this.aV.c().a())) {
                u();
                b(false);
            }
        }
    }

    public boolean b(String str) {
        return str != null && str.equals("taiwanmap");
    }

    public void setGestureScaleByMapCenter(boolean z) {
        this.aZ = z;
    }
}
