package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import android.support.v7.b.a$b;
import android.support.v7.b.a.a;

final class af extends Drawable {
    static a Ts;
    static final double gk = Math.cos(Math.toRadians(45.0d));
    final int Tr;
    final RectF Tt;
    Paint cN;
    Paint gl;
    Paint gm;
    float go;
    Path gp;
    float gq;
    float gr;
    float gs;
    float gt;
    boolean gu = true;
    private final int gv;
    private final int gx;
    private boolean gy = true;
    private boolean gz = false;

    af(Resources resources, int i, float f, float f2, float f3) {
        this.gv = resources.getColor(a.cardview_shadow_start_color);
        this.gx = resources.getColor(a.cardview_shadow_end_color);
        this.Tr = resources.getDimensionPixelSize(a$b.cardview_compat_inset_shadow);
        this.cN = new Paint(5);
        this.cN.setColor(i);
        this.gl = new Paint(5);
        this.gl.setStyle(Style.FILL);
        this.go = (float) ((int) (0.5f + f));
        this.Tt = new RectF();
        this.gm = new Paint(this.gl);
        this.gm.setAntiAlias(false);
        o(f2, f3);
    }

    private static int n(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public final void U(boolean z) {
        this.gy = z;
        invalidateSelf();
    }

    public final void setAlpha(int i) {
        this.cN.setAlpha(i);
        this.gl.setAlpha(i);
        this.gm.setAlpha(i);
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.gu = true;
    }

    final void o(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
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
                this.gs = (float) ((int) (((n * 1.5f) + ((float) this.Tr)) + 0.5f));
                this.gq = ((float) this.Tr) + n2;
                this.gu = true;
                invalidateSelf();
            }
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) c(this.gr, this.go, this.gy));
        int ceil2 = (int) Math.ceil((double) d(this.gr, this.go, this.gy));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float c(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - gk) * ((double) f2)));
        }
        return 1.5f * f;
    }

    static float d(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - gk) * ((double) f2)));
        }
        return f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.cN.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        int i;
        int i2 = 1;
        if (this.gu) {
            Rect bounds = getBounds();
            f = this.gr * 1.5f;
            this.Tt.set(((float) bounds.left) + this.gr, ((float) bounds.top) + f, ((float) bounds.right) - this.gr, ((float) bounds.bottom) - f);
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
            f = this.go / (this.go + this.gs);
            float[] fArr = new float[]{0.0f, f, 1.0f};
            f = 0.0f;
            this.gl.setShader(new RadialGradient(0.0f, f, this.go + this.gs, new int[]{this.gv, this.gv, this.gx}, fArr, TileMode.CLAMP));
            float f2 = 0.0f;
            this.gm.setShader(new LinearGradient(0.0f, (-this.go) + this.gs, f2, (-this.go) - this.gs, new int[]{this.gv, this.gv, this.gx}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.gm.setAntiAlias(false);
            this.gu = false;
        }
        canvas.translate(0.0f, this.gt / 2.0f);
        f = (-this.go) - this.gs;
        float f3 = (this.go + ((float) this.Tr)) + (this.gt / 2.0f);
        if (this.Tt.width() - (2.0f * f3) > 0.0f) {
            i = 1;
        } else {
            boolean i3 = false;
        }
        if (this.Tt.height() - (2.0f * f3) <= 0.0f) {
            i2 = 0;
        }
        int save = canvas.save();
        canvas.translate(this.Tt.left + f3, this.Tt.top + f3);
        canvas.drawPath(this.gp, this.gl);
        if (i3 != 0) {
            canvas.drawRect(0.0f, f, this.Tt.width() - (2.0f * f3), -this.go, this.gm);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.Tt.right - f3, this.Tt.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.gp, this.gl);
        if (i3 != 0) {
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, f, this.Tt.width() - (2.0f * f3), this.gs + (-this.go), this.gm);
        }
        canvas.restoreToCount(save);
        i3 = canvas.save();
        canvas.translate(this.Tt.left + f3, this.Tt.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.gp, this.gl);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.Tt.height() - (2.0f * f3), -this.go, this.gm);
        }
        canvas.restoreToCount(i3);
        i3 = canvas.save();
        canvas.translate(this.Tt.right - f3, this.Tt.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.gp, this.gl);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.Tt.height() - (2.0f * f3), -this.go, this.gm);
        }
        canvas.restoreToCount(i3);
        canvas.translate(0.0f, (-this.gt) / 2.0f);
        Ts.a(canvas, this.Tt, this.go, this.cN);
    }
}
