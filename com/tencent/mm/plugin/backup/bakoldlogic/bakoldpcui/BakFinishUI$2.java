package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

class BakFinishUI$2 implements Runnable {
    final /* synthetic */ BakFinishUI haF;

    BakFinishUI$2(BakFinishUI bakFinishUI) {
        this.haF = bakFinishUI;
    }

    public final void run() {
        a.asN().asO().gZU = -1;
        BakFinishUI.b(this.haF);
    }
}
