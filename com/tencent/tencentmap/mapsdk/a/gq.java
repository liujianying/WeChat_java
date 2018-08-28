package com.tencent.tencentmap.mapsdk.a;

public final class gq extends gu {
    int b;

    public final void a(int i) {
        if (this.e != null) {
            gr grVar = this.e[0];
            this.f.remove(Integer.valueOf(grVar.b()));
            this.f.put(Integer.valueOf(i), grVar);
        }
        this.b = i;
    }

    private gq(gh ghVar, int i) {
        super(ghVar);
        a(i);
    }

    public static gq a(gh ghVar, int i, double... dArr) {
        gq gqVar = new gq(ghVar, i);
        gqVar.a(dArr);
        return gqVar;
    }

    public static gq a(gh ghVar, int i, gt gtVar, Object... objArr) {
        gq gqVar = new gq(ghVar, i);
        gqVar.a(objArr);
        gqVar.a(gtVar);
        return gqVar;
    }

    public final void a(double... dArr) {
        if (this.e == null || this.e.length == 0) {
            a(new gr[]{gr.a(this.b, dArr)});
            return;
        }
        super.a(dArr);
    }

    public final void a(Object... objArr) {
        if (this.e == null || this.e.length == 0) {
            a(new gr[]{gr.a(this.b, null, objArr)});
            return;
        }
        super.a(objArr);
    }

    /* renamed from: b */
    public final gq clone() {
        return (gq) super.a();
    }

    public final String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.g;
        if (this.e != null) {
            for (gr grVar : this.e) {
                str = str + "\n    " + grVar.toString();
            }
        }
        return str;
    }
}
