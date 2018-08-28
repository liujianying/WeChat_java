package com.tencent.mm.t;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d implements Cloneable {
    private static int dnZ = a.aH(12.0f);
    private static Paint dob;
    private LinkedList<b> bCE;
    public int bCF;
    private float dD;
    private Bitmap doa;
    private Path ks;

    public static class b {
        public float centerX;
        public float centerY;
        public int color = 0;
        public float rotation = 0.0f;
        public float scale = 0.0f;

        public b(float f, int i, float f2, float f3, float f4) {
            this.scale = f;
            this.color = i;
            this.rotation = f2;
            this.centerX = f3;
            this.centerY = f4;
        }
    }

    static {
        Paint paint = new Paint();
        dob = paint;
        paint.setAntiAlias(true);
        dob.setStyle(Style.STROKE);
        dob.setColor(-16776961);
        dob.setStrokeCap(Cap.ROUND);
    }

    public d(int i, Path path, float f, Bitmap bitmap) {
        this.bCF = i;
        this.doa = bitmap;
        this.ks = path;
        this.dD = f;
        dob.setStrokeWidth(((float) a.aH(24.0f)) * f);
    }

    public d(int i, a<LinkedList> aVar, float f) {
        this.bCF = i;
        this.bCE = aVar;
        this.dD = f;
        dob.setStrokeWidth(((float) a.aH(24.0f)) * f);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap;
        if (this.bCF == a.doc) {
            bitmap = this.doa;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.saveLayer(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), null, 31);
                canvas.drawColor(0, Mode.CLEAR);
                canvas.drawPath(this.ks, dob);
                dob.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, dob);
                dob.setXfermode(null);
                canvas.restore();
            }
        } else if (this.bCF == a.dod && this.bCE.size() > 0) {
            float width;
            float f;
            b bVar = (b) this.bCE.getLast();
            float f2 = bVar.scale;
            int i = bVar.color;
            int random = (int) (Math.random() * 100.0d);
            float f3 = ((float) dnZ) * f2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(ad.getContext().getResources(), com.tencent.mm.bd.a.d.mosaic_brush_two, options);
            options.inSampleSize = a.a(options, Math.round((((float) options.outWidth) * f2) * 0.7f), Math.round((f2 * ((float) options.outHeight)) * 0.7f));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeResource(ad.getContext().getResources(), com.tencent.mm.bd.a.d.mosaic_brush_two, options);
            dob.setStyle(Style.FILL);
            dob.setColorFilter(new LightingColorFilter(i, 1));
            if (bitmap != null) {
                width = bVar.centerX - ((((float) bitmap.getWidth()) * 1.0f) / 2.0f);
                f2 = bVar.centerY - ((((float) bitmap.getHeight()) * 1.0f) / 2.0f);
            } else {
                f2 = 0.0f;
                width = 0.0f;
            }
            if (random > 0 && random <= 20) {
                width += f3;
                f = f2 + f3;
            } else if (80 < random) {
                width -= f3;
                f = f2 - f3;
            } else {
                f = f2;
            }
            canvas.save();
            canvas.rotate(-bVar.rotation, bVar.centerX, bVar.centerY);
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, width, f, dob);
            }
            canvas.restore();
            dob.setStyle(Style.STROKE);
            dob.setColorFilter(null);
        }
    }

    public static void clear() {
    }
}
