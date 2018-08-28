package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.e;
import com.tencent.map.lib.gl.JNICallback.g;
import com.tencent.map.lib.gl.d;
import com.tencent.map.lib.util.MathUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.tencentmap.mapsdk.a.hk.a;
import com.tencent.tencentmap.mapsdk.a.ic.b;
import com.tencent.tencentmap.mapsdk.a.ic.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class ht implements g, gh, hg, a, ie {
    private static int c = 116307503;
    private static int d = 39984186;
    private float A = 0.5f;
    private boolean B = true;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private Runnable G;
    private boolean H = false;
    public hk a;
    public hx b;
    private List<hb> e;
    private List<gx> f;
    private List<d> g;
    private List<gz> h;
    private List<he> i;
    private List<hd> j;
    private List<hg> k;
    private List<id> l;
    private List<ib> m;
    private List<hc> n;
    private List<hf> o;
    private boolean p = true;
    private Stack<ic> q = new Stack();
    private WeakReference<hp> r;
    private gy s;
    private ic t;
    private ha u;
    private Rect v;
    private Rect w;
    private Handler x = null;
    private a y = null;
    private float z = 0.5f;

    public ht(gy gyVar) {
        this.s = gyVar;
        this.r = gyVar.b();
        this.t = gyVar.e();
        this.u = (ha) gyVar.d();
        this.v = gyVar.g();
        this.a = new hk(this);
        this.a.a(this);
        a(this.a);
        this.b = new hx(gyVar);
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.n = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        a(hr.a(1));
        this.x = new Handler();
    }

    public int a(int i, int i2, int i3, int i4) {
        this.C = i;
        this.D = i2;
        this.E = i3;
        this.F = i4;
        if (this.v == null || this.v.width() <= 0 || this.v.height() <= 0) {
            a(new 1(this));
            if (!(this.s instanceof hv)) {
                return -2;
            }
            Context l = ((hv) this.s).l();
            return (i + i3 > SystemUtil.getWindowWidth(l) || i2 + i4 > SystemUtil.getWindowHeight(l)) ? -1 : 0;
        } else if (i + i3 > this.v.width() || i2 + i4 > this.v.height()) {
            return -1;
        } else {
            PointF E = E();
            a(E.x, E.y, false);
            return 0;
        }
    }

    private PointF E() {
        int height;
        int i;
        if (this.v != null) {
            int width = this.v.width();
            height = this.v.height();
            i = width;
        } else {
            height = 0;
            i = 0;
        }
        int i2 = (((i - this.C) - this.E) / 2) + this.C;
        int i3 = (((height - this.D) - this.F) / 2) + this.D;
        if (i == 0 || height == 0) {
            return new PointF(0.5f, 0.5f);
        }
        return new PointF((((float) i2) * 1.0f) / ((float) i), (((float) i3) * 1.0f) / ((float) height));
    }

    public Rect b() {
        return new Rect(this.C, this.D, this.E, this.F);
    }

    private boolean F() {
        return this.v != null && this.v.width() > 0 && this.v.height() > 0;
    }

    public hk c() {
        this.a.a();
        return this.a;
    }

    public void d() {
        if (this.a != null) {
            this.a.d();
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.c();
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.b();
        }
    }

    public hk g() {
        return this.a;
    }

    public void a(id idVar) {
        if (idVar != null) {
            if (this.l == null) {
                this.l = new CopyOnWriteArrayList();
            }
            synchronized (this.l) {
                if (!this.l.contains(idVar)) {
                    this.l.add(idVar);
                }
            }
        }
    }

    private void G() {
        if (this.l != null) {
            for (id idVar : this.l) {
                if (idVar != null) {
                    try {
                        idVar.a(this.t);
                    } catch (Exception e) {
                    }
                }
            }
            z();
        }
    }

    public void h() {
        try {
            ic icVar = (ic) this.t.clone();
            com.tencent.map.lib.d.a("mapParam stack saveMapParam:" + icVar.toString());
            this.q.push(icVar);
        } catch (CloneNotSupportedException e) {
        }
    }

    public void i() {
        try {
            ic icVar = (ic) this.q.pop();
            if (icVar.j() != this.t.j()) {
                a(c.c);
            } else if (icVar.i() != this.t.i()) {
                a(c.b);
            }
            if (icVar.c() != this.t.c()) {
                a((double) icVar.c());
            }
            if (icVar.d() != this.t.d()) {
                b((double) icVar.d());
            }
            this.t.a(icVar);
            G();
        } catch (Exception e) {
        }
    }

    public void a(boolean z) {
        this.B = z;
        L();
    }

    public void a(Rect rect) {
        if (F()) {
            float a = a(rect, this.v);
            this.t.a(rect);
            this.t.e(a);
        }
    }

    public ic j() {
        try {
            return (ic) this.t.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void a(hc hcVar) {
        if (hcVar != null) {
            synchronized (this.n) {
                if (!this.n.contains(hcVar)) {
                    this.n.add(hcVar);
                }
            }
        }
    }

    public void a(double d) {
        L();
        for (hc hcVar : this.n) {
            if (hcVar != null) {
                try {
                    hcVar.a(d);
                } catch (Exception e) {
                }
            }
        }
    }

    public void a(hf hfVar) {
        if (hfVar != null) {
            synchronized (this.o) {
                com.tencent.map.lib.d.a("skew addSkewListener");
                if (!this.o.contains(hfVar)) {
                    this.o.add(hfVar);
                }
            }
        }
    }

    public void b(hf hfVar) {
        synchronized (this.o) {
            com.tencent.map.lib.d.a("skew addSkewListener");
            this.o.remove(hfVar);
        }
    }

    public void b(double d) {
        L();
        com.tencent.map.lib.d.a("skew notifySkew");
        for (hf hfVar : this.o) {
            if (hfVar != null) {
                try {
                    hfVar.a(d);
                } catch (Exception e) {
                }
            }
        }
    }

    public void a(e eVar) {
        this.b.a(eVar);
    }

    public void k() {
        GeoPoint geoPoint = new GeoPoint(d, c);
        this.t.a(this.s.g(), geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 18);
        G();
        L();
    }

    public void a(int i) {
        if (this.t.b(i)) {
            a(c.c);
        }
    }

    public float l() {
        return this.t.i();
    }

    public void a(int i, int i2) {
        a(i, i2, 1);
    }

    public void a(int i, int i2, int i3) {
        this.t.a(i, i2, false);
        if (i3 == 1) {
            c(i3);
            G();
        }
    }

    public void a(float f, float f2) {
        if (this.s != null) {
            hq f3 = this.s.f();
            if (f3 != null) {
                f3.a(f, f2, false);
                G();
            }
        }
    }

    public float a(Rect rect, Rect rect2) {
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
        Rect rect3 = new Rect();
        rect3.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        rect3.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        return (float) this.s.f().a(rect3, rect2);
    }

    public void a(Rect rect, Rect rect2, boolean z) {
        if (F()) {
            Rect rect3 = new Rect(this.v);
            if (rect2 != null) {
                rect3.left += rect2.left;
                rect3.right -= rect2.right;
                rect3.top += rect2.top;
                rect3.bottom -= rect2.bottom;
            }
            GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
            GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
            Rect rect4 = new Rect();
            rect4.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            rect4.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            this.s.f().a(rect4, rect3, z);
            z();
        }
    }

    public void a(float f) {
        a(this.t.c(f));
    }

    public int m() {
        return this.t.j();
    }

    public GeoPoint n() {
        return this.t.p();
    }

    public void b(float f) {
        f((double) f);
    }

    public float o() {
        return this.t.c();
    }

    public void c(float f) {
        d((double) f);
    }

    public float p() {
        return this.t.d();
    }

    public float q() {
        return this.t.k();
    }

    public void a(double d, double d2) {
        this.s.f().a((float) d, (float) d2, false);
        c(1);
        G();
    }

    public void c(double d) {
        if (d != 0.0d) {
            float b = this.t.b(this.t.d() + ((float) d));
            G();
            b((double) b);
        }
    }

    public void d(double d) {
        if (d != ((double) this.t.d())) {
            float b = this.t.b((float) d);
            G();
            b((double) b);
        }
    }

    public void e(double d) {
        if (d != 0.0d) {
            float a = this.t.a(this.t.c() + ((float) d));
            G();
            a((double) a);
        }
    }

    public void f(double d) {
        if (MathUtil.calShortestAngleDistance(d - ((double) this.t.c())) != 0.0d) {
            float a = this.t.a((float) d);
            G();
            a((double) a);
        }
    }

    public void g(double d) {
        h((double) (this.t.i() * ((float) d)));
    }

    public void h(double d) {
        a((float) d);
    }

    private void H() {
        this.t.a(0.0f);
        this.t.b(0.0f);
        a(0.0d);
        b(0.0d);
        G();
    }

    public void b(hi hiVar) {
        this.a.j();
        c(hiVar);
    }

    public void i(double d) {
        this.a.j();
        c(new hi(s$l.AppCompatTheme_checkboxStyle, new double[]{0.0d, d}));
    }

    public void j(double d) {
        this.a.j();
        c(new hi(s$l.AppCompatTheme_ratingBarStyleSmall, new double[]{d}));
    }

    public void a(double d, double d2, double d3, double d4, double d5) {
        if (t()) {
            this.a.j();
            c(new hi(s$l.AppCompatTheme_checkedTextViewStyle, new double[]{d, d2, d3, d4, d5}));
        }
    }

    public void a(double d, double d2, double d3, double d4, double d5, Runnable runnable) {
        this.a.j();
        float width = ((float) this.s.g().width()) / 2.0f;
        float height = ((float) this.s.g().height()) / 2.0f;
        b q = D().q();
        if (this.H) {
            double a;
            double b;
            if (q != null) {
                a = (double) (width + ((q.a() * width) * 2.0f));
                b = (double) (((q.b() * height) * 2.0f) + height);
            } else {
                a = (double) width;
                b = (double) height;
            }
            d5 = b;
            d4 = a;
            d3 = b;
            d2 = a;
        }
        c(new hi(s$l.AppCompatTheme_buttonStyleSmall, new double[]{d, d2, d3, d4, d5}));
        hi hiVar = new hi(runnable);
        hiVar.e = false;
        hiVar.c = 0;
        c(hiVar);
    }

    public void a(Runnable runnable) {
        a(runnable, null);
    }

    public void a(Runnable runnable, hj hjVar) {
        if (I()) {
            this.s.f().b(((float) this.s.g().width()) / 2.0f, ((float) this.s.g().height()) / 2.0f);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void a(float f, float f2, Runnable runnable) {
        if (this.H) {
            b q = D().q();
            if (q != null) {
                f = ((float) this.s.g().width()) * (q.a() + 0.5f);
                f2 = ((float) this.s.g().height()) * (q.b() + 0.5f);
            } else {
                a(runnable);
                return;
            }
        }
        a(f, f2, runnable, null);
    }

    public void a(float f, float f2, Runnable runnable, hj hjVar) {
        if (I()) {
            this.s.f().b(f, f2);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void b(Runnable runnable) {
        b(runnable, null);
    }

    public void b(Runnable runnable, hj hjVar) {
        if (J()) {
            this.s.f().t();
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void r() {
        this.a.j();
        a(0.0d, 0.0d, true);
    }

    private void a(double d, double d2, boolean z) {
        double k = k(d - ((double) o()));
        double p = d2 - ((double) p());
        if (k != 0.0d || p != 0.0d) {
            com.tencent.map.lib.d.a("postRotateAndSkew distance:" + k + "," + p);
            c(new 2(this, s$l.AppCompatTheme_checkboxStyle, new double[]{d, d2, 0.0d, 0.0d}, !z, System.currentTimeMillis(), (float) (0.10000000149011612d * k), (float) (0.10000000149011612d * p), k, p, d, d2));
        }
    }

    private double k(double d) {
        double d2 = d % 360.0d;
        if (d2 > 180.0d) {
            return d2 - 360.0d;
        }
        if (d2 < -180.0d) {
            return d2 + 360.0d;
        }
        return d2;
    }

    public void s() {
        d(false);
        r();
    }

    public boolean t() {
        return ((double) Math.abs(p())) > 1.0E-6d || Math.abs(o()) > 1.0f;
    }

    private boolean I() {
        return m() < this.t.m();
    }

    private boolean J() {
        return m() > this.t.l();
    }

    private void d(hi hiVar) {
        int i;
        int i2;
        switch (hiVar.a) {
            case 2:
                if (this.r != null && this.r.get() != null) {
                    ((hp) this.r.get()).a();
                    return;
                }
                return;
            case 3:
                a(hiVar.b[0], hiVar.b[1]);
                return;
            case 4:
                if (hiVar.b.length > 2) {
                    i = (int) hiVar.b[2];
                } else {
                    i = 1;
                }
                a((int) hiVar.b[0], (int) hiVar.b[1], i);
                return;
            case 6:
                if (hiVar.f != null) {
                    hiVar.f.run();
                    return;
                }
                return;
            case s$l.AppCompatTheme_buttonStyle /*100*/:
                g(hiVar.b[0]);
                return;
            case s$l.AppCompatTheme_buttonStyleSmall /*101*/:
                int width = this.s.g().width();
                int height = this.s.g().height();
                i2 = width / 2;
                i = height / 2;
                b q = D().q();
                if (q != null) {
                    i2 = (int) (((float) i2) + (((float) width) * q.a()));
                    i = (int) (((float) i) + (q.b() * ((float) height)));
                }
                double d = ((double) i2) - hiVar.b[1];
                double d2 = ((double) i) - hiVar.b[2];
                double d3 = hiVar.b[3] - ((double) i2);
                double d4 = hiVar.b[4] - ((double) i);
                com.tencent.map.lib.d.a("Debug ScaleFix innerPerform        before   center:" + this.t.p().toString());
                a(d, d2);
                g(hiVar.b[0]);
                com.tencent.map.lib.d.a("Debug ScaleFix innerPerform        after      center:" + this.t.p().toString());
                a(d3, d4);
                com.tencent.map.lib.d.a("Debug ScaleFix finally scale move by:" + d3 + "," + d4 + " curCenter:" + this.t.p().toString());
                return;
            case s$l.AppCompatTheme_checkboxStyle /*102*/:
                e(hiVar.b[0]);
                c(hiVar.b[1]);
                return;
            case s$l.AppCompatTheme_checkedTextViewStyle /*103*/:
                i = this.s.g().width() / 2;
                i2 = this.s.g().height() / 2;
                a(((double) i) - hiVar.b[1], ((double) i2) - hiVar.b[2]);
                e(hiVar.b[0]);
                a(hiVar.b[3] - ((double) i), hiVar.b[4] - ((double) i2));
                return;
            case 104:
                H();
                return;
            case s$l.AppCompatTheme_ratingBarStyleSmall /*108*/:
                h(hiVar.b[0]);
                return;
            case s$l.AppCompatTheme_seekBarStyle /*109*/:
                f(hiVar.b[0]);
                return;
            case s$l.AppCompatTheme_spinnerStyle /*110*/:
                d(hiVar.b[0]);
                return;
            case 120:
                h(hiVar.b[0]);
                a((int) hiVar.b[1], (int) hiVar.b[2]);
                return;
            case 10000:
                if (this.y != null) {
                    this.y.a(hiVar);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void b(int i) {
        if (this.t.a(i)) {
            d(i);
        }
    }

    public void a(float f, float f2, boolean z) {
        this.t.a(f - 0.5f, f2 - 0.5f, z);
        if (z) {
            G();
        }
    }

    public void b(Rect rect) {
        if (this.v != null && rect != null) {
            this.w = rect;
            if (this.s instanceof hv) {
                ((hv) this.s).a(rect);
            }
            G();
        }
    }

    public int u() {
        return this.t.b();
    }

    private void K() {
        for (hb hbVar : this.e) {
            if (hbVar != null) {
                try {
                    hbVar.b_();
                } catch (Exception e) {
                }
            }
        }
        G();
    }

    private void c(int i) {
        for (gx gxVar : this.f) {
            if (gxVar != null) {
                try {
                    gxVar.a(i);
                } catch (Exception e) {
                }
            }
        }
        K();
    }

    public void v() {
        b(this.w);
        for (d dVar : this.g) {
            if (dVar != null) {
                try {
                    dVar.a();
                } catch (Exception e) {
                }
            }
        }
    }

    private void d(boolean z) {
        if (this.h != null) {
            boolean t = t();
            for (gz gzVar : this.h) {
                if (gzVar != null) {
                    try {
                        gzVar.a(t, z);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    public void a(he heVar) {
        if (heVar != null) {
            synchronized (this.i) {
                if (!this.i.contains(heVar)) {
                    this.i.add(heVar);
                }
            }
        }
    }

    public void b(he heVar) {
        synchronized (this.i) {
            this.i.remove(heVar);
        }
    }

    public void a(c cVar) {
        if (cVar != c.a && this.x != null) {
            this.x.post(new 3(this, cVar));
        }
    }

    public void w() {
        for (hd hdVar : this.j) {
            if (hdVar != null) {
                try {
                    hdVar.a();
                } catch (Exception e) {
                }
            }
        }
    }

    public void a(hg hgVar) {
        if (hgVar != null) {
            synchronized (this.k) {
                if (!this.k.contains(hgVar)) {
                    this.k.add(hgVar);
                }
            }
        }
    }

    public void b(hg hgVar) {
        synchronized (this.k) {
            this.k.remove(hgVar);
        }
    }

    public void x() {
        for (hg hgVar : this.k) {
            if (hgVar != null) {
                try {
                    hgVar.a();
                } catch (Exception e) {
                }
            }
        }
    }

    public void a(hb hbVar) {
        if (hbVar != null) {
            synchronized (this.e) {
                if (!this.e.contains(hbVar)) {
                    this.e.add(hbVar);
                }
            }
        }
    }

    public void b(hb hbVar) {
        synchronized (this.e) {
            this.e.remove(hbVar);
        }
    }

    public void a(d dVar) {
        if (dVar != null && !this.g.contains(dVar)) {
            this.g.add(dVar);
        }
    }

    public void b(d dVar) {
        synchronized (this.g) {
            this.g.remove(dVar);
        }
    }

    private void d(int i) {
        for (ib ibVar : this.m) {
            if (ibVar != null) {
                try {
                    ibVar.a(i);
                } catch (Exception e) {
                }
            }
        }
        G();
    }

    public void b(Rect rect, Rect rect2) {
        if (rect != null) {
            if (rect.height() > 0 || rect.width() > 0) {
                a(rect, rect2, false);
            }
            c(1);
        }
    }

    public Rect y() {
        DoublePoint doublePoint = new DoublePoint((double) this.s.g().width(), (double) this.s.g().height());
        GeoPoint a = this.u.a(doublePoint);
        doublePoint.set(0.0d, 0.0d);
        GeoPoint a2 = this.u.a(doublePoint);
        return new Rect(Math.min(a2.getLongitudeE6(), a.getLongitudeE6()), Math.min(a2.getLatitudeE6(), a.getLatitudeE6()), Math.max(a2.getLongitudeE6(), a.getLongitudeE6()), Math.max(a2.getLatitudeE6(), a.getLatitudeE6()));
    }

    public void z() {
        this.a.i();
    }

    public void c(hi hiVar) {
        this.a.a(hiVar);
    }

    public void A() {
        this.a.j();
    }

    public void a(hi hiVar) {
        if (hiVar != null) {
            d(hiVar);
        }
    }

    public void a() {
        x();
    }

    public boolean B() {
        return this.p;
    }

    boolean C() {
        return this.a.k();
    }

    public void b(int i, int i2) {
        a((double) i, (double) i2);
    }

    public void a(a aVar) {
        this.y = aVar;
    }

    public ic D() {
        return this.t;
    }

    private void L() {
        hq f = this.s.f();
        boolean z = t() && this.B;
        f.c(z);
    }

    public void b(boolean z) {
        if (z) {
            if (this.G != null) {
                this.G.run();
                this.G = null;
            }
            G();
        }
    }

    public void c(boolean z) {
        this.H = z;
    }
}
