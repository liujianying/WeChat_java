package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class sw implements sv {
    private List<qw> a = new ArrayList();
    private int b;
    private int c;
    private qx d = null;
    private boolean e = true;
    private float f;
    private float g = 0.0f;
    private String h;
    private sl i;
    private sf j;

    public sw(sl slVar, rb rbVar) {
        this.i = slVar;
        this.j = slVar.e();
        this.h = j();
        this.b = rbVar.d();
        b(rbVar.a());
        this.e = rbVar.f();
        this.f = rbVar.b();
        this.g = rbVar.e();
        this.c = rbVar.c();
    }

    private void b(List<qw> list) {
        qx$a a = qx.a();
        this.a.clear();
        if (list != null) {
            Object obj = null;
            for (qw qwVar : list) {
                if (!qwVar.equals(obj)) {
                    this.a.add(qwVar);
                    a.a(qwVar);
                    obj = qwVar;
                }
            }
            int size = this.a.size();
            if (size > 1 && ((qw) this.a.get(0)).equals((qw) this.a.get(size - 1))) {
                this.a.remove(size - 1);
            }
        }
        this.d = a.a();
    }

    public float a() {
        return this.f;
    }

    public void a(float f) {
        this.f = f;
        this.i.a(false, false);
    }

    public void a(int i) {
        this.b = i;
        this.i.a(false, false);
    }

    public void a(Canvas canvas) {
        if (this.a != null && this.a.size() != 0) {
            Path path = new Path();
            qw qwVar = (qw) this.a.get(0);
            PointF pointF = new PointF();
            PointF a = this.i.b().a(qwVar);
            path.moveTo(a.x, a.y);
            for (int i = 1; i < this.a.size(); i++) {
                qwVar = (qw) this.a.get(i);
                PointF pointF2 = new PointF();
                a = this.i.b().a(qwVar);
                path.lineTo(a.x, a.y);
            }
            Paint paint = new Paint();
            paint.setColor(b());
            paint.setAntiAlias(true);
            paint.setStyle(Style.FILL);
            path.close();
            canvas.drawPath(path, paint);
            if (!sz.a(a(), 0.0f)) {
                paint.setStyle(Style.STROKE);
                paint.setColor(d());
                paint.setStrokeWidth(a());
                canvas.drawPath(path, paint);
            }
        }
    }

    public void a(List<qw> list) {
        b((List) list);
        this.i.a(false, false);
    }

    public boolean a(qw qwVar) {
        return sz.a(qwVar, c());
    }

    public boolean a(sv svVar) {
        return equals(svVar) || svVar.j().equals(j());
    }

    public int b() {
        return this.b;
    }

    public void b(float f) {
        this.g = f;
        this.j.c();
        this.i.a(false, false);
    }

    public void b(int i) {
        this.c = i;
        this.i.a(false, false);
    }

    public void b(boolean z) {
        this.e = z;
        this.i.a(false, false);
    }

    public List<qw> c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public boolean h() {
        if (this.d == null) {
            return false;
        }
        qx c = this.i.b().c();
        return c == null ? true : this.d.a(c) || this.d.b(c);
    }

    public void i() {
        this.j.b(j());
    }

    public String j() {
        if (this.h == null) {
            this.h = sf.a("Polygon");
        }
        return this.h;
    }

    public float k() {
        return this.g;
    }

    public boolean l() {
        return this.e;
    }

    public int m() {
        return super.hashCode();
    }

    public void n() {
    }
}
