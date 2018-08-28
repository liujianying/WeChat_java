package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.platformtools.x;

class VoiceCreateUI$4 implements NoiseDetectMaskView$a {
    final /* synthetic */ VoiceCreateUI oGi;

    VoiceCreateUI$4(VoiceCreateUI voiceCreateUI) {
        this.oGi = voiceCreateUI;
    }

    public final void bJf() {
        VoiceCreateUI.e(this.oGi);
        o f = VoiceCreateUI.f(this.oGi);
        x.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
        f.oFs.we();
        f.oFt.SO();
        this.oGi.finish();
    }
}
