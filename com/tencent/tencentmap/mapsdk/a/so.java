package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import com.tencent.smtt.sdk.WebView;

public class so implements sv {
    private qw a = null;
    private double b = 0.0d;
    private float c = 10.0f;
    private int d = WebView.NIGHT_MODE_COLOR;
    private int e = 0;
    private float f = 0.0f;
    private boolean g = true;
    private boolean h = false;
    private DashPathEffect i = null;
    private DashPathEffect j;
    private String k;
    private sl l;
    private sf m;

    public so(sl slVar, qu quVar) {
        this.l = slVar;
        this.m = slVar.e();
        this.k = j();
        this.e = quVar.e();
        this.a = quVar.a();
        this.g = quVar.g();
        this.c = quVar.c();
        this.f = quVar.f();
        this.d = quVar.d();
        this.b = quVar.b();
        this.h = quVar.h();
        this.i = quVar.i();
        this.j = new DashPathEffect(new float[]{this.c, this.c}, 0.0f);
    }

    public qw a() {
        return this.a;
    }

    public void a(double d) {
        this.b = d;
        this.l.a(false, false);
    }

    public void a(float f) {
        this.c = f;
        this.j = new DashPathEffect(new float[]{this.c, this.c}, 0.0f);
        this.l.a(false, false);
    }

    public void a(int i) {
        this.d = i;
        this.l.a(false, false);
    }

    public void a(Canvas canvas) {
        if (a() != null && this.b > 0.0d && l()) {
            float a = this.l.b().a(this.a.b(), (double) ((float) b()));
            PointF a2 = this.l.b().a(this.a);
            Paint paint = new Paint();
            paint.setColor(e());
            paint.setAntiAlias(true);
            paint.setStyle(Style.FILL);
            canvas.drawCircle(a2.x, a2.y, a, paint);
            if (!sz.a(c(), 0.0f)) {
                if (this.h) {
                    if (this.i == null) {
                        paint.setPathEffect(this.j);
                    } else {
                        paint.setPathEffect(this.i);
                    }
                }
                paint.setColor(d());
                paint.setStyle(Style.STROKE);
                paint.setStrokeWidth(c());
                canvas.drawCircle(a2.x, a2.y, a, paint);
            }
        }
    }

    public void a(DashPathEffect dashPathEffect) {
        this.i = dashPathEffect;
    }

    public void a(qw qwVar) {
        this.a = qwVar;
        this.l.a(false, false);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean a(sv svVar) {
        return equals(svVar) || svVar.j().equals(j());
    }

    public double b() {
        return this.b;
    }

    public void b(float f) {
        this.f = f;
        this.m.c();
        this.l.a(false, false);
    }

    public void b(int i) {
        this.e = i;
        this.l.a(false, false);
    }

    public void b(boolean z) {
        this.g = z;
        this.l.a(false, false);
    }

    public boolean b(qw qwVar) {
        return this.b >= rv.a(this.a, qwVar);
    }

    public float c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public boolean f() {
        return this.h;
    }

    public DashPathEffect g() {
        return this.i;
    }

    public boolean h() {
        return true;
    }

    public void i() {
        this.m.b(j());
    }

    public String j() {
        if (this.k == null) {
            this.k = sf.a("Circle");
        }
        return this.k;
    }

    public float k() {
        return this.f;
    }

    public boolean l() {
        return this.g;
    }

    public int m() {
        return 0;
    }

    public void n() {
        this.a = null;
    }
}
