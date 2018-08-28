package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.a.e.3;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.model.i;

class e$3$2 implements Runnable {
    final /* synthetic */ 3 ltN;

    e$3$2(3 3) {
        this.ltN = 3;
    }

    public final void run() {
        if (this.ltN.ltL.lts == e.lvM) {
            i.bJJ().wQ(this.ltN.ltL.ltw);
            if (this.ltN.ltL.ltC != null) {
                this.ltN.ltL.ltC.aWZ();
            }
        }
    }
}
