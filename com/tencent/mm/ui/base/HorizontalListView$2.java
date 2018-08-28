package com.tencent.mm.ui.base;

class HorizontalListView$2 implements Runnable {
    final /* synthetic */ HorizontalListView tsN;

    HorizontalListView$2(HorizontalListView horizontalListView) {
        this.tsN = horizontalListView;
    }

    public final void run() {
        this.tsN.requestLayout();
    }
}
