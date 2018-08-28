package com.tencent.mm.plugin.voip_cs.ui;

import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

class VoipCSMainUI$2 implements a {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$2(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final void ew(int i) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "onBluetoothHeadsetStateChange status: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                VoipCSMainUI.c(this.oYm).ja(false);
                return;
            case 2:
                au.HV().yC();
                VoipCSMainUI.c(this.oYm).ja(true);
                return;
            case 3:
                au.HV().yB();
                return;
            case 4:
                au.HV().yC();
                VoipCSMainUI.c(this.oYm).ja(true);
                return;
            default:
                return;
        }
    }
}
