package com.tencent.mm.plugin.topstory.ui.video;

class n$15 implements f {
    final /* synthetic */ n oBM;
    final /* synthetic */ boolean oBN;

    n$15(n nVar, boolean z) {
        this.oBM = nVar;
        this.oBN = z;
    }

    public final void bIb() {
        if (n.b(this.oBM).bHQ().jMc) {
            this.oBM.setShowFullScreenPlayNext(true);
            this.oBM.bIs();
            return;
        }
        if (!this.oBN) {
            n.b(this.oBM).bHU().oAl = 2;
        }
        n.b(this.oBM).ye(n.d(this.oBM) + 1);
    }
}
