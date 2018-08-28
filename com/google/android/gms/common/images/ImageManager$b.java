package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import com.google.android.gms.c.o;

final class ImageManager$b extends o<a$a, Bitmap> {
    protected final /* synthetic */ int ae(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        return bitmap.getHeight() * bitmap.getRowBytes();
    }
}
