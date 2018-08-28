package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.tencent.mm.sdk.platformtools.x;

@RemoteView
public class QImageView extends View {
    private static final a[] uHJ = new a[]{a.MATRIX, a.FIT_XY, a.FIT_START, a.FIT_CENTER, a.FIT_END, a.CENTER, a.CENTER_CROP, a.CENTER_INSIDE};
    private static final ScaleToFit[] uHK = new ScaleToFit[]{ScaleToFit.FILL, ScaleToFit.START, ScaleToFit.CENTER, ScaleToFit.END};
    private int AA;
    private boolean OQ;
    private Uri aMJ;
    private int gg;
    private ColorFilter jN;
    private Context mContext;
    private Drawable mDrawable;
    private Matrix mMatrix;
    private int qMj;
    private int[] uHA;
    private boolean uHB;
    private int uHC;
    private int uHD;
    private int uHE;
    private Matrix uHF;
    private final RectF uHG;
    private final RectF uHH;
    private boolean uHI;
    private int uHu;
    private a uHv;
    private boolean uHw;
    private boolean uHx;
    private int uHy;
    private boolean uHz;

    public enum a {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        final int uHT;

        private a(int i) {
            this.uHT = i;
        }
    }

    public QImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        cAA();
    }

    public QImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uHu = 0;
        this.uHw = false;
        this.uHx = false;
        this.gg = Integer.MAX_VALUE;
        this.qMj = Integer.MAX_VALUE;
        this.AA = 255;
        this.uHy = 256;
        this.uHz = false;
        this.mDrawable = null;
        this.uHA = null;
        this.uHB = false;
        this.uHC = 0;
        this.uHF = null;
        this.uHG = new RectF();
        this.uHH = new RectF();
        this.OQ = false;
        this.mContext = context;
        cAA();
        this.OQ = false;
        setAdjustViewBounds(false);
        setMaxWidth(Integer.MAX_VALUE);
        setMaxHeight(Integer.MAX_VALUE);
        this.uHI = false;
    }

    private void cAA() {
        this.mMatrix = new Matrix();
        this.uHv = a.FIT_CENTER;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.mDrawable == drawable || super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected boolean onSetAlpha(int i) {
        if (getBackground() != null) {
            return false;
        }
        int i2 = (i >> 7) + i;
        if (this.uHy == i2) {
            return true;
        }
        this.uHy = i2;
        this.uHz = true;
        cAE();
        return true;
    }

    public void setAdjustViewBounds(boolean z) {
        this.uHx = z;
        if (z) {
            setScaleType(a.FIT_CENTER);
        }
    }

    public void setMaxWidth(int i) {
        this.gg = i;
    }

    public void setMaxHeight(int i) {
        this.qMj = i;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public void setImageResource(int i) {
        if (this.aMJ != null || this.uHu != i) {
            u(null);
            this.uHu = i;
            this.aMJ = null;
            cAB();
            invalidate();
        }
    }

    @TargetApi(11)
    public void setLayerType(int i, Paint paint) {
        if (!(getDrawable() instanceof PictureDrawable) || i == 1) {
            super.setLayerType(i, paint);
        }
    }

    public void setImageURI(Uri uri) {
        if (this.uHu == 0) {
            if (this.aMJ == uri) {
                return;
            }
            if (!(uri == null || this.aMJ == null || !uri.equals(this.aMJ))) {
                return;
            }
        }
        u(null);
        this.uHu = 0;
        this.aMJ = uri;
        cAB();
        invalidate();
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mDrawable != drawable) {
            this.uHu = 0;
            this.aMJ = null;
            u(drawable);
            invalidate();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap));
    }

    private void cAB() {
        Drawable drawable = null;
        if (this.mDrawable == null) {
            Resources resources = getResources();
            if (resources != null) {
                if (this.uHu != 0) {
                    try {
                        drawable = resources.getDrawable(this.uHu);
                    } catch (Exception e) {
                        x.w("ImageView", "Unable to find resource: " + this.uHu, new Object[]{e});
                        this.aMJ = drawable;
                    }
                } else if (this.aMJ == null) {
                    return;
                }
                u(drawable);
            }
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        cAC();
    }

    public void setImageLevel(int i) {
        this.uHC = i;
        if (this.mDrawable != null) {
            this.mDrawable.setLevel(i);
            cAC();
        }
    }

    public void setScaleType(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        } else if (this.uHv != aVar) {
            this.uHv = aVar;
            setWillNotCacheDrawing(this.uHv == a.CENTER);
            requestLayout();
            invalidate();
        }
    }

    public a getScaleType() {
        return this.uHv;
    }

    public Matrix getImageMatrix() {
        return this.mMatrix;
    }

    public void setImageMatrix(Matrix matrix) {
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.mMatrix.isIdentity()) || (matrix != null && !this.mMatrix.equals(matrix))) {
            this.mMatrix.set(matrix);
            cAD();
            invalidate();
        }
    }

    public int[] onCreateDrawableState(int i) {
        if (this.uHA == null) {
            return super.onCreateDrawableState(i);
        }
        if (this.uHB) {
            return mergeDrawableStates(super.onCreateDrawableState(this.uHA.length + i), this.uHA);
        }
        return this.uHA;
    }

    private void u(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(this.uHC);
            this.uHD = drawable.getIntrinsicWidth();
            this.uHE = drawable.getIntrinsicHeight();
            cAE();
            cAD();
        }
    }

    private void cAC() {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = this.uHD;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = this.uHE;
            }
            if (intrinsicWidth != this.uHD || intrinsicHeight != this.uHE) {
                this.uHD = intrinsicWidth;
                this.uHE = intrinsicHeight;
                requestLayout();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode;
        cAB();
        float f = 0.0f;
        Object obj = null;
        Object obj2 = null;
        if (this.mDrawable == null) {
            this.uHD = -1;
            this.uHE = -1;
            i3 = 0;
            i4 = 0;
        } else {
            i5 = this.uHD;
            i3 = this.uHE;
            if (i5 <= 0) {
                i5 = 1;
            }
            if (i3 <= 0) {
                i3 = 1;
            }
            if (this.uHx) {
                mode = MeasureSpec.getMode(i);
                int mode2 = MeasureSpec.getMode(i2);
                obj = mode != 1073741824 ? 1 : null;
                obj2 = mode2 != 1073741824 ? 1 : null;
                f = ((float) i5) / ((float) i3);
                i4 = i5;
            } else {
                i4 = i5;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (obj == null && obj2 == null) {
            i3 += paddingTop + paddingBottom;
            mode = Math.max((paddingLeft + paddingRight) + i4, getSuggestedMinimumWidth());
            i3 = Math.max(i3, getSuggestedMinimumHeight());
            mode = resolveSize(mode, i);
            i3 = resolveSize(i3, i2);
        } else {
            i4 = am((i4 + paddingLeft) + paddingRight, this.gg, i);
            i5 = am((i3 + paddingTop) + paddingBottom, this.qMj, i2);
            if (f == 0.0f || ((double) Math.abs((((float) ((i4 - paddingLeft) - paddingRight)) / ((float) ((i5 - paddingTop) - paddingBottom))) - f)) <= 1.0E-7d) {
                i3 = i5;
                mode = i4;
            } else {
                int i6;
                Object obj3 = null;
                if (obj != null) {
                    i6 = (((int) (((float) ((i5 - paddingTop) - paddingBottom)) * f)) + paddingLeft) + paddingRight;
                    if (i6 <= i4) {
                        obj3 = 1;
                        if (obj3 == null && obj2 != null) {
                            i3 = (((int) (((float) ((i6 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                            if (i3 <= i5) {
                                mode = i6;
                            }
                        }
                        i3 = i5;
                        mode = i6;
                    }
                }
                i6 = i4;
                i3 = (((int) (((float) ((i6 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                if (i3 <= i5) {
                    mode = i6;
                }
                i3 = i5;
                mode = i6;
            }
        }
        setMeasuredDimension(mode, i3);
    }

    private static int am(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i, size), i2);
            case 0:
                return Math.min(i, i2);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.uHw = true;
        cAD();
    }

    private void cAD() {
        if (this.mDrawable != null && this.uHw) {
            int i = this.uHD;
            int i2 = this.uHE;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int i3 = ((i < 0 || width == i) && (i2 < 0 || height == i2)) ? 1 : 0;
            if (i <= 0 || i2 <= 0 || a.FIT_XY == this.uHv) {
                this.mDrawable.setBounds(0, 0, width, height);
                this.uHF = null;
                return;
            }
            this.mDrawable.setBounds(0, 0, i, i2);
            float f;
            float f2;
            if (a.MATRIX == this.uHv) {
                if (this.mMatrix.isIdentity()) {
                    this.uHF = null;
                } else {
                    this.uHF = this.mMatrix;
                }
            } else if (i3 != 0) {
                this.uHF = null;
            } else if (a.CENTER == this.uHv) {
                this.uHF = this.mMatrix;
                this.uHF.setTranslate((float) ((int) ((((float) (width - i)) * 0.5f) + 0.5f)), (float) ((int) ((((float) (height - i2)) * 0.5f) + 0.5f)));
            } else if (a.CENTER_CROP == this.uHv) {
                float f3;
                this.uHF = this.mMatrix;
                if (i * height > width * i2) {
                    f3 = ((float) height) / ((float) i2);
                    f = (((float) width) - (((float) i) * f3)) * 0.5f;
                    f2 = 0.0f;
                } else {
                    f3 = ((float) width) / ((float) i);
                    f2 = (((float) height) - (((float) i2) * f3)) * 0.5f;
                    f = 0.0f;
                }
                this.uHF.setScale(f3, f3);
                this.uHF.postTranslate((float) ((int) (f + 0.5f)), (float) ((int) (f2 + 0.5f)));
            } else if (a.CENTER_INSIDE == this.uHv) {
                this.uHF = this.mMatrix;
                if (i > width || i2 > height) {
                    f2 = Math.min(((float) width) / ((float) i), ((float) height) / ((float) i2));
                } else {
                    f2 = 1.0f;
                }
                float f4 = (float) ((int) (((((float) width) - (((float) i) * f2)) * 0.5f) + 0.5f));
                f = (float) ((int) (((((float) height) - (((float) i2) * f2)) * 0.5f) + 0.5f));
                this.uHF.setScale(f2, f2);
                this.uHF.postTranslate(f4, f);
            } else {
                this.uHG.set(0.0f, 0.0f, (float) i, (float) i2);
                this.uHH.set(0.0f, 0.0f, (float) width, (float) height);
                this.uHF = this.mMatrix;
                this.uHF.setRectToRect(this.uHG, this.uHH, uHK[this.uHv.uHT - 1]);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.onDraw(canvas);
        if (this.mDrawable != null && this.uHD != 0 && this.uHE != 0) {
            if (this.uHF == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                this.mDrawable.draw(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (this.uHI) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            if (this.uHF != null) {
                canvas.concat(this.uHF);
            }
            this.mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    public int getBaseline() {
        return this.OQ ? getMeasuredHeight() : -1;
    }

    public final void setColorFilter(int i) {
        setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_ATOP));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.jN != colorFilter) {
            this.jN = colorFilter;
            this.uHz = true;
            cAE();
            invalidate();
        }
    }

    public void setAlpha(int i) {
        int i2 = i & 255;
        if (this.AA != i2) {
            this.AA = i2;
            this.uHz = true;
            cAE();
            invalidate();
        }
    }

    private void cAE() {
        if (this.mDrawable != null && this.uHz) {
            this.mDrawable = this.mDrawable.mutate();
            this.mDrawable.setColorFilter(this.jN);
            this.mDrawable.setAlpha((this.AA * this.uHy) >> 8);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
