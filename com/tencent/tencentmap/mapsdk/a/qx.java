package com.tencent.tencentmap.mapsdk.a;

public class qx {
    private int a;
    private qw b;
    private qw c;

    qx(int i, qw qwVar, qw qwVar2) {
        a a = new a().a(qwVar).a(qwVar2);
        this.b = new qw(a.a(a), a.b(a));
        this.c = new qw(a.c(a), a.d(a));
        this.a = i;
    }

    public qx(qw qwVar, qw qwVar2) {
        this(1, qwVar, qwVar2);
    }

    public static a a() {
        return new a();
    }

    private boolean a(double d) {
        return this.b.b() <= d && d <= this.c.b();
    }

    private boolean b(double d) {
        return this.b.c() <= this.c.c() ? this.b.c() <= d && d <= this.c.c() : this.b.c() <= d || d <= this.c.c();
    }

    private static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private boolean c(qx qxVar) {
        if (qxVar == null || qxVar.c == null || qxVar.b == null || this.c == null || this.b == null) {
            return false;
        }
        return Math.abs(((qxVar.c.c() + qxVar.b.c()) - this.c.c()) - this.b.c()) < ((this.c.c() - this.b.c()) + qxVar.c.c()) - qxVar.b.c() && Math.abs(((qxVar.c.b() + qxVar.b.b()) - this.c.b()) - this.b.b()) < ((this.c.b() - this.b.b()) + qxVar.c.b()) - qxVar.b.b();
    }

    private static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public boolean a(qw qwVar) {
        return a(qwVar.b()) && b(qwVar.c());
    }

    public boolean a(qx qxVar) {
        return qxVar != null && a(qxVar.b) && a(qxVar.c);
    }

    public qw b() {
        return this.b;
    }

    public boolean b(qx qxVar) {
        return qxVar == null ? false : c(qxVar) || qxVar.c(this);
    }

    public qw c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qx)) {
            return false;
        }
        qx qxVar = (qx) obj;
        return this.b.equals(qxVar.b) && this.c.equals(qxVar.c);
    }

    public final int hashCode() {
        return sz.a(new Object[]{this.b, this.c});
    }

    public final String toString() {
        return sz.a(new String[]{sz.a("southwest", this.b), sz.a("northeast", this.c)});
    }
}
