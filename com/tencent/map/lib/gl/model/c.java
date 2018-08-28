package com.tencent.map.lib.gl.model;

public class c {
    private e a;
    private e b;
    private e c;
    private f d;

    public c() {
        this.d = new f();
    }

    public c(e eVar, e eVar2, e eVar3) {
        this();
        a(eVar, eVar2, eVar3);
    }

    public c(float[] fArr) {
        this();
        a(new e(fArr[0], fArr[1], fArr[2]), new e(fArr[3], fArr[4], fArr[5]), new e(fArr[6], fArr[7], fArr[8]));
    }

    private void a(e eVar, e eVar2, e eVar3) {
        this.a = eVar;
        this.b = eVar2;
        this.c = eVar3;
        this.d.a(eVar);
        this.d.a(eVar2);
        this.d.a(eVar3);
    }

    public boolean a(float[] fArr) {
        e eVar = new e(fArr[0], fArr[1], fArr[2]);
        if (((double) Math.abs(b() - ((new c(eVar, this.a, this.b).b() + new c(eVar, this.a, this.c).b()) + new c(eVar, this.b, this.c).b()))) < 0.001d) {
            return true;
        }
        return false;
    }

    public float[] a() {
        return this.d.a();
    }

    private float b() {
        float[] a = this.d.a();
        float a2 = a(a[0], a[1], a[2], a[3], a[4], a[5]);
        float a3 = a(a[3], a[4], a[5], a[6], a[7], a[8]);
        float a4 = a(a[0], a[1], a[2], a[6], a[7], a[8]);
        float f = ((a2 + a3) + a4) / 2.0f;
        return (float) Math.sqrt((double) ((f - a4) * (((f - a2) * f) * (f - a3))));
    }

    private float a(float f, float f2, float f3, float f4, float f5, float f6) {
        return (float) Math.sqrt((double) ((((f - f4) * (f - f4)) + ((f2 - f5) * (f2 - f5))) + ((f3 - f6) * (f3 - f6))));
    }
}
