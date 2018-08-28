package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.ui.a.a;

class VoiceCreateUI$7 implements a {
    final /* synthetic */ VoiceCreateUI oGi;

    VoiceCreateUI$7(VoiceCreateUI voiceCreateUI) {
        this.oGi = voiceCreateUI;
    }

    public final void bJd() {
        this.oGi.oFI.reset();
        this.oGi.oFI.bJn();
        this.oGi.oFI.bJo();
        this.oGi.oFF.setVisibility(4);
        this.oGi.oFI.setTitleText(R.l.voice_print_reg_step_tip);
        VoiceCreateUI.c(this.oGi).setVisibility(0);
        this.oGi.oFI.bJm();
    }

    public final void bJe() {
    }
}
