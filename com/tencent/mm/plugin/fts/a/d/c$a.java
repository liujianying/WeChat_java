package com.tencent.mm.plugin.fts.a.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public class c$a extends BitmapDrawable {
    public static void a(Resources resources, Bitmap bitmap, ImageView imageView) {
        imageView.setImageDrawable(new c$a(resources, bitmap));
        imageView.postInvalidate();
    }

    private c$a(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public final void draw(Canvas canvas) {
        if (getBitmap() != null && !getBitmap().isRecycled()) {
            super.draw(canvas);
        }
    }
}
