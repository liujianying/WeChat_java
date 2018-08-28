package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.f;

class d$1 implements Runnable {
    final /* synthetic */ d vcd;

    d$1(d dVar) {
        this.vcd = dVar;
    }

    public final void run() {
        this.vcd.hiW = true;
        c.d("MicroMsg.Voip", new Object[]{"NETTASK_RECV TimeOut cmd= ", this.vcd.cEm()});
        f.u(20006, 3, "-1104");
        if (this.vcd.vbY != null) {
            this.vcd.vbY.a(2, -1, "time exceed, force to callback", this.vcd);
        }
    }
}
