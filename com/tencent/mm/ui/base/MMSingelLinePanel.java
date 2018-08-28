package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.m;
import java.util.LinkedList;

public class MMSingelLinePanel extends MMTagPanel {
    static final /* synthetic */ boolean $assertionsDisabled = (!MMSingelLinePanel.class.desiredAssertionStatus());
    private int tsr;
    private int tss;
    private LinkedList<Integer> tst;
    private boolean txi;
    private TextView txj;
    private int txk;
    private int txl;

    public MMSingelLinePanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMSingelLinePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tst = new LinkedList();
        this.tsr = 0;
        this.tss = 0;
        this.txi = true;
        this.txk = 0;
        this.txl = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.FlowLayout);
        try {
            this.tsr = obtainStyledAttributes.getDimensionPixelSize(m.FlowLayout_horizontalSpacing, 0);
            this.tss = obtainStyledAttributes.getDimensionPixelSize(m.FlowLayout_verticalSpacing, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void crI() {
        super.crI();
        this.txj = new TextView(getContext());
        this.txj.setText("...");
        this.txj.setTextColor(getResources().getColor(d.wechat_green));
        this.txj.setLayoutParams(generateDefaultLayoutParams());
        addView(this.txj);
    }

    public void setSingleLine(boolean z) {
        this.txi = z;
        this.txj = new TextView(getContext());
        this.txj.setText("...");
        this.txj.setLayoutParams(generateDefaultLayoutParams());
        addView(this.txj);
    }

    protected void onMeasure(int i, int i2) {
        if ($assertionsDisabled || MeasureSpec.getMode(i) != 0) {
            int makeMeasureSpec;
            int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
            int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
            int childCount = getChildCount();
            this.tst.clear();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            }
            if (this.txi && this.txj != null) {
                this.txj.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                this.txk = this.txj.getMeasuredWidth();
                this.txl = this.txj.getMeasuredHeight();
                x.d("MicroMsg.MMTagContactPanel", "mEllipsisWidth %d", new Object[]{Integer.valueOf(this.txk)});
            }
            if (this.txi) {
                size -= this.txk;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i6 = childAt.getMeasuredHeight();
                    if (i3 + measuredWidth > size) {
                        i3 = 0;
                        i4 += this.tss + i5;
                        this.tst.add(Integer.valueOf(i5));
                        i5 = 0;
                    }
                    i5 = Math.max(i5, childAt.getMeasuredHeight());
                    i3 += this.tsr + measuredWidth;
                }
            }
            this.tst.add(Integer.valueOf(i5));
            if (this.txi) {
                getPaddingTop();
                getPaddingBottom();
            } else if (MeasureSpec.getMode(i2) == 0) {
                getPaddingTop();
                getPaddingBottom();
            } else if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE && i4 + i5 < size2) {
                getPaddingTop();
                getPaddingBottom();
            }
            setMeasuredDimension(MeasureSpec.getSize(i), i6);
            return;
        }
        throw new AssertionError();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount;
        int i5;
        int paddingLeft;
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.txi) {
            childCount = getChildCount();
            i5 = (i3 - i) - this.txk;
            paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
            i6 = 0;
            i7 = 0;
            i8 = 0;
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 8 || childAt == this.txj) {
                    i9 = i8;
                    i10 = paddingTop;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if ((paddingLeft + measuredWidth) + getPaddingRight() > i5) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += ((Integer) this.tst.get(i8)).intValue() + this.tss;
                        i9 = i8 + 1;
                    } else {
                        i9 = i8;
                    }
                    if (i9 <= 0) {
                        childAt.layout(paddingLeft, paddingTop + 0, paddingLeft + measuredWidth, (paddingTop + 0) + measuredHeight);
                        i8 = (this.tsr + measuredWidth) + paddingLeft;
                        i7 = paddingTop;
                        i6 = i8;
                        i10 = paddingTop;
                        paddingLeft = i8;
                    } else {
                        i10 = paddingTop;
                    }
                }
                i11++;
                i8 = i9;
                paddingTop = i10;
            }
            if (this.txj == null) {
                return;
            }
            if (i8 > 0) {
                this.txj.layout(i6, i7, this.txk + i6, this.txl + i7);
                return;
            } else {
                this.txj.layout(0, 0, 0, 0);
                return;
            }
        }
        i10 = getChildCount();
        paddingLeft = i3 - i;
        i9 = getPaddingLeft();
        i7 = getPaddingTop();
        i8 = 0;
        for (i6 = 0; i6 < i10; i6++) {
            View childAt2 = getChildAt(i6);
            if (!(childAt2.getVisibility() == 8 || childAt2 == this.txj)) {
                childCount = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                if ((i9 + childCount) + getPaddingRight() > paddingLeft) {
                    paddingTop = getPaddingLeft();
                    i7 += ((Integer) this.tst.get(i8)).intValue() + this.tss;
                    i8++;
                } else {
                    paddingTop = i9;
                }
                i9 = (((Integer) this.tst.get(i8)).intValue() - i5) / 2;
                childAt2.layout(paddingTop, i7 + i9, paddingTop + childCount, (i9 + i7) + i5);
                i9 = (this.tsr + childCount) + paddingTop;
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
