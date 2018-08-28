package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public abstract class i extends Drawable {
    public final Paint cN = new Paint(3);
    public float go;
    public final Bitmap mBitmap;
    private int rA = 119;
    public final BitmapShader rB;
    private final Matrix rC = new Matrix();
    final Rect rD = new Rect();
    private final RectF rE = new RectF();
    private boolean rF = true;
    public boolean rG;
    private int rH;
    private int rI;
    private int rz = 160;

    public void setFilterBitmap(boolean z) {
        this.cN.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.cN.setDither(z);
        invalidateSelf();
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    final void bG() {
        if (this.rF) {
            if (this.rG) {
                int min = Math.min(this.rH, this.rI);
                a(this.rA, min, min, getBounds(), this.rD);
                int min2 = Math.min(this.rD.width(), this.rD.height());
                this.rD.inset(Math.max(0, (this.rD.width() - min2) / 2), Math.max(0, (this.rD.height() - min2) / 2));
                this.go = ((float) min2) * 0.5f;
            } else {
                a(this.rA, this.rH, this.rI, getBounds(), this.rD);
            }
            this.rE.set(this.rD);
            if (this.rB != null) {
                this.rC.setTranslate(this.rE.left, this.rE.top);
                this.rC.preScale(this.rE.width() / ((float) this.mBitmap.getWidth()), this.rE.height() / ((float) this.mBitmap.getHeight()));
                this.rB.setLocalMatrix(this.rC);
                this.cN.setShader(this.rB);
            }
            this.rF = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bG();
            if (this.cN.getShader() == null) {
                canvas.drawBitmap(bitmap, null, this.rD, this.cN);
            } else {
                canvas.drawRoundRect(this.rE, this.go, this.go, this.cN);
            }
        }
    }

    public void setAlpha(int i) {
        if (i != this.cN.getAlpha()) {
            this.cN.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.cN.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.cN.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.cN.getColorFilter();
    }

    public final void bH() {
        this.rG = true;
        this.rF = true;
        bI();
        this.cN.setShader(this.rB);
        invalidateSelf();
    }

    private void bI() {
        this.go = (float) (Math.min(this.rI, this.rH) / 2);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.rG) {
            bI();
        }
        this.rF = true;
    }

    public int getIntrinsicWidth() {
        return this.rH;
    }

    public int getIntrinsicHeight() {
        return this.rI;
    }

    public int getOpacity() {
        if (this.rA != 119 || this.rG) {
            return -3;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.hasAlpha() || this.cN.getAlpha() < 255 || r(this.go)) {
            return -3;
        }
        return -1;
    }

    i(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.rz = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            this.rH = this.mBitmap.getScaledWidth(this.rz);
            this.rI = this.mBitmap.getScaledHeight(this.rz);
            this.rB = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            return;
        }
        this.rI = -1;
        this.rH = -1;
        this.rB = null;
    }

    public static boolean r(float f) {
        return f > 0.05f;
    }
}
