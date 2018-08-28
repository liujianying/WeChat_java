package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.pluginsdk.ui.VoiceInputFooter.a;

class VoiceInputUI$4 implements a {
    final /* synthetic */ VoiceInputUI qHV;

    VoiceInputUI$4(VoiceInputUI voiceInputUI) {
        this.qHV = voiceInputUI;
    }

    public final void kF(boolean z) {
        if (z) {
            VoiceInputUI.e(this.qHV).setVisibility(4);
        } else {
            VoiceInputUI.e(this.qHV).setVisibility(0);
        }
    }

    public final void cdA() {
        this.qHV.BW(8);
    }
}
