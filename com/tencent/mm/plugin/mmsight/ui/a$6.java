package com.tencent.mm.plugin.mmsight.ui;

class a$6 implements Runnable {
    final /* synthetic */ a lpk;

    a$6(a aVar) {
        this.lpk = aVar;
    }

    public final void run() {
        this.lpk.lpa.setFooterVisible(false);
        this.lpk.lpa.setActionBarVisible(false);
        this.lpk.lpa.setActivated(false);
        a.a(this.lpk);
    }
}
