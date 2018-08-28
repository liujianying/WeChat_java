package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.tencentmap.mapsdk.a.ac.h;
import com.tencent.tencentmap.mapsdk.a.ac.i;
import com.tencent.tencentmap.mapsdk.a.ht.a;
import com.tencent.tencentmap.mapsdk.a.ic.b;
import java.util.ArrayList;
import java.util.List;

public final class mp extends nz implements mq, og, oi {
    private ks a = null;
    private Context b = null;
    private final GeoPoint c = null;
    private final GeoPoint d = null;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private byte[] i = new byte[0];
    private int j = 0;
    private float k = 1.0f;
    private final b l = new b(this, false);
    private final b m = new b(this, true);
    private a n = new a() {
        public void a(hi hiVar) {
            if (hiVar.a == 10000 && (hiVar instanceof kp)) {
                kp kpVar = (kp) hiVar;
                if (kpVar.j()) {
                    mp.this.a.getMap().c((mp.this.a.A / 2) - kpVar.k(), (mp.this.a.B / 2) - kpVar.l());
                }
                if (kpVar.e()) {
                    mp.this.a.getMap().c(kpVar.f(), kpVar.g());
                }
                if (kpVar.h()) {
                    mp.this.a.getMap().b((double) kpVar.i());
                }
                if (kpVar.m()) {
                    int n = kpVar.n();
                    int o = kpVar.o();
                    mp.this.a.getMap().a(n, o);
                    if (kpVar.t()) {
                        mp.this.a.a(n, o);
                    }
                }
                if (kpVar.q()) {
                    mp.this.a.getMap().b(kpVar.p());
                }
                if (kpVar.r()) {
                    mp.this.a.getMap().a(kpVar.s());
                }
                if (kpVar.j()) {
                    mp.this.a.getMap().c(kpVar.k() - (mp.this.a.A / 2), kpVar.l() - (mp.this.a.B / 2));
                }
            }
        }
    };
    private kp.a o = new 2(this);
    private boolean p = false;
    private hg q = new 4(this);

    public mp(ViewGroup viewGroup, Context context, ad adVar) {
        this.b = context;
        this.k = SystemUtil.getDensity(context);
        if (this.a == null) {
            this.a = new ks(this.b, adVar);
            this.a.a(this.b);
        }
        if (kh.u == null) {
            kh.u = new nn(10);
        }
        this.a.a(this);
        this.a.getMap().a(this.n);
        this.a.getMap().a(this.q);
        this.a.getMap().e(0, 0);
        a(false, false);
    }

    public final void a() {
        if (this.a != null) {
            this.a.getMap().b(this.q);
            this.a.m();
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
        if (kh.u != null) {
            kh.u.a();
        }
    }

    public final ox a(Point point) {
        return kh.a(this.a.getMap().s().a(new DoublePoint((double) point.x, (double) point.y)));
    }

    public final Point a(ox oxVar) {
        if (this.a == null) {
            return null;
        }
        DoublePoint b = this.a.getMap().s().b(kh.a(oxVar));
        if (b == null) {
            return null;
        }
        Point point = new Point();
        point.x = (int) Math.round(b.x);
        point.y = (int) Math.round(b.y);
        return point;
    }

    public final double a(double d) {
        return this.a.getMap().s().a(d);
    }

    public final pj b() {
        Point point = new Point(0, this.a.B);
        Point point2 = new Point(this.a.A, this.a.B);
        Point point3 = new Point(0, 0);
        Point point4 = new Point(this.a.A, 0);
        ox a = a(point);
        ox a2 = a(point2);
        ox a3 = a(point3);
        ox a4 = a(point4);
        return new pj(a, a2, a3, a4, oy.a().a(a).a(a2).a(a3).a(a4).a());
    }

    public final View c() {
        return this.a;
    }

    private void a(boolean z, long j, ac.a aVar) {
        if (z) {
            kp kpVar = new kp(10000);
            kpVar.b(1.0f);
            kpVar.a(this.o);
            kpVar.a(aVar);
            kpVar.a(j);
            this.a.getMap().a(kpVar);
            return;
        }
        this.a.getMap().b(this.a.getMap().h() + 1);
    }

    private void b(boolean z, long j, ac.a aVar) {
        if (z) {
            kp kpVar = new kp(10000);
            kpVar.b(-1.0f);
            kpVar.a(this.o);
            kpVar.a(aVar);
            kpVar.a(j);
            this.a.getMap().a(kpVar);
            return;
        }
        this.a.getMap().b(this.a.getMap().h() - 1);
    }

    private void a(float f, float f2, boolean z, long j, ac.a aVar) {
        if (this.a != null) {
            if (f != 0.0f || f2 != 0.0f) {
                if (z) {
                    kp kpVar = new kp(10000);
                    kpVar.a((int) f, (int) f2);
                    kpVar.a(this.o);
                    kpVar.a(aVar);
                    kpVar.a(j);
                    this.a.getMap().a(kpVar);
                    return;
                }
                this.a.getMap().c((int) f, (int) f2);
            }
        }
    }

    private void a(float f, boolean z, long j, ac.a aVar) {
        if (this.a != null) {
            if (z) {
                kp kpVar = new kp(10000);
                kpVar.a(f);
                kpVar.a(this.o);
                kpVar.a(aVar);
                kpVar.a(j);
                this.a.getMap().a(kpVar);
                return;
            }
            int a = ne.a(this.a.getMap().d());
            if (f >= ((float) a)) {
                f = (float) a;
            }
            this.a.getMap().a((double) ((float) (1.0d / Math.pow(2.0d, (double) (((float) a) - f)))));
        }
    }

    private void b(float f, boolean z, long j, ac.a aVar) {
        if (this.a != null && f != 0.0f) {
            if (z) {
                kp kpVar = new kp(10000);
                kpVar.b(f);
                kpVar.a(this.o);
                kpVar.a(aVar);
                kpVar.a(j);
                this.a.getMap().a(kpVar);
                return;
            }
            float pow;
            if (f < 0.0f) {
                pow = (float) (1.0d / Math.pow(2.0d, (double) Math.abs(f)));
            } else {
                pow = (float) (1.0d / Math.pow(0.5d, (double) Math.abs(f)));
            }
            this.a.getMap().a((double) (pow * this.a.getMap().i()));
        }
    }

    private void a(float f, float f2, float f3, boolean z, long j, ac.a aVar) {
        if (this.a != null && f != 0.0f) {
            if (z) {
                kp kpVar = new kp(10000);
                kpVar.b((int) f2, (int) f3);
                kpVar.b(f);
                kpVar.a(this.o);
                kpVar.a(aVar);
                kpVar.a(j);
                this.a.getMap().a(kpVar);
                return;
            }
            float pow;
            if (f < 0.0f) {
                pow = (float) (1.0d / Math.pow(2.0d, (double) Math.abs(f)));
            } else {
                pow = (float) (1.0d / Math.pow(0.5d, (double) Math.abs(f)));
            }
            this.a.getMap().a((double) pow, (double) f2, (double) f3, (double) f2, (double) f3, null);
        }
    }

    private void a(or orVar, boolean z, long j, ac.a aVar) {
        if (this.a != null && orVar != null) {
            GeoPoint a = kh.a(orVar.a);
            float f = orVar.b;
            int a2 = ne.a(this.a.getMap().d());
            int b = this.a.getMap().b();
            if (f < ((float) b)) {
                f = (float) b;
            }
            if (f > ((float) a2)) {
                f = (float) a2;
            }
            if (z) {
                kp kpVar = new kp(10000);
                if (a != null) {
                    kpVar.c(a.getLatitudeE6(), a.getLongitudeE6());
                }
                kpVar.a(f);
                kpVar.c(orVar.d);
                if (orVar.c >= 0.0f) {
                    kpVar.d(orVar.c);
                }
                kpVar.a(this.o);
                kpVar.a(j);
                kpVar.a(aVar);
                this.a.getMap().a(kpVar);
                return;
            }
            double pow = 1.0d / Math.pow(2.0d, (double) (((float) a2) - f));
            if (a != null) {
                this.a.getMap().a(a.getLatitudeE6(), a.getLongitudeE6());
            }
            this.a.getMap().c((float) pow);
            this.a.getMap().b(orVar.d);
            if (orVar.c >= 0.0f) {
                this.a.getMap().a(orVar.c);
            }
        }
    }

    private void a(double d, double d2, float f, boolean z, long j, ac.a aVar) {
        if (this.a != null) {
            float f2;
            int i = (int) (1000000.0d * d);
            int i2 = (int) (1000000.0d * d2);
            int a = ne.a(this.a.getMap().d());
            int b = this.a.getMap().b();
            if (f < ((float) b)) {
                f2 = (float) b;
            } else {
                f2 = f;
            }
            if (f2 > ((float) a)) {
                f2 = (float) a;
            }
            double pow = 1.0d / Math.pow(2.0d, (double) (((float) a) - f2));
            if (z) {
                kp kpVar = new kp(10000);
                kpVar.c(i, i2);
                kpVar.a(f2);
                kpVar.a(this.o);
                kpVar.a(aVar);
                kpVar.a(j);
                this.a.getMap().a(kpVar);
                return;
            }
            this.a.getMap().a(i, i2);
            this.a.getMap().c((float) pow);
        }
    }

    private void a(double d, double d2, boolean z, long j, ac.a aVar) {
        if (this.a != null) {
            int i = (int) (d * 1000000.0d);
            int i2 = (int) (1000000.0d * d2);
            if (z) {
                kp kpVar = new kp(10000);
                kpVar.c(i, i2);
                kpVar.a(this.o);
                kpVar.a(aVar);
                kpVar.a(j);
                this.a.getMap().a(kpVar);
                return;
            }
            this.a.getMap().a(i, i2);
        }
    }

    private int a(oy oyVar, int i, boolean z, long j, ac.a aVar) {
        if (oyVar == null) {
            return -1;
        }
        if (oyVar.b == null || oyVar.a == null) {
            return -1;
        }
        int windowWidth;
        int windowHeight;
        if (this.a.A == 0 || this.a.B == 0) {
            this.a.t = oyVar.a;
            this.a.u = oyVar.b;
            this.a.v = i;
            this.a.C = aVar;
            if (z) {
                this.a.setOnSurfaceChangedListener(this.m);
            } else {
                this.a.setOnSurfaceChangedListener(this.l);
            }
            windowWidth = SystemUtil.getWindowWidth(this.b);
            windowHeight = SystemUtil.getWindowHeight(this.b);
            if (i * 2 > windowWidth || i * 2 > windowHeight) {
                return -1;
            }
            return 0;
        }
        this.a.setOnSurfaceChangedListener(null);
        GeoPoint geoPoint = new GeoPoint();
        float a = a(i, i, i, i, oyVar.a, oyVar.b, geoPoint);
        if (a < 0.0f) {
            return (int) a;
        }
        windowWidth = geoPoint.getLatitudeE6();
        windowHeight = geoPoint.getLongitudeE6();
        if (z) {
            kp kpVar = new kp(10000);
            kpVar.c(0.0f);
            kpVar.d(0.0f);
            kpVar.c(windowWidth, windowHeight);
            kpVar.a(a);
            kpVar.a(this.o);
            kpVar.a(aVar);
            kpVar.a(j);
            this.a.getMap().a(kpVar);
        } else {
            this.a.getMap().a(windowWidth, windowHeight);
            a(a, false, j, null);
            this.a.getMap().b(0.0f);
            this.a.getMap().a(0.0f);
        }
        return 0;
    }

    private void b(float f, float f2, boolean z, long j, ac.a aVar) {
        if (z) {
            kp kpVar = new kp(10000);
            kpVar.c(f);
            if (f2 >= 0.0f) {
                kpVar.d(f2);
            }
            kpVar.a(this.o);
            kpVar.a(aVar);
            kpVar.a(j);
            this.a.getMap().a(kpVar);
            return;
        }
        this.a.getMap().b(f);
        if (f2 >= 0.0f) {
            this.a.getMap().a(f2);
        }
    }

    private int a(oy oyVar, int i, int i2, int i3, int i4, boolean z, long j, ac.a aVar) {
        if (oyVar == null) {
            return -1;
        }
        if (oyVar.b == null || oyVar.a == null) {
            return -1;
        }
        int windowWidth;
        int windowHeight;
        if (this.a.A == 0 || this.a.B == 0) {
            this.a.t = oyVar.a;
            this.a.u = oyVar.b;
            this.a.w = i;
            this.a.x = i2;
            this.a.y = i3;
            this.a.z = i4;
            this.a.C = aVar;
            if (z) {
                this.a.setOnSurfaceChangedListener(this.m);
            } else {
                this.a.setOnSurfaceChangedListener(this.l);
            }
            windowWidth = SystemUtil.getWindowWidth(this.b);
            windowHeight = SystemUtil.getWindowHeight(this.b);
            if (i + i2 > windowWidth || i3 + i4 > windowHeight) {
                return -1;
            }
            return 0;
        }
        this.a.setOnSurfaceChangedListener(null);
        GeoPoint geoPoint = new GeoPoint();
        float a = a(i, i2, i3, i4, oyVar.a, oyVar.b, geoPoint);
        if (a < 0.0f) {
            return (int) a;
        }
        windowWidth = geoPoint.getLatitudeE6();
        windowHeight = geoPoint.getLongitudeE6();
        if (z) {
            kp kpVar = new kp(10000);
            kpVar.c(0.0f);
            kpVar.d(0.0f);
            kpVar.c(windowWidth, windowHeight);
            kpVar.a(a);
            kpVar.a(this.o);
            kpVar.a(aVar);
            kpVar.a(j);
            this.a.getMap().a(kpVar);
        } else {
            this.a.getMap().a(windowWidth, windowHeight);
            a(a, false, j, null);
            this.a.getMap().b(0.0f);
            this.a.getMap().a(0.0f);
        }
        return 0;
    }

    private int a(List<ou> list, int i, int i2, int i3, int i4, boolean z, long j, ac.a aVar) {
        gw gwVar = (gw) this.a.getMap().t();
        if (gwVar == null) {
            return Integer.MIN_VALUE;
        }
        if (list == null || list.isEmpty()) {
            return -1;
        }
        List arrayList = new ArrayList();
        for (ou ouVar : list) {
            if (!(ouVar == null || ouVar.a() == null)) {
                arrayList.addAll(ouVar.a());
            }
        }
        if (this.a.A == 0 || this.a.B == 0) {
            return (i + i2 > SystemUtil.getWindowWidth(this.b) || i3 + i4 > SystemUtil.getWindowHeight(this.b)) ? -1 : 0;
        } else if (i + i2 > this.a.A || i3 + i4 > this.a.B) {
            return -1;
        } else {
            final boolean z2 = z;
            final ac.a aVar2 = aVar;
            final long j2 = j;
            gwVar.a(arrayList, new Rect(i, i3, i2, i4), new gw.a() {
                public void a(float f, GeoPoint geoPoint, double d) {
                    if (mp.this.a != null) {
                        mp.this.a.s.post(new 1(this, f, geoPoint));
                    }
                }
            });
            return 0;
        }
    }

    public final or d() {
        ox a = kh.a(this.a.getMap().f());
        float p = this.a.getMap().p();
        if (p < 0.0f) {
            p = (p % 360.0f) + 360.0f;
        }
        return or.a().a(o()).a(a).c(p).b(this.a.getMap().q()).a();
    }

    public final float e() {
        return (float) this.a.getMap().c();
    }

    public final float f() {
        return (float) this.a.getMap().b();
    }

    public final int a(x xVar) {
        if (xVar == null) {
            return -1;
        }
        ml a = xVar.a();
        if (a == null) {
            return -1;
        }
        switch (a.o) {
            case 0:
                a(false, 0, null);
                break;
            case 1:
                b(false, 0, null);
                break;
            case 2:
                a(a.p, a.q, false, 0, null);
                break;
            case 3:
                a(a.r, false, 0, null);
                break;
            case 4:
                b(a.s, false, 0, null);
                break;
            case 5:
                a(a.t, (float) a.u.x, (float) a.u.y, false, 0, null);
                break;
            case 6:
                a(a.v, false, 0, null);
                break;
            case 7:
                a(a.w.a, a.w.b, false, 0, null);
                break;
            case 8:
                a(a.x.a, a.x.b, a.y, false, 0, null);
                break;
            case 9:
                return a(a.z, a.A, false, 0, null);
            case 10:
                return a(a.B, a.E, a.E, a.E, a.E, false, 0, null);
            case 11:
                return a(a.B, a.F, a.G, a.H, a.I, false, 0, null);
            case 12:
                b(a.J, a.K, false, 0, null);
                break;
            case 13:
                return a(a.L, a.F, a.G, a.H, a.I, false, 0, null);
        }
        return 0;
    }

    public final int a(x xVar, long j, ac.a aVar) {
        if (xVar == null) {
            return -1;
        }
        ml a = xVar.a();
        if (a == null) {
            return -1;
        }
        long j2 = j < 0 ? 0 : j;
        switch (a.o) {
            case 0:
                a(true, j2, aVar);
                break;
            case 1:
                b(true, j2, aVar);
                break;
            case 2:
                a(a.p, a.q, true, j2, aVar);
                break;
            case 3:
                a(a.r, true, j2, aVar);
                break;
            case 4:
                b(a.s, true, j2, aVar);
                break;
            case 5:
                a(a.t, (float) a.u.x, (float) a.u.y, true, j2, aVar);
                break;
            case 6:
                a(a.v, true, j2, aVar);
                break;
            case 7:
                a(a.w.a, a.w.b, true, j2, aVar);
                break;
            case 8:
                a(a.x.a, a.x.b, a.y, true, j2, aVar);
                break;
            case 9:
                return a(a.z, a.A, true, j2, aVar);
            case 10:
                return a(a.B, a.E, a.E, a.E, a.E, true, j2, aVar);
            case 11:
                return a(a.B, a.F, a.G, a.H, a.I, true, j2, aVar);
            case 12:
                b(a.J, a.K, true, j2, aVar);
                break;
            case 13:
                return a(a.L, a.F, a.G, a.H, a.I, true, j2, aVar);
        }
        return 0;
    }

    public final void g() {
        this.a.getMap().u();
    }

    public final void a(boolean z) {
        f map = this.a.getMap();
        if (z) {
            map.a(true);
        } else {
            map.a(false);
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.a.getMap().a(2);
        } else {
            this.a.getMap().a(this.j);
        }
    }

    public final boolean h() {
        return this.a.getMap().g();
    }

    public final ks i() {
        return this.a;
    }

    final void j() {
    }

    final void k() {
        this.a.b();
    }

    final void l() {
        this.a.c();
    }

    final void m() {
        this.a.d();
    }

    final void a(h hVar) {
        this.a.l = hVar;
    }

    final void a(ac$j ac_j) {
        this.a.o = ac_j;
    }

    final void a(ac$c ac_c) {
        this.a.n = ac_c;
        this.a.setCamerChangeListener(ac_c == null);
    }

    public final void a(int i, int i2) {
        if (i != 0 && i2 != 0 && this.c != null && this.d != null) {
        }
    }

    final void a(Handler handler, Config config) {
        this.a.a(handler, config);
    }

    final String n() {
        return "4.0.8";
    }

    public final DoublePoint a(GeoPoint geoPoint, DoublePoint doublePoint) {
        double d = (double) (2.68435456E8f * this.k);
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        d /= 6.283185307179586d;
        double min = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
        d3 = (d3 * (((double) geoPoint.getLongitudeE6()) / 1000000.0d)) + d2;
        d = ((d * Math.log((1.0d + min) / (1.0d - min))) * 0.5d) + d2;
        if (doublePoint == null) {
            doublePoint = new DoublePoint();
        }
        doublePoint.set(d3, d);
        return doublePoint;
    }

    public final float a(int i, int i2, int i3, int i4, ox oxVar, ox oxVar2, GeoPoint geoPoint) {
        int i5 = this.a.A;
        int i6 = this.a.B;
        if (i5 == 0 || i6 == 0 || oxVar == null || oxVar2 == null) {
            return -2.0f;
        }
        if (i + i2 > i5 || i3 + i4 > i6) {
            return -1.0f;
        }
        double d;
        double d2;
        double a;
        double abs;
        b q = this.a.getMap().z().q();
        if (q == null) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            a = (double) q.a();
            d = (double) q.b();
            d2 = a;
        }
        GeoPoint a2 = kh.a(oxVar);
        GeoPoint a3 = kh.a(oxVar2);
        int a4 = ne.a(this.a.getMap().d());
        DoublePoint a5 = a(a2, null);
        DoublePoint a6 = a(a3, null);
        a = a6.x - a5.x;
        if (a < 0.0d) {
            a = Math.abs(a);
        }
        double d3 = a6.y - a5.y;
        if (d3 < 0.0d) {
            abs = Math.abs(d3);
        } else {
            abs = d3;
        }
        int i7 = (i5 - i) - i2;
        int i8 = (i6 - i3) - i4;
        if (i7 <= 0) {
            i7 = 1;
        }
        if (i8 <= 0) {
            i8 = 1;
        }
        abs = Math.max(a / ((double) i7), abs / ((double) i8));
        float log = (float) (((double) a4) - (Math.log(abs) / Math.log(2.0d)));
        if (geoPoint != null) {
            double d4 = (((double) (i2 - i)) * abs) / 2.0d;
            a = (((double) (i3 - i4)) * abs) / 2.0d;
            a6 = a(kh.a(new ox((oxVar.a + oxVar2.a) / 2.0d, (oxVar.b + oxVar2.b) / 2.0d)), null);
            a6.x = d4 + a6.x;
            a6.y = a + a6.y;
            int i9 = this.e - this.g;
            int i10 = this.f - this.h;
            float f = (((float) (this.e - this.g)) / (2.0f * ((float) i5))) + 0.5f;
            if (((double) f) < 0.25d) {
                i9 = (int) (-0.5d * ((double) i5));
            } else if (((double) f) > 0.75d) {
                i9 = (int) (0.5d * ((double) i5));
            }
            f = (((float) (this.f - this.h)) / (2.0f * ((float) i6))) + 0.5f;
            if (((double) f) < 0.25d) {
                i10 = (int) (-0.5d * ((double) i6));
            } else if (((double) f) > 0.75d) {
                i10 = (int) (0.5d * ((double) i6));
            }
            d4 = (((double) i9) * abs) / 2.0d;
            d4 = a6.x - d4;
            GeoPoint a7 = a(new DoublePoint(((d2 * ((double) i5)) * abs) + d4, (a6.y - ((((double) i10) * abs) / 2.0d)) - ((d * ((double) i6)) * abs)), null);
            geoPoint.setLatitudeE6(a7.getLatitudeE6());
            geoPoint.setLongitudeE6(a7.getLongitudeE6());
        }
        return log;
    }

    private GeoPoint a(DoublePoint doublePoint, GeoPoint geoPoint) {
        double d = (double) (2.68435456E8f * this.k);
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        d3 = (doublePoint.x - d2) / d3;
        d = (Math.asin(1.0d - (2.0d / (Math.pow(2.718281828459045d, ((doublePoint.y - d2) / 0.5d) / (d / 6.283185307179586d)) + 1.0d))) * 180.0d) / 3.141592653589793d;
        if (geoPoint == null) {
            geoPoint = new GeoPoint(0, 0);
        }
        geoPoint.setLatitudeE6((int) (d * 1000000.0d));
        geoPoint.setLongitudeE6((int) (1000000.0d * d3));
        return geoPoint;
    }

    public final float o() {
        return (float) (((double) ((float) this.a.getMap().h())) + (Math.log((double) this.a.getMap().j()) / Math.log(2.0d)));
    }

    final void a(float f, float f2, boolean z) {
        if (this.a != null) {
            this.a.getMap().a(f, f2, 0, z);
        }
    }

    public final void c(boolean z) {
        this.a.setZOrderMediaOverlay(z);
    }

    final void p() {
    }

    final void q() {
    }

    public final void a(boolean z, boolean z2) {
        this.a.getMap().c(z2);
        this.a.getMap().b(z);
    }

    final void a(i iVar) {
        this.a.p = iVar;
    }

    final void a(ac$l ac_l) {
        this.a.q = ac_l;
    }

    final void a(ac$g ac_g) {
        this.a.r = ac_g;
    }

    final void d(boolean z) {
        if (this.a != null) {
            f map = this.a.getMap();
            if (map != null) {
                map.d(z);
            }
        }
    }

    final int r() {
        if (this.a == null) {
            return -1;
        }
        f map = this.a.getMap();
        if (map != null) {
            return map.w();
        }
        return -1;
    }

    final String[] s() {
        if (this.a == null) {
            return null;
        }
        f map = this.a.getMap();
        if (map != null) {
            return map.x();
        }
        return null;
    }

    final String b(ox oxVar) {
        if (this.a == null || oxVar == null) {
            return null;
        }
        f map = this.a.getMap();
        if (map == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint();
        String c = map.c(geoPoint);
        oxVar.a = (((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d;
        oxVar.b = (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d;
        return c;
    }

    public final ov c(ox oxVar) {
        String b = b(oxVar);
        String[] s = s();
        if (b == null || s == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (String owVar : s) {
            arrayList.add(new ow(owVar));
        }
        return new ov(b, arrayList, r());
    }

    final void e(boolean z) {
        if (this.a != null) {
            if (z) {
                this.a.r();
            } else {
                this.a.s();
            }
        }
    }

    final boolean t() {
        if (this.a == null) {
            return false;
        }
        return this.a.t();
    }
}
