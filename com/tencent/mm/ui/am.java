package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public final class am {
    public static Bitmap b(int i, int i2, Config config) {
        Bitmap bitmap = null;
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
            return bitmap;
        }
    }
}
