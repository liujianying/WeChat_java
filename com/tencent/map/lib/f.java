package com.tencent.map.lib;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.JNICallback$c;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.tencentmap.mapsdk.a.gv;
import com.tencent.tencentmap.mapsdk.a.gw;
import com.tencent.tencentmap.mapsdk.a.hb;
import com.tencent.tencentmap.mapsdk.a.hc;
import com.tencent.tencentmap.mapsdk.a.he;
import com.tencent.tencentmap.mapsdk.a.hg;
import com.tencent.tencentmap.mapsdk.a.hh;
import com.tencent.tencentmap.mapsdk.a.hi;
import com.tencent.tencentmap.mapsdk.a.hs;
import com.tencent.tencentmap.mapsdk.a.ht;
import com.tencent.tencentmap.mapsdk.a.hv;
import com.tencent.tencentmap.mapsdk.a.ic;
import com.tencent.tencentmap.mapsdk.a.ic.a;
import com.tencent.tencentmap.mapsdk.a.id;
import com.tencent.tencentmap.mapsdk.a.if;
import com.tencent.tencentmap.mapsdk.a.iw;
import java.util.List;

public class f {
    private hv a;
    private int b = a.a;
    private int c = a.d;
    private GeoPoint d = new GeoPoint();
    private int e = 0;

    public f(hv hvVar) {
        this.a = hvVar;
    }

    public void a() {
        this.a.x();
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.a.e().n();
    }

    public int e() {
        return this.a.a().u();
    }

    public void a(int i) {
        this.a.a().b(i);
    }

    public GeoPoint f() {
        return this.a.a().n();
    }

    public String a(GeoPoint geoPoint) {
        return this.a.a(geoPoint);
    }

    public void b(int i) {
        this.a.a().a(i);
    }

    public void a(iw iwVar) {
        this.a.c().a(iwVar);
        this.a.r();
    }

    public void b(iw iwVar) {
        this.a.c().b(iwVar);
        this.a.r();
    }

    public void a(hb hbVar) {
        this.a.a().a(hbVar);
    }

    public void b(hb hbVar) {
        this.a.a().b(hbVar);
    }

    public void a(hg hgVar) {
        this.a.a().a(hgVar);
    }

    public void b(hg hgVar) {
        this.a.a().b(hgVar);
    }

    public void b(GeoPoint geoPoint) {
        this.a.a().a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
    }

    public void a(int i, int i2) {
        this.a.a().a(i, i2);
    }

    public void a(float f) {
        this.a.a().c(f);
    }

    public void b(float f) {
        this.a.a().b(f);
    }

    public boolean g() {
        return this.a.v();
    }

    public void a(boolean z) {
        this.a.b(z);
    }

    public int h() {
        return this.a.a().m();
    }

    public float i() {
        return this.a.a().l();
    }

    public float j() {
        return this.a.a().q();
    }

    public void a(double d) {
        this.a.a().j(d);
    }

    public void a(Runnable runnable) {
        this.a.a().a(runnable);
    }

    public void b(Runnable runnable) {
        this.a.a().b(runnable);
    }

    public void k() {
        this.a.a().s();
    }

    public void l() {
        this.a.t();
    }

    public void m() {
        this.a.u();
    }

    public void n() {
        try {
            gv.a().a(this.a.s());
            gv.a().a(this.a.e());
        } catch (Exception e) {
        }
    }

    public boolean a(String str, byte[] bArr) {
        if p = this.a.p();
        if (p == null) {
            return false;
        }
        return p.a(str, bArr);
    }

    public boolean b(String str, byte[] bArr) {
        if p = this.a.p();
        if (p == null) {
            return false;
        }
        return p.b(str, bArr);
    }

    public void o() {
        if p = this.a.p();
        if (p != null) {
            p.c();
        }
    }

    public void a(hc hcVar) {
        this.a.a().a(hcVar);
    }

    public void a(he heVar) {
        this.a.a().a(heVar);
    }

    public void b(he heVar) {
        this.a.a().b(heVar);
    }

    public void a(com.tencent.map.lib.listener.a aVar) {
        this.a.c().a(aVar);
    }

    public boolean a(float f, float f2) {
        return this.a.c().a(f, f2);
    }

    public float p() {
        return this.a.a().o();
    }

    public float q() {
        return this.a.a().p();
    }

    public int a(Polygon2D polygon2D) {
        return this.a.a(polygon2D);
    }

    public void b(Polygon2D polygon2D) {
        this.a.b(polygon2D);
    }

    public void c(int i) {
        this.a.b(i);
    }

    public int a(int i, int i2, int i3, int i4, int i5, float f) {
        return this.a.a(i, i2, i3, i4, i5, f);
    }

    public void b(int i, int i2) {
        this.a.c(i, i2);
    }

    public void d(int i) {
        this.a.a(i);
    }

    public void a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        this.a.a(list, list2);
    }

    public void r() {
        this.a.w();
    }

    public void b(boolean z) {
        if (this.a != null) {
            this.a.e(z);
        }
    }

    public void c(boolean z) {
        if (this.a != null) {
            this.a.f(z);
        }
    }

    public hh s() {
        return this.a.d();
    }

    @Deprecated
    public hh t() {
        return new gw(this.a);
    }

    public void a(hi hiVar) {
        this.a.a().c(hiVar);
    }

    public void u() {
        this.a.a().A();
    }

    public int a(int i, int i2, int i3, int i4) {
        return this.a.a().a(i, i2, i3, i4);
    }

    public Rect v() {
        return this.a.a().b();
    }

    public void a(e eVar) {
        this.a.a().a(eVar);
    }

    public void d(boolean z) {
        this.a.g(z);
    }

    public int w() {
        return this.a.i().o();
    }

    public String[] x() {
        return this.a.y();
    }

    public String c(GeoPoint geoPoint) {
        return this.a.b(geoPoint);
    }

    public void e(int i) {
        this.b = i;
        this.a.i().b(i);
    }

    public void f(int i) {
        this.c = i;
        this.a.i().c(i);
    }

    public void a(e eVar) {
        this.a.a(eVar);
    }

    public void a(ht.a aVar) {
        this.a.a().a(aVar);
    }

    public void c(int i, int i2) {
        this.a.a().b(i, i2);
    }

    public void c(float f) {
        this.a.a().a(f);
    }

    public void a(float f, float f2, int i, boolean z) {
        this.a.a().a(f, f2, z);
    }

    public void b(double d) {
        this.a.a().h(d);
    }

    public void a(double d, double d2, double d3, double d4, double d5, Runnable runnable) {
        this.a.a().a(d, d2, d3, d4, d5, runnable);
    }

    public void a(id idVar) {
        this.a.a().a(idVar);
    }

    public hs y() {
        return this.a.A();
    }

    public ic z() {
        return this.a.e();
    }

    public int A() {
        return this.a.a(3, true);
    }

    public int B() {
        return this.a.a(2, false);
    }

    public int e(boolean z) {
        return this.a.a(1, z);
    }

    public void g(int i) {
        this.a.c(i);
    }

    public void h(int i) {
        this.a.d(i);
    }

    public void a(d dVar) {
        this.a.a(dVar);
    }

    public void a(j jVar) {
        this.a.a(jVar);
    }

    public void a(b bVar) {
        this.a.a(bVar);
    }

    public void a(JNICallback$c jNICallback$c) {
        this.a.a(jNICallback$c);
    }

    public void a(k kVar) {
        this.a.a(kVar);
    }

    public void d(int i, int i2) {
        this.a.d(i, i2);
    }

    public void f(boolean z) {
        this.a.h(z);
    }

    public void e(int i, int i2) {
        this.a.e(i, i2);
    }

    public void a(String str) {
        this.a.b(str);
    }

    public MapLanguage C() {
        return this.a.z();
    }

    public void b(String str) {
        this.a.a(str);
    }

    public TappedElement b(float f, float f2) {
        return this.a.a(f, f2);
    }

    public void g(boolean z) {
        this.a.j(z);
    }

    public void h(boolean z) {
        this.a.k(z);
    }

    public void c(String str) {
        this.a.c(str);
    }

    public void i(boolean z) {
        this.a.i(z);
    }

    public boolean D() {
        return this.a.C();
    }

    public void E() {
        this.a.D();
    }

    public void j(boolean z) {
        if (this.a != null) {
            this.a.l(z);
        }
    }
}
