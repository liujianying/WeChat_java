package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class VoiceTransTextUI$4 implements a {
    final /* synthetic */ int oqo;
    final /* synthetic */ VoiceTransTextUI ouz;

    VoiceTransTextUI$4(VoiceTransTextUI voiceTransTextUI, int i) {
        this.ouz = voiceTransTextUI;
        this.oqo = i;
    }

    public final boolean vD() {
        if (!VoiceTransTextUI.m(this.ouz)) {
            x.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", new Object[]{Integer.valueOf(this.oqo)});
            VoiceTransTextUI.c(this.ouz, VoiceTransTextUI.a.ouI);
        }
        return false;
    }
}
