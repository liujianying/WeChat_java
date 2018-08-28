package com.tencent.mm.ui.widget.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bw.a.k;

public class MMProgressWheel extends View {
    private static final String TAG = MMProgressWheel.class.getSimpleName();
    private final int barLength = 16;
    private float tua = 0.0f;
    private final int uLY = 270;
    private final long uLZ = 200;
    private int uMa = 28;
    private int uMb = 4;
    private int uMc = 4;
    private boolean uMd = false;
    private double uMe = 0.0d;
    private double uMf = 460.0d;
    private float uMg = 0.0f;
    private boolean uMh = true;
    private long uMi = 0;
    private int uMj = -1442840576;
    private int uMk = 16777215;
    private Paint uMl = new Paint();
    private Paint uMm = new Paint();
    private RectF uMn = new RectF();
    private float uMo = 230.0f;
    private long uMp = 0;
    private boolean uMq;
    private float uMr = 0.0f;
    private boolean uMs = false;
    private a uMt;
    private boolean uMu;

    public MMProgressWheel(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.MMProgressWheel);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.uMb = (int) TypedValue.applyDimension(1, (float) this.uMb, displayMetrics);
        this.uMc = (int) TypedValue.applyDimension(1, (float) this.uMc, displayMetrics);
        this.uMa = (int) TypedValue.applyDimension(1, (float) this.uMa, displayMetrics);
        this.uMa = (int) obtainStyledAttributes.getDimension(k.MMProgressWheel_matProg_circleRadius, (float) this.uMa);
        this.uMd = obtainStyledAttributes.getBoolean(k.MMProgressWheel_matProg_fillRadius, false);
        this.uMb = (int) obtainStyledAttributes.getDimension(k.MMProgressWheel_matProg_barWidth, (float) this.uMb);
        this.uMc = (int) obtainStyledAttributes.getDimension(k.MMProgressWheel_matProg_rimWidth, (float) this.uMc);
        this.uMo = obtainStyledAttributes.getFloat(k.MMProgressWheel_matProg_spinSpeed, this.uMo / 360.0f) * 360.0f;
        this.uMf = (double) obtainStyledAttributes.getInt(k.MMProgressWheel_matProg_barSpinCycleTime, (int) this.uMf);
        this.uMj = obtainStyledAttributes.getColor(k.MMProgressWheel_matProg_barColor, this.uMj);
        this.uMk = obtainStyledAttributes.getColor(k.MMProgressWheel_matProg_rimColor, this.uMk);
        this.uMq = obtainStyledAttributes.getBoolean(k.MMProgressWheel_matProg_linearProgress, false);
        if (obtainStyledAttributes.getBoolean(k.MMProgressWheel_matProg_progressIndeterminate, false)) {
            this.uMp = SystemClock.uptimeMillis();
            this.uMs = true;
            invalidate();
        }
        obtainStyledAttributes.recycle();
        if ((VERSION.SDK_INT >= 17 ? Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) : System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f)) == 0.0f) {
            z = false;
        }
        this.uMu = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = (this.uMa + getPaddingLeft()) + getPaddingRight();
        int paddingTop = (this.uMa + getPaddingTop()) + getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.uMd) {
            this.uMn = new RectF((float) (paddingLeft + this.uMb), (float) (paddingTop + this.uMb), (float) ((i - paddingRight) - this.uMb), (float) ((i2 - paddingBottom) - this.uMb));
        } else {
            int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.uMa * 2) - (this.uMb * 2));
            paddingLeft += (((i - paddingLeft) - paddingRight) - min) / 2;
            paddingTop += (((i2 - paddingTop) - paddingBottom) - min) / 2;
            this.uMn = new RectF((float) (this.uMb + paddingLeft), (float) (this.uMb + paddingTop), (float) ((paddingLeft + min) - this.uMb), (float) ((paddingTop + min) - this.uMb));
        }
        cAY();
        invalidate();
    }

    private void cAY() {
        this.uMl.setColor(this.uMj);
        this.uMl.setAntiAlias(true);
        this.uMl.setStyle(Style.STROKE);
        this.uMl.setStrokeWidth((float) this.uMb);
        this.uMm.setColor(this.uMk);
        this.uMm.setAntiAlias(true);
        this.uMm.setStyle(Style.STROKE);
        this.uMm.setStrokeWidth((float) this.uMc);
    }

    public void setCallback(a aVar) {
        this.uMt = aVar;
        if (!this.uMs) {
            cAZ();
        }
    }

    protected void onDraw(Canvas canvas) {
        boolean z = true;
        super.onDraw(canvas);
        canvas.drawArc(this.uMn, 360.0f, 360.0f, false, this.uMm);
        if (this.uMu) {
            float f;
            float cos;
            if (this.uMs) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.uMp;
                f = (((float) uptimeMillis) * this.uMo) / 1000.0f;
                if (this.uMi >= 200) {
                    this.uMe = ((double) uptimeMillis) + this.uMe;
                    if (this.uMe > this.uMf) {
                        this.uMe -= this.uMf;
                        this.uMi = 0;
                        this.uMh = !this.uMh;
                    }
                    cos = (((float) Math.cos(((this.uMe / this.uMf) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                    if (this.uMh) {
                        this.uMg = cos * 254.0f;
                    } else {
                        cos = (1.0f - cos) * 254.0f;
                        this.tua += this.uMg - cos;
                        this.uMg = cos;
                    }
                } else {
                    this.uMi = uptimeMillis + this.uMi;
                }
                this.tua += f;
                if (this.tua > 360.0f) {
                    this.tua -= 360.0f;
                }
                this.uMp = SystemClock.uptimeMillis();
                float f2 = this.tua - 90.0f;
                f = 16.0f + this.uMg;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f = 135.0f;
                }
                canvas.drawArc(this.uMn, f2, f, false, this.uMl);
            } else {
                float f3;
                cos = this.tua;
                if (this.tua != this.uMr) {
                    this.tua = Math.min(((((float) (SystemClock.uptimeMillis() - this.uMp)) / 1000.0f) * this.uMo) + this.tua, this.uMr);
                    this.uMp = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (cos != this.tua) {
                    cAZ();
                }
                cos = this.tua;
                if (this.uMq) {
                    f3 = 0.0f;
                } else {
                    cos = ((float) (1.0d - Math.pow((double) (1.0f - (this.tua / 360.0f)), 2.0d))) * 360.0f;
                    f3 = ((float) (1.0d - Math.pow((double) (1.0f - (this.tua / 360.0f)), 4.0d))) * 360.0f;
                }
                if (isInEditMode()) {
                    f = 360.0f;
                } else {
                    f = cos;
                }
                canvas.drawArc(this.uMn, f3 - 90.0f, f, false, this.uMl);
            }
            if (z) {
                invalidate();
            }
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.uMp = SystemClock.uptimeMillis();
        }
    }

    private void cAZ() {
        if (this.uMt != null) {
            Math.round((this.tua * 100.0f) / 360.0f);
        }
    }

    public void setInstantProgress(float f) {
        if (this.uMs) {
            this.tua = 0.0f;
            this.uMs = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (Math.abs(f - this.uMr) > 0.0f) {
            this.uMr = Math.min(f * 360.0f, 360.0f);
            this.tua = this.uMr;
            this.uMp = SystemClock.uptimeMillis();
            invalidate();
        }
    }

    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.tua = this.tua;
        wheelSavedState.uMr = this.uMr;
        wheelSavedState.uMs = this.uMs;
        wheelSavedState.uMo = this.uMo;
        wheelSavedState.uMb = this.uMb;
        wheelSavedState.uMj = this.uMj;
        wheelSavedState.uMc = this.uMc;
        wheelSavedState.uMk = this.uMk;
        wheelSavedState.uMa = this.uMa;
        wheelSavedState.uMq = this.uMq;
        wheelSavedState.uMd = this.uMd;
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof WheelSavedState) {
            WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
            super.onRestoreInstanceState(wheelSavedState.getSuperState());
            this.tua = wheelSavedState.tua;
            this.uMr = wheelSavedState.uMr;
            this.uMs = wheelSavedState.uMs;
            this.uMo = wheelSavedState.uMo;
            this.uMb = wheelSavedState.uMb;
            this.uMj = wheelSavedState.uMj;
            this.uMc = wheelSavedState.uMc;
            this.uMk = wheelSavedState.uMk;
            this.uMa = wheelSavedState.uMa;
            this.uMq = wheelSavedState.uMq;
            this.uMd = wheelSavedState.uMd;
            this.uMp = SystemClock.uptimeMillis();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public float getProgress() {
        return this.uMs ? -1.0f : this.tua / 360.0f;
    }

    public void setProgress(float f) {
        if (this.uMs) {
            this.tua = 0.0f;
            this.uMs = false;
            cAZ();
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (Math.abs(f - this.uMr) > 0.0f) {
            if (this.tua == this.uMr) {
                this.uMp = SystemClock.uptimeMillis();
            }
            this.uMr = Math.min(f * 360.0f, 360.0f);
            invalidate();
        }
    }

    public void setLinearProgress(boolean z) {
        this.uMq = z;
        if (!this.uMs) {
            invalidate();
        }
    }

    public int getCircleRadius() {
        return this.uMa;
    }

    public void setCircleRadius(int i) {
        this.uMa = i;
        if (!this.uMs) {
            invalidate();
        }
    }

    public int getBarWidth() {
        return this.uMb;
    }

    public void setBarWidth(int i) {
        this.uMb = i;
        if (!this.uMs) {
            invalidate();
        }
    }

    public int getBarColor() {
        return this.uMj;
    }

    public void setBarColor(int i) {
        this.uMj = i;
        cAY();
        if (!this.uMs) {
            invalidate();
        }
    }

    public int getRimColor() {
        return this.uMk;
    }

    public void setRimColor(int i) {
        this.uMk = i;
        cAY();
        if (!this.uMs) {
            invalidate();
        }
    }

    public float getSpinSpeed() {
        return this.uMo / 360.0f;
    }

    public void setSpinSpeed(float f) {
        this.uMo = 360.0f * f;
    }

    public int getRimWidth() {
        return this.uMc;
    }

    public void setRimWidth(int i) {
        this.uMc = i;
        if (!this.uMs) {
            invalidate();
        }
    }
}
