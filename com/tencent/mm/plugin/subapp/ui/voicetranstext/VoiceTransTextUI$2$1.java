package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.2;
import com.tencent.mm.ui.base.h.c;

class VoiceTransTextUI$2$1 implements c {
    final /* synthetic */ 2 ouA;

    VoiceTransTextUI$2$1(2 2) {
        this.ouA = 2;
    }

    public final void ju(int i) {
        if (i == 0 && VoiceTransTextUI.a(this.ouA.ouz) != null && VoiceTransTextUI.b(this.ouA.ouz) != null) {
            VoiceTransTextUI.a(this.ouA.ouz).setText(VoiceTransTextUI.b(this.ouA.ouz).getText());
        }
    }
}
