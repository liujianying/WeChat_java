package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;

public final class CircleProgressDrawable extends Drawable {
    private static final RectF gEE = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF gEF = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private Paint cN;
    private int gEG = Math.round(ad.getResources().getDisplayMetrics().density * 48.0f);
    private int gEH = 4;
    private boolean gEI = false;
    private int gEJ = 0;
    public RingPathTransform gEK = new RingPathTransform((byte) 0);
    public RingRotation gEL = new RingRotation((byte) 0);
    public ArrayList<Animator> jC = new ArrayList();
    public int jV = -16777216;

    public final void start() {
        Object obj;
        Iterator it = this.jC.iterator();
        while (it.hasNext()) {
            if (((Animator) it.next()).isStarted()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            it = this.jC.iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).start();
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        Iterator it = this.jC.iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).end();
        }
    }

    public final int getIntrinsicWidth() {
        return this.gEG;
    }

    public final int getIntrinsicHeight() {
        return this.gEG;
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() != 0 && bounds.height() != 0) {
            int save;
            if (this.cN == null) {
                this.cN = new Paint();
                this.cN.setAntiAlias(true);
                this.cN.setStyle(Style.STROKE);
                this.cN.setStrokeWidth((float) this.gEH);
                this.cN.setStrokeCap(Cap.SQUARE);
                this.cN.setStrokeJoin(Join.MITER);
            }
            int save2 = canvas.save();
            canvas.translate((float) bounds.left, (float) bounds.top);
            int width = bounds.width();
            int height = bounds.height();
            Paint paint = this.cN;
            canvas.scale(((float) width) / gEE.width(), ((float) height) / gEE.height());
            canvas.translate(gEE.width() / 2.0f, gEE.height() / 2.0f);
            if (this.gEI) {
                save = canvas.save();
                paint.setColor(this.gEJ);
                canvas.drawArc(gEF, 0.0f, 360.0f, false, paint);
                canvas.restoreToCount(save);
            }
            save = canvas.save();
            paint.setColor(this.jV);
            canvas.rotate(RingRotation.a(this.gEL));
            Canvas canvas2 = canvas;
            canvas2.drawArc(gEF, -90.0f + ((this.gEK.kd + this.gEK.kb) * 360.0f), 360.0f * (this.gEK.kc - this.gEK.kb), false, paint);
            canvas.restoreToCount(save);
            canvas.restoreToCount(save2);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }
}
