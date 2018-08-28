package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

class kq$d implements ih {
    private final o a;

    public kq$d(Context context) {
        if (context != null) {
            this.a = o.a(context.getApplicationContext());
        } else {
            this.a = null;
        }
    }

    public String a() {
        if (this.a != null) {
            return this.a.e();
        }
        return null;
    }

    public String b() {
        if (this.a != null) {
            return this.a.f();
        }
        return null;
    }

    public String c() {
        if (this.a != null) {
            return this.a.h();
        }
        return null;
    }

    public String d() {
        if (this.a != null) {
            return this.a.i();
        }
        return null;
    }

    public String e() {
        if (this.a != null) {
            return this.a.g();
        }
        return null;
    }
}
