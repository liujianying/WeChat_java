package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import g.a;

public final class f extends a {
    private static int mNc = 10;
    private final byte[] mNb;

    public f(Bitmap bitmap, int i, int i2) {
        super(bitmap.getWidth() - i, bitmap.getHeight() - i2);
        int width = bitmap.getWidth() - i;
        int height = bitmap.getHeight() - i2;
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, i / 2, i2 / 2, width, height);
        this.mNb = new byte[(width * height)];
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                int i6 = iArr[i4 + i5];
                int i7 = (i6 >> 16) & 255;
                int i8 = (i6 >> 8) & 255;
                i6 &= 255;
                if (i7 == i8 && i8 == i6) {
                    this.mNb[i4 + i5] = (byte) i7;
                } else {
                    this.mNb[i4 + i5] = (byte) ((i6 + ((i7 + i8) + i8)) >> 2);
                }
            }
        }
    }

    public final byte[] m(int i, byte[] bArr) {
        if (i < 0 || i >= this.height) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        Object bArr2;
        int i2 = this.width;
        if (bArr2 == null || bArr2.length < i2) {
            bArr2 = new byte[i2];
        }
        System.arraycopy(this.mNb, i * i2, bArr2, 0, i2);
        return bArr2;
    }

    public final byte[] bsX() {
        return this.mNb;
    }
}
