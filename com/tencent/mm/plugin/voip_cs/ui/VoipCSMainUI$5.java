package com.tencent.mm.plugin.voip_cs.ui;

import android.telephony.PhoneStateListener;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.x;

class VoipCSMainUI$5 extends PhoneStateListener {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$5(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final void onCallStateChanged(int i, String str) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
        if (i == 2) {
            x.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
            b.bMx().oWM = 4;
            this.oYm.yZ(7);
        }
    }
}
