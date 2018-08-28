package com.tencent.mm.ui.chatting.b;

class ad$11 implements Runnable {
    final /* synthetic */ int gIO;
    final /* synthetic */ ad tRG;
    final /* synthetic */ long val$position;

    ad$11(ad adVar, long j, int i) {
        this.tRG = adVar;
        this.val$position = j;
        this.gIO = i;
    }

    public final void run() {
        this.tRG.bAG.getListView().postDelayed(new 1(this), 100);
    }
}
