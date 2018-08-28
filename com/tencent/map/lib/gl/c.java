package com.tencent.map.lib.gl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLUtils;
import javax.microedition.khronos.opengles.GL10;

public class c {
    public static Bitmap a(Bitmap bitmap) {
        int i = 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = 2;
        while (i2 < width) {
            i2 <<= 1;
        }
        while (i < height) {
            i <<= 1;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(false);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i, Config.ARGB_8888);
            createBitmap.setDensity(0);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setDensity(0);
            createBitmap.eraseColor(0);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static int a(GL10 gl10, Bitmap bitmap) {
        int b = b(gl10);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return b;
    }

    private static int a(GL10 gl10) {
        int[] iArr = new int[1];
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private static int b(GL10 gl10) {
        int a = a(gl10);
        gl10.glBindTexture(3553, a);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
        gl10.glTexParameterf(3553, 10242, 33071.0f);
        gl10.glTexParameterf(3553, 10243, 33071.0f);
        return a;
    }
}
