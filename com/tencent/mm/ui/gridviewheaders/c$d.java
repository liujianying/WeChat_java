package com.tencent.mm.ui.gridviewheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

protected class c$d extends FrameLayout {
    private int mNumColumns;
    private int mPosition;
    private View[] utV;
    final /* synthetic */ c utW;
    private boolean uua;

    public c$d(c cVar, Context context) {
        this.utW = cVar;
        super(context);
    }

    public final Object getTag() {
        return getChildAt(0).getTag();
    }

    public final Object getTag(int i) {
        return getChildAt(0).getTag(i);
    }

    public final View getView() {
        return getChildAt(0);
    }

    public final void setNumColumns(int i) {
        this.mNumColumns = i;
    }

    public final void setPosition(int i) {
        this.mPosition = i;
    }

    @SuppressLint({"NewApi"})
    public final void setRowSiblings(View[] viewArr) {
        this.utV = viewArr;
    }

    public final void setTag(int i, Object obj) {
        getChildAt(0).setTag(i, obj);
    }

    public final void setTag(Object obj) {
        getChildAt(0).setTag(obj);
    }

    protected final LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected final void onMeasure(int i, int i2) {
        int i3 = 0;
        super.onMeasure(i, i2);
        if (this.mNumColumns != 1 && c.b(this.utW) != null) {
            if (this.mPosition % this.mNumColumns == 0 && !this.uua) {
                this.uua = true;
                for (View measure : this.utV) {
                    measure.measure(i, i2);
                }
                this.uua = false;
            }
            int measuredHeight = getMeasuredHeight();
            View[] viewArr = this.utV;
            int length = viewArr.length;
            int i4 = measuredHeight;
            while (i3 < length) {
                View view = viewArr[i3];
                if (view != null) {
                    i4 = Math.max(i4, view.getMeasuredHeight());
                }
                i3++;
            }
            if (i4 != measuredHeight) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(i4, 1073741824));
            }
        }
    }
}
