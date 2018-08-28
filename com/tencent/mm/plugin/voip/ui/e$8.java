package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.sdk.platformtools.x;

class e$8 implements Runnable {
    final /* synthetic */ e oSe;

    e$8(e eVar) {
        this.oSe = eVar;
    }

    public final void run() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
        e.r(this.oSe);
        if (this.oSe.getActivity() != null && !this.oSe.getActivity().isFinishing() && e.s(this.oSe) <= 0) {
            e.p(this.oSe).setVisibility(8);
            e.t(this.oSe).setVisibility(8);
            e.u(this.oSe).setVisibility(8);
            e.a(this.oSe).setVisibility(8);
            e.b(this.oSe).setVisibility(8);
            e.e(this.oSe, false);
        }
    }
}
