package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.b.b;

class d extends Drawable {
    final Paint cN = new Paint(1);
    final Rect cO = new Rect();
    final RectF cP = new RectF();
    float cQ;
    int cR;
    int cS;
    int cT;
    int cU;
    private ColorStateList cV;
    private int cW;
    boolean cX = true;
    float cY;

    public d() {
        this.cN.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas) {
        float height;
        if (this.cX) {
            Paint paint = this.cN;
            Rect rect = this.cO;
            copyBounds(rect);
            height = this.cQ / ((float) rect.height());
            float f = 0.0f;
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, f, (float) rect.bottom, new int[]{b.n(this.cR, this.cW), b.n(this.cS, this.cW), b.n(b.o(this.cS, 0), this.cW), b.n(b.o(this.cU, 0), this.cW), b.n(this.cU, this.cW), b.n(this.cT, this.cW)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP));
            this.cX = false;
        }
        height = this.cN.getStrokeWidth() / 2.0f;
        RectF rectF = this.cP;
        copyBounds(this.cO);
        rectF.set(this.cO);
        rectF.left += height;
        rectF.top += height;
        rectF.right -= height;
        rectF.bottom -= height;
        canvas.save();
        canvas.rotate(this.cY, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.cN);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.cQ);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.cN.setAlpha(i);
        invalidateSelf();
    }

    final void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.cW = colorStateList.getColorForState(getState(), this.cW);
        }
        this.cV = colorStateList;
        this.cX = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.cN.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.cQ > 0.0f ? -3 : -2;
    }

    protected void onBoundsChange(Rect rect) {
        this.cX = true;
    }

    public boolean isStateful() {
        return (this.cV != null && this.cV.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.cV != null) {
            int colorForState = this.cV.getColorForState(iArr, this.cW);
            if (colorForState != this.cW) {
                this.cX = true;
                this.cW = colorForState;
            }
        }
        if (this.cX) {
            invalidateSelf();
        }
        return this.cX;
    }
}
