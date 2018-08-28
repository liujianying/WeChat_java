package com.tencent.tencentmap.mapsdk.a;

public class gr implements Cloneable {
    private static final gt<Integer> d = new gn();
    private static final gt<Number> e = new gj();
    int a;
    Class<?> b;
    gp c;
    private gt f;

    private gr(int i) {
        this.c = null;
        this.a = i;
    }

    public static gr a(int i, double... dArr) {
        return new a(i, dArr);
    }

    public static gr a(int i, gt<Object> gtVar, Object... objArr) {
        gr grVar = new gr(i);
        grVar.a(objArr);
        grVar.a((gt) gtVar);
        return grVar;
    }

    public void a(double... dArr) {
        this.b = Double.TYPE;
        this.c = gp.a(dArr);
    }

    public void a(Object... objArr) {
        this.b = objArr[0].getClass();
        this.c = gp.a(objArr);
    }

    /* renamed from: a */
    public gr clone() {
        try {
            gr grVar = (gr) super.clone();
            grVar.a = this.a;
            grVar.c = this.c.clone();
            grVar.f = this.f;
            return grVar;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void a(gt gtVar) {
        this.f = gtVar;
        this.c.a(gtVar);
    }

    public int b() {
        return this.a;
    }

    public String toString() {
        return this.a + ": " + this.c.toString();
    }
}
