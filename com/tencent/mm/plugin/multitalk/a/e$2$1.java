package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.a.e.2;
import com.tencent.mm.plugin.multitalk.a.i.a;
import com.tencent.mm.sdk.platformtools.x;

class e$2$1 implements Runnable {
    final /* synthetic */ 2 ltM;

    e$2$1(2 2) {
        this.ltM = 2;
    }

    public final void run() {
        a bgF = i.bgF();
        if (bgF != this.ltM.ltL.ltD) {
            a aVar = this.ltM.ltL.ltD;
            this.ltM.ltL.ltD = bgF;
            x.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[]{aVar.name(), this.ltM.ltL.ltD.name()});
            this.ltM.ltL.ti(this.ltM.ltL.ltp);
            if (this.ltM.ltL.ltC != null) {
                this.ltM.ltL.ltC.a(this.ltM.ltL.ltD);
                return;
            }
            return;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[]{this.ltM.ltL.ltD.name()});
    }
}
