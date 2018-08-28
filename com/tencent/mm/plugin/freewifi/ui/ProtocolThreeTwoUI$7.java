package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class ProtocolThreeTwoUI$7 implements a {
    final /* synthetic */ ProtocolThreeTwoUI joB;
    private int joa = -999999999;

    ProtocolThreeTwoUI$7(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.joB = protocolThreeTwoUI;
    }

    public final void a(String str, l lVar) {
        ProtocolThreeTwoUI.a(this.joB, this.joB.aPq());
        if (this.joa != ProtocolThreeTwoUI.a(this.joB)) {
            this.joa = ProtocolThreeTwoUI.a(this.joB);
            this.joB.qb(ProtocolThreeTwoUI.a(this.joB));
        }
    }
}
