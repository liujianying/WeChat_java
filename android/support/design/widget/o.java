package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.a$c;
import android.support.v7.c.a.a;

final class o extends a {
    static final double gk = Math.cos(Math.toRadians(45.0d));
    float cY;
    final Paint gl;
    final Paint gm;
    final RectF gn;
    float go;
    Path gp;
    float gq;
    float gr;
    float gs;
    float gt;
    private boolean gu = true;
    private final int gv;
    private final int gw;
    private final int gx;
    boolean gy = true;
    private boolean gz = false;

    public o(Resources resources, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.gv = resources.getColor(a$c.design_fab_shadow_start_color);
        this.gw = resources.getColor(a$c.design_fab_shadow_mid_color);
        this.gx = resources.getColor(a$c.design_fab_shadow_end_color);
        this.gl = new Paint(5);
        this.gl.setStyle(Style.FILL);
        this.go = (float) Math.round(f);
        this.gn = new RectF();
        this.gm = new Paint(this.gl);
        this.gm.setAntiAlias(false);
        o(f2, f3);
    }

    private static int n(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public final void setAlpha(int i) {
        super.setAlpha(i);
        this.gl.setAlpha(i);
        this.gm.setAlpha(i);
    }

    protected final void onBoundsChange(Rect rect) {
        this.gu = true;
    }

    final void o(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float n = (float) n(f);
        float n2 = (float) n(f2);
        if (n > n2) {
            if (!this.gz) {
                this.gz = true;
            }
            n = n2;
        }
        if (this.gt != n || this.gr != n2) {
            this.gt = n;
            this.gr = n2;
            this.gs = (float) Math.round(n * 1.5f);
            this.gq = n2;
            this.gu = true;
            invalidateSelf();
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) c(this.gr, this.go, this.gy));
        int ceil2 = (int) Math.ceil((double) d(this.gr, this.go, this.gy));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float c(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - gk) * ((double) f2)));
        }
        return 1.5f * f;
    }

    public static float d(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - gk) * ((double) f2)));
        }
        return f;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        if (this.gu) {
            Rect bounds = getBounds();
            float f2 = this.gr * 1.5f;
            this.gn.set(((float) bounds.left) + this.gr, ((float) bounds.top) + f2, ((float) bounds.right) - this.gr, ((float) bounds.bottom) - f2);
            this.mDrawable.setBounds((int) this.gn.left, (int) this.gn.top, (int) this.gn.right, (int) this.gn.bottom);
            RectF rectF = new RectF(-this.go, -this.go, this.go, this.go);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.gs, -this.gs);
            if (this.gp == null) {
                this.gp = new Path();
            } else {
                this.gp.reset();
            }
            this.gp.setFillType(FillType.EVEN_ODD);
            this.gp.moveTo(-this.go, 0.0f);
            this.gp.rLineTo(-this.gs, 0.0f);
            this.gp.arcTo(rectF2, 180.0f, 90.0f, false);
            this.gp.arcTo(rectF, 270.0f, -90.0f, false);
            this.gp.close();
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.go / f3;
                f = f4 + ((1.0f - f4) / 2.0f);
                this.gl.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.gv, this.gw, this.gx}, new float[]{0.0f, f4, f, 1.0f}, TileMode.CLAMP));
            }
            this.gm.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.gv, this.gw, this.gx}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.gm.setAntiAlias(false);
            this.gu = false;
        }
        int save = canvas.save();
        canvas.rotate(this.cY, this.gn.centerX(), this.gn.centerY());
        float f5 = (-this.go) - this.gs;
        f = this.go;
        Object obj = this.gn.width() - (2.0f * f) > 0.0f ? 1 : null;
        Object obj2 = this.gn.height() - (2.0f * f) > 0.0f ? 1 : null;
        float f6 = f / ((this.gt - (this.gt * 0.5f)) + f);
        float f7 = f / ((this.gt - (this.gt * 0.25f)) + f);
        float f8 = f / (f + (this.gt - (this.gt * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.gn.left + f, this.gn.top + f);
        canvas.scale(f6, f7);
        canvas.drawPath(this.gp, this.gl);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.gn.width() - (2.0f * f), -this.go, this.gm);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.gn.right - f, this.gn.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(180.0f);
        canvas.drawPath(this.gp, this.gl);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.gn.width() - (2.0f * f), this.gs + (-this.go), this.gm);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.gn.left + f, this.gn.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(270.0f);
        canvas.drawPath(this.gp, this.gl);
        if (obj2 != null) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.gn.height() - (2.0f * f), -this.go, this.gm);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.gn.right - f, this.gn.top + f);
        canvas.scale(f6, f7);
        canvas.rotate(90.0f);
        canvas.drawPath(this.gp, this.gl);
        if (obj2 != null) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f5, this.gn.height() - (2.0f * f), -this.go, this.gm);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
        super.draw(canvas);
    }
}
