package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Gravity;
import android.view.View;
import com.tencent.mm.svg.b.c;

public abstract class b extends Drawable {
    protected View iUA;
    public long mDuration = 0;
    protected final Rect rD = new Rect();
    protected int teS = 0;
    protected boolean teT = false;
    protected Paint teU = new Paint();
    protected int teV = 0;
    protected int teW = 0;
    protected int teX = 0;
    protected int teY = 0;
    protected float teZ;

    public b(int i, int i2, int i3) {
        this.teX = i;
        this.teY = i2;
        this.teZ = 1.0f;
        this.teV = this.teX;
        this.teW = this.teY;
        setLevel(10000);
        this.teS = i3;
    }

    protected final void coh() {
        this.rD.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.teT = true;
    }

    protected boolean onLevelChange(int i) {
        coj();
        return super.onLevelChange(i);
    }

    protected final void coi() {
        if (this.teT) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.rD);
        }
        this.teT = false;
    }

    private void coj() {
        this.iUA = a.t(this);
        if (this.iUA != null) {
            a.b(this.iUA, this.teU);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        coj();
        return super.setVisible(z, z2);
    }

    @TargetApi(17)
    public void setAlpha(int i) {
        this.teU.setAlpha(i);
        if (this.iUA != null && VERSION.SDK_INT >= 17) {
            try {
                this.iUA.setLayerPaint(this.teU);
            } catch (Throwable e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        }
    }

    @TargetApi(17)
    public void setColorFilter(ColorFilter colorFilter) {
        this.teU.setColorFilter(colorFilter);
        if (this.iUA != null && VERSION.SDK_INT >= 17) {
            try {
                this.iUA.setLayerPaint(this.teU);
            } catch (Throwable e) {
                c.printErrStackTrace("MicroMsg.SVGDrawable", e, "samsung", new Object[0]);
            }
        }
    }

    public int getOpacity() {
        if (this.iUA != null && this.iUA.getAlpha() < 1.0f) {
            return -3;
        }
        if (this.teU == null || this.teU.getAlpha() >= 255) {
            return 0;
        }
        return -3;
    }

    protected final void j(Canvas canvas) {
        if (com.tencent.mm.svg.b.b.col()) {
            int height = this.rD.height() / 3;
            canvas.save();
            Paint paint = new Paint();
            paint.setStyle(Style.FILL);
            paint.setColor(-12303292);
            paint.setAlpha(127);
            paint.setTextSize((float) height);
            paint.setStrokeWidth(1.0f);
            canvas.translate(((float) this.rD.width()) - paint.measureText("SVG"), (float) ((this.rD.height() * 2) / 3));
            canvas.drawText("SVG", 0.0f, (float) height, paint);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return this.teV;
    }

    public int getIntrinsicHeight() {
        return this.teW;
    }
}
