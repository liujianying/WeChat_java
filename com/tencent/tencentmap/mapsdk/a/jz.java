package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class jz {
    protected static Paint a;
    private static final String b = Bitmap.class.getCanonicalName();

    static {
        Paint paint = new Paint();
        a = paint;
        paint.setAntiAlias(true);
    }

    public static Bitmap a(View view) {
        if (view != null) {
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.setDrawingCacheEnabled(true);
            try {
                view.buildDrawingCache();
                Bitmap a = a(view.getDrawingCache());
                view.destroyDrawingCache();
                return a;
            } catch (NullPointerException e) {
            }
        }
        return null;
    }

    public static Bitmap a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return a(bitmap, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || bitmap.isRecycled() || i <= 0 || i2 <= 0) {
            return null;
        }
        Bitmap a = a(i, i2, Config.ARGB_8888);
        if (a == null) {
            return null;
        }
        Canvas canvas = new Canvas(a);
        a.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, a);
        return a;
    }

    public static Bitmap a(Bitmap bitmap, Context context, int i, int i2) {
        if (bitmap == null || bitmap.isRecycled() || i <= 0 || i2 <= 0) {
            return null;
        }
        if (i > 2048) {
            i = 2048;
        }
        if (i2 > 2048) {
            i2 = 2048;
        }
        Bitmap a = a(i, i2, Config.ARGB_8888);
        if (a == null) {
            return null;
        }
        a.eraseColor(0);
        Canvas canvas = new Canvas(a);
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, i, i2);
        bitmapDrawable.draw(canvas);
        return a;
    }

    private static Bitmap a(int i, int i2, Config config) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            try {
                return Bitmap.createBitmap(i, i2, config);
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null || f == 1.0f) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static byte[] a(Bitmap bitmap, CompressFormat compressFormat) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
