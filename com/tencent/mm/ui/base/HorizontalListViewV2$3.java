package com.tencent.mm.ui.base;

class HorizontalListViewV2$3 implements Runnable {
    final /* synthetic */ HorizontalListViewV2 tti;

    HorizontalListViewV2$3(HorizontalListViewV2 horizontalListViewV2) {
        this.tti = horizontalListViewV2;
    }

    public final void run() {
        this.tti.requestLayout();
    }
}
