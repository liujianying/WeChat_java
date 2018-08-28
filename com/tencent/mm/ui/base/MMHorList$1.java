package com.tencent.mm.ui.base;

class MMHorList$1 implements Runnable {
    final /* synthetic */ MMHorList tvP;

    MMHorList$1(MMHorList mMHorList) {
        this.tvP = mMHorList;
    }

    public final void run() {
        this.tvP.requestLayout();
    }
}
