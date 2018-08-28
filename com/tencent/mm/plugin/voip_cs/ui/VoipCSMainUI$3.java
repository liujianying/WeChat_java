package com.tencent.mm.plugin.voip_cs.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class VoipCSMainUI$3 implements a {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$3(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final void fV(boolean z) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "onHeadsetState, on:%b", new Object[]{Boolean.valueOf(z)});
        if (VoipCSMainUI.d(this.oYm) == z) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "same status, no changed");
            return;
        }
        VoipCSMainUI.a(this.oYm, z);
        if (z) {
            VoipCSMainUI.c(this.oYm).ja(false);
            Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.voip_voice_come_from_earpiece), 0).show();
            return;
        }
        VoipCSMainUI.c(this.oYm).ja(true);
        Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.voip_voice_come_from_speaker), 0).show();
    }
}
