package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.t;

class l$1 implements Runnable {
    final /* synthetic */ l tXM;

    l$1(l lVar) {
        this.tXM = lVar;
    }

    public final void run() {
        if (this.tXM.tXK != null) {
            if (this.tXM.iC(t.w(this.tXM.elF, this.tXM.filename))) {
                if (this.tXM.nPO == 0 && this.tXM.nPQ == 0) {
                    this.tXM.bCy();
                }
                this.tXM.tXK.aX(this.tXM.filename, true);
                this.tXM.elL = true;
            }
        }
    }
}
