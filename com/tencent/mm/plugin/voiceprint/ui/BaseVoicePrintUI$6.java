package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.R;

class BaseVoicePrintUI$6 implements Runnable {
    final /* synthetic */ BaseVoicePrintUI oFR;

    BaseVoicePrintUI$6(BaseVoicePrintUI baseVoicePrintUI) {
        this.oFR = baseVoicePrintUI;
    }

    public final void run() {
        BaseVoicePrintUI.c(this.oFR).setErr(R.l.voice_record_permission_denied);
        BaseVoicePrintUI.c(this.oFR).bJp();
        BaseVoicePrintUI.f(this.oFR).setPressed(false);
        BaseVoicePrintUI.f(this.oFR).setEnabled(false);
        BaseVoicePrintUI.g(this.oFR).stop();
    }
}
