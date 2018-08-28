package com.tencent.mm.plugin.collect.ui;

class CollectMainUI$20 implements Runnable {
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$20(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
    }

    public final void run() {
        int[] iArr = new int[2];
        CollectMainUI.j(this.hYN).getLocationInWindow(iArr);
        CollectMainUI.ou(iArr[1]);
    }
}
