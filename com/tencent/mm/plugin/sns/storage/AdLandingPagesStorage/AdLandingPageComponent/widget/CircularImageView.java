package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i$l;

public class CircularImageView extends ImageView {
    private static final String TAG = CircularImageView.class.getSimpleName();
    private int borderWidth;
    private boolean eQK;
    private Paint fBa;
    private boolean nHR;
    private boolean nHS;
    private int nHT;
    private int nHU;
    private boolean nHV;
    private float nHW;
    private float nHX;
    private float nHY;
    private BitmapShader nHZ;
    private Bitmap nIa;
    private Paint nIb;
    private Paint nIc;
    private ColorFilter nId;
    private int shadowColor;

    public CircularImageView(Context context) {
        this(context, null, i$l.CircularImageViewStyle_circularImageViewDefault);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i$l.CircularImageViewStyle_circularImageViewDefault);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBa = new Paint();
        this.fBa.setAntiAlias(true);
        this.nIb = new Paint();
        this.nIb.setAntiAlias(true);
        this.nIb.setStyle(Style.STROKE);
        this.nIc = new Paint();
        this.nIc.setAntiAlias(true);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i$l.CircularImageView, i, 0);
        this.nHR = obtainStyledAttributes.getBoolean(i$l.CircularImageView_civ_border, false);
        this.nHS = obtainStyledAttributes.getBoolean(i$l.CircularImageView_civ_selector, false);
        this.nHV = obtainStyledAttributes.getBoolean(i$l.CircularImageView_civ_shadow, false);
        if (this.nHR) {
            setBorderWidth(obtainStyledAttributes.getDimensionPixelOffset(i$l.CircularImageView_civ_borderWidth, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f)));
            setBorderColor(obtainStyledAttributes.getColor(i$l.CircularImageView_civ_borderColor, -1));
        }
        if (this.nHS) {
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
            setSelectorColor(obtainStyledAttributes.getColor(i$l.CircularImageView_civ_selectorColor, 0));
            setSelectorStrokeWidth(obtainStyledAttributes.getDimensionPixelOffset(i$l.CircularImageView_civ_selectorStrokeWidth, i2));
            setSelectorStrokeColor(obtainStyledAttributes.getColor(i$l.CircularImageView_civ_selectorStrokeColor, -16776961));
        }
        if (this.nHV) {
            this.nHW = obtainStyledAttributes.getFloat(i$l.CircularImageView_civ_shadowRadius, 4.0f);
            this.nHX = obtainStyledAttributes.getFloat(i$l.CircularImageView_civ_shadowDx, 0.0f);
            this.nHY = obtainStyledAttributes.getFloat(i$l.CircularImageView_civ_shadowDy, 2.0f);
            this.shadowColor = obtainStyledAttributes.getColor(i$l.CircularImageView_civ_shadowColor, -16777216);
            setShadowEnabled(true);
        }
        obtainStyledAttributes.recycle();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        if (this.nIb != null) {
            this.nIb.setStrokeWidth((float) i);
        }
        requestLayout();
        invalidate();
    }

    public void setBorderColor(int i) {
        if (this.nIb != null) {
            this.nIb.setColor(i);
        }
        invalidate();
    }

    public void setSelectorColor(int i) {
        this.nId = new PorterDuffColorFilter(i, Mode.SRC_ATOP);
        invalidate();
    }

    public void setSelectorStrokeWidth(int i) {
        this.nHU = i;
        requestLayout();
        invalidate();
    }

    public void setSelectorStrokeColor(int i) {
        if (this.nIc != null) {
            this.nIc.setColor(i);
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.nHV = z;
        float f = this.nHV ? this.nHW : 0.0f;
        this.nIb.setShadowLayer(f, this.nHX, this.nHY, this.shadowColor);
        this.nIc.setShadowLayer(f, this.nHX, this.nHY, this.shadowColor);
    }

    public void onDraw(Canvas canvas) {
        int i = 0;
        if (this.nIa != null && this.nIa.getHeight() != 0 && this.nIa.getWidth() != 0) {
            int i2 = this.nHT;
            this.nHT = getWidth() < getHeight() ? getWidth() : getHeight();
            if (i2 != this.nHT) {
                bAy();
            }
            this.fBa.setShader(this.nHZ);
            int i3 = this.nHT / 2;
            if (this.nHS && this.eQK) {
                i = this.nHU;
                i3 = (this.nHT - (i * 2)) / 2;
                this.fBa.setColorFilter(this.nId);
                canvas.drawCircle((float) (i3 + i), (float) (i3 + i), ((float) (((this.nHT - (i * 2)) / 2) + i)) - 4.0f, this.nIc);
            } else if (this.nHR) {
                int i4 = this.borderWidth;
                int i5 = (this.nHT - (i4 * 2)) / 2;
                this.fBa.setColorFilter(null);
                canvas.drawArc(new RectF((float) ((i4 / 2) + 0), (float) ((i4 / 2) + 0), (float) (this.nHT - (i4 / 2)), (float) (this.nHT - (i4 / 2))), 360.0f, 360.0f, false, this.nIb);
                i3 = i5;
                i = i4;
            } else {
                this.fBa.setColorFilter(null);
            }
            canvas.drawCircle((float) (i3 + i), (float) (i3 + i), (float) ((this.nHT - (i * 2)) / 2), this.fBa);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.eQK = true;
                    break;
                case 1:
                case 3:
                case 4:
                case 8:
                    this.eQK = false;
                    break;
            }
            invalidate();
            return super.dispatchTouchEvent(motionEvent);
        }
        this.eQK = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.nIa = q(getDrawable());
        if (this.nHT > 0) {
            bAy();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.nIa = q(getDrawable());
        if (this.nHT > 0) {
            bAy();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.nIa = q(getDrawable());
        if (this.nHT > 0) {
            bAy();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.nIa = bitmap;
        if (this.nHT > 0) {
            bAy();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (!(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            size = this.nHT;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        if (!(mode2 == 1073741824 || mode2 == Integer.MIN_VALUE)) {
            mode = this.nHT;
        }
        setMeasuredDimension(size, mode + 2);
    }

    private static Bitmap q(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public void setIconModeEnabled(boolean z) {
    }

    private void bAy() {
        if (this.nIa != null) {
            this.nHZ = new BitmapShader(this.nIa, TileMode.CLAMP, TileMode.CLAMP);
            if (this.nHT != this.nIa.getWidth() || this.nHT != this.nIa.getHeight()) {
                Matrix matrix = new Matrix();
                float width = ((float) this.nHT) / ((float) this.nIa.getWidth());
                matrix.setScale(width, width);
                this.nHZ.setLocalMatrix(matrix);
            }
        }
    }

    public boolean isSelected() {
        return this.eQK;
    }
}
