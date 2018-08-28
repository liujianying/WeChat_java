package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class tx implements sv {
    protected boolean a = true;
    protected float b = 0.0f;
    protected sl c;
    protected tw d;
    protected sf e;
    protected String f = j();

    public void a() {
    }

    public void a(Canvas canvas) {
        a(canvas, this.d);
    }

    protected void a(Canvas canvas, tw twVar) {
    }

    public void a(qv qvVar) {
    }

    public boolean a(MotionEvent motionEvent, tw twVar) {
        return false;
    }

    public boolean a(qv qvVar, MotionEvent motionEvent, tw twVar) {
        return false;
    }

    public boolean a(qv qvVar, tw twVar) {
        return false;
    }

    public boolean a(sv svVar) {
        return equals(svVar) || svVar.j().equals(j());
    }

    public void b(float f) {
        this.b = f;
        this.e.c();
        this.c.a(false, false);
    }

    public void b(boolean z) {
        this.a = z;
        this.c.a(false, false);
    }

    public boolean h() {
        return false;
    }

    public void i() {
        this.e.b(j());
        a();
    }

    public String j() {
        if (this.f == null) {
            this.f = sf.a("Overlay");
        }
        return this.f;
    }

    public float k() {
        return this.b;
    }

    public boolean l() {
        return this.a;
    }

    public int m() {
        return 0;
    }

    public void n() {
    }
}
