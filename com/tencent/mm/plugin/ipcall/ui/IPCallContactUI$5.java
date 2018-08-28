package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.o.b;

class IPCallContactUI$5 implements b {
    final /* synthetic */ IPCallContactUI kuK;

    IPCallContactUI$5(IPCallContactUI iPCallContactUI) {
        this.kuK = iPCallContactUI;
    }

    public final void WX() {
        x.d("MicroMsg.IPCallContactUI", "onEnterSearch");
        h.mEJ.h(12767, new Object[]{Integer.valueOf(1)});
        IPCallContactUI.a(this.kuK).setVisibility(0);
        IPCallContactUI.b(this.kuK).setVisibility(8);
        IPCallContactUI.c(this.kuK).setVisibility(8);
        this.kuK.fZ(false);
    }

    public final void WW() {
        x.d("MicroMsg.IPCallContactUI", "onQuitSearch");
        this.kuK.pi("");
        this.kuK.fZ(true);
        IPCallContactUI.a(this.kuK).setVisibility(8);
        IPCallContactUI.b(this.kuK).setVisibility(0);
        IPCallContactUI.c(this.kuK).setVisibility(0);
    }

    public final void pk(String str) {
        x.d("MicroMsg.IPCallContactUI", "onSearchChange");
        this.kuK.pi(str);
        if (!bi.oW(str)) {
            IPCallContactUI.a(this.kuK).setVisibility(8);
            IPCallContactUI.b(this.kuK).setVisibility(0);
            IPCallContactUI.c(this.kuK).setVisibility(8);
        }
    }

    public final boolean pj(String str) {
        x.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
        return false;
    }

    public final void WY() {
        IPCallContactUI.a(this.kuK).setVisibility(0);
        IPCallContactUI.b(this.kuK).setVisibility(8);
        IPCallContactUI.c(this.kuK).setVisibility(8);
    }

    public final void WZ() {
    }
}
