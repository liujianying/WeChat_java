package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;

public final class qq implements Cloneable {
    int a = 0;
    int b = 0;
    Bitmap c;

    public qq(Bitmap bitmap) {
        if (bitmap != null) {
            this.a = bitmap.getWidth();
            this.b = bitmap.getHeight();
            this.c = bitmap;
        }
    }

    private qq(Bitmap bitmap, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = bitmap;
    }

    /* renamed from: a */
    public final qq clone() {
        return new qq(Bitmap.createBitmap(this.c), this.a, this.b);
    }

    public final Bitmap b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }
}
