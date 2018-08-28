package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable ba;
    private final Rect bb;
    private final Rect bc;
    private int bd;
    protected boolean be;
    boolean bf;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bb = new Rect();
        this.bc = new Rect();
        this.bd = 119;
        this.be = true;
        this.bf = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ForegroundLinearLayout, i, 0);
        this.bd = obtainStyledAttributes.getInt(i.ForegroundLinearLayout_android_foregroundGravity, this.bd);
        Drawable drawable = obtainStyledAttributes.getDrawable(i.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.be = obtainStyledAttributes.getBoolean(i.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.bd;
    }

    public void setForegroundGravity(int i) {
        if (this.bd != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW) == 0) {
                i2 |= 48;
            }
            this.bd = i2;
            if (this.bd == 119 && this.ba != null) {
                this.ba.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.ba;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.ba != null) {
            this.ba.jumpToCurrentState();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.ba != null && this.ba.isStateful()) {
            this.ba.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.ba != drawable) {
            if (this.ba != null) {
                this.ba.setCallback(null);
                unscheduleDrawable(this.ba);
            }
            this.ba = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.bd == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.ba;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.bf |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bf = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.ba != null) {
            Drawable drawable = this.ba;
            if (this.bf) {
                this.bf = false;
                Rect rect = this.bb;
                Rect rect2 = this.bc;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.be) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.bd, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.ba != null) {
            this.ba.setHotspot(f, f2);
        }
    }
}
