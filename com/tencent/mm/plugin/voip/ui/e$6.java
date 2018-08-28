package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.R;

class e$6 implements Runnable {
    final /* synthetic */ e oSe;

    e$6(e eVar) {
        this.oSe = eVar;
    }

    public final void run() {
        e.n(this.oSe).setText(R.l.voip_invite_waiting_tip);
        this.oSe.oQx.a(e.o(this.oSe), d.oQq);
    }
}
