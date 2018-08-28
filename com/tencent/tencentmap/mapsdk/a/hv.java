package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.a;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNICallback;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.f;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.gl.b;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.map.lib.util.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.opengles.GL10;

public class hv implements gy, hf {
    private String A;
    private boolean B = true;
    private boolean C = false;
    private int D = 0;
    private int E = 0;
    private Rect F;
    private float G = 0.5f;
    private float H = 0.5f;
    private boolean I = true;
    private int J = 18;
    private int K = 14;
    private boolean L = false;
    private hq a;
    private b b;
    private ht c;
    private im d;
    private hu e;
    private hs f;
    private WeakReference<hp> g;
    private ha h;
    private Rect i;
    private boolean j;
    private boolean k;
    private Context l;
    private if m;
    private d n;
    private ic o;
    private LinkedBlockingQueue<a> p;
    private ih q;
    private a r;
    private boolean s = false;
    private c<Integer, Integer> t;
    private boolean u = true;
    private com.tencent.map.lib.b v;
    private boolean w = true;
    private b x;
    private c y;
    private ho z;

    public hq i() {
        return this.a;
    }

    public hv(Context context, hp hpVar) {
        this.l = context.getApplicationContext();
        this.g = new WeakReference(hpVar);
        this.a = new hq(context, this);
        this.o = new ic(this);
        this.i = new Rect();
        this.e = new hu(this);
        this.h = new ha(this.o, this);
        this.c = new ht(this);
        this.a.a(this.c);
        this.n = new d(this, null);
        this.p = new LinkedBlockingQueue();
    }

    public boolean a(Context context, a aVar, jg jgVar) {
        this.r = aVar;
        if (this.r.d() != null) {
            d.a = this.r.d().a();
        }
        d.c("initEngine");
        ih a = aVar.a();
        this.q = a;
        this.a.a(aVar.b());
        this.b = new b(100);
        this.v = aVar.c();
        this.m = new if(context, this, a, this.v);
        String c = a.c();
        String a2 = a.a();
        String b = a.b();
        this.m.a();
        boolean a3 = this.a.a(context, this.m, c, a2, b, 2.0f);
        this.m.b();
        this.f = new hs(this, this.b, this.a);
        if (this.d == null) {
            this.d = new im(this, jgVar);
        }
        if (this.z == null) {
            this.z = new hl(this, this.r.b());
        }
        this.a.n();
        this.a.e(true);
        this.a.b(ic.a.a);
        this.a.c(ic.a.d);
        m(false);
        this.c.a(this);
        return a3;
    }

    public boolean a(Context context, a aVar) {
        return a(context, aVar, aVar.b());
    }

    public boolean j() {
        if (this.a == null) {
            return false;
        }
        return this.a.b();
    }

    public b k() {
        return this.b;
    }

    public Context l() {
        return this.l;
    }

    public void m() {
        if (this.a != null) {
            this.s = true;
            this.B = true;
            if (this.u) {
                this.c.c();
                this.u = false;
            } else {
                this.c.d();
            }
            if (!(this.g == null || this.g.get() == null)) {
                ((hp) this.g.get()).a();
            }
            if (this.j) {
                this.a.i();
            }
            if (this.k && this.d != null) {
                this.d.d();
            }
            if (this.z != null) {
                this.z.c();
            }
        }
    }

    public void n() {
        if (this.a != null) {
            this.s = false;
            this.B = false;
            if (this.z != null) {
                this.z.d();
            }
            this.c.e();
            this.a.j();
            if (this.k && this.d != null) {
                this.d.c();
            }
        }
    }

    public void o() {
        this.c.b(this);
        if (this.y != null) {
            this.y.a();
        }
        this.c.f();
        this.u = true;
        if (this.z != null) {
            this.z.e();
        }
        if (this.d != null) {
            this.d.f();
        }
        if (this.a != null) {
            this.a.a();
        }
        this.l = null;
    }

    public void a(a aVar) {
        try {
            this.p.put(aVar);
        } catch (InterruptedException e) {
        }
    }

    public void a(boolean z) {
        synchronized (this.a) {
            this.a.f(z);
        }
    }

    public ht a() {
        return this.c;
    }

    public WeakReference<hp> b() {
        return this.g;
    }

    public ic e() {
        return this.o;
    }

    public hu c() {
        return this.e;
    }

    public hq f() {
        return this.a;
    }

    public hh d() {
        return this.h;
    }

    public Rect g() {
        return this.i;
    }

    public float h() {
        if (this.l == null) {
            return 1.0f;
        }
        return SystemUtil.getDensity(this.l);
    }

    public if p() {
        return this.m;
    }

    public void a(GL10 gl10) {
        if (this.a != null) {
            this.b.a();
        }
    }

    public void a(int i, int i2) {
        if (this.a != null) {
            this.s = true;
            this.i.set(0, 0, i, i2);
            a(0, 0, i, i2, false);
            this.c.v();
        }
    }

    public void a(Rect rect) {
        if (this.i != null && rect != null) {
            this.F = rect;
            int width = this.i.width();
            int height = this.i.height();
            a(rect.left, rect.bottom, (width - rect.right) - rect.left, (height - rect.bottom) - rect.top, true);
        }
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        this.a.a(i, i2, i3, i4);
        this.D = i3;
        this.E = i4;
        if (z) {
            a(this.G, this.H, this.I);
        }
    }

    public Rect q() {
        return this.F;
    }

    public void a(float f, float f2, boolean z) {
        this.G = f;
        this.H = f2;
        double d = (double) f;
        double d2 = (double) f2;
        if (this.i != null) {
            if (this.E > 0) {
                d2 = 0.5d - (((0.5d - d2) * ((double) this.i.height())) / ((double) this.E));
            }
            if (this.D > 0) {
                d = 0.5d - (((0.5d - d) * ((double) this.i.width())) / ((double) this.D));
            }
        }
        this.a.b((float) d, (float) d2, z);
    }

    public void b(int i, int i2) {
        if (this.i != null) {
            this.i.set(0, 0, i, i2);
        }
    }

    private void c(GL10 gl10) {
        if (this.p.size() != 0) {
            Object obj = 1;
            while (obj != null) {
                a aVar = (a) this.p.poll();
                if (aVar != null) {
                    try {
                        aVar.a(gl10);
                    } catch (Exception e) {
                    }
                } else {
                    obj = null;
                }
            }
        }
    }

    public boolean b(GL10 gl10) {
        if (this.a == null) {
            return false;
        }
        boolean z;
        synchronized (this.a) {
            this.c.C();
            c(gl10);
        }
        this.a.u();
        if (this.a.v() || this.s) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            e a = this.n.a(gl10);
            if (a == null) {
                this.e.a(this.f, this.h);
            } else if (this.n != null) {
                this.n.a(gl10, this.f, this.h);
            }
            synchronized (this.a) {
                this.a.c();
                this.s = false;
            }
            if (!(this.n.a() || a == null)) {
                if (a.c()) {
                    e.a(a, 0);
                } else if (this.a.g() || e.a(a) >= 100) {
                    e.a(a, 0);
                    this.n.b(gl10, this.f, this.h);
                } else {
                    e.b(a);
                }
            }
            if (this.f != null) {
                this.f.c();
            }
        }
        if (this.f != null) {
            this.f.a();
        }
        return z;
    }

    public void r() {
        this.s = true;
    }

    public int s() {
        if (this.a != null) {
            return this.a.d();
        }
        return -1;
    }

    public void t() {
        if (this.a != null) {
            this.a.e();
        }
    }

    public void u() {
        if (this.a != null) {
            this.a.f();
        }
    }

    public boolean v() {
        return this.k;
    }

    public void b(boolean z) {
        if (this.d != null) {
            this.k = z;
            if (z) {
                G();
                this.d.b();
                return;
            }
            H();
            this.d.e();
        }
    }

    public int a(Polygon2D polygon2D) {
        if (this.a == null || polygon2D == null) {
            return -1;
        }
        polygon2D.borderWidth *= SystemUtil.getDensity(this.l);
        int a = this.a.a(polygon2D);
        if (this.t == null) {
            this.t = new c();
        }
        this.t.a(Integer.valueOf(a), Integer.valueOf(polygon2D.borldLineId));
        return a;
    }

    public void b(Polygon2D polygon2D) {
        if (this.a != null && polygon2D != null) {
            polygon2D.borderWidth *= SystemUtil.getDensity(this.l);
            this.a.b(polygon2D);
        }
    }

    public int a(int i, int i2, int i3, int i4, int i5, float f) {
        int i6 = 255;
        if (this.a == null) {
            return -1;
        }
        int i7;
        int i8;
        int i9;
        int i10;
        if (i < 0) {
            i7 = 0;
        } else {
            i7 = i;
        }
        if (i7 > 255) {
            i8 = 255;
        } else {
            i8 = i7;
        }
        if (i2 < 0) {
            i7 = 0;
        } else {
            i7 = i2;
        }
        if (i7 > 255) {
            i9 = 255;
        } else {
            i9 = i7;
        }
        if (i3 < 0) {
            i7 = 0;
        } else {
            i7 = i3;
        }
        if (i7 > 255) {
            i10 = 255;
        } else {
            i10 = i7;
        }
        if (i4 < 0) {
            i7 = 0;
        } else {
            i7 = i4;
        }
        if (i7 <= 255) {
            i6 = i7;
        }
        MaskLayer maskLayer = new MaskLayer();
        maskLayer.color = new int[]{i8, i9, i10, 255 - i6};
        if (this.i != null) {
            maskLayer.width = this.i.width();
            maskLayer.height = this.i.height();
        }
        maskLayer.zIndex = f;
        maskLayer.layer = i5;
        i6 = this.a.a(maskLayer);
        this.e.a(i6, i5);
        return i6;
    }

    public void c(int i, int i2) {
        int i3 = 255;
        if (this.a != null) {
            int i4;
            if (i2 < 0) {
                i4 = 0;
            } else {
                i4 = i2;
            }
            if (i4 <= 255) {
                i3 = i4;
            }
            i3 = 255 - i3;
            if (i3 == 0) {
                i3 = 1;
            }
            this.a.b(i, i3);
        }
    }

    public void a(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void b(int i) {
        if (this.a != null && this.t != null) {
            int intValue;
            if (((Integer) this.t.a(Integer.valueOf(i))) != null) {
                intValue = ((Integer) this.t.a(Integer.valueOf(i))).intValue();
            } else {
                intValue = 0;
            }
            this.a.a(i, intValue);
        }
    }

    public void a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        if (this.y == null) {
            this.y = new c(this);
        }
        this.y.a(list, list2);
    }

    public void w() {
        if (this.y == null) {
            this.y = new c(this);
        }
        this.y.b();
    }

    public List<Integer> a(Rect rect, int i) {
        return this.a.a(rect, i);
    }

    public void a(List<BlockRouteCityData> list) {
        this.a.a(list);
    }

    public void c(boolean z) {
        this.a.g(z);
    }

    public String a(GeoPoint geoPoint) {
        if (!(this.r == null || this.v == null)) {
            String a = this.v.a(geoPoint);
            if (a != null) {
                return a;
            }
        }
        if (this.a == null) {
            return "";
        }
        return this.a.a(geoPoint);
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.e(str);
        }
    }

    public void d(boolean z) {
        if (this.C != z) {
            this.C = z;
            if (this.a != null) {
                this.a.a(z);
            }
        }
    }

    private void G() {
        if (this.a != null) {
            this.a.k();
        }
    }

    private void H() {
        if (this.a != null) {
            this.a.l();
        }
    }

    public void x() {
        this.c.z();
        this.s = true;
    }

    public void e(boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        this.w = z;
        if (this.L) {
            if (!(z && this.c.t())) {
                z2 = false;
            }
            m(z2);
            return;
        }
        if (z || this.c.t()) {
            z3 = true;
        }
        m(z3);
    }

    public void f(boolean z) {
        this.L = z;
    }

    public void a(double d) {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = ((double) this.c.p()) > 1.0E-10d;
        if (this.L) {
            if (!(this.w && z3)) {
                z = false;
            }
            m(z);
        } else {
            if (this.w || z3) {
                z2 = true;
            }
            m(z2);
        }
        if (!jc.a() && this.c.t()) {
            this.a.n();
        }
    }

    private void m(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public void g(boolean z) {
        if (this.a != null) {
            this.a.d(z);
        }
    }

    public String[] y() {
        if (this.a != null) {
            return this.a.p();
        }
        return null;
    }

    public String b(GeoPoint geoPoint) {
        if (this.a != null) {
            return this.a.b(geoPoint);
        }
        return null;
    }

    public void a(e eVar) {
        if (this.a != null) {
            this.a.a(eVar);
        }
    }

    public int a(int i, boolean z) {
        if (this.a != null) {
            return this.a.c(i, z);
        }
        return -1;
    }

    public void c(int i) {
        if (this.a != null) {
            this.a.d(i);
            this.s = true;
        }
    }

    public void d(int i) {
        if (this.a != null) {
            this.a.e(i);
        }
    }

    public void a(JNICallback.d dVar) {
        if (this.a != null) {
            this.a.a(dVar);
        }
    }

    public void a(j jVar) {
        if (this.a != null) {
            this.a.a(jVar);
        }
    }

    public void a(JNICallback.b bVar) {
        if (this.a != null) {
            this.a.a(bVar);
        }
    }

    public void a(JNICallback.c cVar) {
        if (this.a != null) {
            this.a.a(cVar);
        }
    }

    public void a(k kVar) {
        if (this.a != null) {
            this.a.a(kVar);
        }
    }

    public void a(f fVar) {
        if (this.a != null) {
            this.a.a(fVar);
        }
    }

    public void d(int i, int i2) {
        if (this.a != null) {
            this.a.d(i, i2);
        }
    }

    public void h(boolean z) {
        this.c.a(z);
    }

    public void e(int i, int i2) {
        if (this.a != null) {
            this.a.c(i, i2);
        }
    }

    public void b(String str) {
        if (this.a != null) {
            this.a.d(str);
        }
    }

    public MapLanguage z() {
        if (this.x == null) {
            this.x = new b(this);
        }
        return this.x.a();
    }

    public void a(MapLanguageChangeListener mapLanguageChangeListener) {
        if (this.x == null) {
            this.x = new b(this);
        }
        this.x.a(mapLanguageChangeListener);
    }

    public void b(MapLanguageChangeListener mapLanguageChangeListener) {
        if (this.x == null) {
            this.x = new b(this);
        }
        this.x.b(mapLanguageChangeListener);
    }

    public TappedElement a(float f, float f2) {
        if (this.a != null) {
            return this.a.a(f, f2);
        }
        return null;
    }

    public String toString() {
        return this.o != null ? this.o.toString() : "";
    }

    public hs A() {
        return this.f;
    }

    public void c(String str) {
        this.A = str;
    }

    public String B() {
        return this.A;
    }

    public void i(boolean z) {
        if (this.r != null) {
            if (this.z == null) {
                this.z = new hl(this, this.r.b());
            }
            this.z.a(z);
        }
    }

    public boolean C() {
        if (this.z == null) {
            return false;
        }
        return this.z.a();
    }

    public void D() {
        if (this.z != null && this.z.a()) {
            this.z.b();
        }
    }

    a E() {
        return this.r;
    }

    public ih F() {
        return this.q;
    }

    public void j(boolean z) {
        if (this.a != null) {
            this.a.h(z);
        }
    }

    public void k(boolean z) {
        if (this.a != null) {
            this.a.i(z);
        }
    }

    public void l(boolean z) {
        if (this.c != null) {
            this.c.c(z);
        }
    }
}
