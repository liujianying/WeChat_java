package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.f;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable HS;
    private View JA;
    private View JB;
    Drawable JC;
    Drawable JD;
    boolean JE;
    boolean JF;
    private boolean Jy;
    private View Jz;
    private int mHeight;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable cVar;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            cVar = new c(this);
        } else {
            cVar = new b(this);
        }
        setBackgroundDrawable(cVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActionBar);
        this.HS = obtainStyledAttributes.getDrawable(k.ActionBar_background);
        this.JC = obtainStyledAttributes.getDrawable(k.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(k.ActionBar_height, -1);
        if (getId() == f.split_action_bar) {
            this.JE = true;
            this.JD = obtainStyledAttributes.getDrawable(k.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.JE ? this.JD == null : this.HS == null && this.JC == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.JA = findViewById(f.action_bar);
        this.JB = findViewById(f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.HS != null) {
            this.HS.setCallback(null);
            unscheduleDrawable(this.HS);
        }
        this.HS = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.JA != null) {
                this.HS.setBounds(this.JA.getLeft(), this.JA.getTop(), this.JA.getRight(), this.JA.getBottom());
            }
        }
        if (this.JE) {
            if (this.JD != null) {
                z = false;
            }
        } else if (!(this.HS == null && this.JC == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.JC != null) {
            this.JC.setCallback(null);
            unscheduleDrawable(this.JC);
        }
        this.JC = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.JF && this.JC != null) {
                this.JC.setBounds(this.Jz.getLeft(), this.Jz.getTop(), this.Jz.getRight(), this.Jz.getBottom());
            }
        }
        if (this.JE) {
            if (this.JD != null) {
                z = false;
            }
        } else if (!(this.HS == null && this.JC == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.JD != null) {
            this.JD.setCallback(null);
            unscheduleDrawable(this.JD);
        }
        this.JD = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.JE && this.JD != null) {
                this.JD.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.JE) {
            if (this.JD != null) {
                z = false;
            }
        } else if (!(this.HS == null && this.JC == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.HS != null) {
            this.HS.setVisible(z, false);
        }
        if (this.JC != null) {
            this.JC.setVisible(z, false);
        }
        if (this.JD != null) {
            this.JD.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.HS && !this.JE) || ((drawable == this.JC && this.JF) || ((drawable == this.JD && this.JE) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.HS != null && this.HS.isStateful()) {
            this.HS.setState(getDrawableState());
        }
        if (this.JC != null && this.JC.isStateful()) {
            this.JC.setState(getDrawableState());
        }
        if (this.JD != null && this.JD.isStateful()) {
            this.JD.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.HS != null) {
                this.HS.jumpToCurrentState();
            }
            if (this.JC != null) {
                this.JC.jumpToCurrentState();
            }
            if (this.JD != null) {
                this.JD.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.Jy = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.Jy || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ai aiVar) {
        if (this.Jz != null) {
            removeView(this.Jz);
        }
        this.Jz = aiVar;
        if (aiVar != null) {
            addView(aiVar);
            LayoutParams layoutParams = aiVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            aiVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.Jz;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private static boolean aK(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int aL(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.JA == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.mHeight >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.JA != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.Jz != null && this.Jz.getVisibility() != 8 && mode != 1073741824) {
                int aL;
                if (!aK(this.JA)) {
                    aL = aL(this.JA);
                } else if (aK(this.JB)) {
                    aL = 0;
                } else {
                    aL = aL(this.JB);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(aL + aL(this.Jz), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.Jz;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.JE) {
            int i6;
            if (this.HS != null) {
                if (this.JA.getVisibility() == 0) {
                    this.HS.setBounds(this.JA.getLeft(), this.JA.getTop(), this.JA.getRight(), this.JA.getBottom());
                } else if (this.JB == null || this.JB.getVisibility() != 0) {
                    this.HS.setBounds(0, 0, 0, 0);
                } else {
                    this.HS.setBounds(this.JB.getLeft(), this.JB.getTop(), this.JB.getRight(), this.JB.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.JF = z2;
            if (!z2 || this.JC == null) {
                i5 = i6;
            } else {
                this.JC.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.JD != null) {
            this.JD.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
