package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

protected class c$b extends FrameLayout {
    final /* synthetic */ c utW;
    private int utX;
    private int utY;

    public c$b(c cVar, Context context) {
        this.utW = cVar;
        super(context);
    }

    public final int getHeaderId() {
        return this.utX;
    }

    public final void setHeaderId(int i) {
        this.utX = i;
    }

    public final void setHeaderWidth(int i) {
        this.utY = i;
    }

    protected final void onMeasure(int i, int i2) {
        View view = (View) getTag();
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(generateDefaultLayoutParams());
        }
        if (view.getVisibility() != 8 && view.getMeasuredHeight() == 0) {
            view.measure(MeasureSpec.makeMeasureSpec(this.utY, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        }
        setMeasuredDimension(MeasureSpec.getSize(i), view.getMeasuredHeight());
    }

    protected final LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }
}
