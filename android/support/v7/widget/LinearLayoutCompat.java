package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class LinearLayoutCompat extends ViewGroup {
    private boolean OQ;
    private int OR;
    private int OS;
    private int OT;
    private int OU;
    private float OV;
    private boolean OW;
    private int[] OX;
    private int[] OY;
    private Drawable OZ;
    private int Pa;
    private int Pb;
    private int Pc;
    private int Pd;
    private int rA;

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OQ = true;
        this.OR = -1;
        this.OS = 0;
        this.rA = 8388659;
        ap a = ap.a(context, attributeSet, k.LinearLayoutCompat, i);
        int i2 = a.getInt(k.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        i2 = a.getInt(k.LinearLayoutCompat_android_gravity, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        boolean z = a.getBoolean(k.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.OV = a.Ww.getFloat(k.LinearLayoutCompat_android_weightSum, -1.0f);
        this.OR = a.getInt(k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.OW = a.getBoolean(k.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.getDrawable(k.LinearLayoutCompat_divider));
        this.Pc = a.getInt(k.LinearLayoutCompat_showDividers, 0);
        this.Pd = a.getDimensionPixelSize(k.LinearLayoutCompat_dividerPadding, 0);
        a.Ww.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.Pc) {
            requestLayout();
        }
        this.Pc = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.Pc;
    }

    public Drawable getDividerDrawable() {
        return this.OZ;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.OZ) {
            this.OZ = drawable;
            if (drawable != null) {
                this.Pa = drawable.getIntrinsicWidth();
                this.Pb = drawable.getIntrinsicHeight();
            } else {
                this.Pa = 0;
                this.Pb = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.Pd = i;
    }

    public int getDividerPadding() {
        return this.Pd;
    }

    public int getDividerWidth() {
        return this.Pa;
    }

    protected void onDraw(Canvas canvas) {
        if (this.OZ != null) {
            int virtualChildCount;
            int i;
            View childAt;
            if (this.OT == 1) {
                virtualChildCount = getVirtualChildCount();
                i = 0;
                while (i < virtualChildCount) {
                    View childAt2 = getChildAt(i);
                    if (!(childAt2 == null || childAt2.getVisibility() == 8 || !bd(i))) {
                        b(canvas, (childAt2.getTop() - ((LayoutParams) childAt2.getLayoutParams()).topMargin) - this.Pb);
                    }
                    i++;
                }
                if (bd(virtualChildCount)) {
                    childAt = getChildAt(virtualChildCount - 1);
                    b(canvas, childAt == null ? (getHeight() - getPaddingBottom()) - this.Pb : ((LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom());
                    return;
                }
                return;
            }
            LayoutParams layoutParams;
            virtualChildCount = getVirtualChildCount();
            boolean bv = at.bv(this);
            i = 0;
            while (i < virtualChildCount) {
                View childAt3 = getChildAt(i);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !bd(i))) {
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    c(canvas, bv ? layoutParams.rightMargin + childAt3.getRight() : (childAt3.getLeft() - layoutParams.leftMargin) - this.Pa);
                }
                i++;
            }
            if (bd(virtualChildCount)) {
                int paddingLeft;
                childAt = getChildAt(virtualChildCount - 1);
                if (childAt == null) {
                    paddingLeft = bv ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.Pa;
                } else {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    paddingLeft = bv ? (childAt.getLeft() - layoutParams.leftMargin) - this.Pa : layoutParams.rightMargin + childAt.getRight();
                }
                c(canvas, paddingLeft);
            }
        }
    }

    private void b(Canvas canvas, int i) {
        this.OZ.setBounds(getPaddingLeft() + this.Pd, i, (getWidth() - getPaddingRight()) - this.Pd, this.Pb + i);
        this.OZ.draw(canvas);
    }

    private void c(Canvas canvas, int i) {
        this.OZ.setBounds(i, getPaddingTop() + this.Pd, this.Pa + i, (getHeight() - getPaddingBottom()) - this.Pd);
        this.OZ.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.OQ = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.OW = z;
    }

    public int getBaseline() {
        if (this.OR < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.OR) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.OR);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.OS;
            if (this.OT == 1) {
                i = this.rA & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.OU) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.OU;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.OR == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.OR;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.OR = i;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.OV;
    }

    public void setWeightSum(float f) {
        this.OV = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.OT == 1) {
            int i3;
            int i4;
            int i5;
            int i6;
            Object obj;
            Object obj2;
            int i7;
            int measuredWidth;
            int max;
            int i8;
            LayoutParams layoutParams;
            this.OU = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            Object obj3 = 1;
            float f = 0.0f;
            int virtualChildCount = getVirtualChildCount();
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            Object obj4 = null;
            Object obj5 = null;
            int i13 = this.OR;
            boolean z = this.OW;
            int i14 = Integer.MIN_VALUE;
            int i15 = 0;
            while (i15 < virtualChildCount) {
                View childAt = getChildAt(i15);
                if (childAt == null) {
                    this.OU += 0;
                    i3 = i15;
                } else {
                    Object obj6;
                    Object obj7;
                    if (childAt.getVisibility() != 8) {
                        if (bd(i15)) {
                            this.OU += this.Pb;
                        }
                        LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                        float f2 = f + layoutParams2.weight;
                        if (mode2 == 1073741824 && layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                            i4 = this.OU;
                            this.OU = Math.max(i4, (layoutParams2.topMargin + i4) + layoutParams2.bottomMargin);
                            obj5 = 1;
                            i3 = i14;
                        } else {
                            i4 = Integer.MIN_VALUE;
                            if (layoutParams2.height == 0 && layoutParams2.weight > 0.0f) {
                                i4 = 0;
                                layoutParams2.height = -2;
                            }
                            i5 = i4;
                            e(childAt, i, 0, i2, f2 == 0.0f ? this.OU : 0);
                            if (i5 != Integer.MIN_VALUE) {
                                layoutParams2.height = i5;
                            }
                            i4 = childAt.getMeasuredHeight();
                            i6 = this.OU;
                            this.OU = Math.max(i6, (((i6 + i4) + layoutParams2.topMargin) + layoutParams2.bottomMargin) + 0);
                            i3 = z ? Math.max(i4, i14) : i14;
                        }
                        if (i13 >= 0 && i13 == i15 + 1) {
                            this.OS = this.OU;
                        }
                        if (i15 >= i13 || layoutParams2.weight <= 0.0f) {
                            obj = null;
                            if (mode == 1073741824 || layoutParams2.width != -1) {
                                obj2 = obj4;
                            } else {
                                obj2 = 1;
                                obj = 1;
                            }
                            i7 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                            measuredWidth = childAt.getMeasuredWidth() + i7;
                            i9 = Math.max(i9, measuredWidth);
                            i14 = at.combineMeasuredStates(i10, z.M(childAt));
                            obj6 = (obj3 == null || layoutParams2.width != -1) ? null : 1;
                            if (layoutParams2.weight > 0.0f) {
                                max = Math.max(i12, obj != null ? i7 : measuredWidth);
                                i4 = i3;
                                obj7 = obj5;
                                f = f2;
                                i10 = i14;
                            } else {
                                if (obj == null) {
                                    i7 = measuredWidth;
                                }
                                int max2 = Math.max(i11, i7);
                                i4 = i3;
                                obj7 = obj5;
                                f = f2;
                                max = i12;
                                i11 = max2;
                                i10 = i14;
                            }
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                    i4 = i14;
                    obj7 = obj5;
                    obj2 = obj4;
                    obj6 = obj3;
                    max = i12;
                    i3 = i15 + 0;
                    i14 = i4;
                    obj5 = obj7;
                    obj4 = obj2;
                    obj3 = obj6;
                    i12 = max;
                }
                i15 = i3 + 1;
            }
            if (this.OU > 0 && bd(virtualChildCount)) {
                this.OU += this.Pb;
            }
            if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                this.OU = 0;
                i8 = 0;
                while (i8 < virtualChildCount) {
                    View childAt2 = getChildAt(i8);
                    if (childAt2 == null) {
                        this.OU += 0;
                        i4 = i8;
                    } else if (childAt2.getVisibility() == 8) {
                        i4 = i8 + 0;
                    } else {
                        layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        i6 = this.OU;
                        this.OU = Math.max(i6, (layoutParams.bottomMargin + ((i6 + i14) + layoutParams.topMargin)) + 0);
                        i4 = i8;
                    }
                    i8 = i4 + 1;
                }
            }
            this.OU += getPaddingTop() + getPaddingBottom();
            i5 = z.resolveSizeAndState(Math.max(this.OU, getSuggestedMinimumHeight()), i2, 0);
            i7 = (16777215 & i5) - this.OU;
            int i16;
            if (obj5 != null || (i7 != 0 && f > 0.0f)) {
                if (this.OV > 0.0f) {
                    f = this.OV;
                }
                this.OU = 0;
                i15 = 0;
                float f3 = f;
                obj5 = obj3;
                i16 = i11;
                i14 = i10;
                i12 = i9;
                while (i15 < virtualChildCount) {
                    float f4;
                    View childAt3 = getChildAt(i15);
                    if (childAt3.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt3.getLayoutParams();
                        float f5 = layoutParams.weight;
                        if (f5 > 0.0f) {
                            View view;
                            i8 = (int) ((((float) i7) * f5) / f3);
                            f5 = f3 - f5;
                            max = i7 - i8;
                            i6 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width);
                            if (layoutParams.height != 0 || mode2 != 1073741824) {
                                i8 += childAt3.getMeasuredHeight();
                                if (i8 < 0) {
                                    i8 = 0;
                                }
                                view = childAt3;
                            } else if (i8 > 0) {
                                view = childAt3;
                            } else {
                                i8 = 0;
                                view = childAt3;
                            }
                            view.measure(i6, MeasureSpec.makeMeasureSpec(i8, 1073741824));
                            f4 = f5;
                            i7 = max;
                            i14 = at.combineMeasuredStates(i14, z.M(childAt3) & -256);
                        } else {
                            f4 = f3;
                        }
                        i6 = layoutParams.leftMargin + layoutParams.rightMargin;
                        i3 = childAt3.getMeasuredWidth() + i6;
                        max = Math.max(i12, i3);
                        obj3 = (mode == 1073741824 || layoutParams.width != -1) ? null : 1;
                        if (obj3 == null) {
                            i6 = i3;
                        }
                        i3 = Math.max(i16, i6);
                        obj2 = (obj5 == null || layoutParams.width != -1) ? null : 1;
                        int i17 = this.OU;
                        this.OU = Math.max(i17, (layoutParams.bottomMargin + ((childAt3.getMeasuredHeight() + i17) + layoutParams.topMargin)) + 0);
                        obj = obj2;
                        measuredWidth = i3;
                    } else {
                        f4 = f3;
                        obj = obj5;
                        measuredWidth = i16;
                        max = i12;
                    }
                    i15++;
                    f3 = f4;
                    obj5 = obj;
                    i16 = measuredWidth;
                    i12 = max;
                }
                this.OU += getPaddingTop() + getPaddingBottom();
                obj3 = obj5;
                i4 = i16;
                i10 = i14;
                i8 = i12;
            } else {
                i16 = Math.max(i11, i12);
                if (z && mode2 != 1073741824) {
                    i4 = 0;
                    while (true) {
                        i8 = i4;
                        if (i8 >= virtualChildCount) {
                            break;
                        }
                        View childAt4 = getChildAt(i8);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LayoutParams) childAt4.getLayoutParams()).weight <= 0.0f)) {
                            childAt4.measure(MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i14, 1073741824));
                        }
                        i4 = i8 + 1;
                    }
                }
                i4 = i16;
                i8 = i9;
            }
            if (obj3 != null || mode == 1073741824) {
                i4 = i8;
            }
            setMeasuredDimension(z.resolveSizeAndState(Math.max(i4 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i10), i5);
            if (obj4 != null) {
                M(virtualChildCount, i2);
                return;
            }
            return;
        }
        N(i, i2);
    }

    private boolean bd(int i) {
        if (i == 0) {
            if ((this.Pc & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.Pc & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.Pc & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    private void M(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void N(int i, int i2) {
        Object obj;
        View childAt;
        LayoutParams layoutParams;
        int i3;
        int i4;
        Object obj2;
        int i5;
        int measuredHeight;
        int baseline;
        int i6;
        Object obj3;
        int max;
        Object obj4;
        LayoutParams layoutParams2;
        this.OU = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        Object obj5 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj6 = null;
        Object obj7 = null;
        if (this.OX == null || this.OY == null) {
            this.OX = new int[4];
            this.OY = new int[4];
        }
        int[] iArr = this.OX;
        int[] iArr2 = this.OY;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.OQ;
        boolean z2 = this.OW;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            int i13;
            childAt = getChildAt(i12);
            if (childAt == null) {
                this.OU += 0;
                i13 = i12;
            } else {
                if (childAt.getVisibility() != 8) {
                    if (bd(i12)) {
                        this.OU += this.Pa;
                    }
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    float f2 = f + layoutParams.weight;
                    if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        if (obj != null) {
                            this.OU += layoutParams.leftMargin + layoutParams.rightMargin;
                        } else {
                            i3 = this.OU;
                            this.OU = Math.max(i3, (layoutParams.leftMargin + i3) + layoutParams.rightMargin);
                        }
                        if (z) {
                            i3 = MeasureSpec.makeMeasureSpec(0, 0);
                            childAt.measure(i3, i3);
                            i13 = i11;
                        } else {
                            obj7 = 1;
                            i13 = i11;
                        }
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                            i3 = 0;
                            layoutParams.width = -2;
                        }
                        int i14 = i3;
                        e(childAt, i, f2 == 0.0f ? this.OU : 0, i2, 0);
                        if (i14 != Integer.MIN_VALUE) {
                            layoutParams.width = i14;
                        }
                        i3 = childAt.getMeasuredWidth();
                        if (obj != null) {
                            this.OU += ((layoutParams.leftMargin + i3) + layoutParams.rightMargin) + 0;
                        } else {
                            i4 = this.OU;
                            this.OU = Math.max(i4, (((i4 + i3) + layoutParams.leftMargin) + layoutParams.rightMargin) + 0);
                        }
                        if (z2) {
                            i13 = Math.max(i3, i11);
                        } else {
                            i13 = i11;
                        }
                    }
                    Object obj8 = null;
                    if (mode2 == 1073741824 || layoutParams.height != -1) {
                        obj2 = obj6;
                    } else {
                        obj2 = 1;
                        obj8 = 1;
                    }
                    i5 = layoutParams.topMargin + layoutParams.bottomMargin;
                    measuredHeight = childAt.getMeasuredHeight() + i5;
                    i11 = at.combineMeasuredStates(i8, z.M(childAt));
                    if (z) {
                        baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            i6 = ((((layoutParams.gravity < 0 ? this.rA : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i6] = Math.max(iArr[i6], baseline);
                            iArr2[i6] = Math.max(iArr2[i6], measuredHeight - baseline);
                        }
                    }
                    i7 = Math.max(i7, measuredHeight);
                    obj3 = (obj5 == null || layoutParams.height != -1) ? null : 1;
                    if (layoutParams.weight > 0.0f) {
                        if (obj8 != null) {
                            i3 = i5;
                        } else {
                            i3 = measuredHeight;
                        }
                        max = Math.max(i10, i3);
                        i3 = i13;
                        obj4 = obj7;
                        f = f2;
                        i8 = i11;
                    } else {
                        if (obj8 == null) {
                            i5 = measuredHeight;
                        }
                        baseline = Math.max(i9, i5);
                        i3 = i13;
                        obj4 = obj7;
                        f = f2;
                        max = i10;
                        i9 = baseline;
                        i8 = i11;
                    }
                } else {
                    i3 = i11;
                    obj4 = obj7;
                    obj2 = obj6;
                    obj3 = obj5;
                    max = i10;
                }
                i13 = i12 + 0;
                i11 = i3;
                obj7 = obj4;
                obj6 = obj2;
                obj5 = obj3;
                i10 = max;
            }
            i12 = i13 + 1;
        }
        if (this.OU > 0 && bd(virtualChildCount)) {
            this.OU += this.Pa;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i4 = i7;
        } else {
            i4 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.OU = 0;
            i6 = 0;
            while (i6 < virtualChildCount) {
                View childAt2 = getChildAt(i6);
                if (childAt2 == null) {
                    this.OU += 0;
                    i3 = i6;
                } else if (childAt2.getVisibility() == 8) {
                    i3 = i6 + 0;
                } else {
                    layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (obj != null) {
                        this.OU = ((layoutParams2.rightMargin + (layoutParams2.leftMargin + i11)) + 0) + this.OU;
                        i3 = i6;
                    } else {
                        i5 = this.OU;
                        this.OU = Math.max(i5, (layoutParams2.rightMargin + ((i5 + i11) + layoutParams2.leftMargin)) + 0);
                        i3 = i6;
                    }
                }
                i6 = i3 + 1;
            }
        }
        this.OU += getPaddingLeft() + getPaddingRight();
        i12 = z.resolveSizeAndState(Math.max(this.OU, getSuggestedMinimumWidth()), i, 0);
        max = (16777215 & i12) - this.OU;
        int i15;
        View childAt3;
        if (obj7 != null || (max != 0 && f > 0.0f)) {
            if (this.OV > 0.0f) {
                f = this.OV;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            i10 = -1;
            this.OU = 0;
            i7 = 0;
            float f3 = f;
            Object obj9 = obj5;
            i15 = i9;
            int i16 = i8;
            while (i7 < virtualChildCount) {
                float f4;
                int i17;
                childAt3 = getChildAt(i7);
                if (childAt3 == null || childAt3.getVisibility() == 8) {
                    f4 = f3;
                    i6 = max;
                    obj4 = obj9;
                    measuredHeight = i15;
                    i17 = i10;
                } else {
                    float f5;
                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    f = layoutParams2.weight;
                    if (f > 0.0f) {
                        View view;
                        i6 = (int) ((((float) max) * f) / f3);
                        f5 = f3 - f;
                        max -= i6;
                        measuredHeight = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin, layoutParams2.height);
                        if (layoutParams2.width != 0 || mode != 1073741824) {
                            i6 += childAt3.getMeasuredWidth();
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            view = childAt3;
                        } else if (i6 > 0) {
                            view = childAt3;
                        } else {
                            i6 = 0;
                            view = childAt3;
                        }
                        view.measure(MeasureSpec.makeMeasureSpec(i6, 1073741824), measuredHeight);
                        i16 = at.combineMeasuredStates(i16, z.M(childAt3) & -16777216);
                    } else {
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.OU += ((childAt3.getMeasuredWidth() + layoutParams2.leftMargin) + layoutParams2.rightMargin) + 0;
                    } else {
                        i6 = this.OU;
                        this.OU = Math.max(i6, (((childAt3.getMeasuredWidth() + i6) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + 0);
                    }
                    obj3 = (mode2 == 1073741824 || layoutParams2.height != -1) ? null : 1;
                    i4 = layoutParams2.topMargin + layoutParams2.bottomMargin;
                    measuredHeight = childAt3.getMeasuredHeight() + i4;
                    i17 = Math.max(i10, measuredHeight);
                    if (obj3 != null) {
                        i6 = i4;
                    } else {
                        i6 = measuredHeight;
                    }
                    i15 = Math.max(i15, i6);
                    obj2 = (obj9 == null || layoutParams2.height != -1) ? null : 1;
                    if (z) {
                        i6 = childAt3.getBaseline();
                        if (i6 != -1) {
                            i3 = ((((layoutParams2.gravity < 0 ? this.rA : layoutParams2.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i6);
                            iArr2[i3] = Math.max(iArr2[i3], measuredHeight - i6);
                        }
                    }
                    f4 = f5;
                    i6 = max;
                    obj4 = obj2;
                    measuredHeight = i15;
                }
                i7++;
                f3 = f4;
                max = i6;
                obj9 = obj4;
                i15 = measuredHeight;
                i10 = i17;
            }
            this.OU += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i10 = Math.max(i10, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj5 = obj9;
            i3 = i15;
            i8 = i16;
            i6 = i10;
        } else {
            i15 = Math.max(i9, i10);
            if (z2 && mode != 1073741824) {
                i3 = 0;
                while (true) {
                    i6 = i3;
                    if (i6 >= virtualChildCount) {
                        break;
                    }
                    childAt3 = getChildAt(i6);
                    if (!(childAt3 == null || childAt3.getVisibility() == 8 || ((LayoutParams) childAt3.getLayoutParams()).weight <= 0.0f)) {
                        childAt3.measure(MeasureSpec.makeMeasureSpec(i11, 1073741824), MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), 1073741824));
                    }
                    i3 = i6 + 1;
                }
            }
            i3 = i15;
            i6 = i4;
        }
        if (obj5 != null || mode2 == 1073741824) {
            i3 = i6;
        }
        setMeasuredDimension((-16777216 & i8) | i12, z.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i8 << 16));
        if (obj6 != null) {
            measuredHeight = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            i3 = 0;
            while (true) {
                int i18 = i3;
                if (i18 < virtualChildCount) {
                    childAt = getChildAt(i18);
                    if (childAt.getVisibility() != 8) {
                        layoutParams = (LayoutParams) childAt.getLayoutParams();
                        if (layoutParams.height == -1) {
                            baseline = layoutParams.width;
                            layoutParams.width = childAt.getMeasuredWidth();
                            measureChildWithMargins(childAt, i, 0, measuredHeight, 0);
                            layoutParams.width = baseline;
                        }
                    }
                    i3 = i18 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static int getChildrenSkipCount$5359dca7() {
        return 0;
    }

    private void e(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    private static int getLocationOffset$3c7ec8d0() {
        return 0;
    }

    private static int getNextLocationOffset$3c7ec8d0() {
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
        r23 = this;
        r0 = r23;
        r3 = r0.OT;
        r4 = 1;
        if (r3 != r4) goto L_0x00bd;
    L_0x0007:
        r8 = r23.getPaddingLeft();
        r3 = r27 - r25;
        r4 = r23.getPaddingRight();
        r9 = r3 - r4;
        r3 = r3 - r8;
        r4 = r23.getPaddingRight();
        r10 = r3 - r4;
        r11 = r23.getVirtualChildCount();
        r0 = r23;
        r3 = r0.rA;
        r3 = r3 & 112;
        r0 = r23;
        r4 = r0.rA;
        r5 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r5 = r5 & r4;
        switch(r3) {
            case 16: goto L_0x0053;
            case 80: goto L_0x0045;
            default: goto L_0x002f;
        };
    L_0x002f:
        r3 = r23.getPaddingTop();
    L_0x0033:
        r7 = 0;
        r6 = r3;
    L_0x0035:
        if (r7 >= r11) goto L_0x01d5;
    L_0x0037:
        r0 = r23;
        r12 = r0.getChildAt(r7);
        if (r12 != 0) goto L_0x0062;
    L_0x003f:
        r6 = r6 + 0;
        r3 = r7;
    L_0x0042:
        r7 = r3 + 1;
        goto L_0x0035;
    L_0x0045:
        r3 = r23.getPaddingTop();
        r3 = r3 + r28;
        r3 = r3 - r26;
        r0 = r23;
        r4 = r0.OU;
        r3 = r3 - r4;
        goto L_0x0033;
    L_0x0053:
        r3 = r23.getPaddingTop();
        r4 = r28 - r26;
        r0 = r23;
        r6 = r0.OU;
        r4 = r4 - r6;
        r4 = r4 / 2;
        r3 = r3 + r4;
        goto L_0x0033;
    L_0x0062:
        r3 = r12.getVisibility();
        r4 = 8;
        if (r3 == r4) goto L_0x01e0;
    L_0x006a:
        r13 = r12.getMeasuredWidth();
        r14 = r12.getMeasuredHeight();
        r3 = r12.getLayoutParams();
        r3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r3;
        r4 = r3.gravity;
        if (r4 >= 0) goto L_0x007d;
    L_0x007c:
        r4 = r5;
    L_0x007d:
        r15 = android.support.v4.view.z.I(r23);
        r4 = android.support.v4.view.f.getAbsoluteGravity(r4, r15);
        r4 = r4 & 7;
        switch(r4) {
            case 1: goto L_0x00ab;
            case 5: goto L_0x00b7;
            default: goto L_0x008a;
        };
    L_0x008a:
        r4 = r3.leftMargin;
        r4 = r4 + r8;
    L_0x008d:
        r0 = r23;
        r15 = r0.bd(r7);
        if (r15 == 0) goto L_0x009a;
    L_0x0095:
        r0 = r23;
        r15 = r0.Pb;
        r6 = r6 + r15;
    L_0x009a:
        r15 = r3.topMargin;
        r6 = r6 + r15;
        r15 = r6 + 0;
        f(r12, r4, r15, r13, r14);
        r3 = r3.bottomMargin;
        r3 = r3 + r14;
        r3 = r3 + 0;
        r6 = r6 + r3;
        r3 = r7 + 0;
        goto L_0x0042;
    L_0x00ab:
        r4 = r10 - r13;
        r4 = r4 / 2;
        r4 = r4 + r8;
        r15 = r3.leftMargin;
        r4 = r4 + r15;
        r15 = r3.rightMargin;
        r4 = r4 - r15;
        goto L_0x008d;
    L_0x00b7:
        r4 = r9 - r13;
        r15 = r3.rightMargin;
        r4 = r4 - r15;
        goto L_0x008d;
    L_0x00bd:
        r4 = android.support.v7.widget.at.bv(r23);
        r8 = r23.getPaddingTop();
        r3 = r28 - r26;
        r5 = r23.getPaddingBottom();
        r12 = r3 - r5;
        r3 = r3 - r8;
        r5 = r23.getPaddingBottom();
        r13 = r3 - r5;
        r14 = r23.getVirtualChildCount();
        r0 = r23;
        r3 = r0.rA;
        r5 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r3 = r3 & r5;
        r0 = r23;
        r5 = r0.rA;
        r11 = r5 & 112;
        r0 = r23;
        r15 = r0.OQ;
        r0 = r23;
        r0 = r0.OX;
        r16 = r0;
        r0 = r23;
        r0 = r0.OY;
        r17 = r0;
        r5 = android.support.v4.view.z.I(r23);
        r3 = android.support.v4.view.f.getAbsoluteGravity(r3, r5);
        switch(r3) {
            case 1: goto L_0x0133;
            case 5: goto L_0x0124;
            default: goto L_0x0101;
        };
    L_0x0101:
        r9 = r23.getPaddingLeft();
    L_0x0105:
        r5 = 0;
        r3 = 1;
        if (r4 == 0) goto L_0x01dd;
    L_0x0109:
        r5 = r14 + -1;
        r3 = -1;
        r4 = r3;
    L_0x010d:
        r10 = 0;
    L_0x010e:
        if (r10 >= r14) goto L_0x01d5;
    L_0x0110:
        r3 = r4 * r10;
        r18 = r5 + r3;
        r0 = r23;
        r1 = r18;
        r19 = r0.getChildAt(r1);
        if (r19 != 0) goto L_0x0143;
    L_0x011e:
        r9 = r9 + 0;
        r3 = r10;
    L_0x0121:
        r10 = r3 + 1;
        goto L_0x010e;
    L_0x0124:
        r3 = r23.getPaddingLeft();
        r3 = r3 + r27;
        r3 = r3 - r25;
        r0 = r23;
        r5 = r0.OU;
        r9 = r3 - r5;
        goto L_0x0105;
    L_0x0133:
        r3 = r23.getPaddingLeft();
        r5 = r27 - r25;
        r0 = r23;
        r6 = r0.OU;
        r5 = r5 - r6;
        r5 = r5 / 2;
        r9 = r3 + r5;
        goto L_0x0105;
    L_0x0143:
        r3 = r19.getVisibility();
        r6 = 8;
        if (r3 == r6) goto L_0x01da;
    L_0x014b:
        r20 = r19.getMeasuredWidth();
        r21 = r19.getMeasuredHeight();
        r6 = -1;
        r3 = r19.getLayoutParams();
        r3 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r3;
        if (r15 == 0) goto L_0x0168;
    L_0x015c:
        r7 = r3.height;
        r22 = -1;
        r0 = r22;
        if (r7 == r0) goto L_0x0168;
    L_0x0164:
        r6 = r19.getBaseline();
    L_0x0168:
        r7 = r3.gravity;
        if (r7 >= 0) goto L_0x016d;
    L_0x016c:
        r7 = r11;
    L_0x016d:
        r7 = r7 & 112;
        switch(r7) {
            case 16: goto L_0x01ac;
            case 48: goto L_0x019b;
            case 80: goto L_0x01b8;
            default: goto L_0x0172;
        };
    L_0x0172:
        r6 = r8;
    L_0x0173:
        r0 = r23;
        r1 = r18;
        r7 = r0.bd(r1);
        if (r7 == 0) goto L_0x01d6;
    L_0x017d:
        r0 = r23;
        r7 = r0.Pa;
        r7 = r7 + r9;
    L_0x0182:
        r9 = r3.leftMargin;
        r7 = r7 + r9;
        r9 = r7 + 0;
        r0 = r19;
        r1 = r20;
        r2 = r21;
        f(r0, r9, r6, r1, r2);
        r3 = r3.rightMargin;
        r3 = r3 + r20;
        r3 = r3 + 0;
        r9 = r7 + r3;
        r3 = r10 + 0;
        goto L_0x0121;
    L_0x019b:
        r7 = r3.topMargin;
        r7 = r7 + r8;
        r22 = -1;
        r0 = r22;
        if (r6 == r0) goto L_0x01d8;
    L_0x01a4:
        r22 = 1;
        r22 = r16[r22];
        r6 = r22 - r6;
        r6 = r6 + r7;
        goto L_0x0173;
    L_0x01ac:
        r6 = r13 - r21;
        r6 = r6 / 2;
        r6 = r6 + r8;
        r7 = r3.topMargin;
        r6 = r6 + r7;
        r7 = r3.bottomMargin;
        r6 = r6 - r7;
        goto L_0x0173;
    L_0x01b8:
        r7 = r12 - r21;
        r0 = r3.bottomMargin;
        r22 = r0;
        r7 = r7 - r22;
        r22 = -1;
        r0 = r22;
        if (r6 == r0) goto L_0x01d8;
    L_0x01c6:
        r22 = r19.getMeasuredHeight();
        r6 = r22 - r6;
        r22 = 2;
        r22 = r17[r22];
        r6 = r22 - r6;
        r6 = r7 - r6;
        goto L_0x0173;
    L_0x01d5:
        return;
    L_0x01d6:
        r7 = r9;
        goto L_0x0182;
    L_0x01d8:
        r6 = r7;
        goto L_0x0173;
    L_0x01da:
        r3 = r10;
        goto L_0x0121;
    L_0x01dd:
        r4 = r3;
        goto L_0x010d;
    L_0x01e0:
        r3 = r7;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    private static void f(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.OT != i) {
            this.OT = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.OT;
    }

    public void setGravity(int i) {
        if (this.rA != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.rA = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.rA & 8388615) != i2) {
            this.rA = i2 | (this.rA & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.rA & 112) != i2) {
            this.rA = i2 | (this.rA & -113);
            requestLayout();
        }
    }

    /* renamed from: d */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: ep */
    protected LayoutParams generateDefaultLayoutParams() {
        if (this.OT == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.OT == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* renamed from: d */
    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }
}
