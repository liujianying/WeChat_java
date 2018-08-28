package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class WxImageView extends WxBaseImageView implements g {
    protected Matrix aaA;
    private float aaO;
    private int iGn;
    private int iGo;
    private boolean lkO;
    protected ag mHandler;
    private float mKP;
    protected Bitmap nIa;
    private boolean nWI;
    private MultiTouchImageView$a nXf;
    private int orientation;
    private boolean tzA;
    private boolean tzB;
    private boolean tzC;
    private float tzD;
    private float tzE;
    private boolean tzG;
    private Drawable tzH;
    protected Matrix tzo;
    private final Matrix tzp;
    private final float[] tzq;
    int tzr;
    int tzs;
    private float tzt;
    private float tzu;
    private float tzv;
    private boolean tzw;
    private float tzx;
    private float tzy;
    private float tzz;

    public WxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tzo = new Matrix();
        this.aaA = new Matrix();
        this.tzp = new Matrix();
        this.tzq = new float[9];
        this.nIa = null;
        this.tzr = -1;
        this.tzs = -1;
        this.tzt = 0.0f;
        this.tzu = 0.0f;
        this.tzv = 0.0f;
        this.lkO = false;
        this.tzw = false;
        this.tzx = 2.0f;
        this.tzy = 0.75f;
        this.tzz = 20.0f;
        this.tzA = false;
        this.tzB = false;
        this.tzC = false;
        this.nWI = true;
        this.tzG = false;
        this.mHandler = new ag();
        this.aaO = 1.0f;
    }

    public WxImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tzo = new Matrix();
        this.aaA = new Matrix();
        this.tzp = new Matrix();
        this.tzq = new float[9];
        this.nIa = null;
        this.tzr = -1;
        this.tzs = -1;
        this.tzt = 0.0f;
        this.tzu = 0.0f;
        this.tzv = 0.0f;
        this.lkO = false;
        this.tzw = false;
        this.tzx = 2.0f;
        this.tzy = 0.75f;
        this.tzz = 20.0f;
        this.tzA = false;
        this.tzB = false;
        this.tzC = false;
        this.nWI = true;
        this.tzG = false;
        this.mHandler = new ag();
        this.aaO = 1.0f;
    }

    public final boolean crk() {
        return this.tzB;
    }

    public final boolean crl() {
        return this.tzC;
    }

    public float getScaleWidth() {
        return this.tzD;
    }

    public float getScaleHeight() {
        return this.tzE;
    }

    public float getMaxZoom() {
        return this.tzu;
    }

    public float getMinZoom() {
        return this.tzv;
    }

    public void setMaxZoomLimit(float f) {
        if (Float.compare(f, 1.0f) < 0) {
            x.w("MicroMsg.WxImageView", "max scale limit is less than 1.0, change nothing, return");
        } else {
            this.tzz = f;
        }
    }

    public void setMinZoomLimit(float f) {
        if (Float.compare(f, 1.0f) > 0) {
            x.w("MicroMsg.WxImageView", "min scale limit is greater than 1.0, change nothing, return");
        } else if (Float.compare(f, 0.0f) < 0) {
            x.w("MicroMsg.WxImageView", "min scale limit is less than 0.0, change nothing, return");
        } else {
            this.tzy = f;
        }
    }

    public void setDoubleTabScaleLimit(float f) {
        if (Float.compare(f, 0.0f) < 0) {
            x.w("MicroMsg.WxImageView", "double tab scale limit is less than 0.0, change nothing, return");
        } else {
            this.tzx = f;
        }
    }

    public void setMaxZoomDoubleTab(boolean z) {
        this.tzA = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.iGn == MeasureSpec.getSize(i) && this.iGo == MeasureSpec.getSize(i2)) {
            this.tzw = false;
        } else {
            this.tzw = true;
        }
        this.iGn = MeasureSpec.getSize(i);
        this.iGo = MeasureSpec.getSize(i2);
        x.d("MicroMsg.WxImageView", "alvinluo onMeasure viewWidth: %d, viewHeight: %d", new Object[]{Integer.valueOf(this.iGn), Integer.valueOf(this.iGo)});
        if (!this.lkO) {
            this.lkO = true;
            this.tzG = false;
            x.d("MicroMsg.WxImageView", "init screenWidth:" + this.iGn + " screenHeight :" + this.iGo);
            float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
            if (f > 1.0f) {
                this.aaO = f;
            }
            crm();
        }
        if (this.tzw) {
            crm();
        }
    }

    public int getContentTop() {
        if (!this.lkO) {
            return 0;
        }
        int imageHeight = (int) ((((float) this.iGo) - (this.mKP * ((float) getImageHeight()))) / 2.0f);
        if (imageHeight < 0) {
            imageHeight = 0;
        }
        x.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", new Object[]{Float.valueOf(this.mKP), Integer.valueOf(getImageHeight()), Integer.valueOf(this.iGo), Integer.valueOf(imageHeight)});
        return imageHeight;
    }

    public int getContentLeft() {
        if (!this.lkO) {
            return 0;
        }
        int i = (int) ((((float) this.iGn) - (this.mKP * ((float) this.imageWidth))) / 2.0f);
        if (i < 0) {
            i = 0;
        }
        x.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", new Object[]{Float.valueOf(this.mKP), Integer.valueOf(this.imageWidth), Integer.valueOf(this.iGn), Integer.valueOf(i)});
        return i;
    }

    public final void crm() {
        x.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
        this.aaA.reset();
        crZ();
        if (this.djD != null) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.djD;
            subsamplingScaleImageView.a(subsamplingScaleImageView.aaK, new PointF(0.0f, 0.0f));
        }
        h(this.mKP, 0.0f, 0.0f);
    }

    public final void T(float f, float f2) {
        crZ();
        i(this.mKP, f, f2);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.lkO = false;
        }
    }

    public void setOrientation(int i) {
        this.orientation = i;
        crZ();
    }

    private void crZ() {
        boolean z;
        boolean z2 = true;
        int imageWidth = getImageWidth();
        int imageHeight = getImageHeight();
        this.tzD = ((float) this.iGn) / ((float) imageWidth);
        this.tzE = ((float) this.iGo) / ((float) imageHeight);
        this.tzB = ((float) imageWidth) > ((float) imageHeight) * 2.2f;
        if (((float) imageHeight) > ((float) imageWidth) * 2.2f) {
            z = true;
        } else {
            z = false;
        }
        this.tzC = z;
        if (!this.tzB || imageWidth <= this.iGn) {
            z = false;
        } else {
            z = true;
        }
        this.tzB = z;
        if (!this.tzC || imageHeight <= this.iGo) {
            z2 = false;
        }
        this.tzC = z2;
        float f = ((float) imageHeight) / ((float) imageWidth);
        float f2 = 1.8f;
        if (!(this.iGn == 0 || this.iGo == 0)) {
            f2 = ((float) this.iGo) / ((float) this.iGn);
        }
        if (f <= f2 || ((double) f) > 2.2d) {
            this.mKP = this.tzD;
        } else {
            this.mKP = this.tzE;
        }
        setScaleRate(this.mKP);
    }

    public float getScaleRate() {
        return this.mKP;
    }

    public int getImageWidth() {
        if (this.orientation == 90 || this.orientation == 270) {
            return this.imageHeight;
        }
        return this.imageWidth;
    }

    public void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public int getImageHeight() {
        if (this.orientation == 90 || this.orientation == 270) {
            return this.imageWidth;
        }
        return this.imageHeight;
    }

    public void setImageHeight(int i) {
        this.imageHeight = i;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        f.c(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !f.d(keyEvent) || f.e(keyEvent) || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        h(1.0f, ((float) this.iGn) / 2.0f, ((float) this.iGo) / 2.0f);
        return true;
    }

    public float getScale() {
        return super.getScale();
    }

    protected Matrix getImageViewMatrix() {
        this.tzp.set(this.tzo);
        this.tzp.postConcat(this.aaA);
        return this.tzp;
    }

    public final void crn() {
        if (this.tzA && 0.0f == this.tzt) {
            this.tzt = getDoubleTabScale();
        }
    }

    public final void h(float f, float f2, float f3) {
        int i;
        int i2 = 1;
        float scale = getScale();
        if (this.tzA) {
            this.tzu = 0.0f == this.tzt ? this.tzz * this.aaO : this.tzt;
        }
        if (f > this.tzu * 2.0f) {
            f = (this.tzu * 2.0f) + ((f - this.tzu) * 0.1f);
        } else if (f < this.tzv) {
            f = this.tzv;
        }
        float f4 = f / scale;
        x.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", new Object[]{Float.valueOf(this.tzt), Float.valueOf(this.tzu), Float.valueOf(f), Float.valueOf(scale), Float.valueOf(f4)});
        if (!this.tzG) {
            this.aaA.postScale(f4, f4, f2, f3);
        }
        if (this.nWI && this.tzB) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.tzC) {
            i2 = 0;
        }
        if (!(this.tzH == null && this.tzG)) {
            float f5;
            float f6;
            Matrix imageViewMatrix = getImageViewMatrix();
            RectF rectF = this.tzG ? new RectF(0.0f, 0.0f, (float) this.tzH.getIntrinsicWidth(), (float) this.tzH.getIntrinsicHeight()) : new RectF(0.0f, 0.0f, (float) this.imageWidth, (float) this.imageHeight);
            imageViewMatrix.mapRect(rectF);
            scale = rectF.height();
            float width = rectF.width();
            if (i2 != 0) {
                if (scale < ((float) this.iGo)) {
                    f5 = ((((float) this.iGo) - scale) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    f5 = -rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.iGo)) {
                        f5 = ((float) this.iGo) - rectF.bottom;
                    }
                    f5 = 0.0f;
                }
            } else if (rectF.top > 0.0f) {
                f5 = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.iGo)) {
                    f5 = ((float) this.iGo) - rectF.bottom;
                }
                f5 = 0.0f;
            }
            if (i != 0) {
                if (width < ((float) this.iGn)) {
                    f6 = ((((float) this.iGn) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f6 = -rectF.left;
                } else {
                    if (rectF.right < ((float) this.iGn)) {
                        f6 = ((float) this.iGn) - rectF.right;
                    }
                    f6 = 0.0f;
                }
            } else if (rectF.left > 0.0f) {
                f6 = -rectF.left;
            } else {
                if (rectF.right < ((float) this.iGn)) {
                    f6 = ((float) this.iGn) - rectF.right;
                }
                f6 = 0.0f;
            }
            V(f6, f5);
            getImageViewMatrix().mapRect(rectF);
        }
        if (this.nXf == null) {
            return;
        }
        if (f4 > 1.0f) {
            this.nXf.bDw();
        } else if (f4 < 1.0f) {
            this.nXf.bDv();
        }
    }

    public float getDoubleTabScale() {
        float scaleRate = getScaleRate();
        if (getScaleWidth() * 0.7f > scaleRate) {
            scaleRate = getScaleWidth();
        } else if (getScaleHeight() * 0.7f > scaleRate) {
            scaleRate = getScaleHeight();
        } else {
            scaleRate = getScaleRate() * this.tzx;
        }
        if (((double) scaleRate) < 1.0d) {
            scaleRate = 1.0f;
        }
        if (scaleRate > getMaxZoom()) {
            return getMaxZoom();
        }
        return scaleRate;
    }

    public final void U(float f, float f2) {
        this.tzt = getDoubleTabScale();
        i(this.tzt, f, f2);
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.nWI = z;
    }

    private void i(float f, float f2, float f3) {
        float scale = (f - getScale()) / 128.0f;
        float scale2 = getScale();
        this.mHandler.post(new 1(this, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    public final void V(float f, float f2) {
        x.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        this.aaA.postTranslate(f, f2);
    }

    public final void translate(float f, float f2) {
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        setTranslationX(translationX + f);
        setTranslationY(translationY + f2);
        x.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", new Object[]{Float.valueOf(translationX), Float.valueOf(translationY), Float.valueOf(translationX + f), Float.valueOf(translationY + f2)});
    }

    public Matrix getImageMatrix() {
        this.tzp.set(this.tzo);
        this.tzp.postConcat(this.aaA);
        return this.tzp;
    }
}
