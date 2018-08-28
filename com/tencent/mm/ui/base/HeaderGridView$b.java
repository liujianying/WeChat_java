package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

class HeaderGridView$b extends FrameLayout {
    final /* synthetic */ HeaderGridView tsw;

    public HeaderGridView$b(HeaderGridView headerGridView, Context context) {
        this.tsw = headerGridView;
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec((this.tsw.getMeasuredWidth() - this.tsw.getPaddingLeft()) - this.tsw.getPaddingRight(), 1073741824), i2);
    }
}
