package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.TimerTask;

class e$3 extends TimerTask {
    final /* synthetic */ e ltL;

    e$3(e eVar) {
        this.ltL = eVar;
    }

    public final void run() {
        if (this.ltL.bgo() >= 45000 && this.ltL.lts != e.Talking) {
            ah.A(new 1(this));
        }
        if (this.ltL.lts == e.Talking) {
            e eVar = this.ltL;
            eVar.ltw++;
            ah.A(new 2(this));
        }
    }
}
