package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.m;

public class MMPinProgressBtn extends CompoundButton {
    private Paint AB;
    private int pF;
    private int style;
    private int uGt;
    private Paint uGu;
    private RectF uGv = new RectF();
    private int uGw;
    private final float uGx = 4.0f;
    private Runnable uGy = new 1(this);

    public MMPinProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet, 0);
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet, i);
    }

    private void c(Context context, AttributeSet attributeSet, int i) {
        Throwable th;
        TypedArray typedArray;
        this.uGt = 100;
        this.pF = 0;
        Resources resources = getResources();
        int color = resources.getColor(d.pin_progress_default_circle_color);
        int color2 = resources.getColor(d.pin_progress_default_progress_color);
        if (attributeSet != null) {
            TypedArray typedArray2 = null;
            try {
                typedArray2 = context.obtainStyledAttributes(attributeSet, m.MMPinProgressBtn, i, 0);
                try {
                    this.uGt = typedArray2.getInteger(m.MMPinProgressBtn_max, this.uGt);
                    this.pF = typedArray2.getInteger(m.MMPinProgressBtn_progress, this.pF);
                    color = typedArray2.getColor(m.MMPinProgressBtn_circleColor, color);
                    color2 = typedArray2.getColor(m.MMPinProgressBtn_progressColor, color2);
                    this.style = typedArray2.getInteger(m.MMPinProgressBtn_style, 0);
                    this.uGw = typedArray2.getDimensionPixelSize(m.MMPinProgressBtn_innerSize, resources.getDimensionPixelSize(e.pin_progress_inner_size));
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    typedArray = typedArray2;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                typedArray = typedArray2;
            }
        }
        this.AB = new Paint();
        this.AB.setColor(color);
        this.AB.setStyle(Style.STROKE);
        this.AB.setStrokeWidth(4.0f);
        this.AB.setAntiAlias(true);
        this.uGu = new Paint();
        this.uGu.setColor(color2);
        this.uGu.setAntiAlias(true);
        setClickable(false);
    }

    public int getMax() {
        return this.uGt;
    }

    public void setMax(int i) {
        this.uGt = Math.max(0, i);
        invalidate();
    }

    public int getProgress() {
        return this.pF;
    }

    public void setProgress(int i) {
        this.pF = Math.max(0, i);
        this.pF = Math.min(i, this.uGt);
        invalidate();
    }

    public final void cAt() {
        removeCallbacks(this.uGy);
        post(this.uGy);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(this.uGw, i), resolveSize(this.uGw, i2));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.uGv.set(2.0f, 2.0f, ((float) this.uGw) - 2.0f, ((float) this.uGw) - 2.0f);
        this.uGv.offset((float) ((getWidth() - this.uGw) / 2), (float) ((getHeight() - this.uGw) / 2));
        canvas.drawArc(this.uGv, 0.0f, 360.0f, true, this.AB);
        switch (this.style) {
            case 0:
                this.uGv.set(8.0f, 8.0f, ((float) this.uGw) - 8.0f, ((float) this.uGw) - 8.0f);
                this.uGv.offset((float) ((getWidth() - this.uGw) / 2), (float) ((getHeight() - this.uGw) / 2));
                canvas.drawArc(this.uGv, -90.0f, 360.0f * ((((float) this.pF) * 1.0f) / ((float) this.uGt)), true, this.uGu);
                return;
            case 1:
                this.uGv.set(2.0f, 2.0f, ((float) this.uGw) - 2.0f, ((float) this.uGw) - 2.0f);
                this.uGv.offset((float) ((getWidth() - this.uGw) / 2), (float) ((getHeight() - this.uGw) / 2));
                canvas.drawArc(this.uGv, 270.0f, (((((float) this.pF) * 1.0f) / ((float) this.uGt)) * 360.0f) - 360.0f, true, this.uGu);
                return;
            default:
                return;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (!isSaveEnabled()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        SavedState.a(savedState, this.uGt);
        SavedState.b(savedState, this.pF);
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.uGt = SavedState.a(savedState);
            this.pF = SavedState.b(savedState);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
