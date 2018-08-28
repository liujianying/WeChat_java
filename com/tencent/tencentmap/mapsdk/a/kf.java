package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.tencentmap.mapsdk.a.ic.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class kf extends ke implements he, iw {
    Polygon2D a;
    private ks b = null;
    private List<GeoPoint> c = new ArrayList();
    private Rect d;
    private iy e;
    private byte[] f = new byte[0];
    private b g = new b();
    private String h;
    private GeoPoint i = new GeoPoint();
    private Rect j = new Rect();
    private f k;
    private boolean l = false;
    private boolean m = false;
    private pe n;

    private static class b {
        private Bitmap a;
        private TextPaint b;
        private int c;
        private int d;
        private int e;
        private HashMap<String, Integer> f;

        private b() {
            this.a = null;
            this.b = null;
            this.c = 900;
            this.d = 180;
            this.e = -1;
            this.f = new HashMap();
        }

        void a() {
            if (this.a != null && !this.a.isRecycled()) {
                this.a.recycle();
                this.a = null;
            }
        }
    }

    public kf(ks ksVar, pe peVar) {
        this.b = ksVar;
        this.a = new Polygon2D();
        this.a.polygonId = -1;
        this.n = peVar;
        this.k = this.b.getMap();
        if (peVar != null && !StringUtil.isEmpty(peVar.g())) {
            this.k.a(this);
        }
    }

    public void a(List<GeoPoint> list) {
        if (list != null && !list.isEmpty()) {
            if (this.c == null) {
                this.c = new ArrayList();
            } else {
                this.c.clear();
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GeoPoint geoPoint = (GeoPoint) list.get(i);
                if (geoPoint != null) {
                    boolean z;
                    for (int i2 = 0; i2 < i; i2++) {
                        if (geoPoint.equals((GeoPoint) list.get(i2))) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.O = true;
                        this.c.add(geoPoint);
                    }
                }
            }
        }
    }

    public void a(pe peVar) {
        if (peVar != null) {
            c(peVar.d());
            b(peVar.c());
            d(peVar.b());
            c(peVar.e());
            a_(peVar.f());
            b(peVar.a());
            this.O = true;
        }
    }

    public int e() {
        return this.a == null ? -1 : this.a.polygonId;
    }

    private void b(List<ox> list) {
        if (list != null) {
            int size = list.size();
            if (size > 0) {
                List arrayList = new ArrayList();
                for (int i = 0; i < size; i++) {
                    ox oxVar = (ox) list.get(i);
                    if (oxVar != null) {
                        GeoPoint a = kh.a(oxVar);
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
                a(arrayList);
            }
        }
    }

    public void a(GL10 gl10) {
        if (a()) {
            c();
            return;
        }
        this.b.getMap().c(this.a.polygonId);
        this.a.polygonId = -1;
    }

    public boolean a(float f, float f2) {
        return false;
    }

    public boolean a() {
        return this.N;
    }

    public void a_(boolean z) {
        this.N = z;
        this.b.getMap().a();
    }

    public void b() {
    }

    public void c() {
        i();
    }

    private int[] a(int i) {
        return new int[]{Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i)};
    }

    private void i() {
        if ((this.a.polygonId < 0 || this.O) && this.c != null && this.c.size() > 2) {
            this.a.color = a(this.K);
            this.a.borderColor = a(this.L);
            this.a.borderWidth = this.J;
            this.a.polygonMode = 1;
            this.a.zIndex = w();
            int size = this.c.size();
            this.a.points = new Point[size];
            for (int i = 0; i < size; i++) {
                GeoPoint geoPoint = (GeoPoint) this.c.get(i);
                this.a.points[i] = new Point(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
            }
            if (-1 == this.a.polygonId) {
                this.a.polygonId = this.b.getMap().a(this.a);
            } else if (this.O) {
                this.b.getMap().b(this.a);
            }
            this.b.getMap().a();
            this.O = false;
        }
    }

    public void u() {
        super.u();
    }

    public void d() {
        this.k.b(this);
        if (this.a != null) {
            this.b.getMap().c(this.a.polygonId);
        }
        if (this.c != null) {
            this.c.clear();
            this.c = null;
        }
        this.b = null;
        synchronized (this.f) {
            if (this.g != null) {
                this.g.a();
                this.g = null;
            }
        }
        if (this.e != null) {
            this.k.b(this.e);
            this.e = null;
        }
        this.k = null;
        this.l = false;
    }

    public Rect f() {
        if (this.d != null) {
            return this.d;
        }
        if (this.c == null || this.c.isEmpty()) {
            return null;
        }
        GeoPoint geoPoint = (GeoPoint) this.c.get(0);
        int latitudeE6 = geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint.getLongitudeE6();
        int size = this.c.size();
        int i = 1;
        int i2 = latitudeE6;
        int i3 = latitudeE6;
        int i4 = longitudeE6;
        int i5 = longitudeE6;
        while (i < size) {
            geoPoint = (GeoPoint) this.c.get(i);
            int latitudeE62 = geoPoint.getLatitudeE6();
            int longitudeE62 = geoPoint.getLongitudeE6();
            longitudeE6 = Math.max(i5, longitudeE62);
            i4 = Math.min(i4, longitudeE62);
            latitudeE6 = Math.max(i3, latitudeE62);
            i2 = Math.min(i2, latitudeE62);
            i++;
            i3 = latitudeE6;
            i5 = longitudeE6;
        }
        this.d = new Rect(i5, i3, i4, i2);
        return this.d;
    }

    public List<GeoPoint> g() {
        return this.c;
    }

    public List<GeoPoint> h() {
        List<GeoPoint> arrayList = new ArrayList(49);
        Rect f = f();
        int i = f.left;
        int i2 = f.right;
        i2 = f.top;
        int i3 = f.bottom;
        i3 = Math.abs(f.width());
        int abs = Math.abs(f.height());
        double d = ((double) i) - (0.125d * ((double) i3));
        double d2 = ((double) i2) - (0.125d * ((double) abs));
        double d3 = ((double) i) - (0.25d * ((double) i3));
        double d4 = ((double) i2) - (0.25d * ((double) abs));
        double d5 = ((double) i) - (0.375d * ((double) i3));
        double d6 = ((double) i2) - (0.375d * ((double) abs));
        double d7 = ((double) i) - (0.5d * ((double) i3));
        double d8 = ((double) i2) - (0.5d * ((double) abs));
        double d9 = ((double) i) - (0.625d * ((double) i3));
        double d10 = ((double) i2) - (0.625d * ((double) abs));
        double d11 = ((double) i) - (0.75d * ((double) i3));
        double d12 = ((double) i2) - (0.75d * ((double) abs));
        double d13 = ((double) i) - (((double) i3) * 0.825d);
        double d14 = ((double) i2) - (0.825d * ((double) abs));
        GeoPoint geoPoint = new GeoPoint(new GeoPoint((int) d2, (int) d));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d4, (int) d));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d6, (int) d));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d8, (int) d));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d10, (int) d));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d12, (int) d));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d14, (int) d));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d2, (int) d3));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d4, (int) d3));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d6, (int) d3));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d8, (int) d3));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d10, (int) d3));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d12, (int) d3));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d14, (int) d3));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d2, (int) d5));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d4, (int) d5));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d6, (int) d5));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d8, (int) d5));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d10, (int) d5));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d12, (int) d5));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d14, (int) d5));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d2, (int) d7));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d4, (int) d7));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d6, (int) d7));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d8, (int) d7));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d10, (int) d7));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d12, (int) d7));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d14, (int) d7));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d2, (int) d9));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d4, (int) d9));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d6, (int) d9));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d8, (int) d9));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d10, (int) d9));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d12, (int) d9));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d14, (int) d9));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d2, (int) d11));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d4, (int) d11));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d6, (int) d11));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d8, (int) d11));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d10, (int) d11));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d12, (int) d11));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d14, (int) d11));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d2, (int) d13));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d4, (int) d13));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d6, (int) d13));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d8, (int) d13));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d10, (int) d13));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d12, (int) d13));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        geoPoint = new GeoPoint(new GeoPoint((int) d14, (int) d13));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        return arrayList;
    }

    private boolean a(GeoPoint geoPoint) {
        if (this.c == null || this.c.size() <= 1) {
            return false;
        }
        double longitudeE6 = (double) geoPoint.getLongitudeE6();
        double latitudeE6 = (double) geoPoint.getLatitudeE6();
        int i = 0;
        int size = this.c.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            GeoPoint geoPoint2;
            GeoPoint geoPoint3;
            double longitudeE62;
            double latitudeE62;
            double longitudeE63;
            double latitudeE63;
            if (i3 < size - 1) {
                geoPoint2 = (GeoPoint) this.c.get(i3);
                geoPoint3 = (GeoPoint) this.c.get(i3 + 1);
                longitudeE62 = (double) geoPoint2.getLongitudeE6();
                latitudeE62 = (double) geoPoint2.getLatitudeE6();
                longitudeE63 = (double) geoPoint3.getLongitudeE6();
                latitudeE63 = (double) geoPoint3.getLatitudeE6();
                if (b(longitudeE6, latitudeE6, longitudeE62, latitudeE62, longitudeE63, latitudeE63)) {
                    return true;
                }
                if (Math.abs(latitudeE63 - latitudeE62) >= 1.0E-9d) {
                    if (b(longitudeE62, latitudeE62, longitudeE6, latitudeE6, 180.0d, latitudeE6)) {
                        if (latitudeE62 > latitudeE63) {
                            i2 = 0 + 1;
                            i3++;
                        }
                    } else if (b(longitudeE63, latitudeE63, longitudeE6, latitudeE6, 180.0d, latitudeE6)) {
                        if (latitudeE63 > latitudeE62) {
                            i2 = 0 + 1;
                            i3++;
                        }
                    } else if (a(longitudeE62, latitudeE62, longitudeE63, latitudeE63, longitudeE6, latitudeE6, 180.0d, latitudeE6)) {
                        i2 = 0 + 1;
                        i3++;
                    }
                }
                i2 = 0;
                i3++;
            } else {
                geoPoint2 = (GeoPoint) this.c.get(size - 1);
                geoPoint3 = (GeoPoint) this.c.get(0);
                longitudeE62 = (double) geoPoint2.getLongitudeE6();
                latitudeE62 = (double) geoPoint2.getLatitudeE6();
                longitudeE63 = (double) geoPoint3.getLongitudeE6();
                latitudeE63 = (double) geoPoint3.getLatitudeE6();
                if (b(longitudeE6, latitudeE6, longitudeE62, latitudeE62, longitudeE63, latitudeE63)) {
                    return true;
                }
                if (Math.abs(latitudeE63 - latitudeE62) >= 1.0E-9d) {
                    if (b(longitudeE62, latitudeE62, longitudeE6, latitudeE6, 180.0d, latitudeE6)) {
                        if (latitudeE62 > latitudeE63) {
                            i = 0 + 1;
                        }
                    } else if (b(longitudeE63, latitudeE63, longitudeE6, latitudeE6, 180.0d, latitudeE6)) {
                        if (latitudeE63 > latitudeE62) {
                            i = 0 + 1;
                        }
                    } else if (a(longitudeE62, latitudeE62, longitudeE63, latitudeE63, longitudeE6, latitudeE6, 180.0d, latitudeE6)) {
                        i = 0 + 1;
                    }
                }
                if (i % 2 == 1) {
                    return true;
                }
                return false;
            }
        }
    }

    private double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    private boolean b(double d, double d2, double d3, double d4, double d5, double d6) {
        if (Math.abs(a(d, d2, d3, d4, d5, d6)) >= 1.0E-9d || (d - d3) * (d - d5) > 0.0d || (d2 - d4) * (d2 - d6) > 0.0d) {
            return false;
        }
        return true;
    }

    private boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = ((d3 - d) * (d8 - d6)) - ((d4 - d2) * (d7 - d5));
        if (d9 == 0.0d) {
            return false;
        }
        double d10 = (((d2 - d6) * (d7 - d5)) - ((d - d5) * (d8 - d6))) / d9;
        d9 = (((d2 - d6) * (d3 - d)) - ((d - d5) * (d4 - d2))) / d9;
        if (d10 < 0.0d || d10 > 1.0d || d9 < 0.0d || d9 > 1.0d) {
            return false;
        }
        return true;
    }

    public void b(hs hsVar, hh hhVar) {
    }

    public synchronized void a(hs hsVar, hh hhVar, GL10 gl10) {
        if (!a()) {
            this.b.getMap().c(this.a.polygonId);
            this.a.polygonId = -1;
        } else if (StringUtil.isEmpty(this.n.g())) {
            c();
        } else if (b(hhVar)) {
            if (!this.l) {
                this.e = c(hhVar);
                this.l = true;
            }
            a(gl10);
            if (this.e != null) {
                this.e.b(hsVar, hhVar);
                this.h = this.e.e();
                if (!this.m) {
                    this.k.d(this.e.e(), e());
                    this.m = true;
                }
            }
        }
    }

    public boolean a(hh hhVar, float f, float f2) {
        return false;
    }

    public Rect a(hh hhVar) {
        Rect rect = new Rect(0, 0, 0, 0);
        if (this.a != null) {
            rect = f();
        }
        Rect rect2 = new Rect(0, 0, 0, 0);
        if (this.e != null) {
            rect2 = this.e.a(hhVar);
        }
        Rect rect3 = new Rect();
        rect3.left = Math.max(rect.left, rect2.left);
        rect3.top = Math.max(rect.top, rect2.top);
        rect3.right = Math.min(rect.right, rect2.right);
        rect3.bottom = Math.min(rect.bottom, rect2.bottom);
        return rect3;
    }

    public void a(c cVar) {
        if (cVar != c.a && this.k != null) {
            d(this.k.s());
        }
    }

    private boolean b(hh hhVar) {
        if (this.a == null) {
            return false;
        }
        Rect f = f();
        GeoPoint geoPoint = new GeoPoint(f.top, f.left);
        GeoPoint geoPoint2 = new GeoPoint(f.bottom, f.right);
        GeoPoint geoPoint3 = new GeoPoint(f.bottom, f.left);
        GeoPoint geoPoint4 = new GeoPoint(f.top, f.right);
        DoublePoint b = hhVar.b(geoPoint);
        DoublePoint b2 = hhVar.b(geoPoint2);
        DoublePoint b3 = hhVar.b(geoPoint3);
        DoublePoint b4 = hhVar.b(geoPoint4);
        DoublePoint[] a = a(new DoublePoint[]{b, b4, b2, b3});
        Rect rect = new Rect((int) a[0].x, (int) a[0].y, (int) a[1].x, (int) a[1].y);
        if (Math.abs(rect.width()) <= 5 || Math.abs(rect.height()) <= 5) {
            return false;
        }
        return true;
    }

    private iy c(hh hhVar) {
        if (this.k != null) {
            String g = this.n.g();
            if (!StringUtil.isEmpty(g)) {
                synchronized (this.f) {
                    if (this.g == null) {
                        this.g = new b();
                    }
                }
                a(g, this.i, hhVar);
            }
        }
        return null;
    }

    private void d(hh hhVar) {
        if (this.k != null) {
            String g = this.n.g();
            if (!StringUtil.isEmpty(g)) {
                synchronized (this.f) {
                    if (this.g == null) {
                        this.g = new b();
                    }
                }
                a(g, hhVar);
            }
        }
    }

    private int a(String str, GeoPoint geoPoint, hh hhVar) {
        this.j = a(j());
        geoPoint.setLatitudeE6(this.j.centerY());
        geoPoint.setLongitudeE6(this.j.centerX());
        GeoPoint geoPoint2 = new GeoPoint(this.j.top, this.j.left);
        GeoPoint geoPoint3 = new GeoPoint(this.j.top, this.j.right);
        GeoPoint geoPoint4 = new GeoPoint(this.j.bottom, this.j.right);
        GeoPoint geoPoint5 = new GeoPoint(this.j.bottom, this.j.left);
        DoublePoint b = hhVar.b(geoPoint2);
        DoublePoint b2 = hhVar.b(geoPoint3);
        DoublePoint b3 = hhVar.b(geoPoint4);
        DoublePoint b4 = hhVar.b(geoPoint5);
        DoublePoint[] a = a(new DoublePoint[]{b, b2, b3, b4});
        return a(new Rect((int) a[0].x, (int) a[0].y, (int) a[1].x, (int) a[1].y), str);
    }

    private DoublePoint[] a(DoublePoint[] doublePointArr) {
        int length = doublePointArr.length;
        double d = doublePointArr[0].x;
        double d2 = doublePointArr[0].y;
        double d3 = doublePointArr[0].x;
        double d4 = doublePointArr[0].y;
        int i = 1;
        while (i < length) {
            double d5 = doublePointArr[i].x;
            double d6 = doublePointArr[i].y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 <= d3) {
                d5 = d3;
            }
            if (d6 < d2) {
                d2 = d6;
            }
            if (d6 <= d4) {
                d6 = d4;
            }
            i++;
            d4 = d6;
            d3 = d5;
        }
        DoublePoint doublePoint = new DoublePoint(d, d2);
        DoublePoint doublePoint2 = new DoublePoint(d3, d4);
        return new DoublePoint[]{doublePoint, doublePoint2};
    }

    private int a(String str, hh hhVar) {
        GeoPoint geoPoint = new GeoPoint(this.j.top, this.j.left);
        GeoPoint geoPoint2 = new GeoPoint(this.j.top, this.j.right);
        GeoPoint geoPoint3 = new GeoPoint(this.j.bottom, this.j.right);
        GeoPoint geoPoint4 = new GeoPoint(this.j.bottom, this.j.left);
        DoublePoint b = hhVar.b(geoPoint);
        DoublePoint b2 = hhVar.b(geoPoint2);
        DoublePoint b3 = hhVar.b(geoPoint3);
        DoublePoint b4 = hhVar.b(geoPoint4);
        DoublePoint[] a = a(new DoublePoint[]{b, b2, b3, b4});
        return a(new Rect((int) a[0].x, (int) a[0].y, (int) a[1].x, (int) a[1].y), str);
    }

    private int a(Rect rect, String str) {
        return 1;
    }

    private a[] j() {
        List g = g();
        List a = kh.a(g);
        int size = g.size();
        List arrayList = new ArrayList();
        for (int i = 0; i < size - 1; i++) {
            arrayList.add(new a(this, (ox) a.get(i), (ox) a.get(i + 1)));
        }
        arrayList.add(new a(this, (ox) a.get(size - 1), (ox) a.get(0)));
        return (a[]) arrayList.toArray(new a[arrayList.size()]);
    }

    private Rect a(a[] aVarArr) {
        ox oxVar = new ox(0.0d, 0.0d);
        double a = a(aVarArr, oxVar);
        double d = oxVar.b;
        double d2 = oxVar.a;
        return new Rect((int) ((d + a) * 1000000.0d), (int) ((d2 + a) * 1000000.0d), (int) ((d - a) * 1000000.0d), (int) ((d2 - a) * 1000000.0d));
    }

    private double a(a[] aVarArr, ox oxVar) {
        List h = h();
        if (h == null || h.isEmpty()) {
            return 0.0d;
        }
        List a = kh.a(h);
        if (a == null || a.isEmpty()) {
            return 0.0d;
        }
        int size = a.size();
        ox[] oxVarArr = new ox[size];
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            oxVarArr[i] = new ox(0.0d, 0.0d);
            dArr[i] = a((ox) a.get(i), aVarArr, oxVarArr[i]);
            if (Double.isNaN(dArr[i])) {
                dArr[i] = 0.0d;
            }
        }
        double d = dArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < size; i3++) {
            if (dArr[i3] > d) {
                d = dArr[i3];
                i2 = i3;
            }
        }
        oxVar.a = oxVarArr[i2].a;
        oxVar.b = oxVarArr[i2].b;
        return dArr[i2];
    }

    private double a(ox oxVar, a[] aVarArr, ox oxVar2) {
        ox oxVar3;
        double a;
        ox oxVar4 = new ox(0.0d, 0.0d);
        ox oxVar5 = new ox(0.0d, 0.0d);
        a aVar = aVarArr[0];
        ox oxVar6 = aVar.a[0];
        ox oxVar7 = aVar.a[1];
        double a2 = ki.a(oxVar, oxVar6, oxVar7);
        oxVar4.a = oxVar6.a;
        oxVar4.b = oxVar6.b;
        oxVar5.a = oxVar7.a;
        oxVar5.b = oxVar7.b;
        int i = 1;
        while (i < r10) {
            aVar = aVarArr[i];
            ox oxVar8 = aVar.a[0];
            oxVar3 = aVar.a[1];
            a = ki.a(oxVar, oxVar8, oxVar3);
            if (a < a2) {
                oxVar4.a = oxVar8.a;
                oxVar4.b = oxVar8.b;
                oxVar5.a = oxVar3.a;
                oxVar5.b = oxVar3.b;
            } else {
                a = a2;
            }
            i++;
            a2 = a;
        }
        i = 0;
        oxVar3 = ki.b(oxVar, oxVar4, oxVar5);
        ox oxVar9 = new ox(0.0d, 0.0d);
        a2 = 0.0d;
        Object obj = null;
        int i2 = 0;
        while (obj == null) {
            ox a3 = ki.a(oxVar, oxVar3, i);
            a = ki.b(a3, oxVar3);
            for (a aVar2 : aVarArr) {
                if (ki.a(a3, a, aVar2.a[0], aVar2.a[1])) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                oxVar9.a = a3.a;
                oxVar9.b = a3.b;
                i += 5;
            } else if (i2 == 0) {
                oxVar9.a = a3.a;
                oxVar9.b = a3.b;
            } else {
                a = a2;
            }
            a2 = a;
            i2++;
        }
        oxVar2.a = oxVar9.a;
        oxVar2.b = oxVar9.b;
        return a2;
    }
}
