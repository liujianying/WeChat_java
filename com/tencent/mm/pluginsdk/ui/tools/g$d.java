package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

public class g$d extends Drawable {
    static final Paint qSX = new Paint(6);
    WeakReference<Bitmap> qSY = new WeakReference(null);
    private boolean qSZ = false;
    private boolean qTa = false;
    final Rect rD = new Rect();

    public static void b(ImageView imageView, Bitmap bitmap) {
        boolean z;
        boolean z2 = true;
        Drawable g_d = imageView.getDrawable() instanceof g$d ? (g$d) imageView.getDrawable() : new g$d();
        g_d.qSY = new WeakReference(bitmap);
        if (imageView.getScaleType() == ScaleType.FIT_XY) {
            z = true;
        } else {
            z = false;
        }
        g_d.qSZ = z;
        if (imageView.getScaleType() != ScaleType.CENTER_CROP) {
            z2 = false;
        }
        g_d.qTa = z2;
        imageView.setImageDrawable(g_d);
        imageView.postInvalidate();
    }

    public static void d(ImageView imageView) {
        b(imageView, null);
    }

    public final void draw(Canvas canvas) {
        Object obj;
        Bitmap bitmap = (Bitmap) this.qSY.get();
        if (bitmap == null || bitmap.isRecycled()) {
            obj = null;
        } else {
            copyBounds(this.rD);
            canvas.drawBitmap(bitmap, null, this.rD, qSX);
            obj = 1;
        }
        if (obj == null) {
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
