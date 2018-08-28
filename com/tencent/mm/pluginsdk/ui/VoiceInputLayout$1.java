package com.tencent.mm.pluginsdk.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputLayout$1 extends ag {
    final /* synthetic */ VoiceInputLayout qHD;

    VoiceInputLayout$1(VoiceInputLayout voiceInputLayout) {
        this.qHD = voiceInputLayout;
    }

    public final void handleMessage(Message message) {
        if (message.what != 0) {
            if (message.what == 1) {
                x.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[]{Integer.valueOf(this.qHD.qHc)});
            } else {
                return;
            }
        }
        x.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[]{Integer.valueOf(this.qHD.qHc)});
        if (this.qHD.qHc == 3) {
            VoiceInputLayout.a(this.qHD).removeMessages(0);
            VoiceInputLayout.a(this.qHD).removeMessages(1);
            if (VoiceInputLayout.b(this.qHD) != null) {
                VoiceInputLayout.b(this.qHD).an(true);
            }
            this.qHD.reset(true);
        }
    }
}
