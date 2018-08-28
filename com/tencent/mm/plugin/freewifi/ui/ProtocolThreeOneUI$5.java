package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class ProtocolThreeOneUI$5 implements a {
    private int joa = -999999999;
    final /* synthetic */ ProtocolThreeOneUI jov;

    ProtocolThreeOneUI$5(ProtocolThreeOneUI protocolThreeOneUI) {
        this.jov = protocolThreeOneUI;
    }

    public final void a(String str, l lVar) {
        ProtocolThreeOneUI.a(this.jov, this.jov.aPq());
        if (this.joa != ProtocolThreeOneUI.a(this.jov)) {
            this.joa = ProtocolThreeOneUI.a(this.jov);
            this.jov.qb(ProtocolThreeOneUI.a(this.jov));
        }
    }
}
