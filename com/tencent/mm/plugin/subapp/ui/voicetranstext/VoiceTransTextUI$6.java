package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class VoiceTransTextUI$6 extends ag {
    final /* synthetic */ VoiceTransTextUI ouz;

    VoiceTransTextUI$6(VoiceTransTextUI voiceTransTextUI) {
        this.ouz = voiceTransTextUI;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            VoiceTransTextUI.b(this.ouz, true);
        } else if (i == 2) {
            VoiceTransTextUI.b(this.ouz, false);
        }
    }
}
