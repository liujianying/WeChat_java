package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.b.c;

public class MultiTouchImageView extends ImageView implements g {
    protected Matrix aaA;
    private float aaO;
    public int iGn;
    public int iGo;
    private int imageHeight;
    private int imageWidth;
    private boolean lkO;
    protected ag mHandler;
    private float mKP;
    protected Bitmap nIa;
    private boolean nWI;
    private a nXf;
    private boolean tzA;
    public boolean tzB;
    public boolean tzC;
    private float tzD;
    private float tzE;
    float tzF;
    public boolean tzG;
    public Drawable tzH;
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
            x.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
        } else {
            this.tzz = f;
        }
    }

    public void setMinZoomLimit(float f) {
        if (Float.compare(f, 1.0f) > 0) {
            x.w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
        } else if (Float.compare(f, 0.0f) < 0) {
            x.w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
        } else {
            this.tzy = f;
        }
    }

    public void setDoubleTabScaleLimit(float f) {
        if (Float.compare(f, 0.0f) < 0) {
            x.w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
        } else {
            this.tzx = f;
        }
    }

    public void setMaxZoomDoubleTab(boolean z) {
        this.tzA = z;
    }

    public MultiTouchImageView(Context context, int i, int i2, a aVar) {
        super(context);
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
        this.mHandler = new ag();
        this.aaO = 1.0f;
        this.tzF = 0.0f;
        this.tzG = false;
        this.imageHeight = i2;
        this.imageWidth = i;
        this.nXf = aVar;
        init();
    }

    public MultiTouchImageView(Context context, int i, int i2) {
        this(context, i, i2, null);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private MultiTouchImageView(Context context, AttributeSet attributeSet, byte b) {
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
        this.mHandler = new ag();
        this.aaO = 1.0f;
        this.tzF = 0.0f;
        this.tzG = false;
        this.imageHeight = 0;
        this.imageWidth = 0;
        init();
    }

    public final void eT(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
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
        if (!this.lkO) {
            this.lkO = true;
            init();
        }
        if (this.tzw) {
            crm();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.tzG = false;
        this.nIa = bitmap;
        this.lkO = false;
        super.setImageBitmap(bitmap);
    }

    protected void onDraw(Canvas canvas) {
        if (this.tzG || this.nIa == null || !this.nIa.isRecycled()) {
            super.onDraw(canvas);
        } else {
            x.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
        }
    }

    public final void crm() {
        this.aaA.reset();
        crZ();
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

    private void crZ() {
        boolean z;
        boolean z2 = true;
        this.tzD = ((float) this.iGn) / ((float) this.imageWidth);
        this.tzE = ((float) this.iGo) / ((float) this.imageHeight);
        this.tzB = ((float) this.imageWidth) > ((float) this.imageHeight) * 2.2f;
        if (((float) this.imageHeight) > ((float) this.imageWidth) * 2.2f) {
            z = true;
        } else {
            z = false;
        }
        this.tzC = z;
        if (!this.tzB || this.imageWidth <= this.iGn) {
            z = false;
        } else {
            z = true;
        }
        this.tzB = z;
        if (!this.tzC || this.imageHeight <= this.iGo) {
            z2 = false;
        }
        this.tzC = z2;
        float f = ((float) this.imageHeight) / ((float) this.imageWidth);
        float f2 = 1.8f;
        if (!(this.iGn == 0 || this.iGo == 0)) {
            f2 = ((float) this.iGo) / ((float) this.iGn);
        }
        if (f <= f2 || ((double) f) > 2.2d) {
            this.mKP = this.tzD;
        } else {
            this.mKP = this.tzE;
        }
    }

    public float getScaleRate() {
        return this.mKP;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public int getImageHeight() {
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

    private void X(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.nIa == null && !this.tzG) {
            return;
        }
        if (this.tzH != null || !this.tzG) {
            RectF rectF;
            float f2;
            Matrix imageViewMatrix = getImageViewMatrix();
            if (this.tzG) {
                rectF = new RectF(0.0f, 0.0f, (float) this.tzH.getIntrinsicWidth(), (float) this.tzH.getIntrinsicHeight());
            } else {
                rectF = new RectF(0.0f, 0.0f, (float) this.nIa.getWidth(), (float) this.nIa.getHeight());
            }
            imageViewMatrix.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            if (!z2) {
                f2 = ((float) this.iGo) - rectF.bottom;
                height = (rectF.top + f2) / 2.0f;
                if (height < 0.0f) {
                    height = 0.0f;
                }
                if (rectF.top > 0.0f) {
                    f2 = height - rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.iGo)) {
                        f2 -= height;
                    }
                    f2 = 0.0f;
                }
            } else if (height < ((float) this.iGo)) {
                f2 = ((((float) this.iGo) - height) / 2.0f) - rectF.top;
            } else if (rectF.top > 0.0f) {
                f2 = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.iGo)) {
                    f2 = ((float) this.iGo) - rectF.bottom;
                }
                f2 = 0.0f;
            }
            if (!z) {
                width = ((float) this.iGn) - rectF.right;
                height = (rectF.left + width) / 2.0f;
                if (height < 0.0f) {
                    height = 0.0f;
                }
                if (rectF.left > 0.0f) {
                    f = height - rectF.left;
                } else if (rectF.right < ((float) this.iGn)) {
                    f = width - height;
                }
            } else if (width < ((float) this.iGn)) {
                f = ((((float) this.iGn) - width) / 2.0f) - rectF.left;
            } else if (rectF.left > 0.0f) {
                f = -rectF.left;
            } else if (rectF.right < ((float) this.iGn)) {
                f = ((float) this.iGn) - rectF.right;
            }
            V(f, f2);
            imageViewMatrix = getImageViewMatrix();
            setImageMatrix(imageViewMatrix);
            imageViewMatrix.mapRect(rectF);
            rectF.height();
            rectF.width();
        }
    }

    private void init() {
        x.d("dktest", "init screenWidth:" + this.iGn + " screenHeight :" + this.iGo);
        setScaleType(ScaleType.MATRIX);
        float f = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f > 1.0f) {
            this.aaO = f;
        }
        crm();
    }

    public float getScale() {
        this.aaA.getValues(this.tzq);
        crZ();
        this.tzu = this.tzz * this.aaO;
        this.tzv = this.mKP * this.tzy;
        if (this.tzu < 1.0f) {
            this.tzu = 1.0f;
        }
        if (this.tzv > 1.0f) {
            this.tzv = 1.0f;
        }
        return this.tzq[0];
    }

    protected Matrix getImageViewMatrix() {
        this.tzp.set(this.tzo);
        this.tzp.postConcat(this.aaA);
        return this.tzp;
    }

    public final void csa() {
        boolean z;
        boolean z2 = true;
        if (this.nWI && this.tzB) {
            z = false;
        } else {
            z = true;
        }
        if (this.tzC) {
            z2 = false;
        }
        X(z, z2);
    }

    public final void crn() {
        if (this.tzA && 0.0f == this.tzt) {
            this.tzt = getDoubleTabScale();
        }
    }

    public final void h(float f, float f2, float f3) {
        boolean z;
        boolean z2 = true;
        float scale = getScale();
        if (this.tzA) {
            this.tzu = 0.0f == this.tzt ? this.tzz * this.aaO : this.tzt;
        }
        if (f > this.tzu * 2.0f) {
            f = (this.tzu * 2.0f) + ((f - this.tzu) * 0.1f);
        } else if (f < this.tzv) {
            f = this.tzv;
        }
        scale = f / scale;
        if (!this.tzG) {
            setImageMatrix(getImageViewMatrix());
            this.aaA.postScale(scale, scale, f2, f3);
        }
        if (this.nWI && this.tzB) {
            z = false;
        } else {
            z = true;
        }
        if (this.tzC) {
            z2 = false;
        }
        X(z, z2);
        if (this.nXf == null) {
            return;
        }
        if (scale > 1.0f) {
            this.nXf.bDw();
        } else if (scale < 1.0f) {
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

    public float getRealWidth() {
        return getScale() * ((float) getImageWidth());
    }

    public final void V(float f, float f2) {
        this.aaA.postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    public void setGifPath(String str) {
        this.tzG = true;
        try {
            this.tzH = c.gj(str, str);
            setImageDrawable(this.tzH);
            if (this.tzH != null) {
                eT(this.tzH.getIntrinsicWidth(), this.tzH.getIntrinsicHeight());
            }
        } catch (Exception e) {
            this.tzG = false;
        }
    }

    public void setGifDrawable(Drawable drawable) {
        this.tzG = true;
        this.tzH = drawable;
        setImageDrawable(this.tzH);
    }
}
