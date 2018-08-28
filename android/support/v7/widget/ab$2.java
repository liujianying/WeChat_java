package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

class ab$2 extends ab {
    ab$2(RecyclerView$h recyclerView$h) {
        super(recyclerView$h, (byte) 0);
    }

    public final int ft() {
        return this.QG.mHeight - this.QG.getPaddingBottom();
    }

    public final int getEnd() {
        return this.QG.mHeight;
    }

    public final void bj(int i) {
        this.QG.bq(i);
    }

    public final int fs() {
        return this.QG.getPaddingTop();
    }

    public final int aW(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (RecyclerView$h.bg(view) + layoutParams.topMargin);
    }

    public final int aX(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (RecyclerView$h.bf(view) + layoutParams.leftMargin);
    }

    public final int aV(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + RecyclerView$h.bk(view);
    }

    public final int aU(View view) {
        return RecyclerView$h.bi(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
    }

    public final int fu() {
        return (this.QG.mHeight - this.QG.getPaddingTop()) - this.QG.getPaddingBottom();
    }

    public final int getEndPadding() {
        return this.QG.getPaddingBottom();
    }

    public final int getMode() {
        return this.QG.Sg;
    }

    public final int fv() {
        return this.QG.Sf;
    }
}
