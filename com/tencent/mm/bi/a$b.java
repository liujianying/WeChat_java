package com.tencent.mm.bi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Looper;
import com.tencent.mm.api.j;
import com.tencent.mm.d.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class a$b implements Runnable {
    j qVA;
    boolean qVB;
    final /* synthetic */ a qVu;

    a$b(a aVar, j jVar, boolean z) {
        this.qVu = aVar;
        this.qVA = jVar;
        this.qVB = z;
    }

    public final void run() {
        Iterator it;
        Iterator it2;
        try {
            Bitmap bitmap;
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            it = this.qVu.qVn.iterator();
            while (it.hasNext()) {
                ((b) it.next()).vJ();
            }
            Bitmap bitmap2 = null;
            if (this.qVu.qVl.getBaseBoardView().cCg()) {
                bitmap = this.qVu.qVp;
            } else {
                int width = this.qVu.qVl.getBaseBoardView().getAliveRect().width();
                int height = this.qVu.qVl.getBaseBoardView().getAliveRect().height();
                if (width > 0 && height > 0) {
                    bitmap2 = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                }
                bitmap = bitmap2;
            }
            if (bitmap == null) {
                this.qVA.c(new NullPointerException("bitmap is null!"));
                try {
                    it2 = this.qVu.qVn.iterator();
                    while (it2.hasNext()) {
                        ((b) it2.next()).onFinish();
                    }
                    this.qVu.onDestroy();
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            Canvas canvas = new Canvas(bitmap);
            Iterator it3 = this.qVu.qVn.iterator();
            while (it3.hasNext()) {
                ((b) it3.next()).vG().c(canvas);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.qVu.bwU.path, options);
            float height2 = (((float) options.outHeight) * 1.0f) / ((float) bitmap.getHeight());
            float width2 = (((float) options.outWidth) * 1.0f) / ((float) bitmap.getWidth());
            if (height2 <= width2) {
                height2 = width2;
            }
            if (height2 == 0.0f) {
                height2 = 1.0f;
            }
            float a = this.qVu.qVl.getBaseBoardView().a(this.qVu.qVl.getBaseBoardView().getMainMatrix());
            Matrix matrix = new Matrix();
            matrix.postScale(height2, height2, 0.0f, 0.0f);
            matrix.postRotate(-a);
            Rect rect = new Rect(this.qVu.qVl.getBaseBoardView().getAliveRect());
            x.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[]{rect, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            if (rect.left < 0) {
                rect.left = 0;
            }
            if (rect.top < 0) {
                rect.top = 0;
            }
            if (rect.bottom < 0) {
                rect.bottom = 0;
            }
            if (rect.right < 0) {
                rect.right = 0;
            }
            if (rect.bottom > bitmap.getHeight()) {
                rect.bottom = bitmap.getHeight();
            }
            if (rect.right > bitmap.getWidth()) {
                rect.right = bitmap.getWidth();
            }
            this.qVA.a(a(bitmap, rect, a, options, matrix), this.qVB);
            try {
                it2 = this.qVu.qVn.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).onFinish();
                }
                this.qVu.onDestroy();
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            this.qVA.c(e3);
            try {
                it2 = this.qVu.qVn.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).onFinish();
                }
                this.qVu.onDestroy();
            } catch (Exception e4) {
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                it = this.qVu.qVn.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).onFinish();
                }
                this.qVu.onDestroy();
            } catch (Exception e5) {
            }
        }
    }

    private static Bitmap a(Bitmap bitmap, Rect rect, float f, Options options, Matrix matrix) {
        try {
            if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                return Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DrawingPresenter", e, "", new Object[0]);
            float f2 = 1920.0f / ((float) options.outHeight);
            float f3 = 1920.0f / ((float) options.outWidth);
            if (f2 <= f3) {
                f2 = f3;
            }
            matrix.reset();
            matrix.postScale(f2, f2, 0.0f, 0.0f);
            matrix.postRotate(-f);
            if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                return Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
    }
}
