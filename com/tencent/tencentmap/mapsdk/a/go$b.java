package com.tencent.tencentmap.mapsdk.a;

class go$b extends go {
    Object d;

    go$b(float f, Object obj) {
        this.a = f;
        this.d = obj;
        this.c = obj != null;
        this.b = this.c ? obj.getClass() : Object.class;
    }

    public Object a() {
        return this.d;
    }

    /* renamed from: e */
    public go$b d() {
        go$b go_b = new go$b(b(), this.d);
        go_b.a(c());
        return go_b;
    }
}
