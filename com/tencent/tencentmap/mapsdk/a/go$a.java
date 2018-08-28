package com.tencent.tencentmap.mapsdk.a;

class go$a extends go {
    double d;

    go$a(float f, double d) {
        this.a = f;
        this.d = d;
        this.b = Double.TYPE;
        this.c = true;
    }

    go$a(float f) {
        this.a = f;
        this.b = Double.TYPE;
    }

    public Object a() {
        return Double.valueOf(this.d);
    }

    /* renamed from: e */
    public go$a d() {
        go$a go_a = new go$a(b(), this.d);
        go_a.a(c());
        return go_a;
    }
}
