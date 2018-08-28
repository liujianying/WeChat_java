package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

final class b {
    private static a<Paint> teE = new a();
    private static a<float[]> teF = new a();
    private static a<Matrix> teG = new a();
    private static a<Path> teH = new a();
    private static final float[] teI = new float[9];

    protected static synchronized void d(Looper looper) {
        synchronized (b.class) {
            teE.c(looper);
            teF.c(looper);
            teG.c(looper);
            teH.c(looper);
        }
    }

    protected static synchronized Paint a(Looper looper, Paint paint) {
        Paint paint2;
        synchronized (b.class) {
            paint2 = (Paint) teE.cof();
            if (paint2 == null) {
                paint2 = new Paint();
            } else {
                paint2.reset();
            }
            if (paint != null) {
                paint2.set(paint);
            }
            teE.a(looper, paint2);
        }
        return paint2;
    }

    protected static synchronized float[] e(Looper looper) {
        Object obj;
        synchronized (b.class) {
            obj = (float[]) teF.cof();
            if (obj == null) {
                obj = new float[9];
            } else {
                System.arraycopy(teI, 0, obj, 0, 9);
            }
            teF.a(looper, obj);
        }
        return obj;
    }

    protected static synchronized Matrix f(Looper looper) {
        Matrix matrix;
        synchronized (b.class) {
            matrix = (Matrix) teG.cof();
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            teG.a(looper, matrix);
        }
        return matrix;
    }

    protected static synchronized Path g(Looper looper) {
        Path path;
        synchronized (b.class) {
            path = (Path) teH.cof();
            if (path == null) {
                path = new Path();
            } else {
                path.reset();
            }
            teH.a(looper, path);
        }
        return path;
    }
}
