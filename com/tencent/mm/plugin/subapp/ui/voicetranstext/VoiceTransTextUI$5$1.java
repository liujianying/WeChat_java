package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.5;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.a;
import com.tencent.mm.sdk.platformtools.x;

class VoiceTransTextUI$5$1 implements Runnable {
    final /* synthetic */ 5 ouB;

    VoiceTransTextUI$5$1(5 5) {
        this.ouB = 5;
    }

    public final void run() {
        x.i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
        if (VoiceTransTextUI.q(this.ouB.ouz) != null) {
            VoiceTransTextUI.q(this.ouB.ouz).SO();
        }
        VoiceTransTextUI.c(this.ouB.ouz, a.ouI);
    }
}
