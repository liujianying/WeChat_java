package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;

class VoiceCreateUI$5 implements OnClickListener {
    final /* synthetic */ VoiceCreateUI oGi;

    VoiceCreateUI$5(VoiceCreateUI voiceCreateUI) {
        this.oGi = voiceCreateUI;
    }

    public final void onClick(View view) {
        VoiceCreateUI.e(this.oGi);
        this.oGi.finish();
    }
}
