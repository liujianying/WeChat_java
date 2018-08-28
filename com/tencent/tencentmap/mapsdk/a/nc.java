package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;

public class nc {
    private final int a;
    private final int b;
    private final int c;
    private final String d;
    private boolean e = false;
    private Bitmap f = null;
    private volatile boolean g = false;

    public nc(int i, int i2, int i3, String str) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nc)) {
            return false;
        }
        nc ncVar = (nc) obj;
        if (this.a == ncVar.a && this.b == ncVar.b && this.c == ncVar.c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a * 7) + (this.b * 11)) + (this.c * 13);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append(this.a);
        stringBuilder.append("-");
        stringBuilder.append(this.b);
        stringBuilder.append("-");
        stringBuilder.append(this.c);
        stringBuilder.append("-");
        stringBuilder.append(this.d);
        return stringBuilder.toString();
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public void a(Bitmap bitmap) {
        this.f = bitmap;
    }
}
