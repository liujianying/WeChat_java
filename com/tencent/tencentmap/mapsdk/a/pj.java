package com.tencent.tencentmap.mapsdk.a;

public final class pj {
    public final ox a;
    public final ox b;
    public final ox c;
    public final ox d;
    public final oy e;

    public pj(ox oxVar, ox oxVar2, ox oxVar3, ox oxVar4, oy oyVar) {
        this.a = oxVar;
        this.b = oxVar2;
        this.c = oxVar3;
        this.d = oxVar4;
        this.e = oyVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pj)) {
            return false;
        }
        pj pjVar = (pj) obj;
        if (this.a.equals(pjVar.a) && this.b.equals(pjVar.b) && this.c.equals(pjVar.c) && this.d.equals(pjVar.d) && this.e.equals(pjVar.e)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "nearLeft" + this.a + "nearRight" + this.b + "farLeft" + this.c + "farRight" + this.d + "latLngBounds" + this.e;
    }
}
